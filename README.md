# version

该工程是一个 gradle 插件工程，用于组件化工程的版本统一管理。

**如何使用**
+ 在组件工程的顶层 build.gradle 里添加如下代码
    ```
    buildscript {
        repositories {
            ···
            maven { url "http://artifactory.jd.com/plugins-snapshots-local" }
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
    implementation "androidx.recyclerview:recyclerview:$Versions.recyclerView"
    implementation Dependencies.recyclerView
    ```

**如何修改插件中定义的版本号**
+ 拉取 version 工程最新的代码，在 VersionManager.kt 中修改你想要变更的版本号并提交。
+ 本地运行 `gradle clean :plugin:publish` 命令发布插件（也可以在 Android Studio 右侧的 Gradle Tasks 里执行相应的 task：version -> plugin -> Tasks -> publishing -> publish）

**注意事项**
+ 京东 maven 私服需要身份验证，所以在发布插件前请将自己的用户名和密码按照如下格式写入本地文件 ${USER_HOME}/.gradle/gradle.properties
    ```
    USER_NAME=1step2hell
    PASS_WORD=hahaha
    ```
  或者通过 gradle 命令 -P 参数传递 `gradle clean :plugin:publish -PUSER_NAME='1step2hell' -PPASS_WORD='hahaha'`。
  需要注意的是，如果在文件中配置了账户密码，同时又在 gradle 参数中传递了账户密码，则以 gradle 命令中的为准（优先级最高）。
+ 新增依赖常量时，命名请尽量遵循以下规则：
    * 以依赖的 artifactId 为基准，在保证不冲突且不产生歧义的情况下 尽量精简名字
    * 过滤掉不支持的中横线 -
    * 使用驼峰命名法
+ 插件发布请一定不要升级插件版本，我们约定一直使用快照版本 `com.step2hell.version:plugin:1.0.0-SNAPSHOT`，避免大家在插件更新后还得去修改引用的插件版本号。
  如果组件工程出现缓存版本号一致而导致插件更新失败，请在组件工程的顶层 build.gradle 文件中配置如下缓存策略
    ```
    buildscript {
        configurations.all {
            resolutionStrategy {
                cacheChangingModulesFor 1, 'minutes'
                cacheDynamicVersionsFor 1, 'minutes'
            }
        }
        ···
    }
    ```
+ 如果是发布到本地仓库 mavenLocal()，则替换发布指令为 `gradle clean :plugin:publishToMavenLocal`。当然，相应的发布 url 和依赖 repository 也需要替换为 mavenLocal()。
+ 由于自身是 gradle 插件，所以该方式无法控制 module 工程的插件版本号。考虑到插件版本号的影响相对较小，是可以接受的。

**Todo**
+ 目前暂不支持依赖自动补全，待后续？
