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
}

group = "com.ndoglio.yahoo-fantasy-client"
version = "0.1.0-SNAPSHOT"

dependencies {
    implementation(project(":resources"))
    implementation(project(":resource-adapters"))
    implementation(project(":core"))

    implementation(Square.okHttp3.okHttp)
    implementation(Square.okHttp3.loggingInterceptor)

    implementation("com.github.scribejava:scribejava-apis:_")

    implementation(Square.retrofit2.retrofit)
    implementation(Square.retrofit2.converter.moshi)
    implementation(Square.moshi)
    implementation("com.squareup.moshi:moshi-adapters:_")

    testImplementation(Testing.junit4)
    testImplementation("com.google.truth:truth:_")

    // TODO validate models?
    testImplementation("org.jetbrains.kotlin:kotlin-reflect:_")
    testImplementation("io.github.classgraph:classgraph:_")
    testImplementation("uk.co.jemos.podam:podam:_")
}
