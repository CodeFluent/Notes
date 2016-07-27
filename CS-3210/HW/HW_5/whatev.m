



  .section ".data"

  stringMessage: .asciz "Please enter in a string of a maximum of 30 letters: "
  letterMessage: .asciz "Please enter a letter: "

  upCaseStr: .asciz "The string in uppercase is: %s "
  lengthMessage: .asciz  "The length of the string is %d character"
  lettersIn: .asciz "The letter %c appears %d times in the string."
  revisedMessage: .asciz "The revised string is: %s "

  sequenceMessage: .asciz "Would you like to enter another string? (y/n)? "
  goodbyeMessage: .asciz "Goodbye."

  format: .asciz "%s "
  format2: .asciz "%s "
  format3: .asciz "%c "
  format4: .asciz "%c "
  format5: .asciz "%d "
  newLine: .asciz "\n"
  newLine2: .asciz "\n1"

.align 4

  define(ptr, l0)
  define(byte, l1)
  define(len, l2)
  define(strInput, l3)
  define(charInput, l4)


  input: .word 0
  !input1: .byte 0
  !input2: .byte 0
  ! yesNoInput: .byte 0
 ! nl: .byte 0

  .align 4
  define(ptr, l0)
  define(byte, l1)
  define(len, l2)
  define(strInput, l3)
  define(charInput, l4)
  define(`ptr_r',  l5)
  define(`byte_r', l6)

  input: .word 0
  !input1: .byte 0
  !input2: .byte 0
  ! yesNoInput: .byte 0
 ! nl: .byte 0

  .align 4
  .global main
  .section ".text"



main:
   save  %sp, -96, %sp

loadStr:
        set     stringMessage, %o0
        call    printf
        nop
        set     format, %o0
        set     input, %o1
        call    scanf
        nop
        set     input, %o0
        call    findLength
        nop
        mov     %o0, %o1
        set     lengthMessage, %o0
        call    printf
        nop
          !!!!!!!!!!!!!!!!!!!!!!!!
        set     format, %o0
        set     input, %o1
        call    scanf
        nop
        set     input, %o0
        call    capital
        nop
        !set     %o0, %o1
        set     upCaseStr, %o0
          !!!!!!!!!!!!!!
        call    printf
        nop
ret
restore


.global findLength
findLength:
        save    %sp, -96, %sp
        mov     %i0, %ptr
        clr     %len
loop:
        ldub    [%ptr], %byte
        cmp     %byte, 0
        beq     finished
        nop
        inc     %ptr
        inc     %len
        ba      loop
        nop
finished:
        mov     %len, %i0
        ret
        restore

.global capital
capital:
        save    %sp, -96, %sp
        mov     %i0, %ptr             ! copy starting address
loop2:
        ldub    [%ptr], %byte       ! load next byte (unsigned)
        cmp     %byte, 0              ! exit when zero byte reached
        beq     done
        nop
        cmp     %byte, 'a'            ! cmp to lower limit 0x61 = 97 = 'a'
        blt     next                    !   lower case letter will be >= 'a'
        nop
        cmp     %byte, 'z'            ! cmp to upper limit 0x7a = 122 = 'z'
        bgt     next                    !   lower case letter will be <= 'z'
        nop
        sub     %byte, 0x20, %byte  ! change lower case letter to upper ca$
        stb     %byte, [%ptr]       ! store back to string (update in plac$
next:
        inc     %ptr                 ! increment string pointer
        ba      loop2
        nop
done:
        ret
        restore
