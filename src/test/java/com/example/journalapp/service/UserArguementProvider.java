package com.example.journalapp.service;

import com.example.journalapp.entity.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

public class UserArguementProvider implements ArgumentsProvider{
    @Disabled
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(User.builder().userName("Jony").password("@121").build()),
                Arguments.of(User.builder().userName("Cobra").password("").build())
        );
    }
}
