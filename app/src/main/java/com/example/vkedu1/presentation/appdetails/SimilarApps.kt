package com.example.vkedu1.presentation.appdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkedu1.R
import com.example.vkedu1.data.sampleApps
import com.example.vkedu1.domain.AppInfo
import com.example.vkedu1.presentation.common.AppIcon
import com.example.vkedu1.ui.theme.VkEdu1Theme

@Composable
fun SimilarApps(
    apps: List<AppInfo>,
    onDownloadClick: (AppInfo) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        Text(
            text = stringResource(R.string.app_details_similar_apps),
            style = MaterialTheme.typography.headlineSmall,
        )
        Spacer(Modifier.height(4.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(apps) { app ->
                SimilarAppItem(app = app, onDownloadClick = { onDownloadClick(app) })
            }
        }
    }
}

@Composable
private fun SimilarAppItem(
    app: AppInfo,
    onDownloadClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.width(128.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppIcon(
            icon = app.icon,
            background = app.iconBackground,
            size = 128.dp,
            cornerRadius = 16.dp,
        )
        Text(text = app.name, maxLines = 2, overflow = TextOverflow.Ellipsis)
        Button(
            onClick = onDownloadClick,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = stringResource(R.string.app_details_download),
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    VkEdu1Theme {
        SimilarApps(
            apps = sampleApps,
            onDownloadClick = {},
        )
    }
}
