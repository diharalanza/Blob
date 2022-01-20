package comp1406a5;

public class Blob extends Image {

	// leave this constructor as is. This is the constructor that we will  use
	// when testing your code.
	public Blob(int rows, int cols) {
		super(rows, cols);
	}


	public void computePixelPerimeterHelper(int row, int column) {

		if (getPixel(row, column).hasInk == false) {
			return;
		} else {
			getPixel(row, column).setVisited(true);

			//checks if pixel on left is out of bounds
			if ((column - 1) < this.cols && (column - 1) >= 0) {

				//checks if this pixel is connected to blob
				if (getPixel(row, column - 1).hasInk() == true && getPixel(row, column - 1).visited() == false) {

					//sets the pixel to left as visited
					//getPixel(row, column - 1).setVisited(true);

					computePixelPerimeterHelper(row, column - 1);
				}
				//adds pixel with no ink to sides
				else if (getPixel(row, column - 1).hasInk == false) {

					getPixel(row, column).setSides((getPixel(row, column).getSides()) + 1);
				}

			}

			//checks if pixel on bottom is out of bounds
			if ((row + 1 < this.rows) && (row + 1 >= 0)) {

				//checks if this pixel is connected to blob
				if (getPixel(row + 1, column).hasInk() == true && getPixel(row + 1, column).visited() == false) {

					//sets the pixel on bottom as visited
					//getPixel(row + 1, column).setVisited(true);

					computePixelPerimeterHelper(row + 1, column);


				}
				//adds pixel with no ink to sides
				else if (getPixel(row + 1, column).hasInk == false) {

					getPixel(row, column).setSides((getPixel(row, column).getSides()) + 1);
				}
			}

			//checks if pixel on right is out of bounds
			if (column + 1 < this.cols && column + 1 >= 0) {

				//checks if this pixel is connected to blob
				if (getPixel(row, column + 1).hasInk() == true && getPixel(row, column + 1).visited() == false) {

					//sets the pixel on right as visited
					//getPixel(row, column + 1).setVisited(true);

					computePixelPerimeterHelper(row, column + 1);


				}
				//adds pixel with no ink to sides
				else if (getPixel(row, column + 1).hasInk == false) {

					getPixel(row, column).setSides((getPixel(row, column).getSides()) + 1);
				}
			}

			//checks if pixel on top is out of bounds
			if (row - 1 < this.rows && row - 1 >= 0) {

				//checks if this pixel is connected to blob
				if (getPixel(row - 1, column).hasInk() == true && getPixel(row - 1, column).visited() == false) {

					//sets the pixel on top as visited
					//getPixel(row - 1, column).setVisited(true);

					computePixelPerimeterHelper(row - 1, column);

				}


				//adds pixel with no ink to sides
				else if (getPixel(row - 1, column).hasInk == false) {

					getPixel(row, column).setSides((getPixel(row, column).getSides()) + 1);
				}
			}
		}


	}

	public void computePixelPerimeters(int row, int column) {
		clearImage();
		computePixelPerimeterHelper(row, column);
	}




	public int perimeterhelper(int row, int column){

		if ((row < this.rows) && (row >= 0) && (column < this.cols) && (column >= 0) && getPixel(row, column).hasInk()==true && getPixel(row, column).visited()==true) {
			getPixel(row, column).setVisited(false);





			return getPixel(row, column).getSides() + perimeterhelper(row, column - 1) + perimeterhelper(row + 1, column) + perimeterhelper(row, column + 1) + perimeterhelper(row - 1, column);

		} else {
			return 0;

		}

	}




	public int perimeter(int row, int column) {

		clearImage();
		computePixelPerimeters(row, column);
		return perimeterhelper(row, column);



	}


	public static void main(String[] args) {
		// for testing...
		Blob disblob = new Blob(3, 3);

		boolean t = true;
		boolean f = false;

		disblob.pixels[0][0] = new Pixel(0, 0, f);
		disblob.pixels[0][1] = new Pixel(0, 1, f);
		disblob.pixels[0][2] = new Pixel(0, 2, t);
		disblob.pixels[1][0] = new Pixel(1, 0, f);
		disblob.pixels[1][1] = new Pixel(1, 1, t);
		disblob.pixels[1][2] = new Pixel(1, 2, t);
		disblob.pixels[2][0] = new Pixel(2, 0, f);
		disblob.pixels[2][1] = new Pixel(2, 1, t);
		disblob.pixels[2][2] = new Pixel(2, 2, f);

		System.out.println(disblob);
		disblob.computePixelPerimeters(0, 1);
		System.out.println(disblob.perimeter(1, 1));
		System.out.println(disblob);



	}


}


