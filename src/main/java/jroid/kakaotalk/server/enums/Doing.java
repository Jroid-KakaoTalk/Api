package jroid.kakaotalk.server.enums;

public enum Doing implements ValuedEnum<Integer> {
    
    NONE(0),
    MINE(1);
    
    public static final EnumFinder<Integer, Doing> finder = EnumFinder.getFinder(Doing.values());
    public final int value;
    
    Doing(int value) {
        this.value = value;
    }
    
    @Override
    public Integer getValue() {
        return this.value;
    }
    
}