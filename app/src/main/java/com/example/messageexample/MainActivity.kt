package com.example.messageexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.messageexample.ui.theme.MessageExampleTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageExampleTheme {
                MessageScreen()
            }
        }
    }
}

@Composable
fun MessageScreen() {
    var showMessage by remember { mutableStateOf(false) }
    // ボタンがタップされたらメッセージを表示
    Button(onClick = {
        showMessage = true
    }) {
        Text("記録")
    }
    Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
    // メッセージが表示されたら、2秒後に非表示にする
    if (showMessage) {
        Text("記録しました。")
        // LaunchedEffectを使って非同期処理を行う
        LaunchedEffect(Unit) {
            delay(2000) // 2秒待機
            showMessage = false // 2秒後にメッセージを非表示
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MessageExampleTheme {
        MessageScreen()
    }
}