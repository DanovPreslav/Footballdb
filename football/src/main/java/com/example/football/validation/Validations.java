package com.example.football.validation;

public interface Validations {

    boolean validateTeam(String line, int lineNumber);

    boolean validatePlayer(String line, int lineNumber);
    boolean validateParticipation(String line, int lineNumber);




    boolean validateMatch(String line, int lineNumber);


}
