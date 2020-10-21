#pragma once
class Not : public SubExpression
{
public:
    Not(Expression* left, Expression* right) : SubExpression(left, right)
    {
    }
    int evaluate()
    { 
        if (((left->evaluate() > 0 ) )) {
            cout << "Negated to False" << '\n';
            return 0;
        } else {
            cout << "Negated to True" << '\n';
            return 1;
        }
    }
};