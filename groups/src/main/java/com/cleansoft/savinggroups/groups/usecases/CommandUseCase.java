package com.cleansoft.savinggroups.groups.usecases;

public interface CommandUseCase<I> {

    void execute(I request);
}
