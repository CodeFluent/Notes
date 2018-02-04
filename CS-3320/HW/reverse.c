# include <stdio.h>


int main (void) {

    int i, k, j;
    char str[100];
    char revstr[100];
    printf("Enter a message: ");
    scanf("%s", str);

    for (i = 0; str[i] != '\0'; i++) {
        k = i-1; // get length of string.
    }

    for (j = 0; j <= i-1; j++) {
        revstr[j] = str[k];
        k--;
    }

    printf("%s\n", revstr);



}
