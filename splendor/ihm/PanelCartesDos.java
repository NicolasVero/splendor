package splendor.ihm;

import splendor.Controleur;
import java.awt.*;
import javax.swing.*;

public class PanelCartesDos extends JPanel {

	private Controleur controleur;

	private JPanel panelCarteDos;
	private JLabel[] labelsCartesDos;

	public PanelCartesDos(Controleur controleur) {

		this.controleur = controleur;

		this.panelCarteDos = new JPanel();
		this.panelCarteDos.setLayout(new GridLayout(3,0));

		this.labelsCartesDos = new JLabel[3];

		String texte = "I";

		for(int i = 0; i < this.labelsCartesDos.length; i++) {
			
			this.labelsCartesDos[i] = new JLabel(new ImageIcon(this.controleur.CHEMIN_IMG + "dev_" + texte + "_dos.png"));

			texte += "I";
			this.panelCarteDos.add(this.labelsCartesDos[i]);
		}

		this.add(this.panelCarteDos);
	}
}