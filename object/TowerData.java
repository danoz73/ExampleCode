package lotr.object;

public class TowerData {
	
	private final Coordinate mCoordinate;
	private final String mName;
	
	public TowerData(Coordinate coordinate, String name) {
		mCoordinate = coordinate;
		mName = name;
	}
	
	public Coordinate getCoordinate() {
		return mCoordinate;
	}
	
	public String getName() {
		return mName;
	}

}
