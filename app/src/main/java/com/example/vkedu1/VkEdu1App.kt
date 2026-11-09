package com.example.vkedu1

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Точка входа Hilt: эта аннотация запускает генерацию DI-кода
 * и создаёт главный контейнер зависимостей на всё приложение.
 * Класс прописан в AndroidManifest.xml (android:name=".VkEdu1App").
 */
@HiltAndroidApp
class VkEdu1App : Application()
