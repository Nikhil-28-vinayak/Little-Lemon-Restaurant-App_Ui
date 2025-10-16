package com.example.little_lemon


import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomBar(navController: NavHostController) {
    var destinationList = listOf<Destination>(
        Home,
        MenuList,
        Setting
    )
    var state by rememberSaveable { mutableStateOf(0) }
    BottomNavigation(contentColor = Color(0xFFF4CE14)) {
        destinationList.forEachIndexed { index, destination ->
            BottomNavigationItem(
                label = { Text(destination.route, color = Color.White) },
                icon = { Icon(destination.icon, contentDescription = null ) },
                modifier = Modifier.background(Color(0xFF495E57)),
                selected = index ==  state,
                onClick = {
                    state = index
                    navController.navigate(destination.route)},
            )
        }
    }
}
@Preview
@Composable
fun see(){
    val navController = rememberNavController()
    BottomBar(navController)
}
