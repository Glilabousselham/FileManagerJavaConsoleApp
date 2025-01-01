package Command;

import java.io.File;

public abstract class AbstractCommand implements ICommand {

    protected File currentDirectory;

    public AbstractCommand(File currentDirectory) {
        this.currentDirectory = currentDirectory;
    }


    public AbstractCommand() {
    }


   public static String getCommandName()  throws  Exception{
        throw new Exception("Not implemented");
   }

}
