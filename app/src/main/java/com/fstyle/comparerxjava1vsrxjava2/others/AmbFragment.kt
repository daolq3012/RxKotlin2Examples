package com.fstyle.comparerxjava1vsrxjava2.others

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import io.reactivex.Observable

/**
 * Created by Sun on 7/15/2017.
 */
class AmbFragment : BaseFragment() {

  override fun doSomething() {
    val observable = getObservable()
    val ambObservable = observable.ambWith(observable)
    subscribe(ambObservable)
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): AmbFragment {
      val fragment = AmbFragment()
      return fragment
    }
  }
}
