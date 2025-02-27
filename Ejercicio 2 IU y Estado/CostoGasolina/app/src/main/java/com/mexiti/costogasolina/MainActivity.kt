package com.mexiti.costogasolina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mexiti.costogasolina.ui.theme.CostoGasolinaTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CostoGasolinaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CostGasLayout("Android")
                }
            }
        }
    }
}

// ============= Funciones no componibles =============
private fun calculateAmmount(precio:Double, cantLitros:Double, propina:Double):String {
    val monto = precio * cantLitros + propina
    return NumberFormat.getCurrencyInstance().format(monto)
}

@Composable
fun CostGasLayout(name: String) {
    var precioLitroEntrada by remember { mutableStateOf("") }
    var cantLitrosEntrada by remember { mutableStateOf("") }
    var propinaEntrada by remember { mutableStateOf("") }
    var incluirPropina by remember { mutableStateOf(false) }
    val precioLitro = precioLitroEntrada.toDoubleOrNull() ?: 0.0
    val cantLitros = cantLitrosEntrada.toDoubleOrNull() ?: 0.0
    val propina = if (incluirPropina) propinaEntrada.toDoubleOrNull() ?: 0.0 else 0.0
    val total = calculateAmmount(precioLitro, cantLitros, propina)

    Box(modifier = Modifier.fillMaxSize()) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(16.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = Modifier.padding(0.dp, 10.dp),
                text = stringResource(R.string.calcular_monto),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
                )
            EditNumberField(
                modifier = Modifier.fillMaxWidth(),
                label = R.string.ingresa_gasolina,
                leadingIcon = R.drawable.money_gas ,
                keyboardsOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                value = precioLitroEntrada,
                onValueChanged = { precioLitroEntrada = it }
            )
            EditNumberField(
                modifier = Modifier.fillMaxWidth(),
                label = R.string.litros,
                leadingIcon = R.drawable.gasolina ,
                keyboardsOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                value = cantLitrosEntrada,
                onValueChanged = { cantLitrosEntrada = it }
            )
            EditNumberField(
                modifier = Modifier.fillMaxWidth(),
                label = R.string.propina,
                leadingIcon = R.drawable.propina ,
                keyboardsOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                value = propinaEntrada,
                onValueChanged = { propinaEntrada = it }
            )
            Row (
                modifier = Modifier.fillMaxWidth().padding(0.dp, 10.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                //verticalAlignment = Arrangement.aligned()
            ){
                Text(
                    modifier = Modifier.padding(0.dp,10.dp),
                    text = "¿Deseas agregar la propina?",
                )
                Switch(
                    checked = incluirPropina,
                    onCheckedChange = { incluirPropina = it }
                )
            }
            Text(
                text = stringResource(R.string.total_string,total),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )

        }
    }
}

@Composable
fun EditNumberField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    keyboardsOptions:KeyboardOptions,
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
){
    TextField(
        label = { Text(text = stringResource(id = label))  },
        value = value,
        singleLine = true,
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon) , contentDescription = null) },
        keyboardOptions = keyboardsOptions,
        modifier = modifier,
        onValueChange = onValueChanged
    )

}

@Preview(showBackground = true)
@Composable
fun CostGasLayoutPreview() {
    CostoGasolinaTheme {
        CostGasLayout("Android")
    }
}