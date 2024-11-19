package com.example.buddyforum

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FourQuadrants(
    onNavigateToMainScreen: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.app_bar_color)) // This ensures the background color is applied to the screen
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Top-left quadrant
                Quadrant(
                    heading = stringResource(id = R.string.aih),
                    paragraph = stringResource(id = R.string.aip),
                    modifier = Modifier.weight(1f)
                )

                // Top-right quadrant
                Quadrant(
                    heading = stringResource(id = R.string.gh),
                    paragraph = stringResource(id = R.string.gp),
                    modifier = Modifier.weight(1f)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Bottom-left quadrant
                Quadrant(
                    heading = stringResource(id = R.string.cbh),
                    paragraph = stringResource(id = R.string.cbp),
                    modifier = Modifier.weight(1f)
                )

                // Bottom-right quadrant
                Quadrant(
                    heading = stringResource(id = R.string.coding_block_h),
                    paragraph = stringResource(id = R.string.coding_block_p),
                    modifier = Modifier.weight(1f)
                )
            }
            Button(
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = colorResource(id = R.color.app_bar_color)
                ),
                onClick = onNavigateToMainScreen,
                modifier = Modifier.width(200.dp)
            ) {
                Text("Give Your FeedBack", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun Quadrant(
    heading: String = "",
    paragraph: String = "",
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f) // Ensures the quadrant is square
            .border(1.dp, Color.White, shape = RoundedCornerShape(16.dp)) // Rounded border
            .clip(RoundedCornerShape(16.dp)) // Clip content to rounded shape
             // Background color inside the box
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.fillMaxSize()
        ) {
            // Heading
            Text(
                text = heading, // Content for the heading
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White),
                modifier = Modifier.fillMaxWidth()
            )

            // Paragraph
            Text(
                text = paragraph, // Content for the paragraph
                style = TextStyle(fontSize = 14.sp, color = Color.White),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
