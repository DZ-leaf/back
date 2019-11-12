
package leaf.service.company;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import leaf.model.dao.company.CompanyRepository;
import leaf.model.dto.company.Company;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

@AllArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository repo;

    public Vector<Map<String,String>> findCompany(String company) {
        String str = "%" + company + "%";
        System.out.println(str);
        Vector<Map<String,String>> list = new Vector<>();
        for (Company item : repo.findByCompanyNmLike(str)) {
            Map<String,String> map = new HashMap<>();
            map.put("companyNm",item.getCompanyNm());
            list.add(map);
        }
        return list;
    }
    
}
