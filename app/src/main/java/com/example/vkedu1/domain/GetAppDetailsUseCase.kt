package com.example.vkedu1.domain

class GetAppDetailsUseCase(
    private val repository: AppsRepository,
) {
    suspend operator fun invoke(id: String): AppDetails? = repository.getAppDetails(id)
}
