package com.fstyle.comparerxjava1vsrxjava2.filter

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import com.fstyle.comparerxjava1vsrxjava2.R.string.first
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.functions.Predicate

/**
 * Created by Sun on 7/15/2017.
 */
class LastFragment : BaseFragment() {

  override fun doSomething() {
    val observable = getObservable()
    val filterObservable = observable.last("Null").toObservable()
    // return Single emit last item if not show data default (Null)
    subscribe(filterObservable)
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): LastFragment {
      val fragment = LastFragment()
      return fragment
    }
  }
}
