package com.example.vkedu1.presentation.appdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkedu1.R
import com.example.vkedu1.domain.AppInfo
import com.example.vkedu1.presentation.applist.AppListItem
import com.example.vkedu1.presentation.common.previewApps
import com.example.vkedu1.ui.theme.VkEdu1Theme

private const val APPS_PER_PAGE = 3

/**
 * Блок «Витрина»: заголовок и горизонтальный постраничный список (Pager).
 * На каждой странице по три приложения, вёрстка каждого — тот же [AppListItem], что и в списке приложений.
 */
@Composable
fun Showcase(
    apps: List<AppInfo>,
    onAppClick: (AppInfo) -> Unit,
    modifier: Modifier = Modifier,
) {
    // 9 приложений -> 3 страницы по 3
    val pages = remember(apps) { apps.chunked(APPS_PER_PAGE) }
    val pagerState = rememberPagerState { pages.size }

    Column(modifier) {
        Text(
            text = stringResource(R.string.showcase_title),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(4.dp))
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
        ) { pageIndex ->
            Column {
                pages[pageIndex].forEach { app ->
                    AppListItem(
                        app = app,
                        onClick = { onAppClick(app) },
                        minDescriptionLines = 2,
                    )
                }
            }
        }
        PageIndicator(
            pageCount = pages.size,
            currentPage = pagerState.currentPage,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
        )
    }
}

/** Точки под пейджером: текущая страница выделена акцентным цветом. */
@Composable
private fun PageIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
    ) {
        repeat(pageCount) { index ->
            val color = if (index == currentPage) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.outlineVariant
            }
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(color),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    VkEdu1Theme {
        Showcase(
            apps = previewApps,
            onAppClick = {},
        )
    }
}
