#pragma once
class Operand : public Expression
{
public:
    static Expression* parse();
};