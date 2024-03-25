package br.com.pgabrelgmdeveloper.buscadorcep.components
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun  CustomOutlinedTextField(label:String, modifier: Modifier, value: String, changeValue: (String) -> Unit, keyboardOptions: KeyboardOptions) {
    OutlinedTextField(value = value,
        onValueChange = changeValue,
        label={ Text(text = label)},
        modifier = modifier, keyboardOptions =  keyboardOptions
    )
}



