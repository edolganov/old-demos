/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tatia.app.modules.testmodule.table;

/**
 *
 * @author gorosh.natalia
 */
public class TableItem {

    private String element1;
    private String element2;
    private Integer element3;

    public TableItem(String element1, String element2, Integer element3) {
        this.element1 = element1;
        this.element2 = element2;
        this.element3 = element3;
    }

    

    public String getElement1() {
        return element1;
    }

    public void setElement1(String element1) {
        this.element1 = element1;
    }

    public String getElement2() {
        return element2;
    }

    public void setElement2(String element2) {
        this.element2 = element2;
    }

    public Integer getElement3() {
        return element3;
    }

    public void setElement3(Integer element3) {
        this.element3 = element3;
    }



}
