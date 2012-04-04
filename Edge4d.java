import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;


public class Edge4d {

	//�t�B�[���h
	//�ӂ͒��_��2����
	private Vertex4d vList[];
	//�ӍʐF
	private Color eColor;
	//�X�g���[�N
	private BasicStroke wideStroke ;
	private GradientPaint gradient;

	public Edge4d(Vertex4d v0, Vertex4d v1) {

		this.vList = new Vertex4d[2];
		this.vList[0] = v0;
		this.vList[1] = v1;

		this.eColor = new Color(0,0,255,255);
		this.wideStroke = new BasicStroke(1.0f);
		this.gradient = new GradientPaint(
				 (float)v0.getPoint4d().getX(),
				 (float)v0.getPoint4d().getY(),
				 v0.getColor(),
				 (float)v1.getPoint4d().getX(),
				 (float)v1.getPoint4d().getY(),
				 v1.getColor()
		 );

	}

	//get�n
	public Color getColor() {return this.eColor;}
	public GradientPaint getGradient() {return this.gradient;}
	public Vertex4d getVertex4d(int n) {
		if (n == 1) {
			return vList[n];
		}
		else
			return vList[0];//�ʏ�͒��_0��Ԃ�
	}
	public BasicStroke getBasicStroke() {
		return this.wideStroke;
	}
	public void setBasicStroke(float w) {
		this.wideStroke = new BasicStroke(w);
	}

	//�����ӂ𔻒�
	public boolean equalEdge(Edge4d e) {
		if(this.getVertex4d(0).getPoint4d().equal(e.getVertex4d(0).getPoint4d()) &&
				this.getVertex4d(1).getPoint4d().equal(e.getVertex4d(1).getPoint4d()) ) {
			return true;
		}
		else if(this.getVertex4d(0).getPoint4d().equal(e.getVertex4d(1).getPoint4d()) &&
				this.getVertex4d(1).getPoint4d().equal(e.getVertex4d(0).getPoint4d()) ) {
			return true;
		}
		else
			return false;

	}


}
