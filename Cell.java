class Cell{
    private int x;
    private int y;
    private int N;
    private boolean blocked;
    private int g;

    public Cell(int x, int y, int N, boolean blocked){
        this.x = x;
        this.y = y;
        this.N = N;
        this.blocked = blocked;
        this.g = 0;
    }

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isBlocked(){
        return blocked;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean equals(Cell other){
        if(x == other.x && y == other.y){
            return true;
        }
        else{
            return false;
        }
    }
    public int getG(){
        return g;
    }

    public void setG(int g){
        this.g = g;
    }
}
