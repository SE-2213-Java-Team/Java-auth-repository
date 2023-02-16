import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramNotification extends TelegramLongPollingBot {
    private final String BOT_NAME = "SE-2213";
    private final String BOT_TOKEN = "6091730690:AAH4h4Bc_RnfMRDYCwAGekd8_ln41iXawyg";
    private final String CHAT_ID = "2021059850";

    @Override
    public void onUpdateReceived(Update update) {}
    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }
    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    public void setAnswer(String text) {
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setChatId(CHAT_ID);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
