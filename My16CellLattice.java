
public class My16CellLattice extends MyPolytope {
	
	public My16CellLattice() {
		// TODO 自動生成されたコンストラクター・スタブ
		V_NUM = 40;
		E_NUM = 438;
		F_NUM = 32;
		C_NUM = 16;
		p =  new Point4d[V_NUM];
		
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
				if(p[i].distance(p[j])<120) {
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
		p[0] = new Point4d(1,0,0,0);
		p[1] = new Point4d(0,1,0,0);
		p[2]= new Point4d(0,0,1,0);
		p[3] = new Point4d(0,0,0,1);

		p[4] = new Point4d(-1,0,0,0);
		p[5] = new Point4d(0,-1,0,0);
		p[6] = new Point4d(0,0,-1,0);
		p[7] =  new Point4d(0,0,0,-1);
		
		for(int i=8;i<16;i++) {
			p[i] =  new Point4d(p[i-8].getX(),p[i-8].getY(),p[i-8].getZ(),p[i-8].getU());
			p[i].translate(1,0,0,0);
		}
		
		for(int i=16;i<24;i++) {
			p[i] =  new Point4d(p[i-16].getX(),p[i-16].getY(),p[i-16].getZ(),p[i-16].getU());
			p[i].translate(-1,0,0,0);
		}
		
		for(int i=24;i<32;i++) {
			p[i] =  new Point4d(p[i-24].getX(),p[i-24].getY(),p[i-24].getZ(),p[i-24].getU());
			p[i].translate(0,1,0,0);
		}
		
		for(int i=32;i<40;i++) {
			p[i] =  new Point4d(p[i-32].getX(),p[i-32].getY(),p[i-32].getZ(),p[i-32].getU());
			p[i].translate(0,-1,0,0);
		}
		
		for(int i=0;i<p.length;i++) {
			v[i] = new Vertex4d(p[i]);
			v[i].getPoint4d().setScale(70);
		}
	}

}
