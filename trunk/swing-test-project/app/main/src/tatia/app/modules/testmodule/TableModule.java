/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tatia.app.modules.testmodule;

import tatia.app.common.module.Module;
import tatia.app.modules.testmodule.table.TableController;
import tatia.app.modules.testmodule.table.TableItem;
import tatia.app.modules.testmodule.ui.TableUI;

/**
 *
 * @author gorosh.natalia
 */
public class TableModule extends Module<TableUI>{

    @Override
    protected TableUI createUI() {
        return new TableUI();
    }

    public void addElement(TableItem item){
        get(TableController.class).addElement(item);
    }

    public void removeElement(int row, int col){
        get(TableController.class).removeElement(row, col);
    }



}
