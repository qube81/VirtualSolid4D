import java.awt.Color;

//080803 4次元のVertexクラス
class Vertex4d {

	//フィールド
	//直径
	private int SIZE = 8;
	//色
	private Color vColor;
	//座標
	private Point4d p;
	
	//コンストラクタ
	public Vertex4d(Point4d p) {
		this.p = p;
		vColor = new Color(0,0,0);
	}

	//メソッド
	//get系
	public int getSize() {return this.SIZE;}
	public Color getColor() {return vColor;}
	public Point4d getPoint4d() {return p;}
	
	//set系
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
