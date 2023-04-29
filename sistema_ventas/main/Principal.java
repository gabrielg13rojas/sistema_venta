package main;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import formularios.FormClientes;
import formularios.FormMarcas;

@SuppressWarnings("serial")
public class Principal extends JFrame {
	private JDesktopPane escritorio;
	private JMenu mnRegistros;
	private JMenuItem mntmClientes;
	private JMenuItem mntmMarcas;
	private JMenuItem mntmProductos;
	private JMenuItem mntmVentas;
	private JMenu mnReportes;
	private JMenuItem mntmInformeCaja;
	private JMenu mnTransacciones;
	private JMenuItem mntmInventario;
	private JMenuItem mntmInformeVentas;
	private JButton btnProductos;
	private JMenuBar barraMenu;
	private JButton btnClientes;
	private JButton btnMarcas;
	private JButton btnVentas;

	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
		Principal pri = new Principal();
	}

	public Principal() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/system.png")));
	
		setBounds(100, 100, 1001, 601);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		escritorio = new JDesktopPane();
		
		setTitle("Menú principal - Sistema de Ventas");
		setVisible(true);

		btnClientes = new JButton("Clientes");
		btnClientes.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/clientes.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmClientes.doClick();
			}
		});
		
		btnProductos = new JButton("Productos");
		btnProductos.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/productos.png")).getImage()
				.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		
		btnMarcas = new JButton("Marcas");
		btnMarcas.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/marcas.png")).getImage()
				.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		btnMarcas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmMarcas.doClick();
			}
		});
		
		btnVentas = new JButton("Ventas");
		btnVentas.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/ventas.png")).getImage()
				.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(2)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnClientes, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnProductos, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMarcas, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVentas, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addComponent(escritorio, GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(2)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnClientes, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(btnProductos, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(btnMarcas, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(btnVentas, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
						.addComponent(escritorio, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)))
		);
		getContentPane().setLayout(groupLayout);

		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);

		mnRegistros = new JMenu("Registros");
		mnRegistros.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/registros.png")).getImage()
				.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		barraMenu.add(mnRegistros);

		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormClientes form = new FormClientes();
				escritorio.add(form);
				form.show();
			}
		});
		mntmClientes.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/clientes.png")).getImage()
				.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		mnRegistros.add(mntmClientes);
		
		mntmMarcas = new JMenuItem("Marcas");
		mntmMarcas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormMarcas form = new FormMarcas();
				escritorio.add(form);
				form.show();
			}
		});
		mntmMarcas.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/marcas.png")).getImage()
				.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		mnRegistros.add(mntmMarcas);

		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmProductos.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/productos.png")).getImage()
				.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		mnRegistros.add(mntmProductos);

		mnTransacciones = new JMenu("Transacciones");
		mnTransacciones.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/transacciones.png")).getImage()
				.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		barraMenu.add(mnTransacciones);
		
		mntmVentas = new JMenuItem("Ventas");
		mntmVentas.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/ventas.png")).getImage()
				.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		mnTransacciones.add(mntmVentas);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/reportes.png")).getImage()
				.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		barraMenu.add(mnReportes);
		
		mntmInformeCaja = new JMenuItem("Informe de caja");
		mntmInformeCaja.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/informe_caja.png")).getImage()
				.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		mnReportes.add(mntmInformeCaja);
		
		mntmInformeVentas = new JMenuItem("Informe de ventas");
		mntmInformeVentas.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/informe_ventas.png")).getImage()
				.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		mnReportes.add(mntmInformeVentas);
		
		mntmInventario = new JMenuItem("Inventario de productos");
		mntmInventario.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/listado_productos.png")).getImage()
				.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		mnReportes.add(mntmInventario);
	}
}
