package io.github.mateiaru.android.madrun;
import com.badlogic.gdx.Gdx;

public class GdxUtils {
	
	public static final int BUTTON_NONE     = 0x00000000;
	public static final int BUTTON_PLAY     = 0x00000052;
	public static final int BUTTON_SETTINGS = 0x00001579;
	public static final int BUTTON_QUIT     = 0x152f1579;
	
	public static int getPressedButton(int x, int y) {
		if (x >= 15 && x <= (Gdx.graphics.getWidth() - 15)) {
			if (isBetween(y, 200, 280)) return BUTTON_PLAY;
			if (isBetween(y, 300, 380)) return BUTTON_SETTINGS;
			if (isBetween(y, 400, 480)) return BUTTON_PLAY;
		}
		return BUTTON_NONE;
	}
	
	private static boolean isBetween(int number, int first, int second) {
		return ((number > first) && (number < second));
	}
	
}
