
public class Main {
    public static void main(String[] args) {
        FileManager fileManager= new FileManager();
        String directoryPath="text_directory";
        fileManager.deleteDirectory(directoryPath);

        String filePath=directoryPath+"/test_file.txt";
        fileManager.createFile(filePath);

        fileManager.ListContents(directoryPath);

        fileManager.deleteFile(filePath);

        fileManager.deleteDirectory(directoryPath);

    }
}