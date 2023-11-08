import stanford.karel.*;

public class BlankKarel extends SuperKarel {
    public int steps = 0;

    public void run() {
        countRowsAndCols();
        System.out.println(steps);
    }

    public void countRowsAndCols() {
        steps = 0;
        int col = 1;
        int row = 1;
        while (frontIsClear()) {
            move();
            steps++;
            col++;
        }
        turnAround();
        while (frontIsClear()) {
            move();
            steps++;
        }
        turnRight();
        if (col % 2 == 0) {
            while (frontIsClear()) {
                row++;
                putBeeper();
                move();
                steps++;
            }
            putBeeper();
            turnAround();
            while (frontIsClear()) {
                move();
                steps++;
            }
            turnLeft();
        }
        else {
            while (frontIsClear()) {
                row++;
                move();
                steps++;
            }
            turnAround();
            while (frontIsClear()) {
                move();
                steps++;
            }
            turnLeft();
        }
        if (row % 2 == 0) {
            if(col % 2!=0) {
                putBeeper();
            }
            while (frontIsClear()) {
                move();
                steps++;
                putBeeper();
            }
            turnAround();
            while (frontIsClear()) {
                move();
                steps++;
            }
            turnAround();
        }
        createCol(col, row);

    }
    public void createCol(int col, int row) {
        int c = (int)Math.ceil(col / 2.0);
        if(col%2==0) c++;
        for(int i=1;i<c;i++) {
            move();
            steps++;
        }
        if(row%2!=0)putBeeper();
        turnLeft();
        while (frontIsClear()) {
            move();
            steps++;
            putBeeper();
        }
        turnAround();
        if(col%2==0)c-=1;
        if(col%2==0)col-=1;
        if(row%2==0)row-=1;
        if(row>=7 && col>=7) {
            createSquare(c, col, row);
        }
        else {
            move();
            steps++;
            System.out.println("The map is too small!");
        }
        createRow(row);
    }

    public void createSquare(int c, int col, int row) {
        move();
        steps++;
        turnLeft();
        for(int i= c; i<=col-2;i++) {
            move();
            steps++;
            if(!beepersPresent())putBeeper();
        }
        turnRight();
        for(int i= 2; i<row-1;i++) {
            move();
            steps++;
            if(!beepersPresent())putBeeper();
        }
        turnRight();
        for(int i= col-1; i>2;i--) {
            move();
            steps++;
            if(!beepersPresent())putBeeper();
        }
        turnRight();
        for(int i= 2; i<row-1;i++) {
            move();
            steps++;
            if(!beepersPresent())putBeeper();
        }
        turnRight();
        for(int i= 2; i<c-1;i++) {
            move();
            steps++;
            if(!beepersPresent())putBeeper();
        }
        move();
        steps++;
        turnRight();
    }

    public void createRow(int row) {
        int c = row / 2;
        for(int i=2;i<=c;i++) {
            move();
            steps++;
        }
        turnLeft();
        while (frontIsClear()) {
            move();
            steps++;
            if(!beepersPresent())putBeeper();
        }
        turnAround();
        while (frontIsClear()) {
            move();
            steps++;
            if(!beepersPresent())putBeeper();
        }
    }
}
