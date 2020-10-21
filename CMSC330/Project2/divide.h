#pragma once


class Divide : public SubExpression
{
public:
	Divide(Expression* left, Expression* right) : SubExpression(left, right)
	{
	}
	int evaluate()
	{
		if (right->evaluate() == 0) {
			cout << "Cant divide by 0 \n";
			return 0;
		} else {
			return left->evaluate() / right->evaluate();
		}
		
	}
};