package com.excel.medicarecalculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;

public class ExcelformulaCalculator {

	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_5;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_6;
	private JLabel lblNewLabel_7;
	private JTextField textField_7;
	private JLabel lblNewLabel_8;
	private JTextField textField_8;
	private JButton btnNormalizedScore;
	private JTextField textField_9;
	private JButton btnSumOfFactors;
	private JLabel lblNewLabel_6;
	private JTextField textField_10;
	private JLabel lblNewLabel_9;
	private JTextField textField_11;
	private JLabel lblNewLabel_10;
	private JButton btnRiskScore;
	private JTextField textField_12;
	private JTextField textField_13;
	private int count = 0;
	private static final String COMMA_DELIMITER = ",";
	static List<Integer> dosYear = new ArrayList<>();
	static List<Double> maCodingAdjustmentPercent = new ArrayList<>();
	static List<Double> normalizationFactor = new ArrayList<>();

	private static int[] years = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		BufferedReader br = null;

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcelformulaCalculator window = new ExcelformulaCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		try {
			// Reading the csv file
			br = new BufferedReader(
					new FileReader("C:\\GHCC_MCR_NormalizationFactors.csv"));

			// Create List for holding Employee objects
			List<GhccMcrNormalizationFactors> ghccMcrNormalizationFactorsList = new ArrayList<GhccMcrNormalizationFactors>();

			String line = "";
			// Read to skip the header
			br.readLine();
			// Reading from the second line
			while ((line = br.readLine()) != null) {
				String[] normalizationFactors = line.split(COMMA_DELIMITER);

				if (normalizationFactors.length > 0) {
					// Save the employee details in Employee object
					GhccMcrNormalizationFactors ghccMcrNormalizationFactors = new GhccMcrNormalizationFactors(
							Integer.parseInt(normalizationFactors[0]), Double.parseDouble(normalizationFactors[1]),
							Double.parseDouble(normalizationFactors[2]));
					ghccMcrNormalizationFactorsList.add(ghccMcrNormalizationFactors);
				}
			}

			// Lets print the GhccMcrNormalizationFactors List
			for (GhccMcrNormalizationFactors e : ghccMcrNormalizationFactorsList) {
				dosYear.add(e.getDosYear());

			}
			for (GhccMcrNormalizationFactors e : ghccMcrNormalizationFactorsList) {

				normalizationFactor.add(e.getNormalizationFactor());

			}

			for (GhccMcrNormalizationFactors e : ghccMcrNormalizationFactorsList) {

				maCodingAdjustmentPercent.add(e.getMaCodingAdjustmentPercent());

			}

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ie) {
				System.out.println("Error occured while closing the BufferedReader");
				ie.printStackTrace();
			}
		}
	}

	/**
	 * Create the application.
	 */
	public ExcelformulaCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.RED);
		frame.setForeground(Color.BLACK);
		frame.setBounds(100, 100, 950, 707);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Demographic_Factor_total");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(15, 139, 198, 44);
		frame.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("HCC_Factors_Total");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblNewLabel_1.setBounds(15, 186, 198, 31);
		frame.getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Interaction_Factors_Total");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(15, 228, 198, 31);
		frame.getContentPane().add(lblNewLabel_2);

		textField_3 = new JTextField("0.000");
		textField_3.setBackground(new Color(255, 255, 224));
		textField_3.setBounds(234, 228, 146, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		lblNewLabel_3 = new JLabel("Medicaid_Factors_Total");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(15, 275, 184, 23);
		frame.getContentPane().add(lblNewLabel_3);

		textField_4 = new JTextField("0.000");
		textField_4.setBackground(new Color(255, 255, 224));
		textField_4.setBounds(234, 271, 146, 26);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		lblNewLabel_4 = new JLabel("Disabled_Factors_Total");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(15, 314, 184, 31);
		frame.getContentPane().add(lblNewLabel_4);

		textField_5 = new JTextField("0.000");
		textField_5.setBackground(new Color(255, 255, 224));
		textField_5.setBounds(234, 314, 146, 26);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		lblNewLabel_5 = new JLabel("New_Enrollee_Factors_Total");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(15, 361, 189, 21);
		frame.getContentPane().add(lblNewLabel_5);

		textField_1 = new JTextField("0.000");
		textField_1.setBackground(new Color(255, 255, 224));
		textField_1.setBounds(234, 356, 146, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField = new JTextField("0.000");
		textField.setBackground(new Color(255, 255, 224));
		textField.setForeground(Color.BLACK);
		textField.setBounds(234, 146, 146, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_2 = new JTextField("0.000");
		textField_2.setBackground(new Color(255, 255, 224));
		textField_2.setBounds(234, 186, 146, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_6 = new JTextField("0.000");
		textField_6.setBackground(new Color(144, 238, 144));
		textField_6.setBounds(152, 398, 146, 26);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		lblNewLabel_7 = new JLabel("Raw_Risk_Score");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(15, 496, 134, 20);
		frame.getContentPane().add(lblNewLabel_7);

		textField_7 = new JTextField("0.000");
		textField_7.setBackground(new Color(240, 255, 255));
		textField_7.setBounds(234, 491, 146, 26);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);

		lblNewLabel_8 = new JLabel("Normalization Factor");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(15, 532, 156, 20);
		frame.getContentPane().add(lblNewLabel_8);

		textField_8 = new JTextField("0.000");
		textField_8.setBackground(new Color(240, 255, 255));
		textField_8.setBounds(234, 527, 146, 26);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);

		btnNormalizedScore = new JButton("NormRisk_Score");
		btnNormalizedScore.setBackground(Color.PINK);
		btnNormalizedScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_7.getText().isEmpty() || textField_8.getText().isEmpty()) {
					infoBox("Please enter all the fields", "Warning");
				} else {
					double normalizedScore = Double.parseDouble(textField_7.getText())
							/ Double.parseDouble(textField_8.getText());
					textField_9.setText(Double.toString(normalizedScore));
				}
				if (!textField_9.getText().isEmpty() || textField_9.getText() != null) {
					textField_10.setText(textField_9.getText());
				}

			}
		});
		btnNormalizedScore.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNormalizedScore.setBounds(104, 603, 251, 39);
		frame.getContentPane().add(btnNormalizedScore);

		textField_9 = new JTextField("0.000");
		textField_9.setBackground(new Color(60, 179, 113));
		textField_9.setBounds(152, 576, 146, 26);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);

		btnSumOfFactors = new JButton("Sum_Total_Factors");
		btnSumOfFactors.setBackground(Color.ORANGE);
		btnSumOfFactors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty()
						|| textField_3.getText().isEmpty() || textField_4.getText().isEmpty()
						|| textField_5.getText().isEmpty()) {
					infoBox("Please enter all the fields", "Warning");
				} else {
					double sumOfFactors = Double.parseDouble(textField.getText())
							+ Double.parseDouble(textField_2.getText()) + Double.parseDouble(textField_3.getText())
							+ Double.parseDouble(textField_4.getText()) + Double.parseDouble(textField_5.getText())
							+ Double.parseDouble(textField_1.getText());
					textField_6.setText(Double.toString(sumOfFactors));
				}

				if (!textField_6.getText().isEmpty() || textField_6.getText() != null) {
					textField_7.setText(textField_6.getText());
				}

			}
		});
		btnSumOfFactors.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSumOfFactors.setBounds(88, 425, 292, 44);
		frame.getContentPane().add(btnSumOfFactors);

		lblNewLabel_6 = new JLabel("Normalized Risk Score");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(522, 282, 166, 31);
		frame.getContentPane().add(lblNewLabel_6);

		textField_10 = new JTextField("0.000");
		textField_10.setBackground(new Color(176, 224, 230));
		textField_10.setBounds(727, 279, 146, 26);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);

		lblNewLabel_9 = new JLabel("(1- Coding Difference Adjustment)");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(510, 324, 198, 31);
		frame.getContentPane().add(lblNewLabel_9);

		textField_11 = new JTextField("0.000");
		textField_11.setBackground(new Color(176, 224, 230));
		textField_11.setBounds(727, 321, 146, 26);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);

		lblNewLabel_10 = new JLabel("Medicare Advantage Score Calculator");
		lblNewLabel_10.setForeground(Color.CYAN);
		lblNewLabel_10.setBackground(Color.GREEN);
		lblNewLabel_10.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_10.setBounds(237, 11, 507, 51);
		frame.getContentPane().add(lblNewLabel_10);

		btnRiskScore = new JButton("Total Raw_Score");
		btnRiskScore.setBackground(Color.GREEN);
		btnRiskScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_10.getText().isEmpty() || textField_11.getText().isEmpty()) {
					infoBox("Please enter all the fields", "Warning");
				} else {
				}
				double riskScore = Double.parseDouble(textField_10.getText()) * codingDifferenceAdjustment();
				textField_12.setText(Double.toString(riskScore));

			}
		});
		btnRiskScore.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRiskScore.setBounds(588, 402, 219, 39);
		frame.getContentPane().add(btnRiskScore);

		textField_12 = new JTextField("0.000");
		textField_12.setBackground(new Color(221, 160, 221));
		textField_12.setBounds(646, 375, 126, 26);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);

		JButton btnNewButton = new JButton("Reset All");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("0.000");
				textField_1.setText("0.000");
				textField_2.setText("0.000");
				textField_3.setText("0.000");
				textField_4.setText("0.000");
				textField_5.setText("0.000");
				textField_6.setText("0.000");
				textField_7.setText("0.000");
				textField_8.setText("0.000");
				textField_9.setText("0.000");
				textField_10.setText("0.000");
				textField_11.setText("0.000");
				textField_12.setText("0.000");

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(628, 500, 134, 46);
		frame.getContentPane().add(btnNewButton);

		JLabel lblYear = new JLabel("YEAR");
		lblYear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblYear.setBounds(271, 78, 69, 20);
		frame.getContentPane().add(lblYear);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(dosYear.toArray()));
		textField_8.setText(Double.toString(normalizationFactor.get(0).doubleValue()));
		textField_11.setText(Double.toString(maCodingAdjustmentPercent.get(0).doubleValue()));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox1 = (JComboBox) e.getSource();
				int dateofYear = (Integer) comboBox1.getSelectedItem();
				for (int i = 0; i < dosYear.toArray().length; i++) {
					if (dateofYear == dosYear.get(i).intValue()) {
						double factor = normalizationFactor.get(i).doubleValue();
						double adjustmentPercent = maCodingAdjustmentPercent.get(i).doubleValue();
						textField_8.setText(Double.toString(factor));
						textField_11.setText(Double.toString(adjustmentPercent));
					}
				}
			}
		});
		comboBox.setEditable(true);
		comboBox.setMaximumRowCount(5);
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setBounds(403, 78, 120, 26);
		frame.getContentPane().add(comboBox);

	}

	private double codingDifferenceAdjustment() {
		String factor = textField_11.getText();
		double value = Double.parseDouble(factor);
		double result = (1 - value / 100);
		return result;
	}

	private static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	public int getElement(int[] arrayOfInts, int index) {
		return arrayOfInts[index];
	}

}
