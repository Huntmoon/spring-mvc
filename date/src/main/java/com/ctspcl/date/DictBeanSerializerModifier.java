package com.ctspcl.date;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DictBeanSerializerModifier extends BeanSerializerModifier {
    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
        List<BeanPropertyWriter> dictPropertyWriter = beanProperties
                .stream()
                .filter(beanPropertyWriter -> beanPropertyWriter.getAnnotation(Dict.class) != null)
                .map(beanPropertyWriter -> new DictBeanPropertyWriter(beanPropertyWriter, PropertyName.construct(beanPropertyWriter.getName() + "DictName")))
                .collect(Collectors.toList());

        Set<String> dictNameSet = dictPropertyWriter.stream().map(BeanPropertyWriter::getName).collect(Collectors.toSet());

        List<BeanPropertyWriter> result = beanProperties.stream().filter(beanPropertyWriter -> !dictNameSet.contains(beanPropertyWriter.getName()))
                .collect(Collectors.toList());
        result.addAll(dictPropertyWriter);
        return result;
    }
}
