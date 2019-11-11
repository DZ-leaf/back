package leaf.model.dto.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(schema = "company", name = "company_list")
public class Company {

    @Id
    private String companyNm;

    private String ceo;

    private String phone;

}
