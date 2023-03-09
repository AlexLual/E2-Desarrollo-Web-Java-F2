public class Galleta extends HeladoDecorador {
    public Galleta(Helado helado) {
        super(helado);
    }

    public int assemble() {
        super.assemble();
        System.out.println("Agregando galleta + $15 extra");
        return 15;
    }
}