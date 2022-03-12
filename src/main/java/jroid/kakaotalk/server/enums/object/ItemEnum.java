package jroid.kakaotalk.server.enums.object;

import jroid.kakaotalk.server.enums.EnumFinder;
import jroid.kakaotalk.server.enums.ValuedEnum;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public enum ItemEnum implements ValuedEnum<Long> {
    
    STONE(1, "길에 굴러다니는 흔한 돌이다");
    
    public static final EnumFinder<Long, ItemEnum> finder = EnumFinder.getFinder(ItemEnum.values());
    
    public final long value;
    public final String des;
    public final String gainDes;
    public final String useDes;
    public final String eatDes;
    
    ItemEnum(int value, @NonNull String des) {
        this(value, des, null, null, null);
    }
    
    ItemEnum(int value, @NonNull String des, @Nullable String gainDes,
             @Nullable String useDes, @Nullable String eatDes) {
        this.value = value;
        this.des = des;
        this.gainDes = gainDes;
        this.useDes = useDes;
        this.eatDes = eatDes;
    }
    
    @Override
    public Long getValue() {
        return this.value;
    }
    
}
