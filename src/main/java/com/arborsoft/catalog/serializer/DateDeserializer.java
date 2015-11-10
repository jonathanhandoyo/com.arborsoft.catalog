package com.arborsoft.catalog.serializer;

import com.arborsoft.catalog.constant.AppConstant;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeserializer extends JsonDeserializer<Date> {
    private static final Logger LOG = LoggerFactory.getLogger(DateDeserializer.class);

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        String text = jsonParser.getText();
        if (StringUtils.isNotBlank(text)) {
            try {
                return new SimpleDateFormat(AppConstant.Format.DATE_LONG).parse(text);
            } catch (ParseException e) {
                LOG.error(e.getMessage(), e);
            }
        }

        return null;
    }
}
