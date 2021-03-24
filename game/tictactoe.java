
package com.mycompany.game;
import java.util.*;
public class tictactoe {
    
    static ArrayList<Integer>user1positions;
    static ArrayList<Integer>user2positions;
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        do{
            user1positions=new ArrayList<>();
            user2positions=new ArrayList<>();
            startgamettt();
            System.out.println("Do you want to play again? [Y/N]");
            String playagain=sc.next();
            if(playagain.equals("N"))
                    {
                        break;
                    }
        }while(true);
            
     }
    public static void startgamettt()
    {    
        Scanner s=new Scanner(System.in);
        char[][] board={{' ','|',' ','|',' '},
                        {'-','|','-','|','-'},
                        {' ','|',' ','|',' '},
                        {'-','|','-','|','-'},
                        {' ','|',' ','|',' '}};
        
        char[][] firstboard={{'T','|','T','|','T'},
                             {'-','|','-','|','-'},
                             {'I','|','A','|','O'},
                             {'-','|','-','|','-'},
                             {'C','|','C','|','E'}};
        printboard(firstboard);
                          
        System.out.println("Enter name of player 1");
        String user1=s.next();
         System.out.println(user1+": Choose (X/O)");
         String symbol1=s.next();
        System.out.println("Enter name of player 2");
        String user2=s.next();
        String symbol2;
         if(symbol1.equals("X"))
         symbol2="O";
         else
         symbol2="X"; 
         System.out.println("("+user1+" is "+symbol1+")");
         System.out.println("("+user2+" is "+symbol2+")");
         
        while(true){
            
            System.out.println(user1+": Where do you want to place "+symbol1+"? Enter position [0-9]");
            int user1pos=s.nextInt();
            while(!validpos(user1pos))
            {
                System.out.println("Position taken by "+user1+", try another");
                user1pos=s.nextInt();
            }
            placepiece(board,user1pos,"player1",symbol1);
            printboard(board);
            String res=checkwin(user1);
            if(res.length()>0)
            {
                
                System.out.println(res);
                break;
            }
            
            System.out.println(user2+":Where do you want to place "+symbol2+"? Enter position [0-9]");
            int user2pos=s.nextInt();
            while(!validpos(user2pos))
            {
                System.out.println("Position taken by "+user1+", try another");
                user2pos=s.nextInt();
            }
            placepiece(board,user2pos,"player2",symbol2);
            printboard(board);
            res=checkwin(user2);
            if(res.length()>0)
            {
                
                System.out.println(res);
                break;
            }
        }
    }
    public static void printboard(char[][] board)
    {
        for(char[] row:board)
        {
            for(char c:row)
            {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static boolean validpos(int pos)
    {
        return !(user1positions.contains(pos)||user2positions.contains(pos));            
    }
    public static void placepiece(char[][] board,int pos,String user,String pieceval)
    {
        char piece=' ';
        if(user.equals("player1"))
        {
            piece=pieceval.charAt(0);
            user1positions.add(pos);
            
            
        }
        else if(user.equals("player2"))
        {
            piece=pieceval.charAt(0);
            user2positions.add(pos);
            
        }
        switch(pos)
        {
            case 1:
                board[0][0]=piece;
                break;
            case 2:
                board[0][2]=piece;
                break;
            case 3:
                board[0][4]=piece;
                break;
            case 4:
                board[2][0]=piece;
                break;
            case 5:
                board[2][2]=piece;
                break;
            case 6:
                board[2][4]=piece;
                break;
            case 7:
                board[4][0]=piece;
                break;
            case 8:
                board[4][2]=piece;
                break;   
            case 9:
                board[4][4]=piece;
                break; 
            default:
                System.out.println("Enter position[0-9]");
                break;
        }
        
    }
    
    public static String checkwin(String name)
    {
        List<Integer>row1=Arrays.asList(1,2,3);
        List<Integer>row2=Arrays.asList(4,5,6);
        List<Integer>row3=Arrays.asList(7,8,9);
        List<Integer>col1=Arrays.asList(1,4,7);
        List<Integer>col2=Arrays.asList(2,5,8);
        List<Integer>col3=Arrays.asList(3,6,9);
        List<Integer>diag1=Arrays.asList(1,5,9);
        List<Integer>diag2=Arrays.asList(3,5,7);
        
         HashSet <List> wins=new HashSet <>();
        wins.add(row1);
        wins.add(row2);
        wins.add(row3);
        wins.add(col1);
        wins.add(col2);
        wins.add(col3);
        wins.add(diag1);
        wins.add(diag2);
        
        String res="";
        for(List l:wins)
        {
            if(user1positions.containsAll(l))
            {
                return "Congratulations "+name+", You won!!";
            }
            else  if(user2positions.containsAll(l))
            {
                return "Congratulations "+name+", You won!!";
            }
            else if(user1positions.size()+user2positions.size()==9)
                res="TIE";

        }
        return res;
    }
}
