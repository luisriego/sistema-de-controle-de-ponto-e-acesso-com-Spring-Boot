package com.dio.live.controller.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class WorkingDayForm {
    @NotNull @NotEmpty
    private String description;

}
