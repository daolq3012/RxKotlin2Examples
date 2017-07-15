package com.fstyle.comparerxjava1vsrxjava2.filter

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Sun on 7/15/2017.
 */
class DistinctFragment : BaseFragment() {

  override fun doSomething() {
    val distinctObservable = getObservableDistinct()
        .distinct()
        // Run on a background thread
        .subscribeOn(Schedulers.io())
        // Be notified on the main thread
        .observeOn(AndroidSchedulers.mainThread())

    subscribe(distinctObservable)
  }

  private fun getObservableDistinct(): Observable<String> {
    return Observable.just("One", "Two", "Two", "One", "Five", "Two", "Four", "Three")
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): DistinctFragment {
      val fragment = DistinctFragment()
      return fragment
    }
  }
}