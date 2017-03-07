# Practice Problem 2.1
### Perform the following number conversions:
> A. 0x39A7F8 to binary
> B. Binary 1100100101111011 to hexadecimal
> C. 0xD5E4C to binary
> D. Binary 1001101110011110110101 to hexadecimal

> A. 0003 1001 1010 0111 1111 1000
> B. 0xA97B
> C. 1101 0101 1110 0100 1100
> D. 0x26E7B5

# Practice Problem 2.2
### Fill in the blank entries in the following table, giving the decimal and hexadecimal
representations of different powers of 2:

| n        | 2^n(Decimal)   |  2^n(Hexadecimal)  |
| --------   | -----:  | :----:  |
| 9     | 512 |   0x200     |
| 19        |     524288 |   19 = 3 + 4*4, 0x80000   |
|  14       |    16384    | 14 = 2 + 3*4, 0x4000   |
|  16       |    65536    | 0x10000, 0 + 4*4 = 16   |
|  17       |    131072    |17 = 1 + 4*4, 0x20000   |
|  5       |    32    | 5 = 1 + 1*4, 0x20   |
|  7       |    128    | 0x80, 3 + 1*4 = 7    |

# Practice Problem 2.3
### A single byte can be represented by two hexadecimal digits. Fill in the missing
entries in the following table, giving the decimal, binary, and hexadecimal values
of different byte patterns:

| Decimal        | Binary   |  Hexadecimal  |
| --------   | -----:  | :----:  |
| 0     | 0000 0000 |   0x00     |
| 167        |     1010 0111 |   0xA7   |
|  62       |    0011 1110    | 0x3E   |
|  188       |    1011 1100    | 0xBC   |
|  55       |    0011 0111    | 0x37   |
|  136       |    1000 1000    | 0x88   |
|  243       |    1111 0011    | 0xF3   |
|  82       |    0101 0010    | 0x52   |
|  172       |    1010 1100    | 0xAC   |
|  231       |    1110 0111    | 0xE7   |

# Practice Problem 2.4
### Without converting the numbers to decimal or binary, try to solve the following arithmetic problems, giving the answers in hexadecimal. Hint: Just modify
the methods you use for performing decimal addition and subtraction to use
base 16.

# Practice Problem 2.5
> ### Consider the following three calls to show_bytes:
> 
>  ##### int val = 0x87654321;
>  ##### byte_pointer valp = (byte_pointer) &val;
>  ##### show_bytes(valp, 1); /* A. */
>  ##### show_bytes(valp, 2); /* B. */
>  ##### show_bytes(valp, 3); /* C. */

### Indicate which of the following values will be printed by each call on a little-endian machine and on a big-endian machine.

| Little endian        | Big endian   |
| --------   | -----:  |
| 21   | 87  |
| 21 43   | 87 65  |
| 21 43 65   | 87 65 43  |


# Practice Problem 2.6

### Using show_int and show_float,we determine that the integer 3510593 has hexadecimal representation **0x00359141**, while the floating-point number 3510593.0 has hexadecimal representation **0x4A564504**.

> 1. Write the binary representations of these two hexadecimal values.
> 2. Shift these two strings relative to one another to maximize the number of matching bits. How many bits match?
> 3. What parts of the strings do not match?

> 1. 0000 0000 0011 0101 1001 0001 0100 0001 and 0100 1010 0101 0110 0100 0101 0000 0100
> 2. make second binary to 0001 0010 1001 **0101 1001 0001 0100 0001**
> 3. the left parts do not match, **0001 0010 1001**


## Aside
### display the ASCII by "man ascii"


# Practice Problem 2.7
### What would be printed as a result of the following call to show_bytes?
    const char* s = "abcdef";
    show_bytes((byte_pointer) s, strlen(s));
### Note that letters 'a' through 'z' have **ASCII** codes 0x61 through ox7A.

### Answer: 61 62 63 64 65 66
