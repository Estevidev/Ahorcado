import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
    
        Scanner scanner= new Scanner(System.in);

        String palabraSecreta = "sabelotodo";
        int intentosMax = 8;
        int intentos = 0;
        boolean palabraCorrecta = false;

        char [] letrasAdivinadas = new char[palabraSecreta.length()]; //para saber cuantas letras maximo tiene que adivinar para ganar

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }
        
        while (!palabraCorrecta && intentos < intentosMax) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas));
            System.out.println("Introduce una letra: ");
            //Le pedimos una letra
            char letra = Character.toLowerCase(scanner.next().charAt(0)); // es un metodo que devuelve la primera letra que se escriba (por eso el 0), por si escribe mas de una antes de pulsar enter

            boolean letraCorrecta = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if(palabraSecreta.charAt(i) == letra){
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true; // evitamos que gaste un intento
                }
            }

            if(!letraCorrecta){
                intentos++;
                System.out.println("¡Incorrecto! Te quedan " + (intentosMax - intentos) + " intentos");
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraCorrecta = true;
                System.out.println("La palabra era: " + palabraSecreta);
                System.out.println("¡Enhorabuena! Has acertado la palabra secreta");
            }
        }
        if(!palabraCorrecta){
            System.out.println("¡¡Has perdido!!");
        }
        scanner.close();

    }
}
