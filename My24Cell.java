public class My24Cell extends MyPolytope {
	
	My24Cell(){
		V_NUM = 24;
		E_NUM = 96;
		F_NUM = 96;
		C_NUM = 24;
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
		int k = 0;
		Vertex4d[][] eIndex = new Vertex4d[E_NUM][2];
		double x, y, z, u = 0;
		for(int i = 0; i < V_NUM; i++){
			for(int j = i + 1; j < V_NUM; j++){
				x = p[i].getX() * p[j].getX();
				y = p[i].getY() * p[j].getY();
				z = p[i].getZ() * p[j].getZ();
				u = p[i].getU() * p[j].getU();
				if(x >= 0 && y >= 0 && z >= 0 && u >= 0 && x + y + z + u != 0){
					eIndex [k][0] = v[i];
					eIndex [k++][1] =v[j];
				}
			}
		}
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
		p[0] = new Point4d(1, 1, 0, 0);
		p[1] = new Point4d(1, 0, 1, 0);
		p[2] = new Point4d(1, 0, 0, 1);
		p[3] = new Point4d(1, -1, 0, 0);
		p[4] = new Point4d(1, 0, -1, 0);
		p[5] = new Point4d(1, 0, 0, -1);
		p[6] = new Point4d(-1, 1, 0, 0);
		p[7] = new Point4d(-1, 0, 1, 0);
		p[8] = new Point4d(-1, 0, 0, 1);
		p[9] = new Point4d(-1, -1, 0, 0);
		p[10] = new Point4d(-1, 0, -1, 0);
		p[11] = new Point4d(-1, 0, 0, -1);
		p[12] = new Point4d(0, 1, 1, 0);
		p[13] = new Point4d(0, 1, 0, 1);
		p[14] = new Point4d(0, 1, -1, 0);
		p[15] = new Point4d(0, 1, 0, -1);
		p[16] = new Point4d(0, -1, 1, 0);
		p[17] = new Point4d(0, -1, 0, 1);
		p[18] = new Point4d(0, -1, -1, 0);
		p[19] = new Point4d(0, -1, 0, -1);
		p[20] = new Point4d(0, 0, 1, 1);
		p[21] = new Point4d(0, 0, 1, -1);
		p[22] = new Point4d(0, 0, -1, 1);
		p[23] = new Point4d(0, 0, -1, -1);
		
		for(int i=0;i<p.length;i++) {
			v[i] = new Vertex4d(p[i]);
			v[i].getPoint4d().setScale(100);
		}
	}

}
