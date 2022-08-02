package com.example.timerui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Icon
import com.example.timerui.ui.theme.TimerUITheme
import androidx.compose.material.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimerUITheme {

ScreenElements(appImageValues)

            }
        }
    }
}
data class AppImageValue(
    val id: Int,
    val name: String,
    val imageRes : Int
)
val appImageValues = listOf(
    AppImageValue(
        1,
        "Facebook",
        R.drawable._1__1_,
    ),
    AppImageValue(
        2,
        "Youtube",
        R.drawable._1__2_,
    ),
    AppImageValue(
        3,
        "LinkedIn",
        R.drawable._1__3_,
    ),
    AppImageValue(
        4,
        "Twitter",
        R.drawable._1__4_,
    ),
    AppImageValue(
        5,
        "Snapchat",
        R.drawable._1__5_,
    ),
    AppImageValue(
        6,
        "Instagram",
        R.drawable._1__6_,
    ),
    AppImageValue(
        7,
        "Whatsapp",
        R.drawable._1__7_,
    )
)
//@Composable
//fun AppImage(imageRes : Int){
//    Image(
//        painter = painterResource(id =imageRes),
//        contentDescription = null,
//        contentScale = ContentScale.Crop,
//        modifier = Modifier
//            .size(56.dp)
//            .clip(CircleShape)
//    )
//}

//@Composable
//fun AppName( text: String){
//    Text(
//        text= stringResource(id=text),
//        style = MaterialTheme.typography.headlineSmall
//    )
//}

@Composable
fun AppDuration(time:String){
    Text(
        text= time
        )
}

@Composable
fun AppLimit(timeLeft:String){
    Text(
        text=timeLeft,
        modifier = Modifier.paddingFromBaseline(
            top = 24.dp, bottom = 8.dp
    )
    )
}

@Composable
fun timerElement(name: String, image: Int) {
    Card(
        modifier = Modifier.padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colorScheme.surface
    ) {


        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id =image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text= name,
                    style = MaterialTheme.typography.headlineSmall
                )
                AppDuration(time = "4h 54m")
            }
            Spacer(modifier = Modifier.width(100.dp))



            Row {
                Divider(Modifier
                    .width(2.dp)
                    .height(100.dp), color = Color.Black)
                Spacer(modifier = Modifier.width(20.dp))
                Column(modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(id = R.drawable.ic_baseline_hourglass_top_24),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape))
                    androidx.compose.material.Text(
                        text = "30m"
                    )


                }
            }


        }

    }
}





@Composable
fun ScreenElements(platList: List<AppImageValue>) {
    Column() {

        Column {

            Text(text = "App Usage")
            Spacer(modifier = Modifier.width(30.dp))
        }
        Column() {

        Text(text = "Graph")
        Spacer(modifier = Modifier.width(80.dp))}

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {


            items(platList) { AppImageValue ->
                timerElement(AppImageValue.name, AppImageValue.imageRes)
                Spacer(modifier = Modifier.width(20.dp))
            }



        }
    }
}





