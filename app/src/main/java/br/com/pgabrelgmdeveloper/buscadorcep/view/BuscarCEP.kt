package br.com.pgabrelgmdeveloper.buscadorcep.view

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.pgabrelgmdeveloper.buscadorcep.components.CustomButtom
import br.com.pgabrelgmdeveloper.buscadorcep.components.CustomOutlinedTextField
import br.com.pgabrelgmdeveloper.buscadorcep.listners.ResponseApi
import br.com.pgabrelgmdeveloper.buscadorcep.ui.theme.Purple80
import br.com.pgabrelgmdeveloper.buscadorcep.viewmodel.BuscarCepViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuscarCEP(navController: NavController, viewModel: BuscarCepViewModel) {
    val context = LocalContext.current
    var inputCep by remember{
        mutableStateOf("")
    }
    var logradouroInput by remember{
        mutableStateOf("")
    }
    var bairroInput by remember{
        mutableStateOf("")
    }
    var cidadeInput by remember{
        mutableStateOf("")
    }
    var estadoInput by remember{
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
                    value = inputCep,
                    changeValue = { value ->
                                  inputCep = value
                    },
                    KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                CustomButtom(title = "Buscar Cep", modifier = Modifier
                    .weight(1f)
                    .padding(10.dp, 8.dp)
                    .height(54.dp), onClick = {
                        viewModel.responseApi(inputCep, object : ResponseApi {
                            override fun onSuccess(
                                logradouro: String,
                                bairro: String,
                                cidade: String,
                                estado: String
                            ) {
                                logradouroInput =logradouro
                                bairroInput = bairro
                                cidadeInput = cidade
                                estadoInput = estado
                            }

                            override fun onFailure(error: String) {
                               Toast.makeText(context,error,Toast.LENGTH_SHORT).show()
                            }

                        })
                })
            }
            CustomOutlinedTextField(label = "Logradouro", modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp),
                value = logradouroInput,  changeValue = { value ->
                    logradouroInput = value
                },
                KeyboardOptions(keyboardType = KeyboardType.Text))

            CustomOutlinedTextField(label = "Bairro", modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp),
                value = bairroInput,
                changeValue = { value ->
                    bairroInput = value
                },
                KeyboardOptions(keyboardType = KeyboardType.Text)
                )
            CustomOutlinedTextField(label = "Cidade", modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp) , value = cidadeInput,  changeValue = { value ->
                cidadeInput = value
            },
                KeyboardOptions(keyboardType = KeyboardType.Text))


            CustomOutlinedTextField(label = "Estado", modifier = Modifier.fillMaxWidth()

                .padding(10.dp, 0.dp), value = estadoInput, changeValue = { value ->
                estadoInput = value
            },
                KeyboardOptions(keyboardType = KeyboardType.Text))
                CustomButtom(title = "Avancar", modifier = Modifier.padding(10.dp, 8.dp)
                    .height(54.dp)) {
            }

        }
    }
}


