
public class MyRhomboHexagonalDodecahedron extends MyPolytope {

	MyRhomboHexagonalDodecahedron(){
		V_NUM = 36;
		E_NUM = 74;
		F_NUM = 48;
		C_NUM = 14;
		p =  new Point4d[V_NUM];
		v =  new Vertex4d[V_NUM];
		e =  new Edge4d[E_NUM];
		//f = new Face4d[F_NUM];
		//c = new Cell4d[C_NUM];
		setVertex4d();
		setEdge4d();
		//setFace4d();
		//setCell4d();

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
				//if(i==0) 
					//System.out.println(p[i].distance(p[j]));
				
				//4次元距離の計算
				double distance = p[i].distance(p[j]);
				//System.out.println(distance);
				
				//if(p[i].distance(p[j]) > 56.0 && p[i].distance(p[j]) < 57.0 ) {
				//ルート２系ならば辺が存在
				if(distance > 69 && distance < 70 ) {
					eIndex[k][0] = i;
					eIndex[k++][1] = j;
					//System.out.println("{"+i+","+j+"}");
				}
			}
		}
		
		//System.out.println("k="+k);
		
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
	
	
		p[0] = new Point4d(0,2,0,-Math.sqrt(3)/2);
		p[1] = new Point4d(0,-2,0,-Math.sqrt(3)/2);
		p[2] = new Point4d(1,1,1,-Math.sqrt(3)/2);
		p[3] = new Point4d(1,1,-1,-Math.sqrt(3)/2);
		p[4] = new Point4d(1,-1,1,-Math.sqrt(3)/2);
		p[5] = new Point4d(-1,1,1,-Math.sqrt(3)/2);
		p[6] = new Point4d(-1,-1,1,-Math.sqrt(3)/2);
		p[7] = new Point4d(1,-1,-1,-Math.sqrt(3)/2);
		p[8] = new Point4d(-1,1,-1,-Math.sqrt(3)/2);
		p[9] = new Point4d(-1,-1,-1,-Math.sqrt(3)/2);
		
		for(int i=0;i<10;i++) {
			if(p[i].getY()<0) {
				double tmpY = p[i].getY()-Math.sqrt(3)/2;
				p[i].setY(tmpY);
			}
			else if(p[i].getY()>0) {
				double tmpY = p[i].getY()+Math.sqrt(3)/2;
				p[i].setY(tmpY);
			}
		}
		
		p[10] = new Point4d(0,Math.sqrt(3)/2,2,-Math.sqrt(3)/2);
		p[11] = new Point4d(0,Math.sqrt(3)/2,-2,-Math.sqrt(3)/2);
		p[12] = new Point4d(2,Math.sqrt(3)/2,0,-Math.sqrt(3)/2);
		p[13] = new Point4d(-2,Math.sqrt(3)/2,0,-Math.sqrt(3)/2);
		
		p[14] = new Point4d(0,-Math.sqrt(3)/2,2,-Math.sqrt(3)/2);
		p[15] = new Point4d(0,-Math.sqrt(3)/2,-2,-Math.sqrt(3)/2);
		p[16] = new Point4d(2,-Math.sqrt(3)/2,0,-Math.sqrt(3)/2);
		p[17] = new Point4d(-2,-Math.sqrt(3)/2,0,-Math.sqrt(3)/2);
		
		for(int i=18;i<36;i++) {
			p[i]=new Point4d(p[i-18].getX(),p[i-18].getY(),p[i-18].getZ(),Math.sqrt(3)/2);
		}
		
		
		for(int i=0;i<p.length;i++) {
			v[i] = new Vertex4d(p[i]);
			v[i].getPoint4d().setScale(40);
		}
	}
}
