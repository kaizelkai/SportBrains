plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "kabre.m2.sportbrains"
    compileSdk = 35

    defaultConfig {
        applicationId = "kabre.m2.sportbrains"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.1"

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.media3.common.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    implementation("com.airbnb.android:lottie:6.1.0")
    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    implementation("com.google.code.gson:gson:2.8.8")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation ("de.hdodenhof:circleimageview:3.1.0")



    implementation("com.google.android.material:material:1.12.0")

    implementation("androidx.activity:activity:1.10.1")
    implementation("androidx.work:work-runtime-ktx:2.10.1")
    // Room
    implementation("androidx.room:room-runtime:2.7.1")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.1.0")

}