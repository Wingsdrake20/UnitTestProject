import org.junit.Test;
import static org.junit.Assert.*;
public class Tester {

    YahtzeeScorer ys1 = new YahtzeeScorer();
    int a, b, c, d, e;

    public void setDie(int f, int g, int h, int i, int j)
    {
        a = f;
        b = g;
        c = h;
        d = i;
        e = j;
    }
    @Test
    public void testYahtzee()
    {
        //Unit Test 1
        setDie(1, 1, 1, 1, 1);
        ys1.newRoll(a, b, c, d, e);
        String choice = "Yahtzee";
        assertEquals(50, ys1.scorer(choice, a, b, c, d, e));
        ys1.played("Yahtzee", false);

        //Unit Test 2
        setDie(1, 1, 1, 1, 2);
        ys1.newRoll(a, b, c, d, e);
        assertEquals(0, ys1.scorer(choice, a, b, c, d, e));
        ys1.played("Yahtzee", true);

        //Unit Test 3
        setDie(1, 1, 1, 1, 1);
        ys1.newRoll(a, b, c, d, e);
        assertEquals(0, ys1.scorer(choice, a, b, c, d, e));

        //Unit Test 4
        System.out.println(ys1.getScore());
    }

    @Test
    public void testLargeStraight()
    {
        //Unit Test 5
        setDie(4, 2, 3, 6, 5);
        ys1.newRoll(a, b, c, d, e);
        String choice = "Large Straight";
        assertEquals(40, ys1.scorer(choice, a, b, c, d, e));
        ys1.played("Large Straight", false);

        //Unit Test 6
        setDie(1, 2, 3, 5, 6);
        ys1.newRoll(a, b, c, d, e);
        assertEquals(0, ys1.scorer(choice, a, b, c, d, e));
        ys1.played("Large Straight", true);

        //Unit Test 7
        setDie(2, 5, 6, 3, 4);
        ys1.newRoll(a, b, c, d, e);
        assertEquals(0, ys1.scorer(choice, a, b, c, d, e));

        //Unit Test 8
        System.out.println(ys1.getScore());
    }

    @Test
    public void testFullHouse()
    {
        //Unit Test 9
        setDie(3, 2, 3, 3, 2);
        ys1.newRoll(a, b, c, d, e);
        String choice = "Full House";
        assertEquals(25, ys1.scorer(choice, a, b, c, d, e));
        ys1.played("Full House", false);

        //Unit Test 10
        setDie(3, 2, 3, 5, 3);
        ys1.newRoll(a, b, c, d, e);
        assertEquals(0, ys1.scorer(choice, a, b, c, d, e));
        ys1.played("Full House", true);

        //Unit Test 11
        setDie(3, 3, 2, 3, 2);
        ys1.newRoll(a, b, c, d, e);
        assertEquals(0, ys1.scorer(choice, a, b, c, d, e));

        //Unit Test 12
        System.out.println(ys1.getScore());
    }

    @Test
    public void test3OfAKind()
    {
        //Unit Test 13
        setDie(3, 1, 3, 3, 2);
        ys1.newRoll(a, b, c, d, e);
        String choice = "3 of a Kind";
        assertEquals(a + b + c + d + e, ys1.scorer(choice, a, b, c, d, e));
        ys1.played("3 of a Kind", false);

        //Unit Test 14
        setDie(3, 2, 1, 5, 3);
        ys1.newRoll(a, b, c, d, e);
        assertEquals(0, ys1.scorer(choice, a, b, c, d, e));
        ys1.played("3 of a Kind", true);

        //Unit Test 15
        setDie(3, 3, 2, 3, 2);
        ys1.newRoll(a, b, c, d, e);
        assertEquals(0, ys1.scorer(choice, a, b, c, d, e));

        //Unit Test 16
        System.out.println(ys1.getScore());
    }

}
