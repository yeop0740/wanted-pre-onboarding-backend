package wanted.preonboarding.backend.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wanted.preonboarding.backend.application.CreateApplicationRequest;
import wanted.preonboarding.backend.application.service.ApplicationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/application")
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createApplication(@RequestBody CreateApplicationRequest request) {
        applicationService.createApplication(request);
    }

}
