package miniproject;

import java.util.Random;
import java.util.Scanner;

class TicTacToe{
	 static char[][] board;
	
	
	public TicTacToe(){
		board=new char [3][3];
		initBoard();
	}
	
	void initBoard()
	{
		for (int i = 0; i < board.length; i++) 
		{
			for (int j = 0; j < board[i].length; j++) 
			{
				board[i][j]=' ';
				
			}
			
		}
		
	}
	
	
	 static void displayboard()
	 {
		 	System.out.println("-------------");
			for (int i = 0; i < board.length; i++) 
			{
				System.out.print("| ");
				for (int j = 0; j < board[i].length; j++) 
				{
					System.out.print(board[i][j]+" | ");
				}
				System.out.println();
			 	System.out.println("-------------");
				
			}
	 }





 static void placemark(int row,int col,char mark)
{
	if (row>=0&&row<=2&& col>=0&&col<=2){
		board[row][col]=mark;
	}
	else{
		System.out.println("invalid position");
	}
	
}

 static boolean checkcolwin(){
	for (int j = 0; j <=2; j++) 
	{
		if(board[0][j]!=' ' &&      board[0][j]==board[1][j]&&board[1][j]==board[2][j])
		{
			return true;
		}
			
		
	}
	return false;
	
}

static boolean checkrowwin(){
	for (int i = 0; i <=2; i++)
	{
		if(board[i][0]!=' '&&        board[i][0]==board[i][1]&&board[i][1]==board[i][2])
		{
			return true;
		}
		
	}
	return false; 
}

 static boolean checkdiaonalwin(){
	if(board[0][0]!=' '&&       board[0][0]==board[1][1]&&board[1][1]==board[2][2]||  board[0][2]!=' '&&        board[0][2]==board[1][1]&&board[1][1]==board[2][0])
	{
		return true;
	}
	else
	{
		return false;
	}

	
}

 
 static boolean checkDraw(){
	 for (int i = 0; i <=2; i++) 
	 {
		 for (int j = 0; j <=2; j++) 
		 {
			 if(board[i][j]==' '){
				 return false;
			 }
			
		}
		
	}
	 return true;
 }
}


 abstract class Player
{
	String name;
	char mark;
	
	abstract void makemove();
	
	 boolean isvalidmove(int row,int col)
	 {
		 if(row>=0&&row<=2 &&col>=0&&col<=2)
		 {
			 if(TicTacToe.board[row][col]==' ')
			 {
				 return true;
			 }
		 }
		 return false;
		 
	 }
}

class HumanPlayer extends Player{
	
	
	HumanPlayer(String name,char mark)
	{
		this.name=name;
		this.mark=mark;
	}
	void makemove(){
		int row;
		int col;
		Scanner sc= new Scanner(System.in);
		do {
			System.out.println("enter the row and column");
			  row=sc.nextInt();
			  col=sc.nextInt();
		} while (!isvalidmove(row,col));
		TicTacToe.placemark(row, col, mark);
		
		
	}
	 
	
	
	
}





class AIPlayer extends Player{
	
	
	AIPlayer(String name,char mark)
	{
		this.name=name;
		this.mark=mark;
	}
	void makemove(){
		int row;
		int col;
		Scanner sc= new Scanner(System.in);
		do {
		Random r =new Random();
		 row=r.nextInt(3);
		 col=r.nextInt(3);
		} while (!isvalidmove(row,col));
		TicTacToe.placemark(row, col, mark);
		
		
	}
	 
	
	
	
}

public class LaunchGame
{
	 public static void main(String[] args) {
	TicTacToe t=new TicTacToe();
		 HumanPlayer h1= new HumanPlayer("bob",'X');
		 AIPlayer h2= new AIPlayer("ai", 'O');
		 Player cp;
		 cp=h1;
		 while(true){
			 System.out.println(cp.name+"turn");
			 cp.makemove();
			 TicTacToe.displayboard();
			 if(TicTacToe.checkcolwin()||TicTacToe.checkrowwin()||TicTacToe.checkdiaonalwin()){
				 System.out.println(cp.name + "has won");
				 break;
			 }
			 
			 
			 else if(TicTacToe.checkDraw())
			 {
				 System.out.println("game is draw");
				 break;
			 }
			 else{
				 if (cp==h1)
				 {
					 cp=h2; 
				 }
				 else{
					 cp=h1;
				 }
			 }
			 
		 }
		 
		
		 
		 
		 
	}

}
