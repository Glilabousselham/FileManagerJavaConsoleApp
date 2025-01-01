package Commands;

import Command.AbstractCommand;

import java.io.File;

public class PWDCommand extends AbstractCommand {

    public PWDCommand(File file){
        super(file);
    }


    @Override
    public void execute(String command) {
        System.out.println(this.currentDirectory.getAbsolutePath());
    }




    public static String getCommandName(){
        return "pwd";
    }
}
