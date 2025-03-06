package com.example.listacomida

import android.provider.ContactsContract.Data
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listacomida.data.DataSource
import com.example.listacomida.model.Platillo
import java.text.NumberFormat

@Composable
fun MenuCard(platillo: Platillo, modifier: Modifier = Modifier){
    Card(modifier = Modifier.padding(10.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box(modifier = Modifier.padding(horizontal = 15.dp)) {
                Image(
                    painter = painterResource(id = platillo.drawableResourceId),
                    contentDescription = stringResource(id = platillo.stringResourceId),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(160.dp)
                        .clip(CircleShape)
                )
            }
            Column(
                modifier = Modifier
                    .height(160.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = LocalContext.current.getString(platillo.stringResourceId),
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = NumberFormat.getCurrencyInstance().format(platillo.precio),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Con hasta " + platillo.descuento + "% de descuento",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
        }
    }
}

@Composable
fun MenuCardList(platillos:List<Platillo>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier) {
        items(platillos) {
            platillo -> MenuCard(
                platillo = platillo,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuCard_Preview(){
    val dataSource = DataSource()
    val platillos = dataSource.LoadPlatillos()
    MenuCard(platillo = platillos[0])
}