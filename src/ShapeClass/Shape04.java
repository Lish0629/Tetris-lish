package ShapeClass;

public class Shape04 extends Shape0 {
    int[][] temp0={
            {0,1,1},
            {0,1,0},
            {0,1,0}
    };
    int[][] temp1={
            {0,0,0},
            {1,1,1},
            {0,0,1}
    };
    int[][] temp2={
            {0,1,0},
            {0,1,0},
            {1,1,0}
    };
    int[][] temp3={
            {1,0,0},
            {1,1,1},
            {0,0,0}
    };

    public Shape04() {
        setPlace(temp0);
        setState(0);
        setBordnum(temp0.length);
        setLoc(new int[]{0,3});
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
