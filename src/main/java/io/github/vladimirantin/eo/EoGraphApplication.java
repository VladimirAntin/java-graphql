package io.github.vladimirantin.eo;

import com.github.vladimirantin.core.annotation.DisableCoreSecurity;
import com.github.vladimirantin.core.annotation.EnableAudit;
import com.github.vladimirantin.core.annotation.EnableSoftDeleteEvents;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAudit
@EnableSoftDeleteEvents
@DisableCoreSecurity
public class EoGraphApplication {

    public static void main(String[] args) {
        SpringApplication.run(EoGraphApplication.class, args);
    }

}
