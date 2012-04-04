import java.awt.Color;


public class My8CellLattice extends MyPolytope {
	
	My8CellLattice(){
		V_NUM = 80;
		E_NUM = 192;
		F_NUM = 24;
		C_NUM = 8;
		
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
	void setVertex4d() {
		p[0] = new Point4d(1,1,1,1);
		p[1] = new Point4d(1,-1,1,1);
		p[2]= new Point4d(-1,-1,1,1);
		p[3] = new Point4d(-1,1,1,1);
		p[4] = new Point4d(1,1,-1,1);
		p[5] = new Point4d(1,-1,-1,1);
		p[6] = new Point4d(-1,-1,-1,1);
		p[7] =  new Point4d(-1,1,-1,1);
		p[8] = new Point4d(1,1,1,-1);
		p[9] = new Point4d(1,-1,1,-1);
		p[10]= new Point4d(-1,-1,1,-1);
		p[11] = new Point4d(-1,1,1,-1);
		p[12] = new Point4d(1,1,-1,-1);
		p[13] = new Point4d(1,-1,-1,-1);
		p[14] = new Point4d(-1,-1,-1,-1);
		p[15] =  new Point4d(-1,1,-1,-1);
		
		for(int i=16;i<32;i++) {
			p[i] =  new Point4d(p[i-16].getX(),p[i-16].getY(),p[i-16].getZ(),p[i-16].getU());
			p[i].translate(4,0,0,0);
		}
		
		for(int i=32;i<48;i++) {
			p[i] =  new Point4d(p[i-32].getX(),p[i-32].getY(),p[i-32].getZ(),p[i-32].getU());
			p[i].translate(-4,0,0,0);
		}
		
		for(int i=48;i<64;i++) {
			p[i] =  new Point4d(p[i-48].getX(),p[i-48].getY(),p[i-48].getZ(),p[i-48].getU());
			p[i].translate(0,0,4,0);
		}
		
		for(int i=64;i<80;i++) {
			p[i] =  new Point4d(p[i-64].getX(),p[i-64].getY(),p[i-64].getZ(),p[i-64].getU());
			p[i].translate(0,0,-4,0);
		}
		
		for(int i=0;i<p.length;i++) {
			v[i] = new Vertex4d(p[i]);
			v[i].getPoint4d().setScale(30);
		}
	}

	@Override
	void setEdge4d() {
		//辺の自動検索
		int[][] eIndex = new int[1000][2];
		
		int k=0;
		for(int i=0;i<p.length;i++) {
			for(int j=i+1;j<p.length;j++) {
				System.out.println(p[i].distance(p[j]));
				if(p[i].distance(p[j])==60.0) {
					eIndex[k][0] = i;
					eIndex[k++][1] = j;
					//System.out.println("{"+i+","+j+"}");
					
				}
			}
		}
		
		System.out.println("k="+k);
		for(int i=0;i<e.length;i++) {
			e[i] = new Edge4d(v[eIndex[i][0]] , v[eIndex[i][1]] );
			
		}
		
	}
	@Override
	void setCell4d() {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	void setFace4d() {
		// TODO 自動生成されたメソッド・スタブ
		
	}


}
