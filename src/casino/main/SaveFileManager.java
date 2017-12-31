package casino.main;

import util.checker.Checker;
import util.manager.FileManager;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

class SaveFileManager {
    private FileManager fm = new FileManager();
    private File[] saves = new File("saves").listFiles();
    private Player pl = Player.getInstance();

    void createSaveData() {
        System.out.println("�V�K�Z�[�u�f�[�^���쐬���܂��B");
        System.out.print("�Z�[�u�f�[�^�������߂Ă�������(���p�p����)\n> ");
        String name = input();
        File file = new File(name);
        try {
            //TODO: �x���̏���������ׂď���
            if (file.createNewFile())
                System.out.println("�Z�[�u�f�[�^���쐬���܂����B");
            else {
                System.out.println("�Z�[�u�f�[�^�̍쐬�Ɏ��s���܂����B");
                System.exit(1);
            }
            writeSaveData(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeSaveData(File file) {
        fm.setFile(file);
        try {
            fm.openOutputStream();
            fm.writeObject(pl.getPlayData());
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try { fm.close(); }
            catch(IOException ignored) {}
        }
    }

    private String input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String text = sc.nextLine();
            if (Checker.stringCheck(text, Pattern.compile("[a-zA-Z0-9]+"))
                    && distinctCheck(text))
                return "saves\\" + text + ".dat";
            System.out.print("�t�H�[�}�b�g���������Ȃ����A���ɑ��݂���t�@�C�����ł��B\n�ē��͂��Ă�������\n> ");
        }
    }

    private boolean distinctCheck(String text) {
        for (File file : saves) {
            if (file.toString().equals("saves\\" + text + ".dat"))
                return false;
        }
        return true;
    }

    boolean existSaveFile() {
        return saves.length != 0;
    }

    void readSaveData() {
        File file = readFile();
        fm.setFile(file);
        try {
            fm.openInputStream();
            Object obj = fm.readObject();
            if (obj instanceof PlayData)
                pl.setPlayData((PlayData) obj);
            else throw new ClassCastException();
            fm.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private File readFile() {
        showSaveFile();
        int no = select();
        return saves[no - 1];
    }

    private void showSaveFile() {
        for (int i = 0; i < saves.length; i++) {
            System.out.println((i + 1) + ": "
                    + ": " + saves[i].toString().replace("saves\\", "")
                    .replace(".dat", ""));
        }
    }

    private int select() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = sc.nextLine();
            if (Checker.numberCheck(input, saves.length + 1))
                return Integer.parseInt(input);
            System.out.println("���͂��Ԉ���Ă��܂��B");
        }
    }

    void deleteSaveData() {
        System.out.print("�폜����Z�[�u�f�[�^��I�����Ă�������\n> ");
        File file = readFile();
        System.out.println(file);
        if (file != null && file.delete()) System.out.println("�Z�[�u�f�[�^���폜���܂����B");
        else System.out.println("�Z�[�u�f�[�^�̍폜�Ɏ��s���܂����B");
    }
}

