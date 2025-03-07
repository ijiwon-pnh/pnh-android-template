plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.pnhglobal.domain"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    testImplementation(libs.junit)
    androidTestImplementation(libs.junit)

    // Kotlin
    implementation(libs.kotlin.stdlib)
    implementation(libs.androidx.monitor)
    implementation(libs.androidx.junit.ktx)
    testImplementation(libs.kotlin.stdlib)

    // JavaX Inject
    implementation(libs.javax.inject)

    // Coroutine
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Paging 3.0
    implementation(libs.androidx.paging.runtime.ktx)
    testImplementation(libs.androidx.paging.common)
}