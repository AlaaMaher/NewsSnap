package com.alaa.newssnap.newsapp.presentation.authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import com.alaa.newssnap.newsapp.domain.authenticator.BiometricAuthenticator

@Composable
fun AuthenticationScreen() {


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val fragmentActivity = LocalContext.current as FragmentActivity
        val biometricAuthenticator = BiometricAuthenticator(fragmentActivity)

        var message by remember {
            mutableStateOf("")
        }
        TextButton(onClick = {
            biometricAuthenticator.promptBiometricAuth(
                title = "Login",
                subtitle = "Use Your Fingerprint",
                cancelBtnText = "Cancel",
                fragmentActivity = fragmentActivity,
                onSuccess = {
                    message = " Success"
                },
                onFailed = {
                    message = "Wrong Fingerprint"
                },
                onError = { _, error ->
                    message = error
                })
        }) {
            Text(text = "Login With Fingerprint")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = message)

    }
}