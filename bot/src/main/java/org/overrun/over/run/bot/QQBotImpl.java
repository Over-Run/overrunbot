package org.overrun.over.run.bot;

import kotlin.Unit;
import love.forte.simbot.application.Applications;
import love.forte.simbot.component.mirai.MiraiComponent;
import love.forte.simbot.component.mirai.bot.MiraiBotManager;
import love.forte.simbot.core.application.Simple;
import love.forte.simbot.core.event.SimpleListeners;
import love.forte.simbot.event.FriendMessageEvent;

public class QQBotImpl {
    public static void main(String[] args) {
        final var builder = Applications
                .buildSimbotApplication(Simple.INSTANCE);
        builder.config(config -> {

        });
        builder.build((build, config) -> {
            build.install(MiraiComponent.Factory, (config1, perceivable) -> Unit.INSTANCE);
            build.install(MiraiBotManager.Factory, (config1, perceivable) -> Unit.INSTANCE);
        });

        final var app = builder.createBlocking();


        final var elm = app.getEventListenerManager();
        elm.register(SimpleListeners.listener(
                FriendMessageEvent.Key,
                (context, event) -> {
                    final String textContent = context.getTextContent();
                    return "喵".equals(textContent);
                },
                (context, event) -> {
                    event.replyBlocking("喵喵喵");
                }
        ));

        app.joinBlocking();
    }
}
