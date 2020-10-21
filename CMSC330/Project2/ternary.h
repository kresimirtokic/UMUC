#pragma once
class Ternary : public SubExpression
{
public:
    Ternary(Expression* left, Expression* right, Expression* third) :
        SubExpression(left, right, third)
    {
    }
    int evaluate()
    {
        return third->evaluate() ? left->evaluate() : right->evaluate();
    }
};