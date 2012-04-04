//080803 4次元のPointクラス


class Point4d {

	//フィールド
	private double x;
	private double y;
	private double z;
	private double u;

	//コンストラクタ
	//引数なし（原点）
	public Point4d(){
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
		this.u = 0.0;
	}
	//指定点で初期化
	public Point4d(double x, double y, double z, double u){
		this.x = x;
		this.y = y;
		this.z = z;
		this.u = u;
	}

	//Point4dで指定
	public Point4d(Point4d p){
		this.x = p.x;
		this.y = p.y;
		this.z = p.z;
		this.u = p.u;
	}

	//メソッド
	public String toString() {
		return "("+this.x+","+this.y+","+this.z+","+this.u+")";
	}

	public double distance(double px, double py, double pz, double pu) {
		double distX = Math.pow(this.x - px ,2);
		double distY = Math.pow(this.y - py ,2);
		double distZ = Math.pow(this.z - pz ,2);
		double distU = Math.pow(this.u - pu ,2);

		return Math.sqrt(distX + distY + distZ + distU);
	}

	public double distance(Point4d p) {
		double distX = Math.pow(this.x - p.x ,2);
		double distY = Math.pow(this.y - p.y ,2);
		double distZ = Math.pow(this.z - p.z ,2);
		double distU = Math.pow(this.u - p.u ,2);

		return Math.sqrt(distX + distY + distZ + distU);
	}

	//get系
	public double getX() {return this.x;}
	public double getY() {return this.y;}
	public double getZ() {return this.z;}
	public double getU() {return this.u;}

	public int getIntX(){return (int)Math.round(this.x);}
	public int getIntY(){return (int)Math.round(this.y);}
	public int getIntZ(){return (int)Math.round(this.z);}
	public int getIntU(){return (int)Math.round(this.u);}

	//set系
	//指定点へ移動
	public void setLocation(double x, double y, double z, double u) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.u = u;
	}

	//各軸に沿って移動
	public  void translate(double dx, double dy ,double dz, double du)	{
		this.x += dx;
		this.y += dy;
		this.z += dz;
		this.u += du;
	}

	//スケーリング
	public void setScale(int s) {
		this.x *= s;
		this.y *= s;
		this.z *= s;
		this.u *= s;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public void setU(double u) {
		this.u = u;
	}

	public boolean equal(Point4d p) {
		if(this.x == p.getX() && this.y == p.getY() && this.z == p.getZ() && this.u == p.getU() ) {
			return true;
		}
		else
			return false;		
	}
}
