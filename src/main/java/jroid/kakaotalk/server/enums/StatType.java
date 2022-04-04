package jroid.kakaotalk.server.enums;

import lombok.Getter;

@Getter
public enum StatType implements ValuedEnum<Integer> {
    
    MAXHP(1, 1),
    HP(2, 0),
    MAXMN(3, 2),
    MN(4, 0),
    ATK(5, 5),
    MATK(6, 5),
    AGI(7, 1),
    ATS(8, 5),
    DEF(9, 3),
    MDEF(10, 3),
    BRE(11, 2),
    MBRE(12, 2),
    DRA(13, 5),
    MDRA(14, 5),
    EVA(15, 1),
    ACC(16, 1);
    
    public static final EnumFinder<Integer, StatType> finder = EnumFinder.getFinder(StatType.values());
    private final int value;
    private final int useSp;
    
    StatType(int value, int useSp) {
        this.value = value;
        this.useSp = useSp;
    }
    
    @Override
    public Integer getValue() {
        return this.value;
    }
    
}