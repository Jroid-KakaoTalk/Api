package jroid.kakaotalk.server.enums;

public enum MapType implements ValuedEnum<Integer> {
    
    VILLAGE(1),
    FIELD(2),
    RIVER(3),
    SEA(4);
    
    public static final EnumFinder<Integer, MapType> finder = EnumFinder.getFinder(MapType.values());
    public final int value;
    
    MapType(int value) {
        this.value = value;
    }
    
    @Override
    public Integer getValue() {
        return this.value;
    }
    
}