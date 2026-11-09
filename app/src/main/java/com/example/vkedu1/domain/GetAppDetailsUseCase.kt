package com.example.vkedu1.domain

import javax.inject.Inject

class GetAppDetailsUseCase @Inject constructor(
    private val repository: AppsRepository,
) {
    suspend operator fun invoke(id: String): AppDetails? = repository.getAppDetails(id)
}
