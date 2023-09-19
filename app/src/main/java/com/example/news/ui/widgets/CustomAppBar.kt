package com.example.newsappcompose.ui.widgets

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    title: String,
    modifier: Modifier = Modifier,
    colors: TopAppBarDefaults = TopAppBarDefaults,
    leadingIcon: @Composable () -> Unit = {},
    trailingIcons : @Composable() (RowScope.() -> Unit) = {},
    ) {
    CenterAlignedTopAppBar(
        title = {
                Text(
                    text = title,
                    style = TextStyle(color = Color.White, fontSize = 24.sp)
                )

        },
        actions = {
            trailingIcons()
        },
        modifier = modifier.clip(
            RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 26.dp,
                bottomEnd = 26.dp
            )
        ),

        colors = colors.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF39A552),
            navigationIconContentColor = Color.White
        ),
        navigationIcon = {
            leadingIcon()
        }
    )
}