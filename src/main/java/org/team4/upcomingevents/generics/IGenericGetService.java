package org.team4.upcomingevents.generics;

public interface IGenericGetService<T> {

    T getById(Long id) throws Exception;
    
}
