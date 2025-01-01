package command;

import java.io.File;

public class WorkingDir {

    private File file;

    public WorkingDir(File file){
        this.file = file;
    }



    public File getWorkingDir(){
        return this.file;

    }


    public void setWorkingDir(File file) {
        this.file = file;
    }
}
