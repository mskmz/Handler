package com.wzk.handler.handler

import java.lang.RuntimeException


class Handler {
    private var looper: Looper
    private val mQueue: MessageQueue

    init {
        if (Looper.myLooper() == null) {
            throw RuntimeException("请在线程中执行")
        }
        looper = Looper.myLooper()!!
        mQueue = looper.mQueue
    }

    fun sendMessage(m: Message) {
        enqueueMessage(m)
    }

    fun enqueueMessage(m: Message) {
        m.target = this
        mQueue.enqueueMessage(m)
    }

    fun dispatchMessage(msg: Message) {
        handleMessage(msg)
    }


    fun handleMessage(msg: Message) {}
}