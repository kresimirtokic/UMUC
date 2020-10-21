#pragma once
class GreaterThan : public SubExpression
{
public:
	GreaterThan(Expression* left, Expression* right) : SubExpression(left, right)
	{
	}
	int evaluate()
	{
		if (left->evaluate() > right->evaluate()) {
			cout << "True" << '\n';
			return 1;
		}
		else {
			cout << "False" << '\n';
			return 0;
		}
	}
};