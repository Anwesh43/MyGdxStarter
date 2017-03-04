package com.mygdx.game.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 11/09/16.
 */
public class BallTouchStore {
    public List<BallTouchData> touchesData = new ArrayList<BallTouchData>();

}
class BallTouchData {
    private float x,y;
    private long time_gap,initial_time;
}