
public class My16Cell extends MyPolytope {
	
	My16Cell(){
		V_NUM = 8;
		E_NUM = 24;
		F_NUM = 32;
		C_NUM = 16;
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
				//System.out.println(p[i].distance(p[j]));
				if(p[i].distance(p[j])<190) {
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
		//あやしい・・・・
		Vertex4d[][] fIndex = {
				{v[0],v[1],v[2]},//0
				{v[0],v[1],v[3]},//1
				{v[0],v[2],v[3]},//2
				{v[1],v[2],v[3]},//3
				
				{v[0],v[1],v[7]},//4
				{v[0],v[2],v[7]},//5
				{v[1],v[2],v[7]},//6
				
				{v[2],v[3],v[4]},//7
				{v[1],v[2],v[4]},//8
				{v[1],v[3],v[4]},//9
				
				{v[2],v[3],v[5]},//10
				{v[3],v[4],v[5]},//11
				{v[2],v[4],v[5]},//12
				
				{v[3],v[4],v[6]},//13
				{v[3],v[5],v[6]},//14
				{v[4],v[5],v[6]},//15
				
				{v[4],v[5],v[7]},//16
				{v[4],v[6],v[7]},//17
				{v[5],v[6],v[7]},//18
				
				{v[0],v[6],v[7]},//19
				{v[0],v[5],v[7]},//20
				{v[0],v[5],v[6]},//21
				
				{v[0],v[1],v[6]},//22
				{v[1],v[6],v[7]},//23
				{v[0],v[1],v[7]},//24
				
				{v[0],v[2],v[3]},//25
				{v[0],v[2],v[5]},//26
				{v[0],v[3],v[5]},//27
				
				{v[0],v[3],v[6]},//28
				
				{v[1],v[4],v[6]},//29
				{v[1],v[3],v[6]},//30
				
				{v[1],v[4],v[7]},//31
				
			
		};
		for(int i=0;i<f.length;i++) {
			f[i] = new Face4d(fIndex[i]);
		}
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
		
		for(int i=0;i<p.length;i++) {
			v[i] = new Vertex4d(p[i]);
			v[i].getPoint4d().setScale(130);
		}
	}
}
