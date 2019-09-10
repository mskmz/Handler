package com.wzk.handler.handler


class Looper private constructor() {
    lateinit var mQueue: MessageQueue;

    var m: Message? = null

    companion object {
        private val threadLocal = ThreadLocal<Looper>()
        fun myLooper(): Looper? {
            return threadLocal.get()
        }

        fun prepare() {
            threadLocal.set(Looper())
        }
    }

    fun loop() {
        // 从全局ThreadLocalMap中获取唯一：Looper对象
        val me = myLooper()
        // 从Looper对象中获取全局唯一消息队列MessageQueue对象
        mQueue = me!!.mQueue
        while (true) {
            m = mQueue.next()
            m?.target?.dispatchMessage(m!!)
        }
    }

}