package com.Galeto.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"


        },

        features = "src/test/resources/Features",
        glue = "com/Galeto/stepDefinitions",
        dryRun = false,
        tags = "",
        publish = true



)

public class CukesRunner {



}
