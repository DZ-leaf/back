
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
public class CompanyService {

    private CompanyRepository repo;

    public Vector<Map<String,String>> findCompany(String company) {
        String str = "%" + company + "%";
        System.out.println(str);
        Vector<Map<String,String>> list = new Vector<>();
        for (Company item : repo.findByCompanyNameLike(str)) {
            Map<String,String> map = new HashMap<>();
            map.put("companyNm",item.getCompanyName());
            list.add(map);
        }
        return list;
    }
    
}
