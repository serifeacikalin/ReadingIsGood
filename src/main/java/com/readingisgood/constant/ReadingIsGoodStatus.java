package com.readingisgood.constant;

public enum ReadingIsGoodStatus implements BaseEnum<ReadingIsGoodStatus, String>{

    AKTIF("1", "Aktif"),
    PASIF("0", "Pasif"),
    IPTAL("2", "İptal");

    private String value;
    private String text;

    ReadingIsGoodStatus(String value, String text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String getText() {
        return this.text;
    }

    public static ReadingIsGoodStatus getEnum(String value){
        if(value == null){
            return null;
        }

        for(ReadingIsGoodStatus type : ReadingIsGoodStatus.values()){
            if(value.equals(type.getValue())){
                return type;
            }
        }
        return null;
    }
}
