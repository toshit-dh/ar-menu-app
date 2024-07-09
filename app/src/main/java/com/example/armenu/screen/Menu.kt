package com.example.armenu.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.armenu.R
import com.example.armenu.model.Food
import com.example.armenu.model.FoodList
import com.example.armenu.screen.component.CircularImage

@Composable
fun Menu(
    modifier: Modifier,
    list: List<Food> = FoodList,
    onClick: (String) -> Unit
) {
    var currentIndex by remember {
        mutableIntStateOf(0)
    }
    fun updateIndex(offset: Int){
        currentIndex = (currentIndex + offset + list.size) % list.size
    }
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconButton(
            onClick = {
                updateIndex(-1)
                onClick(list[currentIndex].name)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = stringResource(R.string.back_button)
            )
        }
        CircularImage(
            image = list[currentIndex].image
        )
        IconButton(
            onClick = {
                updateIndex(1)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.forward),
                contentDescription = stringResource(R.string.forward_button)
            )
        }
    }
}