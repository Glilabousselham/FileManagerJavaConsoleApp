package commands;

import command.AbstractCommand;
import command.WorkingDir;

public class ChangeDirCommand extends AbstractCommand {
    public ChangeDirCommand(WorkingDir file){
        super(file);
    }


    @Override
    public void execute(String command) {

        // check the path that we want to navigate into
        if (command.compareTo("..") == 0){
            this.currentDirectory.setWorkingDir(this.currentDirectory.getWorkingDir().getParentFile());
        }else {
            // must be like dir/dir2... or dir


        }



        System.out.println(command);
    }


    public static String getCommandName(){
        return "cd";
    }
}
