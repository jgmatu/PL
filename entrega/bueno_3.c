int get_result() {
    int a;

    for (a = 0; a < 10; a = a + 1) {
        a = a + 1;
    }
    return a;
}


int main() {
    int result;
    int a;
    float b;

    result = get_result();

    a = 0;
    b = 0.0;

    b = b + 1.0;
    a = a + 1;

    do {
        b = b * 10.0;
        a = a + 1;
    } until (a < 100);
    return 0;
}
