package com.arborsoft.catalog.serializer;

import com.arborsoft.catalog.constant.AppConstant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat(AppConstant.Format.DATE_LONG);
        String formattedDate = formatter.format(value);
        gen.writeString(formattedDate);
    }
}
