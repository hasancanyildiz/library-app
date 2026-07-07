package com.library.library_app;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Primary
@Service
public class NormalBookService implements BookService{
    @Override
    public String getBookInfo(){
        return "Suç ve Ceza - Dostoyevski";

    }
}
