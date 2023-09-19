package com.example.newsappcompose.ui.screens.categoires

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.news.R
import com.example.newsappcompose.ui.widgets.CategoriesContent
import com.example.newsappcompose.ui.widgets.CustomDrawer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesNews(navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Box(modifier = with(Modifier) {
        fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.pattern),
                contentScale = ContentScale.FillBounds
            )
    }) {
        NewsDrawer(drawerState = drawerState, navController = navController, scope = scope)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDrawer(drawerState: DrawerState, navController: NavHostController, scope: CoroutineScope) {
    CustomDrawer(scope = scope, navController = navController, drawerState = drawerState,
        topBar = {
            NewsAppBar(
                drawerState,
                title = stringResource(R.string.news_bar),
            )
        }
    ) {
        CategoriesContent(navController = navController)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsAppBar(
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    title: String,
    iconContent: @Composable () -> Unit = {
        Icon(
            modifier =Modifier.size(32.dp),
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = "Icon Navigation"
        )
    },
    trailingIcon: @Composable() (RowScope.() -> Unit) = {},
) {
    val scope = rememberCoroutineScope()
    com.example.newsappcompose.ui.widgets.CustomAppBar(title = title,
        leadingIcon = {
            IconButton(onClick = {
                scope.launch {
                    drawerState.open()
                }
            }) { iconContent() }
        }, trailingIcons = {
            trailingIcon()
        })

}