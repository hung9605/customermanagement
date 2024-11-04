package com.app.customermanagement.controller;

import com.app.customermanagement.constants.AppHttpStatus;
import com.app.customermanagement.dto.response.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

    public static final String ERROR = "error";
    public static final String RESPONSE_NULL = "Response null!";
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected ResponseEntity<ResponseBean> response(ResponseBean responseBean) {
        if (responseBean == null) {
            throw new IllegalArgumentException(RESPONSE_NULL);
        }
        return new ResponseEntity<ResponseBean>(responseBean, HttpStatus.OK);
    }

    protected ResponseEntity<ResponseBean> responseError(ResponseBean responseBean, Exception exception) {
        logger.error(ERROR, exception);
        responseBean.setData(null);
        responseBean.setStatus(AppHttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<ResponseBean>(responseBean, HttpStatus.OK);
    }


}
