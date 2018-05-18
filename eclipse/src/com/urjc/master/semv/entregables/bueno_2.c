void readLines(int len, int a) {
    int pos;
    int n;

    n = len;
    pos = 0;
    do {
        a = a + 1;
        if (a < pos) then {
            a = 0;
        } else {
            pos = pos + 1;
        }
    } until (pos < n);
}



int main () {
    int a, b;
    a = 10;
    b = 10;
    readLines(a, b);
}
