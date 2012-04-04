abstract class MyPolytope {
	//���_�A�ӁA�ʂ̐�
	protected int V_NUM;
	protected int E_NUM;
	protected int F_NUM;
	protected int C_NUM;
	
	//���_�z��
	protected Point4d[] p;
	protected Vertex4d[] v;
	
	//�ӂ̏��
	protected Edge4d[] e;

	//�o�΂̒��_
	Point4d dual_points[];
	//�ʂ̏��
	protected Face4d[] f;
	
	//�E�̏��
	protected Cell4d[] c;
	
	abstract void setVertex4d() ;
	abstract void setEdge4d() ;
	abstract void setFace4d() ;
	abstract void setCell4d() ;
	
}
