package com.fstyle.comparerxjava1vsrxjava2.combine

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.fstyle.comparerxjava1vsrxjava2.R
import com.fstyle.comparerxjava1vsrxjava2.filter.*
import kotlinx.android.synthetic.main.activity_combining.*

class CombiningActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_combining)
    btnCombineLatest.setOnClickListener { replaceFragment(CombineLatestFragment.newInstance()) }
    btnJoin.setOnClickListener { replaceFragment(JoinFragment.newInstance()) }
    btnMerge.setOnClickListener { replaceFragment(MergeFragment.newInstance()) }
    btnStartWith.setOnClickListener { replaceFragment(StartWithFragment.newInstance()) }
    btnSwitch.setOnClickListener { replaceFragment(SwitchFragment.newInstance()) }
    btnZip.setOnClickListener { replaceFragment(ZipFragment.newInstance()) }
  }

  fun replaceFragment(fragment: Fragment) {
    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction().addToBackStack(
        null).replace(R.id.layout_container, fragment, fragment.javaClass.name)
    transaction.commit()
  }
}
