package site.campingon.campingon.reservation.dto;

import lombok.*;

@Getter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CampResponseDto {

    private Long id;

    private String campName;

    private String thumbImage;
}
