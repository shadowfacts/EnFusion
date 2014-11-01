package net.shadowfacts.shadowcore.command;

import java.util.List;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.shadowfacts.shadowcore.util.CoreUtils;

public class CommandKillAll implements ISubCommand {

	public static CommandKillAll instance = new CommandKillAll();
	
	
	@Override
	public String getCommandName() {
	    return "killall";
	}

	@Override
	public void handleCommand(ICommandSender sender, String[] args) {
		if (!CoreUtils.isOpOrServer(sender.getCommandSenderName())) {
			sender.addChatMessage(new ChatComponentText(CommandHandler.COMMAND_DISALLOWED));
			return;
		}
		
	}

	@Override
	public List<String> addTabCompletionOptions(ICommandSender sender, String[] args) {
		return null;
	}

}
