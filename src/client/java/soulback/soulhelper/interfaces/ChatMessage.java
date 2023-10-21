package soulback.soulhelper.interfaces;

import java.util.List;

import net.minecraft.text.Text;
import soulback.soulhelper.SoulHelperClient;

public class ChatMessage {
    
    private Text originalMessage;
    private List<Text> messageSiblings;
    private String messageTag;

    public ChatMessage(Text message) {
        originalMessage = message;
        //Convert message Into List
        messageSiblings = message.getSiblings();
        //get first Element of List, which is the Tag if it needed
        messageTag = messageSiblings.get(0).getString();
        //Remove "[...] " from the tag
        messageTag = messageTag.substring(1, messageTag.length() - 3);

        SoulHelperClient.LOGGER.info("Created Message Object");
    }

    public Text getText() {
        return originalMessage;
    }

    public String getString() {
        return originalMessage.getString();
    }

    public boolean hasTag(String tagName) {
        if (messageTag.equals(tagName)) {
            return true;
        }
        return false;
    }

}
