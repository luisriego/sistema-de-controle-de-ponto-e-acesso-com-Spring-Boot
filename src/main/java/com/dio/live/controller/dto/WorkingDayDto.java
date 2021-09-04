package com.dio.live.controller.dto;

import com.dio.live.model.WorkingDay;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WorkingDayDto {
    private Long id;
    private String description;

    public WorkingDayDto(WorkingDay workingDay) {
        this.id = workingDay.getId();
        this.description = workingDay.getDescription();
    }



}
