package com.example.vkedu1.domain

import javax.inject.Inject

class GetAppsUseCase @Inject constructor(
    private val repository: AppsRepository,
) {
    suspend operator fun invoke(): List<AppInfo> = repository.getApps()
}
