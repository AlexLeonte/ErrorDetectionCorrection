import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;


public class ApplicationController {

	private JFrame frame;
	private JTextField inputMesaj;
	private JTextField inputBitEronat;
	private JTextArea textCodulGenerat;
	private JButton buttonSterge;
	private HammingCode hc ;
	private final JLabel Hamming = DefaultComponentFactory.getInstance().createTitle("Aplicatia pentru detectia si corectia erorii");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationController window = new ApplicationController();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationController() {
		hc = new HammingCode();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 803, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		inputMesaj = new JTextField();
		inputMesaj.setBounds(158, 164, 167, 20);
		frame.getContentPane().add(inputMesaj);
		inputMesaj.setColumns(10);
		
		Label label = new Label("Introduceti mesajul:");
		label.setBounds(10, 164, 119, 22);
		frame.getContentPane().add(label);
		
		JButton genereazaCodul = new JButton("Genereaza codul");
		genereazaCodul.setBounds(10, 240, 154, 23);
		genereazaCodul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textCodulGenerat.append(hc.getGeneratedCode(inputMesaj.getText()));
				
			}
		});
		frame.getContentPane().add(genereazaCodul);
		
		inputBitEronat = new JTextField();
		inputBitEronat.setBounds(158, 194, 167, 20);
		frame.getContentPane().add(inputBitEronat);
		inputBitEronat.setColumns(10);
		
		Label label_1 = new Label("Introduceti bitul eronat:");
		label_1.setBounds(10, 192, 130, 22);
		frame.getContentPane().add(label_1);
		
		textCodulGenerat = new JTextArea();
		textCodulGenerat.setBounds(158, 269, 229, 20);
		textCodulGenerat.setEditable(false);
		frame.getContentPane().add(textCodulGenerat);
		
		buttonSterge = new JButton("Sterge");
		buttonSterge.setBounds(673, 455, 89, 23);
		buttonSterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCodulGenerat.setText(null);
			}
		});
		frame.getContentPane().add(buttonSterge);
		
		JLabel lblIntr = new JLabel("Codul generat este:");
		lblIntr.setBounds(23, 274, 193, 14);
		frame.getContentPane().add(lblIntr);
		
		JLabel lblCodulTrimisEste = new JLabel("Codul trimis este:");
		lblCodulTrimisEste.setBounds(23, 336, 106, 14);
		frame.getContentPane().add(lblCodulTrimisEste);
		
		JLabel lblCodulCorectatEste = new JLabel("Codul corectat este:");
		lblCodulCorectatEste.setBounds(23, 370, 117, 14);
		frame.getContentPane().add(lblCodulCorectatEste);
		
		JLabel lblDateleOriginaleTrimise = new JLabel("Mesajul original este:");
		lblDateleOriginaleTrimise.setBounds(23, 407, 154, 14);
		frame.getContentPane().add(lblDateleOriginaleTrimise);
		
		JButton afiseazaCodulTrimis = new JButton("Afiseaza");
		afiseazaCodulTrimis.setBounds(435, 332, 89, 23);
		frame.getContentPane().add(afiseazaCodulTrimis);
		
		JButton afiseazaCodulCorectat = new JButton("Afiseaza");
		afiseazaCodulCorectat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		afiseazaCodulCorectat.setBounds(435, 366, 89, 23);
		frame.getContentPane().add(afiseazaCodulCorectat);
		
		JButton afiseazaMesajulOriginal = new JButton("Afiseaza");
		afiseazaMesajulOriginal.setBounds(435, 403, 89, 23);
		frame.getContentPane().add(afiseazaMesajulOriginal);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(422, 41, -163, 20);
		frame.getContentPane().add(desktopPane);
		Hamming.setBounds(269, 30, 290, 31);
		frame.getContentPane().add(Hamming);
		
		JTextArea textMain = new JTextArea();
		textMain.setEditable(false);
		textMain.setBounds(549, 87, 213, 334);
		frame.getContentPane().add(textMain);
		
		JTextArea textCodulTrimis = new JTextArea();
		textCodulTrimis.setEditable(false);
		textCodulTrimis.setBounds(174, 335, 213, 20);
		frame.getContentPane().add(textCodulTrimis);
		
		JTextArea textCodulCorectat = new JTextArea();
		textCodulCorectat.setEditable(false);
		textCodulCorectat.setBounds(174, 369, 213, 20);
		frame.getContentPane().add(textCodulCorectat);
		
		JTextArea textMesajulOriginal = new JTextArea();
		textMesajulOriginal.setEditable(false);
		textMesajulOriginal.setBounds(174, 402, 213, 20);
		frame.getContentPane().add(textMesajulOriginal);
	}
}
