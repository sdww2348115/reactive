package com.sdww8591.webflux.config;

import com.sdww8591.webflux.exception.CustomerException;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;

@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {

        Map<String, Object> map = super.getErrorAttributes(
                request, includeStackTrace);

        Throwable exception = getError(request);
        if (exception != null && CustomerException.class.isInstance(exception)) {
            CustomerException customerException = (CustomerException) exception;
            map.put("status", customerException.getStatusCode());
            map.put("message", customerException.getMessage());
        } else {
            map.put("status", HttpStatus.BAD_REQUEST);
            map.put("message", "username is required");
        }

        return map;
    }
}
