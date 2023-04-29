package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import componentes.Combobox;
import componentes.TextField;

@SuppressWarnings("serial")
public class FormFiltroListadoClientes extends JDialog {

	private final JPanel panelCentral = new JPanel();
	private JPanel panelFID;
	private JPanel panelFNombre;
	private JPanel panelOrdenamiento;
	private JPanel panelFApellido;
	private JPanel panelFSexo;
	private JButton btnFiltrar;
	@SuppressWarnings("rawtypes")
	private Combobox cbxSexo;
	private TextField tfIDDesde;
	private TextField tfIDHasta;
	private TextField tfDesdeNombre;
	private TextField tfHastaNombre;
	private TextField tfHastaApellido;
	@SuppressWarnings("rawtypes")
	private Combobox cbxOrdenamiento;
	@SuppressWarnings("rawtypes")
	private Combobox cbxOrdenASDE;
	private TextField tfDesdeApellido;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FormFiltroListadoClientes() {
		setTitle("Filtro de datos para listado de clientes");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(FormFiltroListadoClientes.class.getResource("/img/filtro.png")));
		setBounds(100, 100, 350, 400);
		getContentPane().setLayout(new BorderLayout());
		panelCentral.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		panelFID = new JPanel();
		panelFID.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Filtro por id", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFID.setBounds(4, 2, 165, 135);
		panelCentral.add(panelFID);
		panelFID.setLayout(null);

		tfIDDesde = new TextField();
		tfIDDesde.setLabelText("Desde");
		tfIDDesde.setBounds(6, 16, 150, 53);
		panelFID.add(tfIDDesde);

		tfIDHasta = new TextField();
		tfIDHasta.setLabelText("Hasta");
		tfIDHasta.setBounds(6, 75, 150, 53);
		panelFID.add(tfIDHasta);

		panelFNombre = new JPanel();
		panelFNombre.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Filtro por nombre", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFNombre.setBounds(169, 2, 164, 131);
		panelCentral.add(panelFNombre);
		panelFNombre.setLayout(null);

		tfDesdeNombre = new TextField();
		tfDesdeNombre.setLabelText("Desde");
		tfDesdeNombre.setBounds(6, 16, 150, 53);
		panelFNombre.add(tfDesdeNombre);

		tfHastaNombre = new TextField();
		tfHastaNombre.setLabelText("Hasta");
		tfHastaNombre.setBounds(6, 72, 150, 53);
		panelFNombre.add(tfHastaNombre);

		panelFApellido = new JPanel();
		panelFApellido.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Filtro por apellido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFApellido.setBounds(4, 139, 165, 131);
		panelCentral.add(panelFApellido);
		panelFApellido.setLayout(null);

		tfDesdeApellido = new TextField();
		tfDesdeApellido.setLabelText("Desde");
		tfDesdeApellido.setBounds(6, 16, 150, 53);
		panelFApellido.add(tfDesdeApellido);

		tfHastaApellido = new TextField();
		tfHastaApellido.setLabelText("Hasta");
		tfHastaApellido.setBounds(6, 72, 150, 53);
		panelFApellido.add(tfHastaApellido);

		panelFSexo = new JPanel();
		panelFSexo.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Filtro por sexo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFSexo.setBounds(4, 272, 165, 81);
		panelCentral.add(panelFSexo);
		panelFSexo.setLayout(null);

		cbxSexo = new Combobox();
		cbxSexo.addItem("TODOS");
		cbxSexo.addItem("MASCULINO");
		cbxSexo.addItem("FEMENINO");
		cbxSexo.setBounds(6, 16, 149, 59);
		panelFSexo.add(cbxSexo);

		panelOrdenamiento = new JPanel();
		panelOrdenamiento.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Ordenamiento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOrdenamiento.setBounds(169, 139, 164, 131);
		panelCentral.add(panelOrdenamiento);
		panelOrdenamiento.setLayout(null);

		cbxOrdenamiento = new Combobox();
		cbxOrdenamiento.addItem("ID");
		cbxOrdenamiento.addItem("NOMBRE Y APELLIDO");
		cbxOrdenamiento.addItem("SEXO");
		cbxOrdenamiento.setBounds(6, 16, 150, 53);
		panelOrdenamiento.add(cbxOrdenamiento);

		cbxOrdenASDE = new Combobox();
		cbxOrdenASDE.addItem("ASCENDENTE");
		cbxOrdenASDE.addItem("DESCENDENTE");
		cbxOrdenASDE.setBounds(6, 71, 150, 53);
		panelOrdenamiento.add(cbxOrdenASDE);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFiltrar.setIcon(new ImageIcon(new ImageIcon(FormClientes.class.getResource("/img/aceptarfiltro.png"))
				.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btnFiltrar.setBounds(179, 281, 145, 65);
		panelCentral.add(btnFiltrar);
	}

	public String getRango() {
		return "ID: " + tfIDDesde.getText() + "/" + tfIDHasta.getText() + " Nombre: " + tfDesdeNombre.getText() + "/"
				+ tfHastaNombre.getText() + " Apellido: " + tfDesdeApellido.getText() + "/" + tfHastaApellido.getText()
				+ " Sexo: " + cbxSexo.getSelectedItem().toString();
	}

	public String getOrdenamiento() {
		return cbxOrdenamiento.getSelectedItem().toString() + " - " + cbxOrdenASDE.getSelectedItem().toString();
	}

	public String getFiltro() {
		String filtro = "SELECT * FROM clientes WHERE cli_nombre ILIKE '%%'";
		if (!tfIDDesde.getText().isEmpty() && !tfIDHasta.getText().isEmpty()) {
			filtro = filtro + " AND cli_id BETWEEN " + tfIDDesde.getText() + " AND " + tfIDHasta.getText();
		}
		if (!tfDesdeNombre.getText().isEmpty() && !tfHastaNombre.getText().isEmpty()) {
			filtro = filtro + " AND cli_nombre BETWEEN '" + tfDesdeNombre.getText() + "' AND '" + tfHastaNombre.getText()+"ZZZZZZ'";
		}
		if (!tfDesdeApellido.getText().isEmpty() && !tfHastaApellido.getText().isEmpty()) {
			filtro = filtro + " AND cli_apellido BETWEEN '" + tfDesdeApellido.getText() + "' AND '"
					+ tfHastaApellido.getText()+"ZZZZZZZ'";
		}
		if (cbxSexo.getSelectedIndex() > 0) {
			filtro = filtro + " AND cli_sexo=" + cbxSexo.getSelectedIndex();
		}

		filtro = filtro + " ORDER BY ";
		if (cbxOrdenamiento.getSelectedIndex() == 0) {// ID
			filtro += " cli_id ";
		} else if (cbxOrdenamiento.getSelectedIndex() == 1) {// NOMBRE Y APELLIDO
			filtro += " cli_nombre, cli_apellido ";
		} else {// SEXO
			filtro += " cli_sexo ";
		}

		if (cbxOrdenASDE.getSelectedIndex() > 0) {
			filtro += " DESC ";
		}

		return filtro;
	}

}
