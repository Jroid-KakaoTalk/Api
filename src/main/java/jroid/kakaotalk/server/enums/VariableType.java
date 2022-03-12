package jroid.kakaotalk.server.enums;

public enum VariableType implements ValuedEnum<Integer> {
    
    MINE_LV(1);
    
    public static final EnumFinder<Integer, VariableType> finder = EnumFinder.getFinder(VariableType.values());
    public final int value;
    
    VariableType(int value) {
        this.value = value;
    }
    
    @Override
    public Integer getValue() {
        return this.value;
    }
    
}