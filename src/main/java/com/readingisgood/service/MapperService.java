package com.readingisgood.service;

import java.util.List;

public interface MapperService {

    <D> D map(Object source, Class<D> destinationType);

    <S,D> List<D> map(List<S> source, Class<D> destinationType);
}
