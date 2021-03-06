package UserInterface;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.ValuesToWorkWith;

public class GamblingFrame extends JFrame {

	private static final long serialVersionUID = -8009777093110390448L;

	private Random random = new Random();
	private JLabel generatedCard;
	private JButton redCard = new JButton();
	private JButton blackCard = new JButton();
	private JPanel cardPanel = new JPanel();
	private int code;
	private int gambleIterator = 0;
	private ValuesToWorkWith values = new ValuesToWorkWith();
	
	private ButtonsPanel butPanel = new ButtonsPanel();
	
	public GamblingFrame(String title) {

		super(title);
		setLocation(500, 50);
		setSize(400, 400);
		setDefaultCloseOperation(GamblingFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setLayout(new GridLayout(2, 3));

		generatedCard = new JLabel(new ImageIcon(ClassLoader.getSystemResource("back.jpg")));
		cardPanel.add(generatedCard);

		redCard.setBackground(Color.RED);
		blackCard.setBackground(Color.BLACK);

		redCard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				code = random.nextInt(12);
				redOrBlack(code);

				if (gambleIterator == 3) {
					setVisible(false);
				}

				if (code >= 6 && gambleIterator < 3) {
					values.setWinning(values.getWinning() * 2);
					butPanel.newWinning();
					gambleIterator++;
				} else if (code < 6) {
					 values.setWinning(0);
					butPanel.newWinning();
					setVisible(false);
				}

			}

		});

		blackCard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				code = random.nextInt(5);
				redOrBlack(code);

				if (gambleIterator == 3) {
					setVisible(false);
				}

				if (code < 6 && gambleIterator < 3) {
					values.setWinning(values.getWinning() * 2);
					butPanel.newWinning();
					gambleIterator++;
				} else if (code >= 6) {
					values.setWinning(0);
					butPanel.newWinning();
					setVisible(false);
				}

			}

		});

		add(new JLabel());
		add(cardPanel);
		add(new JLabel());
		add(redCard);
		add(new JLabel());
		add(blackCard);

	}

	public void redOrBlack(int value) {

		cardPanel.setVisible(false);
		generatedCard = new JLabel(new ImageIcon(ClassLoader.getSystemResource("card" + value + ".jpg")));
		cardPanel.removeAll();
		cardPanel.add(generatedCard);
		cardPanel.setVisible(true);

	}

}
