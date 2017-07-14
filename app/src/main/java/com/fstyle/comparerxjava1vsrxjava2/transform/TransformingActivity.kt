package com.fstyle.comparerxjava1vsrxjava2.transform

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.fstyle.comparerxjava1vsrxjava2.R
import kotlinx.android.synthetic.main.activity_transforming.*

class TransformingActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_transforming)
    btnBuffer.setOnClickListener { replaceFragment(BufferFragment.newInstance()) }
    btnFlatMap.setOnClickListener { replaceFragment(FlatmapFragment.newInstance()) }
  }

  fun replaceFragment(fragment: Fragment) {
    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction().addToBackStack(
        null).replace(R.id.layout_container, fragment, fragment.javaClass.name)
    transaction.commit()
  }
}
