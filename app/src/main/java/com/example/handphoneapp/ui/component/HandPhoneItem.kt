package com.example.handphoneapp.ui.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.handphoneapp.R
import com.example.handphoneapp.ui.theme.HandphoneAppTheme
import com.example.handphoneapp.ui.theme.Shapes

@Composable
fun HandPhoneItem(
    image: Int,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(170.dp)
                .clip(Shapes.medium)
        )
        Text(
            text = title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.subtitle1.copy(
                fontWeight = FontWeight.ExtraBold
            )
        )
    }

}
@Composable
@Preview(showBackground = true)
fun HandPhoneItemPreview() {
    HandphoneAppTheme {
        HandPhoneItem(R.drawable.samsung_galaxy_s23_ultra_5g, "Samsung Galaxy S23 Ultra" )
    }
}