# Vending Machine Bug Report

## Bug 1 - Constructor Array Index Error

**Observed Failure:**  
Creating a new VendingMachine caused an `ArrayIndexOutOfBoundsException`.
The error reported that index 4 was out of bounds for an array of length 4.

**Test That Exposed It:**  
`constructorStartsEmpty()`

**Source-Code Fault:**  
The constructor loop used `i <= NUM_SLOTS`, which allowed `i` to reach 4.
Since the slots array has four elements, its valid indexes are only 0 through 3.

**Diagnosis:**  
I debugged `constructorStartsEmpty()` and stepped through the VendingMachine
constructor. I observed the loop variable increase from 0 through 4. When
`i` became 4, the program attempted to access `slots[4]`, causing the exception.

**Correction:**  
Changed the loop condition from:

`i <= NUM_SLOTS`

to:

`i < NUM_SLOTS`

After the correction, `constructorStartsEmpty()` passed.