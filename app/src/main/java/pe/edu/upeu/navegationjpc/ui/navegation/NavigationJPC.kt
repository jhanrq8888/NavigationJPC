package pe.edu.upeu.navegationjpc.ui.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pe.edu.upeu.navegacionjpc.ui.presentation.screens.BarcodeScanningScreen
import pe.edu.upeu.navegationjpc.ui.presentation.screens.CalcScreen

import pe.edu.upeu.navegationjpc.ui.presentation.screens.HomeScreen
import pe.edu.upeu.navegationjpc.ui.presentation.screens.ProfileScreen
import pe.edu.upeu.navegationjpc.ui.presentation.screens.SettingsScreen


@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("profile") { ProfileScreen() }
        composable("settings") { SettingsScreen() }
        composable("barcode") { BarcodeScanningScreen(navController) }
        composable("calc") { CalcScreen() }
    }
}