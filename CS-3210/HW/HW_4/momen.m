/*
  Write a program to find and print a Fibonacci sequence of numbers. The Fibonacci sequence is defined by:

  Fn = Fn-2 + Fn-1, where Fo = 0 and F1 = 1.
 */

!Variables and Macros


define(max_value, g2)
define(prevVal, g3)
define(prevPrevVal,g4)
define(currVal, g5)


.section ".data"

input: .word 0
nl: .byte 0   !for newline
format: .asciz "%d"

!to print numbers
output: .asciz "%d "




helloMessage: .asciz "This program prints the Fibonacci sequence.\n"
scanMessage: .asciz "Enter the limit on the largest number to be displayed: "



divMessage: .asciz "\nThe last number %d is divisible by %d.\n"

askQuestion: .asciz "Do you want to print a different sequence (Y/N)?: "

yesnoin: .byte 0
format2:  "%c"
nl2: .byte 0

goodbye: .asciz "Goodbye."


!testing printf
test: .asciz "Number is %d"

testchar: .asciz "HEKLSAFASFSA is %c"




.align 4
.section ".text"
.global main

main:
  save %sp, -96, %sp


  set helloMessage, %o0         !print hello message
  call printf
  nop

heyo:
  iflush %o0
  iflush %o1
  iflush %o2

  clr %o0
  clr %o1
  clr %o2



  set scanMessage, %o0          !print scan message
  call printf
  nop

  set format, %o0
  set input, %o1
  set nl, %o2
  call scanf
  nop


  ld [%o1], %max_value
  ldub [%o2], %l2

/*Uncommment to print out max_value

  set test, %o0
  mov %max_value, %o1
  call printf
  nop
*/


  mov 1, %o1                            !print out the base case 1
  set output, %o0
  call printf
  nop

  mov 1, %prevVal                         !begin first evaluation
  mov 0, %prevPrevVal

loop:
  add %prevVal, %prevPrevVal, %currVal    !get the value to be outputted now
  mov %prevVal, %prevPrevVal              !swap values for next run fib(n-2)
  mov %currVal, %prevVal                  !swap values for next run fib(n-1)

printLoop:

  cmp %currVal, %max_value                !compare to see if we print the current value
  bg setting
  nop

  mov %currVal, %o1                       !print currVal
  set output, %o0
  call printf
  nop

  ba loop                                 !branch to loop always
  nop


setting:
  set 1, %i2
div:
  mov %prevPrevVal, %l1
  andcc %prevPrevVal, %i2, %g0
  bne end
  nop
  ba div
  add %i2, %i2, %i2                       !increment the mask

end:
  set divMessage, %o0
  mov %i2, %o2
  call printf
  mov %prevPrevVal, %o1


here:
 set askQuestion, %o0
 call printf
 nop

 set format2, %o0
 set yesnoin, %o1
 set nl2, %o2
 call scanf
 nop

!works with bne, but then goes to heyo and prints the sequence and the last divisible again. need to flush the values from o1 and o2.
 cmp %o1, 'y'
 bne heyo
 nop


 set goodbye, %o0
 call printf
 nop

 !example input/output

/*
This program prints the Fibonacci sequence.
Enter the limit on the largest number to be displayed: 50
1 1 2 3 5 8 13 21 34
The last number 34 is divisible by 2.
Do you want to print a different sequence (Y/N)?: y
Enter the limit on the largest number to be displayed: 1 1 2 3 5 8 13 21 34
The last number 34 is divisible by 2.
Do you want to print a different sequence (Y/N)?: 144
Enter the limit on the largest number to be displayed: 1 1 2 3 5 8 13 21 34 55 89 144
The last number 144 is divisible by 16.
Do you want to print a different sequence (Y/N)?:
*/



ret
restore
