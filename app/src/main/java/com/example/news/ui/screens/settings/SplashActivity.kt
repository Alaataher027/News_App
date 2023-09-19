package com.example.newsappcompose.ui.screens.settings

import android.app.Activity
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.news.R
import com.example.news.ui.theme.NewsTheme
import com.example.newsappcompose.ui.navigation_component.NewsScreens
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsTheme {

            }
        }

    }
}


@Composable
fun SplashContent(navController: NavHostController) {

    val scale  = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

LaunchedEffect(key1 = true){
    scale.animateTo(
        targetValue = 0.3f,
        animationSpec = tween(
            delayMillis = 500,
            easing = {
                OvershootInterpolator(2f).getInterpolation(it)
            }
        )
    )

    delay(3000L)

    navController.navigate(NewsScreens.CategoriesScreen.name)

}

    Column(
        modifier = Modifier.fillMaxSize()
            .paint(
            painterResource(id = R.drawable.pattern),
            contentScale = ContentScale.FillBounds
        ),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.fillMaxSize(.65F),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "splash logo"
        )
        Spacer(modifier = Modifier.fillMaxHeight(0.35F))
        Image(
            painter = painterResource(id = R.drawable.sign),
            contentDescription = "App Signature",
            modifier = Modifier
                .fillMaxSize(0.5F)
        )

    }
}


