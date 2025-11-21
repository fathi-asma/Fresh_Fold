package com.store.fresh_fold.Controller;

import com.store.fresh_fold.DAO.ServiceDAO;
import com.store.fresh_fold.Model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ServiceController {

    private ServiceDAO serviceDAO;

    // Use constructor injection (recommended)
    @Autowired
    public ServiceController(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    @GetMapping("/user/service")
    public String service(Model model) {
        List<Service> services = serviceDAO.getAllServices();
        model.addAttribute("services", services);
        return "UserService";
    }
}
