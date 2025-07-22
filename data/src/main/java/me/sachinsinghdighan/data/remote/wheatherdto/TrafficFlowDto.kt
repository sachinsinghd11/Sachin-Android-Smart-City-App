package me.sachinsinghdighan.data.remote.wheatherdto

import com.google.gson.annotations.SerializedName

data class TrafficFlowDto(
    @SerializedName("flowSegmentData") val flowSegmentData: FlowSegmentDataDto
)

data class FlowSegmentDataDto(
    @SerializedName("frc") val frc: String?,
    @SerializedName("currentSpeed") val currentSpeed: Int?,
    @SerializedName("freeFlowSpeed") val freeFlowSpeed: Int?,
    @SerializedName("currentTravelTime") val currentTravelTime: Int?,
    @SerializedName("freeFlowTravelTime") val freeFlowTravelTime: Int?,
    @SerializedName("confidence") val confidence: Float?,
    @SerializedName("roadClosure") val roadClosure: Boolean?,
    @SerializedName("coordinates") val coordinates: CoordinatesDto?,
    @SerializedName("@version") val version: String?
)

data class CoordinatesDto(
    @SerializedName("coordinate") val coordinate: List<CoordinateDto>
)

data class CoordinateDto(
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double
) 