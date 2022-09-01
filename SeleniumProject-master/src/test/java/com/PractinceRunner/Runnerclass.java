package com.PractinceRunner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions
        (features = {"src/test/resources/features"}, //Provide path for feature files
		glue = {"com.StepDefination"}, // provide path for step defination or java classes  
		plugin = {"pretty","html:target/cucumber-html-report"}, // Genrating test exacution report / or genrating BDD Report 
		dryRun = false,//if set to true check if all steps have steps defination// make sure all steps are implemented and and also if you set true not lunching the browser
		monochrome =true,// if set true display the consol in the readable language, if set false display unreadable language. Monochrome  also used to provide  proper alignment text in the consol. 
		tags = {"@Main"}// By using Tag we are able to exucte specific scenario/ Tag - help us to filter N-number of scenarios 
			

        //tags = {"@Login, @Main, @Register, @Flight"  These tags help us to execute all existance test cases 
		
		
)
public class  Runnerclass {

}
