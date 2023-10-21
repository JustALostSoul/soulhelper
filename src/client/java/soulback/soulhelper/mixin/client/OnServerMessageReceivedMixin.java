package soulback.soulhelper.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;
import soulback.soulhelper.SoulHelperClient;
import soulback.soulhelper.interfaces.ChatMessage;

@Mixin(ChatHud.class)
public class OnServerMessageReceivedMixin {

    private static final String METHOD_PATH = "addMessage(Lnet/minecraft/text/Text;)V";
    
    @Inject(method = METHOD_PATH, at = @At("HEAD"), cancellable = true)
    public void addMessage(Text message, CallbackInfo ci) {
        ChatMessage chatMessage = new ChatMessage(message);
        SoulHelperClient.LOGGER.info("Received Message");
        for (String tagName : SoulHelperClient.SEARCH_TAGS) {
            if (chatMessage.hasTag(tagName)) {
                SoulHelperClient.LOGGER.info("Found Tag: " + tagName);
            }
        }
    }

}
