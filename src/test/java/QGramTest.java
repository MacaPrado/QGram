import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QGramTest {

    @Test
    void similitudOk(){
        new QGram(3);
        Assertions.assertEquals("1,0000", String.format("%.4f", QGram.similarity("joe","joe")));
        Assertions.assertEquals("0,3636", String.format("%.4f", QGram.similarity("john","joe")));
        new QGram(2);
        Assertions.assertEquals("0,3077", String.format("%.4f", QGram.similarity("salesal","vale")));
        Assertions.assertEquals("0,4286", String.format("%.4f", QGram.similarity("salesal","alale")));
    }

    @Test
    void tokensOk(){
        Assertions.assertEquals(QGram.getMap("joe"), QGram.getMap("joe"));
    }


}
