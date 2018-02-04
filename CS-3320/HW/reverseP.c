# include <stdio.h>


int main (void) {

    int i, k, j, *p, *s, *r;
    char str[100];
    char revstr[100];
    printf("Enter a message: ");
    scanf("%s", str);

    for (*p = 0; str[*p] != '\0'; *p++) {
        k = *p-1; // get length of str*png.
    }

    for (*r = 0; *r <= *p-1; *r++) {
        revstr[*r] = str[k];
        k--;
    }

    printf("%s\n", revstr);



}
