import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerPanel(drawerState: DrawerState, scope: CoroutineScope) {
    Column (modifier = Modifier.background(Color.White)){
        for(i in 1..10){
            Text(
                text = "Item #$i",
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
            )
            IconButton(onClick = {
                scope.launch { drawerState.close() }
            }) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "Close Icon"
                )
            }
        }
    }
}
