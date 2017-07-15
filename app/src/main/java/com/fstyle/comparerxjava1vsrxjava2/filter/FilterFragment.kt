package com.fstyle.comparerxjava1vsrxjava2.filter

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import io.reactivex.functions.Predicate

/**
 * Created by Sun on 7/15/2017.
 */
class FilterFragment : BaseFragment() {

  override fun doSomething() {
    val observable = getObservable()
    val filterObservable = observable.filter({ s -> s.contains("O", true) })
    // Explore element have values contains O character
    subscribe(filterObservable)
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): FilterFragment {
      val fragment = FilterFragment()
      return fragment
    }
  }
}
