
public class MyHexagonalHyperPrism extends MyPolytope {

	MyHexagonalHyperPrism(){
		V_NUM = 24;
		E_NUM = 48;
		F_NUM = 34;
		C_NUM = 10;
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
				if(distance > 99 && distance < 101 ) {
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
		
		for(int i=0; i<6;i++) {
			p[i] = new Point4d(Math.cos(Math.PI*i/3), Math.sin(Math.PI*i/3) ,0.5 ,-0.5);
			p[i+6] = new Point4d(Math.cos(Math.PI*i/3), Math.sin(Math.PI*i/3) ,-0.5 ,-0.5);
			p[i+12] = new Point4d(Math.cos(Math.PI*i/3), Math.sin(Math.PI*i/3) ,0.5 ,0.5);
			p[i+18] = new Point4d(Math.cos(Math.PI*i/3), Math.sin(Math.PI*i/3) ,-0.5 ,0.5);
		}
		
		for(int i=0;i<p.length;i++) {
			v[i] = new Vertex4d(p[i]);
			v[i].getPoint4d().setScale(100);
		}
		
	}

}
