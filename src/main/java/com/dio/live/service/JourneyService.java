package com.dio.live.service;

import com.dio.live.controller.dto.WorkingDayDto;
import com.dio.live.controller.form.WorkingDayUpdateForm;
import com.dio.live.controller.form.WorkingDayForm;
import com.dio.live.model.WorkingDay;
import com.dio.live.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JourneyService {
    @Autowired
    private JourneyRepository journeyRepository;

    public ResponseEntity<WorkingDayDto> saveJourney(WorkingDayForm workingDayForm) {
        WorkingDay workingDay = new WorkingDay(workingDayForm.getDescription());
        this.journeyRepository.save(workingDay);

        return ResponseEntity.ok(new WorkingDayDto(workingDay));

    }

    public List<WorkingDay> findAll() {
        return this.journeyRepository.findAll();
    }

    public ResponseEntity<WorkingDayDto> getById(Long idJourney) {
        Optional<WorkingDay> byId = this.journeyRepository.findById(idJourney);

        return byId.map(workingDay -> ResponseEntity.ok(new WorkingDayDto(workingDay))).orElseGet(() -> ResponseEntity.notFound().build());

        /*if(byId.isPresent()) {
            return ResponseEntity.ok(new WorkingDayDto(byId.get()));
        } else {
            return ResponseEntity.notFound().build();
        }*/
    }

    public ResponseEntity<WorkingDayDto> updateJourney(Long idJourney, WorkingDayUpdateForm form ) {
        Optional<WorkingDay> byId = this.journeyRepository.findById(idJourney);

        if (byId.isPresent()) {
            WorkingDay workingDay = form.update(idJourney, this.journeyRepository);
            return ResponseEntity.ok(new WorkingDayDto(workingDay));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity<WorkingDayDto> deleteJourney(Long idJourney) {
        Optional<WorkingDay> byId = this.journeyRepository.findById(idJourney);

        if (byId.isPresent()) {
            this.journeyRepository.deleteById(idJourney);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}

