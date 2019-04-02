package romannumberconverter;

public class RomanNumberConverter {

  public int convert(String roman){
    if (roman == null) {
      throw new IllegalArgumentException("number cannot be null");
    }

    int number = 0;
    //vérifier les caractères ?

    return number;
  }

  public String convert(int number){
    if (number == 0) {
      throw new IllegalArgumentException("number cannot be 0");
    }
    if (number < 0) {
      throw new IllegalArgumentException("number cannot be negative");
    }
    String roman = "";
    String unite = "a";
    String cinq = "a";

    int [] decomposition = decompose(number);
    for (int i=0; i<decomposition.length; i++)
    {
      switch(i) {
        case 0:
          unite = "I";
          cinq = "V";
          break;
        case 1:
          unite = "X";
          unite = "L";
          break;
        case 2:
          unite = "C";
          cinq = "D";
          break;
        case 3:
          unite = "M";
          cinq = "MMMMM";
        default:
          unite = "a";
          cinq = "a";
      }
      System.out.println(decomposition[i]);
      if (decomposition[i] <= 3){
        for(int j=0; j<decomposition[i];j++){
          roman = roman + unite;
        }
        break; // doit sauter la fin de la boucle for
      }
      switch (decomposition[i]) {
        case 4:
          roman = unite + cinq + roman;
          break;
        case 5:
          roman = cinq + roman;
          break;
        case 9:
          roman = "9"+roman;
          break;
        default:
          break;
      }
      if (decomposition[i] <= 8){
        for(int j=0; j<decomposition[i];j++){
          roman = roman + unite;
        }
        roman = cinq + roman;
        break;
      }
    }
    return roman;
  }

  int [] decompose (int n) {
    int length = new String ( "" + n + "").length ();
    int [] result = new int [length];
    int i = 0;

    while (n > 0) {
      result [i++] = n % 10;
      n /= 10;
    }
    return result;
  }
}
