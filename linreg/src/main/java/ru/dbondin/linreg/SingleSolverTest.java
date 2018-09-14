package ru.dbondin.linreg;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ru.dbondin.linreg.Solver.SolveResult;

public class SingleSolverTest extends JFrame {

	private static final double DEFAULT_R2_MIN = 0.95;

	private static final String ICON_RESOURCE_PATH = "/ru/dbondin/linreg/images/icon.png";

	private static final double INTERSECT_EPSILON = 0.00001;

	private static final long serialVersionUID = 3622959977100983304L;

	private static final int SIZE = 480;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SingleSolverTest mf = new SingleSolverTest();
				mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				mf.setVisible(true);
			}
		});
	}

	private JPanel buttonsPanel;

	private JButton clearButton;

	private JFileChooser fileChooser = new JFileChooser();

	private GraphPanel graphPane;

	private JButton loadButton;

	private final SortedSet<Point> points = new TreeSet<Point>(new Comparator<Point>() {
		public int compare(Point o1, Point o2) {
			return (int) Math.signum(o1.x - o2.x);
		}
	});

	private JSpinner r2MinSpinner;

	private SpinnerNumberModel r2MinSpinnerModel = new SpinnerNumberModel(DEFAULT_R2_MIN, 0.0, 1.0, 0.01);

	private JButton saveButton;

	private final Solver solver = new Solver();

	public SingleSolverTest() {
		initGui();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	}

	private void initButtonsPanel() {
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridBagLayout());
		buttonsPanel.setBorder(BorderFactory.createTitledBorder("buttons"));

		clearButton = new JButton("clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCleanButton();
			}
		});

		buttonsPanel.add(clearButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(4, 4, 4, 4), 0, 0));

		r2MinSpinner = new JSpinner(r2MinSpinnerModel);
		r2MinSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				recalculate();
			}
		});

		buttonsPanel.add(new JLabel("<html>min R<sup>2</sup></html>"), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(4, 4, 4, 4), 0, 0));

		buttonsPanel.add(r2MinSpinner, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(4, 4, 4, 4), 0, 0));

		saveButton = new JButton("save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onSaveButtonClicked();
			}
		});
		buttonsPanel.add(saveButton, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(4, 4, 4, 4), 0, 0));

		loadButton = new JButton("load");
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onLoadButtonClicked();
			}
		});
		buttonsPanel.add(loadButton, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(4, 4, 4, 4), 0, 0));

		buttonsPanel.add(new JPanel(), new GridBagConstraints(0, 4, 2, 1, 0.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(4, 4, 4, 4), 0, 0));
	}

	private void initGui() {

		setIconImage(new ImageIcon(getClass().getResource(ICON_RESOURCE_PATH)).getImage());

		setTitle("linreg | single solver test");
		setLayout(new GridBagLayout());

		graphPane = new GraphPanel();
		graphPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON1) {
					onGraphPaneLeftSingleClick(e.getX(), e.getY());
				}
			}
		});

		JScrollPane graphPaneScroll = new JScrollPane(graphPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		graphPaneScroll.setBorder(BorderFactory.createTitledBorder("graph"));
		add(graphPaneScroll, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(4, 4, 4, 4), 0, 0));

		initButtonsPanel();
		add(buttonsPanel, new GridBagConstraints(1, 0, 1, 1, 0.0, 1.0, GridBagConstraints.WEST,
				GridBagConstraints.VERTICAL, new Insets(4, 4, 4, 4), 0, 0));

		pack();
	}

	private void onCleanButton() {
		points.clear();
		graphPane.setData(points, null, null);
	}

	private void onGraphPaneLeftSingleClick(int x, int y) {
		System.out.println("x=" + x + " y=" + y);
		points.add(new Point(((double) x / SIZE), 1.0 - ((double) y / SIZE)));
		recalculate();
	}

	private static final DecimalFormat DFMT = new DecimalFormat("########.########", DecimalFormatSymbols.getInstance(Locale.US));
	
	private void onLoadButtonClicked() {
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File f = fileChooser.getSelectedFile();
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(f);
				loadPoints(fis);
			} catch (Throwable t) {
				JOptionPane.showMessageDialog(this, t);
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (Throwable t) {
						JOptionPane.showMessageDialog(this, t);
					}
				}
			}
		}
	}

	private void onSaveButtonClicked() {
		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File f = fileChooser.getSelectedFile();
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(f);
				savePoints(fos);
			} catch (Throwable t) {
				JOptionPane.showMessageDialog(this, t);
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (Throwable t) {
						JOptionPane.showMessageDialog(this, t);
					}
				}
			}
		}
	}

	private void savePoints(final OutputStream os) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(os);
			for (Point p : points) {
				pw.println(String.format("%s %s", DFMT.format(p.x), DFMT.format(p.y)));
			}

		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

	private void loadPoints(final InputStream is) {
		Scanner s = null;
		try {
			s = new Scanner(is);
			s.useLocale(Locale.US);
			List<Point> pl = new ArrayList<Point>();
			while (s.hasNext()) {
				Point p = new Point(s.nextDouble(), s.nextDouble());
				pl.add(p);
			}
			points.clear();
			points.addAll(pl);
			recalculate();
		} catch (Throwable t) {
			JOptionPane.showMessageDialog(this, t);
		} finally {
			if (s != null) {
				s.close();
			}
		}
		s.close();
	}

	private void recalculate() {
		System.out.println("recalculate");
		SolveResult sr = solver.solve(points, r2MinSpinnerModel.getNumber().doubleValue(), INTERSECT_EPSILON);
		graphPane.setData(points, sr.lines, sr.iPoints);
	}
}
