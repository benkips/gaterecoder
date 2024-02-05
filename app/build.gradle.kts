plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
}
val navigationVersion =rootProject.extra["navigationVersion"]
val hiltVersion = rootProject.extra["hiltVersion"]
val hiltAndroidXVersion = rootProject.extra["hiltAndroidXVersion"]
val retrofitVersion = rootProject.extra["retrofitVersion"]

android {
    namespace = "com.example.kabetegaterecoder"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kabetegaterecoder"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //making it fit for all screens
    implementation("com.intuit.sdp:sdp-android:1.0.6")

    //splash screen
    implementation("androidx.core:core-splashscreen:1.1.0-alpha02")

    // Dagger Hilt
    implementation( "com.google.dagger:hilt-android:$hiltVersion")
    kapt ("com.google.dagger:hilt-android-compiler:$hiltVersion")
    kapt( "androidx.hilt:hilt-compiler:$hiltAndroidXVersion")

    // Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation ("androidx.navigation:navigation-ui-ktx:$navigationVersion")
    // Retrofit + GSON
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    //help with pending intent
    implementation ("androidx.work:work-runtime-ktx:2.7.0")

    //These dependencies Result API
    implementation ("androidx.activity:activity:1.2.0-alpha08")
    implementation ("androidx.fragment:fragment:1.3.0-alpha08")

}