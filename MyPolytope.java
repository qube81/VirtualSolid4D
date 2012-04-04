abstract class MyPolytope {
	//頂点、辺、面の数
	protected int V_NUM;
	protected int E_NUM;
	protected int F_NUM;
	protected int C_NUM;
	
	//頂点配列
	protected Point4d[] p;
	protected Vertex4d[] v;
	
	//辺の情報
	protected Edge4d[] e;

	//双対の頂点
	Point4d dual_points[];
	//面の情報
	protected Face4d[] f;
	
	//胞の情報
	protected Cell4d[] c;
	
	abstract void setVertex4d() ;
	abstract void setEdge4d() ;
	abstract void setFace4d() ;
	abstract void setCell4d() ;
	
}
