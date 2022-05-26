package com.acme.practicebackend1.learning.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateCommentResource {
    private Long id;

    @NotNull
    private String text;
}
