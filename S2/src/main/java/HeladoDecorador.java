public class HeladoDecorador implements Helado{
protected Helado helado;

public HeladoDecorador(Helado helado) {
        this.helado = helado;
        }

public int assemble() {
        this.helado.assemble();
        int a = 0;
        return a;}
        }