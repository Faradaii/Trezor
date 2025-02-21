package com.faradaii.trezor.core.data.datasource.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RoiResponse(

    @field:SerializedName("times")
    val times: Double? = null,

    @field:SerializedName("percentage")
    val percentage: Double? = null,

    @field:SerializedName("currency")
    val currency: String? = null,
) : Parcelable