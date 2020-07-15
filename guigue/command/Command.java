package guigue.command;

public abstract class Command {
	
	public abstract String getAlias();
	public abstract String getDescription();
	public abstract String getSyntax();
	public abstract void onCommand(String[] args) throws Exception;
	
	
}
