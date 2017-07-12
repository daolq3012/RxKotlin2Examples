package com.fstyle.comparerxjava1vsrxjava2

import android.app.Application
import android.support.v7.app.AppCompatDelegate.setCompatVectorFromResourcesEnabled

/**
 * Created by DaoLQ on 12/07/2017.
 * FStyle Ltd
 * daole.2511@gmail.com
 */
class Application : Application() {
  override fun onCreate() {
    super.onCreate()
    setCompatVectorFromResourcesEnabled(true)
  }
}
