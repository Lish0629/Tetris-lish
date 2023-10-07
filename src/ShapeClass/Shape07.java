package ShapeClass;

public class Shape07 extends Shape0 {
    int[][] temp0={
            {1,0,0},
            {1,1,0},
            {0,1,0}
    };
    int[][] temp1={
            {0,0,0},
            {0,1,1},
            {1,1,0}
    };
    public Shape07() {
        setPlace(temp0);
        setState(0);
        setBordnum(temp0.length);
        setLoc(new int[]{0,4});
    }
    @Override
    public void Spin() {
        if(getState()==0){
            setPlace(temp1);
            setState(1);
        } else if (getState()==1) {
            setPlace(temp0);
            setState(0);
        }
    }
    public static void main(String[] args) {
        Shape07 s=new Shape07();
        for(int i=0;i<s.getPlace().length;i++){
            for (int j=0;j<s.getPlace()[i].length;j++){
                System.out.print("("+s.getPlace()[i][j]+")");
            }
            System.out.println();
        }
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
