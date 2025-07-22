package me.sachinsinghdighan.presentation.cityalertdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson
import me.sachinsinghdighan.domain.model.wheather.WeatherAlertItem
import me.sachinsinghdighan.domain.model.wheather.WeatherAlertLocation
import java.net.URLDecoder

@Composable
fun CityAlertDetailScreenRoute(navController: NavController) {
    val backStackEntry = navController.currentBackStackEntry
    val alertJson = backStackEntry?.arguments?.getString("alertJson")
    val alert: WeatherAlertItem? = alertJson?.let {
        try {
            Gson().fromJson(URLDecoder.decode(it, "UTF-8"), WeatherAlertItem::class.java)
        } catch (e: Exception) { null }
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        CityAlertDetailScreenLayout(
            alerts = if (alert != null) listOf(alert) else emptyList(),
            innerPadding = innerPadding
        )
    }
}

@Composable
fun CityAlertDetailScreenLayout(
    location: WeatherAlertLocation? = null,
    alerts: List<WeatherAlertItem> = emptyList(),
    innerPadding: PaddingValues = PaddingValues(56.dp)
) {
    Column(modifier = Modifier.padding(innerPadding).padding(top = 16.dp)) {
        // Location Info
        if (location != null) {
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD)),
                elevation = CardDefaults.cardElevation(2.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFE3F2FD))
                    .padding(bottom = 12.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "City: ${location.name ?: "--"}, ${location.country ?: "--"}",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = Color(0xFF1976D2),
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                    Text(
                        text = "Region: ${location.region ?: "--"}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF333333),
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                    Text(
                        text = "Local Time: ${location.localtime ?: "--"}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF333333)
                    )
                }
            }
        }
        // Alerts
        if (alerts.isNotEmpty()) {
            Text(
                text = "City Alerts",
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFFD32F2F),
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                alerts.forEach { alert ->
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF3E0)),
                        elevation = CardDefaults.cardElevation(6.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFFFFF3E0))
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Filled.Warning,
                                    contentDescription = "Alert",
                                    tint = Color(0xFFD32F2F),
                                    modifier = Modifier.padding(end = 12.dp)
                                )
                                Text(
                                    text = alert.headline ?: "Alert",
                                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                    color = Color(0xFFD32F2F),
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Event: ${alert.event ?: "--"}",
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                                color = Color(0xFF333333)
                            )
                            Text(
                                text = "Severity: ${alert.severity ?: "--"} | Urgency: ${alert.urgency ?: "--"}",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFFB71C1C)
                            )
                            Text(
                                text = "Areas: ${alert.areas ?: "--"}",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFF333333)
                            )
                            Text(
                                text = "Effective: ${alert.effective ?: "--"}",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFF333333)
                            )
                            Text(
                                text = "Expires: ${alert.expires ?: "--"}",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFF333333)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = alert.desc ?: "",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFF333333),
                                maxLines = 6,
                                overflow = TextOverflow.Ellipsis
                            )
                            if (!alert.instruction.isNullOrBlank()) {
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = "Instruction: ${alert.instruction}",
                                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium),
                                    color = Color(0xFF1976D2)
                                )
                            }
                        }
                    }
                }
            }
        } else {
            Text(
                text = "No active city alerts.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CityAlertDetailScreenLayoutPreview(){
    CityAlertDetailScreenLayout()
}