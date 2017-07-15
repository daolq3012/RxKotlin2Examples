package com.fstyle.comparerxjava1vsrxjava2.filter

import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by Sun on 7/15/2017.
 */
class DeBounceFragment : BaseFragment() {

  override fun doSomething() {
    val deBounceObservable = getObservableDeBounce()
        .debounce(500, TimeUnit.MILLISECONDS)
        // Run on a background thread
        .subscribeOn(Schedulers.io())
        // Be notified on the main thread
        .observeOn(AndroidSchedulers.mainThread())

    subscribe(deBounceObservable)
  }

  private fun getObservableDeBounce(): Observable<String> {
    return Observable.create { emitter ->
      // send events with simulated time wait
      emitter.onNext("one") // skip
      Thread.sleep(400)
      emitter.onNext("two") // deliver
      Thread.sleep(501)
      emitter.onNext("three") // skip
      Thread.sleep(100)
      emitter.onNext("four") // deliver
      Thread.sleep(600)
      emitter.onNext("five") // deliver
      emitter.onComplete()
    }
  }

  companion object {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * *
     * @return A new instance of fragment BufferFragment.
     */
    fun newInstance(): DeBounceFragment {
      val fragment = DeBounceFragment()
      return fragment
    }
  }
}