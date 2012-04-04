public class My8Cell extends MyPolytope {

	My8Cell(){
		V_NUM = 16;
		E_NUM = 32;
		F_NUM = 24;
		C_NUM = 8;
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

	//頂点をセット
	public void setVertex4d() {
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
		
	
		for(int i=0;i<p.length;i++) {
			v[i] = new Vertex4d(p[i]);
			v[i].getPoint4d().setScale(60);
		}
	}

	public void setEdge4d() {
		int[][] eIndex = new int[E_NUM][2];
		
		int k=0;
		for(int i=0;i<v.length;i++) {
			for(int j=i+1;j<v.length;j++) {
				//4次元距離の計算
				double distance = p[i].distance(p[j]);
				if(distance == 120) {
					eIndex[k][0] = i;
					eIndex[k++][1] = j;
					//System.out.println("{"+i+","+j+"}");
				}
			}
		}
		
	
		for(int i=0;i<e.length;i++) {
			e[i] = new Edge4d(v[eIndex[i][0]] , v[eIndex[i][1]] );
			if(i>32)
				e[i].setBasicStroke(5);
		}


	}
	public void setFace4d() {
		Vertex4d[][] fIndex = {
				{v[0],v[1],v[2],v[3]},//0
				{v[4],v[5],v[6],v[7]},//1
				{v[0],v[1],v[5],v[4]},//2
				{v[0],v[4],v[7],v[3]},//3
				{v[2],v[6],v[7],v[3]},//4
				{v[1],v[5],v[6],v[2]},//5

				{v[8],v[9],v[10],v[11]},//6
				{v[12],v[13],v[14],v[15]},//7
				{v[8],v[9],v[13],v[12]},//8
				{v[9],v[13],v[14],v[10]},//9
				{v[10],v[14],v[15],v[11]},//10
				{v[8],v[12],v[15],v[11]},//11

				{v[0],v[1],v[9],v[8]},//12
				{v[1],v[2],v[10],v[9]},//13
				{v[2],v[3],v[11],v[10]},//14
				{v[0],v[3],v[11],v[8]},//15

				{v[0],v[4],v[12],v[8]},//16
				{v[3],v[7],v[15],v[11]},//17
				{v[2],v[6],v[14],v[10]},//18
				{v[1],v[5],v[13],v[9]},//19

				{v[5],v[6],v[14],v[13]},//20
				{v[6],v[7],v[15],v[14]},//21
				{v[4],v[7],v[15],v[12]},//22
				{v[5],v[4],v[12],v[13]},//23

		};

		for(int i=0;i<f.length;i++) {
			f[i] = new Face4d(fIndex[i]);
		}

	}
	
	public void setCell4d() {
		Face4d[][] cIndex = {
				{f[0],f[1],f[2],f[3],f[4],f[5]},
				{f[6],f[7],f[8],f[9],f[10],f[11]},
				
				{f[3],f[22],f[17],f[16],f[11],f[15]},
				{f[5],f[20],f[18],f[9],f[13],f[19]},
				
				{f[2],f[12],f[16],f[23],f[8],f[19]},
				{f[4],f[14],f[17],f[18],f[21],f[10]},
				
				{f[1],f[22],f[21],f[20],f[23],f[7]},
				{f[0],f[14],f[15],f[12],f[13],f[6]},
		};
		
		for(int i=0;i<cIndex.length;i++) {
			c[i] = new Cell4d(cIndex[i]);
			dual_points[0] = setDualPoint4d(cIndex[0]);
		}
	}
	
	public Point4d setDualPoint4d(Face4d[] f) {
		double tmpX=0,tmpY=0,tmpZ=0,tmpU=0,counter =0;
		for(int i=0;i<f.length;i++) {
			for(int j=0;j<f[i].getVertexNum();j++) {
				tmpX+=f[i].getVertex4d(j).getPoint4d().getX();
				tmpY+=f[i].getVertex4d(j).getPoint4d().getY();
				tmpZ+=f[i].getVertex4d(j).getPoint4d().getZ();
				tmpU+=f[i].getVertex4d(j).getPoint4d().getU();
				counter++;
			}
		}	
		tmpX /= counter;
		tmpY /= counter;
		tmpZ /= counter;
		tmpU /= counter;
		//System.out.println("("+tmpX+","+tmpY+","+tmpZ+","+tmpU+")");
		Point4d d = new Point4d(tmpX,tmpY,tmpZ,tmpU);
		return d;
	}

}
