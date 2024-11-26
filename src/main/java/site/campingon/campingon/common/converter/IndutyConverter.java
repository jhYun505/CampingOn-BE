package site.campingon.campingon.common.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import site.campingon.campingon.camp.entity.Induty;

@Converter(autoApply = true) // autoApply를 true로 설정하면 해당 타입에 대해 자동으로 변환
public class IndutyConverter implements AttributeConverter<Induty, String> {

    @Override
    public String convertToDatabaseColumn(Induty attribute) {
        return attribute.getType(); // "자동차야영장" 값으로 저장
    }

    @Override
    public Induty convertToEntityAttribute(String dbData) {
        for (Induty induty : Induty.values()) {
            if (induty.getType().equals(dbData)) {
                return induty;
            }
        }
        throw new IllegalArgumentException("Unknown database value: " + dbData);    //todo 커스텀 예외처리
    }
}