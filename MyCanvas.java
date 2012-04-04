import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;


@SuppressWarnings("serial")
public class MyCanvas extends Canvas{

	//��ʃT�C�Y
	public static final int CANVAS_WIDTH = 300;
	public static final int CANVAS_HEIGHT = 300;
	
	//�_�u���o�b�t�@�p�I�t�X�N���[��
	private Image offs;
	private Graphics2D offg;
	
	int plane;
	MyDrawing d;
	
	protected MyPolytope qube ;
	
	public MyCanvas(int plane) {
		setPolytope();
		this.plane = plane;
	}
	
	public void setPolytope() {
		qube = main4D.solid;
	}
	
	public void setWBuf(){
		offs = createImage(CANVAS_WIDTH, CANVAS_HEIGHT);
		offg = (Graphics2D)offs.getGraphics();
		offg .setRenderingHint(RenderingHints.KEY_ANTIALIASING,  
				RenderingHints.VALUE_ANTIALIAS_ON);
		offg .setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
		                      RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		d = new MyDrawing(offg,qube,this.plane);
	}
	
	//img��]�����邾��
	public void paint(Graphics g){
		//draw();
		d.draw();
		g.drawImage(offs,0,0,this);  
	}
	
	//update�̃I�[�o�[���C�h
	public void update(Graphics g){
		paint(g);
	}
	
	
	public void reset() {
		setPolytope();
		d = new MyDrawing(offg,qube,this.plane);
		repaint();
	}
}
