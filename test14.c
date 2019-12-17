#include <stdio.h>
#include <string.h>
#include <math.h>

int main(int argc, char const *argv[]) {
    // Read array size
    int n;
    int sum = 0;
    printf("Please enter array size: ");
    scanf("%i", &n);



    if (n <= 0) {
        printf("Array size must be greater than zero\n");
    } else { }

        int arr[n];
        for (int i = 0; i < n; i++) {
            printf("arr[%i]= ", i);
            scanf("%i", &arr[i]);
            sum += arr[i];
        }

        int mean = sum / n;
        int dev = 0;

        for (int k = 0; k < n; k++) {
          dev += ((arr[k] - mean) * (arr[k] - mean)) ;
        }

        dev = sqrt (dev / (n-1));

        printf("The mean of this array is %i\n", mean);
        printf("ST of this array is %i\n", dev);

    //     for (int j = 0; j < n; j++) {
    //         printf("%i ", arr[j]);
    //     }
    //     printf("\n");
    //
    //
    //     for (int k = n - 1; k >= 0; k--) {
    //         printf("%i ", arr[k]);
    //     }
    //     printf("\n");
    // }

    return 0;
}
