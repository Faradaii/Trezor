package com.faradaii.trezor.core.data.datasource.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoinResponse(

    @field:SerializedName("symbol")
    val symbol: String? = null,

    @field:SerializedName("sentiment_votes_up_percentage")
    val sentimentVotesUpPercentage: Int? = null,

    @field:SerializedName("asset_platform_id")
    val assetPlatformId: String? = null,

    @field:SerializedName("public_notice")
    val publicNotice: String? = null,

    @field:SerializedName("description")
    val description: Description? = null,

    @field:SerializedName("market_cap_rank")
    val marketCapRank: Int? = null,

    @field:SerializedName("watchlist_portfolio_users")
    val watchlistPortfolioUsers: Int? = null,

    @field:SerializedName("platforms")
    val platforms: Platforms? = null,

    @field:SerializedName("sentiment_votes_down_percentage")
    val sentimentVotesDownPercentage: Int? = null,

    @field:SerializedName("additional_notices")
    val additionalNotices: List<String?>? = null,

    @field:SerializedName("preview_listing")
    val previewListing: Boolean? = null,

    @field:SerializedName("web_slug")
    val webSlug: String? = null,

    @field:SerializedName("links")
    val links: Links? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("categories")
    val categories: List<String?>? = null,

    @field:SerializedName("genesis_date")
    val genesisDate: String? = null,

    @field:SerializedName("image")
    val image: Image? = null,

    @field:SerializedName("last_updated")
    val lastUpdated: String? = null,

    @field:SerializedName("community_data")
    val communityData: CommunityData? = null,

    @field:SerializedName("country_origin")
    val countryOrigin: String? = null,

    @field:SerializedName("market_data")
    val marketData: MarketData? = null,

    @field:SerializedName("block_time_in_minutes")
    val blockTimeInMinutes: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("hashing_algorithm")
    val hashingAlgorithm: String? = null,
) : Parcelable

@Parcelize
data class MarketData(

    @field:SerializedName("circulating_supply")
    val circulatingSupply: Int? = null,

    @field:SerializedName("last_updated")
    val lastUpdated: String? = null,

    @field:SerializedName("total_supply")
    val totalSupply: Int? = null,

    @field:SerializedName("max_supply")
    val maxSupply: Int? = null,

    @field:SerializedName("current_price")
    val currentPrice: CurrentPrice? = null,

    @field:SerializedName("max_supply_infinite")
    val maxSupplyInfinite: Boolean? = null,
) : Parcelable

@Parcelize
data class CommunityData(

    @field:SerializedName("twitter_followers")
    val twitterFollowers: Int? = null,

    @field:SerializedName("telegram_channel_user_count")
    val telegramChannelUserCount: Int? = null,

    @field:SerializedName("facebook_likes")
    val facebookLikes: Int? = null,

    @field:SerializedName("reddit_subscribers")
    val redditSubscribers: Int? = null,

    @field:SerializedName("reddit_average_posts_48h")
    val redditAveragePosts48h: Int? = null,

    @field:SerializedName("reddit_average_comments_48h")
    val redditAverageComments48h: Int? = null,

    @field:SerializedName("reddit_accounts_active_48h")
    val redditAccountsActive48h: Int? = null,
) : Parcelable

@Parcelize
data class Links(

    @field:SerializedName("subreddit_url")
    val subredditUrl: String? = null,

    @field:SerializedName("official_forum_url")
    val officialForumUrl: List<String?>? = null,

    @field:SerializedName("telegram_channel_identifier")
    val telegramChannelIdentifier: String? = null,

    @field:SerializedName("repos_url")
    val reposUrl: ReposUrl? = null,

    @field:SerializedName("facebook_username")
    val facebookUsername: String? = null,

    @field:SerializedName("snapshot_url")
    val snapshotUrl: String? = null,

    @field:SerializedName("blockchain_site")
    val blockchainSite: List<String?>? = null,

    @field:SerializedName("whitepaper")
    val whitepaper: String? = null,

    @field:SerializedName("twitter_screen_name")
    val twitterScreenName: String? = null,

    @field:SerializedName("chat_url")
    val chatUrl: List<String?>? = null,

    @field:SerializedName("homepage")
    val homepage: List<String?>? = null,
) : Parcelable

@Parcelize
data class CurrentPrice(

    @field:SerializedName("usd")
    val usd: Int? = null,

    @field:SerializedName("xdr")
    val xdr: Int? = null,

    @field:SerializedName("eos")
    val eos: Int? = null,

    @field:SerializedName("sgd")
    val sgd: Int? = null,

    @field:SerializedName("vef")
    val vef: Int? = null,

    @field:SerializedName("bnb")
    val bnb: Int? = null,

    @field:SerializedName("eth")
    val eth: Int? = null,

    @field:SerializedName("nzd")
    val nzd: Int? = null,

    @field:SerializedName("brl")
    val brl: Int? = null,

    @field:SerializedName("xag")
    val xag: Int? = null,

    @field:SerializedName("chf")
    val chf: Int? = null,

    @field:SerializedName("mxn")
    val mxn: Int? = null,

    @field:SerializedName("clp")
    val clp: Int? = null,

    @field:SerializedName("bits")
    val bits: Int? = null,

    @field:SerializedName("zar")
    val zar: Int? = null,

    @field:SerializedName("vnd")
    val vnd: Long? = null,

    @field:SerializedName("xau")
    val xau: Int? = null,

    @field:SerializedName("aud")
    val aud: Int? = null,

    @field:SerializedName("ils")
    val ils: Int? = null,

    @field:SerializedName("idr")
    val idr: Int? = null,

    @field:SerializedName("xrp")
    val xrp: Int? = null,

    @field:SerializedName("try")
    val jsonMemberTry: Int? = null,

    @field:SerializedName("hkd")
    val hkd: Int? = null,

    @field:SerializedName("twd")
    val twd: Int? = null,

    @field:SerializedName("aed")
    val aed: Int? = null,

    @field:SerializedName("eur")
    val eur: Int? = null,

    @field:SerializedName("dkk")
    val dkk: Int? = null,

    @field:SerializedName("bch")
    val bch: Int? = null,

    @field:SerializedName("cad")
    val cad: Int? = null,

    @field:SerializedName("myr")
    val myr: Int? = null,

    @field:SerializedName("dot")
    val dot: Int? = null,

    @field:SerializedName("link")
    val link: Int? = null,

    @field:SerializedName("mmk")
    val mmk: Int? = null,

    @field:SerializedName("nok")
    val nok: Int? = null,

    @field:SerializedName("gel")
    val gel: Int? = null,

    @field:SerializedName("btc")
    val btc: Int? = null,

    @field:SerializedName("lkr")
    val lkr: Int? = null,

    @field:SerializedName("ngn")
    val ngn: Int? = null,

    @field:SerializedName("czk")
    val czk: Int? = null,

    @field:SerializedName("pkr")
    val pkr: Int? = null,

    @field:SerializedName("sek")
    val sek: Int? = null,

    @field:SerializedName("ltc")
    val ltc: Int? = null,

    @field:SerializedName("uah")
    val uah: Int? = null,

    @field:SerializedName("bhd")
    val bhd: Int? = null,

    @field:SerializedName("ars")
    val ars: Int? = null,

    @field:SerializedName("sar")
    val sar: Int? = null,

    @field:SerializedName("inr")
    val inr: Int? = null,

    @field:SerializedName("cny")
    val cny: Int? = null,

    @field:SerializedName("thb")
    val thb: Int? = null,

    @field:SerializedName("krw")
    val krw: Int? = null,

    @field:SerializedName("jpy")
    val jpy: Int? = null,

    @field:SerializedName("bdt")
    val bdt: Int? = null,

    @field:SerializedName("pln")
    val pln: Int? = null,

    @field:SerializedName("gbp")
    val gbp: Int? = null,

    @field:SerializedName("bmd")
    val bmd: Int? = null,

    @field:SerializedName("huf")
    val huf: Int? = null,

    @field:SerializedName("xlm")
    val xlm: Int? = null,

    @field:SerializedName("sats")
    val sats: Int? = null,

    @field:SerializedName("kwd")
    val kwd: Int? = null,

    @field:SerializedName("php")
    val php: Int? = null,

    @field:SerializedName("yfi")
    val yfi: Int? = null,

    @field:SerializedName("rub")
    val rub: Int? = null,
) : Parcelable

@Parcelize
data class Description(

    @field:SerializedName("en")
    val en: String? = null,
) : Parcelable


@Parcelize
data class ReposUrl(

    @field:SerializedName("github")
    val github: List<String?>? = null,

    @field:SerializedName("bitbucket")
    val bitbucket: List<String?>? = null,
) : Parcelable

@Parcelize
data class Image(

    @field:SerializedName("small")
    val small: String? = null,

    @field:SerializedName("large")
    val large: String? = null,

    @field:SerializedName("thumb")
    val thumb: String? = null,
) : Parcelable

@Parcelize
data class Platforms(

    @field:SerializedName("")
    val jsonMember: String? = null,
) : Parcelable
