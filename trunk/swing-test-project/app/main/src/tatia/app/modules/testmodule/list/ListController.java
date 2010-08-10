package tatia.app.modules.testmodule.list;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

import tatia.app.common.controller.Controller;
import tatia.app.modules.testmodule.ui.TestUI;
import tatia.swing.core.controller.ControllerInfo;

@ControllerInfo(target=TestUI.class)
public class ListController extends Controller<TestUI>{

	@Override
	public void init(TestUI ui) {
		Object[] items = new Object[]{"one","two","many"};
		ui.jComboBox1.setModel(new DefaultComboBoxModel(items));
		
		ui.jButton1.setText("hello!");
		ui.jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello");
			}
		});
		
	}

}
