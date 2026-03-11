package com.abdulin.studentplanner.navigation

sealed class Screen(val route: String) {
    object Details : Screen("details/{subjectId}") {
        fun createRoute(subjectId: String) = "details/$subjectId"
    }
    object Profile : Screen("profile")
    object Settings : Screen("settings")
}