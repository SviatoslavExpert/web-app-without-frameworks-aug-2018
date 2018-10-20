package com.akhambir.controller;

import com.akhambir.web.Request;
import com.akhambir.web.ViewModel;

public interface Controller {

    ViewModel process(Request request);

}
