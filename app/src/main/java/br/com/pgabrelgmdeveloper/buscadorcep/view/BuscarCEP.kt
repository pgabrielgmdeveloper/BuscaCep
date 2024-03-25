package br.com.pgabrelgmdeveloper.buscadorcep.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.pgabrelgmdeveloper.buscadorcep.components.CustomButtom
import br.com.pgabrelgmdeveloper.buscadorcep.components.CustomOutlinedTextField
import br.com.pgabrelgmdeveloper.buscadorcep.ui.theme.Purple80


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuscarCEP(navController: NavController) {
    var cep by remember{
        mutableStateOf("")
    }
    var logradouro by remember{
        mutableStateOf("")
    }
    var bairro by remember{
        mutableStateOf("")
    }
    var cidade by remember{
        mutableStateOf("")
    }
    var estado by remember{
        mutableStateOf("")
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Buscador de cep") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Purple80, titleContentColor = Color.White)
            )
        }
    ) {

        Column(
            modifier = Modifier.padding(it)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 60.dp, 0.dp, 0.dp)) {
                CustomOutlinedTextField(label = "Cep",
                    modifier = Modifier
                    .weight(1f)
                    .padding(10.dp, 0.dp) ,
                    value = cep,
                    changeValue = { value ->
                                  cep = value
                    },
                    KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                CustomButtom(title = "Buscar Cep", modifier = Modifier
                    .weight(1f)
                    .padding(10.dp, 8.dp)
                    .height(54.dp)) {
                    
                }
            }
            CustomOutlinedTextField(label = "Logradouro", modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp),
                value = logradouro,  changeValue = { value ->
                    logradouro = value
                },
                KeyboardOptions(keyboardType = KeyboardType.Text))

            CustomOutlinedTextField(label = "Bairro", modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp),
                value = bairro,
                changeValue = { value ->
                    bairro = value
                },
                KeyboardOptions(keyboardType = KeyboardType.Text)
                )
            CustomOutlinedTextField(label = "Cidade", modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp) , value = cidade,  changeValue = { value ->
                cidade = value
            },
                KeyboardOptions(keyboardType = KeyboardType.Text))


            CustomOutlinedTextField(label = "Estado", modifier = Modifier.fillMaxWidth()

                .padding(10.dp, 0.dp), value = estado, changeValue = { value ->
                estado = value
            },
                KeyboardOptions(keyboardType = KeyboardType.Text))



                CustomButtom(title = "Avancar", modifier = Modifier.padding(10.dp, 8.dp)
                    .height(54.dp)) {
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun t(){
    BuscarCEP(navController = rememberNavController())
}