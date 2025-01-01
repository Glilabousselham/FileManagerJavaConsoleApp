package commands;

import command.AbstractCommand;
import command.WorkingDir;

import java.io.File;
import java.util.regex.Pattern;

public class MakeDirCommand extends AbstractCommand {


    public MakeDirCommand(WorkingDir workingDir){
        super(workingDir);

    }

    @Override
    public void execute(String command) {
        String direname = command.trim();

        Pattern pattern = Pattern.compile("^[a-z][a-z0-9]{0,}$", Pattern.CASE_INSENSITIVE);

        if (!pattern.matcher(direname).find()) {
            System.out.println(direname + " : is not a valid dir name");
            return;
        }

        File dir = new File(this.currentDirectory.getWorkingDir(), direname);

        // check if exists
        if (dir.exists()){
            System.out.println("Dir or file name is already exists");
            return;
        }

        boolean created = dir.mkdir();

        if(!created) System.out.println("Dir has not been created");
    }


    public static String getCommandName(){
        return "mkdir";
    }

    public static String describe()  throws  Exception{
        return ("mkdir : create new directory (ex: mkdir test)");
    }
}
