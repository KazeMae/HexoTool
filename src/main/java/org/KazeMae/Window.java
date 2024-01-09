package org.KazeMae;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;

public class Window extends JFrame {
    private final JTextField scField;
    private final String str = "~~请输入标题~~";
    private String title;
    private final BashControl bashControl;

    public Window() throws IOException {
        // 初始化界面等
        setTitle("Hexo Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        // 设置图标
        Image icon = ImageIO.read(new File("src/main/resources/qqq.jpg"));
        setIconImage(icon);

        // 初始化bash
        bashControl = new BashControl();

        // 标题
        JLabel state_str = new JLabel("\\= HEXO TOOL =/");
        state_str.setFont(new Font("Fire Code", Font.BOLD, 20));
        state_str.setForeground(Color.ORANGE);
        state_str.setHorizontalAlignment(SwingConstants.CENTER);
        add(state_str);

        // 读取标题
        scField = new JTextField(str);
        scField.setForeground(Color.GRAY);
        add(scField);

        // 按钮
        JPanel button = new JPanel();
        JButton newPost = new JButton("新建文章");
        JButton newPage = new JButton("新建页面");
        JButton submit = new JButton("生成推送");
        button.add(newPost);
        button.add(newPage);
        button.add(submit);
        add(button);

        newPost.addActionListener(e -> {
            title = scField.getText();
            try {
                bashControl.newPost(title);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        newPage.addActionListener(e -> {
            title = scField.getText();
            try {
                bashControl.newPage(title);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        submit.addActionListener(e -> {
            try {
                bashControl.submit();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        scField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (scField.getText().equals(str)) {
                    scField.setText(""); // 获取焦点时清空提示语
                    scField.setForeground(Color.BLACK); // 设置字体颜色为黑色
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (scField.getText().isEmpty()) {
                    scField.setText(str); // 失去焦点时恢复提示语
                    scField.setForeground(Color.GRAY); // 设置提示语的颜色为灰色
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
