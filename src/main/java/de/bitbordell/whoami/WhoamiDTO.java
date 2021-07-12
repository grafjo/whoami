package de.bitbordell.whoami;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class WhoamiDTO {

    private final String hostname;
    private final String method;
    private final String remoteAddress;
    private final List<String> headers;

}
