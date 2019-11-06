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
    @Column(length = 30, nullable = false)
    private String companyNm;

    @Column(length = 10, nullable = false)
    private String ceo;

    @Column(length = 15, nullable = false)
    private String phone;

}
