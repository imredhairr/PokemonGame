#include<stdio.h>
int main()
{
  int i;
  float total;
  float average;
  int score[5];

  for(i=0;i<5 ;i++)
   {
     printf("Enter score:");
     scanf("%d",&score[i]);
   }

for (i=0 ; i<5; i++)
  {
    total =total+score[i] ;
  }
  average=total/5;
  printf("Average marks:%f",average);
  return 0;
}
