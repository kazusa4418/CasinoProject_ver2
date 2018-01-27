package casino.main;

import util.menu.Callback;
import util.menu.Menu;

class Title implements Callback {
    private Menu menu = new Menu();
    private SaveFileManager sfm = new SaveFileManager();

    private boolean flag = true;

    Title() {
        menu.addMenu(1, "はじめから始める", this);
        menu.addMenu(2, "続きから始める", this);
        menu.addMenu(3, "セーブデータを削除する", this);
        menu.addMenu(4, "ゲームをやめる", this);
    }

    void menu() {
        flag = true;
        while(flag) {
            menu.show();
            menu.select();
        }
    }

    public void callback(int id) {
        switch(id) {
            case 1:
                create();
                break;
            case 2:
                read();
                break;
            case 3:
                delete();
                break;
            case 4:
                exit();
                break;
        }
    }

    private void create() {
        sfm.createSaveData();
        flag = false;
    }

    private void read() {
        if (sfm.existSaveFile()) {
            sfm.readSaveData();
            flag = false;
        } else System.out.println("セーブデータが存在しません。");
    }

    private void delete() {
        if (sfm.existSaveFile()) {
            sfm.deleteSaveData();
        } else System.out.println("セーブデータが存在しません。");
    }

    private void exit() {
        System.exit(0);
    }
}
