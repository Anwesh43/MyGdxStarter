package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 23/03/17.
 */
public class AnimationQueue {
    private List<ObjectAnimation> animations = new ArrayList<ObjectAnimation>();
    public void addAnimation(ObjectAnimation objectAnimation) {
        animations.add(objectAnimation);
    }
    public void execute() {
        if(animations.size()>0) {
            ObjectAnimation objectAnimation = animations.get(0);
            objectAnimation.animate();
            if(objectAnimation.isDone()) {
                animations.remove(objectAnimation);
            }
            try {
                Thread.sleep(40);
            }
            catch (Exception ex) {

            }
        }
    }
}
