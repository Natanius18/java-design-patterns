package example.natanius.flyweight;

import example.natanius.flyweight.forest.Forest;
import java.awt.Color;
import java.util.Random;

public class Demo {
    private static final int CANVAS_SIZE = 800;
    private static final int TREES_TO_DRAW = 1_000_000;
    private static final int TREE_TYPES = 2;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Forest forest = new Forest();
        for (int i = 0; i < Math.floor((double) TREES_TO_DRAW / TREE_TYPES); i++) {
            forest.plantTree(random(), random(),
                    "Summer Oak", Color.GREEN, "Oak texture stub");
            forest.plantTree(random(), random(),
                    "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
        }
        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
        forest.setVisible(true);

        System.out.println(TREES_TO_DRAW + " trees drawn");
        System.out.println("---------------------");
        System.out.println("Memory usage:");
        System.out.println("Tree size (8 bytes) * " + TREES_TO_DRAW);
        System.out.println("+ TreeTypes size (~30 bytes) * " + TREE_TYPES);
        System.out.println("---------------------");
        System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
                "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");
    }

    private static int random() {
        return (RANDOM.nextInt((CANVAS_SIZE) + 1));
    }
}
