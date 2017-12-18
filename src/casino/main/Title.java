package casino.main;

import util.menu.Callback;
import util.menu.Menu;

class Title implements Callback {
    private Menu menu = new Menu();
    private SaveFileManager sfm = new SaveFileManager();

    private boolean flag = true;

    Title() {
        menu.addMenu(1, "�͂��߂���n�߂�", this);
        menu.addMenu(2, "��������n�߂�", this);
        menu.addMenu(3, "�Z�[�u�f�[�^���폜����", this);
        menu.addMenu(4, "�Q�[������߂�", this);
    }

    void menu() {
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
        } else System.out.println("�Z�[�u�f�[�^�����݂��܂���B");
    }

    private void delete() {
        if (sfm.existSaveFile()) {
            sfm.deleteSaveData();
        } else System.out.println("�Z�[�u�f�[�^�����݂��܂���B");
    }

    private void exit() {
        System.exit(0);
    }
}
