package com.rookie.codecrack

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
            // 使用主题，关闭动态颜色
            CodeCrackTheme(dynamicColor = false) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppBody()
                }
            }
        }
    }
}

@Composable
fun AppBody() {
    // 居中显示卡片
    Column(modifier = Modifier.padding(16.dp)) {
        Card {
            // 定义可记忆的状态变量，用于控制展开和收起
            var expanded by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier.clickable {
                    expanded = !expanded
                }.fillMaxWidth() // 点击切换状态
            ) {
                // 显示介绍
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = "AppLogo")
                    Column {
                        Text("拥抱Kotlin", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("优雅的进行Xposed开发", style = MaterialTheme.typography.bodyLarge)
                    }
                }

                // 动画展开显示作者信息
                AnimatedVisibility(visible = expanded) {
                    AuthorInfo(
                        "抠脚本人",
                        "https://github.com/little-alei/CodeCrack"
                    )
                }
            }
        }
    }
}

@Composable
fun AuthorInfo(author: String, github: String) {
    val context = LocalContext.current
    Row {
        Button(
            onClick = {
                toast(author)
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
                    data = Uri.parse(github)
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

@Composable
@Preview(showBackground = true)
fun GreetingPreview() {
    CodeCrackTheme {
        AppBody()
    }
}