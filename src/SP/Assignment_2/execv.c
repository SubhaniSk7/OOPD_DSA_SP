#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

int main() {

    while (1) {

        char input[1000];
        fgets(input, 1000, stdin);

        if (input[0] == 'c' && input[1] == 'd' && input[2] == ' ') {
            int c = 0;
            char *ff;
            char * pch;

            ff = &input[1];

            char file[100];

            int fi = 0;
            int i = 3;
            int q = 0;
            for (i = 3; i<sizeof (input) && q != 1; i++) {
                if (input[i] == '\0' || input[i] == " " || input[i] == NULL || input[i] == '\n') {
                    q = 1;
                    break;
                } else {
                    file[fi++] = input[i];
                    //                    printf("%s n\n", &file);
                    //                    printf("hell\n");
                }
            }

            //            printf("pp %s b", &file);
            //            printf("b\n");
            int t = chdir(&file);
            //            printf("t %d\n", t);
            if (t == 0) {
                //                printf("-c\n");
                printf("Directory change Successful\n");
            } else {
                switch (t) {
                    case EACCES: perror("Permission denied");
                        break;
                    case EIO: perror("An input output error occured");
                        break;
                    case ENAMETOOLONG: perror("Path is to long");
                        break;
                    case ENOTDIR: perror("A component of path not a directory");
                        break;
                    case ENOENT: perror("No such file or directory");
                        printf("enoent\n");

                    default: perror("Couldn't change directory to ");
                }
            }
            //            else {
            //                printf("d\n");
            //                return 0;
            //            }
        } else {

            pid_t result = fork();

            if (result == 0) {
                //                printf("a\n");
                //                printf("e-%s\n", &input[0]);

                char *args[1000];

                args[0] = "/bin/sh";
                args[1] = "-c";
                args[2] = &input[0];
                args[3] = NULL;

                execv("/bin/sh", args);
            }
        }
    }
    return 0;
}
