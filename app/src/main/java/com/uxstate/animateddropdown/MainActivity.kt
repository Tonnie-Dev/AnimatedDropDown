package com.uxstate.animateddropdown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
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
fun DropDown(text: String, content: @Composable () -> Unit, isOpen: Boolean) {

}
