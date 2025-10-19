package com.example.little_lemon

import DrawerPanel
import android.content.res.Configuration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController


@Composable
fun Main(navController: NavHostController) {

    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            HomeScreen2(navController)
        }

        else -> {
              HomeScreen1(navController)
        }
    }
}

    @Composable
    fun HomeScreen1(navController: NavHostController) {
        val drawerState =
            rememberDrawerState(initialValue = DrawerValue.Closed)//create a drawerstate
        val snackbarHostState = remember { SnackbarHostState() }//create snackbarhoststate
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
                snackbarHost = {
                    SnackbarHost(hostState = snackbarHostState)
                },
                content = { padding ->
                    Column(modifier = Modifier.padding(padding)) {
                        UpperPanel1(snackbarHostState, scope, navController)
                        LowerPanel(navController)
                    }
                }
            )
        }
    }

    @Composable
    fun HomeScreen2(navController: NavHostController) {
        val drawerState =
            rememberDrawerState(initialValue = DrawerValue.Closed)//create a drawerstate
        val snackbarHostState = remember { SnackbarHostState() }//create snackbarhoststate
        val scope = rememberCoroutineScope()//create a coroutine

        ModalNavigationDrawer(//create a drawer
            drawerState = drawerState,//used to check whether drawer is open or not
            drawerContent = {//content of the drawer
                DrawerPanel(drawerState, scope)
            }
        ) {
            Scaffold(
                topBar = {
                    TopAppBar2(drawerState, scope)
                },
                snackbarHost = {//place for snackbar
                    SnackbarHost(hostState = snackbarHostState)
                },
                content = { padding ->
                    Row(modifier = Modifier.padding(padding)) {
                        UpperPanel2(snackbarHostState, scope,navController)
                        LowerPanel(navController)
                    }
                }
            )
        }
    }

    @Preview()
    @Composable
    fun preview() {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()
        DrawerPanel(drawerState, scope)
    }

