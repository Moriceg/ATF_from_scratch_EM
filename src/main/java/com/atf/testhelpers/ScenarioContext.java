package com.atf.testhelpers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ScenarioContext {

    @Value("${atf.evidence.path}")
    private String evidenceFolderPath;

    private String currentEvidenceFolderPath;

    public void setCurrentTestEvidencePath(){
        setCurrentEvidenceFolderPath(getEvidenceFolderPath());
    }

}
