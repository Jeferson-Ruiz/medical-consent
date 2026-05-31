package com.jr.consentimiento.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.jr.consentimiento.service.IDataPreparationService;

@Service
public class DataPreparationService implements IDataPreparationService {

    private final String REMPLACE_NULL = "N/E";

    // Cambia los valores vacion por N/E
    public Map<String, String> dateNull(Map<String, String> date) {

        Map<String, String> newDate = new HashMap<>();

        for (String point : date.keySet()) {
            String value = date.get(point);
            boolean isEmpy = value == null || value.trim().isEmpty();
            newDate.put(point, isEmpy ? REMPLACE_NULL : value.trim());
        }
        return newDate;
    }
}
