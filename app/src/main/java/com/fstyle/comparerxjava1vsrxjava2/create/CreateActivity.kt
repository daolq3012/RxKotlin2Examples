package com.fstyle.comparerxjava1vsrxjava2.create

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.fstyle.comparerxjava1vsrxjava2.R
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_create)
    btnCreate.setOnClickListener { replaceFragment(CreateFragment.newInstance()) }
    btnDefer.setOnClickListener { replaceFragment(DeferFragment.newInstance()) }
    btnEmptyNeverThrow.setOnClickListener { replaceFragment(EmptyNeverThrowFragment.newInstance()) }
    btnInterval.setOnClickListener { replaceFragment(IntervalFragment.newInstance()) }
    btnTimer.setOnClickListener { replaceFragment(TimerFragment.newInstance()) }
  }

  fun replaceFragment(fragment: Fragment) {
    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction().addToBackStack(
        null).replace(R.id.layout_container, fragment, fragment.javaClass.name)
    transaction.commit()
  }
}
