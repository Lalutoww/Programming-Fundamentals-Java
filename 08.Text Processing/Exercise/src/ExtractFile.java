import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();
        String fileNameAndExtension = filePath.substring(filePath.lastIndexOf("\\") + 1);
        String fileName = fileNameAndExtension.substring(0, fileNameAndExtension.lastIndexOf("."));
        String fileExtension = fileNameAndExtension.substring(fileNameAndExtension.lastIndexOf(".") + 1);

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileExtension);

    }
}