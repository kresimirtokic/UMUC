#pragma once

class Or : public SubExpression
{
public:
	Or(Expression* left, Expression* right) : SubExpression(left, right)
	{
	}
	int evaluate()
	{
		if (left->evaluate() != 0 || right->evaluate() != 0) {
			cout << "True" << '\n';
			return 1;
		}	else {
			cout << "False" << '\n';
			return 0;
		}
	}
};