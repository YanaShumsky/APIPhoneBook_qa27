package dto;

import java.util.List;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString

public class GetAllContactsDto {
    List<ContactsDto>contacts;
}
