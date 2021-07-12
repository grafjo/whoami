package de.bitbordell.whoami;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class WhoamiDTOCreator {

    private final Environment env;

    public WhoamiDTOCreator(Environment env) {
        this.env = env;
    }

    public WhoamiDTO create(HttpHeaders headers, String httpMethod) {

        return WhoamiDTO.builder()
                .hostname(env.getProperty("HOSTNAME", "unknown"))
                .method(httpMethod)
                .headers(toList(headers))
                .build();
    }

    private List<String> toList(HttpHeaders headers) {
        return headers.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> String.format("%s: %s", entry.getKey(), entry.getValue().stream().reduce("", (a, b) -> a + b)))
                .collect(Collectors.toList());
    }
}
