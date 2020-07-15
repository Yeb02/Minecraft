package guigue.command;

import java.util.ArrayList;

import guigue.Client;

public class CommandManager {
	
	private ArrayList<Command> commands;
	
	public CommandManager() {
		commands = new ArrayList();
	}
	
	public void AddCommand(Command c) {
		commands.add(c);
	}
	
	public ArrayList<Command> GetCommand(){
		return commands;
	}
	
	public void CallCommand(String input) {
		 String split[] = input.split(" ");
		 String command = split[0];
		 String args = input.substring(command.length()).trim();
		 for (Command c : commands) {
			 if (c.getAlias() == command) {
				 try {
					 c.onCommand(args.split(" "));
				 } 
				 catch (Exception e) {
					 Client.addChatMessage("Invalid arguments");
					 Client.addChatMessage(c.getSyntax());
				 }
				 return;
			 }
		 }
		 Client.addChatMessage("Command not found");
	}
	
	
	
	
}
