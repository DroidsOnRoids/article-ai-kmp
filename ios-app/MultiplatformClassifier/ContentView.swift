import UIKit
import SwiftUI
import composeApp
import MediaPipeTasksText

struct ComposeView: UIViewControllerRepresentable {
       
    init() {
        let modelPath = Bundle.main.path(forResource: "mobilebert", ofType: "tflite")
        
        let options = TextClassifierOptions()
        options.baseOptions.modelAssetPath = modelPath!
        let textClassifier = try? TextClassifier(options: options)
  
        Classifier_iosKt.doInitClassifier { (text: String) -> String in
            (try? textClassifier?.classify(text: text).classificationResult.classifications.first?.categories.max {
                $0.score < $1.score
            }?.categoryName) ?? "unknown"
        }
    }
    
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView()
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}
