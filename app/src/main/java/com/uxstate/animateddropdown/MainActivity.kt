package com.uxstate.animateddropdown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import com.uxstate.animateddropdown.ui.theme.AnimatedDropDownTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedDropDownTheme {

            }
        }
    }
}


@Composable
fun DropDown(text: String, content: @Composable () -> Unit, initiallyOpened: Boolean) {


    var isOpen by remember { mutableStateOf(initiallyOpened) }


    val alpha = animateFloatAsState(
        targetValue = if (isOpen) 1f else 0f,
        animationSpec = tween(durationMillis = 100)
    )

}
