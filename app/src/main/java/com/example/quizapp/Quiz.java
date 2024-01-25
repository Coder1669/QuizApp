package com.example.quizapp;

public class Quiz {

    public static String questions[] ={
            "What does HTML stand for?",
            "Which of the following statements correctly declares and initializes an integer variable in Python?",
            "What does the term IDE stand for?",
            "What is the purpose of the elif keyword in Python?",
            "Which operator is used for exponentiation in Python?",
            "  What does the term API stand for?"
    };

    public static String choices[][] ={

            {"Hyper Trainer Marking Language","Hyper Text Marketing Language","Hyper Text Markup Language", "Hyper Text Markup Leveler"},
            { "integer x = 5;", "x = int(5);", "int x = 5", "x = 5"},
            {"Integrated Development Environment", " Intelligent Design Engine", "Interactive Development Environment", "Integrated Design Environment"},
            {"It represents the end of an if-else block.","It is short for else if and is used for multiple conditional statements.","It is used to define a function."," It is a typo and not a valid keyword."},
            { "^", "**", "*^ ", "//"},
            { "Application Programming Interface", "Advanced Programming Interface", "Application Process Integration", " Advanced Process Interface"}

    };

    public static String correctAnswer[]={
            "Hyper Text Markup Language",
            "x = 5",
            "Integrated Development Environment",
            "It is short for \"else if\" and is used for multiple conditional statements.",
            "**",
            "Application Programming Interface"

    };
}
