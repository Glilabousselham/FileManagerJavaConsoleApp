package command;

import java.io.File;

public abstract class AbstractCommand implements ICommand {

    protected WorkingDir currentDirectory;

    public AbstractCommand(WorkingDir currentDirectory) {
        this.currentDirectory = currentDirectory;
    }


    public AbstractCommand() {
    }


   public static String getCommandName()  throws  Exception{
        throw new Exception("Not implemented");
   }

   public static String describe()  throws  Exception{
        throw new Exception("Not implemented");
   }

}
