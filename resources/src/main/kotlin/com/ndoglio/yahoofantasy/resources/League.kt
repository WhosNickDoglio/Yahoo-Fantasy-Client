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

package com.ndoglio.yahoofantasy.resources

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
public data class League(
    @Json(name = "league_key") val leagueKey: String,
    @Json(name = "league_id") val leagueId: String,
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String?, // https://basketball.fantasysports.yahoo.com/2019/nba/15785
    @Json(name = "logo_url") val logoUrl: String?, // https://yahoofantasysports-res.cloudinary.com/image/upload/t_s192sq/fantasy-logos/56476173091_e8ebcb.jpg
    @Json(name = "password") val password: String?,
    @Json(name = "draft_status") val draftStatus: String?, // postdraft
    @Json(name = "num_teams") val numTeams: Int?, // 12
    @Json(name = "edit_key") val editKey: String?, // 2020-03-08
    @Json(name = "weekly_deadline") val weeklyDeadline: String?,
    @Json(name = "league_update_timestamp") val leagueUpdateTimestamp: String?, // 1591891909
    @Json(name = "scoring_type") val scoringType: String?, // headone TODO enum
    @Json(name = "league_type") val leagueType: String?, // private TODO enum
    @Json(name = "renew") val renew: String?, // 385_137475
    @Json(name = "renewed") val renewed: String?,
    @Json(name = "iris_group_chat_id") val irisGroupChatId: String?, // NFVDGLMMNRGFZOAOVUWXCY5GFI
    @Json(name = "short_invitation_url") val shortInvitationUrl: String?, // https://basketball.fantasysports.yahoo.com/2019/nba/15785/invitation?key=e59b1bceba6cea84&ikey=2535bf88a97fe29d
    @Json(name = "allow_add_to_dl_extra_pos") val allowAddToDlExtraPos: Boolean, // 1
    @Json(name = "is_pro_league") val isProLeague: Boolean, // 0
    @Json(name = "is_cash_league") val isCashLeague: Boolean, // 0
    @Json(name = "current_week") val currentWeek: Int, // 19
    @Json(name = "start_week") val startWeek: Int, // 1
    @Json(name = "start_date") val startDate: Date, // 2019-10-22
    @Json(name = "end_week") val endWeek: Int, // 19
    @Json(name = "end_date") val endDate: Date, // 2020-03-08
    @Json(name = "is_finished") val isFinished: Boolean, // 1
    @Json(name = "game_code") val gameCode: String, // nba
    @Json(name = "season") val season: Int // 2019
)
