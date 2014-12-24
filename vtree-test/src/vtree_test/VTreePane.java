package vtree_test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VTreePane extends Component {

	private static class Dot {
		public double x;
		public double y;
		public double r;

		public Dot(double x, double y, double r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}

	private static class Line {
		public double x1;
		public double x2;
		public double y1;
		public double y2;

		public Line(double x1, double y1, double x2, double y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}

	private static class Pnt {
		public double x;
		public double y;

		public Pnt(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	private Point mouseDragStartPoint = new Point(0, 0);

	private Point mouseDragOffset = new Point(0, 0);

	private static final double SCALE_MIN = 0.2;

	private static final double SCALE_MAX = 20.0;

	private static final double SCALE_FACTOR = 0.1;

	private double scale = 1.0;

	private static final int STAR_LINES_MIN = 8;

	private static final int STAR_LINES_MAX = 16;

	private static final int DEPTH = 5;

	private static final double STAR_ANGLE_DG = 300;

	private static final double STAR_ANGLE_RD = Math.PI * 2.0
			* ((double) STAR_ANGLE_DG) / 360.0;

	private boolean isDataInitialized = false;

	private List<Line> lines = new LinkedList<Line>();
	private List<Dot> dots = new LinkedList<Dot>();

	public VTreePane() {
		initGui();
	}

	private void calculateDot(Pnt position, double size) {
		dots.add(new Dot(position.x, position.y, size));
	}

	private double normalizeAngle(double angle) {

		final double PI2 = Math.PI * 2.0;

		while (angle > PI2) {
			angle -= PI2;
		}

		while (angle < -PI2) {
			angle += PI2;
		}

		return angle;
	}

	private void calculateOneStar(Pnt position, double size, double direction,
			int depth, boolean isRoot) {

		if (depth > 0) {

			direction = normalizeAngle(direction);

			int starLines = STAR_LINES_MIN;

			if (!isRoot) {
				starLines += (int) ((double) (STAR_LINES_MAX - STAR_LINES_MIN) * Math
						.random());
			}

			List<Pnt> pl = new ArrayList<Pnt>();
			List<Double> al = new ArrayList<Double>();

			double startAngle;
			double sector;

			if (isRoot) {
				sector = (2 * Math.PI) / ((double) starLines);
				startAngle = -sector / 2.0;
			} else {
				sector = STAR_ANGLE_RD / ((double) starLines - 1);
				startAngle = (2 * Math.PI - STAR_ANGLE_RD) / 2.0;
			}

			for (int i = 0; i < starLines; i++) {
				double angle = normalizeAngle(direction + Math.PI + startAngle
						+ sector * i);
				Pnt end = new Pnt(position.x + size * Math.cos(angle),
						position.y + size * Math.sin(angle));

				lines.add(new Line(position.x, position.y, end.x, end.y));

				pl.add(end);
				al.add(angle);
			}

			calculateDot(position, size / 5);

			Pnt p1 = pl.get(0);
			Pnt p2 = pl.get(1);

			double newSize = Math.sqrt((p1.x - p2.x) * (p1.x - p2.x)
					+ (p1.y - p2.y) * (p1.y - p2.y)) / 2.75;

			for (int i = 0; i < pl.size(); i++) {
				calculateOneStar(pl.get(i), newSize, al.get(i), depth - 1,
						false);
			}
		}
	}

	private void initGui() {
		setBackground(Color.BLACK);
		requestFocus();

		addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				onMouseWheelMoved(e);
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				onMouseDragged(e);
			}
		});

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onMouseClicked(e);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				onMousePressed(e);
			}
		});
	}

	private void initializeData() {
		if (!isDataInitialized) {
			calculateOneStar(new Pnt(0, 0), 200.0, 0.0, DEPTH, true);
			isDataInitialized = true;
		}
	}

	private void onMouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {

			Dimension size = getSize();

			mouseDragOffset.x += size.width / 2 - e.getPoint().x;
			mouseDragOffset.y += size.height / 2 - e.getPoint().y;
			repaint();
		}
	}

	private void onMouseDragged(MouseEvent e) {
		mouseDragOffset.x = e.getX() - mouseDragStartPoint.x;
		mouseDragOffset.y = e.getY() - mouseDragStartPoint.y;
		repaint();
	}

	private void onMousePressed(MouseEvent e) {
		mouseDragStartPoint.x = -mouseDragOffset.x + e.getPoint().x;
		mouseDragStartPoint.y = -mouseDragOffset.y + e.getPoint().y;
	}

	private void onMouseWheelMoved(MouseWheelEvent e) {
		updateScale(e.getWheelRotation() * SCALE_FACTOR);
		repaint();
	}

	@Override
	public void paint(Graphics g) {

		initializeData();

		Dimension size = getSize();

		Image buffer = new BufferedImage(size.width, size.height,
				BufferedImage.TYPE_INT_RGB);

		Graphics bg = buffer.getGraphics();

//		if (bg instanceof Graphics2D) {
//			Graphics2D g2d = (Graphics2D) bg;
//			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//					RenderingHints.VALUE_ANTIALIAS_ON);
//		}

		Point center = new Point(size.width / 2 + mouseDragOffset.x,
				size.height / 2 + mouseDragOffset.y);

		/* Background */
		bg.setColor(getBackground());
		bg.fillRect(0, 0, size.width, size.height);

		/* Lines */
		bg.setColor(Color.WHITE);
		for (Line l : lines) {
			bg.drawLine((int) (center.x + l.x1 * scale), (int) (center.y + l.y1
					* scale), (int) (center.x + l.x2 * scale),
					(int) (center.y + l.y2 * scale));
		}

		/* Dots */
		bg.setColor(Color.YELLOW);
		for (Dot d : dots) {
			bg.fillOval((int) (center.x + (d.x - d.r / 2.0) * scale),
					(int) (center.y + (d.y - d.r / 2.0) * scale),
					(int) (d.r * scale), (int) (d.r * scale));
		}

		/* Legend */
		bg.setColor(Color.GREEN);
		int height = g.getFontMetrics().getHeight() + 4;
		int ypos = height;
		bg.drawString("SCALE: " + scale, 4, ypos);
		ypos += height;
		bg.drawString("OFFSET:" + mouseDragOffset.x + " " + mouseDragOffset.y,
				4, ypos);
		ypos += height;
		bg.drawString("PTS:" + dots.size(), 4, ypos);

		g.drawImage(buffer, 0, 0, null);
	}

	private void updateScale(double delta) {

		scale += delta;

		if (scale > SCALE_MAX) {
			scale = SCALE_MAX;
		} else if (scale < SCALE_MIN) {
			scale = SCALE_MIN;
		}
	}

	public void reset() {
		scale = 1.0;
		mouseDragOffset.x = 0;
		mouseDragOffset.y = 0;
		repaint();
	}
}
