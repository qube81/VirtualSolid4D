import java.awt.Color;
import java.util.ArrayList;

public class Cell4d {
		
	// 面リストtest
	private ArrayList<Face4d> fList;
	public Color color;

	//Cellは面の配列を持つ
	public Cell4d(Face4d[] f) {
		this.fList = new ArrayList<Face4d>();
		for(int i=0;i<f.length;i++) {
			addFace4d(f[i]);
		}
		this.color = new Color(0,128,0,32);
	}
	
	// 面の追加
	public void addFace4d(Face4d f) {
		fList.add(f);
	}

	// 面の取得
	public Face4d getFace4d(int n) {
		return fList.get(n);
	}

	// 面の数の取得
	public int getFaceNum() {
		return fList.size();
	}
	
	//胞全体を透明にする
	public void setInvisible() {
		for(int i=0;i<this.getFaceNum();i++) {
			this.getFace4d(i).setColor(255,255,255,0);
		}
	}
	
	//胞全体の色を変える
	public void setColor(int r,int g,int b,int alpha) {
		for(int i=0;i<this.getFaceNum();i++) {
			this.getFace4d(i).setColor(r,g,b,alpha);
		}
	}

	public Color getColor() {
		return this.getFace4d(0).getColor();
	}
}
