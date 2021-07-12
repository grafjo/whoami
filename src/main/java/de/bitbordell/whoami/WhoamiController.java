package de.bitbordell.whoami;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WhoamiController {

    private final WhoamiDTOCreator creator;

    public WhoamiController(WhoamiDTOCreator creator) {
        this.creator = creator;
    }

    @GetMapping("/")
    public ResponseEntity<WhoamiDTO> root(@RequestHeader HttpHeaders headers, HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(creator.create(headers, httpServletRequest.getMethod()));
    }

}
