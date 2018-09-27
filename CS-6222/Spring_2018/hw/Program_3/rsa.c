/* Calculate the private key. */

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

	BIGNUM *p = BN_new();
	BIGNUM *q = BN_new();
	BIGNUM *e = BN_new();

	BN_hex2bn(&p, "F7E75FDC469067FFDC4E847C51F452DF");
	BN_hex2bn(&q, "E85CED54AF57E53E092113E62F436F4F");
	BN_hex2bn(&e, "0D88C3");

	// calculate n first
	BIGNUM *n = BN_new();
	BN_mul(n, p, q, ctx);
	printBN("p * q = ", n);

	// calculate phi which is p-1 * q-1
	BIGNUM *phi = BN_new();
	BIGNUM *one = BN_new();
	BIGNUM *sub_p = BN_new();
	BIGNUM *sub_q = BN_new();

	BN_hex2bn(&phi, "0");
	BN_hex2bn(&one, "1");

	sub_p = BN_sub(p, p, one);
	sub_q = BN_sub(q, q, one);

	phi = BN_mul(phi, sub_p, sub_q, ctx);
	printBN("phi = ", phi);

	// have e, so do mod inverse
	BIGNUM *d = BN_new();
	d = BN_mod_inverse(d, e, n, ctx);
	printBN("d = ", d);


}