package ru.dbondin.linreg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JPanel;

public class GraphPanel extends JPanel {

	private static final double INTERSECT_EPSILON = 0.00001;

	private static final double R2_MIN = 0.95;

	private static final long serialVersionUID = 4598862799122336435L;
	private static final int SIZE = 480;

	private final List<Point> iPoints = new ArrayList<Point>();
	private final List<Line> lines = new ArrayList<Line>();
	private final List<Point> points = new ArrayList<Point>();

	public GraphPanel() {
		final Dimension dim = new Dimension(SIZE, SIZE);
		setSize(dim);
		setMinimumSize(dim);
		setMaximumSize(dim);
		setPreferredSize(dim);

		setOpaque(true);
	}

	public void setData(final Collection<Point> points, final Collection<Line> lines, final Collection<Point> iPoints) {
		this.points.clear();
		if (points != null) {
			this.points.addAll(points);
		}
		this.lines.clear();
		if (lines != null) {
			this.lines.addAll(lines);
		}
		this.iPoints.clear();
		if (iPoints != null) {
			this.iPoints.addAll(iPoints);
		}
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, SIZE, SIZE);

		paintCoords(g);

		for (final Point p : iPoints) {
			int x = (int) (p.x * SIZE);
			int y = SIZE - (int) (p.y * SIZE);
			paintIPoint(g, x, y);
		}

		for (int i = 1; i < iPoints.size(); ++i) {
			Point left = iPoints.get(i - 1);
			Point right = iPoints.get(i);
			Line l = lines.get(i - 1);
			int x0 = (int) (((double) SIZE) * left.x);
			int x1 = (int) (((double) SIZE) * right.x);
			int y0 = SIZE - (int) (((double) SIZE) * l.y(left.x));
			int y1 = SIZE - (int) (((double) SIZE) * l.y(right.x));
			paintLine(g, x0, y0, x1, y1);
		}

		for (final Point p : points) {
			int x = (int) (p.x * SIZE);
			int y = SIZE - (int) (p.y * SIZE);
			paintPoint(g, x, y);
		}
	}

	private void paintCoords(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		for (double x = 0.0; x < 1.0; x += 0.1) {
			g.drawLine(0, (int) ((double) SIZE * x), SIZE, (int) ((double) SIZE * x));
			g.drawLine((int) ((double) SIZE * x), 0, (int) ((double) SIZE * x), SIZE);
		}
		g.setFont(Font.decode("sans-PLAIN-8"));
		g.drawString("0:0", 8, SIZE - 8);
		g.drawString("1", SIZE - 8, SIZE - 8);
		g.drawString("1", 8, 8);
	}

	private void paintIPoint(final Graphics g, final int x, final int y) {
		if (x < SIZE && x >= 0 && y < SIZE && y >= 0) {
			g.setColor(Color.GRAY);
			for (int i = SIZE; i > 0; i -= 20) {
				g.drawLine(x, i, x, i - 10);
			}
			
			//g.setColor(Color.MAGENTA);
			//g.drawLine(x, y - 10, x, y + 10);
			//g.drawLine(x - 3, y - 10, x + 3, y - 10);
			//g.drawLine(x - 3, y + 10, x + 3, y + 10);

		}
	}

	private void paintLine(Graphics g, final int x0, final int y0, final int x1, final int y1) {
		g.setColor(Color.BLUE);
		g.drawLine(x0, y0, x1, y1);
	}

	private void paintPoint(final Graphics g, final int x, final int y) {
		if (x < SIZE && x >= 0 && y < SIZE && y >= 0) {
			g.setColor(Color.RED);
			g.drawLine(x - 3, y, x + 3, y);
			g.drawLine(x, y - 3, x, y + 3);
		}
	}
}
