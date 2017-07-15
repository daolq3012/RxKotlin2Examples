package com.fstyle.comparerxjava1vsrxjava2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fstyle.comparerxjava1vsrxjava2.transform.FilteringActivity
import com.fstyle.comparerxjava1vsrxjava2.transform.TransformingActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    btnTransform.setOnClickListener {
      startActivity(Intent(this@MainActivity, TransformingActivity::class.java))
    }
    btnFilter.setOnClickListener {
      startActivity(Intent(this@MainActivity, FilteringActivity::class.java))
    }
  }
}
