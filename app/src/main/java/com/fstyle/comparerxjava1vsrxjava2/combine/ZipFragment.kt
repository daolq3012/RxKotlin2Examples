package com.fstyle.comparerxjava1vsrxjava2.combine

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import io.reactivex.functions.BiFunction

/**
 * Created by Sun on 7/15/2017.
 */
class ZipFragment : BaseFragment() {

  override fun doSomething() {
    val observable1 = getObservable()
    val observable2 = getObservableSecond()
    val zipObservable = observable1.zipWith(observable2,
        BiFunction<String, String, String>() { s1: String?, s2: String? -> "$s1-$s2" })
    subscribe(zipObservable)
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): ZipFragment {
      val fragment = ZipFragment()
      return fragment
    }
  }
}
