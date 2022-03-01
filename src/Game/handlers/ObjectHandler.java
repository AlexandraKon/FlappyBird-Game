package Game.handlers;

import Game.supers.GameObject;

import java.awt.Graphics;
import java.util.LinkedList;

public class ObjectHandler {
    public static LinkedList<GameObject> list = new LinkedList<GameObject>();

    public static void addObject(GameObject o) {
        list.add(o);
    }

    public static void removeObject(GameObject o) {
        list.remove(o);
    }

    public static void render(Graphics g) {
        GameObject temp = null;

        for (int i = 0; i< list.size(); i++) {
            temp = list.get(i);
            temp.render(g);
        }
    }
    public static void tick() {
        GameObject temp = null;

        for (int i=0; i < list.size(); i++) {
            temp = list.get(i);
            temp.tick();
        }
    }
}




