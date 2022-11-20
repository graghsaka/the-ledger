package com.ledger.service;

import com.ledger.enums.InputCommand;
import com.ledger.factory.InputCommandFactory;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static com.ledger.constants.Constants.SPACE_REGEX;

public class FileProcessor {

    public void processFileCommands(String filePath) {

        try {
            FileInputStream stream = new FileInputStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));

            String strLine;

            while ((strLine = br.readLine()) != null) {

                String inputCommandString = strLine.split(SPACE_REGEX)[0];

                InputCommand inputCommand = InputCommand.valueOf(inputCommandString);

                InputCommandFactory inputCommandFactory = new InputCommandFactory();
                InputCommandProcessor inputCommandProcessor = inputCommandFactory.getInputCommandProcessor(inputCommand);

                inputCommandProcessor.processInputCommand(strLine.split(SPACE_REGEX,2)[1]);

            }

            stream.close();
        } catch (Exception ex) {
            System.out.println("Error occurred while processing file commands: " + ex.getMessage());
        }

    }
}
