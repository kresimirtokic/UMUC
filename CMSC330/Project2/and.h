#pragma once
class And : public SubExpression {
public:
	And(Expression* left, Expression* right) : SubExpression(left, right)
	{
	}
	int evaluate()
	{//if left or right are 0 then return false 0 otherwise return true 1
		if (left->evaluate() == 0 || right->evaluate() == 0) {
			cout << "False" << '\n';
			return 0;
		}
		else {
			cout << "True" << '\n';
			return 1;
		}
	}
};