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

package com.ndoglio.yahoofantasy.networkresources.core

import com.ndoglio.internal.annotations.IntAsBoolean
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

public sealed class LeagueListItem

@JsonClass(generateAdapter = true)
public data class NetworkLeague(
    @Json(name = "league_key") val leagueKey: String, // 395.l.15785
    @Json(name = "league_id") val leagueId: String, // 15785
    @Json(name = "name") val name: String, // Mitchell Robinson Fan Club
    @Json(name = "url") val url: String, // https://basketball.fantasysports.yahoo.com/2019/nba/15785
    @Json(name = "logo_url") val logoUrl: String, // https://yahoofantasysports-res.cloudinary.com/image/upload/t_s192sq/fantasy-logos/56476173091_e8ebcb.jpg
    @Json(name = "password") val password: String,
    @Json(name = "draft_status") val draftStatus: DraftStatus, // postdraft TODO ENUM
    @Json(name = "num_teams") val numTeams: Int, // 12
    @Json(name = "edit_key") val editKey: String, // 2020-03-08
    @Json(name = "weekly_deadline") val weeklyDeadline: String,
    @Json(name = "league_update_timestamp") val leagueUpdateTimestamp: String, // 1591891909
    @Json(name = "scoring_type") val scoringType: ScoringType, // headone TODO ENUM
    @Json(name = "league_type") val leagueType: LeagueType, // private TODO ENUM
    @Json(name = "renew") val renew: String, // 385_137475
    @Json(name = "renewed") val renewed: String, // TODO What is this?
    @Json(name = "iris_group_chat_id") val irisGroupChatId: String, // NFVDGLMMNRGFZOAOVUWXCY5GFI
    @Json(name = "short_invitation_url") val shortInvitationUrl: String, // https://basketball.fantasysports.yahoo.com/2019/nba/15785/invitation?key=e59b1bceba6cea84&ikey=2535bf88a97fe29d
    @Json(name = "allow_add_to_dl_extra_pos") @IntAsBoolean val allowAddToDlExtraPos: Boolean, // 1
    @Json(name = "is_pro_league") @IntAsBoolean val isProLeague: Boolean, // 0
    @Json(name = "is_cash_league") @IntAsBoolean val isCashLeague: Boolean, // 0
    @Json(name = "current_week") val currentWeek: Int, // 19
    @Json(name = "start_week") val startWeek: Int, // 1
    @Json(name = "start_date") val startDate: Date, // 2019-10-22 // TODO Date?
    @Json(name = "end_week") val endWeek: Int, // 19
    @Json(name = "end_date") val endDate: Date, // 2020-03-08 // TODO Date?
    @Json(name = "is_finished") @IntAsBoolean val isFinished: Boolean, // 1
    @Json(name = "game_code") val gameCode: String?, // nba // TODO enum?
    @Json(name = "season") val season: Int?, // 2019
) : LeagueListItem()
