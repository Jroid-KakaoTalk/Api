package jroid.kakaotalk.server.enums;

public enum LogType implements ValuedEnum<Integer> {
    
    ERROR(0),
    MISSING_ARG(1),
    WRONG_ARG_TYPE(2),
    OBJECT_NOT_FOUND(4),
    
    MINE(1000);
    
    public static final EnumFinder<Integer, LogType> finder = EnumFinder.getFinder(LogType.values());
    public final int value;
    
    LogType(int value) {
        this.value = value;
    }
    
    @Override
    public Integer getValue() {
        return this.value;
    }
    
}