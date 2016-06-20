	.file	"test.c"
	.section	".rodata"
	.align 8
.LLC0:
	.asciz	"Hello world my name is Wasfi Momen! \n"
	.section	".text"
	.align 4
	.global main
	.type	main, #function
	.proc	04
main:
	!#PROLOGUE# 0
	save	%sp, -112, %sp
	!#PROLOGUE# 1
	sethi	%hi(.LLC0), %g1
	or	%g1, %lo(.LLC0), %o0
	call	printf, 0
	 nop
	mov	%g1, %i0
	ret
	restore
	.size	main, .-main
	.ident	"GCC: (GNU) 3.4.6"
