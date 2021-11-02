package com.example.kindergarten.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class EntityOrDtoConverter {

    private final ModelMapper modelMapper;

    public EntityOrDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public <S, T> T converter(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }

    public <S, T> List<T> convertList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
