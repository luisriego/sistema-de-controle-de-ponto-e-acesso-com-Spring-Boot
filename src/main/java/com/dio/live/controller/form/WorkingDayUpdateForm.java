package com.dio.live.controller.form;

import com.dio.live.model.WorkingDay;
import com.dio.live.repository.JourneyRepository;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class WorkingDayUpdateForm {
    @NotNull @NotEmpty
    public String description;

    public WorkingDay update(Long idJourney, JourneyRepository journeyRepository) {
        WorkingDay workingDay = journeyRepository.getOne(idJourney);
        workingDay.setDescription(this.description);
        return workingDay;
    }

}
