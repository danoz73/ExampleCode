package lotr.object;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Tower extends GCompound {

	private static final int TOWER_WIDTH = 10;
	private static final int TOWER_HEIGHT = 70;
	private static final int Y_POSITION = 60;

	private String towerName;
	private Tower nextTower;
	private GRect towerRect;
	private GLabel towerLabel;

	public Tower(String name, Tower link, int xPosition, int horizontalShift) {
		towerName = name;
		nextTower = link;
		towerRect = new GRect(xPosition, Y_POSITION, TOWER_WIDTH, TOWER_HEIGHT);
		towerLabel = new GLabel(name, xPosition + TOWER_WIDTH / 2.0 - horizontalShift, TOWER_HEIGHT + 75);
	}

	public String getTowerName() {
		return towerName;
	}

	public Tower getNextTower() {
		return nextTower;
	}

	public GRect getTowerRect() {
		return towerRect;
	}

	public GLabel getTowerLabel() {
		return towerLabel;
	}
}
