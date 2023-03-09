public class CoberturaToping extends HeladoDecorador {
    public CoberturaToping(Helado helado) {
        super(helado);
    }

    public int assemble() {
        super.assemble();
        System.out.println("Agregando cobertura + $20 extra");
        return 20;
    }
}