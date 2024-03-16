package com.alaa.newssnap.newsapp.presentation.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alaa.newssnap.R
import com.alaa.newssnap.newsapp.domain.model.Article
import com.alaa.newssnap.newsapp.domain.model.Source
import com.alaa.newssnap.ui.theme.NewsSnapTheme
import com.alaa.newssnap.util.Dimens.ExtraSmallPadding
import com.alaa.newssnap.util.Dimens.MediumPadding1
import com.alaa.newssnap.util.Dimens.MediumPadding2
import com.alaa.newssnap.util.Dimens.SmallPadding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@Composable
fun BreakingNewsArticle(
    modifier: Modifier = Modifier, article: Article,
    onClick: () -> Unit

) {
    val ctx = LocalContext.current

    Card(
        modifier = modifier
            .padding(MediumPadding1)
            .clickable { onClick() },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(modifier = modifier.height(220.dp)) {


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.White
                            ),
                            startY = 300f
                        )
                    )
            ) {

                Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.6f),
                        contentScale = ContentScale.FillBounds,
                        model = ImageRequest.Builder(ctx).data(article.urlToImage).build(),
                        contentDescription = null
                    )
                    Spacer(modifier = modifier.height(SmallPadding))

                    Text(
                        text = article.title,
                        modifier = Modifier.padding(horizontal = SmallPadding),
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                        color = colorResource(id = R.color.display_small),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = article.description,
                        modifier = Modifier.padding(horizontal = SmallPadding),
                        style = MaterialTheme.typography.bodyMedium,
                        color = colorResource(id = R.color.text_medium),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = modifier.height(MediumPadding2))
                }

                Text(
                    text = article.source.name,
                    modifier = Modifier
                        .padding(SmallPadding)
                        .align(Alignment.TopStart),
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.White,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                val parsedDate =
                    LocalDateTime.parse(article.publishedAt, DateTimeFormatter.ISO_DATE_TIME)
                val formattedDate = parsedDate.format(DateTimeFormatter.ofPattern("hh:mm a"))


                Text(
                    text = formattedDate,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(SmallPadding)
                        .align(Alignment.TopEnd),
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.White,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

            }
        }

    }

}


@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun BreakingNewsArticlePreview() {
    NewsSnapTheme {

        BreakingNewsArticle(
            article = Article(
                author = "",
                title = "The Rise of Virtual Reality in Education: Transforming the Classroom Experience",
                description = "Coinbase says Apple blocked its last app release on NFTs in Wallet ... - CryptoSaurus",
                content = "Virtual Reality (VR) technology has emerged as a transformative tool in education, revolutionizing the way students learn and interact with the world around them. By creating immersive and engaging environments, VR has the potential to enhance traditional classroom settings and provide students with unique learning experiences that were once unimaginable[+1131 chars]",
                publishedAt = "2023-06-16T22:24:33Z",
                source = Source(
                    id = "", name = "bbc"
                ),
                url = "https://consent.google.com/ml?continue=https://news.google.com/rss/articles/CBMiaWh0dHBzOi8vY3J5cHRvc2F1cnVzLnRlY2gvY29pbmJhc2Utc2F5cy1hcHBsZS1ibG9ja2VkLWl0cy1sYXN0LWFwcC1yZWxlYXNlLW9uLW5mdHMtaW4td2FsbGV0LXJldXRlcnMtY29tL9IBAA?oc%3D5&gl=FR&hl=en-US&cm=2&pc=n&src=1",
                urlToImage = "https://media.wired.com/photos/6495d5e893ba5cd8bbdc95af/191:100/w_1280,c_limit/The-EU-Rules-Phone-Batteries-Must-Be-Replaceable-Gear-2BE6PRN.jpg"
            )
        ) {}
    }
}