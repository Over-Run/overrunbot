package org.overrun.over.run.bot;

import kotlin.Unit;
import love.forte.simbot.application.Applications;
import love.forte.simbot.component.kook.KookBotManager;
import love.forte.simbot.component.kook.KookComponent;
import love.forte.simbot.component.mirai.MiraiComponent;
import love.forte.simbot.component.mirai.bot.MiraiBotManager;
import love.forte.simbot.component.qguild.QQGuildBotManager;
import love.forte.simbot.component.qguild.QQGuildComponent;
import love.forte.simbot.core.application.Simple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimBotImpl {
    public static final Logger logger = LoggerFactory.getLogger("over-run-bot");
    public static final ConfigInit configInit = new ConfigInit();

    static {
        configInit.init();
    }

    public static void main(String[] args) {

        logger.info("test");
        final var builder = Applications
                .buildSimbotApplication(Simple.INSTANCE);
        builder.config(config -> {

        });
        builder.build((build, config) -> {
            build.install(MiraiComponent.Factory, (__, ___) -> Unit.INSTANCE);
            build.install(MiraiBotManager.Factory, (__, ___) -> Unit.INSTANCE);
            build.install(QQGuildComponent.Factory, (__, ___) -> Unit.INSTANCE);
            build.install(QQGuildBotManager.Factory, (__, ___) -> Unit.INSTANCE);
            build.install(KookComponent.Factory, (__, ___) -> Unit.INSTANCE);
            build.install(KookBotManager.Factory, (__, ___) -> Unit.INSTANCE);

        });

        final var app = builder.createBlocking();


        final var elm = app.getEventListenerManager();
//        elm.register(SimpleListeners.listener(
//                FriendMessageEvent.Key,
//                (context, event) -> {
//                    final String textContent = context.getTextContent();
//                    return "喵".equals(textContent);
//                },
//                (context, event) -> {
//                    event.replyBlocking("喵喵喵");
//                }
//        ));

        app.joinBlocking();

    }
}
