package com.fleetio.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.lazy.items
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.fleetio.R
import com.fleetio.domain.model.CommentItem

@Composable
fun CommentItem(comment: CommentItem) {
    Row(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(comment.userImageUrl)
                .crossfade(true)
                .placeholder(R.mipmap.ic_placeholder_vehicle_large)
                .fallback(R.mipmap.ic_placeholder_vehicle_large)
                .error(R.mipmap.ic_placeholder_vehicle_large)
                .build(),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .size(30.dp, 30.dp),
            contentDescription = comment.userFullName + comment.comment
        )
        Text(text = comment.userFullName, modifier = Modifier.fillMaxWidth())
    }
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = comment.comment,
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp, 0.dp, 0.dp, 0.dp)
    )
}

@Composable
fun VehicleCommentsView() {
    val viewModel: VehicleDetailScreenViewModel = hiltViewModel()
    val commentState = viewModel.userComment.value

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(6.dp, 6.dp, 6.dp, 60.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                items(commentState.userComments) { comment ->
                    CommentItem(comment = comment)
                }
            }
        }

        if (commentState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally),
                color = Color.Green
            )
        }

        if (commentState.apiError.isNotBlank()) {
            Text(text = commentState.apiError)
        }
    }
}
