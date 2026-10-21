package com.example.vkedu1.presentation.appdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkedu1.data.sampleAppDetails
import com.example.vkedu1.data.sampleApps
import com.example.vkedu1.data.showcaseApps
import com.example.vkedu1.domain.AppInfo
import com.example.vkedu1.ui.theme.VkEdu1Theme

private const val SCREENSHOTS_COUNT = 3

@Composable
fun AppDetailsContent(
    content: AppDetailsState.Content,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onInstallClick: () -> Unit,
    onReadMoreClick: () -> Unit,
    onDeveloperClick: () -> Unit,
    onSimilarAppDownloadClick: (AppInfo) -> Unit,
    onShowcaseAppClick: (AppInfo) -> Unit,
    modifier: Modifier = Modifier,
) {
    val appDetails = content.appDetails
    val descriptionCollapsed = content.descriptionCollapsed

    Column(modifier.verticalScroll(rememberScrollState())) {
        Toolbar(
            onBackClick = onBackClick,
            onShareClick = onShareClick,
        )
        Spacer(Modifier.height(8.dp))
        AppDetailsHeader(
            appDetails = appDetails,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(16.dp))
        InstallButton(
            onClick = onInstallClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        if (content.similarApps.isNotEmpty()) {
            Spacer(Modifier.height(12.dp))
            SimilarApps(
                apps = content.similarApps,
                onDownloadClick = onSimilarAppDownloadClick,
                modifier = Modifier.padding(horizontal = 16.dp),
            )
        }
        Spacer(Modifier.height(12.dp))
        ScreenshotsList(
            screenshotCount = SCREENSHOTS_COUNT,
            contentPadding = PaddingValues(horizontal = 16.dp),
        )
        Spacer(Modifier.height(12.dp))
        AppDescription(
            description = appDetails.description,
            collapsed = descriptionCollapsed,
            onReadMoreClick = onReadMoreClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(12.dp))
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.outlineVariant,
        )
        Spacer(Modifier.height(12.dp))
        Developer(
            name = appDetails.developer,
            onClick = onDeveloperClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
        )
        Spacer(Modifier.height(16.dp))
        // Блок «Витрина» — в самом низу карточки
        Showcase(
            apps = content.showcaseApps,
            onAppClick = onShowcaseAppClick,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(Modifier.height(16.dp))
    }
}

@Preview
@Composable
private fun Preview() {
    VkEdu1Theme {
        AppDetailsContent(
            content = AppDetailsState.Content(
                appDetails = sampleAppDetails.first(),
                similarApps = sampleApps.drop(1).take(6),
                showcaseApps = showcaseApps,
                descriptionCollapsed = false,
            ),
            onBackClick = {},
            onShareClick = {},
            onInstallClick = {},
            onReadMoreClick = {},
            onDeveloperClick = {},
            onSimilarAppDownloadClick = {},
            onShowcaseAppClick = {},
            modifier = Modifier.fillMaxSize(),
        )
    }
}
