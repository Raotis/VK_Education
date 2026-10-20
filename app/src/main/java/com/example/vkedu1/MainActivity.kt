package com.example.vkedu1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.vkedu1.data.sampleApps
import com.example.vkedu1.presentation.applist.AppListScreen
import com.example.vkedu1.ui.theme.VkEdu1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkEdu1Theme {
                AppListScreen(apps = sampleApps)
            }
        }
    }
}
