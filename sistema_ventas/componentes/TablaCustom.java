package componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class TablaCustom extends JPanel {
	private DefaultTableModel model = null;
	private JTextField searchField;
	private JTable table;
	public JTable getTable() {
		return table;
	}
	public DefaultTableModel getModel() {
		return model;
	}

	public void setSearchField(JTextField searchField) {
		this.searchField = searchField;
	}

	@Override
	public void setEnabled(boolean enabled) {
		table.setEnabled(enabled);
		super.setEnabled(enabled);
	}

	public void limpiar() {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	public void setFila(Object[] row) {
		Object[] fila = new Object[row.length + 2];
		fila[0] = "Eliminar";
		fila[1] = "Editar";
		for (int i = 0; i < row.length; i++) {
			fila[i + 2] = row[i];
		}
		model.addRow(fila);
	}

	public void setColumnas(String[] columnas, AbstractAction accionEliminar, AbstractAction accionEditar,
			JTextField tfBuscar) {
		searchField = tfBuscar;
		String cols[] = new String[columnas.length + 2];
		cols[0] = "Eliminar";
		cols[1] = "Editar";
		for (int i = 0; i < columnas.length; i++) {
			cols[i + 2] = columnas[i];
		}
		model = new DefaultTableModel(null, cols) {
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}

			@Override
			public boolean isCellEditable(int row, int column) {

				if (column > 1) {
					return false;
				} else {
					return true;
				}
			}
		};

		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumn(cols[0]).setCellRenderer(new ButtonRenderer());
		table.getColumn(cols[0]).setCellEditor(new Boton(new JCheckBox(), accionEliminar));
		table.getColumn(cols[1]).setCellRenderer(new ButtonRenderer());
		table.getColumn(cols[1]).setCellEditor(new Boton(new JCheckBox(), accionEditar));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setRowHeight(36);
//		table.setAutoCreateRowSorter(true);
//
//		table.setFillsViewportHeight(true);
//		TableRowSorter<? extends TableModel> sorter = new TableRowSorter<>(model);
//		table.setRowSorter(sorter);
//
//		RendererBuscadorTabla rendBusc = new RendererBuscadorTabla(searchField);
//
//		table.setDefaultRenderer(String.class, rendBusc);
//		searchField.getDocument().addDocumentListener(new DocumentListener() {
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				update();
//			}
//
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				update();
//			}
//
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//			}
//
//			private void update() {
//				String pattern = searchField.getText().trim();
//				if (pattern.isEmpty()) {
//					sorter.setRowFilter(null);
//				} else if (model.getRowCount() > 0) {
//					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + pattern));
//				}
//			}
//		});

		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0, 0, getWidth(), getHeight());
		add(sp);
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(31)
						.addComponent(sp, GroupLayout.DEFAULT_SIZE, getWidth(), Short.MAX_VALUE).addGap(54)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(31)
						.addComponent(sp, GroupLayout.DEFAULT_SIZE, getHeight(), Short.MAX_VALUE).addGap(48)));
	}

	public TablaCustom() {
		setLayout(null);
	}
}

@SuppressWarnings("serial")
class ButtonRenderer extends JButton implements TableCellRenderer {
	ImageIcon iconelim = new ImageIcon(new ImageIcon(TablaCustom.class.getResource("/img/eliminar.png")).getImage()
			.getScaledInstance(13, 13, Image.SCALE_SMOOTH));
	ImageIcon iconedit = new ImageIcon(new ImageIcon(TablaCustom.class.getResource("/img/editar.png")).getImage()
			.getScaledInstance(13, 13, Image.SCALE_SMOOTH));

	public ButtonRenderer() {
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if (isSelected) {
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
		} else {
			setForeground(table.getForeground());
			setBackground(UIManager.getColor("Button.background"));
		}
		setText((value == null) ? "" : value.toString());
		if (getText().equalsIgnoreCase("eliminar")) {
			setIcon(iconelim);
		} else if (getText().equalsIgnoreCase("editar")) {
			setIcon(iconedit);
		}
		table.repaint();
		return this;
	}
}

@SuppressWarnings("serial")
class Boton extends DefaultCellEditor {
	protected JButton btn;
	private String label;
	ImageIcon iconelim = new ImageIcon(new ImageIcon(TablaCustom.class.getResource("/img/eliminar.png")).getImage()
			.getScaledInstance(13, 13, Image.SCALE_SMOOTH));
	ImageIcon iconedit = new ImageIcon(new ImageIcon(TablaCustom.class.getResource("/img/editar.png")).getImage()
			.getScaledInstance(13, 13, Image.SCALE_SMOOTH));

	public Boton(JCheckBox checkBox, AbstractAction accion) {
		super(checkBox);
		btn = new JButton();
		btn.setAction(accion);
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		if (isSelected) {
			btn.setForeground(table.getSelectionForeground());
			btn.setBackground(table.getSelectionBackground());

		} else {
			btn.setForeground(table.getForeground());
			btn.setBackground(table.getBackground());

		}
		label = (value == null) ? "" : value.toString();
		btn.setText(label);
		if (btn.getText().equalsIgnoreCase("eliminar")) {
			btn.setIcon(iconelim);
		} else if (btn.getText().equalsIgnoreCase("editar")) {
			btn.setIcon(iconedit);
		}
		return btn;
	}

	public Object getCellEditorValue() {
		return new String(label);
	}

	public boolean stopCellEditing() {
		return super.stopCellEditing();
	}
}

class RendererBuscadorTabla extends DefaultTableCellRenderer {
	private final JTextField searchField;

	public RendererBuscadorTabla(JTextField searchField) {
		this.searchField = searchField;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		String txt = Objects.toString(value, "");
		String pattern = searchField.getText();

		if (Objects.nonNull(pattern) && !pattern.isEmpty()) {
			Matcher matcher = Pattern.compile(pattern).matcher(txt);
			int pos = 0;
			StringBuilder buf = new StringBuilder("<html>");
			while (matcher.find(pos)) {
				int start = matcher.start();
				int end = matcher.end();
				buf.append(String.format("%s<span style='color:#000000; background-color:#FFFF00'>%s</span>",
						txt.substring(pos, start), txt.substring(start, end)));
				pos = end;
			}
			buf.append(txt.substring(pos));
			txt = buf.toString();
		}
		super.getTableCellRendererComponent(table, txt, isSelected, hasFocus, row, column);
		return this;
	}
}
