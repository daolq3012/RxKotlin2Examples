package com.fstyle.comparerxjava1vsrxjava2.transform

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment

/**
 * Buffer Operator
 */
class BufferFragment : BaseFragment() {

  override fun doSomething() {
    val observable = getObservable()
    val buffer = observable.buffer(3, 1)
    // 3 means,  it takes max of three from its start index and create list
    // 1 means, it jumps one step every time
    // so the it gives the following list
    // 1 - one, two, three
    // 2 - two, three, four
    // 3 - three, four, five
    // 4 - four, five
    // 5 - five
    subscribeList(buffer)
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): BufferFragment {
      val fragment = BufferFragment()
      return fragment
    }
  }
}
