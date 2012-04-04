import java.util.Iterator;


public class MyTruncatedOctahedronPillar extends MyPolytope {

	
	MyTruncatedOctahedronPillar(){
		V_NUM = 48;
		E_NUM = 96;
		F_NUM = 64;
		C_NUM = 16;
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
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

	@Override
	void setEdge4d() {
		//�ӂ̎�������
		int[][] eIndex = new int[E_NUM][2];
		
		int k=0;
		for(int i=0;i<p.length;i++) {
			for(int j=i+1;j<p.length;j++) {
				//if(i==0) 
					//System.out.println(p[i].distance(p[j]));
				
				//4���������̌v�Z
				double distance = p[i].distance(p[j]);
				//System.out.println(distance);
				
				//if(p[i].distance(p[j]) > 56.0 && p[i].distance(p[j]) < 57.0 ) {
				//���[�g�Q�n�Ȃ�Εӂ�����
				if(distance > 84 && distance < 85 ) {
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
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

	@Override
	void setVertex4d() {
		p[0] = new Point4d(-1, 2, 0 ,-Math.sqrt(2)/2);
		p[1] = new Point4d(0, 2, 1 ,-Math.sqrt(2)/2);
		p[2] = new Point4d(1, 2, 0 ,-Math.sqrt(2)/2);
		p[3] = new Point4d(0, 2, -1 ,-Math.sqrt(2)/2);

		// 2�i�ڂS�i�����P�j
		p[4] = new Point4d(-2, 1, 0 ,-Math.sqrt(2)/2);
		p[5] = new Point4d(0, 1, 2 ,-Math.sqrt(2)/2);
		p[6] = new Point4d(2, 1, 0 ,-Math.sqrt(2)/2);
		p[7] = new Point4d(0, 1, -2 ,-Math.sqrt(2)/2);

		// ���i(����0)
		p[8] = new Point4d(-2, 0, -1 ,-Math.sqrt(2)/2);
		p[9] = new Point4d(-2, 0, 1 ,-Math.sqrt(2)/2);
		p[10] = new Point4d(-1, 0, 2 ,-Math.sqrt(2)/2);
		p[11] = new Point4d(1, 0, 2 ,-Math.sqrt(2)/2);
		p[12] = new Point4d(2, 0, 1 ,-Math.sqrt(2)/2);
		p[13] = new Point4d(2, 0, -1 ,-Math.sqrt(2)/2);
		p[14] = new Point4d(1, 0, -2 ,-Math.sqrt(2)/2);
		p[15] = new Point4d(-1, 0, -2 ,-Math.sqrt(2)/2);

		// 4�i��4�i����-�P�j
		p[16] = new Point4d(-2, -1, 0 ,-Math.sqrt(2)/2);
		p[17] = new Point4d(0, -1, 2 ,-Math.sqrt(2)/2);
		p[18] = new Point4d(2, -1, 0 ,-Math.sqrt(2)/2);
		p[19] = new Point4d(0, -1, -2, -Math.sqrt(2)/2);

		// ��ʂS(����-�Q)
		p[20] = new Point4d(-1, -2, 0 ,-Math.sqrt(2)/2);
		p[21] = new Point4d(0, -2, 1 ,-Math.sqrt(2)/2);
		p[22] = new Point4d(1, -2, 0 ,-Math.sqrt(2)/2);
		p[23] = new Point4d(0, -2, -1 ,-Math.sqrt(2)/2);
		
		p[24] = new Point4d(-1, 2, 0 ,Math.sqrt(2)/2);
		p[25] = new Point4d(0, 2, 1 ,Math.sqrt(2)/2);
		p[26] = new Point4d(1, 2, 0 ,Math.sqrt(2)/2);
		p[27] = new Point4d(0, 2, -1 ,Math.sqrt(2)/2);

		// 2�i�ڂS�i�����P�j
		p[28] = new Point4d(-2, 1, 0 ,Math.sqrt(2)/2);
		p[29] = new Point4d(0, 1, 2 ,Math.sqrt(2)/2);
		p[30] = new Point4d(2, 1, 0 ,Math.sqrt(2)/2);
		p[31] = new Point4d(0, 1, -2 ,Math.sqrt(2)/2);

		// ���i(����0)
		p[32] = new Point4d(-2, 0, -1 ,Math.sqrt(2)/2);
		p[33] = new Point4d(-2, 0, 1 ,Math.sqrt(2)/2);
		p[34] = new Point4d(-1, 0, 2 ,Math.sqrt(2)/2);
		p[35] = new Point4d(1, 0, 2 ,Math.sqrt(2)/2);
		p[36] = new Point4d(2, 0, 1 ,Math.sqrt(2)/2);
		p[37] = new Point4d(2, 0, -1 ,Math.sqrt(2)/2);
		p[38] = new Point4d(1, 0, -2 ,Math.sqrt(2)/2);
		p[39] = new Point4d(-1, 0, -2 ,Math.sqrt(2)/2);

		// 4�i��4�i����-�P�j
		p[40] = new Point4d(-2, -1, 0 ,Math.sqrt(2)/2);
		p[41] = new Point4d(0, -1, 2 ,Math.sqrt(2)/2);
		p[42] = new Point4d(2, -1, 0 ,Math.sqrt(2)/2);
		p[43] = new Point4d(0, -1, -2, Math.sqrt(2)/2);

		// ��ʂS(����-�Q)
		p[44] = new Point4d(-1, -2, 0 ,Math.sqrt(2)/2);
		p[45] = new Point4d(0, -2, 1 ,Math.sqrt(2)/2);
		p[46] = new Point4d(1, -2, 0 ,Math.sqrt(2)/2);
		p[47] = new Point4d(0, -2, -1 ,Math.sqrt(2)/2);
		
		for(int i=0;i<p.length;i++) {
			v[i] = new Vertex4d(p[i]);
			v[i].getPoint4d().setScale(60);
		}

	}

}
