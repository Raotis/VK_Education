package com.example.vkedu1

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkedu1.ui.theme.VkEdu1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkEdu1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var text by rememberSaveable { mutableStateOf("") }
    var error by rememberSaveable { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                error = null
            },
            label = { Text("Текст или номер телефона") },
            isError = error != null,
            supportingText = { error?.let { Text(it) } },
            modifier = Modifier.fillMaxWidth()
        )

        // 1. Явный Intent
        Button(
            onClick = {
                val input = text.trim()
                if (input.isEmpty()) {
                    error = "Введите текст"
                } else {
                    val intent = Intent(context, SecondActivity::class.java)
                        .putExtra(SecondActivity.EXTRA_TEXT, input)
                    context.startActivity(intent)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Открыть вторую Activity") }

        // 2. Неявный Intent (ACTION_DIAL)
        Button(
            onClick = {
                val phone = normalizePhone(text)
                if (phone == null) {
                    error = "Введите корректный номер, например +7 925 123-45-67"
                } else {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
                    context.startActivitySafely(intent)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Позвонить другу") }

        // 3. Системный Intent (ACTION_SEND)
        Button(
            onClick = {
                val input = text.trim()
                if (input.isEmpty()) {
                    error = "Введите текст, которым хотите поделиться"
                } else {
                    val sendIntent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, input)
                    }
                    context.startActivitySafely(
                        Intent.createChooser(sendIntent, "Поделиться через…")
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Поделиться текстом") }
    }
}

/** Возвращает номер вида "+79251234567" / "89251234567" или null, если ввод некорректен. */
private fun normalizePhone(raw: String): String? {
    val trimmed = raw.trim()
    // разрешены только цифры, пробелы, дефисы, скобки и ведущий "+"
    if (!Regex("""^\+?[\d\s\-()]+$""").matches(trimmed)) return null
    val digits = trimmed.filter { it.isDigit() }
    if (digits.length !in 5..15) return null
    return if (trimmed.startsWith("+")) "+$digits" else digits
}

/** Запускает Intent и не падает, если подходящего приложения нет. */
private fun Context.startActivitySafely(intent: Intent) {
    try {
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(this, "Не найдено приложение для этого действия", Toast.LENGTH_SHORT).show()
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    VkEdu1Theme {
        MainScreen()
    }
}