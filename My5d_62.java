import java.util.Iterator;


public class My5d_62 extends MyPolytope {
	
	//6次元計算用配列
	int[][] points = new int[720][6];

	My5d_62(){
		V_NUM = 720;
		E_NUM = 1800;
		
		p =  new Point4d[V_NUM];
		v =  new Vertex4d[V_NUM];
		e =  new Edge4d[E_NUM];
		
		setVertex4d();
		setEdge4d();

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
				
				//6次元距離の計算
				double tmpX = Math.pow(points[i][0]-points[j][0],2);
				double tmpY = Math.pow(points[i][1]-points[j][1],2);
				double tmpZ = Math.pow(points[i][2]-points[j][2],2);
				double tmpU = Math.pow(points[i][3]-points[j][3],2);
				double tmpV = Math.pow(points[i][4]-points[j][4],2);
				double tmpW = Math.pow(points[i][5]-points[j][5],2);
				
				double distance = Math.sqrt(tmpX+tmpY+tmpZ+tmpU+tmpV+tmpW);
				
				//if(p[i].distance(p[j]) > 56.0 && p[i].distance(p[j]) < 57.0 ) {
				//ルート２系ならば辺が存在
				if(distance > 2.8 && distance < 2.9 ) {
					eIndex[k][0] = i;
					eIndex[k++][1] = j;
					//System.out.println("{"+i+","+j+"}");
					
					double lineX =Math.abs(points[i][0]-points[j][0]);
					double lineY =Math.abs(points[i][1]-points[j][1]);
					double lineZ =Math.abs(points[i][2]-points[j][2]);
					double lineU =Math.abs(points[i][3]-points[j][3]);
					double lineV =Math.abs(points[i][4]-points[j][4]);
					
					//System.out.println("{"+lineX+","+lineY+","+lineZ+","+lineU+","+lineV+"}");
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
		String[] strs = {"-5","-3","-1", "1", "3","5"};
		int[] vertex = new int[6];
		//System.out.println("N="+strs.length);
		Iterator e = new Permutation(strs);
		int count = 0;
		while(e.hasNext()) {
			String[] a = (String[])e.next();
			//System.out.print("{" + a[0]);
			for(int i=0; i<a.length; i++) {
				//System.out.print(", "+a[i]);
				vertex[i] = Integer.valueOf(a[i]);
				points[count][i] = vertex[i];
				//System.out.println(points[count]);
			}
			//System.out.println("}");
			p[count] =  new Point4d(vertex[0],vertex[1],vertex[2],vertex[3]);
			count++;
			
		}
		System.out.println("count="+count);
		
		for(int i=0;i<p.length;i++) {
			v[i] = new Vertex4d(p[i]);
			v[i].getPoint4d().setScale(20);
		} 
		
	}

}
