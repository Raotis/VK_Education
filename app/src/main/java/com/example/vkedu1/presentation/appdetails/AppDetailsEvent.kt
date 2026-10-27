package com.example.vkedu1.presentation.appdetails

sealed interface AppDetailsEvent {
    data object UnderDevelopment : AppDetailsEvent
}
