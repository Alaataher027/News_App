package com.example.newsappcompose.ui.screens.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.news.R
import com.example.newsappcompose.ui.screens.categoires.NewsAppBar
import com.example.newsappcompose.ui.widgets.CustomDrawer
import com.example.newsappcompose.ui.widgets.DropdownMenuBox


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
   Box(modifier = with(Modifier){
       fillMaxSize()
           .paint(painter = painterResource(id = R.drawable.pattern) , contentScale = ContentScale.FillBounds)
   }) {
      CustomDrawer(drawerState = drawerState,navController = navController, topBar = {
          NewsAppBar(
              drawerState = drawerState,
              title = stringResource(id = R.string.settings),
          )
      },
          ){
          Column() {
              Text(modifier = Modifier.padding(24.dp),text = stringResource(R.string.language), style = TextStyle(
                  fontSize = 24.sp,
                  fontWeight = FontWeight.Bold))

              DropdownMenuBox()
          }
      }
   }
}