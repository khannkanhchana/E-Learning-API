package co.istad.kanhchana.elearninga01m1.features.auth.dto;


import lombok.Getter;

@Getter
public enum GenderOptions {
    FEMALE("Female"),
    MALE("Male"),
    OTHER("Other");


    private final String gender;
    GenderOptions(String gender) {
        this.gender = gender;
    }


}
