package com.fstyle.comparerxjava1vsrxjava2.transform

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import io.reactivex.Observable


/**
 * Created by DaoLQ on 13/07/2017.
 * Fstyle Ltd
 * daole.2511@gmail.com
 */
class FlatmapFragment : BaseFragment() {

  override fun doSomething() {
    val observable = getObservable()
    val flatmap = observable.flatMap { string ->
      var output = string
      output += "-test"
      Observable.just(output)
    }
    subscribe(flatmap)
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): FlatmapFragment {
      val fragment = FlatmapFragment()
      return fragment
    }
  }
}
