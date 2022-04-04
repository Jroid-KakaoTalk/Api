package jroid.kakaotalk.server.enums;

public enum SocketStatus implements ValuedEnum<Integer> {
    
    ERROR(0),
    SUCCESS(1),
    IGNORE(2);
    
    public static final EnumFinder<Integer, SocketStatus> finder = EnumFinder.getFinder(SocketStatus.values());
    private final int value;
    
    SocketStatus(int value) {
        this.value = value;
    }
    
    @Override
    public Integer getValue() {
        return this.value;
    }
    
}
