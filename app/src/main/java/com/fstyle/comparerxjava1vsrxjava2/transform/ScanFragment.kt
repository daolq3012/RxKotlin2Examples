package com.fstyle.comparerxjava1vsrxjava2.transform

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import io.reactivex.Observable

/**
 * Created by Sun on 7/13/2017.
 */
class ScanFragment : BaseFragment() {

  override fun doSomething() {
    val observable = getObservable()
    val map = observable.scan() { s1, s2 ->
      s1 + "-" + s2
    }
    // so the it gives the following list
    // 1 - one
    // 2 - one-two
    // 3 - one-two-three
    // 4 - one-two-three-four
    // 5 - one-two-three-four-five
    compositeDispose.add(subscribe(map))
  }

  companion object {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): ScanFragment {
      val fragment = ScanFragment()
      return fragment
    }
  }
}
