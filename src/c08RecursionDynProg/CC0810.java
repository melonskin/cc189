package c08RecursionDynProg;

/*
 * Paint fill
 */
public class CC0810 {
    enum Color {Black, White, Red}

    public void paintFill(Color[][] screen, int r, int c, Color newColor) {
        if (screen[r][c] == newColor) {
            return;
        }
        paintFill(screen, r, c, screen[r][c], newColor);
    }
    private void paintFill(Color[][] screen, int r, int c, Color oldColor, Color newColor) {
        if (r < 0 || r > screen.length - 1 || c < 0 || c > screen[0].length - 1) {
            return;
        }
        if (screen[r][c] == oldColor) {
            screen[r][c] = newColor;
            paintFill(screen, r - 1, c, oldColor, newColor);
            paintFill(screen, r + 1, c, oldColor, newColor);
            paintFill(screen, r, c - 1, oldColor, newColor);
            paintFill(screen, r, c + 1, oldColor, newColor);
        }
    }
}
