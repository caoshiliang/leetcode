package easy;

import org.junit.Test;

/**
 * 
 * 
 * Revisited on 9/9/2017
 * 
 * The key point is to find the programmatic feature that we could use to identify if the
 * 2 rectangles have overlap or not.
 * 
 * https://leetcode.com/problems/rectangle-area/
 * @author caos1
 * Key Points:
 *     1. Divide into 2 cases: no overlap & has overlap
 *     2. For first case, just return sum of both areas; for second case, calculate boundaries of overlapping areas
 *     then area, then minus this area (because it's calculated twice when adding areaI and areaII)
 */
public class RectangleArea {
    @Test
    public void abc() {
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaI = (C - A) * (D - B);
        int areaII = (G - E) * (H - F);
        // No overlap
        if (A >= G || C <= E || B >= H || D <= F) {
            return areaI + areaII;
        }
        int left = A < E ? E : A;
        int right = C < G ? C : G;
        int top = D < H ? D : H;
        int bottom = B < F ? F : B;
        
        return areaI + areaII - (right - left) * (top - bottom);
    }
}
