package com.example.little_lemon

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Order(image:String,text1: String, text2: String){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)//create a drawerstate
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxSize().background(Color.White) ){
       Scaffold(
           topBar = {TopAppBar1(drawerState, scope)},
           snackbarHost = { SnackbarHost(snackbarHostState) },
           content = {Order1(image,text1,text2, snackbarHostState, scope)}
       )
    }
}
@Composable
fun Order1(
    image: String,
    text1: String,
    text2: String,
    snackbarHostState: SnackbarHostState,
    scope: CoroutineScope
):Int{
   Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
       Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp)) {
           DynamicImage(image)
       }
       Row(modifier = Modifier.fillMaxWidth()) {
           Text(
               text1, color = Color.Black,
               fontWeight = FontWeight.Bold, fontSize = 30.sp,
               modifier = Modifier.padding(start = 10.dp),
               fontFamily = FontFamily.Serif
           )

           Spacer(modifier = Modifier.width(150.dp))

           Text(
               text2, color = Color.Black, modifier = Modifier.padding(top = 6.dp),
               fontWeight = FontWeight.Bold, fontSize = 25.sp
           )
       }
       Text(
           stringResource(R.string.content),
           modifier = Modifier.padding(top = 10.dp, start = 10.dp, bottom = 20.dp),
           fontSize = 20.sp
       )
       var checked1 by remember { mutableStateOf(false) }
       var checked2 by remember { mutableStateOf(false) }
       var checked3 by remember { mutableStateOf(false) }
       var checked4 by remember { mutableStateOf(false) }
       Card() {
           Column(modifier = Modifier.background(Color.White)) {
               Text("Select options for customisation!", fontSize = 25.sp,
                   fontWeight = FontWeight.Bold,
                   modifier = Modifier.padding(start = 10.dp, bottom = 10.dp))
               Row(modifier = Modifier.fillMaxWidth()) {
                   Text("Extra Toppings", fontSize = 20.sp,   modifier = Modifier.padding(start = 10.dp))
                   Spacer(modifier = Modifier.width(228.dp))
                   Checkbox(
                       checked = checked1,
                       onCheckedChange = { checked1 = it },
                   )
               }
               Row(modifier = Modifier.fillMaxWidth()) {
                   Text("Extra Spices", fontSize = 20.sp,   modifier = Modifier.padding(start = 10.dp))
                   Spacer(modifier = Modifier.width(255.dp))
                   Checkbox(
                       checked = checked2,
                       onCheckedChange = { checked2 = it },
                   )
               }
               Row(modifier = Modifier.fillMaxWidth()) {
                   Text("Soft Drinks", fontSize = 20.sp,   modifier = Modifier.padding(start = 10.dp))
                   Spacer(modifier = Modifier.width(268.dp))
                   Checkbox(
                       checked = checked3,
                       onCheckedChange = { checked3 = it },
                   )
               }
               Row(modifier = Modifier.fillMaxWidth()) {
                   Text("Normal", fontSize = 20.sp,   modifier = Modifier.padding(start = 10.dp))
                   Spacer(modifier = Modifier.width(305.dp))
                   Checkbox(
                       checked = checked4,
                       onCheckedChange = { checked4 = it },
                   )
               }
           }
       }
       Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
       Button(
           onClick = {  if(checked1==true||checked2==true||checked3==true)
               scope.launch { snackbarHostState.showSnackbar("Your order is successfully added") }
               else
               scope.launch { snackbarHostState.showSnackbar("Please Select any option!") }},
           colors = ButtonDefaults.buttonColors(Color(0xFFF4CE14)),
           shape = RoundedCornerShape(30.dp),
           modifier = Modifier.width(400.dp).height(50.dp).padding(top = 5.dp)
       ) {
           Text(
               "Add to card", color = Color.Black, fontSize = 25.sp,
               fontWeight = FontWeight.Bold
           )
       }
       }
   }
    return 0
}
@Preview
@Composable
fun sjnjn(){
    Order("greekSalad","GreekSalad","12.99")
}

@Composable
fun DynamicImage(imageName: String) {
    val context = LocalContext.current
    val imageResId = remember(imageName) {
        context.resources.getIdentifier(imageName, "drawable", context.packageName)
    }

    if (imageResId != 0) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            contentScale = ContentScale.Crop
        )
    } else {
        Text("Image not found", color = Color.Red)
    }
}