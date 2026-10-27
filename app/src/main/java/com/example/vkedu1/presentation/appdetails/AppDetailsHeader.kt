package com.example.vkedu1.presentation.appdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkedu1.R
import com.example.vkedu1.domain.AppDetails
import com.example.vkedu1.presentation.common.AppIcon
import com.example.vkedu1.presentation.common.previewAppDetails
import com.example.vkedu1.presentation.common.title
import com.example.vkedu1.presentation.common.toImageVector
import com.example.vkedu1.ui.theme.VkEdu1Theme
import kotlin.math.roundToInt

@Composable
fun AppDetailsHeader(
    appDetails: AppDetails,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AppIcon(
            icon = appDetails.iconType.toImageVector(),
            background = Color(appDetails.iconColor),
            size = 128.dp,
            cornerRadius = 24.dp,
        )
        Spacer(Modifier.width(16.dp))
        Column {
            Text(
                text = appDetails.category.title,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 12.sp,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = appDetails.name,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = appDetails.developer,
                fontSize = 12.sp,
            )
            Spacer(Modifier.height(4.dp))
            Row {
                Column(Modifier.width(IntrinsicSize.Max)) {
                    Text(
                        text = "${appDetails.ageRating}+",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(text = stringResource(R.string.app_details_age))
                }
                Spacer(Modifier.width(12.dp))
                Column {
                    Text(text = "${appDetails.size.roundToInt()} МБ")
                    Spacer(Modifier.height(4.dp))
                    Text(text = stringResource(R.string.app_details_size))
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    VkEdu1Theme {
        AppDetailsHeader(
            appDetails = previewAppDetails,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
