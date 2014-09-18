package com.hackergym.samples.tree;

import com.hackergym.samples.tree.model.GraphNode;
import org.junit.Test;

import static com.hackergym.samples.tree.Problem3.CellType;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class Problem3Test {

    public Problem3 solver = new Problem3();
    @Test
    public void testGenerateGraphCustom() throws Exception {

        CellType[][] cells = getMaze();
        GraphNode<CellType> node = solver.generateGraph(cells);

        //sample a couple of edge
        //better verifications are needed. Too
        assertThat(node.adjacents.size(), is(2));
    }

    @Test
    public void testGenerateGraphCustomAllWall() throws Exception {

        CellType[][] cells = getAllWalls();
        GraphNode<CellType> node = solver.generateGraphCustom(cells);

        assertThat(node, nullValue());
    }

    @Test
    public void testFindTreasureCustom() throws Exception {

        CellType[][] cells = getMaze();
        GraphNode<CellType> node = solver.findTreasureCustom(cells);

        assertThat(node.value, is(CellType.TREASURE));
    }

    @Test
    public void testFindTreasureCustomNoPath() throws Exception {

        CellType[][] cells = getUnreachableTrasure();
        GraphNode<CellType> node = solver.findTreasureCustom(cells);

        assertThat(node, nullValue());
    }

    @Test
    public void testGenerateGraph() throws Exception {

        CellType[][] cells = getMaze();
        GraphNode<CellType> node = solver.generateGraph(cells);

        //sample a couple of edge
        //better verifications are needed. Too
        assertThat(node.adjacents.size(), is(2));
    }

    @Test
    public void testGenerateGraphAllWall() throws Exception {

        CellType[][] cells = getAllWalls();
        GraphNode<CellType> node = solver.generateGraph(cells);

        assertThat(node, nullValue());
    }

    @Test
    public void testFindTreasureDFS() throws Exception {

        CellType[][] cells = getMaze();
        GraphNode<CellType> node = solver.findTreasureDFS(cells);

        assertThat(node.value, is(CellType.TREASURE));
    }

    @Test
    public void testFindTreasureDFSNoPath() throws Exception {

        CellType[][] cells = getUnreachableTrasure();
        GraphNode<CellType> node = solver.findTreasureDFS(cells);

        assertThat(node, nullValue());
    }

    @Test
    public void testFindTreasureBFS() throws Exception {

        CellType[][] cells = getMaze();
        GraphNode<CellType> node = solver.findTreasureBFS(cells);

        assertThat(node.value, is(CellType.TREASURE));
    }

    @Test
    public void testFindTreasureBFSNoPath() throws Exception {

        CellType[][] cells = getUnreachableTrasure();
        GraphNode<CellType> node = solver.findTreasureBFS(cells);

        assertThat(node, nullValue());
    }


    public Problem3.CellType[][] getMaze() {
        CellType[][] cells =  {
                {CellType.PATH, CellType.PATH, CellType.PATH, CellType.WALL, CellType.PATH, CellType.PATH},
                {CellType.PATH, CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL, CellType.PATH},
                {CellType.PATH, CellType.PATH, CellType.PATH, CellType.PATH, CellType.PATH, CellType.PATH},
                {CellType.PATH, CellType.PATH, CellType.WALL, CellType.PATH, CellType.WALL, CellType.WALL},
                {CellType.PATH, CellType.PATH, CellType.WALL, CellType.PATH, CellType.TREASURE, CellType.WALL},
        };
        return cells;
    }

    public CellType[][] getUnreachableTrasure() {

        CellType[][] cells =  {
                {CellType.PATH, CellType.PATH, CellType.PATH, CellType.WALL, CellType.PATH, CellType.PATH},
                {CellType.PATH, CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL, CellType.PATH},
                {CellType.PATH, CellType.PATH, CellType.PATH, CellType.PATH, CellType.PATH, CellType.PATH},
                {CellType.PATH, CellType.PATH, CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL},
                {CellType.PATH, CellType.PATH, CellType.WALL, CellType.PATH, CellType.TREASURE, CellType.WALL},
        };
        return cells;
    }

    public CellType[][] getAllWalls() {

        CellType[][] cells =  {
                {CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL},
                {CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL},
                {CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL},
                {CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL},
                {CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL, CellType.WALL},
        };

        return cells;
    }
}