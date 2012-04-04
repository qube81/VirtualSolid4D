import java.awt.Color;
import java.util.ArrayList;

public class Cell4d {
		
	// �ʃ��X�gtest
	private ArrayList<Face4d> fList;
	public Color color;

	//Cell�͖ʂ̔z�������
	public Cell4d(Face4d[] f) {
		this.fList = new ArrayList<Face4d>();
		for(int i=0;i<f.length;i++) {
			addFace4d(f[i]);
		}
		this.color = new Color(0,128,0,32);
	}
	
	// �ʂ̒ǉ�
	public void addFace4d(Face4d f) {
		fList.add(f);
	}

	// �ʂ̎擾
	public Face4d getFace4d(int n) {
		return fList.get(n);
	}

	// �ʂ̐��̎擾
	public int getFaceNum() {
		return fList.size();
	}
	
	//�E�S�̂𓧖��ɂ���
	public void setInvisible() {
		for(int i=0;i<this.getFaceNum();i++) {
			this.getFace4d(i).setColor(255,255,255,0);
		}
	}
	
	//�E�S�̂̐F��ς���
	public void setColor(int r,int g,int b,int alpha) {
		for(int i=0;i<this.getFaceNum();i++) {
			this.getFace4d(i).setColor(r,g,b,alpha);
		}
	}

	public Color getColor() {
		return this.getFace4d(0).getColor();
	}
}
