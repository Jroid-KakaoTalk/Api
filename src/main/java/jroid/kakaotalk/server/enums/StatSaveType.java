package jroid.kakaotalk.server.enums;

public enum StatSaveType implements ValuedEnum<Integer> {
    
    BASIC(1),
    SP(2),
    EQUIP(3),
    BUFF(4);
    
    public static final EnumFinder<Integer, StatSaveType> finder = EnumFinder.getFinder(StatSaveType.values());
    private final int value;
    
    StatSaveType(int value) {
        this.value = value;
    }
    
    @Override
    public Integer getValue() {
        return this.value;
    }
    
}