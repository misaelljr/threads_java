/*
 * @(#)Corrida.java 1.0 03/03/17
 *
 * You can modify the template of this file in the
 * directory ..\JCreator\Templates\Template_1\Project_Name.java
 *
 * You can also create your own project template by making a new
 * folder in the directory ..\JCreator\Template\. Use the other
 * templates as examples.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class Corrida extends JFrame implements ActionListener {
static final int MAX_RUNNERS = 15;
JSlider nRunners, sleepTime, len;
JProgressBar[] pb;
JLabel result;
	
	public Corrida() {
		
		JPanel p1 = new JPanel(new BorderLayout());
		JPanel left = new JPanel(new GridLayout(7,1));
		JPanel right = new JPanel(new GridLayout(MAX_RUNNERS*2,1));
		
        JLabel sliderLabel = new JLabel("Número de corredores", JLabel.CENTER);
		nRunners = new JSlider(JSlider.HORIZONTAL,
                                      1, MAX_RUNNERS, 5);
		nRunners.setMajorTickSpacing(5);
		nRunners.setMinorTickSpacing(1);
		nRunners.setPaintTicks(true);
		nRunners.setPaintLabels(true);
//		nRunners.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

		//add the slider to the content pane
		left.add(sliderLabel);
		left.add(nRunners);

        sliderLabel = new JLabel("Tempo de espera", JLabel.CENTER);
		sleepTime = new JSlider(JSlider.HORIZONTAL,
                                      0, 200, 50);
		sleepTime.setMajorTickSpacing(50);
		sleepTime.setMinorTickSpacing(10);
		sleepTime.setPaintTicks(true);
		sleepTime.setPaintLabels(true);
//		sleepTime.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

		//add the slider to the content pane
		left.add(sliderLabel);
		left.add(sleepTime);

        sliderLabel = new JLabel("Distância", JLabel.CENTER);
		len = new JSlider(JSlider.HORIZONTAL,
                                      0, 500, 50);
		len.setMajorTickSpacing(100);
		len.setMinorTickSpacing(10);
		len.setPaintTicks(true);
		len.setPaintLabels(true);
//		len.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

		//add the slider to the content pane
		left.add(sliderLabel);
		left.add(len);
		
		JButton go = new JButton("GO!");
		left.add(go);
		go.addActionListener(this);

		pb = new JProgressBar[MAX_RUNNERS];		
		for (int i = 0; i < MAX_RUNNERS; i++)
		{
			JProgressBar progressBar;
			JLabel jjl = new JLabel("Corredor " + (i+1));
		    progressBar = new JProgressBar(0, 500);
    		progressBar.setValue(0);
    		progressBar.setStringPainted(true);
    		right.add(jjl);
    		right.add(progressBar);
			pb[i] = progressBar;
		}
		
		left.setBorder(BorderFactory.createEtchedBorder());
		right.setBorder(BorderFactory.createEtchedBorder());
		
		result = new JLabel("O vencedor é: ");
		result.setFont(new Font("Arial", Font.BOLD, 32));
		result.setBorder(BorderFactory.createEtchedBorder());

		p1.add(left, "West");
		p1.add(right, "East");
		p1.add(result, "North");
		
		
		getContentPane().add(p1);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e)
	{
		int n = nRunners.getValue();
		int x = len.getValue();
		int sleep = sleepTime.getValue();
		for (int i = 0; i < n; i++)
		{
			pb[i].setMaximum(x);
		}
		Controlador ct = new Controlador(n, x, sleep, pb, result);
		ct.start();
	}

	public static void main(String args[]) {
		System.out.println("Starting Corrida...");
		Corrida mainFrame = new Corrida();
		mainFrame.setSize(400, 400);
		mainFrame.setTitle("Corrida");
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}
