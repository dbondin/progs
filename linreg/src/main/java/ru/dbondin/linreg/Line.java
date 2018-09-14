package ru.dbondin.linreg;

import ru.dbondin.linreg.Point;

/**
 * y = intercept + slope * x
 * 
 * @author dbondin
 *
 */
public class Line {

	public double intercept;
	public double slope;

	public Line(final double intercept, final double slope) {
		this.intercept = intercept;
		this.slope = slope;
	}

	/**
	 * Find intersection point (with specified accuracy)
	 * 
	 * @param l2
	 * @param epsilon
	 * @return
	 */
	public Point intersect(final Line l2, final double epsilon) {
		final double numerator = l2.intercept - this.intercept;
		final double denominator = this.slope - l2.slope;
		if (Math.abs(denominator) <= epsilon) {
			return null;
		}
		final double vx = numerator / denominator;
		final double vy = y(vx);
		return new Point(vx, vy);
	}

	public double y(final double x) {
		return intercept + (x * slope);
	}
}