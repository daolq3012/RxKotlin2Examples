package com.fstyle.comparerxjava1vsrxjava2.filter

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment

/**
 * Created by Sun on 7/15/2017.
 */
class ElementAtFragment : BaseFragment() {

  override fun doSomething() {
    val observable = getObservable()
    val elementAtObservable = observable.elementAt(3).toObservable()
    // Return Maybe<T>  Explore element at position 3 if OutOfRange don't call onSuccess
    subscribe(elementAtObservable)
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): ElementAtFragment {
      val fragment = ElementAtFragment()
      return fragment
    }
  }
}
