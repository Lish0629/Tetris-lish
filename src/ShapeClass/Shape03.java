package ShapeClass;

public class Shape03 extends Shape0 {
    int[][] temp0={
            {1,1},
            {1,1}
    };

    public Shape03() {
        setPlace(temp0);
        setState(0);
        setBordnum(temp0.length);
        setLoc(new int[]{0,4});
    }

    @Override
    public void Spin() {

    }
}
