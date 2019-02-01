#include <stdio.h>
#include <openssl/bn.h>

#define NBITS 256

void printBN(char *msg, BIGNUM * a) {
	char * number_str = BN_bn2hex(a);
	printf("%s %s\n", msg, number_str);
	OPENSSL_free(number_str);
}

int main() {

	BN_CTX *ctx = BN_CTX_new();

	BIGNUM *n = BN_new();
	BIGNUM *e = BN_new();
	BIGNUM *M = BN_new(); // python -c 'print("Launch a missile.".encode("hex"))'
	BIGNUM *S = BN_new();
	BIGNUM *S_corrupted = BN_new();	
	BIGNUM *verify = BN_new();	




	BN_hex2bn(&n, "AE1CD4DC432798D933779FBD46C6E1247F0CF1233595113AA51B450F18116115");
	BN_hex2bn(&e, "010001");
	BN_hex2bn(&M, "4c61756e63682061206d697373696c652e");
	BN_hex2bn(&S, "643D6F34902D9C7EC90CB0B2BCA36C47FA37165C0005CAB026C0542CBDB6802F");
	BN_hex2bn(&S_corrupted, "643D6F34902D9C7EC90CB0B2BCA36C47FA37165C0005CAB026C0542CBDB6803F");

	// verify S^e mod n
	BN_mod_exp(verify, S, e, n, ctx);
	printBN("verfication: ", verify);
	printBN("original message: ", M);

	printf("\n");

	// verify S_corrupted^e mod n
	BN_mod_exp(verify, S_corrupted, e, n, ctx);
	printBN("verfication corrupted: ", verify);
	printBN("original message: ", M);


	return 0;
}