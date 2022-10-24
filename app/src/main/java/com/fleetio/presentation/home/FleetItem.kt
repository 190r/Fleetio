package com.fleetio.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.fleetio.R
import com.fleetio.common.getVehicles
import com.fleetio.domain.model.VehicleDetail

@Composable
fun FleetItem(
    vehicle: VehicleDetail,
    onItemClick: (VehicleDetail) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(vehicle) }
            .height(160.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 5.dp, 5.dp, 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(vehicle.defaultImageUrlMedium)
                        .crossfade(true)
                        .placeholder(R.mipmap.ic_placeholder_vehicle_large)
                        .fallback(R.mipmap.ic_placeholder_vehicle_large)
                        .error(R.mipmap.ic_placeholder_vehicle_large)
                        .build(),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxHeight(),
                    contentDescription = vehicle.vehicleTypeName
                )
                Column {
                    Text(
                        text = vehicle.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 6.dp, 0.dp, 6.dp)
                            .semantics { contentDescription = vehicle.name },
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp
                    )
                    Divider(modifier = Modifier.fillMaxWidth().padding(12.dp, 0.dp, 12.dp, 8.dp).height(2.dp))
                    val type = stringResource(id = R.string.vehicle_type, vehicle.vehicleTypeName)
                    Text(
                        text = type,
                        modifier = Modifier
                            .padding(20.dp, 0.dp, 0.dp, 4.dp)
                            .semantics { contentDescription = type },
                        textAlign = TextAlign.Start,
                        fontSize = 10.sp
                    )
                    val make = stringResource(id = R.string.vehicle_make, "${vehicle.make ?: R.string.vehicle_unknown}")
                    Text(
                        text = make,
                        modifier = Modifier
                            .padding(20.dp, 0.dp, 0.dp, 4.dp)
                            .semantics { contentDescription = make },
                        textAlign = TextAlign.Start,
                        fontSize = 10.sp
                    )
                    val model = stringResource(id = R.string.vehicle_model, "${vehicle.model ?: R.string.vehicle_unknown}")
                    Text(
                        text = model,
                        modifier = Modifier
                            .padding(20.dp, 0.dp, 0.dp, 4.dp)
                            .semantics { contentDescription = model },
                        textAlign = TextAlign.Start,
                        fontSize = 10.sp
                    )
                    val year = stringResource(id = R.string.vehicle_year, "${vehicle.year ?: R.string.vehicle_unknown}")
                    Text(
                        text = year,
                        modifier = Modifier
                            .padding(20.dp, 0.dp, 0.dp, 4.dp)
                            .semantics { contentDescription = year },
                        textAlign = TextAlign.Start,
                        fontSize = 10.sp
                    )
//                    val vin = stringResource(id = R.string.vehicle_vin, "${vehicle.vin ?: R.string.vehicle_unknown}")
//                    Text(
//                        text = vin,
//                        modifier = Modifier
//                            .padding(20.dp, 0.dp, 0.dp, 4.dp)
//                            .semantics { contentDescription = vin },
//                        textAlign = TextAlign.Start,
//                        fontSize = 10.sp
//                    )
                    val ownership = stringResource(id = R.string.vehicle_ownership_status, "${vehicle.ownership ?: R.string.vehicle_unknown}")
                    Text(
                        text = ownership,
                        modifier = Modifier
                            .padding(20.dp, 0.dp, 0.dp, 4.dp)
                            .semantics { contentDescription = ownership },
                        textAlign = TextAlign.Start,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = false)
@Composable
fun FleetItemPreview() {
    val vehicle = getVehicles(LocalContext.current).let { it[5] }
    FleetItem(vehicle = vehicle, onItemClick = {})
}

