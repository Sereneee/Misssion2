package com.example.Mission2;

import lombok.NonNull;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Pet
{
    @NonNull private String id;
    private String name;
    @Nullable private int age;
    @Nullable private String type;

    public Pet(String id, String name, int age, String type)
    {
        this.id = id;
        this.name = name;
        this.age= age;
        this.type = type;
    }
}
