package com.example.newsappcompose.ui.screens.home_details

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.news.R
import com.example.news.api.model.newsResponse.News
import com.example.newsappcompose.ui.screens.categoires.NewsAppBar

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeDetails(navController: NavHostController) {
    val news = navController.previousBackStackEntry?.savedStateHandle?.get<News>("news")
    val context = LocalContext.current

    Box(modifier = with (Modifier){
        fillMaxSize()
            .paint(
                painterResource(id = R.drawable.pattern),
                contentScale = ContentScale.FillBounds
            )
    }){
        NewsAppBar(
            title = stringResource(R.string.news_details),
            iconContent = { Box() {}},
        )
        Column(Modifier.padding(horizontal = 16.dp, vertical = 64.dp)) {
            GlideImage(modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(16.dp)
                .clip(
                    RoundedCornerShape(CornerSize(16.dp))
                ),
                model = news?.urlToImage,
                contentDescription ="url image",
                contentScale = ContentScale.FillBounds
            )

            Text(modifier = Modifier.padding(8.dp),text = news?.source?.name ?: "", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
            Text(modifier = Modifier.padding(8.dp),text =news?.title ?: "",style = TextStyle(fontSize = 18.sp))
            Text(modifier = Modifier
                .align(Alignment.End)
                .padding(8.dp),text =news?.publishedAt ?: "",style = TextStyle(fontSize = 18.sp))


            Card(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Intent(Intent.ACTION_VIEW, Uri.parse(news?.url)).also {
                        try {
                            context.startActivity(it)
                        } catch (e: ActivityNotFoundException) {
                            e.printStackTrace()
                        }
                    }
                },colors = CardDefaults.cardColors(
                containerColor = Color.White
            ), shape = RoundedCornerShape(CornerSize(8.dp))) {
                Text(modifier = Modifier.padding(16.dp),text =news?.description ?: "", style = TextStyle(fontSize = 20.sp))
                Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End)){
                    Text(modifier = Modifier.padding(16.dp),text = "View Details", style = TextStyle( fontSize = 20.sp))
                    Icon(modifier = Modifier
                        .padding(end = 16.dp, top = 20.dp)
                        .size(18.dp),painter = painterResource(id = R.drawable.paly_ic ), contentDescription = "arrow icon",)
                }
            }
        }

    }
}