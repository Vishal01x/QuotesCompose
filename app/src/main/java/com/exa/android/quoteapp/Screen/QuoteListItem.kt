package com.exa.android.quoteapp.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exa.android.quoteapp.models.Quote

@Composable
fun QuoteListItem(quote : Quote, onClick :(quote : Quote) ->Unit) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .clickable {
               onClick(quote)
            }
            .background(Color.White)
    ) {
        Row(
            Modifier.padding(16.dp)
        ) {
            Image(
                imageVector = Icons.Filled.FormatQuote, // Corrected parameter order
                contentDescription = "Quote", // Fixed spelling
                colorFilter = ColorFilter.tint(Color.White), // Corrected colorFilter
                modifier = Modifier
                    .rotate(180F)
                    .size(40.dp)
                    .background(Color.Black),
                alignment = Alignment.TopStart // Set alignment in Image Composable
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Column(Modifier.weight(1f)) {
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                    fontWeight = FontWeight.Bold
                )

                Box(                     // used to create a line as we used view in xml
                    modifier = Modifier
                        .fillMaxWidth(.4f) // to occupy only 40% of space available
                        .height(1.dp)
                        .background(Color(0xFFB8B4B4)) // the color code is in ARGB format(alpha Red Green Blue) alpha is used for transparency
                )
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp),
                    fontWeight = FontWeight.Thin
                )
            }
        }
    }
}

