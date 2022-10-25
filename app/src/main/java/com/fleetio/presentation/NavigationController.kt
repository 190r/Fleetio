package com.fleetio.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fleetio.R
import com.fleetio.presentation.home.HomeScreen
import com.fleetio.presentation.detail.VehicleInfoScreen

@Composable
fun AppNavigationGraph() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        fontSize = 20.sp
                        )
                    },
                backgroundColor = Color(0xFF045B83),
                contentColor = Color.White,
                navigationIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_app_bar_foreground),
                            contentDescription = "Fleetio",
                            tint = Color.White
                        )
                    }
                )
            },
//        bottomBar = {
//           BottomAppBar {
//               val index = remember { mutableStateOf(0) }
//               BottomNavigation {
////                   BottomNavigationItem(selected = , onClick = { /*TODO*/ })
//               }
//           }
//        },
        backgroundColor = Color.White
    ) { pendingValues ->
        Box(modifier = Modifier.padding(pendingValues)) {
            NavHost(
                navController = navController,
                startDestination = Screen.FleetViewScreen.route
            ) {
                composable(
                    route = Screen.FleetViewScreen.route
                ) {
                    HomeScreen(navController = navController)
                }
                composable(
                    route = Screen.VehicleInfoDisplay.route + "/{id}"
                ) {
                    VehicleInfoScreen(navController = navController)
                }
            }
        }
    }
}