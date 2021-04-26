package by.htp.les02.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.les02.controller.command.impl.ChangeLocal;
import by.htp.les02.controller.command.impl.DeleteOneNews;
import by.htp.les02.controller.command.impl.GoToEditPage;
import by.htp.les02.controller.command.impl.GoToIndexPage;
import by.htp.les02.controller.command.impl.GoToMainPage;
import by.htp.les02.controller.command.impl.GoToOneNewsPage;
import by.htp.les02.controller.command.impl.GoToRegistrationPage;
import by.htp.les02.controller.command.impl.Logination;
import by.htp.les02.controller.command.impl.SaveEditOneNews;
import by.htp.les02.controller.command.impl.LogOut;
import by.htp.les02.controller.command.impl.SaveNewUser;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandName.LOGINATION, new Logination());// +
		commands.put(CommandName.GOTOREGISTRATIONPAGE, new GoToRegistrationPage());// +
		commands.put(CommandName.SAVENEWUSER, new SaveNewUser());// +
		commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());// +
		commands.put(CommandName.GOTOMAINPAGE, new GoToMainPage());// +
		commands.put(CommandName.LOGOUT, new LogOut());// +
		commands.put(CommandName.GO_TO_ONE_NEWS_PAGE, new GoToOneNewsPage());//+
		commands.put(CommandName.GO_TO_EDIT_PAGE, new GoToEditPage());//+
		commands.put(CommandName.SAVE_EDIT_ONE_NEWS, new SaveEditOneNews());//+
		commands.put(CommandName.DELETE_ONE_NEWS, new DeleteOneNews());//+
		commands.put(CommandName.CHANGE_LOCAL, new ChangeLocal());//
	}

	public Command takeCommand(String name) {
		CommandName commandName;

		commandName = CommandName.valueOf(name.toUpperCase());

		return commands.get(commandName);
	}
}
