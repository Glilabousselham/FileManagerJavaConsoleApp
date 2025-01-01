package commands;

import command.AbstractCommand;
import command.WorkingDir;

public class PWDCommand extends AbstractCommand {

    public PWDCommand(WorkingDir file){
        super(file);
    }


    @Override
    public void execute(String command) {
        System.out.println(this.currentDirectory.getWorkingDir().getAbsolutePath());
    }




    public static String getCommandName(){
        return "pwd";
    }
}
