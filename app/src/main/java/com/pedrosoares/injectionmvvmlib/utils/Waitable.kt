package com.pedrosoares.injectionmvvmlib.utils

class Waitable<T> {

    private val lock = java.lang.Object()

    private var value: T? = null

    fun wait(): T? {
        synchronized(lock) {
            lock.wait()
            return value
        }
    }

    fun setValue(value: T) {
        synchronized(lock) {
            this.value = value
            lock.notifyAll()
        }
    }

    fun empty() {
        synchronized(lock) {
            this.value = null
            lock.notifyAll()
        }
    }
}