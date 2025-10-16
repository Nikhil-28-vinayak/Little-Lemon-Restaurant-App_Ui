package com.example.little_lemon

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button


import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun LowerPanel() {
    Column {
        WeeklySpecial()
        MenuDish()
    }
}


@Composable
fun WeeklySpecial(){
    Card(modifier = Modifier.fillMaxWidth(), colors =  CardDefaults.cardColors(Color.White),border = BorderStroke(1.dp,Color.Gray), shape = RectangleShape) {
        Text(stringResource(R.string.special), fontSize=26.sp, modifier=Modifier.padding(8.dp).clickable {},
            fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold,)
    }
}


@Composable
fun MenuDish() {
    LazyColumn() {
        item {
            Card(
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RectangleShape
            ) {
                Row(modifier = Modifier.fillMaxWidth().padding(10.dp).clickable {}) {

                    Column(modifier = Modifier.width(300.dp).padding(end = 10.dp).clickable {}) {
                        Text("Greek Salad", fontSize = 18.sp)
                        Text(
                            stringResource(R.string.content),
                            color = Color.Gray,
                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                        )
                        Text("$12.99", color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painterResource(R.drawable.greeksalad),
                        contentDescription = "Greek Salad Image",
                        modifier = Modifier.size(100.dp)
                    )

                }
            }
            Card(
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RectangleShape
            ) {
                Row(modifier = Modifier.fillMaxWidth().padding(10.dp).clickable {}) {

                    Column(modifier = Modifier.width(300.dp).padding(end = 10.dp).clickable {}) {
                        Text("Italian Pasta", fontSize = 18.sp)
                        Text(
                            stringResource(R.string.description2),
                            color = Color.Gray,
                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                        )
                        Text("$20.99", color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painterResource(R.drawable.img_3),
                        contentDescription = "Greek Salad Image",
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
            Card(
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RectangleShape
            ) {
                Row(modifier = Modifier.fillMaxWidth().padding(10.dp).clickable {}) {

                    Column(modifier = Modifier.width(300.dp).padding(end = 10.dp).clickable {}) {
                        Text("Brussels Sprouts ", fontSize = 18.sp)
                        Text(
                            stringResource(R.string.sprouts),
                            color = Color.Gray,
                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                        )
                        Text("$10.00", color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.weight(0.1F).padding(2.dp))
                    Image(
                        painterResource(R.drawable.img_7),
                        contentDescription = "Greek Salad Image",
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
            Card(
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RectangleShape
            ) {
                Row(modifier = Modifier.fillMaxWidth().padding(10.dp).clickable {}) {

                    Column(modifier = Modifier.width(300.dp).padding(end = 10.dp).clickable {}) {
                        Text("French Fries", fontSize = 18.sp)
                        Text(
                            stringResource(R.string.Frechfries),
                            color = Color.Gray,
                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                        )
                        Text("$8.39", color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painterResource(R.drawable.img_4),
                        contentDescription = "Greek Salad Image",
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
            Card(
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RectangleShape
            ) {
                Row(modifier = Modifier.fillMaxWidth().padding(10.dp).clickable {}) {

                    Column(modifier = Modifier.width(300.dp).padding(end = 10.dp).clickable {}) {
                        Text("Spainish Pizza", fontSize = 18.sp)
                        Text(
                            stringResource(R.string.pizza),
                            color = Color.Gray,
                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                        )
                        Text("$18.45", color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painterResource(R.drawable.img_5),
                        contentDescription = "Greek Salad Image",
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
            Card(
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RectangleShape
            ) {
                Row(modifier = Modifier.fillMaxWidth().padding(10.dp).clickable {}) {

                    Column(modifier = Modifier.width(300.dp).padding(end = 10.dp).clickable {}) {
                        Text("Japanese Noodles", fontSize = 18.sp)
                        Text(
                            stringResource(R.string.noodles),
                            color = Color.Gray,
                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                        )
                        Text("$20.50", color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.weight(0.1F).padding(2.dp))
                    Image(
                        painterResource(R.drawable.img_6),
                        contentDescription = "Greek Salad Image",
                        modifier = Modifier.size(100.dp)
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LowerPanelPreview(){
    LowerPanel()
}
