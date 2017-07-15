package com.fstyle.comparerxjava1vsrxjava2.create

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import com.fstyle.comparerxjava1vsrxjava2.R.string.create
import com.fstyle.comparerxjava1vsrxjava2.R.string.first
import com.fstyle.comparerxjava1vsrxjava2.filter.LastFragment
import io.reactivex.*
import io.reactivex.functions.Predicate
import java.util.concurrent.Callable

/**
 * Created by Sun on 7/15/2017.
 */
class EmptyNeverThrowFragment : BaseFragment() {

  override fun doSomething() {
    val empty = Observable.empty<String>()
    val never = Observable.never<String>()
    val error = Observable.error<Exception>(Throwable())
    subscribe(empty)
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): EmptyNeverThrowFragment {
      val fragment = EmptyNeverThrowFragment()
      return fragment
    }
  }
}
