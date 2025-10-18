package com.example.little_lemon

import DrawerPanel
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MenuList(navController: NavHostController) {
    var state = remember { mutableStateOf("Salads") }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)//create a drawerstate
    val scope = rememberCoroutineScope()//create a coroutine
    ModalNavigationDrawer(//create a drawer
        drawerState = drawerState,//used to check whether drawer is open or not
        drawerContent = {//content of the drawer
            DrawerPanel(drawerState, scope)
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar1(drawerState, scope)
            },
            bottomBar = {
                BottomBar(navController)
            },
            content = {
                Column() {
                    Panel1()
                    Panel2(navController) { newValue ->
                        state.value = newValue
                    }
                    when (state.value) {
                        "Salads" -> Panel3a(navController)
                        "Pasta" -> Panel3b(navController)
                        "Pizza" -> Panel3c(navController)
                        "French Fires" -> Panel3d(navController)
                        "Noodles" -> Panel3e(navController)
                    }
                }
            }
        )
    }
}
    @Composable
    fun Panel1() {
        Row(
            modifier = Modifier.fillMaxWidth().height(150.dp).background(Color(0xFF495E57))
                .padding(top = 60.dp)
        ) {
            Text(
                text = "Little Lemon",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF4CE14),
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(top = 30.dp).clickable {}
            )
        }
    }

    @Composable
    fun Panel2(navController: NavHostController, onitemSelected: (String) -> Unit) {
        Column(modifier = Modifier.fillMaxWidth().background(Color.White)) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "ORDER FOR TAKE AWAY",
                    fontSize = 25.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
            LazyRow {
                item {
                    tab(navController, onitemSelected)
                }
            }
        }
    }
    @Composable
    fun tab(navController: NavHostController, onitemSelected: (String) -> Unit) {
        Button(
            onClick = { onitemSelected("Salads") },
            shape = RoundedCornerShape(40),
            colors = ButtonDefaults.buttonColors(Color(0xFFFf4CE14)),
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                "Salads",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333),
            )
        }
        Button(
            onClick = { onitemSelected("Pasta") },
            shape = RoundedCornerShape(40),
            colors = ButtonDefaults.buttonColors(Color(0xFFFf4CE14)),
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                "Pasta",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333),
            )
        }
        Button(
            onClick = { onitemSelected("Pizza") },
            shape = RoundedCornerShape(40),
            colors = ButtonDefaults.buttonColors(Color(0xFFFf4CE14)),
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                "Pizza",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333),
            )
        }
        Button(
            onClick = { onitemSelected("French Fires") },
            shape = RoundedCornerShape(40),
            colors = ButtonDefaults.buttonColors(Color(0xFFFf4CE14)),
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                "French Fires",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333),
            )
        }
        Button(
            onClick = { onitemSelected("Noodles") },
            shape = RoundedCornerShape(40),
            colors = ButtonDefaults.buttonColors(Color(0xFFFf4CE14)),
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                "Noodles",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333),
            )
        }
    }
@Composable
fun Panel3a(navController: NavHostController) {
    HorizontalDivider(
        thickness = 2.dp,
        color = Color.Gray
    )
    LazyColumn(modifier = Modifier.fillMaxWidth().padding()) {
        item {
            Card(
                onClick = {
                    imageName="greeksalad"
                    title="Greek Salad"
                    price="$12.99"
                    description="Greek salad combines crisp cucumbers, juicy tomatoes, briny olives, " +
                            "sharp red onions, and creamy feta cheese, all tossed in a zesty olive oil and oregano dressing for a refreshing experience."
                    navController.navigate(Order.route)},
                colors = CardDefaults.cardColors(Color.Gray),
                shape = RectangleShape,
            ) {
                Row(modifier = Modifier.fillMaxWidth().background(Color.White).padding(8.dp)) {
                    Column(
                        modifier = Modifier.width(300.dp)
                            .padding(end = 10.dp).clickable {}) {
                        Text("Greek Salad", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text(
                            androidx.compose.ui.res.stringResource(R.string.content),
                            color = Color.Gray,
                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Text("$12.99", color = Color.Gray, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(R.drawable.greeksalad),
                        contentDescription = "Greek Salad",
                        modifier = Modifier.size(100.dp)


                    )
                }
                HorizontalDivider(
                    thickness = 2.dp,
                    color = Color.Gray
                )
                Card(
                    onClick = {
                        imageName="img_8"
                        title="Chinese Salad"
                        price="$16.9"
                        description="The famous Chinese Salad of crispy lettuce, peppers, olives"
                        navController.navigate(Order.route)},
                    colors = CardDefaults.cardColors(Color.Gray),
                    shape = RectangleShape
                ) {
                    Row(modifier = Modifier.fillMaxWidth().background(Color.White).padding(8.dp)) {
                        Column(
                            modifier = Modifier.width(300.dp)
                                .padding(end = 10.dp).clickable {}) {
                            Text("Chinese Salad", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                            Text(
                                androidx.compose.ui.res.stringResource(R.string.content),
                                color = Color.Gray,
                                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                            )
                            Text("$16.9", color = Color.Gray, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(R.drawable.img_8),
                            contentDescription = "Greek Salad",
                            modifier = Modifier.size(100.dp)
                        )
                    }
                    HorizontalDivider(
                        thickness = 2.dp,
                        color = Color.Gray
                    )
                    Card(
                        onClick = {
                            imageName="img_9"
                            title="Tossed Salad"
                            price="$25.9"
                            description="The famous Tossed Salad of crispy, olives with a refreshing experience."
                            navController.navigate(Order.route)},
                        colors = CardDefaults.cardColors(Color.Gray),
                        shape = RectangleShape
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().background(Color.White).padding(8.dp)
                        ) {
                            Column(
                                modifier = Modifier.width(300.dp)
                                    .padding(end = 10.dp).clickable {}) {
                                Text("Tossed Salad", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                                Text(
                                    androidx.compose.ui.res.stringResource(R.string.content),
                                    color = Color.Gray,
                                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                                )
                                Text("$25.9", color = Color.Gray, fontWeight = FontWeight.Bold)
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Image(
                                painter = painterResource(R.drawable.img_9),
                                contentDescription = "Greek Salad",
                                modifier = Modifier.size(100.dp)
                            )
                        }
                        HorizontalDivider(
                            thickness = 2.dp,
                            color = Color.Gray
                        )
                        Card(
                            onClick = {
                                imageName="img_10"
                                title="Mexican Salad"
                                price="$9.5"
                                description="Mexican salad bursts with bold flavors from black beans, sweet corn, creamy avocado, juicy tomatoes, crunchy lettuce, and a tangy " +
                                        "lime-cilantro dressing that brings it all together in a bowl."
                                navController.navigate(Order.route)},
                            colors = CardDefaults.cardColors(Color.Gray),
                            shape = RectangleShape
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth().background(Color.White)
                                    .padding(8.dp)
                            ) {
                                Column(
                                    modifier = Modifier.width(300.dp)
                                        .padding(end = 10.dp).clickable {}) {
                                    Text(
                                        "Mexican Salad",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        androidx.compose.ui.res.stringResource(R.string.content),
                                        color = Color.Gray,
                                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                                    )
                                    Text("$9.5", color = Color.Gray, fontWeight = FontWeight.Bold)
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Image(
                                    painter = painterResource(R.drawable.img_10),
                                    contentDescription = "Greek Salad",
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                            HorizontalDivider(
                                thickness = 2.dp,
                                color = Color.Gray
                            )
                            Card(
                                onClick = {
                                    imageName="img_11"
                                    title="Indian Salad"
                                    price="$15.5"
                                    description="Indian salad is a vibrant medley of crisp cucumbers, juicy tomatoes, " +
                                            "finely chopped onions, and fresh coriander leaves, all " +
                                            "tossed with a zesty mix of lemon juice, salt, and chili, delivering a refreshing crunch " +
                                            "with a spicy, tangy kick that complements any traditional meal."
                                    navController.navigate(Order.route)},
                                colors = CardDefaults.cardColors(Color.Gray),
                                shape = RectangleShape
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth().background(Color.White)
                                        .padding(8.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.width(300.dp)
                                            .padding(end = 10.dp).clickable {}) {
                                        Text(
                                            "Indian Salad",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            androidx.compose.ui.res.stringResource(R.string.content),
                                            color = Color.Gray,
                                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                                        )
                                        Text(
                                            "$15.5",
                                            color = Color.Gray,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                    Image(
                                        painter = painterResource(R.drawable.img_11),
                                        contentDescription = "Greek Salad",
                                        modifier = Modifier.size(100.dp)
                                    )
                                }
                                HorizontalDivider(
                                    thickness = 2.dp,
                                    color = Color.Gray
                                )
                                Card(
                                    onClick = {
                                        imageName="img_12"
                                        title="Western Salad"
                                        price="$10.0"
                                        description="Western salad features a colorful mix of lettuce, cherry tomatoes, cucumbers, bell peppers, and shredded cheese,"+
                                        "topped with creamy ranch or vinaigrette for a classic, hearty crunch"
                                        navController.navigate(Order.route)},
                                    colors = CardDefaults.cardColors(Color.Gray),
                                    shape = RectangleShape
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth().background(Color.White)
                                            .padding(8.dp)
                                    ) {
                                        Column(
                                            modifier = Modifier.width(300.dp)
                                                .padding(end = 10.dp).clickable {}) {
                                            Text(
                                                "Western Salad",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Text(
                                                androidx.compose.ui.res.stringResource(R.string.content),
                                                color = Color.Gray,
                                                modifier = Modifier.padding(
                                                    top = 5.dp,
                                                    bottom = 5.dp
                                                )
                                            )
                                            Text(
                                                "$10.0",
                                                color = Color.Gray,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                        Spacer(modifier = Modifier.weight(1f))
                                        Image(
                                            painter = painterResource(R.drawable.img_12),
                                            contentDescription = "Greek Salad",
                                            modifier = Modifier.size(100.dp)
                                        )
                                    }
                                    HorizontalDivider(
                                        thickness = 2.dp,
                                        color = Color.Gray
                                    )
                                    Card(
                                        onClick = {
                                            imageName="img_13"
                                            title="Japanese Salad"
                                            price="$9.5"
                                            navController.navigate(Order.route)},
                                        colors = CardDefaults.cardColors(Color.Gray),
                                        shape = RectangleShape
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth()
                                                .background(Color.White)
                                                .padding(8.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier.width(300.dp)
                                                    .padding(end = 10.dp).clickable {}) {
                                                Text(
                                                    "Japanese Salad",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold
                                                )
                                                Text(
                                                    androidx.compose.ui.res.stringResource(R.string.content),
                                                    color = Color.Gray,
                                                    modifier = Modifier.padding(
                                                        top = 5.dp,
                                                        bottom = 5.dp
                                                    )
                                                )
                                                Text(
                                                    "$9.5",
                                                    color = Color.Gray,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            }
                                            Spacer(modifier = Modifier.weight(1f))
                                            Image(
                                                painter = painterResource(R.drawable.img_13),
                                                contentDescription = "Greek Salad",
                                                modifier = Modifier.size(100.dp)
                                            )
                                        }
                                        HorizontalDivider(
                                            thickness = 2.dp,
                                            color = Color.Gray
                                        )
                                        Card(
                                            colors = CardDefaults.cardColors(Color.Gray),
                                            shape = RectangleShape
                                        ) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth()
                                                    .background(Color.White)
                                                    .padding(8.dp)
                                            ) {
                                                Column(
                                                    modifier = Modifier.width(300.dp)
                                                        .padding(end = 10.dp).clickable {}) {
                                                    Text(
                                                        " ",
                                                        fontSize = 18.sp,
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                }
                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
    @Composable
    fun Panel3b(navController: NavHostController) {
        HorizontalDivider(
            thickness = 2.dp,
            color = Color.Gray
        )
        LazyColumn(modifier = Modifier.fillMaxWidth().padding()) {
            item {
                Card(
                    onClick = {
                        imageName="img_14"
                        title="Italian Pasta"
                        price="$14.27"
                        description="The famous Greek Salad of crispy lettuce, peppers, olives"
                        navController.navigate(Order.route)},
                    colors = CardDefaults.cardColors(Color.Gray),
                    shape = RectangleShape
                ) {
                    Row(modifier = Modifier.fillMaxWidth().background(Color.White).padding(8.dp)) {
                        Column(
                            modifier = Modifier.width(300.dp)
                                .padding(end = 10.dp).clickable {}) {
                            Text("Italian Pasta", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                            Text(
                                androidx.compose.ui.res.stringResource(R.string.pasta),
                                color = Color.Gray,
                                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                                fontWeight = FontWeight.Bold
                            )
                            Text("$14.27", color = Color.Gray, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(R.drawable.img_14),
                            contentDescription = "Greek Salad",
                            modifier = Modifier.size(100.dp)
                        )
                    }
                    HorizontalDivider(
                        thickness = 2.dp,
                        color = Color.Gray
                    )
                    Card(
                        onClick = {
                            imageName="img_15"
                            title="White Sauce Pasta"
                            price="$20.00"
                            navController.navigate(Order.route)},
                        colors = CardDefaults.cardColors(Color.Gray),
                        shape = RectangleShape
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().background(Color.White).padding(8.dp)
                        ) {
                            Column(
                                modifier = Modifier.width(300.dp)
                                    .padding(end = 10.dp).clickable {}) {
                                Text(
                                    "White Sauce Pasta",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    androidx.compose.ui.res.stringResource(R.string.content),
                                    color = Color.Gray,
                                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                                )
                                Text("$20.00", color = Color.Gray, fontWeight = FontWeight.Bold)
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Image(
                                painter = painterResource(R.drawable.img_15),
                                contentDescription = "Greek Salad",
                                modifier = Modifier.size(100.dp)
                            )
                        }
                        HorizontalDivider(
                            thickness = 2.dp,
                            color = Color.Gray
                        )
                        Card(
                            onClick = {
                                imageName="img_16"
                                title="Pink Sauce Pasta"
                                price="$20.9"
                                navController.navigate(Order.route)},
                            colors = CardDefaults.cardColors(Color.Gray),
                            shape = RectangleShape
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth().background(Color.White)
                                    .padding(8.dp)
                            ) {
                                Column(
                                    modifier = Modifier.width(300.dp)
                                        .padding(end = 10.dp).clickable {}) {
                                    Text(
                                        "Pink Sauce Pasta",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        androidx.compose.ui.res.stringResource(R.string.content),
                                        color = Color.Gray,
                                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                                    )
                                    Text("$20.9", color = Color.Gray, fontWeight = FontWeight.Bold)
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Image(
                                    painter = painterResource(R.drawable.img_16),
                                    contentDescription = "Greek Salad",
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                            HorizontalDivider(
                                thickness = 2.dp,
                                color = Color.Gray
                            )
                            Card(
                                onClick = {
                                    imageName="img_17"
                                    title="Macaroni"
                                    price="$26.05"
                                    navController.navigate(Order.route)},
                                colors = CardDefaults.cardColors(Color.Gray),
                                shape = RectangleShape
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth().background(Color.White)
                                        .padding(8.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.width(300.dp)
                                            .padding(end = 10.dp).clickable {}) {
                                        Text(
                                            "Macaroni",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            androidx.compose.ui.res.stringResource(R.string.content),
                                            color = Color.Gray,
                                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                                        )
                                        Text(
                                            "$26.05",
                                            color = Color.Gray,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                    Image(
                                        painter = painterResource(R.drawable.img_17),
                                        contentDescription = "Greek Salad",
                                        modifier = Modifier.size(100.dp)
                                    )
                                }
                                HorizontalDivider(
                                    thickness = 2.dp,
                                    color = Color.Gray
                                )
                                Card(
                                    onClick = {
                                        imageName="img_20"
                                        title="Double Cheese Pasta"
                                        price="$15.5"
                                        navController.navigate(Order.route)},
                                    colors = CardDefaults.cardColors(Color.Gray),
                                    shape = RectangleShape
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth().background(Color.White)
                                            .padding(8.dp)
                                    ) {
                                        Column(
                                            modifier = Modifier.width(300.dp)
                                                .padding(end = 10.dp).clickable {}) {
                                            Text(
                                                "Double Cheese Pasta",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Text(
                                                androidx.compose.ui.res.stringResource(R.string.content),
                                                color = Color.Gray,
                                                modifier = Modifier.padding(
                                                    top = 5.dp,
                                                    bottom = 5.dp
                                                )
                                            )
                                            Text(
                                                "$15.5",
                                                color = Color.Gray,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                        Spacer(modifier = Modifier.weight(1f))
                                        Image(
                                            painter = painterResource(R.drawable.img_20),
                                            contentDescription = "Greek Salad",
                                            modifier = Modifier.size(100.dp)
                                        )
                                    }
                                    HorizontalDivider(
                                        thickness = 2.dp,
                                        color = Color.Gray
                                    )
                                    Card(
                                        onClick = {
                                            imageName="img_18"
                                            title="Green Pasta"
                                            price="$18.5"
                                            navController.navigate(Order.route)},
                                        colors = CardDefaults.cardColors(Color.Gray),
                                        shape = RectangleShape
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth()
                                                .background(Color.White)
                                                .padding(8.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier.width(300.dp)
                                                    .padding(end = 10.dp).clickable {}) {
                                                Text(
                                                    "Green Pasta",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold
                                                )
                                                Text(
                                                    androidx.compose.ui.res.stringResource(R.string.content),
                                                    color = Color.Gray,
                                                    modifier = Modifier.padding(
                                                        top = 5.dp,
                                                        bottom = 5.dp
                                                    )
                                                )
                                                Text(
                                                    "$18.5",
                                                    color = Color.Gray,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            }
                                            Spacer(modifier = Modifier.weight(1f))
                                            Image(
                                                painter = painterResource(R.drawable.img_18),
                                                contentDescription = "Greek Salad",
                                                modifier = Modifier.size(100.dp)
                                            )
                                        }
                                        HorizontalDivider(
                                            thickness = 2.dp,
                                            color = Color.Gray
                                        )
                                        Card(
                                            onClick = {
                                                imageName="img_19"
                                                title="Veggie Pasta"
                                                price="$7.50"
                                                description="The famous Greek Salad of crispy lettuce, peppers, olives"
                                                navController.navigate(Order.route)},
                                            colors = CardDefaults.cardColors(Color.Gray),
                                            shape = RectangleShape
                                        ) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth()
                                                    .background(Color.White)
                                                    .padding(8.dp)
                                            ) {
                                                Column(
                                                    modifier = Modifier.width(300.dp)
                                                        .padding(end = 10.dp).clickable {}) {
                                                    Text(
                                                        "Veggie Pasta",
                                                        fontSize = 18.sp,
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                    Text(
                                                        androidx.compose.ui.res.stringResource(R.string.content),
                                                        color = Color.Gray,
                                                        modifier = Modifier.padding(
                                                            top = 5.dp,
                                                            bottom = 5.dp
                                                        )
                                                    )
                                                    Text(
                                                        "$7.50",
                                                        color = Color.Gray,
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                }
                                                Spacer(modifier = Modifier.weight(1f))
                                                Image(
                                                    painter = painterResource(R.drawable.img_19),
                                                    contentDescription = "Greek Salad",
                                                    modifier = Modifier.size(100.dp)
                                                )
                                            }
                                            HorizontalDivider(
                                                thickness = 2.dp,
                                                color = Color.Gray
                                            )
                                            Card(
                                                colors = CardDefaults.cardColors(Color.Gray),
                                                shape = RectangleShape
                                            ) {
                                                Row(
                                                    modifier = Modifier.fillMaxWidth()
                                                        .background(Color.White)
                                                        .padding(8.dp)
                                                ) {
                                                    Column(
                                                        modifier = Modifier.width(300.dp)
                                                            .padding(end = 10.dp).clickable {}) {
                                                        Text(
                                                            " ",
                                                            fontSize = 18.sp,
                                                            fontWeight = FontWeight.Bold
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Panel3c(navController: NavHostController) {
        HorizontalDivider(
            thickness = 2.dp,
            color = Color.Gray
        )
        LazyColumn(modifier = Modifier.fillMaxWidth().padding()) {
            item {
                Card(
                    onClick = {
                        imageName="img_21"
                        title="Margherita Pizza"
                        price="$16.27"
                        navController.navigate(Order.route)},
                    colors = CardDefaults.cardColors(Color.Gray),
                    shape = RectangleShape
                ) {
                    Row(modifier = Modifier.fillMaxWidth().background(Color.White).padding(8.dp)) {
                        Column(
                            modifier = Modifier.width(300.dp)
                                .padding(end = 10.dp).clickable {}) {
                            Text("Margherita Pizza", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                            Text(
                                androidx.compose.ui.res.stringResource(R.string.pasta),
                                color = Color.Gray,
                                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                                fontWeight = FontWeight.Bold
                            )
                            Text("$16.27", color = Color.Gray, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(R.drawable.img_21),
                            contentDescription = "Greek Salad",
                            modifier = Modifier.size(100.dp)
                        )
                    }
                    HorizontalDivider(
                        thickness = 2.dp,
                        color = Color.Gray
                    )
                    Card(
                        onClick = {
                            imageName="img_22"
                            title="Corn Pizza"
                            price="$19.02"
                            navController.navigate(Order.route)},
                        colors = CardDefaults.cardColors(Color.Gray),
                        shape = RectangleShape
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().background(Color.White).padding(8.dp)
                        ) {
                            Column(
                                modifier = Modifier.width(300.dp)
                                    .padding(end = 10.dp).clickable {}) {
                                Text(
                                    "Corn Pizza",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    androidx.compose.ui.res.stringResource(R.string.content),
                                    color = Color.Gray,
                                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                                )
                                Text("$19.02", color = Color.Gray, fontWeight = FontWeight.Bold)
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Image(
                                painter = painterResource(R.drawable.img_22),
                                contentDescription = "Greek Salad",
                                modifier = Modifier.size(100.dp)
                            )
                        }
                        HorizontalDivider(
                            thickness = 2.dp,
                            color = Color.Gray
                        )
                        Card(
                            onClick = {
                                imageName="img_23"
                                title="Veggie Pizza"
                                price="$20.0"
                                description="The famous Greek Salad of crispy lettuce, peppers, olives"
                                navController.navigate(Order.route)},
                            colors = CardDefaults.cardColors(Color.Gray),
                            shape = RectangleShape
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth().background(Color.White)
                                    .padding(8.dp)
                            ) {
                                Column(
                                    modifier = Modifier.width(300.dp)
                                        .padding(end = 10.dp).clickable {}) {
                                    Text(
                                        "Veggie Pizza",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        androidx.compose.ui.res.stringResource(R.string.content),
                                        color = Color.Gray,
                                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                                    )
                                    Text("$20.0", color = Color.Gray, fontWeight = FontWeight.Bold)
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Image(
                                    painter = painterResource(R.drawable.img_23),
                                    contentDescription = "Greek Salad",
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                            HorizontalDivider(
                                thickness = 2.dp,
                                color = Color.Gray
                            )
                            Card(
                                onClick = {
                                    imageName="img_24"
                                    title="Italian Pizza"
                                    price="$24.95"
                                    description="The famous Greek Salad of crispy lettuce, peppers, olives"
                                    navController.navigate(Order.route)},
                                colors = CardDefaults.cardColors(Color.Gray),
                                shape = RectangleShape
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth().background(Color.White)
                                        .padding(8.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.width(300.dp)
                                            .padding(end = 10.dp).clickable {}) {
                                        Text(
                                            "Italian Pizza",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            androidx.compose.ui.res.stringResource(R.string.content),
                                            color = Color.Gray,
                                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                                        )
                                        Text(
                                            "$24.95",
                                            color = Color.Gray,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                    Image(
                                        painter = painterResource(R.drawable.img_24),
                                        contentDescription = "Greek Salad",
                                        modifier = Modifier.size(100.dp)
                                    )
                                }
                                HorizontalDivider(
                                    thickness = 2.dp,
                                    color = Color.Gray
                                )
                                Card(
                                    onClick = {
                                        imageName="img_25"
                                        title="Cheese Pizza"
                                        price="$26.5"
                                        navController.navigate(Order.route)},
                                    colors = CardDefaults.cardColors(Color.Gray),
                                    shape = RectangleShape
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth().background(Color.White)
                                            .padding(8.dp)
                                    ) {
                                        Column(
                                            modifier = Modifier.width(300.dp)
                                                .padding(end = 10.dp).clickable {}) {
                                            Text(
                                                "Cheese Pizza",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Text(
                                                androidx.compose.ui.res.stringResource(R.string.content),
                                                color = Color.Gray,
                                                modifier = Modifier.padding(
                                                    top = 5.dp,
                                                    bottom = 5.dp
                                                )
                                            )
                                            Text(
                                                "$26.5",
                                                color = Color.Gray,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                        Spacer(modifier = Modifier.weight(1f))
                                        Image(
                                            painter = painterResource(R.drawable.img_25),
                                            contentDescription = "Greek Salad",
                                            modifier = Modifier.size(100.dp)
                                        )
                                    }
                                    HorizontalDivider(
                                        thickness = 2.dp,
                                        color = Color.Gray
                                    )
                                    Card(
                                        onClick = {
                                            imageName="img_26"
                                            title="Masala Pasta"
                                            price="$14.50"
                                            navController.navigate(Order.route)},
                                        colors = CardDefaults.cardColors(Color.Gray),
                                        shape = RectangleShape
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth()
                                                .background(Color.White)
                                                .padding(8.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier.width(300.dp)
                                                    .padding(end = 10.dp).clickable {}) {
                                                Text(
                                                    "Masala Pasta",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold
                                                )
                                                Text(
                                                    androidx.compose.ui.res.stringResource(R.string.content),
                                                    color = Color.Gray,
                                                    modifier = Modifier.padding(
                                                        top = 5.dp,
                                                        bottom = 5.dp
                                                    )
                                                )
                                                Text(
                                                    "$14.50",
                                                    color = Color.Gray,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            }
                                            Spacer(modifier = Modifier.weight(1f))
                                            Image(
                                                painter = painterResource(R.drawable.img_26),
                                                contentDescription = "Greek Salad",
                                                modifier = Modifier.size(100.dp)
                                            )
                                        }
                                        HorizontalDivider(
                                            thickness = 2.dp,
                                            color = Color.Gray
                                        )
                                        Card(
                                            onClick = {
                                                imageName="img_27"
                                                title="Spicy pizza"
                                                price="$17.50"
                                                navController.navigate(Order.route)},
                                            colors = CardDefaults.cardColors(Color.Gray),
                                            shape = RectangleShape
                                        ) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth()
                                                    .background(Color.White)
                                                    .padding(8.dp)
                                            ) {
                                                Column(
                                                    modifier = Modifier.width(300.dp)
                                                        .padding(end = 10.dp).clickable {}) {
                                                    Text(
                                                        "Spicy pizza",
                                                        fontSize = 18.sp,
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                    Text(
                                                        androidx.compose.ui.res.stringResource(R.string.content),
                                                        color = Color.Gray,
                                                        modifier = Modifier.padding(
                                                            top = 5.dp,
                                                            bottom = 5.dp
                                                        )
                                                    )
                                                    Text(
                                                        "$17.50",
                                                        color = Color.Gray,
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                }
                                                Spacer(modifier = Modifier.weight(1f))
                                                Image(
                                                    painter = painterResource(R.drawable.img_27),
                                                    contentDescription = "Greek Salad",
                                                    modifier = Modifier.size(100.dp)
                                                )
                                            }
                                            HorizontalDivider(
                                                thickness = 2.dp,
                                                color = Color.Gray
                                            )
                                            Card(
                                                colors = CardDefaults.cardColors(Color.Gray),
                                                shape = RectangleShape
                                            ) {
                                                Row(
                                                    modifier = Modifier.fillMaxWidth()
                                                        .background(Color.White)
                                                        .padding(8.dp)
                                                ) {
                                                    Column(
                                                        modifier = Modifier.width(300.dp)
                                                            .padding(end = 10.dp).clickable {}) {
                                                        Text(
                                                            " ",
                                                            fontSize = 18.sp,
                                                            fontWeight = FontWeight.Bold
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Panel3d(navController: NavHostController) {
        HorizontalDivider(
            thickness = 2.dp,
            color = Color.Gray
        )
        LazyColumn(modifier = Modifier.fillMaxWidth().padding()) {
            item {
                Card(
                    onClick = {imageName="img_28"
                               title="Masala Fries"
                               price="10.07"
                               description="The famous Greek Salad of crispy lettuce, peppers, olives"
                        navController.navigate(Order.route)},
                    colors = CardDefaults.cardColors(Color.Gray),
                    shape = RectangleShape
                ) {
                    Row(modifier = Modifier.fillMaxWidth().
                    background(Color.White).padding(8.dp)) {
                        Column(
                            modifier = Modifier.width(300.dp)
                                .padding(end = 10.dp).clickable {}) {
                            Text(
                                "Masala Fries",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                androidx.compose.ui.res.stringResource(R.string.pasta),
                                color = Color.Gray,
                                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                                fontWeight = FontWeight.Bold
                            )
                            Text("$10.07", color = Color.Gray, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(R.drawable.img_28),
                            contentDescription = "Greek Salad",
                            modifier = Modifier.size(100.dp)
                        )
                    }
                    HorizontalDivider(
                        thickness = 2.dp,
                        color = Color.Gray
                    )
                    Card(
                        onClick = {imageName="img_29"
                            title="Staffed Fries"
                            price="$15.02"
                            description="The famous Greek Salad of crispy lettuce, peppers, olives"
                            navController.navigate(Order.route)},
                        colors = CardDefaults.cardColors(Color.Gray),
                        shape = RectangleShape
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().background(Color.White).padding(8.dp)
                        ) {
                            Column(
                                modifier = Modifier.width(300.dp)
                                    .padding(end = 10.dp).clickable {}) {
                                Text(
                                    "Staffed Fries",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    androidx.compose.ui.res.stringResource(R.string.content),
                                    color = Color.Gray,
                                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                                )
                                Text("$15.02", color = Color.Gray, fontWeight = FontWeight.Bold)
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Image(
                                painter = painterResource(R.drawable.img_29),
                                contentDescription = "Greek Salad",
                                modifier = Modifier.size(100.dp)
                            )
                        }
                        HorizontalDivider(
                            thickness = 2.dp,
                            color = Color.Gray
                        )
                        Card(
                            onClick = {imageName="img_30"
                                title="Salted Fries"
                                price="$9.01"
                                navController.navigate(Order.route)},
                            colors = CardDefaults.cardColors(Color.Gray),
                            shape = RectangleShape
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth().background(Color.White)
                                    .padding(8.dp)
                            ) {
                                Column(
                                    modifier = Modifier.width(300.dp)
                                        .padding(end = 10.dp).clickable {}) {
                                    Text(
                                        "Salted Fries",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        androidx.compose.ui.res.stringResource(R.string.content),
                                        color = Color.Gray,
                                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                                    )
                                    Text("$9.01", color = Color.Gray, fontWeight = FontWeight.Bold)
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Image(
                                    painter = painterResource(R.drawable.img_30),
                                    contentDescription = "Greek Salad",
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                            HorizontalDivider(
                                thickness = 2.dp,
                                color = Color.Gray
                            )
                            Card(
                                onClick = {imageName="img_31"
                                    title="Spicy Fries"
                                    price="$13.95"
                                    description="The famous Greek Salad of crispy lettuce, peppers, olives"
                                    navController.navigate(Order.route)},
                                colors = CardDefaults.cardColors(Color.Gray),
                                shape = RectangleShape
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth().background(Color.White)
                                        .padding(8.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.width(300.dp)
                                            .padding(end = 10.dp).clickable {}) {
                                        Text(
                                            "Spicy Fries",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            androidx.compose.ui.res.stringResource(R.string.content),
                                            color = Color.Gray,
                                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                                        )
                                        Text(
                                            "$13.95",
                                            color = Color.Gray,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                    Image(
                                        painter = painterResource(R.drawable.img_31),
                                        contentDescription = "Greek Salad",
                                        modifier = Modifier.size(100.dp)
                                    )
                                }
                                HorizontalDivider(
                                    thickness = 2.dp,
                                    color = Color.Gray
                                )
                                Card(
                                    onClick = {imageName="img_32"
                                        title="Cheesy Fries"
                                        price= "$16.50"
                                        navController.navigate(Order.route)},
                                    colors = CardDefaults.cardColors(Color.Gray),
                                    shape = RectangleShape
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth().background(Color.White)
                                            .padding(8.dp)
                                    ) {
                                        Column(
                                            modifier = Modifier.width(300.dp)
                                                .padding(end = 10.dp).clickable {}) {
                                            Text(
                                                "Cheesy Fries",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Text(
                                                androidx.compose.ui.res.stringResource(R.string.content),
                                                color = Color.Gray,
                                                modifier = Modifier.padding(
                                                    top = 5.dp,
                                                    bottom = 5.dp
                                                )
                                            )
                                            Text(
                                                "$16.50",
                                                color = Color.Gray,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                        Spacer(modifier = Modifier.weight(1f))
                                        Image(
                                            painter = painterResource(R.drawable.img_32),
                                            contentDescription = "Greek Salad",
                                            modifier = Modifier.size(100.dp)
                                        )
                                    }
                                    HorizontalDivider(
                                        thickness = 2.dp,
                                        color = Color.Gray
                                    )
                                    Card( onClick = {imageName="img_33"
                                        title= "Veg Fries"
                                        price= "$15.90"
                                        navController.navigate(Order.route)},
                                        colors = CardDefaults.cardColors(Color.Gray),
                                        shape = RectangleShape
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth()
                                                .background(Color.White)
                                                .padding(8.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier.width(300.dp)
                                                    .padding(end = 10.dp).clickable {}) {
                                                Text(
                                                    "Veg Fries",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold
                                                )
                                                Text(
                                                    androidx.compose.ui.res.stringResource(R.string.content),
                                                    color = Color.Gray,
                                                    modifier = Modifier.padding(
                                                        top = 5.dp,
                                                        bottom = 5.dp
                                                    )
                                                )
                                                Text(
                                                    "$15.90",
                                                    color = Color.Gray,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            }
                                            Spacer(modifier = Modifier.weight(1f))
                                            Image(
                                                painter = painterResource(R.drawable.img_33),
                                                contentDescription = "Greek Salad",
                                                modifier = Modifier.size(100.dp)
                                            )
                                        }
                                        HorizontalDivider(
                                            thickness = 2.dp,
                                            color = Color.Gray
                                        )
                                        Card(
                                            onClick = {imageName="img_34"
                                                title= "Twisted Fries"
                                                price="$14.5"
                                                navController.navigate(Order.route)},
                                            colors = CardDefaults.cardColors(Color.Gray),
                                            shape = RectangleShape
                                        ) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth()
                                                    .background(Color.White)
                                                    .padding(8.dp)
                                            ) {
                                                Column(
                                                    modifier = Modifier.width(300.dp)
                                                        .padding(end = 10.dp).clickable {}) {
                                                    Text(
                                                        "Twisted Fries",
                                                        fontSize = 18.sp,
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                    Text(
                                                        androidx.compose.ui.res.stringResource(R.string.content),
                                                        color = Color.Gray,
                                                        modifier = Modifier.padding(
                                                            top = 5.dp,
                                                            bottom = 5.dp
                                                        )
                                                    )
                                                    Text(
                                                        "$14.5",
                                                        color = Color.Gray,
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                }
                                                Spacer(modifier = Modifier.weight(1f))
                                                Image(
                                                    painter = painterResource(R.drawable.img_34),
                                                    contentDescription = "Greek Salad",
                                                    modifier = Modifier.size(100.dp)
                                                )
                                            }
                                            HorizontalDivider(
                                                thickness = 2.dp,
                                                color = Color.Gray
                                            )
                                            Card(
                                                colors = CardDefaults.cardColors(Color.Gray),
                                                shape = RectangleShape
                                            ) {
                                                Row(
                                                    modifier = Modifier.fillMaxWidth()
                                                        .background(Color.White)
                                                        .padding(8.dp)
                                                ) {
                                                    Column(
                                                        modifier = Modifier.width(300.dp)
                                                            .padding(end = 10.dp).clickable {}) {
                                                        Text(
                                                            " ",
                                                            fontSize = 18.sp,
                                                            fontWeight = FontWeight.Bold
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Panel3e(navController: NavController) {
        HorizontalDivider(
            thickness = 2.dp,
            color = Color.Gray
        )
        LazyColumn(modifier = Modifier.fillMaxWidth().padding()) {
            item {
                Card(
                    onClick = {imageName="img_35"
                        title= "Spicy Noodles"
                        price="$22.17"
                        navController.navigate(Order.route)},
                    colors = CardDefaults.cardColors(Color.Gray),
                    shape = RectangleShape
                ) {
                    Row(modifier = Modifier.fillMaxWidth().background(Color.White).padding(8.dp)) {
                        Column(
                            modifier = Modifier.width(300.dp)
                                .padding(end = 10.dp).clickable {}) {
                            Text("Spicy Noodles", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                            Text(
                                androidx.compose.ui.res.stringResource(R.string.pasta),
                                color = Color.Gray,
                                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                                fontWeight = FontWeight.Bold
                            )
                            Text("$22.17", color = Color.Gray, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(R.drawable.img_35),
                            contentDescription = "Greek Salad",
                            modifier = Modifier.size(100.dp)
                        )
                    }
                    HorizontalDivider(
                        thickness = 2.dp,
                        color = Color.Gray
                    )
                    Card(
                        onClick = {imageName="img_36"
                            title= "Hakka Noodles"
                            price= "$15.02"
                            navController.navigate(Order.route)},
                        colors = CardDefaults.cardColors(Color.Gray),
                        shape = RectangleShape
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().background(Color.White).padding(8.dp)
                        ) {
                            Column(
                                modifier = Modifier.width(300.dp)
                                    .padding(end = 10.dp).clickable {}) {
                                Text(
                                    "Hakka Noodles",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    androidx.compose.ui.res.stringResource(R.string.content),
                                    color = Color.Gray,
                                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                                )
                                Text("$15.02", color = Color.Gray, fontWeight = FontWeight.Bold)
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Image(
                                painter = painterResource(R.drawable.img_36),
                                contentDescription = "Greek Salad",
                                modifier = Modifier.size(100.dp)
                            )
                        }
                        HorizontalDivider(
                            thickness = 2.dp,
                            color = Color.Gray
                        )
                        Card(
                            onClick = {imageName="img_37"
                                title= "Japanese Noodles"
                                price= "$22.21"
                                navController.navigate(Order.route)},
                            colors = CardDefaults.cardColors(Color.Gray),
                            shape = RectangleShape
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth().background(Color.White)
                                    .padding(8.dp)
                            ) {
                                Column(
                                    modifier = Modifier.width(300.dp)
                                        .padding(end = 10.dp).clickable {}) {
                                    Text(
                                        "Japanese Noodles",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        androidx.compose.ui.res.stringResource(R.string.content),
                                        color = Color.Gray,
                                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                                    )
                                    Text("$22.21", color = Color.Gray, fontWeight = FontWeight.Bold)
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Image(
                                    painter = painterResource(R.drawable.img_37),
                                    contentDescription = "Greek Salad",
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                            HorizontalDivider(
                                thickness = 2.dp,
                                color = Color.Gray
                            )
                            Card(
                                onClick = {imageName="img_38"
                                    title= "Chinese Noodles"
                                    price= "$22.05"
                                    navController.navigate(Order.route)},
                                colors = CardDefaults.cardColors(Color.Gray),
                                shape = RectangleShape
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth().background(Color.White)
                                        .padding(8.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.width(300.dp)
                                            .padding(end = 10.dp).clickable {}) {
                                        Text(
                                            "Chinese Noodles",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            androidx.compose.ui.res.stringResource(R.string.content),
                                            color = Color.Gray,
                                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                                        )
                                        Text(
                                            "$22.05",
                                            color = Color.Gray,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                    Image(
                                        painter = painterResource(R.drawable.img_38),
                                        contentDescription = "Greek Salad",
                                        modifier = Modifier.size(100.dp)
                                    )
                                }
                                HorizontalDivider(
                                    thickness = 2.dp,
                                    color = Color.Gray
                                )
                                Card(
                                    onClick = {imageName="img_39"
                                        title= "Korean Noodles"
                                        price= "$24.58"
                                        navController.navigate(Order.route)},
                                    colors = CardDefaults.cardColors(Color.Gray),
                                    shape = RectangleShape
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth().background(Color.White)
                                            .padding(8.dp)
                                    ) {
                                        Column(
                                            modifier = Modifier.width(300.dp)
                                                .padding(end = 10.dp).clickable {}) {
                                            Text(
                                                "Korean Noodles",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Text(
                                                androidx.compose.ui.res.stringResource(R.string.content),
                                                color = Color.Gray,
                                                modifier = Modifier.padding(
                                                    top = 5.dp,
                                                    bottom = 5.dp
                                                )
                                            )
                                            Text(
                                                "$24.58",
                                                color = Color.Gray,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                        Spacer(modifier = Modifier.weight(1f))
                                        Image(
                                            painter = painterResource(R.drawable.img_39),
                                            contentDescription = "Greek Salad",
                                            modifier = Modifier.size(100.dp)
                                        )
                                    }
                                    HorizontalDivider(
                                        thickness = 2.dp,
                                        color = Color.Gray
                                    )
                                    Card(
                                        onClick = {imageName="img_40"
                                            title= "Desi Masala Noodles"
                                            price= "$25.90"
                                            navController.navigate(Order.route)},
                                        colors = CardDefaults.cardColors(Color.Gray),
                                        shape = RectangleShape
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth()
                                                .background(Color.White)
                                                .padding(8.dp)
                                        ) {
                                            Column(
                                                modifier = Modifier.width(300.dp)
                                                    .padding(end = 10.dp).clickable {}) {
                                                Text(
                                                    "Desi Masala Noodles",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold
                                                )
                                                Text(
                                                    androidx.compose.ui.res.stringResource(R.string.content),
                                                    color = Color.Gray,
                                                    modifier = Modifier.padding(
                                                        top = 5.dp,
                                                        bottom = 5.dp
                                                    )
                                                )
                                                Text(
                                                    "$25.90",
                                                    color = Color.Gray,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            }
                                            Spacer(modifier = Modifier.weight(1f))
                                            Image(
                                                painter = painterResource(R.drawable.img_40),
                                                contentDescription = "Greek Salad",
                                                modifier = Modifier.size(100.dp)
                                            )
                                        }
                                        HorizontalDivider(
                                            thickness = 2.dp,
                                            color = Color.Gray
                                        )
                                        Card(
                                            onClick = {imageName="img_41"
                                                title= "Cheese Corn Noodles"
                                                price= "$24.59"
                                                navController.navigate(Order.route)},
                                            colors = CardDefaults.cardColors(Color.Gray),
                                            shape = RectangleShape
                                        ) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth()
                                                    .background(Color.White)
                                                    .padding(8.dp)
                                            ) {
                                                Column(
                                                    modifier = Modifier.width(300.dp)
                                                        .padding(end = 10.dp).clickable {}) {
                                                    Text(
                                                        "Cheese Corn Noodles",
                                                        fontSize = 18.sp,
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                    Text(
                                                        androidx.compose.ui.res.stringResource(R.string.content),
                                                        color = Color.Gray,
                                                        modifier = Modifier.padding(
                                                            top = 5.dp,
                                                            bottom = 5.dp
                                                        )
                                                    )
                                                    Text(
                                                        "$24.59",
                                                        color = Color.Gray,
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                }
                                                Spacer(modifier = Modifier.weight(1f))
                                                Image(
                                                    painter = painterResource(R.drawable.img_41),
                                                    contentDescription = "Greek Salad",
                                                    modifier = Modifier.size(100.dp)
                                                )
                                            }
                                            HorizontalDivider(
                                                thickness = 2.dp,
                                                color = Color.Gray
                                            )
                                            Card(
                                                colors = CardDefaults.cardColors(Color.Gray),
                                                shape = RectangleShape
                                            ) {
                                                Row(
                                                    modifier = Modifier.fillMaxWidth()
                                                        .background(Color.White)
                                                        .padding(8.dp)
                                                ) {
                                                    Column(
                                                        modifier = Modifier.width(300.dp)
                                                            .padding(end = 10.dp).clickable {}) {
                                                        Text(
                                                            " ",
                                                            fontSize = 18.sp,
                                                            fontWeight = FontWeight.Bold
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
