package com.fstyle.comparerxjava1vsrxjava2.filter

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment

/**
 * Created by Sun on 7/15/2017.
 */
class TakeLastFragment : BaseFragment() {

  override fun doSomething() {
    val observable = getObservable()
    val filterObservable = observable.takeLast(2)
    // emit 2 item count from last
    subscribe(filterObservable)
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): TakeLastFragment {
      val fragment = TakeLastFragment()
      return fragment
    }
  }
}
