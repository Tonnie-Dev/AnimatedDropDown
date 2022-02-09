package com.uxstate.animateddropdown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
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


    //Animate alpha value
    val alpha = animateFloatAsState(
        targetValue = if (isOpen) 1f else 0f,
        animationSpec = tween(durationMillis = 300)
    )

    //Animate rotationX as the 3D anim rotation is along the X-Axis
    val rotationX = animateFloatAsState(
        targetValue = if (isOpen) 0f else -90f,
        animationSpec = tween(durationMillis = 300)
    )


    Column(modifier = Modifier.fillMaxWidth()) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(text = text, color = Color.White, fontSize = 16.sp)
            IconButton(onClick = {

                //toggle drawer
                isOpen = !isOpen

            }) {
                Icon(
                    imageVector = if (isOpen) Icons.Default.KeyboardArrowUp else Icons.Default.ArrowDropDown,
                    contentDescription = "Drop down"
                )

            }
        }

    }
}
