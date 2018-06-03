package com.ctspcl.date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;

public class DictBeanPropertyWriter extends BeanPropertyWriter {
    public DictBeanPropertyWriter(BeanPropertyWriter base, PropertyName name) {
        super(base, name);

    }

    @Override
    public void serializeAsField(Object bean, JsonGenerator gen, SerializerProvider prov) throws Exception {

        super.serializeAsField(bean, gen, prov);
    }
}
