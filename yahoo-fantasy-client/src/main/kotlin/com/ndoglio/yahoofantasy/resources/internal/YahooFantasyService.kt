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

package com.ndoglio.yahoofantasy.resources.internal

import com.ndoglio.yahoofantasy.resources.FantasyResponse
import com.ndoglio.yahoofantasy.resources.LeagueFantasyContent
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

/**
 * A Retrofit service that outlines all the API endpoints.
 */
internal interface YahooFantasyService {

    // <editor-fold desc="League endpoints">

    @Headers("Authorization: $AUTH")
    @GET("league/{GAME_ID}.l.{LEAGUE_ID}/metadata")
    fun requestLeagueMetadata(
        @Path("GAME_ID") gameId: String,
        @Path("LEAGUE_ID") leagueId: String,
    ): Call<FantasyResponse>

    @Headers("Authorization: $AUTH")
    @GET("league/{GAME_ID}.l.{LEAGUE_ID}/standings")
    fun requestLeagueStandings(
        @Path("GAME_ID") gameId: String,
        @Path("LEAGUE_ID") leagueId: String,
    ): Call<FantasyResponse>

    @Headers("Authorization: $AUTH")
    @GET("league/{GAME_ID}.l.{LEAGUE_ID}/transactions")
    fun requestLeagueTransactions(
        @Path("GAME_ID") gameId: String,
        @Path("LEAGUE_ID") leagueId: String,
    ): Call<LeagueFantasyContent>

    @Headers("Authorization: $AUTH")
    @GET("league/{GAME_ID}.l.{LEAGUE_ID}/settings")
    fun requestLeagueSettings(
        @Path("GAME_ID") gameId: String,
        @Path("LEAGUE_ID") leagueId: String,
    ): Call<LeagueFantasyContent>

    @Headers("Authorization: $AUTH")
    @GET("league/{GAME_ID}.l.{LEAGUE_ID}/scoreboard")
    fun requestLeagueScoreboard(
        @Path("GAME_ID") gameId: String,
        @Path("LEAGUE_ID") leagueId: String,
    ): Call<LeagueFantasyContent>

    @Headers("Authorization: $AUTH")
    @GET("league/{GAME_ID}.l.{LEAGUE_ID}/teams")
    fun requestLeagueTeams(
        @Path("GAME_ID") gameId: String,
        @Path("LEAGUE_ID") leagueId: String,
    ): Call<LeagueFantasyContent>

    @Headers("Authorization: $AUTH")
    @GET("league/{GAME_ID}.l.{LEAGUE_ID}/players")
    fun requestLeaguePlayers(
        @Path("GAME_ID") gameId: String,
        @Path("LEAGUE_ID") leagueId: String,
    ): Call<LeagueFantasyContent>

    @Headers("Authorization: $AUTH")
    @GET("league/{GAME_ID}.l.{LEAGUE_ID}/draftresults")
    fun requestLeagueDraftResults(
        @Path("GAME_ID") gameId: String,
        @Path("LEAGUE_ID") leagueId: String,
    ): Call<LeagueFantasyContent>

    // </editor-fold>

    companion object {
        @Suppress("MaxLineLength")
        private const val TOKEN: String =
            "TZfbqrGd5geJTs5BijsI6hL9R7eXPCD3pfKgajnREojpGzrY6uZnqrA0Ndb1PysXzlIW17uS4et0tbldebeSG2u2mB.P.geeqOrO4dM5Vzb.1j.lPDgQB68hABeg3oQMn_vrM5iJ7sSa02NHJYZOShWSN0CxWpfJ5vbENlvAjRsBZ5hfxAB6eB7b_epSOkENOQ1ipWL50SmBOJtO4DcI00wukIrY11mhuy64VPS7AhbIkC4aK.K0r7z4KOLlm.XyTYlgfhPINGNjYBs1xhe50fS3_0CIY0ufvpaI19Y9lj1Bm17rhaekCzM4IJ8HWQE9E39JPNDPTt8y6LGlEaRrbTPbbpYc1qRHT1h_WwZ_T2WdzhGNj3DDPXXl7knf9tUNsDS2gnFGUi4UbwEu3A2PGLYef7m6.DRfvO2t4OSCiNSiKwPMCy5LyRDAzodhY..pOeuc5hw9ko0Dm6bftG.VSMEVcOMYcFbXLxHuCJT4Z7lJ8UvRugtygbGmpCUXESuuCJnJu4zbRhXTkZKlTkQ.v8B3dMIbTHsEewZHTJ.kPqe57Vg6EBbJzOh_.r6DI5q15gjyedRmnT_s5gXq2K6dDA2JtyfvsxOOgpk9o1VNnCchah4W_oQL8BtyiKsoSzfmXmZwrZtqMNeCvKipF08tDzovrhfIzybJEjZnAhD_8rL1mSEE2s8LAKODM4y1ZZmTa9sB0OAVxuZ5i.M4XSfQkC_msHG4IawuQq_iUtazDD17u1BfVUwrCyXRjbj6u0rd5GChEeww_aUZo7.UdnRyCPdgQduGAfnmZYp0LE8z2mGrxkF7Bv3DDrlXWQqBqbM_zXho5scg4_ppl_hmX7z8pKypOEpqLg_oPDkeRU1bbLQleclI91Bs6jTftg56T9h79DM5NqIX7CFfVctyQ1mxyQ8d68nV_UZspZEbUz6Lflp4VG9h.K_v8Pr8UnDT.B4h1PZ7H0ZJAz0RSuaoPC1FoA04uTu.FVnp_v9yuq4r7cIhy7Z7fQJ0FJI-"
        private const val AUTH: String = "Bearer $TOKEN"

        private const val API_BASE_URL = "https://fantasysports.yahooapis.com/fantasy/v2/"

        internal fun createService(
            okHttpClient: OkHttpClient,
            moshi: Moshi
        ): YahooFantasyService = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(API_BASE_URL)
            .client(okHttpClient)
            .build()
            .create()
    }
}
