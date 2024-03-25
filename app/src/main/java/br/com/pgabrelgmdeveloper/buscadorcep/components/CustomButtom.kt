package br.com.pgabrelgmdeveloper.buscadorcep.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CustomButtom(title: String, modifier: Modifier,onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(5.dp)
    ) {
        Text(text = title)
    }
}

@Preview
@Composable
fun PCB() {
    CustomButtom(title = "BuscarCEP", modifier = Modifier.padding()) {

    }
}