# version

该工程是一个 gradle 插件工程，用于组件化工程的版本统一管理。

**如何使用**
+ 在组件工程的顶层 build.gradle 里添加如下代码
    ```
    buildscript {
        repositories {
            ···
            maven { url "http://artifactory.jd.com/plugins-snapshots-local" }   // 如果是发布到本地仓库，则替换为 mavenLocal()
        }
        dependencies {
            ···
            classpath 'com.step2hell.version:plugin:1.0.0-SNAPSHOT'
        }
    }
    ```
+ 在所有需要使用版本管理的 module 对应的 build.gradle 文件开头添加如下代码
    ```
    import com.step2hell.version.*

    ···
    apply plugin: 'com.step2hell.version'
    ```
+ sync 成功后便可在 module 的 build.gradle 引用插件定义的相关版本依赖。引用的方式有如下两种，建议使用后一种（这里以 RecyclerView 为例）
    ```
    implementation "androidx.recyclerview:recyclerview:$Versions.recyclerview"
    implementation Dependencies.recyclerview
    ```

**如何修改插件中定义的版本号**
+ 拉取 version 工程最新的代码，在 VersionManager.kt 中修改你想要变更的版本号并提交。
+ 本地运行 `gradle clean :plugin:publish` 命令发布插件（也可以在 Android Studio 右侧的 Gradle Tasks 里找到相应的 task：plugin -> Tasks -> publishing -> publish）

**注意事项**
+ 京东 maven 私服需要身份验证，所以在发布插件前请将自己的用户名和密码按照如下格式写入本地文件 ~/.gradle/gradle.properties
    ```
    USER_NAME=1step2hell
    PASS_WORD=hahaha
    ```
+ 插件发布不要升级插件版本，约定一直使用快照版本 `com.step2hell.version:plugin:1.0.0-SNAPSHOT`，避免大家在插件更新后还得去修改引用的插件版本号。
+ 如果是发布到本地仓库 mavenLocal()，则替换发布指令为 `gradle clean :plugin:publishToMavenLocal`