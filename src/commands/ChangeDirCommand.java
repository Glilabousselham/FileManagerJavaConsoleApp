package commands;

import command.AbstractCommand;
import command.WorkingDir;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeDirCommand extends AbstractCommand {
    public ChangeDirCommand(WorkingDir file) {
        super(file);
    }


    @Override
    public void execute(String command) {

        // trim the command
        String path = command.trim();

        // check the path that we want to navigate into
        if (path.compareTo("..") == 0) {

            File parentFile = this.currentDirectory.getWorkingDir().getParentFile();
            if(!parentFile.exists()) {
                System.out.println("Invalid dir name");
                return;
            }

            this.currentDirectory.setWorkingDir(parentFile);
            return;
        }


        // allow only one step or one lvl
        Pattern pattern = Pattern.compile("^[a-z][a-z0-9]{0,}$", Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(path).find()) {

            File newFile = new File(this.currentDirectory.getWorkingDir(), path);

            // check if directory
            if(!newFile.isDirectory()) {
                System.out.println(path + " is not a directory");
                return;
            }

            this.currentDirectory.setWorkingDir(newFile);
        }
    }


    public static String getCommandName() {
        return "cd";
    }
    public static String describe()  throws  Exception{
        return ("cd : allows only one step ex (cd test | cd .. )");
    }
}
