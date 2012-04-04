import java.awt.Color;
import java.util.ArrayList;



public class Face4d {
	
	//���_�̐��͈�ӂł͂Ȃ��̂Ńx�N�^�[�^�ɂ���
	//private Vector<Vertex4d> vecV;
	private ArrayList<Vertex4d> vecV;
	
	
	//�F
	private Color fColor;
	
	public Face4d(Vertex4d[] v) {
		this.vecV = new ArrayList<Vertex4d>();
		for(Vertex4d vertex: v) {
			this.addVertex4d(vertex);
		}
		fColor = new Color(0,128,0,64);
	}
	
	// ���_�̒ǉ�
	public void addVertex4d(Vertex4d v) {
		vecV.add(v);
	}

	// ���_�̎擾
	public Vertex4d getVertex4d(int n) {
		return vecV.get(n);
	}

	// ���_�̌��iN�p�`�j
	public int getVertexNum() {
		return vecV.size();
	}
	
	//�ʂ̐F
	public Color getColor() {
		return this.fColor;
	}
	public void setColor(int r,int g,int b, int alpha) {
		this.fColor = new Color(r,g,b,alpha);
	}

}
