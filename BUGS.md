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

## Bug 2 - Incorrect Minimum Money Amount

**Observed Failure:**  
The parameterized `insertMoneyValidAmounts()` test failed for the valid
amounts 0.00, 0.01, and 0.99. Each value caused a
`VendingMachineException` even though the method documentation allows
amounts greater than or equal to zero.

**Test That Exposed It:**  
`insertMoneyValidAmounts()`

**Source-Code Fault:**  
The `insertMoney()` method checked whether `amount < 1`, which incorrectly
rejected every amount below 1.00.

**Diagnosis:**  
I debugged the test using the value 0.01 and observed that the condition
`amount < 1` evaluated to true, causing the method to throw an exception.

**Correction:**  
Changed the condition from:

`amount < 1`

to:

`amount < 0`

After the correction, all six cases in `insertMoneyValidAmounts()` passed.