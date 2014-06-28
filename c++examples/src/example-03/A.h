#ifndef __A_H__
#define __A_H__

class A {
public:

	static const int ARRAY_SIZE = 0;

	A();
	~A();
	void set_value(int value);
	int get_value() const;
private:
	int value;
	int * array;
};

#endif /* __A_H__ */
