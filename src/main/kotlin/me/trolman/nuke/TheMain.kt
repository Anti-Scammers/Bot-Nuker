package me.trolman.nuke

import me.trolman.nuke.events.Events
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.requests.GatewayIntent

private var TOKEN = "";

fun main(args: Array<String>) {
    TOKEN = args[0]
    Bot.setJda(JDABuilder.createDefault(getToken())
        .addEventListeners(Events())
        .enableIntents(GatewayIntent.MESSAGE_CONTENT)
        .enableIntents(GatewayIntent.GUILD_MEMBERS)
        .enableIntents(GatewayIntent.DIRECT_MESSAGES)
        .build())
    println("Listening to commands: ")
    println("spamChannels, createChannels, deleteChannels")
}


fun getToken(): String {
    return TOKEN
}