package com.example.recipy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipy.ui.theme.RecipyTheme
import androidx.navigation.compose.*
import androidx.compose.runtime.*
import com.example.recipy.ui.screens.RecipeListScreen // ← match your package name
import com.example.recipy.ui.screens.EditRecipeScreen
import com.example.recipy.ui.screens.ShoppingListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val nav = rememberNavController()
            NavHost(nav, "list") {
                composable("list") {
                    RecipeListScreen(
                        onEdit = { id -> nav.navigate("edit/${id ?: ""}") },
                        onShopping = { nav.navigate("shopping") }
                    )
                }
                composable("edit/{id?}") { back ->
                    EditRecipeScreen(onDone = { nav.popBackStack() })
                }
                composable("shopping") {
                    ShoppingListScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecipyTheme {
        Greeting("Android")
    }
}