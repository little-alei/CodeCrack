package com.rookie.codecrack

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rookie.codecrack.ui.theme.CodeCrackTheme
import com.rookie.codecrack.utils.Debug.Companion.toast

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 使用主题
            CodeCrackTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppBody(this.application)
                }
            }
        }
    }
}

@Composable
fun AppBody(context: Context) {
    // 居中显示卡片
    Column(modifier = Modifier.padding(16.dp)) {
        Card {
            // 定义可记忆的状态变量，用于控制展开和收起
            var expanded by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier.clickable { expanded = !expanded }.fillMaxWidth() // 点击切换状态
            ) {
                // 显示图片
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = "AppLogo")
                    Column {
                        Text(text = "拥抱Kotlin", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "优雅的进行Xposed开发", style = MaterialTheme.typography.bodyLarge)
                    }
                }

                // 动画显示站看内容
                AnimatedVisibility(visible = expanded) {
                    Row {
                        Button(
                            onClick = {
                                toast("抠脚本人")
                            },
                            modifier = Modifier.padding(16.dp),
                            shape = MaterialTheme.shapes.medium,
                        ) {
                            Text("显示作者")
                        }
                        // Spacer(Modifier.width(8.dp))
                        Button(
                            onClick = {
                                // 创建 Intent 跳转到浏览器
                                val intent = Intent(Intent.ACTION_VIEW).apply {
                                    data = Uri.parse("https://github.com/")
                                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                }
                                // 启动 Activity
                                context.startActivity(intent)

                            },
                            modifier = Modifier.padding(16.dp),
                            shape = MaterialTheme.shapes.medium,
                        ) {
                            Text("GitHub")
                        }
                    }


                }
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun GreetingPreview() {
    CodeCrackTheme {
        AppBody(LocalContext.current)
    }
}