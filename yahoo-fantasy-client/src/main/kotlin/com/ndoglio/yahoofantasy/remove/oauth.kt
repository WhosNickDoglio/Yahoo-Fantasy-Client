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

package com.ndoglio.yahoofantasy.remove

import com.github.scribejava.apis.YahooApi20
import com.github.scribejava.core.builder.ServiceBuilder
import com.github.scribejava.core.model.OAuth2AccessToken
import com.github.scribejava.core.model.OAuthConstants
import com.github.scribejava.core.model.OAuthRequest
import com.github.scribejava.core.model.Verb
import com.github.scribejava.core.oauth.OAuth20Service

private fun main() {
    val service: OAuth20Service =
        ServiceBuilder(
            "dj0yJmk9UVEzOTB4OFJpWXFzJmQ9WVdrOVIzSjFSbmN5TjJVbWNHbzlNQS0tJnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PTcy"
        )
            .apiSecret("951038ec9d345c41ab4542a52d3364c6f2d73291")
            .callback(OAuthConstants.OOB)
            .build(YahooApi20.instance())

    println("Now go and authorize ScribeJava here:")
    println(service.authorizationUrl)
    println("And paste the verifier here")
    print(">>")
    val oauthVerifier: String = readLine()!!
    println()

    println("Trading the Authorization Code for an Access Token...")
    val accessToken: OAuth2AccessToken = service.getAccessToken(oauthVerifier)
    println("Got the Access Token!")
    println(accessToken.rawResponse)
    println()

    println("Now we're going to access a protected resource...")
    val request = OAuthRequest(Verb.GET, "https://fantasysports.yahooapis.com/fantasy/v2/league/nba.l.15785/standings")
    service.signRequest(accessToken, request)

    val response = service.execute(request)
    println("RESPONSE: ${response.code}")
}
