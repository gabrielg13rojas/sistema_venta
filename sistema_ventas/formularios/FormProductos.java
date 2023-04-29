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

public class FormProductos extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnNuevo;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private TextField tfBuscador;
	private TextField tfCodigo;
	private TablaCustom tbClientes;
	private TextField tfDescripcion;
	private JRadioButton rdbtnActivo;
	private TextField tfID;
	private TextField tfPrecioVenta;
	private Combobox cbxMarca;
	private TextField tfPrecioCosto;
	private JRadioButton rdbtnInactivo;

	public FormProductos() {
		setFrameIcon(new ImageIcon(FormProductos.class.getResource("/img/productos.png")));
		setTitle("Registro de productos");
		setMaximizable(true);
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
		btnNuevo.setIcon(new ImageIcon(new ImageIcon(FormProductos.class.getResource("/img/nuevo.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estadoFormulario(true);
			}
		});
		btnNuevo.setBounds(10, 505, 129, 54);
		contentPanel.add(btnNuevo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(new ImageIcon(FormProductos.class.getResource("/img/guardar.png")).getImage()
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
		btnCancelar.setIcon(new ImageIcon(new ImageIcon(FormProductos.class.getResource("/img/cancelar.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btnCancelar.setBounds(309, 505, 129, 54);
		contentPanel.add(btnCancelar);

		tfID = new TextField();
		tfID.setLabelText("ID");
		tfID.setBounds(10, 11, 183, 54);
		contentPanel.add(tfID);

		tfBuscador = new TextField();
		tfBuscador.setLabelText("Buscar por código, descripción, marca o grupo");
		tfBuscador.setBounds(448, 11, 550, 54);
		contentPanel.add(tfBuscador);

		tfCodigo = new TextField();
		tfCodigo.setLabelText("Código");
		tfCodigo.setBounds(203, 11, 235, 54);
		contentPanel.add(tfCodigo);

		tbClientes = new TablaCustom();
		tbClientes.setBounds(448, 76, 550, 483);
		tbClientes.setColumnas(new String[] { "ID", "CÉDULA", "NOMBRE Y APELLIDO", "SEXO", "TELÉFONO", "NACIMIENTO" },
				accionEliminar, accionEditar, tfBuscador);
		contentPanel.add(tbClientes);

		tfDescripcion = new TextField();
		tfDescripcion.setLabelText("Descripción");
		tfDescripcion.setBounds(10, 76, 428, 54);
		contentPanel.add(tfDescripcion);

		tfPrecioVenta = new TextField();
		tfPrecioVenta.setLabelText("Precio de venta");
		tfPrecioVenta.setBounds(10, 226, 183, 54);
		contentPanel.add(tfPrecioVenta);

		cbxMarca = new Combobox();
		cbxMarca.setLabeText("Marca");
		cbxMarca.setBounds(10, 141, 183, 54);
		contentPanel.add(cbxMarca);

		tfPrecioCosto = new TextField();
		tfPrecioCosto.setLabelText("Precio de costo");
		tfPrecioCosto.setBounds(203, 141, 235, 54);
		contentPanel.add(tfPrecioCosto);

		rdbtnActivo = new JRadioButton("Activo");
		rdbtnActivo.setBounds(10, 415, 211, 23);
		contentPanel.add(rdbtnActivo);

		rdbtnInactivo = new JRadioButton("Inactivo");
		rdbtnInactivo.setBounds(223, 415, 215, 23);
		contentPanel.add(rdbtnInactivo);

		tfDescuento = new TextField();
		tfDescuento.setLabelText("Descuento");
		tfDescuento.setBounds(203, 226, 235, 54);
		contentPanel.add(tfDescuento);

		tfGrupo = new TextField();
		tfGrupo.setLabelText("Grupo");
		tfGrupo.setBounds(10, 354, 428, 54);
		contentPanel.add(tfGrupo);

		tfStock = new TextField();
		tfStock.setLabelText("Stock");
		tfStock.setBounds(10, 291, 183, 54);
		contentPanel.add(tfStock);

		tfUnidadMedida = new TextField();
		tfUnidadMedida.setLabelText("Unidad de medida");
		tfUnidadMedida.setBounds(203, 291, 235, 54);
		contentPanel.add(tfUnidadMedida);

		estadoFormulario(false);
	}

	private void estadoFormulario(boolean e) {
		tfID.setEnabled(e);
		tfCodigo.setEnabled(e);
		tfDescripcion.setEnabled(e);
		tfPrecioVenta.setEnabled(e);
		tfPrecioCosto.setEnabled(e);
		cbxMarca.setEnabled(e);
		rdbtnActivo.setEnabled(e);
		rdbtnInactivo.setEnabled(e);

		btnGuardar.setEnabled(e);
		btnCancelar.setEnabled(e);

		if (e) {
			tbClientes.setEnabled(false);
			btnNuevo.setEnabled(false);
		} else {
			tbClientes.setEnabled(true);
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
	private TextField tfDescuento;
	private TextField tfStock;
	private TextField tfUnidadMedida;
	private TextField tfGrupo;
}
