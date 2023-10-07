package ShapeClass;

public class Shape05 extends Shape0 {
    int[][] temp0={
            {1,1,0},
            {0,1,0},
            {0,1,0}
    };
    int[][] temp1={
            {0,0,1},
            {1,1,1},
            {0,0,0}
    };
    int[][] temp2={
            {0,1,0},
            {0,1,0},
            {0,1,1}
    };
    int[][] temp3={
            {0,0,0},
            {1,1,1},
            {1,0,0}
    };

    public Shape05() {
        setPlace(temp0);
        setState(0);
        setBordnum(temp0.length);
        setLoc(new int[]{0,4});
    }

    @Override
    public void Spin() {
        switch (getState()){
            case 0 -> {
                setPlace(temp1);
                setState(1);
            }
            case 1-> {
                setPlace(temp2);
                setState(2);
            }
            case 2-> {
                setPlace(temp3);
                setState(3);
            }
            case 3-> {
                setPlace(temp0);
                setState(0);
            }
        }
    }
}

