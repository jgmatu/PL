#include math.h;
#include plot.h;

int get_bla(int argc, float argv)
{
	return 0;
}

int main (float hola, int argc)
{
	int a;
	a = 3;

	if (argc == 3) then {
		a = a + 3;
	} else {
		a = 0;
	}

	for (a = 0; a < 3; a = a + 1) {
		a = a * 10;
	}
	plotter();
	plot(hola);


	int bla, d;
	float c;
	bla = get_bla(bla, c);

	d = 0;
	do {
		int k;
		d = sum(bla, k);
		d = mult(bla, k);
	} until (bla < d);
	return 0;
}
