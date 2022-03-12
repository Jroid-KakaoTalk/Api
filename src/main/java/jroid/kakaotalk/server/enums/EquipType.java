package jroid.kakaotalk.server.enums;

public enum EquipType implements ValuedEnum<Integer> {
    
    WEAPON(1),
    UPPER_ARMOR(2),
    LOWER_ARMOR(3),
    RINGS(6),
    GEM(7),
    AMULET(8);
    
    public static final EnumFinder<Integer, EquipType> finder = EnumFinder.getFinder(EquipType.values());
    public final int value;
    
    EquipType(int value) {
        this.value = value;
    }
    
    @Override
    public Integer getValue() {
        return this.value;
    }
    
}