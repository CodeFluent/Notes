.section ".data"
input2: .asciz "                                               "
yesNo: .byte 0		!store a character representing yes or no
nl: .asciz "\n"   !where we dump the trailing newline input
format1: .asciz "%s"	!specify a decimal number (word) and a character
format2: .asciz "%c%c" 	!specify two characters
prompt: .asciz "\nPlease enter in a string of a maximum of 30 letters:"
prompt2: .asciz "\nWould you like to try again(Y/N):"
prompt4: .asciz "\nThe length of the string is %d characters"
prompt3: .asciz "\nthe leteer appears %d times"
prompt5: .asciz "\nPlease enter a letter:"
prompt6: .asciz "\nThe letter %s appears 3 times:"
prompt7: .asciz "\nGoodbye. "
prompt8: .asciz "\nThe revisded string is: "
format3: .asciz "\n%s"
input3: .asciz " "
define(ptr_r,  l0)
define(byte_r, l1)
define(len_r,  l2)
define(string_r,  l3)
define(ptr2_r,  l4)
define(byte2_r, l5)
define(letter, l6)
define(count, l7)
.align 4
.global main
.section ".text"

main: 
	save %sp, -96, %sp

 repeat:
	! prompt the user for an input
        set prompt, %o0
	call printf
	nop

	set format1, %o0	!what kind of data we want to get
	set input2, %o1		!location for the input number to be
	set nl, %o2		!location to dump the input newline
	call scanf
	nop			!now, the user input must be in the data
				!specified by the lable input and nl
length:
	mov %o1, %string_r
	mov	%string_r, %ptr_r		! copy starting address
	clr	%len_r			! length starts at 0
	
	set prompt5, %o0
	call printf 
	nop

	set format3, %o0
	set input3, %o1
	set nl, %o2
	call scanf 
	nop
	mov %o1, %letter
	set prompt6, %o0
	mov %letter, %o1
	call printf 
	nop	
loop:
	ldub	[%ptr_r], %byte_r	! load next byte (unsigned)
	cmp	%byte_r, 0		! exit when zero byte reached
	beq	done
	nop
	inc	%ptr_r			! increment string pointer
	inc	%len_r			! increment length
	ba	loop
	nop
done:
	mov	%len_r,%i0		! copy length to return value
	set prompt4, %o0
	mov %i0, %o1
	call printf 
	nop
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
occurence:
	clr	%count	
	mov	%string_r, %ptr2_r		! copy starting address
loop2:
	ldub	[%ptr2_r], %byte2_r	! load next byte (unsigned)
	cmp	%byte2_r, 0		! exit when zero byte reached
	beq	done2
	nop
	cmp	%byte2_r, %letter		! cmp to letter
	be	next			!   
	nop
	inc 	%count
	stb	%byte2_r, [%ptr2_r]	! store back to string (update in place)
next:
	inc	%ptr2_r			! increment string pointer
	
	ba	loop2
	nop
done2:
	mov	%count, %i0		! copy length to return value
	set prompt3, %o0
	mov %i0, %o1
	call printf 
	nop

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	set prompt2, %o0	!reprompt
	call printf
	nop

	set format2, %o0	!getting a character and a newline
	set yesNo, %o1		!location for yes/no
	set nl, %o2		!dummy newline
	call scanf
	nop

	set yesNo, %l7		!get the address of yes/no memory
	ldub [%l7], %o0		!get the yes/no response from memory	
	cmp %o0, 'y'		
	be	repeat		!yes, then try again
	nop

        cmp %o0, 'Y'		!yes, then try again
	be	repeat
        nop 

	ret			!get out
	restore
