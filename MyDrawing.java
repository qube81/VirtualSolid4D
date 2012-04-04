import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;


public class MyDrawing {
	
	Graphics2D g;
	MyPolytope p;
	
	int plane;//0=xy,1=xz,2=xu,3=yz,4=yu,5=zu
	
	
	MyDrawing(Graphics2D g , MyPolytope p, int plane){
		this.g = g;
		this.p = p;
		this.plane = plane;
	}
	
	public void draw() {
			g.setColor(Color.white);
			g.fillRect(0, 0, MyCanvas.CANVAS_WIDTH, MyCanvas.CANVAS_HEIGHT);
			
			//drawCellXY(p.c[0]);
			
			for(Vertex4d vertex : p.v) {
				drawVertex(vertex);
			}
			
			
			for(Edge4d edge : p.e) {
				drawEdge(edge);
			}
			/*
			for(Face4d face : p.f) {
				drawFace(face);
			}
			*/
			
			//drawFaceXY(p.f[0]);
			
			
	}
	
	public void drawVertex(Vertex4d v) {
		g.setColor(v.getColor());
		double first ,second;
		switch (plane) {
			case 0:
				first = v.getPoint4d().getX()-v.getSize()/2+MyCanvas.CANVAS_WIDTH/2;
				second =v.getPoint4d().getY()-v.getSize()/2+MyCanvas.CANVAS_HEIGHT/2;
				break;
			case 1:
				first = v.getPoint4d().getX()-v.getSize()/2+MyCanvas.CANVAS_WIDTH/2;
				second = v.getPoint4d().getZ()-v.getSize()/2+MyCanvas.CANVAS_HEIGHT/2;
				break;
			case 2:
				first = v.getPoint4d().getX()-v.getSize()/2+MyCanvas.CANVAS_WIDTH/2;
				second = v.getPoint4d().getU()-v.getSize()/2+MyCanvas.CANVAS_HEIGHT/2;
				break;
			case 3:
				first = v.getPoint4d().getY()-v.getSize()/2+MyCanvas.CANVAS_WIDTH/2;
				second = v.getPoint4d().getZ()-v.getSize()/2+MyCanvas.CANVAS_HEIGHT/2;
				break;
			case 4:
				first = v.getPoint4d().getY()-v.getSize()/2+MyCanvas.CANVAS_WIDTH/2;
				second = v.getPoint4d().getU()-v.getSize()/2+MyCanvas.CANVAS_HEIGHT/2;
				break;
			case 5:
				first = v.getPoint4d().getZ()-v.getSize()/2+MyCanvas.CANVAS_WIDTH/2;
				second = v.getPoint4d().getU()-v.getSize()/2+MyCanvas.CANVAS_HEIGHT/2;
				break;
			default:
				first=0;
				second=0;
				System.out.println("error");
		}
		g.fill(new Ellipse2D.Double(first,second,v.getSize(),v.getSize()));
	}
	
	public void drawEdge(Edge4d e) {
		
		g.setPaint(e.getColor());
		g.setPaint(e.getGradient());
		g.setStroke(e.getBasicStroke());

		switch (plane) {
			case 0:
				g.draw(
					new Line2D.Double(
						e.getVertex4d(0).getPoint4d().getX()+MyCanvas.CANVAS_WIDTH/2,
						e.getVertex4d(0).getPoint4d().getY()+MyCanvas.CANVAS_HEIGHT/2,
						e.getVertex4d(1).getPoint4d().getX()+MyCanvas.CANVAS_WIDTH/2,
						e.getVertex4d(1).getPoint4d().getY()+MyCanvas.CANVAS_HEIGHT/2
					)
				);
				break;
			case 1:
				g.draw(
					new Line2D.Double(
						e.getVertex4d(0).getPoint4d().getX()+MyCanvas.CANVAS_WIDTH/2,
						e.getVertex4d(0).getPoint4d().getZ()+MyCanvas.CANVAS_HEIGHT/2,
						e.getVertex4d(1).getPoint4d().getX()+MyCanvas.CANVAS_WIDTH/2,
						e.getVertex4d(1).getPoint4d().getZ()+MyCanvas.CANVAS_HEIGHT/2
					)
				);
				break;
			case 2:
				g.draw(
					new Line2D.Double(
						e.getVertex4d(0).getPoint4d().getX()+MyCanvas.CANVAS_WIDTH/2,
						e.getVertex4d(0).getPoint4d().getU()+MyCanvas.CANVAS_HEIGHT/2,
						e.getVertex4d(1).getPoint4d().getX()+MyCanvas.CANVAS_WIDTH/2,
						e.getVertex4d(1).getPoint4d().getU()+MyCanvas.CANVAS_HEIGHT/2
					)
				);
				break;
			case 3:
				g.draw(
					new Line2D.Double(
						e.getVertex4d(0).getPoint4d().getY()+MyCanvas.CANVAS_WIDTH/2,
						e.getVertex4d(0).getPoint4d().getZ()+MyCanvas.CANVAS_HEIGHT/2,
						e.getVertex4d(1).getPoint4d().getY()+MyCanvas.CANVAS_WIDTH/2,
						e.getVertex4d(1).getPoint4d().getZ()+MyCanvas.CANVAS_HEIGHT/2
					)
				);
				break;
			case 4:
				g.draw(
					new Line2D.Double(
						e.getVertex4d(0).getPoint4d().getY()+MyCanvas.CANVAS_WIDTH/2,
						e.getVertex4d(0).getPoint4d().getU()+MyCanvas.CANVAS_HEIGHT/2,
						e.getVertex4d(1).getPoint4d().getY()+MyCanvas.CANVAS_WIDTH/2,
						e.getVertex4d(1).getPoint4d().getU()+MyCanvas.CANVAS_HEIGHT/2
					)
				);
				break;
			case 5:
				g.draw(
					new Line2D.Double(
						e.getVertex4d(0).getPoint4d().getZ()+MyCanvas.CANVAS_WIDTH/2,
						e.getVertex4d(0).getPoint4d().getU()+MyCanvas.CANVAS_HEIGHT/2,
						e.getVertex4d(1).getPoint4d().getZ()+MyCanvas.CANVAS_WIDTH/2,
						e.getVertex4d(1).getPoint4d().getU()+MyCanvas.CANVAS_HEIGHT/2
					)
				);
				break;
			default :
				System.out.println("error");
		}
		
	}
	
	public void drawFace(Face4d f) {
		
		g.setColor(f.getColor());
		int[] firstPoints = new int[f.getVertexNum()];
		int[] secondPoints = new int[f.getVertexNum()];
		
		switch(plane) {
			case 0:
				for(int i=0;i<f.getVertexNum();i++) {
					firstPoints[i] = f.getVertex4d(i).getPoint4d().getIntX()+MyCanvas.CANVAS_WIDTH/2;
					secondPoints[i] = f.getVertex4d(i).getPoint4d().getIntY()+MyCanvas.CANVAS_HEIGHT/2;
				}
				break;
			case 1:
				for(int i=0;i<f.getVertexNum();i++) {
					firstPoints[i] = f.getVertex4d(i).getPoint4d().getIntX()+MyCanvas.CANVAS_WIDTH/2;
					secondPoints[i] = f.getVertex4d(i).getPoint4d().getIntZ()+MyCanvas.CANVAS_HEIGHT/2;
				}
				break;
			case 2:
				for(int i=0;i<f.getVertexNum();i++) {
					firstPoints[i] = f.getVertex4d(i).getPoint4d().getIntX()+MyCanvas.CANVAS_WIDTH/2;
					secondPoints[i] = f.getVertex4d(i).getPoint4d().getIntU()+MyCanvas.CANVAS_HEIGHT/2;
				}
				break;
			case 3:
				for(int i=0;i<f.getVertexNum();i++) {
					firstPoints[i] = f.getVertex4d(i).getPoint4d().getIntY()+MyCanvas.CANVAS_WIDTH/2;
					secondPoints[i] = f.getVertex4d(i).getPoint4d().getIntZ()+MyCanvas.CANVAS_HEIGHT/2;
				}
				break;
			case 4:
				for(int i=0;i<f.getVertexNum();i++) {
					firstPoints[i] = f.getVertex4d(i).getPoint4d().getIntY()+MyCanvas.CANVAS_WIDTH/2;
					secondPoints[i] = f.getVertex4d(i).getPoint4d().getIntU()+MyCanvas.CANVAS_HEIGHT/2;
				}
				break;
			case 5:
				for(int i=0;i<f.getVertexNum();i++) {
					firstPoints[i] = f.getVertex4d(i).getPoint4d().getIntZ()+MyCanvas.CANVAS_WIDTH/2;
					secondPoints[i] = f.getVertex4d(i).getPoint4d().getIntU()+MyCanvas.CANVAS_HEIGHT/2;
				}
				break;
			
		}
		Polygon polygon = new Polygon(firstPoints, secondPoints, f.getVertexNum());
		g.fill(polygon);
	}
	
	public void drawCellXY(Cell4d c) {
		g.setColor(c.getColor());
		for(int i=0; i<c.getFaceNum();i++) {
			drawFace(c.getFace4d(i));
		}
	}

}
