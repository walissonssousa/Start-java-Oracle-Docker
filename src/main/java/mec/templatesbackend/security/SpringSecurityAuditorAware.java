package mec.templatesbackend.security;

import mec.templatesbackend.config.Constants;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpringSecurityAuditorAware  implements AuditorAware {

    @Override
    public Optional<String> getCurrentAuditor(){
        return Optional.of(SecurityUtils.getCurrentUserLogin().orElse(Constants.SYSTEM));
    }

}
