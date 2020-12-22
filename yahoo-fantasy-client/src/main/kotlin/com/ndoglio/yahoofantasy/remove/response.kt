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

import com.ndoglio.yahoofantasy.core.appendFormatJsonEveryRequestInterceptor
import com.ndoglio.yahoofantasy.resources.FantasyResponse
import com.ndoglio.yahoofantasy.resources.internal.YahooFantasyService
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val GAME_ID = "nba"
private const val LEAGUE_ID = "3448"

private fun main() {

    val okHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .addInterceptor(appendFormatJsonEveryRequestInterceptor)
        .build()

    val moshi = Moshi.Builder().build()

    val service = YahooFantasyService.createService(okHttpClient, moshi)

    service.requestLeagueMetadata(
        gameId = GAME_ID,
        leagueId = LEAGUE_ID,
    ).enqueue(object : Callback<FantasyResponse> {
        override fun onResponse(call: Call<FantasyResponse>, response: Response<FantasyResponse>) {
            val content = response.body()!!

            println(content)
        }

        override fun onFailure(call: Call<FantasyResponse>, t: Throwable) {
            println(t.message)
        }
    })
}
