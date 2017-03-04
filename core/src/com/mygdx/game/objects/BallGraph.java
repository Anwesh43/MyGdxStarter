package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Pixmap;
import com.sun.javafx.image.PixelAccessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 24/09/16.
 */
public class BallGraph {
    private List<VertexBall> vertices = new ArrayList<VertexBall>();
    private List<LinePath> edges = new ArrayList<LinePath>();

    public void draw(Pixmap pixmap) {
        for(VertexBall ball:vertices) {
            ball.draw(pixmap);
        }
        for(LinePath edge:edges) {
            edge.draw(pixmap);
        }

    }
    public void addEdges(LinePath path) {
        edges.add(path);
    }
    public void addVertices(VertexBall vertexBall) {
        vertices.add(vertexBall);
    }
}
