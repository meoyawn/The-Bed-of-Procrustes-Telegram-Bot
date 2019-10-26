package procrustes

import com.google.common.io.Resources
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import java.nio.charset.Charset

private class Bot(val aphorisms: List<String>) : TelegramLongPollingBot() {

    override fun getBotUsername(): String =
        "the_bed_of_procrustes_bot"

    override fun getBotToken(): String =
        BuildConfig.BOT_TOKEN

    override fun onUpdateReceived(update: Update) {
        val message = update.message ?: return

        println(message.from)
        println(message.text)

        fun send(text: String) =
            execute(SendMessage(message.chatId, text))

        when (message.text) {
            "/start" ->
                send(
                    """
                    Aphorisms are different from conventional text.
                    The author recommends reading no more than four aphorisms in one sitting.
                    It is also preferable to select these randomly.
                    
                    Use /random.
                """.trimIndent()
                )

            "/random" ->
                aphorisms.shuffled().take(4).forEach { send(it) }
        }
    }
}

fun main() {
    val aphorisms = Resources.readLines(Resources.getResource("book.txt"), Charset.defaultCharset())
        .filter { it.isNotBlank() && !it.startsWith("–") && !it.startsWith("*") && it.toUpperCase() != it }

    ApiContextInitializer.init()
    TelegramBotsApi().registerBot(Bot(aphorisms))
}
