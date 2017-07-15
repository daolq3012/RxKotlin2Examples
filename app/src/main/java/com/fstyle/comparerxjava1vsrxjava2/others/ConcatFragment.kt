package com.fstyle.comparerxjava1vsrxjava2.others

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import io.reactivex.Observable

/**
 * Created by Sun on 7/15/2017.
 */
class ConcatFragment : BaseFragment() {

  override fun doSomething() {
    val observable1 = getObservable()
    val observable2 = getObservableSecond()
    val ambObservable = Observable.concat(observable1, observable2)
    subscribe(ambObservable)
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): ConcatFragment {
      val fragment = ConcatFragment()
      return fragment
    }
  }
}
