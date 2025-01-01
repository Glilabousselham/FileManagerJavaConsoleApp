package commands;

import command.AbstractCommand;
import command.WorkingDir;

public class ListDirCommand extends AbstractCommand {

    public ListDirCommand(WorkingDir file){
        super(file);
    }

    @Override
    public void execute(String command) {

        String[] listFiles =  this.currentDirectory.getWorkingDir().list();

        for (String item : listFiles){
            System.out.println(item);
        }

    }

    public static String getCommandName() {
        return "ls";
    }


}
