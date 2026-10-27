package com.example.vkedu1.domain

private const val SIMILAR_APPS_COUNT = 6

/** Бизнес-правило: «похожие» — другие приложения из каталога, не больше шести. */
class GetSimilarAppsUseCase(
    private val repository: AppsRepository,
) {
    suspend operator fun invoke(excludeId: String): List<AppInfo> =
        repository.getApps()
            .filter { it.id != excludeId }
            .take(SIMILAR_APPS_COUNT)
}
