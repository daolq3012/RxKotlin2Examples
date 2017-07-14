package com.fstyle.comparerxjava1vsrxjava2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_content.*


/**
 * Created by DaoLQ on 13/07/2017.
 * Fstyle Ltd
 * daole.2511@gmail.com
 */
abstract class BaseFragment : Fragment() {

  val compositeDispose: CompositeDisposable = CompositeDisposable()

  abstract fun doSomething()

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater!!.inflate(R.layout.fragment_content, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    btnDoSomeWork.setOnClickListener {
      doSomething()
    }
  }

  override fun onStop() {
    compositeDispose.clear()
    super.onStop()
  }

  fun getObservable(): Observable<String> {
    return Observable.just("one", "two", "three", "four", "five")
  }

  fun subscribe(observable: Observable<String>): Disposable {
    return observable.subscribe({ string ->
      run {
        textViewDetailWork.append(" onNext : $string")
        textViewDetailWork.append("\n")
      }
    },
        { e -> textViewDetailWork.append(" onError: ${e.message}") },
        {
          textViewDetailWork.append(" onComplete")
          textViewDetailWork.append("\n")
        })
  }

  fun subscribeList(observable: Observable<List<String>>): Disposable {
    return observable.subscribe({ strings ->
      run {
        textViewDetailWork.append(" onNext : ${strings.asReversed()}")
        textViewDetailWork.append("\n")
      }
    },
        { e -> textViewDetailWork.append(" onError: ${e.message}") },
        {
          textViewDetailWork.append(" onComplete")
          textViewDetailWork.append("\n")
        })
  }
}
