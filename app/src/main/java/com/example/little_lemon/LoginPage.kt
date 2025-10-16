package com.example.little_lemon

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginPage(navController: NavHostController){
    var snackbarHostState = remember { SnackbarHostState() }
    var scope =rememberCoroutineScope()
    Column {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState)},
            content = {LoginPage1(navController, snackbarHostState, scope)}
        )
    }
}
@Composable
fun LoginPage1(
    navController: NavHostController,
    snackbarHostState: SnackbarHostState,
    scope: CoroutineScope
) {
        Column(
            modifier = Modifier.fillMaxSize().background(Color(0xFF495E57)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painterResource(R.drawable.img_47), contentDescription = "",
                modifier = Modifier
                    .padding(top = 65.dp, bottom = 25.dp)
                    .width(300.dp)
            )
            var email by remember { mutableStateOf("") }
            var passward by remember { mutableStateOf("") }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(15.dp),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        "Welcome!", fontSize = 30.sp,
                        modifier = Modifier.padding(start = 140.dp, top = 20.dp),
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                    TextButton(
                        onClick = {navController.navigate(SignUp.route)},
                        modifier = Modifier.padding(start = 45.dp, top = 5.dp)
                    ) {
                        Text(
                            "Create an Account", color = Color(0xFFFf4CE14),
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Enter email") },
                            singleLine = true,
                            modifier = Modifier.padding(start = 55.dp)
                        )
                        OutlinedTextField(
                            value = passward,
                            onValueChange = { passward = it },
                            label = { Text("Enter passward") },
                            singleLine = true,
                            modifier = Modifier.padding(start = 55.dp, top = 20.dp)
                        )
                    }
                    TextButton(
                        onClick = {},
                        modifier = Modifier.padding(start = 42.dp, top = 10.dp)
                    ) {
                        Text(
                            "Forget your Passward?", color = Color(0xFFFf4CE14),
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(start = 105.dp)
                    ) {
                        Button(
                            onClick = {
                                if ((email=="")&&(passward=="")){
                                    scope.launch { snackbarHostState.showSnackbar("Please enter your email and passward!") }
                                }else if(passward==""){
                                    scope.launch { snackbarHostState.showSnackbar("Please enter your passward!") }
                                } else if(email==""){
                                    scope.launch { snackbarHostState.showSnackbar("Please enter your email!") }
                                }else{
                                    navController.navigate(Home.route)
                                }
                            },
                            colors = ButtonDefaults.buttonColors(Color(0xFFFf4CE14)),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .padding(top = 25.dp)
                                .width(200.dp)
                                .height(50.dp)
                        ) {
                            Text(
                                "Login", color = Color(0xFF333333),
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Text(
                            "or",
                            color = Color.Gray,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(top = 10.dp)
                        )
                        Text(
                            "login using",
                            color = Color.Gray,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(top = 15.dp)
                        )
                        Row(modifier = Modifier.padding(bottom = 20.dp)) {
                            IconButton(onClick = {}, modifier = Modifier.padding(top = 10.dp)) {
                                Image(
                                    painterResource(R.drawable.img_44),
                                    contentDescription = " ",
                                )
                            }

                            IconButton(
                                onClick = {},
                                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                            ) {
                                Image(
                                    painterResource(R.drawable.img_45),
                                    contentDescription = " ",
                                    modifier = Modifier.size(35.dp)
                                )
                            }
                            IconButton(
                                onClick = {},
                                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                            ) {
                                Image(
                                    painterResource(R.drawable.img_46),
                                    contentDescription = " ",
                                    modifier = Modifier.size(35.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }


@Preview
@Composable
fun bb(){
    val navController= rememberNavController()
    LoginPage(navController)
}