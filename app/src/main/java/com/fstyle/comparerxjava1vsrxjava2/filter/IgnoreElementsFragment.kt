package com.fstyle.comparerxjava1vsrxjava2.filter

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import io.reactivex.functions.Predicate

/**
 * Created by Sun on 7/15/2017.
 */
class IgnoreElementsFragment : BaseFragment() {

  override fun doSomething() {
    val observable = getObservable()
    val ignoreElementsObservable = observable.ignoreElements().toObservable<String>()
    // Return Completable do not emit any items from an Observable but mirror its termination notification
    subscribe(ignoreElementsObservable)
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): IgnoreElementsFragment {
      val fragment = IgnoreElementsFragment()
      return fragment
    }
  }
}
