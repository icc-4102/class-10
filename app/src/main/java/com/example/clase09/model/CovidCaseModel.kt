package com.example.clase09.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CovidCaseModel (
    val updated: Long?,
    val country: String,
    val cases: Long,
    val todayCases: Long,
    val deaths: Long,
    val todayDeaths: Long?,
    val recovered: Long,
    val active: Long,
): Parcelable