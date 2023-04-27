package componentes;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class Escritorio extends JDesktopPane {
	Image img;

	public Escritorio() {
		img = new ImageIcon(getClass().getResource("/img/escritorio.jpg")).getImage();
	}

	public void paintChildren(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		super.paintChildren(g);
	}

}
