package com.alaa.newssnap.newsapp.presentation.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.fragment.app.FragmentActivity
import com.alaa.newssnap.R
import com.alaa.newssnap.newsapp.domain.authenticator.BiometricAuthenticator
import com.alaa.newssnap.newsapp.presentation.common.NewsButton
import com.alaa.newssnap.util.Dimens.ExtraSmallPadding2
import com.alaa.newssnap.util.Dimens.MediumPadding2

@Composable
fun AuthenticationScreen(modifier: Modifier = Modifier, navigateToHomeScreen: () -> Unit) {


    var message by remember {
        mutableStateOf("")
    }
    val fragmentActivity = LocalContext.current as FragmentActivity
    val biometricAuthenticator = BiometricAuthenticator(fragmentActivity)

    Box {
        Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
            Image(
                modifier = Modifier
                    .padding(vertical = ExtraSmallPadding2)
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                painter = painterResource(R.drawable.ic_news_display), contentDescription = null,
                contentScale = ContentScale.Crop
            )


            Text(
                text = "Stay Informed with Our News Onboarding Experience!",
                modifier = Modifier.padding(horizontal = MediumPadding2),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.display_small)
            )

            Text(
                text = "Welcome to our news app! Get started by personalizing your news feed.",
                modifier = Modifier.padding(horizontal = MediumPadding2),
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_medium)
            )
            Spacer(modifier = Modifier.height(MediumPadding2))


            NewsButton(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Login With Fingerprint"
            ) {
                biometricAuthenticator.promptBiometricAuth(
                    title = "Login",
                    subtitle = "Use Your Fingerprint",
                    cancelBtnText = "Cancel",
                    fragmentActivity = fragmentActivity,
                    onSuccess = {
                                navigateToHomeScreen()

                    },
                    onFailed = {
                        message = "Failed"
                    },
                    onError = { _, error ->
                        message = error
                    })
            }
            Spacer(modifier = Modifier.height(MediumPadding2))
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = MaterialTheme.colorScheme.error,
                text = message.toString()
            )


        }
    }
}