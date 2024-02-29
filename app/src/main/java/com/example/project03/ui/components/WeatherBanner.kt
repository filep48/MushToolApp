package com.example.project03.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project03.viewmodel.ApiWeatherViewModel


@Composable
fun WeatherBanner(viewModel: ApiWeatherViewModel){
    val weatherData by viewModel.weatherData.observeAsState()
    val ubicacion = "Terrassa"

    if(weatherData != null){
        val currentWeather = weatherData!!.current

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.onTertiaryContainer
            ),
            elevation = CardDefaults.cardElevation(1.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 60.dp),
                contentAlignment = Alignment.CenterEnd
            ){
                Icon(
                    imageVector = currentWeather!!.getWeatherIcon(),
                    contentDescription = "ClimaIcono",
                    modifier = Modifier
                        .size(62.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 8.dp)
                        .fillMaxSize()
                ) {
                    Row{
                        Text(
                            text = "${currentWeather?.temperature_2m}" + "º",
                            style = MaterialTheme.typography.headlineMedium,
                            fontSize = 34.sp
                        )
                    }

                    Row{
                        Icon(
                            imageVector = Icons.Rounded.LocationOn,
                            contentDescription = "ubicacion",
                            modifier = Modifier.size(18.dp)
                        )
                        Text(
                            text = ubicacion,
                            fontSize = 18.sp
                        )
                    }

                    Spacer(Modifier.height(10.dp))

                    Text(
                        text = "Sensación térmica: ${currentWeather?.apparent_temperature}" + "º",
                        fontSize = 14.sp
                    )

                    Text(
                        text = "Precipitacion: ${currentWeather?.precipitation}%",
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}