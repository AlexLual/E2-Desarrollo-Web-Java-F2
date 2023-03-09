import java.util.Scanner;


public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Helado nieve = new HeladoSuave();
        int costo = nieve.assemble();

        int option = 0;


        while (option != 6) {
            System.out.println("\nCosto actual: " + costo);
            System.out.println("Elija alguna opción para agregar a su helado:");
            System.out.println("1. Cobertura");
            System.out.println("2. Galleta");
            System.out.println("3. Granola");
            System.out.println("4. Mermelada");
            System.out.println("5. Topping");
            System.out.println("6. Total");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    nieve = new CoberturaToping(nieve);
                    costo += nieve.assemble();
                    break;
                case 2:
                    nieve = new Galleta(nieve);
                    costo += nieve.assemble();
                    break;
                case 3:
                    nieve = new Granola(nieve);
                    costo += nieve.assemble();
                    break;
                case 4:
                    nieve = new Mermelada(nieve);
                    costo += nieve.assemble();
                    break;
                case 5:
                    nieve = new Topping(nieve);
                    costo += nieve.assemble();
                    break;
                case 6:
                    System.out.printf("El total es $ %d, por favor pase a pagar a caja\n", costo);                    break;
            }
        }
      }
}