package jroid.kakaotalk.server.enums.object;

import jroid.kakaotalk.server.base.Location;
import jroid.kakaotalk.server.enums.EnumFinder;
import jroid.kakaotalk.server.enums.MapType;
import jroid.kakaotalk.server.enums.ValuedEnum;
import org.springframework.lang.NonNull;

public enum GameMapEnum implements ValuedEnum<Integer> {
    START_VILLAGE(63, 63, 1, MapType.VILLAGE),
    QUIET_BEACH(64, 63, 1, MapType.SEA),
    ADVENTURE_FIELD(64, 64, 1, MapType.FIELD);
    
    public static final EnumFinder<Integer, GameMapEnum> finder =
        EnumFinder.getFinder(GameMapEnum.values());
    
    public final int location;
    public final int requireLv;
    public final MapType mapType;
    
    GameMapEnum(int x, int y, int requireLv, @NonNull MapType mapType) {
        this.location = Location.toHex(x, y);
        this.requireLv = requireLv;
        this.mapType = mapType;
    }
    
    @Override
    public Integer getValue() {
        return this.location;
    }
    
    @NonNull
    public static GameMapEnum find(int x, int y) {
        return finder.find(Location.toHex(x, y));
    }
    
}
