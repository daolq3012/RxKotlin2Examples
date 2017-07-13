#!/usr/bin/env bash

echo "********************"
echo "* install gems     *"
echo "********************"
gem install --no-document checkstyle_filter-git saddler saddler-reporter-github findbugs_translate_checkstyle_format android_lint_translate_checkstyle_format pmd_translate_checkstyle_format
gem install chatwork

if [ $? -ne 0 ]; then
    echo 'Failed to install gems.'
    exit 1
fi
