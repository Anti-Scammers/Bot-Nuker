package me.trolman.nuke

import net.dv8tion.jda.api.JDA

open class Bot {
    companion object {
        private var jda: JDA? = null;
        fun getJda() : JDA {
            return jda!!
        }
        fun setJda(value : JDA) {
            jda = value
        }
    }
}