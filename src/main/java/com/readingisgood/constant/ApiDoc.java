package com.readingisgood.constant;

import org.springframework.security.core.parameters.P;

import javax.servlet.http.PushBuilder;
import javax.swing.plaf.PanelUI;

public class ApiDoc {

    private ApiDoc() {
    }

    public static final String BOOKS_API_NAME = "ReadingIsGoodServisleri";
    public static final String API_NAME_BOOK = "Kitap Servisleri";
    public static final String API_NAME_CUSTOMER= "Müşteri Servisleri";
    public static final String API_NAME_ORDER= "Sipariş Servisleri";
    public static final String API_NAME_STATISTIC = "İstatistik Servisleri";

    public static final class Description {

        private Description(){

        }
        public static final String SAVE_BOOK = "Kitap kayıdı oluşturma servisidir.";
        public static final String UPDATE_BOOK = "Kitap kayıdı güncelleme servisidir.";
        public static final String LIST_BOOK = "Kitap kayıdı listeleme servisidir.";
        public static final String SAVE_CUSTOMER = "Müşteri kayıdı oluşturma servisidir.";
        public static final String UPDATE_CUSTOMER = "Müşteri kayıdı güncelleme servisidir.";

        public static final String LIST_CUSTOMER = "Müşteri kayıdı listeleme servisidir.";
        public static final String GET_CUSTOMER_DETAIL = "Müşteriye ait detayları müşteri idsi ile getirir.";
        public static final String SAVE_ORDER = "Sipariş kayıdı oluşturma servisidir.";
        public static final String LIST_ORDER = "Sipariş kayıdı listeleme servisidir.";
        public static final String GET_ORDER_DETAIL = "Siparişe ait detayları sipariş idsi ile getirir.";
        public static final String STATISTIC_LIST = "Müşteriye ait toplam siparişlerin raporunu döner.";
    }

    public static final class Summary {

        private Summary(){

        }
        public static final String BOOK_SERVICE_SUMMARY = "Kitap kayıt, listeleme, guncelleme işlemlerinin yapılacağı servislerdir.";
        public static final String SAVE_BOOK = "Kitap kayıdı oluşturma servisidir.";
        public static final String UPDATE_BOOK = "Kitap kayıdı güncelleme servisidir.";
        public static final String LIST_BOOK = "Kitap kayıdı listeleme servisidir.";
        public static final String CUSTOMER_SERVICE_SUMMARY = "Müşteri kayıt, listeleme, guncelleme işlemlerinin yapılacağı servislerdir.";
        public static final String SAVE_CUSTOMER = "Müşteri kayıdı oluşturma servisidir.";
        public static final String UPDATE_CUSTOMER = "Müşteri kayıdı güncelleme servisidir.";

        public static final String LIST_CUSTOMER = "Müşteri kayıdı listeleme servisidir.";
        public static final String GET_CUSTOMER_DETAIL = "Müşteriye ait detayları müşteri idsi ile getirir.";
        public static final String ORDER_SERVICE_SUMMARY = "Sipariş kayıt, listeleme, guncelleme işlemlerinin yapılacağı servislerdir.";
        public static final String SAVE_ORDER = "Sipariş kayıdı oluşturma servisidir.";
        public static final String LIST_ORDER = "Sipariş kayıdı listeleme servisidir.";
        public static final String GET_ORDER_DETAIL = "Siparişe ait detayları sipariş idsi ile getirir.";
        public static final String STATISTIC_SUMMARY = "Müşteriye ait toplam siparişlerin raporunu veren servislerdir.";
        public static final String STATISTIC_LIST = "Müşteriye ait toplam siparişlerin raporunu döner.";
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
        public static final String ORDER_LIST = "Sipariş listesini içerir.";
        public static final String ORDER_COUNT = "Sipariş adedi bilgisidir.";
        public static final String ORDER_DATE = "Sipariş tarihi bilgisidir.";
        public static final String CUSTOMER_INFO = "İşlem yapılmak istenen müşteriye ait bilgileri içerir.";
        public static final String CUSTOMER_LIST = "Verilen kriterlere uygun müşteri listesini döner.";

        public static final String CUSTOMER_NO = "İşlem yapılmak istenen müşterinin müşteri numarasıdır.";
        public static final String CUSTOMER_NAME = "İşlem yapılmak istenen müşterinin adıdır.";
        public static final String EMAIL = "İşlem yapılmak istenen müşterinin email bilgisidir.";
        public static final String PHONE_NUMBER = "İşlem yapılmak istenen müşterinin telefon numarasıdır.";
        public static final String ADDRESS = "İşlem yapılmak istenen müşterinin adres bilgisidir.";
        public static final String IDENTITY_NUMBER = "İşlem yapılmak istenen müşterinin kimlik bilgisidir.";
        public static final String STATUS = "Kaydın durum bilgisidir.";
        public static final String START_DATE = "Sipariş tarihinin filtreleneceği tarih bilgisidir.";
        public static final String END_DATE = "Sipariş tarihinin filtreleneceği tarih bilgisidir.";

        public static final String TOTAL_ORDER_COUNT = "Toplam sipariş sayısıdır.";
        public static final String TOTAL_BOOK_COUNT = "Toplam kitap sayısıdır.";

        public static final String TOTAL_AMOUNT = "Sipariş edilen kitapların toplam fiyar bilgisidir.";
    }
}
