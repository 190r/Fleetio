package com.fleetio.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.fleetio.domain.model.VehicleDetail
import com.fleetio.presentation.HomeScreenViewModel
import com.fleetio.presentation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    val fleetViewModel = hiltViewModel<HomeScreenViewModel>()
    val fleetItems: LazyPagingItems<VehicleDetail> = fleetViewModel.vehicleFleet.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(6.dp, 6.dp, 6.dp, 60.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(fleetItems) { vehicle ->
            vehicle?.let { v ->
                FleetItem(vehicle = v, onItemClick = { navController.navigate( Screen.VehicleInfolDisplay.route + "/${v.id}") })
            }
        }
        fleetItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> item { FullScreenProgressIndicator() }
                loadState.append is LoadState.Loading -> item { LoadingStateIndicator() }
                loadState.append is LoadState.Error -> item {
                    Text(
                        text = "Waiting for items to load from the backend",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}

@Composable
fun LoadingStateIndicator() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally),
        color = Color.Green
    )
}

@Composable
fun FullScreenProgressIndicator() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .wrapContentWidth(Alignment.CenterHorizontally),
            color = Color.Green
        )
    }
}

@Composable
fun ApiErrorDisplay() {

}

@Preview(showBackground = true, showSystemUi = true )
@Composable
fun ProgressBarPreview() {
    FullScreenProgressIndicator()
}
