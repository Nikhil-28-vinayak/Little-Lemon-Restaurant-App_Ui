package com.example.little_lemon



import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopAppBar1(drawerState: DrawerState?=null, scope: CoroutineScope?=null) {
    var context = LocalContext.current
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().background(Color.White).padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = {
            scope?.launch {
                drawerState?.open()
            }
        }) {
            Icon(
                Icons.Default.Menu,
                contentDescription = "Open drawer",
                modifier = Modifier.size(30.dp)
            )
        }
        Image(
            painterResource(R.drawable.img_2), contentDescription = "Lttle Lemon Logo",
            modifier = Modifier.fillMaxWidth(0.5F).padding(horizontal = 20.dp)
        )
        IconButton(onClick = {
            Toast.makeText(
                context,
                "You click on the button",
                Toast.LENGTH_SHORT
            ).show()
        }) {
            Image(
                painterResource(R.drawable.download),
                contentDescription = "cart",
                modifier = Modifier.size(30.dp)
            )
        }

    }

}
@Composable
fun TopAppBar2(drawerState: DrawerState?=null, scope: CoroutineScope?=null){
    var context = LocalContext.current
    Row(horizontalArrangement =Arrangement.SpaceBetween ,
        modifier = Modifier.fillMaxWidth().background(Color.White).padding(top=15.dp).height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = {
            scope?.launch {
                drawerState?.open()
            }
        }) {
            Icon(Icons.Default.Menu, contentDescription = "Open drawer", modifier = Modifier.size(30.dp))
        }
        Image(painterResource(R.drawable.img_2), contentDescription = "Lttle Lemon Logo",
            modifier = Modifier.width(550.dp).padding(horizontal = 20.dp))
        IconButton( onClick = { Toast.makeText(context,"You click on the button",Toast.LENGTH_SHORT).show() }) {
            Image(painterResource(R.drawable.download),
                contentDescription ="cart",
                modifier = Modifier.size(30.dp)
            )
        }

    }

}
@Preview()
@Composable
fun view(){
    TopAppBar2()
}
