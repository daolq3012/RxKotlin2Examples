package com.fstyle.comparerxjava1vsrxjava2.transform

import android.util.Log
import com.fstyle.comparerxjava1vsrxjava2.BaseFragment
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.observables.GroupedObservable
import kotlinx.android.synthetic.main.fragment_content.*

/**
 * Created by Sun on 7/13/2017.
 */
class GroupByFragment : BaseFragment() {

    override fun doSomething() {
        val observable = getObservable()
        observable
                .groupBy { t: String -> if (t.contains("o", false)) "0" else "1" }
                .subscribe({ t -> compositeDispose.add(subscribeGroupBy(t)) },
                        { e -> Log.e("WindowFragment", e.message) })
    }

    fun subscribeGroupBy(observable: Observable<String>): Disposable {
        return observable.subscribe({ string ->
            run {
                textViewDetailWork.append(" onNext : $string - key: ${(observable as GroupedObservable<*, *>).key}")
                textViewDetailWork.append("\n")
            }
        },
                { e -> textViewDetailWork.append(" onError: ${e.message}") },
                {
                    textViewDetailWork.append(" onComplete")
                    textViewDetailWork.append("\n")
                })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * *
         * @return A new instance of fragment BufferFragment.
         */
        fun newInstance(): GroupByFragment {
            val fragment = GroupByFragment()
            return fragment
        }
    }
}
