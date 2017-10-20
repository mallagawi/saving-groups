package com.cleansoft.savago.groups.usecases;

public interface CommandUseCase<I> {

    void execute(I request);
}
