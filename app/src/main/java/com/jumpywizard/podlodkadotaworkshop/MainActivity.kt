package com.jumpywizard.podlodkadotaworkshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.jumpywizard.podlodkadotaworkshop.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            PodlodkaDotaWorkshopTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Screen()
                }
            }
        }
    }
}

@Preview
@Composable
fun Screen() {
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .fillMaxSize()
            .background(BackBlack)
            .verticalScroll(scrollState)
    ) {
        Box() {
            TopBar()
            Logo()
        }
        Tags()
        Description()
        Screenshots()
        Rating()
        Feedbacks()
        InstallButton()
    }
}

@Preview
@Composable
fun InstallButton() {
    OutlinedButton(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp, 40.dp, 24.dp, 40.dp)
            .height(64.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Yellow)
    ) {
        Text(text = "INSTALL", color = Color.Black, fontSize = 20.sp)
    }
}

@Preview
@Composable
fun Feedbacks() {
    val desc =
        "“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”"
    Column(modifier = Modifier.padding(start = 24.dp, top = 38.dp, end = 24.dp)) {
        Feedback("February 14, 2019", "Auguste Conte", desc, R.drawable.user_1)
        Divider(modifier = Modifier.padding(top = 24.dp, bottom = 24.dp), thickness = 1.dp)
        Feedback("February 14, 2019", "Jang Marcelino", desc, R.drawable.user_2)
    }
}

@Composable
fun Feedback(date: String, name: String, desc: String, imageResource: Int) {
    Column() {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Card(
                modifier = Modifier
                    .height(36.dp)
                    .width(36.dp), shape = CircleShape
            ) {
                Image(painter = painterResource(id = imageResource), contentDescription = null)
            }
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = name,
                    color = Color.White,
                    fontSize = 16.sp
                )
                Text(
                    text = date,
                    color = TransparentWhite,
                    fontSize = 12.sp
                )
            }
        }
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = desc,
            color = TransparentWhite,
            fontSize = 12.sp
        )
    }
}

@Preview
@Composable
fun Rating() {
    Column(modifier = Modifier.padding(start = 24.dp, top = 20.dp)) {
        Text(
            text = stringResource(R.string.review_and_ratings),
            color = Color.White,
            fontSize = 16.sp
        )
        Row(
            modifier = Modifier.padding(top = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.rating),
                color = Color.White,
                fontSize = 48.sp
            )
            Column(
                modifier = Modifier.padding(start = 16.dp), verticalArrangement = Arrangement.Center
            ) {
                Row() {
                    for (i in 1..5) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = null,
                            tint = Yellow
                        )
                    }
                }
                Text(
                    modifier = Modifier.padding(top = 8.dp), text = "70M Reviews",
                    color = TransparentWhite,
                    fontSize = 12.sp
                )
            }
        }
    }

}

@Preview
@Composable
fun Screenshots() {
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
            .fillMaxWidth()
            .padding(start = 24.dp, top = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Screenshot(imageResource = R.drawable.ex_1)
        Screenshot(imageResource = R.drawable.ex_1)
    }
}

@Composable
fun Screenshot(imageResource: Int) {
    Card(shape = RoundedCornerShape(14.dp)) {
        Image(
            modifier = Modifier.width(300.dp),
            painter = painterResource(id = imageResource),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
    }
}

@Preview
@Composable
fun Description() {
    Text(
        modifier = Modifier.padding(24.dp, 24.dp, 24.dp, 0.dp),
        text = stringResource(id = R.string.description),
        fontSize = 12.sp,
        color = TransparentWhite
    )
}

@Preview
@Composable
fun Tags() {
    Row(
        modifier = Modifier.padding(start = 24.dp, top = 26.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Tag("MOBA")
        Tag("MULTIPLAYER")
        Tag("STRATEGY")
    }
}

@Composable
fun Tag(text: String) {
    Card(backgroundColor = TagBackground, shape = RoundedCornerShape(100.dp)) {
        Text(
            modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 5.dp),
            text = text,
            color = TagText,
            fontSize = 10.sp
        )
    }
}


@Preview
@Composable
fun Logo() {
    Row(modifier = Modifier.padding(top = 320.dp)) {
        Image(
            painter = painterResource(id = R.drawable.dota_icon),
            modifier = Modifier
                .padding(start = 26.dp),
            contentDescription = "Icon",
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .padding(start = 6.dp)
                .align(Alignment.CenterVertically),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text("DoTA2", fontSize = 20.sp, color = Color.White, fontWeight = Bold)
            Row() {
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                ) {
                    for (i in 1..5) {
                        Icon(

                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = null,
                            tint = Yellow
                        )
                    }
                }
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "70М",
                    fontSize = 12.sp,
                    color = GrayText
                )
            }
        }
    }
}

@Preview
@Composable
fun TopBar() {
    Image(
        painter = painterResource(id = R.drawable.dota_top),
        modifier = Modifier.fillMaxWidth(),
        contentDescription = "Top",
        contentScale = ContentScale.FillWidth
    )

    Row() {
        Icon(
            painter = painterResource(id = R.drawable.ic_left_arrow),
            contentDescription = null,
            modifier = Modifier.padding(24.dp, 70.dp, 0.dp, 0.dp),
            tint = Color.White
        )
        Spacer(Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.ic_more),
            contentDescription = null,
            modifier = Modifier.padding(0.dp, 70.dp, 24.dp, 0.dp),
            tint = Color.White
        )
    }
}

