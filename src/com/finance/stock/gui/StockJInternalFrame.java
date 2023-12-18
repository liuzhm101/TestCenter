package com.finance.stock.gui;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JSplitPane;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import com.finance.stock.data.StockDayData;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StockJInternalFrame extends JInternalFrame {
	
	JTree ConfigureTree = new JTree();
	DefaultMutableTreeNode selectedToolsFileNode;
	JSplitPane splitPane = new JSplitPane();
	JPanel leftpanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	Map configureDetailViewMap=new HashMap();
	
	public TreePath lastTreePath[];
	
	public StockJInternalFrame() {
		
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent arg0) {
				
				StockComponent.sjif=null;
				
			}
		});
		
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Stock Market");
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 95));
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JToolBar toolBar = new JToolBar();
		panel.add(toolBar, BorderLayout.CENTER);
		
		JButton btnRefresh = new JButton("      Refresh      ");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				lastTreePath=ConfigureTree.getSelectionPaths();
				
				initConfigureTree();

				if (lastTreePath!=null)
				{
					for (int i=0; i<lastTreePath.length; i++)
					{
						int count=lastTreePath[i].getPathCount();
						for (int j=0; j<count; j++)
						{
							// 获得当前选择的那个节点
							DefaultMutableTreeNode tp_node=(DefaultMutableTreeNode)lastTreePath[i].getPathComponent(j);
							
							String nodeName=tp_node.getUserObject().toString();
							
							// 找到此节点并展开到此节点
							CommonTool.findInTree(ConfigureTree, nodeName);
							
						}
						
					}

				}
				
				
//				if(!tp_node.isLeaf()){
//					
//					 //判断该节点的路径.
//
//					 TreePath path=new TreePath(tp_node.getPath()); //定义路径变量.
//
//					 ConfigureTree.expandPath(path); //展开路径.
//
//				}
				
//				tabbedPane.removeAll();
				
			}
		});
		btnRefresh.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRefresh.setHorizontalTextPosition(SwingConstants.CENTER);
//		btnExecute.setIcon(new ImageIcon(ConfigureJInternalFrame.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		btnRefresh.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"refresh.png"));
		toolBar.add(btnRefresh);
		
		JButton btnClose = new JButton("         Close         ");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				closeConfigureFile();
			}
		});
		btnClose.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnClose.setHorizontalTextPosition(SwingConstants.CENTER);
		btnClose.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"problem.png"));
		toolBar.add(btnClose);
		
		JButton btnFilter = new JButton("         Filter         ");
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (StockComponent.sdp!=null)
				{
					StockFilterConditionDialog sfcd;
					if (StockComponent.sfcd==null)
					{
						sfcd=new StockFilterConditionDialog();
						StockComponent.sfcd=sfcd;
					}
					else
					{
						sfcd=StockComponent.sfcd;
					}
					
					CommonTool.setLocationInScreenCenter(sfcd);
					sfcd.setModal(true);
					sfcd.setVisible(true);
							
					String conditionStr=sfcd.conditionStr;
					StockComponent.sdp.initDatasetTableWithCondition(StockComponent.sdp.datasetFolder, StockComponent.sdp.datasetFileName, conditionStr);
					sfcd.setVisible(false);
					
				}
				
				
			}
		});
		btnFilter.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnFilter.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFilter.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"race.png"));
		toolBar.add(btnFilter);
		
		JToolBar toolBar1 = new JToolBar();
		panel.add(toolBar1, BorderLayout.EAST);
		
		JButton btn600 = new JButton("         600         ");
		btn600.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stockfilename="index000001";
				String datasetFolderPath=StockKey.stockAllFolderPath;
				drawKChartInNewFrame(datasetFolderPath, stockfilename);
				
			}
		});
		btn600.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn600.setHorizontalTextPosition(SwingConstants.CENTER);
		btn600.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"star.png"));
		toolBar1.add(btn600);
		
		JButton btn000 = new JButton("         000         ");
		btn000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stockfilename="index399001";
				String datasetFolderPath=StockKey.stockAllFolderPath;
				drawKChartInNewFrame(datasetFolderPath, stockfilename);
				
			}
		});
		btn000.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn000.setHorizontalTextPosition(SwingConstants.CENTER);
		btn000.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"statistics.png"));
		toolBar1.add(btn000);
		
		JButton btn002 = new JButton("         002         ");
		btn002.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stockfilename="index399005";
				String datasetFolderPath=StockKey.stockAllFolderPath;
				drawKChartInNewFrame(datasetFolderPath, stockfilename);
				
			}
		});
		btn002.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn002.setHorizontalTextPosition(SwingConstants.CENTER);
		btn002.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"pyramid.png"));
		toolBar1.add(btn002);
		
		JButton btn300 = new JButton("         300         ");
		btn300.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stockfilename="index399006";
				String datasetFolderPath=StockKey.stockAllFolderPath;
				drawKChartInNewFrame(datasetFolderPath, stockfilename);
				
			}
		});
		btn300.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn300.setHorizontalTextPosition(SwingConstants.CENTER);
		btn300.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"trojan.png"));
		toolBar1.add(btn300);
		
	
		
		
		JToolBar toolBar2 = new JToolBar();
		panel.add(toolBar2, BorderLayout.EAST);
	
		
		JButton btn50ETF = new JButton("      50ETF       ");
		btn50ETF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stockfilename="index510050";
				String datasetFolderPath=StockKey.stockAllFolderPath;
				drawKChartInNewFrame(datasetFolderPath, stockfilename);
				
			}
		});
		btn50ETF.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn50ETF.setHorizontalTextPosition(SwingConstants.CENTER);
		btn50ETF.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"star.png"));
		toolBar2.add(btn50ETF);
		
		
		JButton btn500ETF = new JButton("      500ETF       ");
		btn500ETF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stockfilename="index510500";
				String datasetFolderPath=StockKey.stockAllFolderPath;
				drawKChartInNewFrame(datasetFolderPath, stockfilename);
				
			}
		});
		btn500ETF.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn500ETF.setHorizontalTextPosition(SwingConstants.CENTER);
		btn500ETF.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"pyramid.png"));
		toolBar2.add(btn500ETF);
		
		JButton btnCYB50 = new JButton("      创业板50       ");
		btnCYB50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stockfilename="index159949";
				String datasetFolderPath=StockKey.stockAllFolderPath;
				drawKChartInNewFrame(datasetFolderPath, stockfilename);
				
			}
		});
		btnCYB50.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCYB50.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCYB50.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"vdw.png"));
		toolBar2.add(btnCYB50);
		
		JButton btnCYB = new JButton("     创业板        ");
		btnCYB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stockfilename="index159915";
				String datasetFolderPath=StockKey.stockAllFolderPath;
				drawKChartInNewFrame(datasetFolderPath, stockfilename);
				
			}
		});
		btnCYB.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCYB.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCYB.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"statistics.png"));
		toolBar2.add(btnCYB);
		
		
		JButton btnZXB = new JButton("     中小板        ");
		btnZXB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stockfilename="index159902";
				String datasetFolderPath=StockKey.stockAllFolderPath;
				drawKChartInNewFrame(datasetFolderPath, stockfilename);
				
			}
		});
		btnZXB.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnZXB.setHorizontalTextPosition(SwingConstants.CENTER);
		btnZXB.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"trojan.png"));
		toolBar2.add(btnZXB);
		
		JButton btnCSB = new JButton("     测试板        ");
		btnCSB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stockfilename="index159902";
				String datasetFolderPath=StockKey.stockAllFolderPath;
				drawKChartInNewFrame(datasetFolderPath, stockfilename);
				
			}
		});
		btnCSB.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCSB.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCSB.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"trojan.png"));
		toolBar2.add(btnCSB);
/*		
		JButton btn600E = new JButton("         600E         ");
		btn600E.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stockfilename="marketsumarydata_600";
				String datasetFolderPath=StockKey.stockFullFolderPath+"\\market";
				drawKChartInNewFrame(datasetFolderPath, stockfilename);
				
			}
		});
		btn600E.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn600E.setHorizontalTextPosition(SwingConstants.CENTER);
		btn600E.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"star.png"));
		toolBar2.add(btn600E);
		
		JButton btn000E = new JButton("         000E         ");
		btn000E.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stockfilename="marketsumarydata_000";
				String datasetFolderPath=StockKey.stockFullFolderPath+"\\market";
				drawKChartInNewFrame(datasetFolderPath, stockfilename);
				
			}
		});
		btn000E.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn000E.setHorizontalTextPosition(SwingConstants.CENTER);
		btn000E.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"statistics.png"));
		toolBar2.add(btn000E);
		
		JButton btn002E = new JButton("         002E         ");
		btn002E.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stockfilename="marketsumarydata_002";
				String datasetFolderPath=StockKey.stockFullFolderPath+"\\market";
				drawKChartInNewFrame(datasetFolderPath, stockfilename);
				
			}
		});
		btn002E.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn002E.setHorizontalTextPosition(SwingConstants.CENTER);
		btn002E.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"pyramid.png"));
		toolBar2.add(btn002E);
		
		JButton btn300E = new JButton("         300E         ");
		btn300E.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stockfilename="marketsumarydata_300";
				String datasetFolderPath=StockKey.stockFullFolderPath+"\\market";
				drawKChartInNewFrame(datasetFolderPath, stockfilename);
				
			}
		});
		btn300E.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn300E.setHorizontalTextPosition(SwingConstants.CENTER);
		btn300E.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"trojan.png"));
		toolBar2.add(btn300E);
		
		
*/		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 20));
		getContentPane().add(panel_1, BorderLayout.SOUTH);	
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JScrollPane leftScrollpane=new JScrollPane();
		leftScrollpane.setViewportView(ConfigureTree);
		splitPane.setLeftComponent(leftScrollpane);
		
		JPopupMenu configurePopupMenu = new JPopupMenu();
		addPopup(ConfigureTree, configurePopupMenu);
		
		JMenuItem mntmOpen = new JMenuItem("   Open   ");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				openStockData();
				
			}
		});
		mntmOpen.setIcon(new ImageIcon(StockJInternalFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
		configurePopupMenu.add(mntmOpen);
		
		JMenuItem mntmKChart = new JMenuItem("   KChart   ");
		mntmKChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				
				openStockKChart();
				
			}
		});		
		mntmKChart.setIcon(new ImageIcon(StockJInternalFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		configurePopupMenu.add(mntmKChart);
		
		JSeparator separator = new JSeparator();
		configurePopupMenu.add(separator);
		
		JMenuItem mntmHelp = new JMenuItem("   Help   ");
		mntmHelp.setIcon(new ImageIcon(StockJInternalFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
		configurePopupMenu.add(mntmHelp);
		

		
		splitPane.setRightComponent(tabbedPane);
		splitPane.setDividerLocation(300);
			
		initConfigureTree();
		
		this.addKeyListener(new StockKeyboardListener(this));
		this.setFocusable(true);  // 必须保证Frame获得焦点，从而才能响应Keyboard事件
		this.requestFocus();	
		
		openStockKChart();
	}

	
	
	
	
	
	public void closeConfigureFile()
	{
		
		int selectedPageIndex=tabbedPane.getSelectedIndex();						
		
//		JScrollPane selectedPane=(JScrollPane)tabbedPane.getSelectedComponent();
				
		tabbedPane.remove(selectedPageIndex);
		
			
	}
	
	
	public String getSelectedFileFullPath()
	{
	
		TreePath tp=ConfigureTree.getSelectionPath();
		Object[] path=tp.getPath();
		String filePath="";
		for (int i=0; i<path.length; i++)
		{
			filePath=filePath+File.separator+path[i];
		}
		
		String fileFullPath=StockKey.SuperDSRSHome+filePath;
		
		return fileFullPath;
		
	}
	
	public String getSelectedFileFolderPath()
	{
	
		TreePath tp=ConfigureTree.getSelectionPath();
		Object[] path=tp.getPath();
		String filePath="";
		for (int i=0; i<path.length-1; i++)
		{
			filePath=filePath+File.separator+path[i];
		}
		
//		String fullFilePath=StockKey.stockHome+filePath;
		String fullFilePath=StockKey.codeHome+filePath;
		return fullFilePath;
		
	}	
	
	
	public void initConfigureTree()
	{
		
		ConfigureTree.setCellRenderer(new StockTreeCellRender());
		
		ConfigureTree.addKeyListener(new StockKeyboardListener(this));
		
//		DefaultMutableTreeNode root=new DefaultMutableTreeNode("StockAllDataFull");
//		File configureFolder=new File(StockKey.stockHome+File.separator+root.getLastLeaf().toString());
		
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("MySASCode");
		File configureFolder=new File(StockKey.stockHome);
		
		buildTree(root, configureFolder);
		
		DefaultTreeModel dtm=new DefaultTreeModel(root);
		ConfigureTree.setModel(dtm);
		
		// 必须写在Tree中才能响应事件，因为最后init的是Tree，焦点停留在tree上
//		ConfigureTree.addKeyListener(new StockKeyboardListener());  
		
		
	}
	
	public static void buildTree(DefaultMutableTreeNode supernode, File dir) 
	{  
		
		File[] fs = dir.listFiles();  
		System.out.println(dir.getAbsolutePath());
		System.out.println(fs.length);
		for(int i=0; i<fs.length; i++)
		{   
//			System.out.println(fs[i].getAbsolutePath());   
			DefaultMutableTreeNode subnode=new DefaultMutableTreeNode(fs[i].getName());
			
			if(fs[i].isDirectory() 
			&& !fs[i].getName().contains("each") 
			&& !fs[i].getName().equals("Code")
			&& !fs[i].getName().equals("Log")
			&& !fs[i].getName().equals("Zip"))
			{    
				try{     
					buildTree(subnode, fs[i]);    
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}   
				
				supernode.add(subnode);
			} 
			
		} 
		
		for(int i=0; i<fs.length; i++)
		{   
//			System.out.println(fs[i].getAbsolutePath());   
			DefaultMutableTreeNode subnode=new DefaultMutableTreeNode(fs[i].getName());
			
			if(!fs[i].isDirectory())
			{    
				
				supernode.add(subnode);
			} 
			
			
		} 
		
	}
	
	public String getSelectedFileHelpFullPath(JTree ToolsTree)
	{
		
		TreePath tp=ToolsTree.getSelectionPath();
		Object[] path=tp.getPath();
		String filePath="";
		for (int i=0; i<path.length; i++)
		{
			filePath=filePath+File.separator+path[i];
		}
		
		String fileFullPath=StockKey.SuperDSRSHome+filePath;
		String fileHelpFullPath=fileFullPath+".hlp";
		
		return fileHelpFullPath;
			
	}
	
	private void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
								
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
				
				// remove all event out of tree node clicking
				TreePath path = ConfigureTree.getPathForLocation(e.getX(), e.getY()); 
		        if (path == null) {  
	        	        return;  
		         }  

		        selectedToolsFileNode=(DefaultMutableTreeNode)ConfigureTree.getSelectionPath().getLastPathComponent();		        
		        System.out.println(selectedToolsFileNode.toString());
				
				if (e.getClickCount() == 2 && (e.getModifiers() & e.BUTTON3_MASK) == 0)  // left click node 
				{
					
					openStockData();
					
				}	
				
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				
		        
		        // only show popup menu at leaf node
				if (e.getButton() == 3 && selectedToolsFileNode.isLeaf()) {  
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
				
			}
		});
		
	}
	
	
	public void openStockData()
	{
		
		TreePath tp=ConfigureTree.getSelectionPath();
		if (tp!=null)
		{
			DefaultMutableTreeNode node=(DefaultMutableTreeNode)ConfigureTree.getSelectionPath().getLastPathComponent();
            if(node!=null) 
            {
            	if (node.isLeaf())
            	{		                				              		                		
            		
            		JScrollPane jsp=null;
            		if (configureDetailViewMap.get(node)==null)
            		{
            					                			
            			String selectedFileFolderPath=getSelectedFileFolderPath();		   
            			String selectedFileName=node.toString();
            					                			
            			StockDetailTable vcdp=new StockDetailTable(selectedFileFolderPath, selectedFileName);	
            			
            			jsp=new JScrollPane();
            			jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            			jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            			jsp.setViewportView(vcdp);		                			
            			tabbedPane.add(node.toString(), jsp);		
            			
            			configureDetailViewMap.put(node, jsp);
            			
            			StockComponent.sdp=vcdp;
            			
            		}
            		else
            		{
            			jsp=(JScrollPane)configureDetailViewMap.get(node);		                			
            				                		
            		}
            			
            		tabbedPane.setSelectedComponent(jsp);			            		                
            		
            		
            	}
            }
		}
		else
		{
			
		}
		
	}
	
	public void openStockKChart()
	{
		TreePath tp=ConfigureTree.getSelectionPath();
		if (tp!=null)
		{
			DefaultMutableTreeNode node=(DefaultMutableTreeNode)ConfigureTree.getSelectionPath().getLastPathComponent();
            if(node!=null) 
            {
            	if (node.isLeaf())
            	{		  
            		try
            		{
	            		String stockfilename=CommonTool.getFileName(node.toString());
	            		
	            		try
	            		{
	            			String datasetFolderPath=StockKey.stockAllFolderPath;
	            			drawKChartInNewFrame(datasetFolderPath, stockfilename);
	            			
	            		}
	            		catch(Exception e)
	            		{
	            			e.printStackTrace();
	            		}

            		}
            		catch(Exception e)
            		{
            			e.printStackTrace();
            		}
            	}
            }
		}
		
		
		
	}
	
	public void drawKChartInNewFrame(String datasetFolderPath, String stockfilename)
	{
		
		try
		{
			
			List stockDataRecordList=CommonTool.getStockDataRecordList(datasetFolderPath, stockfilename);
		
			StockDayData sdd=(StockDayData)stockDataRecordList.get(stockDataRecordList.size()-1);
			String centerDate=sdd.getDate();
			
			int k_width=12;  // k线区域的宽度，一般要在10以上才行
			int y_distance=1;
			int d_height=0;
			
			StockKLineFrame sklc=new StockKLineFrame(stockDataRecordList, centerDate, k_width, y_distance, d_height);
			int desktopWidth=StockComponent.desktopPane.getWidth();
			int desktopHeight=StockComponent.desktopPane.getHeight();
			sklc.setSize(desktopWidth-60, desktopHeight-60);
			
			StockComponent.desktopPane.add(sklc);
			CommonTool.setLocationInParentComponentCenter(sklc, StockComponent.desktopPane, 30, 30);
			sklc.setVisible(true);
			sklc.setSelected(true);
			sklc.moveToFront();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
}
