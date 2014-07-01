import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import java.awt.event.MouseListener;

import javax.swing.JApplet;
import javax.swing.Timer;

import java.util.ArrayList;
import java.util.Random;

public class Chess extends JApplet {

 int[][] board = new int[8][8];
 private int selectedPiece = -1;
 String previousPos = "1 1";
 int move = -1;
 ArrayList<String> posList= new ArrayList<>();
    //method that is auto called
    public void init() {


     addMouseListener(new MAdapter());

        setSize(800,800);
        
        
        //Initialize board
        initBoard();
        
        for(int j = 0; j < 8; j++) {
         for(int k = 0; k < 8; k++) {
          System.out.print(board[j][k] +", ");
         }
         System.out.println();
        }
        


    }
    
    private void initBoard() {
        //add pawns PAWNS = 1
        for(int i =0; i < 8; i++) {
         board[1][i] = 1;
         board[6][i] = -1;
        }
        
        //Add Knights KNIGHTS = 2;
        board[0][1] = board[0][6] = 2;
        board[7][1] = board[7][6] = -2;
        
        //Add Bishops BISHOPS = 3;
        board[0][2] = board[0][5] = 3;
        board[7][2] = board[7][5] = -3;
        
        //Add Rooks, ROOKS = 4;
        board[0][0] = board[0][7] = 4;
        board[7][0] = board[7][7] = -4;
        
        //Add Queens, QUEENS = 5;
        board[0][4] =5;
        board[7][4] =-5;
        
        //Add Kings, KINGS = 6;
        board[0][3] = 6;
        board[7][3] = -6;
        
        move = 1;
    }

        public void paint(Graphics g) {
        //clear old stuff

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 800);

        g.setColor(Color.BLACK);

        
     
        for(int i =0;i<9;i++) {
            g.drawLine((35*i)+50, 50, (35*i)+50, 330);
            g.drawLine(50, (35*i)+50, 330, (35*i)+50);
        }
        
        for(int j = 0; j < 8; j++) {
        	for(int k = 0; k < 8; k++) {
        		g.setColor(Color.BLACK);
        		if(board[j][k] == 1 || board[j][k] == -1) {
        			g.fillRect(35*k + 55, 35*j+55, 10,10);
        		}
        		
        		if(board[j][k] == 2 || board[j][k] == -2) {
        			g.setColor(Color.RED);
        			g.fillRect(35*k + 55, 35*j+55, 20,20);
        		}
        		
        		if(board[j][k] == 3 || board[j][k] == -3) {
        			g.setColor(Color.BLUE);
        			g.fillRect(35*k + 55, 35*j+55, 20,20);
        		}
        		
        		if(board[j][k] == 4 || board[j][k] == -4 ) {
        			g.setColor(Color.GREEN);
        			g.fillRect(35*k + 55, 35*j+55, 15,15);
        		}
        		
        		if(board[j][k] == 5 || board[j][k] == -5) {
        			g.setColor(Color.GRAY);
        			g.fillOval(35*k + 55, 35*j+55, 15, 15);
        		}
        		
        		if(board[j][k] == 6 || board[j][k] == -6) {
        			g.setColor(Color.YELLOW);
        			g.fillOval(35*k + 55, 35*j+55, 25, 25);
        		}
        		
        	}
        }

        
    }


  private class MAdapter implements MouseListener{


 @Override
 public void mouseClicked(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void mouseEntered(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void mouseExited(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void mousePressed(MouseEvent e) {
  // TODO Auto-generated method stub
  //System.out.println("X position = " +e.getX()  + "\t Y position = " + e.getY());
	 int x = -1;
	  int y = -1;

	  previousPos = "";
	  selectedPiece =-7;
	  
	  boolean bothlegal = false;
	  
	  if(e.getX() > 50 && e.getX() <=85) {
	   bothlegal = true;
	   x=0;
	  }
	  else if(e.getX() > 85 && e.getX() <=120) {
	   bothlegal = true;
	   x=1;
	  }
	  else if(e.getX() > 120 && e.getX() <=155) {
	   bothlegal = true;
	   x=2;
	  }
	  else if(e.getX() > 155 && e.getX() <= 190) {
	   bothlegal = true;
	   x=3;
	  }
	  else if(e.getX() > 190 && e.getX() <= 225) {
	   bothlegal = true;
	   x=4;
	  }
	  else if(e.getX() > 225 && e.getX() <= 260) {
	   bothlegal = true;
	   x=5;
	  }
	  else if(e.getX() > 260 && e.getX() <= 295) {
	   bothlegal = true;
	   x=6;
	  }
	  else if(e.getX() > 295 && e.getX() <= 330) {
	   bothlegal = true;
	   x=7;
	  }
	  else {
	   bothlegal = false;
	  }
	  if(bothlegal) {
	   
	  
	  if(e.getY() > 50 && e.getY() <=85) {
	   bothlegal = true;
	   y=0;
	  }
	  else if(e.getY() > 85 && e.getY() <=120) {
	   bothlegal = true;
	   y=1;
	  }
	  else if(e.getY() > 120 && e.getY() <=155) {
	   bothlegal = true;
	   y=2;
	  }
	  else if(e.getY() > 155 && e.getY() <= 190) {
	   bothlegal = true;
	   y=3;
	  }
	  else if(e.getY() > 190 && e.getY() <= 225) {
	   bothlegal = true;
	   y=4;
	  }
	  else if(e.getY() > 225 && e.getY() <= 260) {
	   bothlegal = true;
	   y=5;
	  }
	  else if(e.getY() > 260 && e.getY() <= 295) {
	   bothlegal = true;
	   y=6;
	  }
	  else if(e.getY() > 295 && e.getY() <= 330) {
	   bothlegal = true;
	   y=7;
	  }
	  else {
	   bothlegal = false;
	  }
	  
  }
  if(bothlegal ){
	  
  previousPos = y + " " + x;
  if(board[y][x] == -1  && move == -1) { 
	  System.out.println("Picked a -Pawn");
	  selectedPiece = -1;
	  
	  if(x-1 >= 0 && y-1 >= 0 && board[y-1][x-1] > 0 && board[y-1][x-1] <= 6 ){
		//  System.out.println((y-1)+" " + (x-1));
		  posList.add((y-1)+ " " + (x-1));
	  }
	  if(y < 7 && x+1 <= 7 && y-1 >=0 && board[y-1][x+1] > 0 && board[y-1][x+1] <=6 ){
		  posList.add((y-1)+ " " + (x+1));
		//  System.out.println((y-1)+" " + (x+1));
		  }
	  if(x >= 0 && y-1 >=0 && board[y-1][x] == 0){
		  posList.add((y-1)+ " " + (x));
		//  System.out.println("FRONT OF: " + (y-1)+" " + x);
		  }
	  
  }
  else if(board[y][x] == 1 && move == 1) {
	  System.out.println("Picked a Pawn");
	  selectedPiece =  1;
	  
	  
	  if(x+1 <= 7 && y+1 <=7 && board[y+1][x+1] < 0 && board[y+1][x+1] >=-6 ){
		  System.out.println(y+" " + x);
		  posList.add((y+1)+ " " + (x+1));
	  }
	  if(y > 0 && x > 0 && y+1 <=7 && board[y+1][x-1] < 0 && board[y+1][x-1] >=-6 ){
		 posList.add((y+1)+ " " + (x-1));
		  System.out.println(y+" " + x);
		  }
	  if(x <= 7 && y <=7 && board[y+1][x] == 0){
		  posList.add((y+1)+ " " + (x));
		  System.out.println("FRONT OF: " + (y+1)+" " + x);
		  }
	  
	  
	  
  }//end +Pawn
  else if(board[y][x] == 2 && move == 1) {
	  System.out.println("Picked a Knight");
	  selectedPiece = 2;
	  
	  //Forward
	  if(y+2 <= 7 && x-1 >=0 && board[y+2][x-1] <=0 && board[y+2][x-1] >= -6) {
		  posList.add((y+2) + " " + (x-1));
	  }
	  
	  if(y+2 <= 7 && x+1 <= 7 && board[y+2][x+1] <=0 && board[y+2][x+1] >= -6) {
		  posList.add((y+2) + " " + (x+1));
	  }
	  
	  //Sides
	  if(x-2 >= 0 && y+1 <= 7 && board[y+1][x-2] <=0 && board[y+1][x-2] >= -6) {
		  posList.add((y+1) + " " + (x-2));
	  }
	  
	  if(x+2 <= 7 && y+1 <=7 && board[y+1][x+2] <=0 && board[y+1][x+2] >= -6) {
		  posList.add((y+1) + " " + (x+2));
	  }
	  
	  if(x-2 >= 0 && y-1 >= 0 && board[y-1][x-2] <=0 && board[y-1][x-2] >= -6) {
		  posList.add((y-1) + " " + (x-2));
	  }
	  
	  if(x+2 <= 7 && y-1 >= 0 && board[y-1][x+2] <=0 && board[y-1][x+2] >= -6) {
		  posList.add((y-1) + " " + (x+2));
	  }

	  
	  //Backward
	  if(y-2 >= 0 && x-1 >=0 && board[y-2][x-1] <=0 && board[y-2][x-1] >= -6) {
		  posList.add((y-2) + " " + (x-1));
	  }
	  
	  if(y-2 >= 0 && x+1 <= 7 && board[y-2][x+1] <=0 && board[y-2][x+1] >= -6) {
		  posList.add((y-2) + " " + (x+1));
	  }
  }//end +Knight
  else if(board[y][x] == -2 && move == -1) {
	  
	  System.out.println("Picked a -Knight");
	  selectedPiece = -2;
	  
	  //Forward
	  if(y+2 <= 7 && x-1 >=0 && board[y+2][x-1] >=0 && board[y+2][x-1] <= 6) {
		  posList.add((y+2) + " " + (x-1));
	  }
	  
	  if(y+2 <= 7 && x+1 <= 7 && board[y+2][x+1] >=0 && board[y+2][x+1] <= 6) {
		  posList.add((y+2) + " " + (x+1));
	  }
	  
	  //Sides
	  if(x-2 >= 0 && y+1 <= 7 && board[y+1][x-2] >=0 && board[y+1][x-2] <= 6) {
		  posList.add((y+1) + " " + (x-2));
	  }
	  
	  if(x+2 <= 7 && y+1 <=7 && board[y+1][x+2] >=0 && board[y+1][x+2] <= 6) {
		  posList.add((y+1) + " " + (x+2));
	  }
	  
	  if(x-2 >= 0 && y-1 >= 0 && board[y-1][x-2] >=0 && board[y-1][x-2] <= 6) {
		  posList.add((y-1) + " " + (x-2));
	  }
	  
	  if(x+2 <= 7 && y-1 >= 0 && board[y-1][x+2] >=0 && board[y-1][x+2] <= 6) {
		  posList.add((y-1) + " " + (x+2));
	  }

	  
	  //Backward
	  if(y-2 >= 0 && x-1 >=0 && board[y-2][x-1] >=0 && board[y-2][x-1] <= 6) {
		  posList.add((y-2) + " " + (x-1));
	  }
	  
	  if(y-2 >= 0 && x+1 <= 7 && board[y-2][x+1] >=0 && board[y-2][x+1] <= 6) {
		  posList.add((y-2) + " " + (x+1));
	  }
	  
  
  
  }//end -Knight
  else if(board[y][x] == 3 && move == 1) {
	  System.out.println("Picked a Bishop");
	  selectedPiece = 3;
	  int newX = x+1;
	  int newY = y+1;
	  while(newX <= 7 && newY <= 7 && board[newY][newX] <= 0 && board[newY][newX] >= -6 ) {
		  posList.add(newY + " " + newX);
		  if(board[newY][newX]!= 0)
				break;
		  newY++;
		  newX++;
	  }
	  newX = x-1;
	  newY = y+1;
	  while(newX >= 0 && newY <= 7 && board[newY][newX] <= 0 && board[newY][newX] >= -6) {
		  posList.add(newY + " " + newX);
		  if(board[newY][newX]!= 0)
				break;
		  newY++;
		  newX--;
	  }
	  newX = x+1;
	  newY = y-1;
	  while(newX <= 7 && newY >= 0 && board[newY][newX] <= 0 && board[newY][newX] >= -6 ) {
		  posList.add(newY + " " + newX);
		  if(board[newY][newX]!= 0)
				break;
		  newY--;
		  newX++;
	  }
	  newX = x-1;
	  newY = y-1;
	  while(newX >= 0 && newY >= 0 && board[newY][newX] <= 0  && board[newY][newX] >= -6) {
		  posList.add(newY + " " + newX);
		  if(board[newY][newX]!= 0)
				break;
		  newY--;
		  newX--;
	  }
	  
	  
	  
	  
  }//end +Bishop
  else if(board[y][x] == -3 && move == -1) {
	  System.out.println("Picked a -Bishop");
	  selectedPiece = -3;
	  int newX = x+1;
	  int newY = y+1;
	  while(newX <= 7 && newY <= 7 && board[newY][newX] >= 0 && board[newY][newX] <= 6 ) {
		 // System.out.println("1Adding (" + newY + "  " + newX + ")" );
		  posList.add(newY + " " + newX);
		  if(board[newY][newX]!= 0)
				break;
		  newY++;
		  newX++;
		 
	  }
	  newX = x-1;
	  newY = y+1;
	  while(newX >= 0 && newY <= 7 && board[newY][newX] >= 0 && board[newY][newX] <= 6) {
		//  System.out.println("2Adding (" + newY + "  " + newX + ")" );
		  posList.add(newY + " " + newX);
		  if(board[newY][newX]!= 0)
				break;
	  
		  newY++;
		  newX--;
	  }
	  newX = x+1;
	  newY = y-1;
	  while(newX <= 7 && newY >= 0 && board[newY][newX] >= 0 && board[newY][newX] <= 6 ) {
		 // System.out.println("3Adding (" + newY + "  " + newX + ")" );
		  posList.add(newY + " " + newX);
		  if(board[newY][newX]!= 0)
				break;
		  newY--;
		  newX++;
		
	  }
	  newX = x-1;
	  newY = y-1;
	  while(newX >= 0 && newY >= 0 && board[newY][newX] >= 0  && board[newY][newX] <= 6) {
		//  System.out.println("Adding (" + newY + "  " + newX + ")" );
		  posList.add(newY + " " + newX);
			if(board[newY][newX]!= 0)
				break;
		  newY--;
		  newX--;
		
	  }
	  
	  
  }//end -Bishop
  else if(board[y][x] == 4 && move == 1) {
	  System.out.println("Picked a Rook");
	  selectedPiece = 4;
	  int newX = x;
	  int newY = y+1;
	  while(newY <= 7 && board[newY][newX] <= 0 && board[newY][newX] >= -6) {
		  posList.add(newY + " " + newX);
		  if(board[newY][newX]!= 0)
				break;
		  newY++;
	  }
	   newX = x;
	   newY = y-1;
	   while(newY >= 0 && board[newY][newX] <= 0 && board[newY][newX] >=-6) {
		   posList.add(newY + " " + newX);
			  if(board[newY][newX]!= 0)
					break;
			  newY--;
	   }
	   newX = x+1;
	   newY = y;
	   while(newX <= 7 && board[newY][newX] <= 0 && board[newY][newX] >= -6) {
			posList.add(newY + " " + newX);
			if(board[newY][newX]!= 0)
					break;
			 newX++;
	   }
	   newX = x-1;
	   newY = y;
	   while(newX >= 0 && board[newY][newX] <= 0 && board[newY][newX] >= -6) {
			posList.add(newY + " " + newX);
			if(board[newY][newX]!= 0)
					break;
			 newX--;
	   } 
	  
  }//end +Rook
  else if(board[y][x] == -4 && move == -1) {
	  System.out.println("Picked a -Rook");
	  selectedPiece = -4;
	  int newX = x;
	  int newY = y+1;
	  while(newY <= 7 && board[newY][newX] >= 0 && board[newY][newX] <= 6) {
		  posList.add(newY + " " + newX);
		  if(board[newY][newX]!= 0)
				break;
		  newY++;
	  }
	   newX = x;
	   newY = y-1;
	   while(newY >= 0 && board[newY][newX] >= 0 && board[newY][newX] <= 6) {
		   posList.add(newY + " " + newX);
			  if(board[newY][newX]!= 0)
					break;
			  newY--;
	   }
	   newX = x+1;
	   newY = y;
	   while(newX <= 7 && board[newY][newX] >= 0 && board[newY][newX] <= 6) {
			posList.add(newY + " " + newX);
			if(board[newY][newX]!= 0)
					break;
			 newX++;
	   }
	   newX = x-1;
	   newY = y;
	   while(newX >= 0 && board[newY][newX] >= 0 && board[newY][newX] <= 6) {
			posList.add(newY + " " + newX);
			if(board[newY][newX]!= 0)
					break;
			 newX--;
	   } 
	  
  }//end -Rook
  else if(board[y][x] == 5 && move == 1) {
	  System.out.println("Picked a Queen");
	  selectedPiece = 5;
	  
	  //Rook-like moves first
	  int newX = x;
	  int newY = y+1;
	  while(newY <= 7 && board[newY][newX] <= 0 && board[newY][newX] >= -6) {
		  posList.add(newY + " " + newX);
		  if(board[newY][newX]!= 0)
				break;
		  newY++;
	  }
	   newX = x;
	   newY = y-1;
	   while(newY >= 0 && board[newY][newX] <= 0 && board[newY][newX] >=-6) {
		   posList.add(newY + " " + newX);
			  if(board[newY][newX]!= 0)
					break;
			  newY--;
	   }
	   newX = x+1;
	   newY = y;
	   while(newX <= 7 && board[newY][newX] <= 0 && board[newY][newX] >= -6) {
			posList.add(newY + " " + newX);
			if(board[newY][newX]!= 0)
					break;
			 newX++;
	   }
	   newX = x-1;
	   newY = y;
	   while(newX >= 0 && board[newY][newX] <= 0 && board[newY][newX] >= -6) {
			posList.add(newY + " " + newX);
			if(board[newY][newX]!= 0)
					break;
			 newX--;
	   } 
	   
	   //Bishop-like moves next
		   newX = x+1;
		   newY = y+1;
		  while(newX <= 7 && newY <= 7 && board[newY][newX] <= 0 && board[newY][newX] >= -6 ) {
			  posList.add(newY + " " + newX);
			  if(board[newY][newX]!= 0)
					break;
			  newY++;
			  newX++;
		  }
		  newX = x-1;
		  newY = y+1;
		  while(newX >= 0 && newY <= 7 && board[newY][newX] <= 0 && board[newY][newX] >= -6) {
			  posList.add(newY + " " + newX);
			  if(board[newY][newX]!= 0)
					break;
			  newY++;
			  newX--;
		  }
		  newX = x+1;
		  newY = y-1;
		  while(newX <= 7 && newY >= 0 && board[newY][newX] <= 0 && board[newY][newX] >= -6 ) {
			  posList.add(newY + " " + newX);
			  if(board[newY][newX]!= 0)
					break;
			  newY--;
			  newX++;
		  }
		  newX = x-1;
		  newY = y-1;
		  while(newX >= 0 && newY >= 0 && board[newY][newX] <= 0  && board[newY][newX] >= -6) {
			  posList.add(newY + " " + newX);
			  if(board[newY][newX]!= 0)
					break;
			  newY--;
			  newX--;
		  }
	   
	  
  }//end +Queen
  else if(board[y][x] == -5 && move == -1 ) {
	  System.out.println("Picked a -Queen");
	  selectedPiece = -5;
	  
	  //Rook-like moves first
	  int newX = x;
	  int newY = y+1;
	  while(newY <= 7 && board[newY][newX] >= 0 && board[newY][newX] <= 6) {
		  posList.add(newY + " " + newX);
		  if(board[newY][newX]!= 0)
				break;
		  newY++;
	  }
	   newX = x;
	   newY = y-1;
	   while(newY >= 0 && board[newY][newX] >= 0 && board[newY][newX] <= 6) {
		   posList.add(newY + " " + newX);
			  if(board[newY][newX]!= 0)
					break;
			  newY--;
	   }
	   newX = x+1;
	   newY = y;
	   while(newX <= 7 && board[newY][newX] >= 0 && board[newY][newX] <= 6) {
			posList.add(newY + " " + newX);
			if(board[newY][newX]!= 0)
					break;
			 newX++;
	   }
	   newX = x-1;
	   newY = y;
	   while(newX >= 0 && board[newY][newX] >= 0 && board[newY][newX] <= 6) {
			posList.add(newY + " " + newX);
			if(board[newY][newX]!= 0)
					break;
			 newX--;
	   } 
	   
	   //Then Bishop
		  newX = x+1;
		  newY = y+1;
		  while(newX <= 7 && newY <= 7 && board[newY][newX] >= 0 && board[newY][newX] <= 6 ) {
			 // System.out.println("1Adding (" + newY + "  " + newX + ")" );
			  posList.add(newY + " " + newX);
			  if(board[newY][newX]!= 0)
					break;
			  newY++;
			  newX++;
			 
		  }
		  newX = x-1;
		  newY = y+1;
		  while(newX >= 0 && newY <= 7 && board[newY][newX] >= 0 && board[newY][newX] <= 6) {
			//  System.out.println("2Adding (" + newY + "  " + newX + ")" );
			  posList.add(newY + " " + newX);
			  if(board[newY][newX]!= 0)
					break;
		  
			  newY++;
			  newX--;
		  }
		  newX = x+1;
		  newY = y-1;
		  while(newX <= 7 && newY >= 0 && board[newY][newX] >= 0 && board[newY][newX] <= 6 ) {
			 // System.out.println("3Adding (" + newY + "  " + newX + ")" );
			  posList.add(newY + " " + newX);
			  if(board[newY][newX]!= 0)
					break;
			  newY--;
			  newX++;
			
		  }
		  newX = x-1;
		  newY = y-1;
		  while(newX >= 0 && newY >= 0 && board[newY][newX] >= 0  && board[newY][newX] <= 6) {
			//  System.out.println("Adding (" + newY + "  " + newX + ")" );
			  posList.add(newY + " " + newX);
				if(board[newY][newX]!= 0)
					break;
			  newY--;
			  newX--;
			
		  }
	  
	  
  }//end -Queen
  else if(board[y][x] == 6 && move == 1) {
	  System.out.println("Picked the King");
	  selectedPiece = 6;
	  
	  //Right Side
	  if(y-1 >= 0 && x+1 <= 7 && board[y-1][x+1] <= 0 && board[y-1][x+1] >= -6) {
		  posList.add((y-1) + " " + (x+1));
	  }
	  if(x+1 <= 7 && board[y][x+1] <= 0 && board[y][x+1] >= -6) {
		  posList.add((y) + " " + (x+1));
		  
	  }
	  if(x+1 <= 7 && y+1 <=7 && board[y+1][x+1] <= 0 && board[y+1][x+1] >=-6 ){
		  posList.add((y+1)+ " " + (x+1));
	  }
	  
	  //Left side
	  if(x-1 >= 0 && y-1 >= 0 && board[y-1][x-1] <= 0 && board[y-1][x-1] >= -6 ) {
		  posList.add((y-1) + " " + (x-1));
	  }
	  if(x-1 >= 0 && board[y][x-1] <= 0 && board[y][x-1] >= -6) {
		  posList.add((y) + " " + (x-1));
	  }
	  
	  if(x-1 >= 0 && y+1 <=7 && board[y+1][x-1] <= 0 && board[y+1][x-1] >=-6 ){
		  posList.add((y+1)+ " " + (x-1));
	}
	  
	 //Front and Back
	  if(x <= 7 && y+1 <=7 && board[y+1][x] <= 0 && board[y+1][x] >= -6){
		  posList.add((y+1)+ " " + (x));
		  }
	  if(x <= 7 && y-1 >= 0 && board[y-1][x] <= 0 && board[y-1][x] >= -6){
		  posList.add((y-1)+ " " + (x));
	  }
	  
	  
  }//end +King
  else if(board[y][x] == -6 && move == -1) {
	  System.out.println("Picked the King");
	  selectedPiece = -6;
	  
	  //Right Side
	  if(y-1 >= 0 && x+1 <= 7 && board[y-1][x+1] >= 0 && board[y-1][x+1] <= 6) {
		  posList.add((y-1) + " " + (x+1));
	  }
	  if(x+1 <= 7 && board[y][x+1] >= 0 && board[y][x+1] <= 6) {
		  posList.add((y) + " " + (x+1));
		  
	  }
	  if(x+1 <= 7 && y+1 <=7 && board[y+1][x+1] >= 0 && board[y+1][x+1] <=6 ){
		  posList.add((y+1)+ " " + (x+1));
	  }
	  
	  //Left side
	  if(x-1 >= 0 && y-1 >= 0 && board[y-1][x-1] >= 0 && board[y-1][x-1] <= 6 ) {
		  posList.add((y-1) + " " + (x-1));
	  }
	  if(x-1 >= 0 && board[y][x-1] >= 0 && board[y][x-1] <= 6) {
		  posList.add((y) + " " + (x-1));
	  }
	  
	  if(x-1 >= 0 && y+1 <=7 && board[y+1][x-1] >= 0 && board[y+1][x-1] <=6 ){
		  posList.add((y+1)+ " " + (x-1));
	}
	  
	 //Front and Back
	  if(x <= 7 && y+1 <=7 && board[y+1][x] >= 0 && board[y+1][x] <= 6){
		  posList.add((y+1)+ " " + (x));
		  }
	  if(x <= 7 && y-1 >= 0 && board[y-1][x] >= 0 && board[y-1][x] <= 6){
		  posList.add((y-1)+ " " + (x));
	  }
	  
  }//end -King
  
  }//end bothlegal
 
 }

 @Override
 public void mouseReleased(MouseEvent e) {
	 //System.out.println("RELEASED");
  boolean bothlegal = false;
  int x = -1;
  int y = -1;
  if(e.getX() > 50 && e.getX() <=85) {
   bothlegal = true;
   x=0;
  }
  else if(e.getX() > 85 && e.getX() <=120) {
   bothlegal = true;
   x=1;
  }
  else if(e.getX() > 120 && e.getX() <=155) {
   bothlegal = true;
   x=2;
  }
  else if(e.getX() > 155 && e.getX() <= 190) {
   bothlegal = true;
   x=3;
  }
  else if(e.getX() > 190 && e.getX() <= 225) {
   bothlegal = true;
   x=4;
  }
  else if(e.getX() > 225 && e.getX() <= 260) {
   bothlegal = true;
   x=5;
  }
  else if(e.getX() > 260 && e.getX() <= 295) {
   bothlegal = true;
   x=6;
  }
  else if(e.getX() > 295 && e.getX() <= 330) {
   bothlegal = true;
   x=7;
  }
  else {
   bothlegal = false;
  }
  if(bothlegal) {
   
  
  if(e.getY() > 50 && e.getY() <=85) {
   bothlegal = true;
   y=0;
  }
  else if(e.getY() > 85 && e.getY() <=120) {
   bothlegal = true;
   y=1;
  }
  else if(e.getY() > 120 && e.getY() <=155) {
   bothlegal = true;
   y=2;
  }
  else if(e.getY() > 155 && e.getY() <= 190) {
   bothlegal = true;
   y=3;
  }
  else if(e.getY() > 190 && e.getY() <= 225) {
   bothlegal = true;
   y=4;
  }
  else if(e.getY() > 225 && e.getY() <= 260) {
   bothlegal = true;
   y=5;
  }
  else if(e.getY() > 260 && e.getY() <= 295) {
   bothlegal = true;
   y=6;
  }
  else if(e.getY() > 295 && e.getY() <= 330) {
   bothlegal = true;
   y=7;
  }
  else {
   bothlegal = false;
   x=-1;
   y=-1;
  }
  
  }
  if(bothlegal) {
  
   //System.out.println(board[y][x]);
   
	  for(int i = 0; i < posList.size(); i++) {
	  //System.out.println("Looking for: " + (y + " " + x) + "\t Found: " + posList.get(i));
	   if((y+" " + x).equals(posList.get(i))) {
		   board[y][x] = selectedPiece;
		   String[] previous = previousPos.split(" ");
		   if(Integer.parseInt(previous[0]) >= 0 && Integer.parseInt(previous[0] ) <=7 && Integer.parseInt(previous[1]) >= 0 && Integer.parseInt(previous[1] ) <=7)
		   board[Integer.parseInt(previous[0])][Integer.parseInt(previous[1])] = 0;
		   previousPos = "";
		   move*=-1;
		   repaint();
		   if(move == 1) {
			   System.out.println("Positive turn!");
		   }
		   else {
			   System.out.println("Negative turn!");
		   }
		   for(int j = 0; j < 8; j++) {
		       for(int k = 0; k < 8; k++) {
		        System.out.print(board[j][k] +", ");
		       }
		       System.out.println();
		      }

		   
		   
		   break;
	   }
   }
	  


   
   selectedPiece =-7;
   posList.clear();
   x=-1;
   y=-1;
   
   
  }
 }
}







}