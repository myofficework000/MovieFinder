package abhishek.pathak.moviefiner.hilt.view

import abhishek.pathak.moviefiner.R
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController

@Composable
fun MyBottomBarUI(navController: NavController) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        contentColor = Color.Black
    ) {
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.baseline_add_home_24), contentDescription = "Home") },
            label = { Text(stringResource(id = R.string.welcome))},
            selected = true,
            onClick = { navController.navigate(BottomRoutes.Screen1.route)}
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.baseline_favorite_24), contentDescription = "Favorites") },
            label = { Text(stringResource(id = R.string.favourites))},
            selected = false,
            onClick = {navController.navigate(BottomRoutes.Screen2.route)}
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.baseline_emoji_people_24), contentDescription = "Profile") },
            label = { Text(stringResource(id = R.string.Profile))},
            selected = false,
            onClick = {navController.navigate(BottomRoutes.Screen3.route) }
        )
    }
}
sealed class BottomRoutes(val route: String)
{
    object Screen1:BottomRoutes("Home")
    object Screen2:BottomRoutes("Favourites")
    object Screen3:BottomRoutes("Profile")

}