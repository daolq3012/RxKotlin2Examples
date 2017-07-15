package com.fstyle.comparerxjava1vsrxjava2.transform

import android.util.Log
import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import io.reactivex.Observable
import io.reactivex.functions.Consumer

/**
 * Created by Sun on 7/13/2017.
 */
class WindowFragment : BaseFragment() {

  override fun doSomething() {
    val observable = getObservable()
    compositeDispose.add(observable.window(2)
        .subscribe({ t -> compositeDispose.add(subscribe(t)) },
            { e -> Log.e("WindowFragment", e.message) }))
    //'2' is a step count
    // so the it gives the following list
    // 1 - Observable.just("one", "two")
    // 2 - Observable.just("three", "four")
    // 3 - Observable.just("five")
  }

  companion object {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): WindowFragment {
      val fragment = WindowFragment()
      return fragment
    }
  }
}
