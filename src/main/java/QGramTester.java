public class QGramTester {

    public static void main(String[] args) {
        QGram g = new QGram(2);
        g.printTokens("alal");

        double value = g.similarity("salesal", "alale");
        System.out.println(value);
    }
}
