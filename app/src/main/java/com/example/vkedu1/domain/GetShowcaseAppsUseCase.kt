package com.example.vkedu1.domain

class GetShowcaseAppsUseCase(
    private val repository: AppsRepository,
) {
    suspend operator fun invoke(): List<AppInfo> = repository.getShowcaseApps()
}
