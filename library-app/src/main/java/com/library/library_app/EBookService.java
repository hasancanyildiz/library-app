package com.library.library_app;

import org.springframework.stereotype.Service;

@Service
public class EBookService implements BookService {
    @Override
    public String getBookInfo(){
        return "Suç ve Ceza - Dostoyevski (EBook)";

    }
}
