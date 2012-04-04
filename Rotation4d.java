//âÒì]èÓïÒ
public class Rotation4d {

	public static void RotateXY(Point4d p, double angle) {
		double r = Math.toRadians(angle);
		double tmpX = p.getX()*Math.cos(r)-p.getY()*Math.sin(r);
		double tmpY = p.getX()*Math.sin(r)+p.getY()*Math.cos(r);
		p.setX(tmpX);
		p.setY(tmpY);
	}
	
	public static void RotateXZ(Point4d p,double angle) {
		double r = Math.toRadians(angle);
		double tmpX = p.getX()*Math.cos(r)-p.getZ()*Math.sin(r);
		double tmpZ = p.getX()*Math.sin(r)+p.getZ()*Math.cos(r);
		p.setX(tmpX);
		p.setZ(tmpZ);	
	}
	public static void RotateXU(Point4d p,double angle) {
		double r = Math.toRadians(angle);
		double tmpX = p.getX()*Math.cos(r)-p.getU()*Math.sin(r);
		double tmpU = p.getX()*Math.sin(r)+p.getU()*Math.cos(r);
		p.setX(tmpX);
		p.setU(tmpU);	
		
	}
	public static void RotateYZ(Point4d p,double angle) {
		double r = Math.toRadians(angle);
		double tmpY = p.getY()*Math.cos(r)-p.getZ()*Math.sin(r);
		double tmpZ = p.getY()*Math.sin(r)+p.getZ()*Math.cos(r);
		p.setY(tmpY);
		p.setZ(tmpZ);
	}
	
	public static void RotateYU(Point4d p,double angle) {
		double r = Math.toRadians(angle);
		double tmpY = p.getY()*Math.cos(r)-p.getU()*Math.sin(r);
		double tmpU = p.getY()*Math.sin(r)+p.getU()*Math.cos(r);
		p.setY(tmpY) ;
		p.setU(tmpU);

	}
	public static void RotateZU(Point4d p,double angle) {
		double r = Math.toRadians(angle);
		double tmpZ= p.getZ()*Math.cos(r)-p.getU()*Math.sin(r);
		double tmpU = p.getZ()*Math.sin(r)+p.getU()*Math.cos(r);
		p.setZ(tmpZ);
		p.setU(tmpU) ;

	}
}
