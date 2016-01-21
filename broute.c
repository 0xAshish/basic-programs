#include <stdio.h>
#include <string.h>
#include <stdlib.h>

static const char alphabet[] =
        "abcdefghijklmnopqrstuvwxyz"
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        "0123456789";

static const int alphabet_size = sizeof(alphabet) - 1;

void brute_impl(char * str, int index, int max_depth)
{
    int i;
    for (i = 0; i < alphabet_size; ++i)
    {
        str[index] = alphabet[i];

        if (index == max_depth - 1)
        {
            printf("%s\n", str); // put check() here instead
        }
        else
        {
            brute_impl(str, index + 1, max_depth);
        }
    }
}

void brute_sequential(int max_len)
{
    char * buf = malloc(max_len + 1);
    int i;

    for (i = 1; i <= max_len; ++i)
    {
        memset(buf, 0, max_len + 1);
        brute_impl(buf, 0, i);
    }

    free(buf);
}

int main(void)
{
    brute_sequential(5);
    return 0;
}
