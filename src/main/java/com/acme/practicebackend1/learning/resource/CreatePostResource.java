package com.acme.practicebackend1.learning.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreatePostResource {
    @NotNull
    @Size(max = 100)
    private String title;

    @NotNull
    @Size(max = 250)
    private String description;

    @NotNull
    private String content;
}
