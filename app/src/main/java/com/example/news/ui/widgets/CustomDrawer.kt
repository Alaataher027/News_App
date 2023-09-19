package com.example.newsappcompose.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDrawer(
    drawerState: DrawerState,
    navController: NavHostController,
    scope : CoroutineScope = rememberCoroutineScope(),
    topBar: @Composable () -> Unit ={},
    drawerContent: @Composable () -> Unit = {},
    topBarContent :  @Composable () -> Unit ={},
) {
    ModalNavigationDrawer(drawerContent = {

            Column(modifier = Modifier.fillMaxSize()) {
                DrawerHeader()
                DrawerBody(navController) {
                    scope.launch {
                        drawerState.close()
                    }
                }
            }

    }, drawerState = drawerState) {
        Scaffold(topBar = { topBar() }) {
            val padding = it
            topBarContent()
        }
    }
}