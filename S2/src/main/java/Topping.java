public class Topping extends HeladoDecorador {
    public Topping(Helado helado) {
        super(helado);
    }

    public int assemble() {
        super.assemble();
        System.out.println("Agregando topping + $20 extra");
        return 20;
    }
}