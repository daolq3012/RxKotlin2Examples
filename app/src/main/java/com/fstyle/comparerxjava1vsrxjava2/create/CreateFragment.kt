package com.fstyle.comparerxjava1vsrxjava2.create

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import com.fstyle.comparerxjava1vsrxjava2.R.string.first
import com.fstyle.comparerxjava1vsrxjava2.filter.LastFragment
import io.reactivex.*
import io.reactivex.functions.Predicate

/**
 * Created by Sun on 7/15/2017.
 */
class CreateFragment : BaseFragment() {

  override fun doSomething() {
    val create = Observable.create({ emitter: ObservableEmitter<String> ->
      emitter.onNext("one")
      emitter.onNext("two")
      emitter.onComplete()
    })
    subscribe(create)
    val singleCreate = Single.create(
        SingleOnSubscribe<String> { emitter -> emitter.onSuccess("one") })
    val maybeCreate = Maybe.create({ emitter: MaybeEmitter<String>? -> emitter?.onSuccess("one") })
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): CreateFragment {
      val fragment = CreateFragment()
      return fragment
    }
  }
}
