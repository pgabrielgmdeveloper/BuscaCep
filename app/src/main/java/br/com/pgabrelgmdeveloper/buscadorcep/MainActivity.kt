package br.com.pgabrelgmdeveloper.buscadorcep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.pgabrelgmdeveloper.buscadorcep.ui.theme.BuscadorCepTheme
import br.com.pgabrelgmdeveloper.buscadorcep.view.BuscarCEP
import br.com.pgabrelgmdeveloper.buscadorcep.viewmodel.BuscarCepViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuscadorCepTheme {
                val navController = rememberNavController()
                val viewModel: BuscarCepViewModel = hiltViewModel<BuscarCepViewModel>()
                NavHost(navController = navController, startDestination = "buscadorCep"){
                    composable("buscadorCep"){
                        BuscarCEP(navController = navController, viewModel = viewModel)
                    }
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
    BuscadorCepTheme {
        Greeting("Android")
    }
}