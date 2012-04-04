public class My5Cell extends MyPolytope{

	My5Cell(){
		V_NUM = 5;
		E_NUM = 10;
		F_NUM = 10;
		C_NUM = 5;
		
		p =  new Point4d[V_NUM];
		dual_points = new Point4d[C_NUM];
		
		v =  new Vertex4d[V_NUM];
		e =  new Edge4d[E_NUM];
		f = new Face4d[F_NUM];
		c = new Cell4d[C_NUM];
		setVertex4d();
		setEdge4d();
		setFace4d();
		setCell4d();
	}
	@Override
	void setCell4d() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	void setEdge4d() {
		Vertex4d[][] eIndex = {
				{v[0],v[1]},{v[0],v[2]},{v[0],v[3]},{v[0],v[4]},
				{v[1],v[2]},{v[1],v[3]},{v[1],v[4]},
				{v[2],v[3]},{v[2],v[4]},
				{v[3],v[4]}
			};
		for(int i=0;i<e.length;i++) {
			e[i] = new Edge4d(eIndex[i][0],eIndex[i][1]);
		}
	}

	@Override
	void setFace4d() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	void setVertex4d() {
		double t1 = (1 + Math.sqrt(5)) / 4;
		double t2 = (5 + Math.sqrt(5)) / 20;
		t1 -= t2;
		p[0] = new Point4d(1 - t2, -t2, -t2, -t2);
		p[1] = new Point4d(-t2, 1 - t2, -t2, -t2);
		p[2] = new Point4d(-t2, -t2, 1 - t2, -t2);
		p[3] = new Point4d(-t2, -t2, -t2, 1 - t2);
		p[4] = new Point4d(t1, t1, t1, t1);
		
		for(int i=0;i<p.length;i++) {
			v[i] = new Vertex4d(p[i]);
			v[i].getPoint4d().setScale(130);
		}
		
	}

}
