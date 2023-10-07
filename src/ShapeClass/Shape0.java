package ShapeClass;

public abstract class Shape0 {
    private int[][] place;
    private int state;
    private int bordnum;
    private int[] loc={0,4};
    public Shape0() {
    }


    public int getBordnum() {
        return bordnum;
    }

    public void setBordnum(int bordnum) {
        this.bordnum = bordnum;
    }

    public int[]getLoc() {
        return loc;
    }

    public void setLoc(int[] loc) {
        this.loc = loc;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    public int[][] getPlace() {
        return place;
    }

    public void setPlace(int[][] place) {
        this.place = place;
    }

    public void Spin(){

    }

    @Override
    public String toString() {
        /*for(int i=0;i<this.getPlace().length;i++){
            for (int j=0;j<this.getPlace()[i].length;j++){
                System.out.print("("+this.getPlace()[i][j]+")");
            }
            System.out.println();
        }*/
        return "Shape0{}";
    }
}
