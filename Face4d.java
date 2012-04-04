import java.awt.Color;
import java.util.ArrayList;



public class Face4d {
	
	//頂点の数は一意ではないのでベクター型にする
	//private Vector<Vertex4d> vecV;
	private ArrayList<Vertex4d> vecV;
	
	
	//色
	private Color fColor;
	
	public Face4d(Vertex4d[] v) {
		this.vecV = new ArrayList<Vertex4d>();
		for(Vertex4d vertex: v) {
			this.addVertex4d(vertex);
		}
		fColor = new Color(0,128,0,64);
	}
	
	// 頂点の追加
	public void addVertex4d(Vertex4d v) {
		vecV.add(v);
	}

	// 頂点の取得
	public Vertex4d getVertex4d(int n) {
		return vecV.get(n);
	}

	// 頂点の個数（N角形）
	public int getVertexNum() {
		return vecV.size();
	}
	
	//面の色
	public Color getColor() {
		return this.fColor;
	}
	public void setColor(int r,int g,int b, int alpha) {
		this.fColor = new Color(r,g,b,alpha);
	}

}
