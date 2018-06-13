package cs304_SuperBuy;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

public class ResultSetToTable {
//    public  main(final String[] arguments) {
//        SwingUtilities.invokeLater(() -> {
//            try {
//                new ResultSetToTable().createAndShowGui();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        });
//    }

    private void createAndShowGui() throws SQLException {
        final JFrame frame = new JFrame("Stack Overflow");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel();
        final TableModel tableModel = buildTableModel(getData("Audi"));
        final JTable table = new JTable(tableModel);
        panel.add(new JScrollPane(table));
        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    private ResultSet getData(final String btrName) throws SQLException {
        final String url = "jdbc:h2:/Freek/TBBBST";
        final Connection connection = DriverManager.getConnection(url, "me", "123");
        final String sql = "SELECT BBSTBBNR, BBSTNABE, BBSTPLZ " +
                "FROM BP.TBBBST " +
                "WHERE BBSTNABEG = ?";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, btrName);
        return preparedStatement.executeQuery();
    }

    /**
     * See https://stackoverflow.com/a/10625471/1694043
     */
    public static TableModel buildTableModel(final ResultSet resultSet)
            throws SQLException {
        int columnCount = resultSet.getMetaData().getColumnCount();

        // Column names.
        Vector<String> columnNames = new Vector<>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            columnNames.add(resultSet.getMetaData().getColumnName(columnIndex));
        }

        // Data of the table.
        Vector<Vector<Object>> dataVector = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> rowVector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                rowVector.add(resultSet.getObject(columnIndex));
            }
            dataVector.add(rowVector);
        }

        return new DefaultTableModel(dataVector, columnNames);
    }
}