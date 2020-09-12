/*
 * MIT License
 *
 * Copyright (c) 2020 Nicholas Doglio
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
    kotlin("jvm")
    id("io.gitlab.arturbosch.detekt")
    id("org.jlleitschuh.gradle.ktlint")
    id("com.github.ben-manes.versions")
    id("org.jetbrains.dokka")
    jacoco
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

kotlin {
    explicitApi()
}

jacoco {
    toolVersion = "0.8.5"
}

ktlint {
    version.set("0.38.1")
    outputColorName.set("RED")
    disabledRules.set(setOf("import-ordering"))
}

group = "com.ndoglio.yahoo-fantasy-client"
version = "0.1.0"

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")

    implementation("com.github.scribejava:scribejava-apis:7.1.1")
    implementation("com.github.scribejava:scribejava-httpclient-okhttp:7.1.1")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-jaxb:2.9.0")

    implementation("javax.xml.bind:jaxb-api:2.3.1")
    implementation("org.glassfish.jaxb:jaxb-runtime:2.3.1")

    testImplementation("junit:junit:4.13")
    testImplementation("com.google.truth:truth:1.0.1")

    // TODO validate models?
    testImplementation("org.jetbrains.kotlin:kotlin-reflect:1.4.10")
    testImplementation("io.github.classgraph:classgraph:4.8.90")
    testImplementation("uk.co.jemos.podam:podam:7.2.5.RELEASE")
}
