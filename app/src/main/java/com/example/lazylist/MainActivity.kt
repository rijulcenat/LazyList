package com.example.lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazylist.ui.theme.LazyListTheme

@Composable
fun GadgetItem(gadget: Gadget, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = gadget.name,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = gadget.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
class MainActivity : ComponentActivity() {
    private val gadgets = listOf(
        Gadget(1, "Smartphone", "Perangkat komunikasi genggam"),
        Gadget(2, "Laptop", "Komputer portabel untuk bekerja"),
        Gadget(3, "Tablet", "Perangkat layar sentuh antara hp dan laptop"),
        Gadget(4, "Smartwatch", "Jam tangan pintar pelacak kesehatan"),
        Gadget(5, "Earbuds", "Perangkat audio nirkabel")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GadgetGrid(
                        gadgets = gadgets,
                        modifier = Modifier.padding(innerPadding)
                    )
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
    LazyListTheme {
        Greeting("Android")
    }
}

@Composable
fun GadgetList(gadgets: List<Gadget>, modifier: Modifier = Modifier) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(gadgets) { gadget ->
            GadgetItem(gadget = gadget)
        }
    }
}

@Composable
fun GadgetRow(gadgets: List<Gadget>, modifier: Modifier = Modifier) {
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(gadgets) { gadget ->

            GadgetItem(
                gadget = gadget,
                modifier = Modifier.width(260.dp)
            )
        }
    }
}

@Composable
fun GadgetGrid(gadgets: List<Gadget>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(gadgets) { gadget ->
            GadgetItem(gadget = gadget)
        }
    }
}