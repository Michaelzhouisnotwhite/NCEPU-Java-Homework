import javax.swing.*;
import java.awt.*;

class Default {
    static int MAX_LENGTH = 100;
    static int order = 0;
    static int selectedOrder = 0;
}


class Contacts {
    String name = "", num = "";
    boolean sex;

    protected void setContacts (String name, String num, boolean sex) {
        this.name = name;
        this.num = num;
        this.sex = sex; // if "male" ture; else false;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public int getSex() {
        if (this.name.equals("")) {
            return -1;
        }
        return this.sex ? 1 : 0;
    }

}


public class AddressBook extends JFrame{
    JScrollPane scrollPane;
    JButton[] contacts;
    JPanel p1, p2;
    JButton create, save, delete;
    JRadioButton male, female;
    JTextField name, num;
    ButtonGroup buttonGroup = new ButtonGroup();
    Contacts[] cont = new Contacts[Default.MAX_LENGTH];


    public AddressBook() {
        Frame();
        Panel_1();
        Panel_2();
        initPanel_2();
        create.doClick();
    }

    private void Frame() {
        setTitle("通讯录");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(700, 400);
        setLocationRelativeTo(null);
    }

    private void Panel_1() {
        p1 = new JPanel(new FlowLayout());
        initContacts();
        setScrollPane();
        scrollPane.setBounds(0, 0, 400, 365);
    }
    
    private void Panel_2() {
        p2 = new JPanel(new GridLayout(6, 1));
        p2.setBounds(400, 0, 300, 400);
        add(p2);
    }

    private void initContacts() {
        contacts = new JButton[Default.MAX_LENGTH];

        for (int i=0; i < contacts.length; i++) {
            contacts[i] = new JButton();
            contacts[i].setPreferredSize(new Dimension(300,50));
            contacts[i].setVisible(false);

            contacts[i].addActionListener(new Listener01(this));
            contacts[i].setActionCommand("REVISE_AND_SAVE" + i);
        }
    }

    private void initPanel_2() {
        nameBox();
        numBox();
        initRButton();
        button3Group();
    }

    private void initRButton() {
        var panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        male = new JRadioButton("男");
        female = new JRadioButton("女");

        male.setFont(new Font("宋体", Font.BOLD, 24));
        female.setFont(new Font("宋体", Font.BOLD, 24));

        buttonGroup.add(male);
        buttonGroup.add(female);
        panel.add(male);
        panel.add(female);
        p2.add(panel);
    }

    private void nameBox() {
        var panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        var panel2 = new JPanel(new BorderLayout());
        var nameLabel = new JLabel();
        nameLabel.setText("姓名：");
        nameLabel.setFont(new Font("黑体", Font.BOLD, 24));

        name = new JTextField(11);
        name.setFont(new Font("黑体", Font.PLAIN, 24));

        panel.add(nameLabel);
        panel.add(name);
        p2.add(panel2);
        p2.add(panel);

    }

    private void numBox() {
        var panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        var numLabel = new JLabel();
        numLabel.setText("电话：");
        numLabel.setFont(new Font("黑体", Font.BOLD, 24));

        num = new JTextField(11);
        num.setFont(new Font("黑体", Font.PLAIN, 24));

        panel.add(numLabel);
        panel.add(num);
        p2.add(panel);
    }

    private void button3Group() {
        var panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        create = new JButton();
        save = new JButton();
        delete = new JButton();

        panel.add(create);
        panel.add(save);
        panel.add(delete);

        create.setText("新建联系人");
        save.setText("保存");
        delete.setText("删除");

        create.addActionListener(new Listener01(this));
        create.setActionCommand("CreateContact");

        save.addActionListener(new Listener01(this));
        save.setActionCommand("SaveContact");

        delete.addActionListener(new Listener01(this));
        delete.setActionCommand("DELETE");
        p2.add(panel);
    }

    private void setScrollPane() {
        scrollPane = new JScrollPane(p1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);
    }


    void delete() {
        for(int i=Default.selectedOrder; i < Default.order-1;i++) {
            cont[i].name = cont[i + 1].name;
            cont[i].num = cont[i + 1].num;
            cont[i].sex = cont[i + 1].sex;
            contacts[i].setText(contacts[i+1].getText());
        }

        p1.setPreferredSize(new Dimension(400, 55 * (Default.order)));

        Default.order -= 1;
        cont[Default.order].name = "";
        cont[Default.order].num = "";
        cont[Default.order].sex = true;
        contacts[Default.order].setVisible(false);
        Default.selectedOrder--;
    }
}

