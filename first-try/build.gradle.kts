plugins {
    kotlin("js") version "1.4.0-rc"
}

group = "pro.devil"
version = "1.0-SNAPSHOT"

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
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.1-1.4.0-rc")
    implementation("org.jetbrains:kotlin-react:16.13.1-pre.109-kotlin-1.4.0-rc")
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.109-kotlin-1.4.0-rc")
    implementation("org.jetbrains:kotlin-styled:1.0.0-pre.109-kotlin-1.4.0-rc")
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