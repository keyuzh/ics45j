package labs.lab3;

/**
 * Represents a table of values.
 */
public class Table {

	private int[][] values;
	private int nRows, nCols;

	/**
	 * Constructs a table with given rows and columns.
	 *
	 * @param rows    the rows in the table (assume always > 0)
	 * @param columns the columns in the table (assume always > 0)
	 */
	public Table(int rows, int columns) {
		values = new int[rows][columns];
		nRows = rows;
		nCols = columns;
	}


	/**
	 * Sets a value in the table.
	 * 
	 * @param i the row of the item to modify (assume always within the bounds of the table)
	 * @param j the column of the item to modify (assume always within the bounds of the table)
	 * @param n the number to use for the new value.
	 */
	public void set(int i, int j, int n) {
		values[i][j] = n;
	}


	/**
	 * Computes and returns the average of the adjacent neighbors of the given
	 * table element in all eight surrounding directions. 
	 * 
	 * If the element is located at the boundary of the table, include only 
	 * the neighbors that are in the table. For example if row and column are 
	 * both 0, there are only three neighbors.
	 * 
	 * If the given element has no neighbors, return 0.
	 * 
	 * If no element with the given row & column exists in this table, return 0.
	 * 
	 * @param row    the row of the element
	 * @param column the column of the element
	 * @return the average of the adjacent elements
	 */
	public double neighborAverage(int row, int column) {
//		if (row < 0 || row >= nRows || column < 0 || column >= nCols) { return 0.0; }
		double sum = 0.0;
		int count = 0;
		for (int i = row-1; i <= row+1; i++) {
			for (int j = column-1; j <= column+1; j++) {
				if ((i == row && j == column)
                        || (i < 0 || i >= nRows || j < 0 || j >= nCols)) {
					continue;
				}
				sum += values[i][j];
				count++;
			}
		}
		return (count == 0) ? 0.0 : (sum / count);
	}


	/**
	 * Returns the sum of a row or column in elements in the table
	 * 
	 * @param i          	the row or column to sum. Assume it will always 
	 * 						be within the bounds of the table
	 * @param horizontal 	if true, then i represents a row, else a column.
	 * @return the sum of the given row or column.
	 */
	public double sum(int i, boolean horizontal) {
		double s = 0.0;
		if (horizontal) {
			for (int j = 0; j < nCols; j++) {
                s += values[i][j];
			}
		}
		else {
			for (int j = 0; j < nRows; j++) {
				s += values[j][i];
			}
		}
		return s;
	}
}
