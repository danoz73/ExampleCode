package lotr;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import acm.program.GraphicsProgram;
import lotr.object.Coordinate;
import lotr.object.Tower;
import lotr.object.TowerData;

public class LotrGame extends GraphicsProgram {
	
	private static final long LIGHTING_DELAY_BETWEEN_TOWERS = 500;
	private static final List<TowerData> TOWER_DATA = Collections.unmodifiableList(
			Arrays.asList(
					new TowerData(new Coordinate(630, 18), "Rohan"),
					new TowerData(new Coordinate(560, 26), "Halifirien"),
					new TowerData(new Coordinate(490, 26), "Calenhad"),
					new TowerData(new Coordinate(420, 38), "Min-Rimmon"),
					new TowerData(new Coordinate(350, 17), "Erelas"),
					new TowerData(new Coordinate(280, 20), "Nardal"),
					new TowerData(new Coordinate(210, 23), "Eilenach"),
					new TowerData(new Coordinate(140, 27), "Amon Din"),
					new TowerData(new Coordinate(70, 35), "Minas Tirith")
					)
			);
	private final List<Tower> mTowers = new ArrayList<>(TOWER_DATA.size());

	public void run() {
		createSignalTowers();
		addMouseListeners();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Tower lastTower = mTowers.get(mTowers.size() - 1);
		if (lastTower.getTowerRect().contains(e.getX(), e.getY())) {
			signal();
		}
	}

	public void signal() {
		Timer signalLightingTimer = new Timer();
		long taskScheduleDelay = 0;
		for (int towerNum = mTowers.size() - 1; towerNum >= 0; towerNum--) {
			final Tower towerToLight = mTowers.get(towerNum);
			TimerTask lightTowerTask = new TimerTask() {
				@Override
				public void run() {
					lightTower(towerToLight);
				}

			};

			signalLightingTimer.schedule(lightTowerTask, taskScheduleDelay);
			taskScheduleDelay += LIGHTING_DELAY_BETWEEN_TOWERS;
		}
	}

	public void lightTower(Tower tower) {
		tower.getTowerRect().setFillColor(Color.RED);
		tower.getTowerRect().setFilled(true);
	}

	private void createSignalTowers() {
		Tower previousTower = null;
		for (TowerData towerData : TOWER_DATA) {
			Tower newTower = new Tower(
					towerData.getName(),
					previousTower,
					towerData.getCoordinate().getX(),
					towerData.getCoordinate().getY()
					);
			add(newTower.getTowerRect());
			add(newTower.getTowerLabel());
			mTowers.add(newTower);
			previousTower = newTower;
		}
	}
}
