package com.fstyle.comparerxjava1vsrxjava2.transform

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.fstyle.comparerxjava1vsrxjava2.R
import com.fstyle.comparerxjava1vsrxjava2.filter.*
import kotlinx.android.synthetic.main.activity_filtering.*

class FilteringActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_filtering)
    btnDebounce.setOnClickListener { replaceFragment(DeBounceFragment.newInstance()) }
    btnDistinct.setOnClickListener { replaceFragment(DistinctFragment.newInstance()) }
    btnElementAt.setOnClickListener { replaceFragment(ElementAtFragment.newInstance()) }
    btnFilter.setOnClickListener { replaceFragment(FilterFragment.newInstance()) }
    btnFirst.setOnClickListener { replaceFragment(FirstFragment.newInstance()) }
    btnIgnoreElements.setOnClickListener { replaceFragment(IgnoreElementsFragment.newInstance()) }
    btnLast.setOnClickListener { replaceFragment(LastFragment.newInstance()) }
    btnSkip.setOnClickListener { replaceFragment(SkipFragment.newInstance()) }
    btnSkipLast.setOnClickListener { replaceFragment(SkipLastFragment.newInstance()) }
    btnTake.setOnClickListener { replaceFragment(TakeFragment.newInstance()) }
    btnTakeLast.setOnClickListener { replaceFragment(TakeLastFragment.newInstance()) }
  }

  fun replaceFragment(fragment: Fragment) {
    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction().addToBackStack(
        null).replace(R.id.layout_container, fragment, fragment.javaClass.name)
    transaction.commit()
  }
}
