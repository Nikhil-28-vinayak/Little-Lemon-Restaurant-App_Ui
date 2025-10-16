package com.example.little_lemon

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

interface Destination{
    val route:String
    val icon: ImageVector
}
object Login: Destination{
    override val route="Login"
    override val icon= Icons.Filled.Home
}
object SignUp: Destination{
    override val route="SignUp"
    override val icon= Icons.Filled.Home
}
object Home: Destination{
    override val route="Home"
    override val icon= Icons.Filled.Home
}
object MenuList: Destination{
    override val route="MenuList"
    override val icon= Icons.Filled.Menu
}
object Category: Destination{
    override val route="Category"
    override val icon= Icons.Filled.Home
}
object Setting: Destination{
    override val route="Setting"
    override val icon= Icons.Filled.Settings
}
object Order: Destination{
    override val route="Order"
    override val icon= Icons.Filled.Settings
}
