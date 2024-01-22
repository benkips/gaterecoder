// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    //hilt
    id ("com.google.dagger.hilt.android") version "2.44" apply false
}
buildscript {

    extra.apply{
        set("navigationVersion", "2.5.0")
        set("hiltVersion", "2.44")
        set("glideVersion", "4.11.0")
        set("hiltAndroidXVersion", "1.0.0-alpha03")
        set("pagingVersion", "3.0.0-alpha05")
        set("retrofitVersion", "2.9.0")
        set("testExtJunitVersion", "1.1.1")
    }

}