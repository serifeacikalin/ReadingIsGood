package com.readingisgood.infra;

import com.readingisgood.service.MapperService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapperServiceImpl implements MapperService {

    private ModelMapper modelMapper;

    public MapperServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true);
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        return source == null ? null : modelMapper.map(source, destinationType);
    }

    @Override
    public <S, D> List<D> map(List<S> source, Class<D> destinationType) {
        List<D> destination = new ArrayList<>();

        for(S element : source){
            destination.add(map(element,destinationType));
        }
        return destination;
    }
}
