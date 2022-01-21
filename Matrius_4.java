//Creat per Joel Ferrer
package src;
import java.util.Scanner;

class Matrius_4{
  public static void main(String[] args){
    //Definim i inicialitzem la variable que farem servir per a introduir dades
    Scanner input = new Scanner(System.in);

    //Definim i inicializtem les variables que farem servir
    byte column1 = 0, row1 = 0, column2 = 0, row2 = 0, columnNum = 0, rowNum, plays = 0;
    char[][] map = new char[5][5];
    String player;
    boolean win1 = false, win2 = false, check = false;

    System.out.println("Benvingut al joc de enfonsar vaixells.\n");
    //Generem quatre nombres aleatoris entre el 1 i el que definiran on es trobara el vaixell
    column1 = (byte) (Math.random()*5 + 1);
    row1 = (byte) (Math.random()*5 + 1);

    column2 = (byte) (Math.random()*5 + 1);
    row2 = (byte) (Math.random()*5 + 1);
    //Omplim al array de '*'
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        map[i][j] = 'X';
      }
    }

    //Obrim el bucle de partida fins que acabi amb els dos vaixells
    while ((win1 == false) || (win2 == false)){
      //Dibuixem la graella
      System.out.println("  A B C D E");

      for (int i = 0; i < 5; i++) {
        System.out.print(i + 1+" ");
        for (int j = 0; j < 5; j++) {
          System.out.print(map[i][j]+" ");
        }
        System.out.println();
      }

      //Solicitem la coordenada a l'usuari
      System.out.print("Entra una coordenada en format \"B1\" o \"A4\": ");
      player = input.nextLine();
      //Mirem si aquesta coordenada és correcte en termes de format
      while (!check){
        if (player.length() != 2){
          System.out.print("Format incorrecte. Entra una coordenada en format \"B1\" o \"A4\": ");
        } else if (player.charAt(0) != 'A' && player.charAt(0) != 'B' && player.charAt(0) != 'C' && player.charAt(0) != 'D' && player.charAt(0) != 'E') {
          System.out.print("Format incorrecte. El primer caràcter ha de estar entre A i D: ");
        } else if (player.charAt(1) > '5' || player.charAt(1) < '1') {
          System.out.print("Format incorrecte. El segon caràcter ha de estar entre 1 i 4: ");
        } else {
          check = true;
          break;
        }
        player = input.nextLine();
      }
      check = false;
      //Convertim la entrada de l'usuari (lletra) a un valor númeric
      switch (player.charAt(0)){
        case 'A':
        columnNum = 1;
        break;
        case 'B':
        columnNum = 2;
        break;
        case 'C':
        columnNum = 3;
        break;
        case 'D':
        columnNum = 4;
        break;
        case 'E':
        columnNum = 5;
      }
      //Convertim la entrada de l'usuari (numeró en forma de caractér) a un valor númeric
      rowNum = (byte)(Character.getNumericValue(player.charAt(1)));

      //Si l'usuari encerta una coordenada li diem que ha encertat un vaixell i li diem que en queda un
      //Tenim dos booleans (win1 & win2) per saber si ha encertat els dos vaixells
      if ((columnNum == column1) && (rowNum == row1)){
        if (win1 == true){
          System.out.println("Ja has enfonsat aquest vaixell.\n");
        }else{
          System.out.println("Tocat i enfonsat. Enhorabona, has trobat un vaixell. Queda un.\n");
        }
        map[row1-1][column1-1] = 'V';
        plays++;
        win1 = true;
      }else if ((columnNum == column2) && (rowNum == row2)) {
        if (win2 == true){
          System.out.println("Ja has enfonsat aquest vaixell.\n");
        }else{
          System.out.println("Tocat i enfonsat. Enhorabona, has trobat un vaixell. Queda un.\n");
        }
        map[row2-1][column2-1] = 'V';
        plays++;
        win2 = true;
      }else{
        System.out.println(player+" = AIGUA.");
        map[rowNum-1][columnNum-1] = 'A';
        plays++;
      }
    }
    System.out.println("  A B C D E");

    for (int i = 0; i < 5; i++) {
      System.out.print(i + 1+" ");
      for (int j = 0; j < 5; j++) {
        System.out.print(map[i][j]+" ");
      }
      System.out.println();
    }
    //Mostrem el nombre d'intents i li indiquem que ha guanyat
    System.out.println("ENHORABONA! HAS GUANYAT EN "+plays+" INTENTS (comptant acerts).");
    
    input.close();
    
  }
}
