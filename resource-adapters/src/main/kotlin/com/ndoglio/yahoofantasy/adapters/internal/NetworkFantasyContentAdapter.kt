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

package com.ndoglio.yahoofantasy.adapters.internal

import com.ndoglio.yahoofantasy.networkresources.core.LeagueListItem
import com.ndoglio.yahoofantasy.networkresources.core.NetworkFantasyContent
import com.ndoglio.yahoofantasy.networkresources.core.NetworkLeague
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

public class NetworkFantasyContentAdapter {

    @FromJson
    public fun fromJson(jsonReader: JsonReader, delegate: JsonAdapter<NetworkLeague>): NetworkFantasyContent? {
        return TODO()
    }

    @ToJson
    public fun toJson(jsonWriter: JsonWriter, data: LeagueListItem, delegate: JsonAdapter<NetworkLeague>) {
        when (data) {
            is NetworkLeague -> delegate.toJson(jsonWriter, data)
            // else -> jsonWriter.value()
            else -> TODO()
        }
    }
}
