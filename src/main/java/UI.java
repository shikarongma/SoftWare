import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UI extends JFrame {
    private JComboBox<String> styleComboBox;
    private JTextField inputFileField;
    private JTextArea outputArea;
    private JButton processButton;

    public UI() {
        setTitle("经典软件体系结构教学软件");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel styleLabel = new JLabel("选择体系结构风格：");
        styleComboBox = new JComboBox<>(new String[]{"主程序-子程序", "面向对象", "事件系统", "管道-过滤器"});

        JLabel inputFileLabel = new JLabel("输入文件路径：");
        inputFileField = new JTextField(30);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        processButton = new JButton("处理文件");
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processFile();
            }
        });

        panel.add(styleLabel);
        panel.add(styleComboBox);
        panel.add(inputFileLabel);
        panel.add(inputFileField);
        panel.add(new JLabel("输出结果："));
        panel.add(scrollPane);
        panel.add(new JLabel());
        panel.add(processButton);

        add(panel);
    }

    private void processFile() {
        String filePath = inputFileField.getText();
        String selectedStyle = (String) styleComboBox.getSelectedItem();
        Processor processor = null;

        switch (selectedStyle) {
            case "主程序-子程序":
                processor = new MainSubroutineProcessor();
                break;
            case "面向对象":
                processor = new OOPProcessor();
                break;
            case "事件系统":
                processor = new EventSystemProcessor();
                break;
            case "管道-过滤器":
                processor = new PipelineFilterProcessor();
                break;
        }

        if (processor != null && filePath != null && !filePath.isEmpty()) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(filePath));
                String result = processor.process(lines);
                outputArea.setText(result);
            } catch (IOException ex) {
                outputArea.setText("文件读取错误: " + ex.getMessage());
            }
        } else {
            outputArea.setText("请选择风格和输入文件路径。");
        }
    }
}