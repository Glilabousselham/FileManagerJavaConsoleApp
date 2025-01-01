package Command;

import java.io.File;

public class ListDirCommand extends AbstractCommand{

    public ListDirCommand(File file){
        super(file);
    }

    @Override
    public void execute(String command) {

        String[] listFiles =  this.currentDirectory.list();

        for (String item : listFiles){
            System.out.println(item);
        }

    }

    public static String getCommandName() {
        return "ls";
    }


}
