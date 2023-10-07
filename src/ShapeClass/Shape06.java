package ShapeClass;

public class Shape06 extends Shape0 {
    int[][] temp0={
            {0,0,0,0},
            {0,0,0,0},
            {1,1,1,1},
            {0,0,0,0}
    };
    int[][] temp1={
            {0,1,0,0},
            {0,1,0,0},
            {0,1,0,0},
            {0,1,0,0}
    };

    public Shape06() {
        setPlace(temp0);
        setState(0);
        setBordnum(temp0.length);
        setLoc(new int[]{0,2});
    }

    @Override
    public void Spin() {
        switch (getState()){
            case 0 -> {
                setPlace(temp1);
                setState(1);
            }
            case 1-> {
                setPlace(temp0);
                setState(0);
            }
        }
    }

}

