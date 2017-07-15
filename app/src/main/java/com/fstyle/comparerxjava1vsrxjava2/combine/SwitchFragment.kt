package com.fstyle.comparerxjava1vsrxjava2.combine

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * Created by Sun on 7/15/2017.
 */
class SwitchFragment : BaseFragment() {

  override fun doSomething() {
    val observable1 = getObservable()
    val observable2 = getObservableSecond()
    // TODO dev later
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): SwitchFragment {
      val fragment = SwitchFragment()
      return fragment
    }
  }
}
