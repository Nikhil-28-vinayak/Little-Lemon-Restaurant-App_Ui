package com.example.little_lemon


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.SnackbarHostState

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.nio.file.WatchEvent

@Composable
fun UpperPanel1(
    snackbarHostState: SnackbarHostState,
    scope: CoroutineScope,
    navController: NavHostController
){
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .background(Color(0xFF495E57))
            .padding(start = 12.dp, end = 12.dp ,bottom = 16.dp)

    ) {
        Text(
            text = stringResource(id = R.string.title),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFF4CE14),
            modifier = Modifier.padding(top = 15.dp).clickable {},
            fontFamily = FontFamily.Serif,
        )
        Text(
            text = stringResource(id = R.string.location),
            fontSize = 24.sp,
            color = Color(0xFFEDEFEE),
            fontFamily = FontFamily.Serif,
            modifier = Modifier.clickable {}
        )
        Row(
            modifier = Modifier
                .padding(top = 18.dp)
        ) {
            Text(
                text = stringResource(id = R.string.description),
                color = Color(0xFFEDEFEE),
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(bottom = 28.dp, end = 23.dp)
                    .clickable {}
                    .fillMaxWidth(0.6f),
            )
            Image(
                painter = painterResource(id = R.drawable.upperpanelimage),
                contentDescription = "Upper Panel Image",
                modifier = Modifier.clip(RoundedCornerShape(20.dp))
            )
        }
        Button(
            onClick = {
                navController.navigate(MenuList.route)
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFFf4CE14)),
        ) {
            Text(
                text = stringResource(id = R.string.orderbuttontext),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333),
            )
        }
    }
        }


@Composable
fun UpperPanel2(
    snackbarHostState: SnackbarHostState,
    scope: CoroutineScope,
    navController: NavHostController
){
    val context = LocalContext.current
    Row(
        modifier = Modifier.fillMaxHeight()
            .height(200.dp)
            .background(Color(0xFF495E57))
            .padding(start = 12.dp, end = 12.dp ,bottom = 16.dp)
    ) {
        Column() {
            Text(
                text = stringResource(id = R.string.title),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF4CE14),
                modifier = Modifier.padding(top = 15.dp, bottom = 5.dp).clickable {},
                fontFamily = FontFamily.Serif,
            )
            Text(
                text = stringResource(id = R.string.location),
                fontSize = 24.sp,
                color = Color(0xFFEDEFEE),
                fontFamily = FontFamily.Serif,
                modifier = Modifier.clickable {}
            )
            Row (
                modifier = Modifier
                    .padding(top = 18.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.description3),
                    color = Color(0xFFEDEFEE),
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(end=23.dp)
                        .clickable {}
                        .fillMaxWidth(0.4f),
                )
                Image(
                    painter = painterResource(id = R.drawable.upperpanelimage),
                    contentDescription = "Upper Panel Image",
                    modifier = Modifier.size(165.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
            }
            Button(
                {
                 navController.navigate(MenuList.route)
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFFf4CE14)),
            ) {
                Text(
                    text = stringResource(id = R.string.orderbuttontext),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF333333),
                )
            }

        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun UpperPanelPreview(){
//    val snackbarHostState = remember { SnackbarHostState() }
//    val scope = rememberCoroutineScope()
//    UpperPanel2(snackbarHostState, scope,  )
//}

@Composable
fun changes(count: Int, onIncrement:()->Unit,ondecrement:()->Unit){
    Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
        Button(onClick = {ondecrement()},modifier= Modifier.padding(10.dp)){
            Text("-")
        }
        Text("$count", fontSize = 55.sp)
        Button(onClick = {onIncrement()},modifier= Modifier.padding(10.dp)){
            Text("+")
        }
    }
}
