/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tatia.app.modules.testmodule.table;

import javax.swing.JTable;
import tatia.app.common.controller.Controller;
import tatia.app.modules.testmodule.ui.TableUI;
import tatia.swing.core.controller.ControllerInfo;

/**
 *
 * @author gorosh.natalia
 */
@ControllerInfo(target=TableUI.class)
public class TableController extends Controller<TableUI> {

    JTable table;

    @Override
    public void init(TableUI ui) {
        table = ui.jTable1;
        int columnsCount = table.getColumnCount();
        //заполняем первую строку
        for (int i=0; i< columnsCount; i++)
        {
            table.setValueAt("data"+i, 0, i);
        }
    }

    public void addElement(TableItem item)
    {
        //STUB
    }

    public void removeElement(int row, int col)
    {
        //STUB
    }


}
