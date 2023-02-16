import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GraphInter {
    public static void main(String[] args) {
        //okno regist s pos:
        JFrame window = new JFrame("Registration");
        window.setBounds(5,5,600, 600);
        window.setLayout(null);
//2 polya
        JTextField log_Field = new JTextField();
        JTextField pass_Field = new JTextField();
        JTextField iin_Field = new JTextField();
        log_Field.setBounds(5,45,150,50);
        pass_Field.setBounds(5,125,150,50);
        iin_Field.setBounds(5,205,150,50);
        window.add(log_Field);
        window.add(pass_Field);
        window.add(iin_Field);
//для отображения полей измените размер окна приложения(если не работает)
//knopka peredachi v db
        JButton button = new JButton("Registration");
        button.setBounds(5,265,150,50);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.ORANGE);
        window.add(button);

//взаимодествие на кнопку
        /*    ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //сюда нужно написать код отправки данных в бд (готовый ли?)
            };
        }    */

        JLabel labelLog = new JLabel("Login");
        labelLog.setBounds(5,5,150,50);
        window.add(labelLog);
        JLabel labelPass = new JLabel("Password");
        labelPass.setBounds(5,85,150,50);
        window.add(labelPass);
        JLabel labelIin = new JLabel("IIN");
        labelIin.setBounds(5,165,150,50);
        window.add(labelIin);

        window.setVisible(true);
    }
}