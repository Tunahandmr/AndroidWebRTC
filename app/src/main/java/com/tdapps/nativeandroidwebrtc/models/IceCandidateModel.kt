package com.tdapps.nativeandroidwebrtc.models

data class IceCandidateModel(
    val sdpMid: String,
    val sdpMLineIndex: Double,
    val sdpCandidate: String
)
