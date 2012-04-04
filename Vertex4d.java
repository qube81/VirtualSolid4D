import java.awt.Color;

//080803 4������Vertex�N���X
class Vertex4d {

	//�t�B�[���h
	//���a
	private int SIZE = 8;
	//�F
	private Color vColor;
	//���W
	private Point4d p;
	
	//�R���X�g���N�^
	public Vertex4d(Point4d p) {
		this.p = p;
		vColor = new Color(0,0,0);
	}

	//���\�b�h
	//get�n
	public int getSize() {return this.SIZE;}
	public Color getColor() {return vColor;}
	public Point4d getPoint4d() {return p;}
	
	//set�n
	public void setSize(int s){
		this.SIZE = s;
	}
	public void setColor(Color c) {
		this.vColor = c;
	}
	public void  setPoint4d(Point4d p) {
		this.p = p;
	}
}
