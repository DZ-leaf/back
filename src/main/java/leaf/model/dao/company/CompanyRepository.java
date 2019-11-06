package leaf.model.dao.company;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import leaf.model.dto.company.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {

    List<Company> findByCompanyNmLike(String companyNm);

}
