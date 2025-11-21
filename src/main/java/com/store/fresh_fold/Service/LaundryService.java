package com.store.fresh_fold.Service;

import com.store.fresh_fold.DAO.ServiceDAO;
import com.store.fresh_fold.Model.Service;

import java.util.List;


public class LaundryService {
    ServiceDAO serviceDAO;

    public List<Service>getAllServices(){
        return serviceDAO.getAllServices();
    }


}
