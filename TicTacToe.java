import java.util.*;
import java.lang.*;
class TicTacToe1
{
    static HashSet<Integer> player1_set=new HashSet<Integer>();
    static HashSet<Integer> player2_set=new HashSet<Integer>();
    
    public static void main(String args[])
    {
       
        char[][]g_board={
            {' ','|',' ','|',' '},
            {'-','|','-','|','-'},
            {' ','|',' ','|',' '},
            {'-','|','-','|','-'},
            {' ','|',' ','|',' '}
        };
        print_board(g_board);
        Scanner s=new Scanner(System.in);
        System.out.println("Enter player1's name: ");
        String s1=s.nextLine();
        System.out.println("Enter player2's name: ");
        String s2=s.nextLine();
        
        while(true)
        {
            System.out.println(s1+ "'s turn");
            System.out.print("Enter values between 1 and 9: ");   //User enter a value
            int player1_pos=s.nextInt();
            while(player1_set.contains(player1_pos)||player2_set.contains(player1_pos))  //if player1 set or player2 set is filled then
            { 
                System.out.println("The position is already filled.Try Again!!!");
                System.out.print("Enter values between 1 and 9: ");
                player1_pos=s.nextInt();     
            }
            p_holder(g_board,player1_pos,"player1");
           //checking winner
            String res=check_winner();
            if(res.length()>0)
            {
                System.out.println(res);
                break;
            }

            System.out.println(s2+ "'s turn");
            System.out.print("Enter values between 1 and 9: ");   //User enter a value
            int player2_pos=s.nextInt();
            
            while(player1_set.contains(player2_pos)||player2_set.contains(player2_pos))  //if player1 set or player2 set is filled then
            {
                
                System.out.println("The position is already filled.Try Again!!!");
                System.out.print("Enter values between 1 and 9: ");
                player2_pos=s.nextInt();
            }
            place_holder(g_board,player2_pos,"player2");
           //checking winner
            res=check_winner();
            if(res.length()>0)
            {
                System.out.println(res);
                break;
            }
        }

    }

    static String check_winner()
    {
       
        HashSet<Integer> r1=new HashSet<Integer>();
        r1.add(1);r1.add(2);r1.add(3);
        HashSet<Integer> r2=new HashSet<Integer>();
        r2.add(4);r2.add(4);r2.add(6);
        HashSet<Integer> r3=new HashSet<Integer>();
        r3.add(7);r3.add(8);r3.add(9);
        HashSet<Integer> c1=new HashSet<Integer>();
        c1.add(1);c1.add(4);c1.add(7);
        HashSet<Integer> c2=new HashSet<Integer>();
        c2.add(2);c2.add(5);c2.add(8);
        HashSet<Integer> c3=new HashSet<Integer>();
        c3.add(3);c3.add(6);c3.add(9);
        HashSet<Integer> d1=new HashSet<Integer>();
        d1.add(1);d1.add(5);d1.add(9);
        HashSet<Integer> d2=new HashSet<Integer>();
        d2.add(3);d2.add(5);d2.add(7);

        HashSet<HashSet> set= new HashSet<HashSet>();
        set.add(r1);set.add(r2);set.add(r3);
        set.add(c1);set.add(c2);set.add(c3);
        set.add(d1);set.add(d2);

        for(HashSet c:set)
        {
            if(player1_set.containsAll(c))
                return "Player1 WON";
               
            else if(player2_set.containsAll(c))
                return "Player2 WON";
                
        }
        if(player1_set.size()+player2_set.size()==9)
            return "DRAW";

            return "";
    }

    static void print_board(char[][]g_board) //print the board
    {
        for(int r=0;r<g_board.length;r++)
        {
            for(int c=0;c<g_board[0].length;c++){
                System.out.print(g_board[r][c]);
            }
            System.out.println();
        }
    }
    static void p_holder(char[][]g_board,int pos,String user)
    {
        char syb1='X';
        if(user.equals("player1"))
        {
            syb1='X';
            player1_set.add(pos);
        }
            switch(pos)
            {
                case 1:
                g_board[0][0]=syb1;
                break;
                case 2:
                g_board[0][2]=syb1;
                break;
                case 3:
                g_board[0][4]=syb1;
                break;
                case 4:
                g_board[2][0]=syb1;
                break;
                case 5:
                g_board[2][2]=syb1;
                break;
                case 6:
                g_board[2][4]=syb1;
                break;
                case 7:
                g_board[4][0]=syb1;
                break;
                case 8:
                g_board[4][2]=syb1;
                break;
                case 9:
                g_board[4][4]=syb1;
                break;

                default:
                System.out.println("Invalid input");
            }
            
        print_board(g_board);
    }
    static void place_holder(char[][]g_board,int pos,String user)
    {
        char syb2='O';
        if(user.equals("player2"))
        {
            syb2='O';
            player2_set.add(pos);
        }
        switch(pos)
        {
                case 1:
                g_board[0][0]=syb2;
                break;
                case 2:
                g_board[0][2]=syb2;
                break;
                case 3:
                g_board[0][4]=syb2;
                break;
                case 4:
                g_board[2][0]=syb2;
                break;
                case 5:
                g_board[2][2]=syb2;
                break;
                case 6:
                g_board[2][4]=syb2;
                break;
                case 7:
                g_board[4][0]=syb2;
                break;
                case 8:
                g_board[4][2]=syb2;
                break;
                case 9:
                g_board[4][4]=syb2;
                break;

                default:
                System.out.println("Invalid input");
        }
        print_board(g_board);
    }
}
