package pl.droidsonroids.classifier

import android.content.Context
import androidx.startup.Initializer

class ClassifierInitializer : Initializer<Unit> {

  override fun create(context: Context) {
    initClassifier(context)
  }

  override fun dependencies() = emptyList<Class<out Initializer<*>>>()
}
