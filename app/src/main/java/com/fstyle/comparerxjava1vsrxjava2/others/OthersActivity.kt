package com.fstyle.comparerxjava1vsrxjava2.others

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.fstyle.comparerxjava1vsrxjava2.R
import kotlinx.android.synthetic.main.activity_others.*

class OthersActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_others)
    btnRetry.setOnClickListener { replaceFragment(RetryFragment.newInstance()) }
    btnAmb.setOnClickListener { replaceFragment(AmbFragment.newInstance()) }
    btnConcat.setOnClickListener { replaceFragment(ConcatFragment.newInstance()) }
  }

  fun replaceFragment(fragment: Fragment) {
    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction().addToBackStack(
        null).replace(R.id.layout_container, fragment, fragment.javaClass.name)
    transaction.commit()
  }
}
