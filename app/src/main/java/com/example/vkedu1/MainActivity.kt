package com.example.vkedu1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.vkedu1.presentation.navigation.AppNavGraph
import com.example.vkedu1.ui.theme.VkEdu1Theme
import dagger.hilt.android.AndroidEntryPoint

/** @AndroidEntryPoint: Hilt умеет выдавать зависимости в эту Activity и в hiltViewModel() внутри неё. */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkEdu1Theme {
                AppNavGraph()
            }
        }
    }
}
