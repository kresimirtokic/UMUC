#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>


int main()
{
    int pidC, pid, status, pidG;
    pid = fork();
    switch(pid) {
    case -1: 
        /* an error occurred */
        printf("Fork error"); 
        break;
    case 0:  
        pidG = getppid();
        pidC = fork();
        switch(pidC) {
          case -1:
          /* an error occured */
            printf("Fork error");
            break;
          case 0:
            /* this code is executed by the child process */
            printf("I am the child process C and my pid is %d\n", getpid()); 
            printf("My parent P has pid %d\n", getppid());
            printf("My grandparent G has pid %d\n", pidG);
            printf("\n");
            break;
          default:
          /* this code is executed by the parent process */
          wait(&status); // I couldn't get wait to work
          //sleep(1);
          printf("I am the parent process P and my pid is %d\n", getpid());
          printf("My parent G has pid %d\n", pidG);
          printf("\n");
          break;
        }
        break;
    default: 
        /* this code is executed by the grandparent process */
        wait(&status); // I couldn't get wait to work
        //sleep(2);
        printf("I am the grandparent process G. My pid is %d\n", getpid());
        printf("\n");
        break;
    }
return 0;
}