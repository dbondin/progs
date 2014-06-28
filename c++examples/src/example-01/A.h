#ifndef __A_H__
#define __A_H__

class A {
public:
	A();
	~A();
	void set_value(int value);
	int get_value() const;
private:
	int value;
};

#endif /* __A_H__ */
