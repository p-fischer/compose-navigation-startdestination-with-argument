package com.example.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)

		setContent {
			val navController = rememberNavController()

			NavHost(
				navController = navController,
				startDestination = "dynamic/1", // doesn't work
				// startDestination = "static", // workaround
			) {
				composable(
					route = "dynamic/{$ARG_ID}",
					arguments = listOf(navArgument(ARG_ID) { type = NavType.StringType }),
				) {
					val id = it.arguments?.getString(ARG_ID)
					Text("dynamic route, received argument: $id!")
				}
				// part of the workaround
				// composable(
				// 	route = "static",
				// ) {
				// 	LaunchedEffect(this) {
				// 		navController.navigate("dynamic/1")
				// 	}
				// }
			}
		}
	}

	companion object
	{
		const val ARG_ID = "id"
	}
}
