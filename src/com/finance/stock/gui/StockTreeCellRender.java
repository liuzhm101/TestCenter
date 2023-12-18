package com.finance.stock.gui;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;


public class StockTreeCellRender extends DefaultTreeCellRenderer  {

	public StockTreeCellRender() {
		// TODO Auto-generated constructor stub
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean isSelected, boolean isExpanded, boolean isLeaf, int row,  boolean hasFocus)  
	{  
			  
        //执行父类原型操作  
        super.getTreeCellRendererComponent(tree, value, isSelected, isExpanded, isLeaf, row, hasFocus);  
		  
        setText(value.toString());  
        	         
        if (isSelected)  
        {  
              setForeground(getTextSelectionColor());  
        }  
        else  
        {  
              setForeground(getTextNonSelectionColor());  
        }  

        
      //得到每个节点的TreeNode  
       DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;  
       String str = node.toString();
       
       if (!isLeaf && node.getParent()!=null)
       {	        		        	
       	
       	this.setIcon(CommonTool.getButtonImage(StockKey.SuperDSRSHome+"\\resource\\images\\folder.png",17,16));
       		        		        	
       }
       
       if (isLeaf ) 
   	{
   		this.setIcon(CommonTool.getButtonImage(StockKey.SuperDSRSHome+"\\resource\\images\\tool.png",17,19));
   	}	        	
        
       
       return this;
	         
	         
	}

}
