My Drive
Earlier this week
Thu 17:45
P
You shared an item
C
Ex3.c

Can edit
Tran Ngoc Quang
Thu 17:45
P
You uploaded an item
C
Ex3.c
Last week
8 Jul
P
You shared 29 items
Image
7516823536_IMG_0493.JPG
Image
7516823536_IMG_0525.JPG
Image
7516823536_IMG_0531.JPG
Image
7516823536_IMG_0526.JPG
Image
7516823536_IMG_0514.JPG
Image
7516823536_IMG_0527.JPG
H
Can edit
Huong Vo
8 Jul
P
You uploaded 29 items
Image
7516823536_IMG_0491.JPG
Image
7516823536_IMG_0492.JPG
Image
7516823536_IMG_0499.JPG
Image
7516823536_IMG_0495.JPG
Image
7516823536_IMG_0511.JPG
Image
7516823536_IMG_0498.JPG
8 Jul
P
You created and shared an item in
My Drive
Google Drive Folder
hình sương mù
H
Can edit
Huong Vo
8 Jul
P
You uploaded 5 items
Image
7516823536_IMG_0518.JPG
Image
7516823536_IMG_0526.JPG
Image
7516823536_IMG_0525.JPG
Image
3.png
Image
3.png
6 Jul
P
Youmoved 3 items to the bin
Image
Screen Shot 2018-07-04 at 9.41.37 PM.png
Image
Untitled-3.png
PDF
scoreReport2.pdf
6 Jul
P
You renamed an item
PDF
scoreReport (2).pdf
scoreReport (1).pdf
6 Jul
P
You renamed an item
PDF
scoreReport (1).pdf
scoreReport (2).pdf
6 Jul
P
Youmoved an item to the bin
Image
Screen Shot 2018-07-04 at 6.52.35 PM.png
6 Jul
P
You uploaded an item
PDF
scoreReport2.pdf
6 Jul
P
Youmoved an item to the bin
Image
Screen Shot 2018-07-04 at 6.52.35 PM.png
6 Jul
P
You uploaded 6 items
PDF
scoreReport (1).pdf
PDF
scoreReport (2).pdf
Image
Screen Shot 2018-07-04 at 9.41.37 PM.png
Image
Screen Shot 2018-07-04 at 6.52.35 PM.png
Image
Untitled-3.png
Image
Screen Shot 2018-07-04 at 6.52.35 PM.png
2 Jul
P
You edited an item
Google Docs
Untitled document
2 Jul
P
You created an item
Google Docs
Untitled document
Earlier this month
1 Jul
P
You edited an item
Google Docs
Untitled document
1 Jul
P
You shared an item
Google Docs
Untitled document

Can edit
Dat Le
1 Jul
P
You edited an item
Google Docs
Untitled document
1 Jul
P
You edited an item
Google Docs
Untitled document
1 Jul
P
You created an item
Google Docs
Untitled document
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
