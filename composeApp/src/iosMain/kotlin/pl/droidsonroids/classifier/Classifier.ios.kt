package pl.droidsonroids.classifier

private lateinit var classifier: (String) -> String

@Suppress("unused") // Called from Swift
fun initClassifier(nativeClassifier: (String) -> String) {
  classifier = nativeClassifier
}

internal actual fun classify(text: String) = classifier.invoke(text)
