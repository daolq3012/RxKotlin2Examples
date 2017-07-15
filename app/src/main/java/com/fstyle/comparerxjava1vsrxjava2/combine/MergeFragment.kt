package com.fstyle.comparerxjava1vsrxjava2.combine

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment

/**
 * Created by Sun on 7/15/2017.
 */
class MergeFragment : BaseFragment() {

  override fun doSomething() {
    val observable1 = getObservable()
    val observable2 = getObservableSecond()
    val mergeObservable = observable1.mergeWith(observable2)
    subscribe(mergeObservable)
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): MergeFragment {
      val fragment = MergeFragment()
      return fragment
    }
  }
}
