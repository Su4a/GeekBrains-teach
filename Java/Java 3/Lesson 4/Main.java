public class Main {
    public static void main(String[] args) {
        SymbolComparison.symbolComparison = 'A';
        Monitor monitor = new Monitor();

        new Thread(new CharType('A', 'B', monitor));
        new Thread(new CharType('B', 'C', monitor));
        new Thread(new CharType('C', 'A', monitor));
    }
}

class Monitor { }

class SymbolComparison {
    static char symbolComparison;
}
