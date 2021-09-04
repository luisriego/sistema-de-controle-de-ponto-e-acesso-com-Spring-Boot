package com.dio.live.controller;

import com.dio.live.controller.dto.WorkingDayDto;
import com.dio.live.controller.form.WorkingDayUpdateForm;
import com.dio.live.controller.form.WorkingDayForm;
import com.dio.live.model.WorkingDay;
import com.dio.live.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/jornada")
public class WorkingDayController {

    @Autowired
    private JourneyService journeyService;

    @PostMapping
    @Transactional
    public ResponseEntity<WorkingDayDto> createJourney(@RequestBody @Valid WorkingDayForm workingDayForm) {
        return this.journeyService.saveJourney(workingDayForm);
    }

    @GetMapping
    public List<WorkingDay> getJornadaList() {
        return this.journeyService.findAll();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<WorkingDayDto> jornadaFindById(@PathVariable("idJornada") Long idJourney) {
        return this.journeyService.getById(idJourney);
    }

    @DeleteMapping("/{idJornada}")
    @Transactional
    public ResponseEntity<WorkingDayDto> deleteJornadaFindById(@PathVariable("idJornada") Long idJourney) {
        return this.journeyService.deleteJourney(idJourney);
    }

    @PutMapping("/{idJornada}")
    @Transactional
    public ResponseEntity<WorkingDayDto> updateJornadaFindById(@PathVariable("idJornada") Long idJourney,
                                                               @RequestBody @Valid WorkingDayUpdateForm workingDayUpdateForm) {
        return this.journeyService.updateJourney(idJourney, workingDayUpdateForm);
    }

}
