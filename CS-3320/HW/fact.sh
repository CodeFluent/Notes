
#!/bin/bash

# Factorial

#intitialize
x=0
y=0
z=0
f=0


y=$1
f=`expr $y - 1` # subtract for first time
z=$f


while [ $z -gt 1 ]  # while value2 is greater than or equal to 1.
do
x=`expr $y \* $z`
echo $x
z=`expr $y - 1`
y=$x
echo -n $y
done

echo “the factorial of $1 is $x.”

