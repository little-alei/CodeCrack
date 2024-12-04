pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // 作为 Xposed 模块使用务必添加，其它情况可选
        maven {
            url = uri("https://api.xposed.info/")
        }
        maven {
            url = uri("https://jitpack.io")
        }
    }
}

rootProject.name = "Code Crack"
include(":app")
