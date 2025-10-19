package br.com.andrew.anime.anime.entities.enums;

public enum Gender {
    MALE(1),
    FEMALE(2);

    private int code;

    Gender(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }

    public static Gender valueOf(int code){
        for (Gender valuesGender : Gender.values()){
            if (valuesGender.getCode() == code){
                return valuesGender;
            }
        }

        throw new IllegalArgumentException();
    }


}
