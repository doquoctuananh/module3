package description;

import java.io.File;
import java.io.IOException;

public class Description {


    public static void main(String[] args) throws IOException {
        File file = new File("E:/BackEnd_Java_CodeGym/Exercise/module 3/sql/case-study/manager_traffic/src/main/java/description/description.txt");
        if (!file.exists()) {
            boolean createFile = file.createNewFile();
            if (createFile) {
                System.out.println("Create Description success");
            }
        }
    }
}
