package nijase.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import nijase.controller.LevelSelectController;
import nijase.controller.MoveController;
import nijase.controller.ResetController;
import nijase.model.Model;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Application extends JFrame {
	
	Model model;
	private JPanel contentPane;
	PuzzleViewer panel;
	JButton upButton;
	JButton downButton;
	JButton leftButton;
	JButton rightButton;
	JButton resetButton;
	private JButton lvl3Button;
	
	JLabel moveCounter;
	private JLabel winSign;
	
	public JLabel getMoveCounter() { return moveCounter; }
	public JLabel getWinSign( ) { return winSign; }
	

	/**
	 * Create the frame.
	 */
	public Application(Model model) {
		this.model = model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new PuzzleViewer(model);
		
		resetButton = new JButton("Reset Level");
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetController(Application.this, model).process();
				
			}			
		});
		
		upButton = new JButton("UP");
		upButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveController(Application.this, model, 0).process();
				
			}			
		});
		
		leftButton = new JButton("LEFT");
		leftButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveController(Application.this, model, 3).process();
				
			}			
		});
		
		rightButton = new JButton("RIGHT");
		rightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveController(Application.this, model, 1).process();
				
			}			
		});
		
		downButton = new JButton("DOWN");
		downButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveController(Application.this, model, 2).process();
				
			}			
		});
		
		JButton lvl1Button = new JButton("Level 1");
		lvl1Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LevelSelectController(Application.this, model, 0).process();
				
			}			
		});
		
		JButton lvl2Button = new JButton("Level 2");
		lvl2Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LevelSelectController(Application.this, model, 1).process();
				
			}			
		});
		
		lvl3Button = new JButton("Level 3");
		lvl3Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LevelSelectController(Application.this, model, 2).process();
				
			}			
		});
		
		moveCounter = new JLabel(model.getMoveCount() + " moves");
		
		winSign = new JLabel("");
		winSign.setHorizontalAlignment(SwingConstants.CENTER);
		winSign.setFont(new Font("Tahoma", Font.BOLD, 30));
		winSign.setForeground(Color.RED);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(upButton)
											.addGap(97))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lvl1Button, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
												.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
												.addComponent(lvl2Button, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
												.addComponent(lvl3Button, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
											.addGap(65))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(60)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(winSign, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
											.addComponent(leftButton)
											.addGap(30)
											.addComponent(rightButton)))
									.addGap(40)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(106)
								.addComponent(downButton)
								.addGap(85)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(92)
							.addComponent(moveCounter)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(30, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lvl1Button, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lvl2Button, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lvl3Button, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(87)
							.addComponent(upButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(leftButton)
								.addComponent(rightButton))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(downButton)
							.addGap(33)
							.addComponent(winSign, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
							.addComponent(moveCounter)
							.addGap(151))))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
