package com.example.vkedu1.domain

class GetAppsUseCase(
    private val repository: AppsRepository,
) {
    suspend operator fun invoke(): List<AppInfo> = repository.getApps()
}
