import java.util.*;

class Labyrinth{
    private Cell[][] labyrinth;
    private ArrayList<Cell> searchCells;//metopo anazhthshs
    private ArrayList<Cell> closedSet; //kleisto synolo
    private int N;

    private Cell S;
    private Cell G1;
    private Cell G2;

    public Labyrinth(int N, double p){
        labyrinth = new Cell[N][N];
        Random random = new Random();
        this.N = N;
        for(int x = 0; x < N; x++){
            for(int y = 0; y < N; y++){
                double d = random.nextDouble();
                boolean blocked = false;
                if(d < p){
                    blocked = true;
                }
                else{
                    blocked = false;
                }
                labyrinth[x][y] = new Cell(x, y, N, blocked);
            }
        }
        searchCells = new ArrayList<Cell>();
        closedSet = new ArrayList<Cell>();
    }

    public void ucs(){
        searchCells.add(S);
        while(searchCells.size() > 0){
            Cell next = searchCells.remove(0);
            System.out.println(searchCells.size());
            boolean found = false;
            //elegxw ean einai sto kleisto
            for(int i = 0; i < closedSet.size(); i++){
                Cell c = closedSet.get(i);
                if(c.equals(next)){
                    found = true;
                    break;
                }
            }
            //ean den thn vrhka sto kleisto kanw ta ypoloipa
            //alliws epilegw epomeno
            if(found == false){
                if(next.equals(G1) || next.equals(G2)){
                    System.out.println("Solution found");
                    //path();
                    print();
                    return;
                }
                else{
                    int x = next.getX();
                    int y = next.getY();

                    Cell c = new Cell(x-1, y-1);
                    if(isValid(c)== true){
                        insertInSearchCells(c);
                        c.setG(next.getG() + 1);
                    }

                    c = new Cell(x, y-1);
                    if(isValid(c)== true){
                        insertInSearchCells(c);
                        c.setG(next.getG() + 1);
                    }

                    c = new Cell(x+1, y-1);
                    if(isValid(c)== true){
                        insertInSearchCells(c);
                        c.setG(next.getG() + 1);
                    }
                    c = new Cell(x-1, y);
                    if(isValid(c)== true){
                        insertInSearchCells(c);
                        c.setG(next.getG() + 1);
                    }

                    c = new Cell(x+1, y);
                    if(isValid(c)== true){
                        insertInSearchCells(c);
                        c.setG(next.getG() + 1);
                    }

                    c = new Cell(x-1, y+1);
                    if(isValid(c)== true){
                        insertInSearchCells(c);
                        c.setG(next.getG() + 1);
                    }

                    c = new Cell(x, y+1);
                    if(isValid(c)== true){
                        insertInSearchCells(c);
                        c.setG(next.getG() + 1);
                    }

                    c = new Cell(x+1, y+1);
                    if(isValid(c)== true){
                        insertInSearchCells(c);
                        c.setG(next.getG() + 1);
                    }
                    closedSet.add(next);
                }
            }
        }
    }

    public void print(){
        for(int x = 0; x < N; x++){
            for(int y = 0; y < N; y++){
                if(labyrinth[x][y].isBlocked()){
                    System.out.print("@ ");
                }
                else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public boolean isValid(Cell c){
        int x = c.getX();
        int y = c.getY();

        if(x>=0 && x<N && y>=0 && y<N && labyrinth[x][y].isBlocked() == false){
            return true;
        }
        else{
            return false;
        }
    }

    public void insertInSearchCells(Cell c){
        int pos = 0;
        for(int i = 0; i < searchCells.size(); i++){
            Cell cell = searchCells.get(i);
            if(cell.getG() > c.getG()){
                break;
            }
            pos = i+1;
        }

        searchCells.add(pos, c);
    }

    public void setCells(Cell S, Cell G1, Cell G2){
        this.S = S;
        this.G1 = G1;
        this.G2 = G2;
    }
}
