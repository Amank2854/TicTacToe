import java.util.*;

class GameBoard 
{
    char[][] board = new char[3][3];
    public void printBoard()
    {
        System.out.println();
        for(int i = 0 ;i<3;i++)
        System.out.println(board[i][0]+" | "+board[i][1]+" | "+board[i][2]);
        System.out.println();
    }

    public boolean insert(int row, int col , char val)
    {
        if(row<1 || row>3 || col<1 || col>3)
        return false;
        if(board[row-1][col-1]==' ')
        {
            board[row-1][col-1]=val;
            return true;
        }
        return false;
    }

    public boolean insertByBot(int row, int col,char val)
    {
        for(int i = 0 ;i<3;i++)
        {
            if((board[i][0]==board[i][1] && board[i][0]==val && board[i][2]==' '))
            {
                board[i][2]= val;
                return true;
            }
            if((board[i][2]==board[i][1] && board[i][1]==val && board[i][0]==' '))
            {
                board[i][0]= val;
                return true;
            }
            if((board[i][2]==board[i][0] && board[i][2]==val && board[i][1]==' '))
            {
                board[i][1]= val;
                return true;
            }


            if((board[0][i]==board[1][i] && board[0][i]==val && board[2][i]==' '))
            {
                board[2][i]= val;
                return true;
            }
            if((board[2][i]==board[1][i] && board[1][i]==val && board[0][i]==' '))
            {
                board[0][i]= val;
                return true;
            }
            if((board[2][i]==board[0][i] && board[0][i]==val && board[1][i]==' '))
            {
                board[1][i]= val;
                return true;
            }
        }
        
        if((board[0][0]==board[1][1] && board[0][0]==val && board[2][2]==' '))
        {
            board[2][2]= val;
            return true;
        }
        if((board[2][2]==board[1][1] && board[1][1]==val && board[0][0]==' '))
        {
            board[0][0]= val;
            return true;
        }
        if((board[2][2]==board[0][0] && board[0][0]==val && board[1][1]==' '))
        {
            board[1][1]= val;
            return true;
        }

        if((board[0][2]==board[1][1] && board[0][2]==val && board[2][0]==' '))
        {
            board[2][0]= val;
            return true;
        }
        if((board[2][0]==board[1][1] && board[1][1]==val && board[0][2]==' '))
        {
            board[0][2]= val;
            return true;
        }
        if((board[2][0]==board[0][2] && board[0][2]==val && board[1][1]==' '))
        {
            board[1][1]= val;
            return true;
        }
        
        for(int i = 0 ;i<3;i++)
        {
            if((board[i][0]==board[i][1] && board[i][0]=='X' && board[i][2]==' '))
            {
                board[i][2]= val;
                return true;
            }
            if((board[i][2]==board[i][1] && board[i][1]=='X' && board[i][0]==' '))
            {
                board[i][0]= val;
                return true;
            }
            if((board[i][2]==board[i][0] && board[i][2]=='X' && board[i][1]==' '))
            {
                board[i][1]= val;
                return true;
            }


            if((board[0][i]==board[1][i] && board[0][i]=='X' && board[2][i]==' '))
            {
                board[2][i]= val;
                return true;
            }
            if((board[2][i]==board[1][i] && board[1][i]=='X' && board[0][i]==' '))
            {
                board[0][i]= val;
                return true;
            }
            if((board[2][i]==board[0][i] && board[0][i]=='X' && board[1][i]==' '))
            {
                board[1][i]= val;
                return true;
            }
        }
        
        if((board[0][0]==board[1][1] && board[0][0]=='X' && board[2][2]==' '))
        {
            board[2][2]= val;
            return true;
        }
        if((board[2][2]==board[1][1] && board[1][1]=='X' && board[0][0]==' '))
        {
            board[0][0]= val;
            return true;
        }
        if((board[2][2]==board[0][0] && board[0][0]=='X' && board[1][1]==' '))
        {
            board[1][1]= val;
            return true;
        }

        if((board[0][2]==board[1][1] && board[0][2]=='X' && board[2][0]==' '))
        {
            board[2][0]= val;
            return true;
        }
        if((board[2][0]==board[1][1] && board[1][1]=='X' && board[0][2]==' '))
        {
            board[0][2]= val;
            return true;
        }
        if((board[2][0]==board[0][2] && board[0][2]=='X' && board[1][1]==' '))
        {
            board[1][1]= val;
            return true;
        }

        board[row][col] = val;
        return true;
    }
}

class GameCheck
{
    public boolean Check(char[][] board, int row, int col)
    {
        boolean f = false;
        row--;
        col--;
        if(board[row][col]==board[(row+1)%3][col] && board[row][col]==board[(row+2)%3][col])
        f = true;
        if(board[row][col]==board[row][(col+1)%3] && board[row][col]==board[row][(col+2)%3])
        f = true;
        if(row==col)
        {
            if(board[row][col]==board[(row+1)%3][(col+1)%3] && board[row][col]==board[(row+2)%3][(col+2)%3])
            f = true;
            if(board[row][col]==board[(row-1+3)%3][(col-1+3)%3] && board[row][col]==board[(row-2+3)%3][(col-2+3)%3])
            f = true;
        }
        return f;
    }
    char val = 'O';
    public boolean CheckBot(char[][] board, int row, int col)
    {
        boolean f = false;
        row--;
        col--;
        for(int i = 0 ;i<3;i++)
        {
            if(board[i][0]==board[i][1] && board[i][0]==board[i][2] && board[i][0]==val)
            {
                f = true;
            }
            
            if(board[0][i]==board[1][i] && board[0][i]==board[2][i] && board[0][i]==val)
            {
                f=true;
            }
        }
        
        if((board[0][0]==board[1][1] && board[0][0]==board[2][2] && board[0][0]==val))
        {
            f = true;
        }

        if((board[2][0]==board[1][1] && board[2][0]==board[0][2] && board[2][0]==val))
        {
            f = true;
        }
        return f;
    }
    
    public boolean Draw(char[][] board, int row, int col)
    {
        boolean f = false;
        for(int i = 0 ;i<3;i++)
        {
            for(int j = 0 ;j<3;j++)
            {
                if(board[i][j]==' ')
                {
                    f = true;
                    break;
                }
            }
            if(f)
            break;
        }
        return !f;
    }
}

public class TicTacToe 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        GameBoard Game = new GameBoard();
        GameCheck CheckWin = new GameCheck();
        System.out.println("Welcome! Please Choose Row and Column Between 1 and 3.");
        System.out.println("Player 1 is X and Player 2/BOT is O");
        System.out.println();
        int Choice = 0;
        System.out.println("Please Enter 1 For Player Vs Player or 2 for Player Vs BOT");
        Choice = sc.nextInt();
        for(int i = 0;i<3;i++)
        {
            for(int j = 0 ;j<3; j++)
            Game.board[i][j]=' ';
        }
        
        int row = -1 , col = -1;
        while(Game.insert(row, col, 'X')!=true)
        {
            System.out.println("Please Enter Row");
            row = sc.nextInt();
            System.out.println("Please Enter Column");
            col = sc.nextInt();
        }
        Game.printBoard();
        if(Choice == 1)
        {
            int c = 0;
            while(CheckWin.Check(Game.board, row, col)!=true && CheckWin.Draw(Game.board, row, col)!=true)
            {
                c++;
                while(Game.insert(row, col,c%2==0 ? 'X':'O')!=true)
                {
                    System.out.println("Please Enter Row");
                    row = sc.nextInt();
                    System.out.println("Please Enter Column");
                    col = sc.nextInt();
                }
                Game.printBoard();
                if(CheckWin.Check(Game.board, row, col)==true)
                {
                    System.out.println("Player "+(c%2+1)+" wins");
                    break;
                }
                if(CheckWin.Draw(Game.board, row, col)==true)
                {
                    System.out.println("Tie");
                    break;
                }
            }
        }
        else if(Choice == 2)
        {
            while(CheckWin.Check(Game.board, row, col)!=true && CheckWin.Draw(Game.board, row, col)!=true)
            {
                Random rand = new Random();
                int row1 = rand.nextInt(3);
                int col1 = rand.nextInt(3);
                while(Game.board[row1][col1]!=' ')
                {
                    row1 = rand.nextInt(3);
                    col1 = rand.nextInt(3);
                }
                Game.insertByBot(row1,col1,'O');
                Game.printBoard();
                if(CheckWin.CheckBot(Game.board, row1+1, col1+1)==true)
                {
                    System.out.println("BOT wins");
                    break;
                }
                if(CheckWin.Draw(Game.board, row1+1, col1+1)==true)
                {
                    System.out.println("Tie");
                    break;
                }
                while(Game.insert(row, col, 'X')!=true)
                {
                    System.out.println("Please Enter Row");
                    row = sc.nextInt();
                    System.out.println("Please Enter Column");
                    col = sc.nextInt();
                }
                Game.printBoard();
                if(CheckWin.Check(Game.board, row, col)==true)
                {
                    System.out.println("Player wins");
                    break;
                }
                if(CheckWin.Draw(Game.board, row, col)==true)
                {
                    System.out.println("Tie");
                    break;
                }
            }
        }
        else
        System.out.println("Wrong Choice");
    }
}
