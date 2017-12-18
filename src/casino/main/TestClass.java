package casino.main;

import util.manager.FileManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestClass {
    private PlayData pl = new PlayData("GUEST");
    private File[] files = new File("saves").listFiles();

    public static void main(String[] args) throws IOException {
        TestClass main = new TestClass();
        main.testFileInit();
    }

    private void testFileInit() {
        for (File file : files) {
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(pl);
                oos.flush();
            } catch(IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    oos.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void testObjectInputStream() {
        ObjectInputStream oos;
        FileInputStream fis;
        try {
            fis = new FileInputStream(files[0]);
            oos = new ObjectInputStream(fis);
            oos.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void check() throws IOException {
        FileManager fm = new FileManager();
        fm.setFile(files[0]);
        fm.openOutputStream();
        fm.writeObject(pl);
        fm.writeByte(10);
        fm.close();
    }
}
