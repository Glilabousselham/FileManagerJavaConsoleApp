import Command.AbstractCommand;
import Command.ListDirCommand;
import Command.PWDCommand;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Program {

    private File workingDirectory;

    private List<Class<? extends AbstractCommand>> commandsList = new ArrayList<>();

    public Program() {
        this.commandsList.add(ListDirCommand.class);
        this.commandsList.add(PWDCommand.class);
    }


    public void run() {

        // get the working directory
        String currentDirectory = System.getProperty("user.dir");

        // initialize the working directory
        this.workingDirectory = new File(currentDirectory);

        this.loop((UserStringCommand userStringCommand) -> {
            for (Class<? extends AbstractCommand> commandClass : commandsList) {


                try {

                    String commandName = commandClass.getMethod("getCommandName").invoke(null).toString();

                    if (commandName.compareTo(userStringCommand.commandName) == 0) {

                        // create object from the called command
                        AbstractCommand command = commandClass.getDeclaredConstructor(File.class).newInstance(this.workingDirectory);

                        command.execute(userStringCommand.commandArg);

                        return;
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("Command not found : " + userStringCommand.commandName);
        });
    }


    private void loop(Consumer<UserStringCommand> consumer) {

        Scanner scanner = new Scanner(System.in);

        UserStringCommand userStringCommand;
        boolean isExited;
        do {

            // read user input
            System.out.print("File Manager (" + this.workingDirectory.getAbsolutePath() + ") $ ");
            userStringCommand = new UserStringCommand(scanner.nextLine());
            System.out.println();

            // check if exited
            isExited = userStringCommand.commandName.compareTo("exit") == 0;

            if (!isExited) {
                // handle the user input
                consumer.accept(userStringCommand);
            }

        } while (!isExited);

        System.out.println("BYE!!");
    }


    class UserStringCommand {
        private String commandName;
        private String commandArg;


        public UserStringCommand(String command) {

            String[] commandArr = command.split(" +", 2);

            this.commandName = commandArr[0];
            this.commandArg = commandArr.length >= 2 ? commandArr[1] : "";


        }
    }

}
