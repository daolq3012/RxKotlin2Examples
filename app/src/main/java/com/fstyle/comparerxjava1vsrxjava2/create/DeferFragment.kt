package com.fstyle.comparerxjava1vsrxjava2.create

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import com.fstyle.comparerxjava1vsrxjava2.R.string.first
import com.fstyle.comparerxjava1vsrxjava2.filter.LastFragment
import io.reactivex.*
import io.reactivex.functions.Predicate
import java.util.concurrent.Callable

/**
 * Created by Sun on 7/15/2017.
 */
class DeferFragment : BaseFragment() {

  override fun doSomething() {
    val create = Observable.defer({ getObservable() })
    subscribe(create)
    val singleCreate = Single.defer({ Single.just("one") })
    val maybeCreate = Maybe.defer({ Maybe.just("One") })
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): DeferFragment {
      val fragment = DeferFragment()
      return fragment
    }
  }
}
