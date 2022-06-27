import java.util.*;
class Askisi1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give N: ");
        int N = scanner.nextInt();
        System.out.print("Give p: ");
        double p = scanner.nextDouble();

        Labyrinth labyrinth = new Labyrinth(N,p);
        labyrinth.print();
        Cell S = null;

        do{

            System.out.print("Give Sx: ");
            int x = scanner.nextInt();

            System.out.print("Give Sy: ");
            int y = scanner.nextInt();

            S = new Cell(x, y);
        }while(labyrinth.isValid(S) == false);

        Cell G1 = null;

        do{

            System.out.print("Give G1x: ");
            int x = scanner.nextInt();

            System.out.print("Give G1y: ");
            int y = scanner.nextInt();

            G1 = new Cell(x, y);
        }while(labyrinth.isValid(G1) == false);

        Cell G2 = null;

        do{

            System.out.print("Give G2x: ");
            int x = scanner.nextInt();

            System.out.print("Give G2y: ");
            int y = scanner.nextInt();

            G2 = new Cell(x, y);
        }while(labyrinth.isValid(G2) == false || G1.equals(G2));

        labyrinth.setCells(S, G1, G2);
        labyrinth.ucs();
    }
}
