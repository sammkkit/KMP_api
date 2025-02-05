package org.example.assignment.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
//import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.ktor.http.ContentType.Text.Html

@Composable
fun BreachItem(breach: Breach) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
//        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = breach.Title,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Domain: ${breach.Domain}",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Breach Date: ${breach.BreachDate}",
                style = MaterialTheme.typography.body1,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            val descriptionWithoutAnchor = extractAnchorText(breach.Description)
            Text(
                text = descriptionWithoutAnchor,
                style = MaterialTheme.typography.body2
            )
        }
    }
}
fun extractAnchorText(html: String): String {
    var result = html
    while (true) {
        val startIndex = result.indexOf("<a ")
        val endIndex = result.indexOf("</a>")

        if (startIndex == -1 || endIndex == -1) break

        val tagContentStart = result.indexOf(">", startIndex) + 1
        val anchorText = result.substring(tagContentStart, endIndex)

        result = result.substring(0, startIndex) + anchorText + result.substring(endIndex + 4)
    }
    return result
}



