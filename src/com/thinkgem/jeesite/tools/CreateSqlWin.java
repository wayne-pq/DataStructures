package com.thinkgem.jeesite.tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class CreateSqlWin extends JFrame {

	private JPanel contentPane;
	private JTextField txtStr;
	private JRadioButton rdbtnString;
	private JRadioButton rdbtnStringbuffer;
	private JSplitPane splitPane;
	private JTextArea newSql;
	private JTextArea oldSql;

	private ImageIcon ico = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateSqlWin frame = new CreateSqlWin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateSqlWin() {
		// setIconImage(ico.getImage());
		setMinimumSize(new Dimension(840, 600));
		setTitle("SQL转java代码");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 80));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setPreferredSize(new Dimension(300, 10));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(10, 10, 153, 20);
		panel_1.add(label);

		rdbtnString = new JRadioButton("String");
		rdbtnString.setSelected(true);
		rdbtnString.setBounds(52, 36, 79, 23);
		panel_1.add(rdbtnString);

		rdbtnStringbuffer = new JRadioButton("StringBuffer");
		rdbtnStringbuffer.setBounds(144, 36, 107, 23);
		// panel_1.add(rdbtnStringbuffer);

		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(rdbtnString);
		bGroup.add(rdbtnStringbuffer);

		txtStr = new JTextField();
		txtStr.setText("str");
		txtStr.setBounds(313, 31, 180, 33);
		panel_1.add(txtStr);
		txtStr.setColumns(10);

		JLabel label_1 = new JLabel("变量名");
		label_1.setBounds(276, 13, 87, 15);
		panel_1.add(label_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 0, 1, 1,
				(Color) new Color(0, 0, 0)));
		panel_3.setPreferredSize(new Dimension(200, 10));
		panel.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));

		JButton button = new JButton("转换");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���SQL
				String oldSqlStr = oldSql.getText();
				/*
				 * if (oldSqlStr.equals("")) {
				 * JOptionPane.showMessageDialog(CreateSqlWin.this,
				 * "�����������SQL��ִ�У�"); return; }
				 */
				// ���
				if (!newSql.getText().equals("")) {
					newSql.setText("");
				}
				String valibleName = txtStr.getText();
				if (valibleName.trim().equals("")) {
					JOptionPane.showMessageDialog(CreateSqlWin.this,
							"�����������");
					return;
				}
				String[] sqls = oldSqlStr.split("\n");
				StringBuffer result = new StringBuffer();
				// sql转换的主要代码
				if (rdbtnString.isSelected()) {

					if (sqls.length == 0) {
						result.append("无sql语句..");
					} else if (sqls.length == 1) {
						if (sqls[0].trim().startsWith("--")) {
							result.append("只有sql注释语句..");
						} else {

							if (sqls[0].contains("--")) {
								int index = sqls[0].indexOf("--");
								sqls[0] = sqls[0].substring(0, index);
							}

							result.append("String " + valibleName + " = \" "
									+ sqls[0] + " \";\n");
						}
					} else {
						// string��ʽ
						for (int i = 0; i <= indexofend(sqls); i++) {
							if ((sqls.length - 1) == i) {
								result.append(" +\" " + sqls[sqls.length - 1]
										+ " \";\n");
								break;
							} else if (sqls[i].contains("--")) {
								int index = sqls[i].indexOf("--");
								if (index != 0) {
									sqls[i] = sqls[i].substring(0, index);
								} else {
									continue;
								}
							}
							if (result.toString().equals("")) {
								if ("".equals(sqls[i].trim()))
									continue;
								result.append("String " + valibleName
										+ " = \" " + sqls[i] + " \"\n");
							} else {
								if ("".equals(sqls[i].trim()))
									continue;
								result.append(" +\" " + sqls[i] + " \"\n");
							}
						}
					}

				} else {
					// stringBuffer��ʽ
					result.append("StringBuffer " + valibleName
							+ " =  new StringBuffer();\n");
					for (int i = 0; i < sqls.length; i++) {
						if (sqls[i].contains("--")) {
							int index = sqls[i].indexOf("--");
							sqls[i] = sqls[i].substring(0, index);
						}
						if ("".equals(sqls[i].trim()))
							continue;
						result.append(valibleName + ".append(\" " + sqls[i]
								+ " \");\n");
					}
				}
				newSql.setText(result.toString());
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 32));
		panel_3.add(button, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 1, 1, 1,
				(Color) new Color(0, 0, 0)));
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		splitPane = new JSplitPane();
		splitPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				divider();
			}
		});
		panel_2.add(splitPane, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);

		oldSql = new JTextArea();
		scrollPane.setViewportView(oldSql);

		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);

		newSql = new JTextArea();
		scrollPane_1.setViewportView(newSql);

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_4.setPreferredSize(new Dimension(10, 30));
		panel_2.add(panel_4, BorderLayout.NORTH);

		JLabel lblsql = new JLabel("sql语句");
		lblsql.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4.add(lblsql);
	}

	public void divider() {
		splitPane.setDividerLocation(0.4);
	}

	public int indexofend(String[] sqls) {
		int i = sqls.length - 1;

		for (; i >= 0; i--) {
			if ("".equals(sqls[i].trim()))
				continue;
			if (sqls[i].trim().startsWith("--"))
				continue;
			break;
		}

		return i;
	}
}
