package com.example.recipy.ui.screens

@Composable
fun ShoppingListScreen(
    viewModel: ShoppingListViewModel = viewModel(factory = MyFactory)
) {
    Column(Modifier.padding(16.dp)) {
        Text("Shopping List", style = MaterialTheme.typography.h5)
        LazyColumn {
            items(viewModel.items.value) { item ->
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("${item.name} — ${item.quantity}")
                    IconButton({ viewModel.remove(item) }) {
                        Icon(Icons.Default.Delete, null)
                    }
                }
            }
        }
    }
}