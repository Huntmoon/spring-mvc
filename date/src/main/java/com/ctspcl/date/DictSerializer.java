package com.ctspcl.date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @author wangtao
 * @since 2018/5/30
 */
public class DictSerializer<Object> extends StdScalarSerializer<Object> implements ContextualSerializer {
    private String dict;
    private String propertyName;
    protected DictSerializer() {
        super(null);
    }

    protected DictSerializer(Class<Object> t) {
        super(t);
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        DictFormat annotation = property.getAnnotation(DictFormat.class);
        dict = annotation.dict();
        propertyName = property.getName();
        return this;
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.toString());
        gen.writeStringField(StringUtils.hasText(dict)?dict:propertyName+"DictName",value+"Dict");
    }
}
