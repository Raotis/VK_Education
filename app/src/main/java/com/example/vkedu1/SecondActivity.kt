package com.example.vkedu1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.vkedu1.ui.theme.VkEdu1Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val receivedText = intent.getStringExtra(EXTRA_TEXT)

        setContent {
            VkEdu1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text("Полученный текст:", style = MaterialTheme.typography.titleMedium)
                        Text(
                            text = receivedText ?: "Данные не переданы",
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Button(onClick = { finish() }) { Text("Назад") }
                    }
                }
            }
        }
    }

    companion object {
        const val EXTRA_TEXT = "extra_text"
    }
}