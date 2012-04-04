import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/*
<applet code="main4D.class" width=800 height=450>
</applet>
*/

@SuppressWarnings("serial")
public class main4D extends JApplet implements ActionListener,Runnable{
	
	//フレームレート
	static final int SLEEP_TIME = 30;
	
	//appletの大きさ
	static  int WIDTH = 900;
	static  int HEIGHT = 650;
	
	
	
	
	//現在の多胞体
	static int nowFigure = 1;
	
	
	private static JRadioButton[] rBtn;
	String[] planeName = {"xy","xz","xu","yz","yu","zu"};
	
	static final String[] figureName = {"8-cell","16-cell","24-cell","六角超柱","菱形十二面体超柱","菱型六角十二面体超柱",
			"切頂八面体超柱","30-cell"};
	private static JRadioButton[] figure ;
	
	//多胞体定数
	private static final int[] cells = {1,2,4,8,16,32,64,128};
	
	private static ButtonGroup group = new ButtonGroup();

	
	private static JButton[] btn;
	String[] actionName = {"start","stop","reset"};
	
	//コンテンツペイン
	Container contentPane;
	
	//実行中フラグ
	boolean isRun = false;
	boolean flag_plane[];
	boolean flag_cell[];
	
	
	//スレッド
	Thread thread = null;
	
	static MyPolytope solid;
	

	private JPanel northPanel,southPanel,centerPanel;

	private MyCanvas[] canvas;
	
	public void init(){
		solid = new My5d_62();
		
		contentPane = getContentPane();
		canvas = new MyCanvas[6];
				
		northPanel = new JPanel(new GridLayout(2, 4, 0, 0));
		centerPanel = new JPanel(new GridLayout(2, 3, 1, 1));
		southPanel = new JPanel(new GridLayout(1, 4, 0, 0));
		
		flag_plane = new boolean[6];
		flag_cell = new boolean[8];
		
		for(int i=0;i<flag_plane.length;i++) {
			flag_plane[i] = false;
		}
	
		rBtn = new JRadioButton[6];
		figure = new JRadioButton[8];
		btn = new JButton[3];
		
		for(int i=0;i<rBtn.length;i++) {
			rBtn[i] = new JRadioButton(planeName[i]);
			rBtn[i].addActionListener(this);
			southPanel.add(rBtn[i]);
		}
		for(int i=0;i<figure.length;i++) {
			figure[i] = new JRadioButton(figureName[i]);
			figure[i].addActionListener(this);
			northPanel.add(figure[i]);
			group.add(figure[i]);
		}
		
		
		for(int i=0;i<btn.length;i++) {
			btn[i] = new JButton(actionName[i]);
			btn[i].setActionCommand(actionName[i]);
			btn[i].addActionListener(this);
			southPanel.add(btn[i]);
		}
		
		
		northPanel.setOpaque(false);
		southPanel.setOpaque(false);
		
		contentPane.add(northPanel, BorderLayout.NORTH);
		
			
		for(int i=0;i<canvas.length;i++) {
			canvas[i] = new MyCanvas(i);
			centerPanel.add(canvas[i]);
		}
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		for(MyCanvas cnv : canvas) {
			cnv.setWBuf();
		}
		setSize(WIDTH,HEIGHT);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand()=="start") {
			startRotate();
			return;
		}
		
		else if(e.getActionCommand()=="stop") {
			stopRotate();
			return;
		}
		
		else if(e.getActionCommand()=="reset") {
			reset();
			return;
		}
		else {
			for(int i=0;i<rBtn.length;i++) {
				if(e.getSource() == rBtn[i]) {
					flag_plane[i] = rBtn[i].isSelected() ? true : false;
					return;
				}
			}
			for(int i=0;i<figure.length;i++) {
				if(e.getSource() == figure[i]) {
					nowFigure = cells[i];
					reset();
					return;
				}
			}
		}
		
		
	}


	@Override
	public void run() {
		while(isRun){
			for(int i=0;i<solid.v.length;i++) {
				if(flag_plane[0]) 
					Rotation4d.RotateXY(solid.v[i].getPoint4d(),1);
				if(flag_plane[1]) 
					Rotation4d.RotateXZ(solid.v[i].getPoint4d(),1);
				if(flag_plane[2]) 
					Rotation4d.RotateXU(solid.v[i].getPoint4d(),1);
				if(flag_plane[3]) 
					Rotation4d.RotateYZ(solid.v[i].getPoint4d(),1);
				if(flag_plane[4]) 
					Rotation4d.RotateYU(solid.v[i].getPoint4d(),1);
				if(flag_plane[5]) 
					Rotation4d.RotateZU(solid.v[i].getPoint4d(),1);
			}
			for(MyCanvas cnv :canvas) {
				cnv.repaint();
			}
			 try {
			    	Thread.sleep(SLEEP_TIME);
			    } catch(InterruptedException e) {
			    	System.out.println("SLEEP ERROR");
			    }
			}	
	}
	
	//スレッド
	public void startRotate(){
		if (!isRun){
			isRun = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	public void stopRotate() {
		isRun = false;
		if( thread != null ){
			thread = null;
		}

	}
	
	public void reset() {
		isRun = false;
		for(int i=0;i<flag_plane.length;i++ ) {
			rBtn[i].setSelected(false);
			flag_plane [i]= false;
		}
		switch(nowFigure) {
			case 1 :
				solid = new My8Cell();
				break;
			case 2:
				solid = new My16Cell();
				break;
			case 4 :
				solid = new My24Cell();
				break;
			case 8 :
				solid = new MyHexagonalHyperPrism();
				break;
			case 16 :
				solid = new MyRhombicDodecahedronPillar();
				break;
			case 32 :
				solid = new MyRhomboHexagonalDodecahedron();
				break;
			case 64 :
				solid = new MyTruncatedOctahedronPillar();
				break;
			case 128 :
				solid = new My30Cell();
				break;
		}
		for(MyCanvas cnv : canvas) {
			cnv.reset();
		}
	}
}
