package com.example.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
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
				startDestination = "dynamic/{$ARG_ID}", // NOT "dynamic/1", provide arguments via defaultValue
			) {
				composable(
					route = "dynamic/{$ARG_ID}",
					arguments = listOf(navArgument(ARG_ID) { type = NavType.StringType; defaultValue = "1" }),
				) {
					val id = it.arguments?.getString(ARG_ID)
					Text("dynamic route, received argument: $id!")
				}
			}
		}
	}

	companion object
	{
		const val ARG_ID = "id"
	}
}
