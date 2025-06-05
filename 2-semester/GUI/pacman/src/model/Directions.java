package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Directions {
    public static int[] UP = {0, -1};
    public static int[] DOWN = {0, 1};
    public static int[] LEFT = {-1, 0};
    public static int[] RIGHT = {1, 0};
    public static int[][] directionsArr = {UP, DOWN, LEFT, RIGHT};
    public static ArrayList<int[]> directionsList = new ArrayList<>(Arrays.asList(directionsArr));
}
