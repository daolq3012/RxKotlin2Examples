package com.fstyle.comparerxjava1vsrxjava2.transform

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import io.reactivex.Observable

/**
 * Created by Sun on 7/13/2017.
 */
class MapFragment : BaseFragment() {

  override fun doSomething() {
    val observable = getObservable()
    val map = observable.map { string ->
      string + "-test"
    }
    compositeDispose.add(subscribe(map))
  }

  companion object {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): MapFragment {
      val fragment = MapFragment()
      return fragment
    }
  }
}
