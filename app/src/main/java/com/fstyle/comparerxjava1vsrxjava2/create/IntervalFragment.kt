package com.fstyle.comparerxjava1vsrxjava2.create

import android.util.Log
import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import com.fstyle.comparerxjava1vsrxjava2.R.string.create
import com.fstyle.comparerxjava1vsrxjava2.R.string.first
import com.fstyle.comparerxjava1vsrxjava2.filter.LastFragment
import io.reactivex.*
import io.reactivex.functions.Consumer
import io.reactivex.functions.Predicate
import java.util.concurrent.Callable
import java.util.concurrent.TimeUnit

/**
 * Created by Sun on 7/15/2017.
 */
class IntervalFragment : BaseFragment() {

  val TAG = "IntervalFragment"

  override fun doSomething() {
    compositeDispose.add(Observable.interval(1, TimeUnit.SECONDS).take(10).subscribe(
        { t -> Log.d(TAG, "$t") }, { e -> Log.e(TAG, "", e) }))
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): IntervalFragment {
      val fragment = IntervalFragment()
      return fragment
    }
  }
}
