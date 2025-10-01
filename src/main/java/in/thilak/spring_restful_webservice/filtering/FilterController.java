package in.thilak.spring_restful_webservice.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {


    @GetMapping("/filter")
    public Filter getFilter() {
        return new Filter("value1", "value2", "value3");
    }

    @GetMapping("/filter-list")
    public Filter[] getFilterList() {
        return new Filter[] { new Filter("value1", "value2", "value3"), new Filter("value4", "value5", "value6") };
    }


}
