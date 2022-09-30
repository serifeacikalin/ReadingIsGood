package com.readingisgood.constant;

import javax.servlet.http.PushBuilder;

public class ApiDoc {

    private ApiDoc() {

    }

    public static final String BOOKS_API_NAME = "ReadingIsGoodServisleri";

    public static final String API_NAME_BOOK = "Kitap Servisleri";

    public static final String API_NAME_CUSTOMER= "Müşteri Servisleri";

    public static final String API_NAME_ORDER= "Sipariş Servisleri";

    public static final class Description {

        private Description(){

        }

        public static final String SAVE_BOOK = "Kitap kayıdı oluşturma servisidir.";

        public static final String UPDATE_BOOK = "Kitap kayıdı güncelleme servisidir.";

        public static final String LIST_BOOK = "Kitap kayıdı listeleme servisidir.";
    }

    public static final class Summary {

        private Summary(){

        }

        public static final String BOOK_SERVICE_SUMMARY = "Kitap kayıt, listeleme, guncelleme işlemlerinin yapılacağı servislerdir.";
        public static final String SAVE_BOOK = "Kitap kayıdı oluşturma servisidir.";
        public static final String UPDATE_BOOK = "Kitap kayıdı güncelleme servisidir.";
        public static final String LIST_BOOK = "Kitap kayıdı listeleme servisidir.";
    }


    public static final class Fields {

        private Fields(){

        }

        public static final String BOOK_INFO = "İşlem yapılmak istenen kitaba ait bilgileri içerir.";

        public static final String BOOK_LIST = "Verilen kriterlere uygun kitap listesini döner.";
        public static final String BOOK_NO = "İşlem yapılmak istenen kitabın kitap numarasıdır.";
        public static final String BOOK_NAME = "İşlem yapılmak istenen kitabın adıdır.";
        public static final String AUTHOR_NAME = "İşlem yapılmak istenen kitabın yazarının adıdır.";
        public static final String PUBLICATION_YEAR = "İşlem yapılmak istenen kitabın basım tarihidir.";
        public static final String STOCK = "İşlem yapılmak istenen kitabın stok adedidir.";
        public static final String AMOUNT = "İşlem yapılmak istenen kitabın fiyatıdır.";
        public static final String CREATED_USER = "İşlemi yapan kullanıcı bilgisidir.";
        public static final String ORDER_INFO = "İşlem yapılmak istenen siparişe ait bilgileri içerir.";

        public static final String ORDER_NO = "İşlem yapılmak istenen siparişin numarasıdır.";

        public static final String ORDER_COUNT = "Sipariş adedi bilgisidir.";
    }
}
