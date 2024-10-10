package com.tdapps.nativeandroidwebrtc.utils

import com.tdapps.nativeandroidwebrtc.models.MessageModel

interface NewMessageInterface {
    fun onNewMessage(message: MessageModel)
}