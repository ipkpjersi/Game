package orsc.enumerations;

public enum ORSCharacterDirection {
	NORTH(0, 0, -1),
	NORTH_WEST(1, 1, -1),
	WEST(2, 1, 0),
	SOUTH_WEST(3, 1, 1),
	SOUTH(4, 0, 1),
	SOUTH_EAST(5, -1, 1),
	EAST(6, -1, 0),
	NORTH_EAST(7, -1, -1),
	COMBAT_A(8, 0, 0),
	COMBAT_B(9, 0, 0);
	private static final ORSCharacterDirection[] rsDir_Lookup;

	static {
		int max = 0;
		for (ORSCharacterDirection c : values())
			max = Math.max(max, c.rsDir + 1);
		rsDir_Lookup = new ORSCharacterDirection[max];
		for (ORSCharacterDirection c : values())
			rsDir_Lookup[c.rsDir] = c;
	}

	public final int x0, z0;
	public final int rsDir;

	private ORSCharacterDirection(int rsDir, int x0, int z0) {
		this.rsDir = rsDir;
		this.x0 = x0;
		this.z0 = z0;
	}

	public static ORSCharacterDirection lookup(int rsDir) {
		if (rsDir >= 0 && rsDir < rsDir_Lookup.length)
			return rsDir_Lookup[rsDir];
		for (ORSCharacterDirection c : values())
			if (c.rsDir == rsDir)
				return c;
		System.out.println("Lookup fail: " + rsDir);
		return null;
	}
}
