package ADAPTER;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import MODELs.User;
/*import UTILs.Utility;*/

@SuppressWarnings("serial")
public class RendererListCellContact extends DefaultListCellRenderer implements ListCellRenderer<Object>{

	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// Assign to value that is passed
		User item = (User) value;
		setText(item.getUserName());
		//setIcon(new ImageIcon(Utility.getImageFile(item.getAvatarPath())));
		setIcon(new ImageIcon(getClass().getResource(item.getAvatarPath())));
		if(isSelected){
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		}else{
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		
		setEnabled(true);
		setFont(list.getFont());
		
		return this;
	}

	
}
