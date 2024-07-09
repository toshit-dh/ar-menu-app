package com.example.armenu.screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.armenu.R
import com.example.armenu.ui.theme.Translucent

@Composable
fun CircularImage(
    image: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(140.dp)
            .clip(CircleShape)
            .border(width = 3.dp, color = Translucent)
    ){
        Image(
            painter = painterResource(id = image),
            contentDescription = stringResource(R.string.food_image),
            contentScale = ContentScale.FillBounds
        )
    }
}