package com.alaa.newssnap.newsapp.presentation.details

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alaa.newssnap.R
import com.alaa.newssnap.newsapp.domain.model.Article
import com.alaa.newssnap.newsapp.domain.model.Source
import com.alaa.newssnap.newsapp.presentation.details.components.DetailsTopBar
import com.alaa.newssnap.ui.theme.NewsSnapTheme
import com.alaa.newssnap.util.Dimens.ArticleImageHeight
import com.alaa.newssnap.util.Dimens.ExtraSmallPadding
import com.alaa.newssnap.util.Dimens.MediumPadding1


@Composable
fun DetailsScreen(
    article: Article,
    navigateUp: () -> Unit
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        DetailsTopBar(
            onBackClick = navigateUp
        )


        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = MediumPadding1,
                end = MediumPadding1,
                top = MediumPadding1
            )
        ) {
            item {
                AsyncImage(
                    model = ImageRequest.Builder(context = context).data(article.urlToImage)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ArticleImageHeight)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(MediumPadding1))
                Text(
                    text = article.title,
                    style = MaterialTheme.typography.displaySmall,
                    color = colorResource(
                        id = R.color.text_title
                    )
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = colorResource(id = R.color.body)
                            )
                        ) {
                            append(article.content)
                        }
                        append("Read More")
                    },
                    modifier = Modifier
                        .padding(start = ExtraSmallPadding)
                        .clickable {
                            Intent(Intent.ACTION_VIEW).also {
                                it.data = Uri.parse(article.url)
                                if (it.resolveActivity(context.packageManager) != null) {
                                    context.startActivity(it)
                                }
                            }
                        },
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Blue
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    NewsSnapTheme(dynamicColor = false) {
        DetailsScreen(
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
        ) {

        }
    }
}