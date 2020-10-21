// CMSC330_Project2.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
using namespace std;

#include "expression.h"
#include "subexpression.h"
#include "symboltable.h"
#include "parse.h"

SymbolTable symbolTable;

void parseAssignments();

int main()
{
    Expression* expression;
    char paren, comma;
    string line;
    ifstream infile;
    infile.open("testCases.txt");
    while (getline(infile, line)) {
        cout << line << '\n'; //outputs the current line

        //these two lines put the put it into the cin
        stringbuf sb(line); 
        streambuf* backup = cin.rdbuf(&sb);

        cin >> paren;
        expression = SubExpression::parse();
        cin >> comma;
        parseAssignments();
        cout << "Value = " << expression->evaluate() << endl;
        
    }
    infile.close();

    return 0;
    //original code
   // cout << "Enter expression: ";
    //cin >> paren;
    //expression = SubExpression::parse();
    //cin >> comma;
    //parseAssignments();
    //cout << "Value = " << expression->evaluate() << endl;
    //return 0;
}

void parseAssignments()
{
    char assignop, delimiter;
    string variable;
    int value;
    do
    {
        variable = parseName();
        cin >> ws >> assignop >> value >> delimiter;
        symbolTable.insert(variable, value);
    } while (delimiter == ',');
}


