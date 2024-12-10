package com.example.myapplicationnote

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    val viewModel = NoteViewModel()
    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") {
            MainScreen(navController, viewModel)
        }
        composable("newNote") {
            NewNote(navController, viewModel)
        }
        composable("editNote/{noteId}") { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId")?.toIntOrNull()
            if (noteId != null) {
                EditNote(navController, noteId, viewModel)
            }
        }
    }
}
