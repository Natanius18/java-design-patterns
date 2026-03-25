package example.natanius.flyweight.trees;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String otherTreeData) {
        return treeTypes.computeIfAbsent(name, n -> new TreeType(n, color, otherTreeData));
    }
}
