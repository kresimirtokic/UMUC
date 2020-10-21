#pragma once
class SubExpression : public Expression
{
public:
    SubExpression(Expression* left, Expression* right);
        SubExpression(Expression* left);
        SubExpression(Expression* left, Expression* right, Expression* third);
    static Expression* parse();
protected:
    Expression* left;
    Expression* right;
    Expression* third;
};
