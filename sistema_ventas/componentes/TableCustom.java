package componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TableCustom extends JTable {

    public TableCustom() {
        init();
    }

    public TableCustom(DefaultTableModel model) {
        super(model);
        init();
    }

    private void init() {
        setSelectionBackground(new Color(167, 230, 255));
    }

    @Override
    public Component prepareRenderer(TableCellRenderer tcr, int i, int i1) {
        Component com = super.prepareRenderer(tcr, i, i1);
        if (getValueAt(i, i1) != null) {
            if (getValueAt(i, i1) instanceof DefaultTableModel) {
                DefaultTableModel model = (DefaultTableModel) getValueAt(i, i1);
                JTable tbl = new TableCustom(model);
                tbl.setBackground(com.getBackground());
                autoRowHeight(tbl);
                initHeaderWidth(tbl);
                return tbl;
            } else if (getValueAt(i, i1) instanceof Header) {
                com.setFont(new Font(com.getFont().getFamily(), 1, com.getFont().getSize()));
                com.setBackground(new Color(209, 211, 252));
                com.setForeground(new Color(80, 80, 80));
                return com;
            }
        }
        if (!isCellSelected(i, i1)) {
            if (i % 2 == 0) {
                com.setBackground(new Color(255, 255, 255));
            } else {
                com.setBackground(new Color(245, 245, 245));
            }
            com.setForeground(new Color(80, 80, 80));
        }
        return com;
    }

    private void initHeaderWidth(JTable table) {
        for (int i = 0; i < table.getColumnCount(); i++) {
            Object obj = table.getValueAt(0, i);
            if (obj instanceof Header) {
                Header header = (Header) table.getValueAt(0, i);
                if (header.getWidth() >= 0) {
                    table.getColumnModel().getColumn(i).setPreferredWidth(header.getWidth());
                }
            }
        }
    }

    public void autoRowHeight(JTable table) {
        for (int row = 0; row < table.getRowCount(); row++) {
            int height = table.getRowHeight();
            for (int col = 0; col < table.getColumnCount(); col++) {
                Component comp = table.prepareRenderer(table.getCellRenderer(row, col), row, col);
                if (comp.getPreferredSize().height > height) {
                    height = comp.getPreferredSize().height;
                }
            }
            table.setRowHeight(row, height);
        }
    }

    @Override
    public TableCellEditor getCellEditor(int i, int i1) {
        return new componentes.TableCellEditor();
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        //  enable edit cell only subjtable
        return getValueAt(i, i1) instanceof DefaultTableModel;
    }
}
class TableCellEditor extends DefaultCellEditor {

    private DefaultTableModel model;

    public TableCellEditor() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        Component com = super.getTableCellEditorComponent(jtable, o, bln, i, i1);
        if (o instanceof DefaultTableModel) {
            model = (DefaultTableModel) o;
            JTable tbl = new TableCustom(model);
            tbl.setBackground(com.getBackground());
            initHeaderWidth(tbl);
            autoRowHeight(tbl);
            return tbl;
        } else {
            return com;
        }
    }

    @Override
    public Object getCellEditorValue() {
        //  pass this model to cell render
        return model;
    }

    private void initHeaderWidth(JTable table) {
        for (int i = 0; i < table.getColumnCount(); i++) {
            Object obj = table.getValueAt(0, i);
            if (obj instanceof Header) {
                Header header = (Header) table.getValueAt(0, i);
                if (header.getWidth() >= 0) {
                    table.getColumnModel().getColumn(i).setPreferredWidth(header.getWidth());
                }
            }
        }
    }

    public void autoRowHeight(JTable table) {
        for (int row = 0; row < table.getRowCount(); row++) {
            int height = table.getRowHeight();
            for (int col = 0; col < table.getColumnCount(); col++) {
                Component comp = table.prepareRenderer(table.getCellRenderer(row, col), row, col);
                if (comp.getPreferredSize().height > height) {
                    height = comp.getPreferredSize().height;
                }
            }
            table.setRowHeight(row, height);
        }
    }
}
