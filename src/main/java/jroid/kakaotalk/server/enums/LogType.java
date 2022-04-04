package jroid.kakaotalk.server.enums;

public enum LogType implements ValuedEnum<Integer> {
    
    ERROR(0),
    MISSING_ARG(1),
    
    OBJECT_NOT_FOUND(100),
    
    MINE(1000);
    
    public static final EnumFinder<Integer, LogType> finder = EnumFinder.getFinder(LogType.values());
    private final int value;
    
    LogType(int value) {
        this.value = value;
    }
    
    @Override
    public Integer getValue() {
        return this.value;
    }
    
}
