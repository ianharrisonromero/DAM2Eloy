#include <stdio.h>
#include <openssl/evp.h>
#include <string.h>
#include "md5magia.c"

int main(int argc, char const *argv[]) {

  char *string = argv[1];
  unsigned char result[EVP_MAX_MD_SIZE];
  char stringToCompare[STR_LEN];

  for (char c1 = 'a'; c1 <= 'z'; c1++){
    for (char c2 = 'a'; c2 <= 'z'; c2++){
      for (char c3 = 'a'; c3 <= 'z'; c3++){
        for (char c4 = 'a'; c4 <= 'z'; c4++){
          stringToCompare[0]=c1;
          stringToCompare[1]=c2;
          stringToCompare[2]=c3;
          stringToCompare[3]=c4;
          stringToCompare[4]='\0';
          
          generateMD5(stringToCompare, result);
          if (strcmp(stringToCompare, result)==0)
          {
            printf("Your 4 character word is %s .", stringToCompare)
          }
        }
      }
    }
  }
}

