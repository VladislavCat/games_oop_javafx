package ru.job4j.chess.figures.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

public class BishopBlackTest {

    @Test
    public void whenCreatePositionTrue() {
        BishopBlack test = new BishopBlack(Cell.findBy(5, 0));
        Cell expected = Cell.findBy(5, 0);
        Cell res = test.position();
        Assert.assertEquals(expected, res);
    }

    @Test
    public void whenCopyPositionTrue() {
        Figure test = new BishopBlack(Cell.findBy(5, 0));
        Cell dest = Cell.findBy(4, 1);
        test = test.copy(dest);
        Assert.assertEquals(test.position(), dest);
    }

    @Test
    public void whenReturnCellWay() {
        Figure test = new BishopBlack(Cell.C1);
        Cell[] result = test.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertArrayEquals(expected, result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenFalseWay() {
        Figure test = new BishopBlack(Cell.findBy(2, 7));
        Cell[] result = test.way(Cell.C3);
    }

}
