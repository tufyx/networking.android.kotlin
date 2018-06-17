package com.tufyx.networking

internal class Config {

    internal object Timeouts {
        val READ = 20000
        val WRITE = 20000
        val CONNECT = 20000
    }
}
