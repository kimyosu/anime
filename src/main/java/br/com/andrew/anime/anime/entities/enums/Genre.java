package br.com.andrew.anime.anime.entities.enums;

public enum Genre {
    ACAO(1),
    AVENTURA(2),
    COMEDIA(3),
    DRAMA(4),
    FANTASIA(5),
    FICCAO_CIENTIFICA(6),
    ROMANCE(7),
    SUSPENSE(8),
    TERROR(9);

    private int code;

    private Genre(int code){
        this.code = code;
    }


    public Gender valueOf(int code){ //Retorna o Gender com base no codigo
        for (Gender valueGender : Gender.values()){
            if (code == valueGender.getCode()){ //.getCode() pega o codigo do Gender atual
                return valueGender;
            }
        }
        throw new IllegalArgumentException();
    }
}
