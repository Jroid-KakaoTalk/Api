package jroid.kakaotalk.server.enums.object;

import jroid.kakaotalk.server.base.Location;
import jroid.kakaotalk.server.enums.EnumFinder;
import jroid.kakaotalk.server.enums.MapType;
import jroid.kakaotalk.server.enums.ValuedEnum;
import lombok.Getter;
import org.springframework.lang.NonNull;

@Getter
public enum GameMapEnum implements ValuedEnum<Integer> {
    START_VILLAGE(63, 63, 1, MapType.VILLAGE),
    QUIET_BEACH(64, 63, 1, MapType.SEA),
    ADVENTURE_FIELD(64, 64, 1, MapType.FIELD);
    
    private static final EnumFinder<Integer, GameMapEnum> finder = EnumFinder.getFinder(GameMapEnum.values());
    
    private final int location;
    private final int requireLv;
    private final MapType mapType;
    
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
