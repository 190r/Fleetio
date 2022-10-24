package com.fleetio.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.fleetio.R
import com.fleetio.common.getVehicles
import com.fleetio.domain.model.Specs
import com.fleetio.domain.model.VehicleDetail
import com.fleetio.presentation.VehicleDetailScreenViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun VehicleInfoScreen(
    navController: NavController,
    viewModel: VehicleDetailScreenViewModel = hiltViewModel()
) {
    val vehicleState = viewModel.vehicle.value
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp, 8.dp, 8.dp, 8.dp)) {

        vehicleState.vehicle?.let { vehicle ->
           VehicleInfoDisplay(vehicle)
        }

        // API Error display
        if (vehicleState.apiError.isNotBlank()) {
            Text(
                text = vehicleState.apiError,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        // Progress Bar display
        if (vehicleState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.Green
            )
        }
    }
}

@Composable
fun VehicleInfoDisplay(
    vehicle: VehicleDetail
) {
    Column(modifier = Modifier.fillMaxSize()) {
        val vInfo = stringResource(id = R.string.vehicle_info_page_title, vehicle.name)
        Text(
            text = vInfo,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 4.dp)
                .semantics { contentDescription = vInfo },
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )

        // Vehicle Photo & Specs
        VehicleSpecs(specs = vehicle.specs, imageUrl = vehicle.defaultImageUrlLarge)
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))
        // Map View
        SetGeolocationData(vehicle = vehicle)
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))
        // Comments View
        VehicleCommentsView()
    }
}

@Composable
fun VehicleLocationMap(lat: Double, lng: Double, address: String?) {
    val mapProps = remember {
        mutableStateOf(
            MapProperties(maxZoomPreference = 10f, minZoomPreference = 5f)
        )
    }
    val mapUiProps = remember {
        mutableStateOf(
            MapUiSettings(mapToolbarEnabled = false)
        )
    }

    val vehicleLocation = LatLng(lat, lng)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(vehicleLocation, 10f)
    }

    GoogleMap(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth(),
        cameraPositionState = cameraPositionState,
        properties = mapProps.value,
        uiSettings = mapUiProps.value
    ) {
        Marker(
            state = MarkerState(position = LatLng(lat, lng)),
            title = address
        )
    }

}

@Composable
fun VehicleSpecs(specs: Specs, imageUrl: String?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .placeholder(R.mipmap.ic_placeholder_vehicle_large)
                        .fallback(R.mipmap.ic_placeholder_vehicle_large)
                        .error(R.mipmap.ic_placeholder_vehicle_large)
                        .build(),
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .align(Alignment.CenterVertically)
                        .size(180.dp, 180.dp),
                    contentDescription = specs.createdAt
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .padding(4.dp, 0.dp, 0.dp, 4.dp)
                ) {
                    val engine = stringResource(id = R.string.vehicle_engine, specs.engineBrand)
                    Text(
                        text = engine,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 2.dp)
                            .semantics { contentDescription = engine },
                        textAlign = TextAlign.Start,
                        fontSize = 10.sp
                    )
                    val fuel = stringResource(
                        id = R.string.vehicle_fuel,
                        specs.fuelQuality)
                    Text(
                        text = fuel,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 2.dp)
                            .semantics { contentDescription = fuel },
                        textAlign = TextAlign.Start,
                        fontSize = 10.sp
                    )
                    val weight = stringResource(
                        id = R.string.vehicle_weight_rating,
                        "${specs.grossVehicleWeightRating}"
                    )
                    Text(
                        text = weight,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 2.dp)
                            .semantics { contentDescription = weight },
                        textAlign = TextAlign.Start,
                        fontSize = 10.sp
                    )
                    val cylinders = stringResource(
                        id = R.string.vehicle_engine_cylinders,
                        "${specs.engineCylinders}")
                    Text(
                        text = cylinders,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 2.dp)
                            .semantics { contentDescription = cylinders },
                        textAlign = TextAlign.Start,
                        fontSize = 10.sp
                    )
                    val engineBrand = stringResource(
                        id = R.string.vehicle_engine_brand,
                        specs.engineBrand
                    )
                    Text(
                        text = engineBrand,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 2.dp)
                            .semantics { contentDescription = engineBrand },
                        textAlign = TextAlign.Start,
                        fontSize = 10.sp
                    )
                    val passengerVolume = stringResource(
                        id = R.string.vehicle_passenger_volume,
                        specs.passengerVolume
                    )
                    Text(
                        text = passengerVolume,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 2.dp)
                            .semantics { contentDescription = passengerVolume },
                        textAlign = TextAlign.Start,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}

@Composable
fun SetGeolocationData(vehicle: VehicleDetail) {
    vehicle.currentLocationEntry?.let { currentLoc ->
        currentLoc.geolocation?.let { geoloc ->
            val latitude = geoloc.latitude
            val longitude = geoloc.longitude

            if (latitude != null && longitude != null) {
                val address = currentLoc.address
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp),
                    elevation = 10.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    // Vehicle Address Display
                    Column {
                        VehicleLocationMap(latitude, longitude, address)
                        Spacer(modifier = Modifier
                            .fillMaxWidth()
                            .height(10.dp))
                        address?.let {
                            val addr = stringResource(id = R.string.vehicle_address, it)
                            Text(
                                text = addr,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .semantics { contentDescription = addr },
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun VehicleCommentsView() {
    val viewModel: VehicleDetailScreenViewModel = hiltViewModel()
    val commentState = viewModel.userComment.value

    commentState.userComment?.let { commentText ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp),
            elevation = 10.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Box {
                Text(text = commentText.comment, modifier = Modifier.fillMaxSize())
                if (commentState.apiError.isNotBlank()) {
                    Text(
                        text = commentState.apiError,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)
                    )
                }
                if (commentState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = Color.Green
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VehicleDisplayPreview() {
    val vehicle = getVehicles(LocalContext.current).let { it[5] }
    VehicleInfoDisplay(vehicle)
}

