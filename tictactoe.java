import java.util.*;
public class tictactoe
{  
  static int[] grid = {1,2,3,4,5,6,7,8,9}; 
  static char letter;
  static char comp_letter;
  public static void program_initialize()//gets all values prepared for the rest of the programs execution 
  { 
   Scanner sc = new Scanner(System.in);
   System.out.println("Hello this is a tic tac toe program in which you play against a computer.");
   grid = new int[] {1,2,3,4,5,6,7,8,9};
   int xo = 3; 
   int first_check = 0;//flag to check if its the first time the loop has been executed
   while((xo > 2) || (xo < 1)) 
   { 
    if(first_check == 0) 
    { 
     System.out.print("Input 1 to go first(X) or 2 to go second(O):"); 
     xo = sc.nextInt();
     System.out.println();
     first_check++; 
     break;
    }
    System.out.print("Invalid Input.Please Reinput 1 to go first(X) or 2 to go second(O):"); 
    xo = sc.nextInt();
    System.out.println();
   }  
   display_grid();
   System.out.println("To play this version input a number from 1-9 to make a mark in the corresponding box.Enjoy!"); 
   switch(xo) 
   { 
    case 1: 
    letter = 'X'; 
    comp_letter = 'O';
    break; 
    case 2: 
    letter = 'O'; 
    comp_letter = 'X';   
    break;
   }  
  }
  public static void display_grid()//displays tictactoe board 
  { 
   int new_line = 0;//starts to print new line 
   int current_line;//prints next collumn of a line
   for(int i = 0;i <= 2;i++) 
   { 
    System.out.println(); 
    System.out.println("+***+***+***+");   
    System.out.print("| "); 
    for(current_line = new_line;current_line <= 2 + new_line;current_line++)
    {
     if(grid[current_line] == 0) 
     { 
      System.out.print(letter + " | ");  
     } 
     else if(grid[current_line] == 10) 
     { 
      System.out.print(comp_letter + " | ");  
     }
     else
     {
     System.out.print(grid[current_line] + " | "); 
     }
    }  
    new_line += 3;
   } 
   System.out.println(); 
   System.out.println("+***+***+***+");  
  } 
  public static void input()//takes in users input 
  { 
   Scanner sc = new Scanner(System.in); 
   int input = 10;
   int first_check = 0;//flag to check if this is the first time user has inputted
   while((input > 9) || (input < 0)) 
   {
    if(first_check == 0) 
    { 
     System.out.print("Your turn.Input a number from 1-9:"); 
     input = sc.nextInt(); 
     System.out.println();
     first_check++;
     if(input < 10 && input > 0) 
     {
      break;
     }
    }
    System.out.print("Invalid Input. Please Reinput a number from 1-9 to make a mark in the corresponding box:"); 
    input = sc.nextInt(); 
    System.out.println();
   } 
   input--;
   while((grid[input] == 0)||(grid[input] == 10)) 
   { 
    input = 10;
    System.out.print("Inputted square occupied.Please Reinput a number from 1-9 to make a mark in the corresponding box:"); 
    input = sc.nextInt(); 
    System.out.println();
    while((input > 9) || (input < 0)) 
    {
     System.out.print("Invalid Input.Please Reinput a number from 1-9 to make a mark in the corresponding box:"); 
     input = sc.nextInt(); 
     System.out.println();
    } 
    input--;
   }
   grid[input] = 0;
  } 
  public static void process()//processes one round of the game 
  { 
   input(); 
   display_grid(); 
   System.out.println("Computers Plays:");
   computer_ai(); 
   display_grid();
  }
  public static void computer_ai()//decides computers move 
  { 
   int[] free_squares = {1,2,3,4,5,6,7,8,9};
   int rand;
   for(int i = 0;i <= 8;i++) 
   { 
    if((grid[i] == 0) || (grid[i] == 10)) 
    { 
     free_squares[i] = grid[i];
    }
    else 
    { 
     continue;
    }
   } 
   while(true) 
   { 
    rand = (int)Math.round(Math.random()*8);
    if((free_squares[rand] != 0) && (free_squares[rand] != 10)) 
    { 
     grid[rand] = 10; 
     break;
    }
   }
  }
  public static int win_detect()//used to check if a victory has occured returns 1 for player victory, returns 2 for computer victory, returns 3 for draw,4 for no change
  { 
   if((grid[0] == grid[1]) && (grid[1]== grid[2]) && (grid[1] == 0))
   { 
    return 1;
   } 
   else if((grid[0] == grid[1]) && (grid[1]== grid[2]) && (grid[1] == 10))
   { 
    return 2;
   } 
   else if((grid[3] == grid[4]) && (grid[4]== grid[5]) && (grid[3] == 0))
   { 
    return 1;
   } 
   else if((grid[3] == grid[4]) && (grid[4]== grid[5]) && (grid[5] == 10))
   { 
    return 2;
   } 
   else if((grid[6] == grid[7]) && (grid[7]== grid[8]) && (grid[7] == 0))
   { 
    return 1;
   } 
   else if((grid[6] == grid[7]) && (grid[7]== grid[8]) && (grid[7] == 10))
   { 
    return 2;
   } 
   else if((grid[0] == grid[4]) && (grid[4]== grid[8]) && (grid[4] == 0))
   { 
    return 1;
   } 
   else if((grid[0] == grid[3]) && (grid[3]== grid[6]) && (grid[3] == 10))
   { 
    return 2;
   } 
   else if((grid[1] == grid[4]) && (grid[4]== grid[7]) && (grid[4] == 0))
   { 
    return 1;
   } 
   else if((grid[1] == grid[4]) && (grid[4]== grid[7]) && (grid[4] == 10))
   { 
    return 2;
   } 
   else if((grid[2] == grid[5]) && (grid[5]== grid[8]) && (grid[2] == 0))
   { 
    return 1;
   } 
   else if((grid[2] == grid[5]) && (grid[5]== grid[8]) && (grid[2] == 10))
   { 
    return 2;
   } 
   else if((grid[0] == grid[4]) && (grid[4]== grid[8]) && (grid[0] == 0))
   { 
    return 1;
   } 
   else if((grid[0] == grid[4]) && (grid[4]== grid[8]) && (grid[0] == 10))
   { 
    return 2;
   } 
   else if((grid[2] == grid[4]) && (grid[4]== grid[6]) && (grid[2] == 0))
   { 
    return 1;
   } 
   else if((grid[2] == grid[4]) && (grid[4]== grid[6]) && (grid[2] == 10))
   { 
    return 2;
   } 
   else if(draw_check() == true)
   {
    return 3;
   } 
   else 
   { 
    return 4; 
   }
  }
  public static boolean draw_check()//method used to check if a draw occurs
  { 
   for(int i = 0;i <= 8;i++) 
   { 
    if((grid[i] == 0) || (grid[i] == 10)) 
    { 
     continue;
    }
    else 
    { 
     return false;
    }
   } 
   return true;
  } 
  public static void main() 
  { 
   program_initialize();
   if(letter == 'O') 
   { 
    computer_ai();
    display_grid();
   }
   process(); 
   while(win_detect() == 4) 
   { 
    process();
   }
   if(win_detect() == 1) 
   { 
    System.out.println("Congrats!You won :)");
   }
   if(win_detect() == 2) 
   { 
    System.out.println("Sorry.You lost :(");
   } 
   if(win_detect() == 3) 
   { 
    System.out.println("Oh its a draw.Try again next time.");
   }
  }
}