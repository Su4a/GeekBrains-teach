public class CharType extends Thread {
    private final char charSymbol;
    private final char charSymbolNext;
    final Monitor monitor;

    public CharType(char charSymbol, char charSymbolNext, Monitor monitor) {
        this.charSymbol = charSymbol;
        this.charSymbolNext = charSymbolNext;
        this.monitor = monitor;
        this.start();
    }

    @Override
    public void run() {
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                while (true) {
                    if (charSymbol != SymbolComparison.symbolComparison) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println(charSymbol);
                        SymbolComparison.symbolComparison = charSymbolNext;
                        monitor.notifyAll();
                        break;
                    }
                }
            }
        }
    }
}
