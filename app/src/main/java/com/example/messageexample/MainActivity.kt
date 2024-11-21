package com.example.messageexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    // Columnを使ってボタンの位置を固定
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 200.dp), // ボタンを画面中央近くに固定する
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // ボタン
        Button(onClick = {
            showMessage = true
        }) {
            Text("記録")
        }
        // ボタンの真下にテキストを表示
        if (showMessage) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("記録しました。")
            // メッセージが2秒後に非表示になる
            LaunchedEffect(Unit) {
                delay(2000) // 2秒待機
                showMessage = false // 2秒後にメッセージを非表示
            }
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
