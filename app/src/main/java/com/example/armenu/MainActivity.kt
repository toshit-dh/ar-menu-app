package com.example.armenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.armenu.screen.Menu
import com.example.armenu.screen.ARScreen
import com.example.armenu.ui.theme.ARMenuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ARMenuTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { pv ->
                    val model = remember {
                        mutableStateOf("burger")
                    }
                    Box (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(pv)
                    ){
                        ARScreen(
                            model.value
                        )
                        Menu(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                        ){

                        }
                    }
                }
            }
        }
    }
}

