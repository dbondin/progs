package ru.dbondin.linreg;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

import org.apache.commons.math3.stat.regression.SimpleRegression;

public class Solver {

	public static class SolveResult {
		public List<Point> iPoints;
		public List<Line> lines;

		public SolveResult(final List<Line> lines, final List<Point> iPoints) {
			this.lines = lines;
			this.iPoints = iPoints;
		}
	}

	public SolveResult solve(final SortedSet<Point> points, final double r2Min, final double intersectEpsilon) {

		final List<Line> lines = new ArrayList<Line>();
		final List<Point> iPoints = new ArrayList<Point>();

		Line line = null;
		Point previousPoint = null;
		SimpleRegression sreg = new SimpleRegression();
		for (final Point p : points) {
			sreg.addData(p.x, p.y);
			final double r = sreg.getR();
			final double r2 = r * r;
			System.out.println("r2 = " + r2);
			if (!Double.isNaN(r2)) {
				if (r2 < r2Min) {
					sreg.clear();
					if (previousPoint != null) {
						sreg.addData(previousPoint.x, previousPoint.y);
					}
					sreg.addData(p.x, p.y);
					if (line != null) {
						lines.add(line);
					}
					line = null;
				}
				line = new Line(sreg.getIntercept(), sreg.getSlope());
			}
			previousPoint = p;
		}
		if (line != null) {
			lines.add(line);
		}
		iPoints.clear();
		if (lines.size() != 0) {
			Point firstIPoint = new Point(points.first().x, lines.get(0).y(points.first().x));
			iPoints.add(firstIPoint);
			for (int i = 0; i < lines.size() - 1; ++i) {
				Line l1 = lines.get(i);
				Line l2 = lines.get(i + 1);
				Point ip = l1.intersect(l2, intersectEpsilon);
				if (ip == null) {
					throw new RuntimeException("Lines not intersect");
				}
				iPoints.add(ip);
			}
			Point lastIPoint = new Point(points.last().x, lines.get(lines.size() - 1).y(points.last().x));
			iPoints.add(lastIPoint);
		}

		return new SolveResult(lines, iPoints);
	}
}
