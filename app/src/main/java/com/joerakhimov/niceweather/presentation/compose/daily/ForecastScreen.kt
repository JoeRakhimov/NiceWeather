package com.joerakhimov.niceweather.presentation.compose.daily

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.joerakhimov.niceweather.presentation.model.DailyItemModel
import com.joerakhimov.niceweather.presentation.compose.components.NoNetwork

@Composable
fun ForecastScreen(
    onUserClick: (String) -> Unit
) {
    val viewModel = hiltViewModel<DailyForecastViewModel>()
    val uiState = viewModel.uiState

    if (uiState.offline) {
        NoNetwork()
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            items(uiState.dailyForecast) { item ->
                DayForecast(item = item, onUserClick = onUserClick)
            }
        }
    }
}

@Composable
fun DayForecast(item: DailyItemModel, onUserClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onUserClick(item.date) }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .size(40.dp),
            model = item.icon,
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = item.date,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "${item.tempMin}/${item.tempMax}",
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
