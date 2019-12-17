  #include <stdio.h>
  #include <string.h>

  int main( int argc,char const *argv[]) {
      char s1[]= {'H','e','l','l','o','\0'};
      char s2[]= "Hello";

      for (int i = 0; i < 5  ; i++ ) {
          printf("%3i %c\n" , s1[i],s1[i]),s2[i],s2[i];
}
return 0;
}
