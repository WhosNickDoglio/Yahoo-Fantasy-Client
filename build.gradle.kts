/*
 * MIT License
 *
 * Copyright (c) 2020. Nicholas Doglio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import org.jetbrains.dokka.gradle.DokkaTask

/*
 * MIT License
 *
 * Copyright (c) 2020. Nicholas Doglio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

plugins {
    kotlin("jvm") version "1.3.72"
    kotlin("kapt") version "1.3.72"
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
    id("io.gitlab.arturbosch.detekt") version "1.10.0"
    id("org.jetbrains.dokka") version "0.10.1"
    id("com.github.ben-manes.versions") version "0.28.0"
    jacoco // TODO might have to use the JunitJacoco Plugin instead?
}

ktlint {
    version.set("0.37.2")
    outputColorName.set("RED")
    disabledRules.set(setOf("import-ordering"))
}

jacoco {
    toolVersion = "0.8.5"
}

// TODO think about how to publish this
group = "com.nicholasdoglio"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("com.squareup.okhttp3:okhttp:4.8.0")

    implementation("com.github.scribejava:scribejava-apis:6.9.0")
    implementation("com.github.scribejava:scribejava-httpclient-okhttp:6.9.0")

    // TODO This might have to be API to expose Kotlin extensions
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    implementation("com.squareup.moshi:moshi:1.9.3")
    // TODO this might not be necessary
    implementation("com.squareup.moshi:moshi-adapters:1.9.3")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.9.3")

    testImplementation("junit:junit:4.13")
    testImplementation("com.google.truth:truth:1.0.1")
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "6.5.1"
}

tasks {
    val dokka by getting(DokkaTask::class) {
        outputFormat = "html"
        outputDirectory = "buildDir/dokka"
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
