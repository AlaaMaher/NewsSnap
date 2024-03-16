package com.alaa.newssnap.newsapp.presentation.home


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.alaa.newssnap.R
import com.alaa.newssnap.newsapp.domain.model.Article
import com.alaa.newssnap.newsapp.presentation.common.ArticlesList
import com.alaa.newssnap.newsapp.presentation.home.components.BreakingNewsArticle
import com.alaa.newssnap.util.Dimens.ExtraSmallPadding
import com.alaa.newssnap.util.Dimens.ExtraSmallPadding2
import com.alaa.newssnap.util.Dimens.MediumPadding1
import com.alaa.newssnap.util.Dimens.MediumPadding2
import com.alaa.newssnap.util.Dimens.SmallPadding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    topHeadlines: LazyPagingItems<Article>,
    articles: LazyPagingItems<Article>,
    navigateToDetails: (Article) -> Unit
) {
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83D\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }

    val topHeadlineState = rememberPagerState(initialPage = 0) {
        topHeadlines.itemSnapshotList.size
    }
    val isDraggedState = topHeadlineState.interactionSource.collectIsDraggedAsState()



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MediumPadding1)
            .statusBarsPadding()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = ExtraSmallPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(70.dp),
                painter = painterResource(id = R.drawable.ic_logo_home),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
            Text(
                modifier = Modifier.padding(horizontal = ExtraSmallPadding),
                text = "Breaking News",
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.displaySmall,
                fontSize = 18.sp
            )

        }


        Text(
            text = titles, modifier = Modifier
                .fillMaxWidth()
                .padding(start = MediumPadding1)
                .basicMarquee(), fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder)
        )


        Box {
            HorizontalPager(state = topHeadlineState) { index ->
                topHeadlines[index]?.let {
                    BreakingNewsArticle(article = it) {
                        navigateToDetails(it)
                    }
                }

            }

            LaunchedEffect(isDraggedState) {
                snapshotFlow { isDraggedState.value }
                    .collectLatest { isDragged ->
                        if (!isDragged) {
                            while (true) {
                                delay(5_000L)
                                runCatching {
                                    topHeadlineState.animateScrollToPage(topHeadlineState.currentPage.inc() % topHeadlineState.pageCount)
                                }
                            }
                        }
                    }
            }

        }
        Text(
            modifier = Modifier.padding(horizontal = MediumPadding2),
            text = "ALL NEWS",
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.padding(vertical=ExtraSmallPadding2))
        Spacer(modifier = Modifier.weight(2f))


        ArticlesList(
            modifier = Modifier.padding(horizontal = MediumPadding1),
            articles = articles,
            onClick = {
                navigateToDetails(it)
            }
        )
    }
}