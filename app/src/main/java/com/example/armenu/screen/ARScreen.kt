package com.example.armenu.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.armenu.R
import com.google.ar.core.Config
import io.github.sceneview.ar.ARScene
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.ar.node.ArNode
import io.github.sceneview.ar.node.PlacementMode

@Composable
fun ARScreen(
    model: String,
) {
    val nodes = remember {
        mutableListOf<ArNode>()
    }
    val modalNode = remember {
        mutableStateOf<ArModelNode?>(null)
    }
    val placeModel = remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = model) {
        modalNode.value?.loadModelGlbAsync(
            glbFileLocation = "models/${model}.glb",
            scaleToUnits = 0.8f
        )
    }
    ARScene(
        modifier = Modifier
            .fillMaxSize(),
        nodes = nodes,
        planeRenderer = true,
        onCreate = {
            it.lightEstimationMode = Config.LightEstimationMode.DISABLED
            it.planeRenderer.isShadowReceiver = false
            modalNode.value = ArModelNode(
                it.engine,
                PlacementMode.INSTANT
            ).apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/${model}.glb",
                    scaleToUnits = 0.8f
                ) {

                }
                onAnchorChanged = {
                    placeModel.value = !isAnchored
                }
                onHitResult = {_,_->
                    placeModel.value = isTracking
                }
            }
            nodes.add(modalNode.value!!)
        },
        onSessionCreate = {
            planeRenderer.isVisible = false
        }
    )
    if (placeModel.value)
        Button(
            onClick = {
                modalNode.value?.anchor()
            }
        ) {
            Text(
                text = stringResource(R.string.place_it)
            )
        }
}
