package formularios;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import componentes.TextField;
import componentes.TablaCustom;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import componentes.Combobox;
import componentes.TextArea;
import javax.swing.JFormattedTextField;
import componentes.TextFieldFormat;
import javax.swing.JRadioButton;

public class FormMarcas extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnNuevo;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private TextField tfBuscador;
	private TextField tfDescripcion;
	private TablaCustom tbMarcas;
	private JRadioButton rdbtnActivo;
	private TextField tfID;
	private JRadioButton rdbtnInactivo;

	public FormMarcas() {
		setTitle("Registro de marcas");
		setMaximizable(true);		setFrameIcon(new ImageIcon(FormClientes.class.getResource("/img/marcas.png")));

		setIconifiable(true);
		setClosable(true);
//		try {
//			setMaximum(true);
//		} catch (PropertyVetoException e1) {
//			e1.printStackTrace();
//		}
		setBounds(0, 0, 1024, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(new ImageIcon(FormClientes.class.getResource("/img/nuevo.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estadoFormulario(true);
			}
		});
		btnNuevo.setBounds(10, 505, 129, 54);
		contentPanel.add(btnNuevo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(new ImageIcon(FormClientes.class.getResource("/img/guardar.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnGuardar.setBounds(153, 505, 141, 54);
		contentPanel.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estadoFormulario(false);
			}
		});
		btnCancelar.setIcon(new ImageIcon(new ImageIcon(FormClientes.class.getResource("/img/cancelar.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btnCancelar.setBounds(309, 505, 129, 54);
		contentPanel.add(btnCancelar);

		tfID = new TextField();
		tfID.setLabelText("ID");
		tfID.setBounds(10, 11, 183, 54);
		contentPanel.add(tfID);

		tfBuscador = new TextField();
		tfBuscador.setLabelText("Buscar por descripción");
		tfBuscador.setBounds(448, 11, 550, 54);
		contentPanel.add(tfBuscador);

		tfDescripcion = new TextField();
		tfDescripcion.setLabelText("Descripción");
		tfDescripcion.setBounds(10, 76, 428, 54);
		contentPanel.add(tfDescripcion);

		tbMarcas = new TablaCustom();
		tbMarcas.setBounds(448, 76, 550, 483);
		tbMarcas.setColumnas(new String[] { "ID", "DESCRIPCIÓN", "ESTADO"},
				accionEliminar, accionEditar, tfBuscador);
		contentPanel.add(tbMarcas);

		rdbtnActivo = new JRadioButton("Activo");
		rdbtnActivo.setBounds(227, 11, 211, 23);
		contentPanel.add(rdbtnActivo);

		rdbtnInactivo = new JRadioButton("Inactivo");
		rdbtnInactivo.setBounds(227, 42, 211, 23);
		contentPanel.add(rdbtnInactivo);

		//estadoFormulario(false);
	}

	private void estadoFormulario(boolean e) {
		tfID.setEnabled(e);
		tfDescripcion.setEnabled(e);
		rdbtnActivo.setEnabled(e);
		rdbtnInactivo.setEnabled(e);

		btnGuardar.setEnabled(e);
		btnCancelar.setEnabled(e);

		if (e) {
			tbMarcas.setEnabled(false);
			btnNuevo.setEnabled(false);
		} else {
			tbMarcas.setEnabled(true);
			btnNuevo.setEnabled(true);
		}

	}

	AbstractAction accionEliminar = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {

		}
	};
	AbstractAction accionEditar = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {

		}
	};

}
