#include <stdio.h>
#include <math.h>

int main (void){
    float numIntroducido = -1;
    int factorial = 1;
    
    printf("Enter a non-negative integer: ");
    scanf("%d", &numIntroducido);

    if (numIntroducido < 0) {
        printf("Factorial is not defined for negative numbers.\n");
    } else {
        for (int i = 1; i <= numIntroducido; i++) {
            factorial *= i;
        }
        printf("The factorial of %d is %llu\n", numIntroducido, factorial);
    }

    return 0;

}

