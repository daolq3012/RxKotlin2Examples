package com.fstyle.comparerxjava1vsrxjava2.combine

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment

/**
 * Created by Sun on 7/15/2017.
 */
class StartWithFragment : BaseFragment() {

  override fun doSomething() {
    val observable1 = getObservable()
    val observable2 = getObservableSecond()
    // 1
    var startWithObservable = observable1.startWith(observable2)
    subscribe(startWithObservable)
    // 2
    startWithObservable = observable1.startWith("----First----")
    subscribe(startWithObservable)
    val array: MutableList<String> = arrayListOf("----First----", "Second")
    // 3
    startWithObservable = observable1.startWith(array)
    subscribe(startWithObservable)
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): StartWithFragment {
      val fragment = StartWithFragment()
      return fragment
    }
  }
}
