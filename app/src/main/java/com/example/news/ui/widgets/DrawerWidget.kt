package com.example.newsappcompose.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.news.R
import com.example.newsappcompose.ui.navigation_component.NewsScreens


@Composable
fun DrawerHeader() {

    Text(
        text = stringResource(id = R.string.news_app),
        modifier = Modifier
            .fillMaxWidth(0.65F)
            .fillMaxHeight(0.1F)
            .background(Color(0xFF39A552))
            .padding(top = 24.dp),

        style = TextStyle(
            color = Color.White, fontSize = 20.sp,
        ),
        textAlign = TextAlign.Center
    )
}

@Composable
fun DrawerBody(
    navController: NavHostController,
    onCloseDrawer: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.65F)
            .fillMaxHeight()
            .background(Color.White)
            .padding(top = 16.dp)
    ) {
        NewsDrawerItem(iconId = R.drawable.ic_category , textId = R.string.categories){
            navController.navigate(NewsScreens.CategoriesScreen.name)
            navController.popBackStack(NewsScreens.HomeScreen.name, inclusive = true)
            onCloseDrawer.invoke()
        }
        NewsDrawerItem(iconId = R.drawable.ic_settings , textId = R.string.settings){
            navController.navigate(NewsScreens.SettingScreen.name)
            onCloseDrawer.invoke()
        }
    }
}

@Composable
fun NewsDrawerItem(iconId: Int, textId: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.65F)
            .background(Color.White)
            .padding(vertical = 16.dp, horizontal = 8.dp)
            .clickable { onClick.invoke() }
    ) {
        Icon(
            modifier = Modifier
                .width(32.dp)
                .height(32.dp),
            painter = painterResource(id = iconId),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = stringResource(id = textId), style = TextStyle(
                fontSize = 18.sp,
                color = Color(0xFF303030),
                fontWeight = FontWeight.Bold
            )
        )

    }
}







