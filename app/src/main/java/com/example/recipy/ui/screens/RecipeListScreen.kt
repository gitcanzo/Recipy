package com.example.recipy.ui.screens

import androidx.compose.material.Text

@Composable
fun RecipeListScreen(
    viewModel: RecipeListViewModel = viewModel(factory = MyFactory),
    onEdit: (Long?) -> Unit,
    onShopping: () -> Unit
) {
    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = viewModel.query,
            onValueChange = { viewModel.query = it },
            label = { Text("Search") }
        )
        Spacer(Modifier.height(8.dp))
        LazyColumn {
            items(viewModel.recipes.value) { ri ->
                Card(Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable { onEdit(ri.recipe.id) }
                ) {
                    Column(Modifier.padding(8.dp)) {
                        Text(ri.recipe.title, style = MaterialTheme.typography.h6)
                        Text("Prep: ${ri.recipe.prepTime} min")
                    }
                }
            }
        }
        FloatingActionButton(onClick = { onEdit(null) },
            Modifier.align(Alignment.End).padding(16.dp)
        ) { Icon(Icons.Default.Add, contentDescription = "Add") }
        Spacer(Modifier.height(16.dp))
        Button(onClick = onShopping) { Text("Shopping List") }
    }
}