package com.example.mycertificate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycertificate.ui.theme.MyCertificateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCertificateTheme {
                Scaffold (modifier = Modifier.fillMaxSize()){
                    innerPadding -> CertificatingCourse(
                        nombre = "Luis Fernando González Zambrano",
                        number = 40,
                        course = "Advanced Swift Development",
                        company = "Tech Academy",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CertificatingCourse(nombre: String, number:Int, course: String, company: String, modifier: Modifier = Modifier) {
    val representative1 = "Steve Jobs"
    val representative2 = "Steve Wozniak"
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.unam_logo),
                    contentDescription = "Left Logo",
                    modifier = Modifier.size(50.dp)
                )
                Text(
                    modifier = modifier.padding(0.dp, 10.dp),
                    text = company,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    painter = painterResource(id = R.drawable.fi_unam_logo),
                    contentDescription = "Right Logo",
                    modifier = Modifier.size(50.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "This certificate is presented to:", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.course_logo),
                    contentDescription = "Logo de Certificado",
                    modifier = modifier.size(250.dp),
                    alpha = 0.4F
                )
                Text(
                    text = nombre,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "has completed a $number hours course on", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = course, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.firma1),
                        contentDescription = "Firma 1",
                        modifier = modifier.size(70.dp),
                    )
                    Text(text = representative1, fontSize = 16.sp)
                    Text(text = "Representative", fontSize = 14.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.firma2),
                        contentDescription = "Firma 2",
                        modifier = modifier.size(70.dp),
                    )
                    Text(text = representative2, fontSize = 16.sp)
                    Text(text = "Representative", fontSize = 14.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CertificatingCoursePreview(){
    CertificatingCourse(
        nombre = "Luis Fernando González Zambrano",
        number = 40,
        course = "Advanced Swift Development",
        company = "Tech Academy"
    )
}
