#include<stdio.h>

/**
 * In my thinkpad x1 carbon, ubuntn(64),
 * gcc hello.c -o hello
 * ./hello
 *
 * output:
 * 7b 00 00 00
 * 00 00 f6 42
 * 38 2b ff 41 ff 7f 00 00
 *
 */

typedef unsigned char* byte_pointer;

void show_bytes(byte_pointer start, int len)
{
	int i;
	for (i = 0; i < len; i++)
		printf(" %.2x", start[i]);
	printf("\n");
}

void show_int(int x)
{
	show_bytes((byte_pointer) &x, sizeof(int));
}

void show_float(float x)
{
	show_bytes((byte_pointer) &x, sizeof(float));
}

void show_pointer(void* x)
{
	show_bytes((byte_pointer) &x, sizeof(void*));
}

void test_show_bytes(int val)
{
	int ival = val;
	float fval = (float) ival;
	int *pval = &ival;
	show_int(ival);
	show_float(fval);
	show_pointer(pval);
}

int main()
{
	int val = 123;
	test_show_bytes(val);
	return 0;
}

