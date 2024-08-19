package pl.droidsonroids.classifier

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun App() {
  MaterialTheme {
    Column(
      modifier = Modifier.padding(16.dp)
    ) {
      var text by rememberSaveable { mutableStateOf("") } // 1
      TextField(
        modifier = Modifier.fillMaxWidth(),
        maxLines = 10,
        label = { Text(text = "Text to classify") },
        value = text, //2
        onValueChange = { text = it }, // 3
      )
      if (text.isNotBlank()) { // 4
        Text("Category: ${classify(text)}") // 5
      }
    }
  }
}
