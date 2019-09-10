package com.wzk.handler.handler

import java.util.concurrent.ArrayBlockingQueue

class MessageQueue {
    val queue = ArrayBlockingQueue<Message>(50)
    fun enqueueMessage(m: Message) {
        queue.put(m)
    }

    fun next(): Message? {
        return queue.take()
    }

}