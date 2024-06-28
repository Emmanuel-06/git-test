package com.example.galleria


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.galleria.ui.theme.GalleriaTheme
import com.example.galleria.ui.theme.avenirFontFamily



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GalleriaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Column(modifier = Modifier
                       .fillMaxSize()) {
                       Layout()
                   }
                }
            }
        }
    }
}

@Composable
fun Layout() {
    var currentImagePosition by remember {
        mutableStateOf(0)
    }
    val artworkImages = listOf<Int>(
        R.drawable.christ_the_redemmer,
        R.drawable.wonder_india,
        R.drawable.greatwall_of_china,
        R.drawable.roman_colloseum,
        R.drawable.petra,
        R.drawable.chichen_itza,
        R.drawable.machu_picchu
    )

    var currentNamePosition by remember {
        mutableStateOf(0)
    }
    val nameOfWonder = listOf(
        R.string.christ_the_redeemer,
        R.string.taj_mahal,
        R.string.greatwall_of_china,
        R.string.roman_colosseum,
        R.string.petra,
        R.string.chichen_itza,
        R.string.machu_picchu
    )

    var currentLocationPosition by remember {
        mutableStateOf(0)
    }
    val location = listOf(
        R.string.ctr_location,
        R.string.tm_location,
        R.string.g_o_c_location,
        R.string.rc_location,
        R.string.pt_location,
        R.string.ci_location,
        R.string.mp_location
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(40.dp)


    ) {
        Text(
            text = stringResource(id = R.string.the_seven_wonders),
            fontSize = 24.sp,
            fontFamily = avenirFontFamily,
            letterSpacing = 0.04.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(40.dp))
        ElevatedCard(
            shape = RoundedCornerShape(0.dp),
            elevation = cardElevation(6.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .size(300.dp, 320.dp)

        ) {
            Image(
                painter = painterResource(artworkImages[currentImagePosition]),
                contentDescription = "Artwork",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(30.dp)
                    .size(300.dp, 320.dp)
                    .clip(RoundedCornerShape(0.dp))

            )
        }

        Spacer(modifier = Modifier.height(80.dp))
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxHeight(1f)
                .padding(bottom = 20.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(id = R.color.pale_orange))
                    .padding(20.dp)
            ) {
                Column {
                    Text(
                        text = stringResource(nameOfWonder[currentNamePosition]),
                        fontFamily = avenirFontFamily,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.02.sp,
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = stringResource(location[currentNamePosition]),
                            fontFamily = avenirFontFamily,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.02.sp
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = stringResource(id = R.string.ctr_year),
                            fontFamily = avenirFontFamily,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = 0.02.sp
                        )
                    }


                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                            currentImagePosition--
                            currentNamePosition--
                            currentLocationPosition--

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .then(
                            if (currentImagePosition == artworkImages[0]) {
                                Modifier.alpha(0f)
                            } else {
                                Modifier.alpha(1f)
                            }
                        )
                ) {
                    Text(
                        text = stringResource(id = R.string.prev),
                        fontFamily = avenirFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )

                }

                Spacer(modifier = Modifier.width(30.dp))
                Button(
                    onClick = {
                        if (currentImagePosition < artworkImages.size - 1) {
                            currentImagePosition++
                            currentNamePosition++
                            currentLocationPosition++
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .then(
                            if (currentImagePosition == artworkImages.size - 1) {
                                Modifier.alpha(0f)

                            } else {
                                Modifier
                            }
                        )
                ) {
                    Text(
                        text = stringResource(id = R.string.next),
                        fontFamily = avenirFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GalleriaTheme {
        Layout()
    }
}