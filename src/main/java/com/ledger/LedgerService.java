package com.ledger;

import com.ledger.service.FileProcessor;

import java.util.Scanner;

public class LedgerService {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String filePath= sc.nextLine();
        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.processFileCommands(filePath);
    }
}
