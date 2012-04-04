
public class My24CellLattice extends MyPolytope {

	My24CellLattice(){
		V_NUM = 72;
		E_NUM = 800;
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
		//辺の自動検索
		int[][] eIndex = new int[E_NUM][2];
		
		int k=0;
		for(int i=0;i<p.length;i++) {
			for(int j=i+1;j<p.length;j++) {
				System.out.println(p[i].distance(p[j]));
				if(p[i].distance(p[j])<80) {
					eIndex[k][0] = i;
					eIndex[k++][1] = j;
					System.out.println("{"+i+","+j+"}");
					
				}
			}
		}
		
		System.out.println("k="+k);
		for(int i=0;i<e.length;i++) {
			e[i] = new Edge4d(v[eIndex[i][0]] , v[eIndex[i][1]] );
			
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
		
		for(int i=24;i<48;i++) {
			p[i] =  new Point4d(p[i-24].getX(),p[i-24].getY(),p[i-24].getZ(),p[i-24].getU());
			p[i].translate(1,1,0,0);
		}
		
		for(int i=48;i<72;i++) {
			p[i] =  new Point4d(p[i-48].getX(),p[i-48].getY(),p[i-48].getZ(),p[i-48].getU());
			p[i].translate(-1,-1,0,0);
		}
		
		for(int i=0;i<p.length;i++) {
			v[i] = new Vertex4d(p[i]);
			v[i].getPoint4d().setScale(50);
		}
	}

}
