package com.example.vkedu1.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vkedu1.data.sampleApps
import com.example.vkedu1.presentation.appdetails.AppDetailsScreen
import com.example.vkedu1.presentation.applist.AppListScreen

/** Маршруты приложения. */
object Routes {
    const val APPS = "apps"
    const val ARG_APP_ID = "appId"
    const val DETAILS = "details/{$ARG_APP_ID}"

    fun details(appId: String) = "details/$appId"
}

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Routes.APPS,
    ) {
        // Список приложений -> карточка выбранного приложения
        composable(Routes.APPS) {
            AppListScreen(
                apps = sampleApps,
                onAppClick = { app ->
                    navController.navigate(Routes.details(app.id))
                },
            )
        }

        // Карточка приложения
        composable(
            route = Routes.DETAILS,
            arguments = listOf(
                navArgument(Routes.ARG_APP_ID) { type = NavType.StringType },
            ),
        ) {
            AppDetailsScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                // Клик по приложению в «Витрине» -> список приложений
                onShowcaseAppClick = {
                    navController.navigate(Routes.APPS) {
                        popUpTo(Routes.APPS) { inclusive = true }
                    }
                },
            )
        }
    }
}
