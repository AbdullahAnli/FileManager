import java.io.File;
import java.io.IOException;

public class FileManager {
    //create director
    public void createDirectory(String directoryPath){
        File directory = new File(directoryPath);
        if (!directory.exists()){
            directory.mkdir();
            System.out.println("directory created: "+directoryPath);
        }
        else {
            System.out.println("directory already exists: "+directoryPath);
        }
    }
    //create file
    public void createFile(String filePath){
        File file = new File(filePath);
        try {
            if (file.createNewFile()){
                System.out.println("file created"+filePath);
            }
            else {
                System.out.println("file already exists: "+ filePath);
            }

        }catch (IOException e){
            System.out.println("an error ");
            e.printStackTrace();
        }
    }
    // List directory contents
    public void ListContents(String directoryPath){
        File directory = new File(directoryPath);
        if (directory.exists()&& directory.isDirectory()){
            System.out.println("contents of directory :"+directoryPath);
            File[] files = directory.listFiles();
            if (files!=null){
                for(File file:files){
                    System.out.println(file.getName());
                }
            }
            else {
                System.out.println("directory does not exists:"+directoryPath);
            }
        }
    }
    // file delete
    public void deleteFile(String filePath){
        File file =new File(filePath);
        if (file.exists() && file.isFile()){
            if (file.delete()){
                System.out.println(" delete file : "+filePath);
            }else {
                System.out.println("unable to delete file  :"+filePath);
            }
        }else {
            System.out.println("file does not exist"+filePath);
        }
    }
    public void deleteDirectory(String directoryPath){
        File directory= new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectory(file.getAbsolutePath());
                    } else {
                        file.delete();
                    }
                }
            }

            if (directory.delete()) {
                System.out.println("directory deleted : " + directoryPath);
            } else {
                System.out.println("unable to delete directory:" + directoryPath);
            }
        }else {
            System.out.println("direcctory does not exists :"+directoryPath);
        }
    }
}
