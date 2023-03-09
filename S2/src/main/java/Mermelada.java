public class Mermelada extends HeladoDecorador {
    public Mermelada(Helado helado) {
        super(helado);
    }

    public int assemble() {
        super.assemble();
        System.out.println("Agregando mermelada + $10 extra");
        return 10;
    }
}