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
	BIGNUM *M = BN_new(); // python -c 'print("I owe you $2000".encode("hex"))'
	BIGNUM *Mprime = BN_new(); // python -c 'print("I owe you $3000".encode("hex"))'
	BIGNUM *d = BN_new();
	BIGNUM *sig = BN_new();



	BN_hex2bn(&n, "DCBFFE3E51F62E09CE7032E2677A78946A849DC4CDDE3A4D0CB81629242FB1A5");
	BN_hex2bn(&e, "010001");
	BN_hex2bn(&M, "49206f776520796f75202432303030");
	BN_hex2bn(&Mprime, "49206f776520796f75202433303030");
	BN_hex2bn(&d, "74D806F9F3A62BAE331FFE3F0A68AFE35B3D2E4794148AACBC26AA381CD7D30D");

	// compute sig M^d mod n
	BN_mod_exp(sig, M, d, n, ctx);
	printBN("signature: ", sig);

	// compute sig Mprime^d mod n
	BN_mod_exp(sig, Mprime, d, n, ctx);
	printBN("other signature: ", sig);


	return 0;
}