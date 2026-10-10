public abstract class Instrument {
    public abstract String play();
}

public class StringInstrument extends Instrument {
    @Override
    public String play() {
        return "Strumming the strings";
    }
}

public class Violin extends StringInstrument {
    @Override
    public String play() {
        return super.play() + ", with a bow drawn across four strings";
    }
}
