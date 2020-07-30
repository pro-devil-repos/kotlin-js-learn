plugins {
    kotlin("js") version "1.4.0-rc"
}
group = "pro.devil"
version = "1.0-SNAPSHOT"

val kotlinReactVersion = "16.13.1-pre.109-kotlin-1.4.0-rc"
val reactVersion = "16.13.1"
val kotlinHtmlVersion = "0.7.1-1.4.0-rc"
val kotlinStyledVersion = "1.0.0-pre.109-kotlin-1.4.0-rc"
val kotlinCoroutinesVersion = "1.3.8-1.4.0-rc"

repositories {
    mavenCentral()
    jcenter()
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
    }
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlinx")
    }
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlin-js-wrappers")
    }
}

dependencies {
    testImplementation(kotlin("test-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:$kotlinHtmlVersion")
    implementation("org.jetbrains:kotlin-react:$kotlinReactVersion")
    implementation("org.jetbrains:kotlin-react-dom:$kotlinReactVersion")
    implementation("org.jetbrains:kotlin-styled:$kotlinStyledVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")

    implementation(npm("react", reactVersion))
    implementation(npm("react-dom", reactVersion))
    implementation(npm("styled-components", "latest"))
    implementation(npm("inline-style-prefixer", "latest"))
    implementation(npm("react-player", "latest"))
    implementation(npm("react-share", "latest"))
}

kotlin {
    js {
        browser {
            binaries.executable()
            webpackTask {
                cssSupport.enabled = true
            }
            runTask {
                cssSupport.enabled = true
            }
            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
    }
}