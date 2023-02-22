package dev.codefactory;

import io.micronaut.http.annotation.*;

@Controller("/sampleCodeJava")
public class SampleCodeJavaController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}