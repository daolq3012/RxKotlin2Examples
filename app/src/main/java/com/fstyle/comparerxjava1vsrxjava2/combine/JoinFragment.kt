package com.fstyle.comparerxjava1vsrxjava2.combine

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function

/**
 * Created by Sun on 7/15/2017.
 */
class JoinFragment : BaseFragment() {

  override fun doSomething() {
    val observable1 = getObservable()
    val observable2 = getObservableSecond()
    val observableJoin = observable1.join(observable2,
        Function<String, ObservableSource<String>> { t -> Observable.just(t) },
        Function<String, ObservableSource<String>> { t -> Observable.just(t) },
        BiFunction<String, String, String> { s1, s2 -> "$s1-$s2" })
    subscribe(observableJoin)
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): JoinFragment {
      val fragment = JoinFragment()
      return fragment
    }
  }
}
