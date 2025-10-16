package com.example.little_lemon


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           MyNavigation()
}
//            var count by rememberSaveable {mutableStateOf(0)}
//           changes(count, {count++}, {count--})
//            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
//                Text(
//                    stringResource(R.string.title), fontSize = 32.sp, color= Color(0xFFF4CE14)
//                )
//                   Text(
//                       stringResource(R.string.place), fontSize = 32.sp, color= Color(0xFFF4CE14)
//                   )
//                Row {
//                    Button({ TODO() },
//                        border = BorderStroke(1.dp, Color.Red), shape = RoundedCornerShape(10.dp),
//                        colors = ButtonDefaults.buttonColors(Color.Gray)
//                    ) {
//                        Text(stringResource(R.string.button))
//                    }
//                }
//              }
            }
        }
var imageName: String=""
var title: String=""
var price:String=""
@Composable
fun MyNavigation(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Login.route){
        composable(Login.route) {
            LoginPage(navController)
        }
        composable(SignUp.route) {
            SignUpPage(navController)
        }
        composable(Home.route) {
            Main(navController)
        }
        composable(MenuList.route) {
            MenuList(navController)
        }
        composable(Order.route) {
            Order(imageName,title,price)
        }
    }
}



//@Composable
//fun UpperPanel1() {
//    val context= LocalContext.current
//    Column(
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.Start,
//        modifier = Modifier.fillMaxWidth().background(Color(0xFF495E57))
//    ) {
//        Text(stringResource(R.string.title), fontSize = 32.sp, modifier = Modifier.padding(start=20.dp, top=40.dp).clickable {}, color=Color.Yellow)
//        Text(stringResource(R.string.location), color = Color.White, fontSize = 24.sp, modifier = Modifier.padding(start=20.dp))
//        Row(modifier = Modifier.fillMaxWidth() ) {
//            Column(modifier=Modifier.padding(end=20.dp)) {
//                Text(stringResource(R.string.content), color=Color.White, fontSize = 21.sp, modifier = Modifier.width(200.dp).padding(start=20.dp, top=20.dp, ))
//                Button(onClick = {
//                        Toast.makeText(context, "Order SuccessFull", Toast.LENGTH_SHORT).show()
//                    }, shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(Color(0xFFFf4CE14)), border = BorderStroke(1.dp, Color.Red), modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 20.dp)) {
//
//                    Text(stringResource(R.string.orderbuttontext), color=Color.Black,)
//                }
//
//            }
//            Image(
//                painterResource(R.drawable.img),
//                contentDescription = "",
//                modifier = Modifier.height(200.dp).clip(RoundedCornerShape(20.dp))
//            )
//        }
//    }
//}








//package com.example.littlelemonlogin
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.littlelemonlogin.ui.theme.LittleLemonLoginTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            LittleLemonLoginTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    LoginScreen()
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun LoginScreen(){
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Image(
//            painter = painterResource(
//                id = R.drawable.littlelemonlogo),
//            contentDescription = "Logo Image"
//        )
//        TextField(
//            value = "",
//            onValueChange = {},
//            label = { Text(text = "Username") },
//        )
//        TextField(
//            value = "",
//            onValueChange = {},
//            label = { Text(text = "Password") },
//        )
//        Button(
//            onClick = { /TODO/ },
//            colors = ButtonDefaults.buttonColors(
//                Color(0xFF495E57)
//            )
//        ) {
//            Text(
//                text = "Login",
//                color = Color(0xFFEDEFEE)
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun LoginScreenPreview(){
//    LoginScreen()
//}
