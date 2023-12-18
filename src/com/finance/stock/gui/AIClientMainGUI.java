package com.finance.stock.gui;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.Dimension;
import javax.swing.JToolBar;
import java.awt.BorderLayout;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;


import java.awt.Component;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.awt.FlowLayout;

public class AIClientMainGUI extends JFrame {
	
	JPanel desktopPanel = new JPanel();
	
	JDesktopPane desktopPane = new JDesktopPane();
	
	JButton btnDeployment;
	
	JCheckBoxMenuItem mntmDSRSServer;
	
	JCheckBoxMenuItem mntmCacheServer;
	
	JCheckBoxMenuItem mntmLocalServer;
	
	JCheckBoxMenuItem mntmHideToolBar;
	
	JCheckBoxMenuItem mntmDisplayToolBar;
	
	JPanel toolBarPanel=new JPanel();	
	
 	public AIClientMainGUI() {
		
		
		int screenWidth=((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
		int screenHeight = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().height); 
		System.out.println(screenWidth+"x"+screenHeight);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
								
				dispose();								
				
			}
		});
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(new Dimension(1350, 780));
		setExtendedState( Frame.MAXIMIZED_BOTH ); 
		
		setTitle("AI Quant Stock");
		
		// create main menu of Super DSRS 
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
				
		JMenu mnServer = new JMenu(" Server ");
		menuBar.add(mnServer);
		
		mntmDSRSServer = new JCheckBoxMenuItem("DSRS Server");		
		mnServer.add(mntmDSRSServer);
		mntmDSRSServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			

				
				
			}
		});
		
		
		mntmCacheServer = new JCheckBoxMenuItem("Cache Server");		
		mnServer.add(mntmCacheServer);
		mntmCacheServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if (mntmCacheServer.isSelected())
				{				
//					DSRSKey.DSRSServletLink="http://brddsrs/dsrs/DSRSServlet";
//					DSRSKey.DSRSCacheDataServerServletLink=DSRSKey.ELCCacheServer+"/dsrs/DSRSServlet";	
					
					mntmDSRSServer.setSelected(false);
					mntmLocalServer.setSelected(false);
					
					JOptionPane.showMessageDialog(null, "You have chosen to connect to Cache server.");
				}
				
			}
		});
		
		
		mntmLocalServer = new JCheckBoxMenuItem("Local Server");		
		mnServer.add(mntmLocalServer);
		mntmLocalServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if (mntmLocalServer.isSelected())
				{
//					DSRSKey.DSRSServletLink="http://localhost/dsrs/DSRSServlet";
//					DSRSKey.DSRSCacheDataServerServletLink="http://localhost/dsrs/DSRSServlet";
					
					mntmDSRSServer.setSelected(false);
					mntmCacheServer.setSelected(false);
					
					JOptionPane.showMessageDialog(null, "You have chosen to connect to Local Machine testing server.");
				}
				
			}
		});
		
	
		
		JSeparator separator_1 = new JSeparator();
		mnServer.add(separator_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");		
		mnServer.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				int result=JOptionPane.showConfirmDialog(null, "Do you want to exit SuperDSRS system?");
				if (result==0)
				{
					dispose();
				}
				
			}
		});
		

		
		
		
		
		JMenu mnAdmin = new JMenu(" Admin ");
		menuBar.add(mnAdmin);
		
		JMenuItem mntmDeployment = new JMenuItem("Deployments");
		mnAdmin.add(mntmDeployment);
		mntmDeployment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				processDeploymentClicked();
				
			}
		});

		JMenuItem mntmLocalMachine = new JMenuItem("Restart");
		mnAdmin.add(mntmLocalMachine);		
		mntmLocalMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				processRestartClicked();
				
			}
		});
		
		JMenuItem mntmConfigure = new JMenuItem("Stock");
		mnAdmin.add(mntmConfigure);
		mntmConfigure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				processStockClicked();
				
			}
		});
		
		JMenuItem mntmTools = new JMenuItem("Tools");
		mnAdmin.add(mntmTools);
		mntmTools.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				processToolsClicked();
				
			}
		});
		
		
		
		JMenu mnDsrs = new JMenu(" DSRS ");
		menuBar.add(mnDsrs);		
		
		JMenuItem mntmRequest = new JMenuItem("Request");
		mnDsrs.add(mntmRequest);
		mntmRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				processRequestClicked();
				
			}
		});
		
		JMenuItem mntmTasks = new JMenuItem("Task");
		mnDsrs.add(mntmTasks);
		mntmTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				processTaskClicked();
				
			}
		});
		
		JMenuItem mntmProblems = new JMenuItem("Problem");
		mnDsrs.add(mntmProblems);
		mntmProblems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				processProblemClicked();
				
			}
		});
		
		JMenuItem mntmShipevent = new JMenuItem("Shipevent");
		mnDsrs.add(mntmShipevent);
		mntmShipevent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				processShipeventClicked();
				
			}
		});
		
		JMenuItem mntmDiagnose = new JMenuItem(" Dectect ");
		mnDsrs.add(mntmDiagnose);
		mntmDiagnose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				processDiagnoseClicked();
				
			}
		});
		
		
		JMenu mnIntegrate = new JMenu("Integrate");
		menuBar.add(mnIntegrate);		
		
		JMenuItem mntmProject = new JMenuItem("Project");
		mnIntegrate.add(mntmProject);
		mntmProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				processProjectClicked();
				
			}
		});
		
		JMenuItem mntmCPRS = new JMenuItem("CPRS");
		mnIntegrate.add(mntmCPRS);
		mntmCPRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				processCPRSClicked();
				
			}
		});
		
		JMenuItem mntmErica = new JMenuItem("Erica");
		mnIntegrate.add(mntmErica);
		mntmErica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				processEricaClicked();
				
			}
		});
		
		JMenuItem mntmPreviewKit = new JMenuItem("Preview-Kit");
		mnIntegrate.add(mntmPreviewKit);
		mntmPreviewKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				processPreviewKitClicked();
				
			}
		});

		JMenuItem mntmRACE = new JMenuItem("RACE");
		mnIntegrate.add(mntmRACE);
		mntmRACE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				processRACEClicked();
				
			}
		});
		
		JMenuItem mntmStatistics = new JMenuItem("Statistics");
		mnIntegrate.add(mntmStatistics);
		mntmStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				processStatisticsClicked();
				
			}
		});
		
		
		JMenu mnWindow = new JMenu(" Window ");
		menuBar.add(mnWindow);
		
		mntmHideToolBar = new JCheckBoxMenuItem("Hide Tool Bar");		
		mnWindow.add(mntmHideToolBar);
		mntmHideToolBar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if (mntmHideToolBar.isSelected())
				{				
					mntmDisplayToolBar.setSelected(false);
					toolBarPanel.setVisible(false);
				}
				
			}
		});
		
		
		mntmDisplayToolBar = new JCheckBoxMenuItem("Display Tool Bar");		
		mnWindow.add(mntmDisplayToolBar);
		mntmDisplayToolBar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if (mntmDisplayToolBar.isSelected())
				{				
					mntmHideToolBar.setSelected(false);
					toolBarPanel.setVisible(true);
				}
				
			}
		});
		
		JSeparator separator_3 = new JSeparator();
		mnWindow.add(separator_3);
		
		
		JMenuItem mntmArrangeMenu = new JMenuItem("Arrange Window");
		mnWindow.add(mntmArrangeMenu);
		mntmArrangeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				JInternalFrame jifs[]=desktopPane.getAllFrames();
				for (int i=0; i<jifs.length; i++)
				{
					jifs[i].setLocation(10+i*30, 10+i*30);
					jifs[i].moveToFront();
				}
				
				
			}
		});
		
		JMenuItem mntmIconfyMenu = new JMenuItem("Iconfy Window");
		mnWindow.add(mntmIconfyMenu);
		mntmIconfyMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				JInternalFrame jifs[]=desktopPane.getAllFrames();
				for (int i=0; i<jifs.length; i++)
				{
					try
					{
						jifs[i].setIcon(true);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
			}
		});
		
		JMenuItem mntmRecoverMenu = new JMenuItem("Recover Window");
		mnWindow.add(mntmRecoverMenu);
		mntmRecoverMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				JInternalFrame jifs[]=desktopPane.getAllFrames();
				for (int i=0; i<jifs.length; i++)
				{
					try
					{
						jifs[i].setIcon(false);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
			}
		});
		
		
		JMenu mnHelp = new JMenu(" Help ");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelpContent = new JMenuItem("Help Content");
		mnHelp.add(mntmHelpContent);
		mntmHelpContent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
	
				
			}
		});
		
		JSeparator separator_2 = new JSeparator();
		mnHelp.add(separator_2);
		
		JMenuItem mntmAbout = new JMenuItem("About ");
		mnHelp.add(mntmAbout);
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				
			}
		});
		
		JToolBar toolBar = new JToolBar();
		JToolBar toolBar1 = new JToolBar();
		JToolBar toolBar2 = new JToolBar();
		JToolBar toolBar3 = new JToolBar();
		
	
		FlowLayout flowLayout = (FlowLayout) toolBarPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
//		getContentPane().add(toolBarPanel, BorderLayout.NORTH);
		
				
		toolBarPanel.add(toolBar);
		
		// create deployment button
		btnDeployment = new JButton("    Deployment    ");
		btnDeployment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				processDeploymentClicked();
			
			}
			
			
		});
//		btnDeployment.setIcon(new ImageIcon(DSRSSuperClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		btnDeployment.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"deployment.png"));
		btnDeployment.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDeployment.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar.add(btnDeployment);
		
		
		// create local button
		JButton btnNewButton = new JButton("     Restart     ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				processRestartClicked();
											
			}
		});
		btnNewButton.setSize(new Dimension(99, 23));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
//		btnNewButton.setIcon(new ImageIcon(DSRSSuperClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/Error.gif")));
		btnNewButton.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"restart.png"));
		toolBar.add(btnNewButton);

		
		// create configure button
		JButton btnConfigure = new JButton("      Stock      ");
		btnConfigure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				processStockClicked();
				
			}
		});
//		btnConfigure.setIcon(new ImageIcon(DSRSSuperClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
		btnConfigure.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"configure.png"));
		btnConfigure.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConfigure.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar.add(btnConfigure);
		
		JButton btnTools = new JButton("         Tools        ");
		btnTools.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				processToolsClicked();
			
				
			}
		});
//		btnTools.setIcon(new ImageIcon(DSRSSuperClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
		btnTools.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"tools.png"));
		btnTools.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTools.setHorizontalTextPosition(SwingConstants.CENTER);
//		toolBar.add(btnTools);
	
		
		toolBarPanel.add(toolBar1, BorderLayout.CENTER);

		
		// create request button
		JButton btnRequest = new JButton("    Request    ");
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				processRequestClicked();
				

			}
		});
//		btnRequest.setIcon(new ImageIcon(DSRSSuperClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
		btnRequest.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"request.png"));
		btnRequest.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRequest.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar1.add(btnRequest);
		
		

		// create task button
		JButton btnTask = new JButton("        Task        ");
		btnTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				processTaskClicked();
				
				
			}
		});
//		btnTask.setIcon(new ImageIcon(DSRSSuperClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
		btnTask.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"task.png"));
		btnTask.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTask.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar1.add(btnTask);
				
		

		// create problem button
		JButton btnProblem = new JButton("    Problem    ");
		btnProblem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				processProblemClicked();
				
				
			}
		});
		btnProblem.setSize(new Dimension(99, 23));
//		btnProblem.setIcon(new ImageIcon(DSRSSuperClientMainGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
		btnProblem.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"problem.png")); 
		btnProblem.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnProblem.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar1.add(btnProblem);
		
				

		// create shipevent button
		JButton btnShipevent = new JButton("    ShipEvent    ");
		btnShipevent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				processShipeventClicked();
				
				
			}
		});
//		btnShipevent.setIcon(new ImageIcon(DSRSSuperClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		btnShipevent.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"document.png"));
		btnShipevent.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnShipevent.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar1.add(btnShipevent);
		
		toolBarPanel.add(toolBar2);
		
		
		
		// create diagnose button
		JButton btnDiagnose = new JButton("     Detect     ");
		btnDiagnose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				processDiagnoseClicked();
				
				
			}
		});
//		btnDiagnose.setIcon(new ImageIcon(DSRSSuperClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		btnDiagnose.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"diagnose.png"));
		btnDiagnose.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDiagnose.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar1.add(btnDiagnose);
		
		toolBarPanel.add(toolBar2);
		
		
		
		// create statistics button
		JButton btnStatistics = new JButton("    Statistics    ");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				
				processStatisticsClicked();
								
				
			}
		});
		btnStatistics.setIcon(new ImageIcon(AIClientMainGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Warn.gif")));
		btnStatistics.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"statistics.png"));
		btnStatistics.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnStatistics.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar3.add(btnStatistics);   // move to the last panel 
		
		
		
		
		// create btnErica button
		JButton btnDSRS = new JButton("         Project         ");
		btnDSRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				processProjectClicked();
								
			}
		});
//		btnDSRS.setIcon(new ImageIcon(DSRSSuperClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
		btnDSRS.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"dsrs.png"));
		btnDSRS.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDSRS.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar2.add(btnDSRS);
		

		
		// create btnErica button
		JButton btnCPRS = new JButton("        CPRS        ");
		btnCPRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				processCPRSClicked();
				
				
			}
		});
//		btnCPRS.setIcon(new ImageIcon(DSRSSuperClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
		btnCPRS.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"cprs.png"));
		btnCPRS.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCPRS.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar2.add(btnCPRS);
		
		
		// create btnErica button
		JButton btnErica = new JButton("        Erica        ");
		btnErica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				processEricaClicked();
								
			}
		});
//		btnErica.setIcon(new ImageIcon(DSRSSuperClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
		btnErica.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"erica.png"));
		btnErica.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnErica.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar2.add(btnErica);			
		
		// create btnErica button
		JButton btnPREVIEW = new JButton("  Preview-Kit  ");
		btnPREVIEW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				processPreviewKitClicked();
				
								
				
			}
		});
//		btnPREVIEW.setIcon(new ImageIcon(DSRSSuperClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		btnPREVIEW.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"previewkit.png"));
		btnPREVIEW.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPREVIEW.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar2.add(btnPREVIEW);
		
				
		
		// create btnErica button
		JButton btnRACE = new JButton("         RACE         ");
		btnRACE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				processRACEClicked();
								
				
			}
		});
		//btnRACE.setIcon(new ImageIcon(DSRSSuperClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/Error.gif")));
		btnRACE.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"race.png"));
		btnRACE.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRACE.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar2.add(btnRACE);
		
		
		toolBarPanel.add(toolBar3);
		
		
		// create VDW button
		JButton btnVDW = new JButton("      Visual Deploy      ");
		btnVDW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try 
				{
					JOptionPane.showMessageDialog(null, "This function is to be developed!");
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				
			}
		});
		//btnRACE.setIcon(new ImageIcon(DSRSSuperClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/Error.gif")));
		btnVDW.setIcon(CommonTool.getButtonImage(StockKey.imgPath+"vdw.png"));
		btnVDW.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVDW.setHorizontalTextPosition(SwingConstants.CENTER);
//		toolBar3.add(btnVDW);
		
		
		
		// set desktop pane

		getContentPane().add(desktopPanel, BorderLayout.CENTER);
		desktopPanel.setLayout(new BorderLayout(0, 0));
		
		
		Color windowsDesktopColor=new Color(58, 110, 165);
		desktopPane.setBackground(windowsDesktopColor);
//		desktopPane.setForeground(SystemColor.desktop);
		desktopPanel.add(desktopPane, BorderLayout.CENTER);
		
		StockComponent.desktopPane=desktopPane;
		
		// add JInternalFrame into desktop

//		JInternalFrame dsrsJIF = new DSRSJInternalFrame();
//		dsrsJIF.setBounds(196, 68, 832, 425);
//		desktopPane.add(dsrsJIF);
//		DSRSComponent.dsrsJIF=dsrsJIF;
//		
//		JInternalFrame raceJIF = new RACEJInternalFrame();
//		raceJIF.setBounds(196, 68, 832, 425);
//		desktopPane.add(raceJIF);
//		DSRSComponent.raceJIF=raceJIF;
//		
//		JInternalFrame cprsJIF = new CPRSJInternalFrame();
//		cprsJIF.setBounds(216, 88, 832, 425);
//		desktopPane.add(cprsJIF);
//		DSRSComponent.cprsJIF=cprsJIF;
//		
//		JInternalFrame ericaJIF = new ERICAJInternalFrame();
//		ericaJIF.setBounds(236, 108, 832, 425);
//		desktopPane.add(ericaJIF);
//		DSRSComponent.ericaJIF=ericaJIF;
//		
//		JInternalFrame previewkitJIF = new PREVIEWKITJInternalFrame();
//		previewkitJIF.setBounds(256, 128, 832, 425);
//		desktopPane.add(previewkitJIF);
//		DSRSComponent.previewkitJIF=previewkitJIF;



		JPopupMenu desktopPopupMenu = new JPopupMenu();
		addPopup(desktopPane, desktopPopupMenu);
		
		JMenuItem mntmArrange = new JMenuItem("Arrange Window");
		mnWindow.add(mntmArrange);
		mntmArrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				JInternalFrame jifs[]=desktopPane.getAllFrames();
				for (int i=0; i<jifs.length; i++)
				{
					jifs[i].setLocation(10+i*30, 10+i*30);
					jifs[i].moveToFront();
				}
				
				
			}
		});
		mntmArrange.setIcon(new ImageIcon(AIClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		desktopPopupMenu.add(mntmArrange);
		
		
		JMenuItem mntmIconfy = new JMenuItem("Iconfy All");
		mntmIconfy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JInternalFrame jifs[]=desktopPane.getAllFrames();
				
				for (int i=0; i<jifs.length; i++)
				{
					try
					{
						jifs[i].setIcon(true);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
			}
		});
		mntmIconfy.setIcon(new ImageIcon(AIClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
		desktopPopupMenu.add(mntmIconfy);
		
		JMenuItem mntmRecover = new JMenuItem("Recover All");
		mntmRecover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JInternalFrame jifs[]=desktopPane.getAllFrames();
				
				for (int i=jifs.length-1; i>=0; i--)
				{
					try
					{
						jifs[i].setIcon(false);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
			}
		});
		mntmRecover.setIcon(new ImageIcon(AIClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		desktopPopupMenu.add(mntmRecover);
		
		JSeparator separ = new JSeparator();
		desktopPopupMenu.add(separ);
		
		JMenuItem mntmClose = new JMenuItem("Close All");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JInternalFrame jifs[]=desktopPane.getAllFrames();
				
				for (int i=0; i<jifs.length; i++)
				{
					try
					{
						jifs[i].dispose();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
			}
		});
		mntmClose.setIcon(new ImageIcon(AIClientMainGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		desktopPopupMenu.add(mntmClose);
		
		
		
//		GetSetKeyThread cbt=new GetSetKeyThread();
//		cbt.start();
		
		
//		if (DSRSKey.mode.equals("RACE"))
//		{
//			btnDeployment.setVisible(false);
//			toolBar1.setVisible(false);
//			toolBar2.setVisible(false);
//		}
		
//		if (DSRSComponent.onlineUser==null || DSRSComponent.onlineUser.getName().equals("guest"))
//		{
//			btnDeployment.setVisible(false);
//			toolBar1.setVisible(false);
//		}
		
		
		
//		processTaskClicked();
		
		processStockClicked();
		StockComponent.sjif.setSize(screenWidth-20, screenHeight-220);   //必须要单独设置，因为desktop目前还没有尺寸，不能根据这个尺寸来设置stock窗口
		
		String datasetFolderPath=StockKey.stockFullFolderPath;
		String stockFileName="stockcodelist_full";
		StockKey.stockMetaDataMap=CommonTool.getStockMetaDataMap(datasetFolderPath, stockFileName);
		
	}

	// add tree popup menu event 
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
		        
		        // only show popup menu at leaf node
				if (e.getButton() == 3) {  
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
				
			}
		});
	}
	
	
	public void processDeploymentClicked()
	{
	
//		try
//		{
//			
//			if (DSRSComponent.deploymentJIF==null)
//			{
//				JInternalFrame deploymentJIF = new DeploymentJInternalFrame();
//				deploymentJIF.setBounds(30, 20, 1200, 550);
//				desktopPane.add(deploymentJIF);
//				DSRSComponent.deploymentJIF=deploymentJIF;
//			}
//							
//			DSRSComponent.deploymentJIF.setIcon(false);
//			DSRSComponent.deploymentJIF.setVisible(true);
//			DSRSComponent.deploymentJIF.setSelected(true);
//			
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}	
//		
//		try
//		{
//			Thread.sleep(1000*3);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		
	}
	
	public void processRestartClicked()
	{
		
//		try
//		{
//			if (DSRSComponent.localJIF==null)
//			{
//				JInternalFrame localJIF = new LocalJInternalFrame();
//				localJIF.setBounds(80, 60, 1200, 550);
//				desktopPane.add(localJIF);
//				DSRSComponent.localJIF=localJIF;
//			}
//			
//			DSRSComponent.localJIF.setIcon(false);
//			DSRSComponent.localJIF.setVisible(true);
//			DSRSComponent.localJIF.setSelected(true);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		
	}
	
	public void processStockClicked()
	{
		
		try
		{
			
			if (StockComponent.sjif==null)
			{
				StockJInternalFrame sjif = new StockJInternalFrame();
//				configureJIF.setBounds(130, 100, 2400, 1250);
				
				desktopPane.add(sjif);
				CommonTool.setLocationInParentComponentCenter(sjif, desktopPane, 10, 10);
				StockComponent.sjif=sjif;
			}				
			
			StockComponent.sjif.setIcon(false);
			StockComponent.sjif.setVisible(true);
			StockComponent.sjif.setSelected(true);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void processToolsClicked()
	{
		
//		try
//		{
//			if (DSRSComponent.toolsJIF==null)
//			{
//				JInternalFrame toolsJIF = new ToolsJInternalFrame();
//				toolsJIF.setBounds(180, 140, 1200, 550);
//				desktopPane.add(toolsJIF);
//				DSRSComponent.toolsJIF=toolsJIF;
//			}
//			
//			DSRSComponent.toolsJIF.setIcon(false);
//			DSRSComponent.toolsJIF.setVisible(true);
//			DSRSComponent.toolsJIF.setSelected(true);
//
//			
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		
	}
	
	public void processRequestClicked()
	{
		
//		try
//		{
//			if (DSRSComponent.requestJIF==null)
//			{
//				JInternalFrame requestJIF = new RequestJInternalFrame();
//				requestJIF.setBounds(10, 10, 1500, 650);
////				CommonTool.setProperSizeOfFrame(desktopPane, requestJIF, 15, 15);
//				desktopPane.add(requestJIF);
//				DSRSComponent.requestJIF=requestJIF;
//			}
//			
//			DSRSComponent.requestJIF.setIcon(false);
//			DSRSComponent.requestJIF.setVisible(true);
//			DSRSComponent.requestJIF.setSelected(true);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		
		
	}
	
	
	public void processTaskClicked()
	{
		
//		try
//		{
//			if (DSRSComponent.taskJIF==null)
//			{
//				JInternalFrame taskJIF = new TaskJInternalFrame();
//				taskJIF.setBounds(40, 30, 1500, 650);
////				CommonTool.setProperSizeOfFrame(desktopPane, taskJIF, 25, 25);
//				desktopPane.add(taskJIF);
//				DSRSComponent.taskJIF=taskJIF;
//			}
//			
//			DSRSComponent.taskJIF.setIcon(false);
//			DSRSComponent.taskJIF.setVisible(true);
//			DSRSComponent.taskJIF.setSelected(true);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
		
	}
	
	public void processProblemClicked()
	{
		
//		try
//		{
//			if (DSRSComponent.problemJIF==null)
//			{
//				JInternalFrame problemJIF = new ProblemJInternalFrame();
//				problemJIF.setBounds(90, 70, 1400, 550);
////				CommonTool.setProperSizeOfFrame(desktopPane, problemJIF, 35, 35);						
//				desktopPane.add(problemJIF);
//				DSRSComponent.problemJIF=problemJIF;
//			}
//			
//			DSRSComponent.problemJIF.setIcon(false);
//			DSRSComponent.problemJIF.setVisible(true);
//			DSRSComponent.problemJIF.setSelected(true);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
		
	}

	public void processShipeventClicked()
	{
		
//		try
//		{
//			if (DSRSComponent.shipEventJIF==null)
//			{
//				JInternalFrame shipEventJIF=new ShipEventJInternalFrame();
////				problemJIF.setBounds(60, 30, 1200, 575);
//				CommonTool.setProperSizeOfFrame(desktopPane, shipEventJIF, 250, 100);
//				
//				desktopPane.add(shipEventJIF);
//				DSRSComponent.shipEventJIF=shipEventJIF;
//			}
//			
//			DSRSComponent.shipEventJIF.setIcon(false);
//			DSRSComponent.shipEventJIF.setVisible(true);
//			DSRSComponent.shipEventJIF.setSelected(true);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
		
	}
	
	public void processDiagnoseClicked()
	{
		
//		try
//		{
//			
//			if (DSRSComponent.monitorJIF==null)
//			{
//				MonitorJInternalFrame monitorJIF = new MonitorJInternalFrame();
//				monitorJIF.setBounds(330, 50, 1000, 650);
//				DSRSComponent.desktopPane.add(monitorJIF);
//				DSRSComponent.monitorJIF=monitorJIF;						
//
//			}				
//			
//			DSRSComponent.monitorJIF.machineTextField.setText("");					
//			DSRSComponent.monitorJIF.setIcon(false);
//			DSRSComponent.monitorJIF.setVisible(true);
//			DSRSComponent.monitorJIF.setSelected(true);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
	}
	
	
	public void processStatisticsClicked()
	{
		
//		
//		try
//		{
//			if (DSRSComponent.statisticsJIF==null)
//			{
//				JInternalFrame statisticsJIF = new StatisticsJInternalFrame();
////				statisticsJIF.setBounds(100, 100, 1500, 650);
//				CommonTool.setProperSizeOfFrame(desktopPane, statisticsJIF, 20, 20);
//				
//				desktopPane.add(statisticsJIF);
//				DSRSComponent.statisticsJIF=statisticsJIF;
//			}
//			
//			DSRSComponent.statisticsJIF.setIcon(false);
//			DSRSComponent.statisticsJIF.setVisible(true);
//			DSRSComponent.statisticsJIF.setSelected(true);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}				
//		
		
	}
	
	public void processProjectClicked()
	{
//		
//		try
//		{
//			if (DSRSComponent.projectJIF==null)
//			{
//				JInternalFrame projectJIF = new ProjectJInternalFrame();
//				projectJIF.setBounds(10, 10, 1400, 650);
//				desktopPane.add(projectJIF);
//				DSRSComponent.projectJIF=projectJIF;
//			}
//			DSRSComponent.projectJIF.setVisible(true);
//			DSRSComponent.projectJIF.setSelected(true);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
		
	}
	
	
	public void processCPRSClicked()
	{
		
//		try
//		{
//			if (DSRSComponent.cprsJIF==null)
//			{
//				JInternalFrame cprsJIF = new CPRSJInternalFrame();
//				cprsJIF.setBounds(90, 90, 1400, 650);
//				desktopPane.add(cprsJIF);
//				DSRSComponent.cprsJIF=cprsJIF;
//			}
//			
//			DSRSComponent.cprsJIF.setVisible(true);
//			DSRSComponent.cprsJIF.setSelected(true);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
		
	}
	
	public void processEricaClicked()
	{
		
		
//		try
//		{
//			if (DSRSComponent.ericaJIF==null)
//			{
//				JInternalFrame ericaJIF = new ERICAJInternalFrame();
//				ericaJIF.setBounds(190, 6, 1350, 650);
//				desktopPane.add(ericaJIF);
//				DSRSComponent.ericaJIF=ericaJIF;
//			}
//			
//			DSRSComponent.ericaJIF.setVisible(true);
//			DSRSComponent.ericaJIF.setSelected(true);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
				
	}
	
	public void processPreviewKitClicked()
	{
		
//		try
//		{
//			if (DSRSComponent.previewkitJIF==null)
//			{
//				JInternalFrame previewkitJIF = new PREVIEWKITJInternalFrame();
//				previewkitJIF.setBounds(240, 60, 1350, 650);
//				desktopPane.add(previewkitJIF);
//				DSRSComponent.previewkitJIF=previewkitJIF;
//			}
//			
//			DSRSComponent.previewkitJIF.setVisible(true);
//			DSRSComponent.previewkitJIF.setSelected(true);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		
		
	}
	
	
	public void processRACEClicked()
	{
		
//		try
//		{
//			if (DSRSComponent.raceJIF==null)
//			{
//				JInternalFrame raceJIF = new RACEJInternalFrame();
//				raceJIF.setBounds(50, 50, 1400, 650);
//				desktopPane.add(raceJIF);
//				DSRSComponent.raceJIF=raceJIF;
//			}
//			
//			DSRSComponent.raceJIF.setVisible(true);
//			DSRSComponent.raceJIF.setSelected(true);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		// initialize Super DSRS Client
		AIClientMainGUI sc=new AIClientMainGUI();
		int sc_x=Toolkit.getDefaultToolkit().getScreenSize().width/2-sc.getWidth()/2;
		int sc_y=Toolkit.getDefaultToolkit().getScreenSize().height/2-sc.getHeight()/2-40;
		sc.setLocation(sc_x, sc_y);		
		sc.setVisible(true);
		
		
		try
		{
			StockComponent.sjif.moveToFront();
			StockComponent.sjif.requestFocus();
			StockComponent.sjif.setSelected(true);
		}
		catch(Exception ec)
		{
			ec.printStackTrace();
		}
		
		try {

//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");//Nimbus风格，jdk6 update10版本以后的才会出现
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");//Motif风格，是蓝黑
//			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());//跨平台的Java风格
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//windows风格
			
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//当前系统风格
//			UIManager.setLookAndFeel("javax.swing.plaf.windows.WindowsLookAndFeel");//windows风格
//			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");//java风格
//			UIManager.setLookAndFeel("com.apple.mrj.swing.MacLookAndFeel");//待考察，

			} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}	
}
