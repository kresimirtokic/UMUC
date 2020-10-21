#include <iostream>
using namespace std;

#include "expression.h"
#include "subexpression.h"
#include "operand.h"
#include "plus.h"
#include "minus.h"
#include "times.h"
#include "divide.h"
#include "and.h"
#include "or.h"
#include "GreaterThan.h"
#include "lessThan.h"
#include "equals.h"
#include "not.h"
#include "ternary.h"

SubExpression::SubExpression(Expression* left, Expression* right)
{
    this->left = left;
    this->right = right;
}

SubExpression::SubExpression(Expression* left, Expression* right, Expression* third) {
    this->left = left;
    this->right = right;
    this->third = third;
}

Expression* SubExpression::parse()
{
    Expression* left;
    Expression* right;
    Expression* third;
    char operation, paren;

    left = Operand::parse();
    cin >> operation;
    right = Operand::parse();
    cin >> paren;
    switch (operation)
    {
    case '+':
        return new Plus(left, right);
    case '-':
        return new Minus(left, right);
    case '*':
        return new Times(left, right);
    case '/':
        return new Divide(left, right);
    case '&':
        return new And(left, right);
    case '>':
        return new GreaterThan(left, right);
    case '|':
        return new Or(left, right);
    case '<':
        return new lessThan(left, right);
    case '=':
        return new Equals(left, right);
    case '!':
        return new Not(left, NULL);
    case ':':
        third = Operand::parse();
        cin >> paren;
        return new Ternary(left, right, third);
    }

    return 0;
}