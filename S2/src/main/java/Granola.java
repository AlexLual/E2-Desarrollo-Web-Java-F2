public class Granola extends HeladoDecorador {
    public Granola(Helado helado) {
        super(helado);
    }

    public int assemble() {
        super.assemble();
        System.out.println("Agregando Granola + $10 extra");
        return 10;
    }
}