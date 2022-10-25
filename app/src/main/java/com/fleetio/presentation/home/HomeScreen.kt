package com.fleetio.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.fleetio.domain.model.VehicleDetail
import com.fleetio.presentation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    val fleetViewModel = hiltViewModel<HomeScreenViewModel>()
    val fleetItems: LazyPagingItems<VehicleDetail> = fleetViewModel.vehiclesPagedFlow.collectAsLazyPagingItems()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(6.dp, 6.dp, 6.dp, 60.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(fleetItems) { vehicle ->
                vehicle?.let { v ->
                    FleetItem(
                        vehicle = v,
                        onItemClick = { navController.navigate(Screen.VehicleInfoDisplay.route + "/${v.id}") })
                }
            }
            fleetItems.apply {
                when {
                    loadState.refresh is LoadState.Loading -> item { FullScreenProgressIndicator(modifier = Modifier.fillParentMaxSize()) }
                    loadState.append is LoadState.Loading -> item { PageLoadingIndicator() }
                    loadState.append is LoadState.Error -> item {
                        val errorMessage = fleetItems.loadState.append as LoadState.Error
                        errorMessage.error.localizedMessage?.let { PageLoadingError(errorMessage = it) }
                    }
                    loadState.refresh is LoadState.Error -> item {
                        val errorMessage = fleetItems.loadState.refresh as LoadState.Error
                        errorMessage.error.localizedMessage?.let { PageLoadingError(errorMessage = it) }
                    }
                }
            }
        }
    }
}

@Composable
fun FullScreenProgressIndicator(modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(80.dp, 80.dp),
            color = Color.Green
        )
    }
}

@Composable
fun PageLoadingIndicator() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentWidth(Alignment.CenterHorizontally),
        color = Color.Green
    )
}

@Composable
fun PageLoadingError(
    errorMessage: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = errorMessage,
            maxLines = 1,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.h6,
            color = Color.Red
        )
    }
}
