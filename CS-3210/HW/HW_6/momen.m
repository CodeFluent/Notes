.section ".data"

stringMessage: .asciz "Please enter in a string of a maximum of 30 letters: "

letterMessage: .asciz "Please enter a letter: "

lengthMessage: .asciz "The length of the string is %d character(s)."

lettersIn: .asciz "The letter %c appears %d times in the string."

revisedMessage: .asciz "The revised string is: %s"

sequenceMessage: .asciz "Would you like to enter another string (y/n)? "

goodbyeMessage: .asciz "Goodbye."

!testing

testStr: .asciz "String is %s"
testChar: .asciz "Char is %c"

format: .asciz "%s "
format2: .asciz "%s "
format3: .asciz "%c "
format4: .asciz "%c "
format5: .asciz "%d "
newLine: .asciz "n"
newLine2: .asciz "n"

.align 4
input: .asciz "                              "

define(ptr, l0)
define(byte, l1)
define(len, l2)
define(strInput, l3)
define(charInput, l4)

.global main
.section ".text"

main:
    save %sp, -96, %sp

loadstring:
    set stringMessage, %o0
    call printf
    nop

    set format, %o0
    set input, %o1
    call scanf
    nop
/*
    set input, %o0
    call length
    nop

    mov %o0, %o1
    set lengthMessage, %o0
    call printf
    nop
    */

    ret
    restore
