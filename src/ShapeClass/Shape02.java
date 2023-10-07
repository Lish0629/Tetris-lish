package ShapeClass;

import java.util.Random;

public class Shape02 extends Shape0 {

    int[][] temp0={
            {0,1,0},
            {0,1,1},
            {0,1,0}
    };
    int[][] temp1={
            {0,0,0},
            {1,1,1},
            {0,1,0}
    };
    int[][] temp2={
            {0,1,0},
            {1,1,0},
            {0,1,0}
    };
    int[][] temp3={
            {0,1,0},
            {1,1,1},
            {0,0,0}
    };
    public Shape02() {
        boolean x=new Random().nextBoolean();
        setBordnum(temp0.length);
        if(x){
            setPlace(temp0);
            setState(0);
            setLoc(new int[]{0,3});
        }else {
            setPlace(temp2);
            setState(2);
            setLoc(new int[]{0,4});
        }

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
    public static void main(String[] args) {
        Shape02 s=new Shape02();
        for(int i=0;i<s.getPlace().length;i++){
            for (int j=0;j<s.getPlace()[i].length;j++){
                System.out.print("("+s.getPlace()[i][j]+")");
            }
            System.out.println();
        }
        s.Spin();
        s.Spin();


        System.out.println();
        for(int i=0;i<s.getPlace().length;i++){
            for (int j=0;j<s.getPlace()[i].length;j++){
                System.out.print("("+s.getPlace()[i][j]+")");
            }
            System.out.println();
        }
    }
}
