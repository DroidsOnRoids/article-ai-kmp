package pl.droidsonroids.classifier

import android.content.Context
import com.google.mediapipe.tasks.core.BaseOptions
import com.google.mediapipe.tasks.text.textclassifier.TextClassifier
import com.google.mediapipe.tasks.text.textclassifier.TextClassifier.TextClassifierOptions

private lateinit var textClassifier: TextClassifier

internal fun initClassifier(context: Context) {
  val baseOptions = BaseOptions.builder().setModelAssetPath("mobilebert.tflite").build()
  val options = TextClassifierOptions.builder().setBaseOptions(baseOptions).build()
  textClassifier = TextClassifier.createFromOptions(context, options)
}

internal actual fun classify(text: String): String = textClassifier.classify(text)
  .classificationResult()
  .classifications()
  .first()
  .categories()
  .maxBy { it.score() }
  .categoryName()
