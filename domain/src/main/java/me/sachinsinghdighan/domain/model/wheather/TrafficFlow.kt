package me.sachinsinghdighan.domain.model.wheather

data class TrafficFlow(
    val flowSegmentData: FlowSegmentData
)

data class FlowSegmentData(
    val frc: String?,
    val currentSpeed: Int?,
    val freeFlowSpeed: Int?,
    val currentTravelTime: Int?,
    val freeFlowTravelTime: Int?,
    val confidence: Float?,
    val roadClosure: Boolean?,
    val coordinates: Coordinates?,
    val version: String?
)

data class Coordinates(
    val coordinate: List<Coordinate>
)

data class Coordinate(
    val latitude: Double,
    val longitude: Double
) 