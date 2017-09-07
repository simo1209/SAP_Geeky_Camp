#include <stdio.h>
#include <string.h>
#define VALID_PIN 0x344347

struct cred_t
{
    char password[1024];
    int pin;
};

int main(int argc, char *argv[])
{
    struct cred_t credentials;

    //printf("Password: ");
    //scanf("%s", credentials.password);
	//credentials.password=argv[1];
    strcpy(credentials.password,argv[1]);
    if (credentials.pin == VALID_PIN)
    {
        printf("Correct\n");
        return 0;
    }
    printf("Wrong\n");
    return 1;
}
