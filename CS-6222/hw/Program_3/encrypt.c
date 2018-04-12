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
	BIGNUM *M = BN_new();
	BIGNUM *d = BN_new();
	BIGNUM *encrypt_res = BN_new();
	BIGNUM *decrypt_res = BN_new();



	BN_hex2bn(&n, "DCBFFE3E51F62E09CE7032E2677A78946A849DC4CDDE3A4D0CB81629242FB1A5");
	BN_hex2bn(&e, "010001");
	BN_hex2bn(&M, "4120746f702073656372657421");
	BN_hex2bn(&d, "74D806F9F3A62BAE331FFE3F0A68AFE35B3D2E4794148AACBC26AA381CD7D30D");

	// encrypt M^e mod n
	BN_mod_exp(encrypt_res, M, e, n, ctx);
	printBN("encrypted message: ", encrypt_res);

	// decrypt y^d mod n
	BN_mod_exp(decrypt_res, encrypt_res, d, n, ctx);
	printBN("decrypt_res: ", decrypt_res);

	return 0;
}