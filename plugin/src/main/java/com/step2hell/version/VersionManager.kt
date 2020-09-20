package com.step2hell.version

object Versions {
    val compileSdkVersion = 29
    val buildToolsVersion = "29.0.3"
    val minSdkVersion = 21
    val targetSdkVersion = 29

    val appcompat = "1.1.0"
    val material = "1.2.1"
    val recyclerview = "1.1.0"
    val fragment = "1.2.1"
    val constraint = "2.0.1"
    val coreKtx = "1.3.0"
    val kotlin = "1.3.72"
    val coroutines = "1.3.7"
    val junit = "1.1.2"
    val ruler = "1.3.0"
    val runner = "1.3.0"
}

object Dependencies {
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val material = "com.google.android.material:material:${Versions.material}"
    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    val fragment = "androidx.fragment:fragment:${Versions.fragment}"
    val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    val constraint ="androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    val coroutines ="org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val junit = "androidx.test.ext:junit:${Versions.junit}"
    val ruler = "androidx.test:rules:${Versions.ruler}"
    val runner = "androidx.test:runner:${Versions.runner}"
}
