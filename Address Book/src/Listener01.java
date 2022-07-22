import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Michael
 * @version 2020/11/26 17:02
 */
public class Listener01 implements ActionListener {
    AddressBook aB;
    Listener01(AddressBook aB) {
        this.aB = aB;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        for (JButton b : aB.contacts) {
            b.setBackground(null);
        }
        switch (command) {
            case "CreateContact" -> {
                try {
                    aB.cont[Default.order] = new Contacts();
                } catch (ArrayIndexOutOfBoundsException exception) {
                    Default.order++;
                }

                Default.selectedOrder = Default.order;
                aB.p1.setPreferredSize(new Dimension(400, 55 * (Default.order + 1)));
                aB.p1.add(aB.contacts[Default.order]);
                aB.contacts[Default.order].setText("填入信息后点击右侧保存");
                aB.contacts[Default.order].setVisible(true);
                aB.scrollPane.getViewport().setViewPosition(new Point(0, aB.p1.getHeight()));
                Default.order++;
                aB.name.setText(null);
                aB.num.setText(null);
                aB.buttonGroup.clearSelection();
                aB.contacts[Default.selectedOrder].setBackground(Color.PINK);
            }
            case "DELETE" -> {
                System.out.println("deleted");
                try {
                    aB.delete();
                } catch (ArrayIndexOutOfBoundsException exception) {
                    JOptionPane.showMessageDialog(
                            null,
                            "联系人已空！",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

                aB.name.setText(null);
                aB.num.setText(null);
                aB.buttonGroup.clearSelection();
            }
            case "SaveContact" -> {
                try {
                    aB.contacts[Default.selectedOrder].setText(aB.name.getText());
                    aB.cont[Default.selectedOrder].setContacts(aB.name.getText(), aB.num.getText(), aB.male.isSelected());
                } catch (ArrayIndexOutOfBoundsException exception) {
                    JOptionPane.showMessageDialog(
                            null,
                            "无法保存，请先新建",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        }

        for(int i=0; i < Default.MAX_LENGTH; i++) {
            if (command.equals("REVISE_AND_SAVE" + i)) {
                for (JButton b : aB.contacts) {
                    b.setBackground(null);
                }
                aB.contacts[i].setBackground(Color.PINK);
                Default.selectedOrder = i;

                aB.name.setText(aB.cont[i].getName());
                aB.num.setText(aB.cont[i].getNum());

                if (aB.cont[i].getSex() == 1) {
                    aB.male.setSelected(true);
                }
                else if (aB.cont[i].getSex() == 0){
                    aB.female.setSelected(true);
                }

                else {
                    aB.buttonGroup.clearSelection();
                }
            }
        }
    }
}
