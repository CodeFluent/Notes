#include <stdio.h>
 
int main(void)
{
	int num;	

	printf("Please input a number: \n");
	scanf("%d",&num);  

	int num2 = num;
        int res = 1;

        while(num2 > 0 ){
                res=res*num2;
                num2--;          
        }

	printf("The factorial of %d is %d\n",num, res);
       
}

