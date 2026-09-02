package com.example.exploracioncomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exploracioncomponentes.ui.theme.ExploracionComponentesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExploracionComponentesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ExploracionScreen()
                }
            }
        }
    }
}

@Composable
fun ExploracionScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text("Exploración de Componentes", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Alumno: Jahmpiero Andy", fontSize = 16.sp, color = MaterialTheme.colorScheme.secondary)
            Divider(modifier = Modifier.padding(vertical = 8.dp))
        }

        // 1. Contenedores
        item {
            Text("1. Contenedores", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            // Card + Column + Row
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Ejemplo de Card y LazyRow:", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(5) { index ->
                            Button(onClick = {}) {
                                Text("Item ${index + 1}")
                            }
                        }
                    }
                }
            }
        }

        // 2. Controles de Entrada
        item {
            Text("2. Controles de Entrada", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            var textState by remember { mutableStateOf("") }
            OutlinedTextField(
                value = textState,
                onValueChange = { textState = it },
                label = { Text("OutlinedTextField") },
                modifier = Modifier.fillMaxWidth()
            )

            var checkState by remember { mutableStateOf(true) }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = checkState, onCheckedChange = { checkState = it })
                Text("Checkbox")
            }

            var switchState by remember { mutableStateOf(true) }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Switch(checked = switchState, onCheckedChange = { switchState = it })
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Text("Switch")
            }

            var sliderState by remember { mutableStateOf(0.5f) }
            Column {
                Text("Slider: ${(sliderState * 100).toInt()}%")
                Slider(value = sliderState, onValueChange = { sliderState = it })
            }
        }

        // 3. Indicadores e Imágenes
        item {
            Text("3. Indicadores e Imágenes", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressIndicator()
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Ejemplo de Image"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewExploracion() {
    ExploracionComponentesTheme {
        ExploracionScreen()
    }
}