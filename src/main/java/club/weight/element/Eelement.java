package club.weight.element;

import javax.swing.*;

public abstract class Eelement {
    public JFrame f;
    //展示
    public void show(){
        f.setVisible(true);
    }
    //隐藏
    public void close(){
        f.setVisible(false);
    }
    //关闭
    public void shutDown(){
        f.dispose();
    }
}
