#!/usr/bin/env bash

echo "********************"
echo "* exec gradle      *"
echo "********************"
./gradlew :app:check -PdisablePreDex

if [ $? -ne 0 ]; then
    echo 'Failed gradle check task.'
    exit 1
fi

echo "********************"
echo "* save outputs     *"
echo "********************"

LINT_RESULT_DIR="$TRAVIS_ARTIFACTS/lint"

sudo mkdir "$LINT_RESULT_DIR"
sudo cp -v "app/build/reports/checkstyle/checkstyle.xml" "$LINT_RESULT_DIR/"
sudo cp -v "app/build/reports/findbugs/findbugs.xml" "$LINT_RESULT_DIR/"
sudo cp -v "app/build/reports/pmd/pmd.xml" "$LINT_RESULT_DIR/"
sudo cp -v "app/build/reports/pmd/cpd.xml" "$LINT_RESULT_DIR/"
sudo cp -v "app/build/reports/lint-results.xml" "$LINT_RESULT_DIR/"

if [ -z "${TRAVIS_PULL_REQUEST}" ]; then
    # when not pull request
    REPORTER=Saddler::Reporter::Github::CommitReviewComment
else
    REPORTER=Saddler::Reporter::Github::PullRequestReviewComment
fi

echo "********************"
echo "* checkstyle       *"
echo "********************"
cat app/build/reports/checkstyle/checkstyle.xml \
    | checkstyle_filter-git diff origin/master \
    | saddler report --require saddler/reporter/github --reporter $REPORTER

echo "********************"
echo "* findbugs         *"
echo "********************"
cat app/build/reports/findbugs/findbugs.xml \
    | findbugs_translate_checkstyle_format translate \
    | checkstyle_filter-git diff origin/master \
    | saddler report --require saddler/reporter/github --reporter $REPORTER

echo "********************"
echo "* PMD              *"
echo "********************"
cat app/build/reports/pmd/pmd.xml \
    | pmd_translate_checkstyle_format translate \
    | checkstyle_filter-git diff origin/master \
    | saddler report --require saddler/reporter/github --reporter $REPORTER

echo "********************"
echo "* PMD-CPD          *"
echo "********************"
cat app/build/reports/pmd/cpd.xml \
    | pmd_translate_checkstyle_format translate --cpd-translate \
    | checkstyle_filter-git diff origin/master \
    | saddler report --require saddler/reporter/github --reporter $REPORTER

echo "********************"
echo "* android lint     *"
echo "********************"
cat app/build/reports/lint-results.xml \
    | android_lint_translate_checkstyle_format translate \
    | checkstyle_filter-git diff origin/master \
    | saddler report --require saddler/reporter/github --reporter $REPORTER
