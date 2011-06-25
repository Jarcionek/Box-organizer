/**
 * @version 28/02/2011
 * @author Jaroslaw Pawlak
 */
public class Box {
    /**
     * 0 - width, 1 - length, 2 - height
     */
    private final int[] sizes = new int[3];
    private final int weight;

    /**
     * Creates a box with non-negative width, length, height
     */
    public Box(int width, int length, int height, int weight) {
        if (width <=0 || length <= 0 || height <= 0) {
            throw new IllegalArgumentException("Sizes must be positive");
        }
        this.sizes[0] = width;
        this.sizes[1] = length;
        this.sizes[2] = height;
        this.weight = weight;
    }

    public int getWidth() {
        return sizes[0];
    }

    public int getLength() {
        return sizes[1];
    }

    public int getHeight() {
        return sizes[2];
    }

    public int getWeight() {
        return weight;
    }

    /**
     * Returns the array of six boxes with every possible order of width,
     * length and height
     * @return array of six boxes
     */
    private Box[] getTurned() {
        int[] sorted = new int[3];
        sorted[0] = this.sizes[0];
        sorted[1] = this.sizes[1];
        sorted[2] = this.sizes[2];

        int temp;
        if (sorted[0] > sorted[1]) {
            temp = sorted[0];
            sorted[0] = sorted[1];
            sorted[1] = temp;
        }
        if (sorted[1] > sorted[2]) {
            temp = sorted[1];
            sorted[1] = sorted[2];
            sorted[2] = temp;
        }
        if (sorted[0] > sorted[1]) {
            temp = sorted[0];
            sorted[0] = sorted[1];
            sorted[1] = temp;
        }

        Box[] result = new Box[6];
        result[0] = new Box(sorted[0], sorted[1], sorted[2], this.weight);
        result[1] = new Box(sorted[0], sorted[2], sorted[1], this.weight);
        result[2] = new Box(sorted[1], sorted[0], sorted[2], this.weight);
        result[3] = new Box(sorted[1], sorted[2], sorted[0], this.weight);
        result[4] = new Box(sorted[2], sorted[0], sorted[1], this.weight);
        result[5] = new Box(sorted[2], sorted[1], sorted[0], this.weight);

        return result;
    }

    /**
     * Counts how many <code>this</code> boxes can be fit in <code>box</code> box.
     * Checks all six possible arrangements. If sum of weights of <code>this</code>
     * boxes is larger than weight of </code>box</code> returns
     * <code>box.weight / this.weight</code>
     * @param box a box to put <code>this</code> in
     * @return number of boxes that can be put in
     */
    public int countIn(Box box) {
        int result = 0;
        for (Box e : this.getTurned()) {
            int temp = e.noTurnCountIn(box);
            if (temp > result) {
                result = temp;
            }
        }
        if (this.weight > 0) {
            return box.weight / this.weight > result ?
                result : box.weight / this.weight;
        } else {
            return result;
        }
    }

    /**
     * Returns a new box of the same size as <code>this</code>, but with changed
     * order of width, length and height so that <code>box</code> can fit the most
     * <code>this</code> boxes without turning it
     * @param box a box to put </code>this</code> boxes in
     * @return best arrangement of <code>this</code> or null if <code>this</code>
     * cannot be fit in any arrangement
     */
    public Box getBestArrangement(Box box) {
        Box result = null;
        int count = 0;
        for (Box e : this.getTurned()) {
            int temp = e.noTurnCountIn(box);
            if (temp > count) {
                count = temp;
                result = e;
            }
        }
        return result;
    }

    /**
     * Counts how many <code>this</code> boxes can be fit in <code>that</code>
     * box without turning
     * @param that a box to put <code>this</code> in
     * @return number of boxes that can be put in
     */
    private int noTurnCountIn(Box that) {
        return (that.sizes[0] / this.sizes[0])
                * (that.sizes[1] / this.sizes[1])
                * (that.sizes[2] / this.sizes[2]);
    }

    public long getVolume() {
        return 1L * sizes[0] * sizes[1] * sizes[2];
    }
}