#include<stdio.h>
#include<stdlib.h>

void reverse(char str[]){
	char *p = str;
	char *q = p;
	
	//go to the last char in this stirng.
	while(*q!='\0'){
		q++;
	}
	//now q is on '\0', go back one step
	q--;
	while(p!=q){
		char tmp = *p;
		*p = *q;
		*q = tmp;
		p++;
		q--;
	}
}


int main(){
	char str[] = "123456789";
	reverse(str);
	printf("%s \n", str);
	return 0;
}
