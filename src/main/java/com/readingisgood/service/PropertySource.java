package com.readingisgood.service;

public interface PropertySource {
    String get(String code, Object... args);
}
