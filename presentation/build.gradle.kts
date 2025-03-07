plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    alias(libs.plugins.androidx.navigation.safeargs.kotlin)
    alias(libs.plugins.google.dagger.hilt.android)
}

android {
    namespace = "com.pnhglobal.ovipay"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.pnhglobal.ovipay"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        val baseUrl: String = project.properties["baseUrl"] as String
        val baseUrlDebug: String = project.properties["baseUrlDebug"] as String

        getByName("debug") {
            isMinifyEnabled = false
            isJniDebuggable = true
            signingConfig = signingConfigs.getByName("debug")

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        defaultConfig {
            buildConfigField("String", "BASE_URL", baseUrl)
            buildConfigField("String", "BASE_URL_DEBUG", baseUrlDebug)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        buildConfig = true
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(libs.material)
    implementation(libs.androidx.activity)
    testImplementation(libs.junit)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Retrofit + Okhttp
    implementation(libs.retrofit2.retrofit)
    implementation(libs.retrofit2.retrofit.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    // Gson
    implementation(libs.gson)

    // androidX <
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.viewmodel.android)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.paging)
    //noinspection KaptUsageInsteadOfKsp
    kapt(libs.androidx.room.compiler)

    // Coroutine
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Paging 3.0
    implementation(libs.androidx.paging.runtime.ktx)
    testImplementation(libs.androidx.paging.common)

    // Navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Coil
    implementation(libs.coil)

    implementation(libs.view.binding.property.delegate)
}

kapt {
    correctErrorTypes = true
}