package com.ohuang.composeforimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ohuang.composeforglide.ImageGlide
import com.ohuang.composeforimage.ui.theme.ComposeForImageTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeForImageTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    //加载png图片
    Column(modifier) {
        Image(
            painter =
                painterResource(R.mipmap.ic_launcher),
            contentDescription = null
        )
        ImageGlide(url = "https://q9.itc.cn/q_70/images03/20241112/57e863c97c2f4ccd89871505c4044b9b.gif")
        var isShow = remember {
            mutableStateOf(false)
        }
        Button(onClick = { isShow.value = !isShow.value }) {
            Text("load img")
        }
        if (isShow.value) {
            ImageGlide() {
                load("http://192.168.2.97:8080/main/files/testImg.gif")
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.drawable.ic_launcher_background)
                    .apply(RequestOptions().transform(RoundedCorners(50)))
            }
        }
        ImageGlide(id = R.mipmap.ic_launcher)
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeForImageTheme {
        Greeting("Android")
    }
}