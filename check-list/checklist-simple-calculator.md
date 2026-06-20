# Simple Calculator - Testing Checklist

**Project:** Custom Simple Calculator Implementation

**Framework:** JUnit 4 / JUnit 5 Baseline Integration

**Methods to Test:** 1 core evaluation method (`calculate`) alongside state management

---

## 1. Methods to Test

| Method    | Signature                                               | Description                                                                    |
| --------- | ------------------------------------------------------- | ------------------------------------------------------------------------------ |
| calculate | `double calculate(double a, double b, String operator)` | Executes basic arithmetic operations given two operands and an operator string |

|
| getResult | `double getResult()` | Retrieves the current accumulated state from the calculator memory

|
| clear | `void clear()` | Resets the calculator internal accumulated memory state to 0.0 |

---

## 2. Test Cases by Scenario Class

### Normal Cases (Basic Arithmetic)

- [ ] Add two positive integers $\rightarrow$ verify exact mathematical sum

- [ ] Subtract smaller positive integer from larger $\rightarrow$ verify exact positive difference

- [ ] Multiply two positive integers $\rightarrow$ verify exact product

- [ ] Divide perfectly divisible positive integers $\rightarrow$ verify exact quotient

### Negative Numbers Group

- [ ] Add positive operand to a larger negative operand $\rightarrow$ verify correct negative sum

- [ ] Subtract a negative number from another negative number $\rightarrow$ verify signs resolve correctly

- [ ] Multiply negative operand by a positive operand $\rightarrow$ verify negative product

- [ ] Divide negative operand by a positive divisor $\rightarrow$ verify negative quotient

### Zero Values Group

- [ ] Add zero to zero $\rightarrow$ verify result is exactly 0.0

- [ ] Add zero to a positive non-zero operand $\rightarrow$ verify identity property holds

- [ ] Multiply an integer operand by zero $\rightarrow$ verify zero annihilation property

- [ ] Divide zero by a valid non-zero divisor $\rightarrow$ verify result is 0.0

### Decimal / Floating-Point Numbers

- [ ] Add two precise decimal floating-point numbers $\rightarrow$ verify precision sum

- [ ] Subtract decimals yielding a precise fraction $\rightarrow$ verify fractional difference

- [ ] Multiply decimal fractions $\rightarrow$ verify correct scale floating-point product

- [ ] Divide non-divisible numbers $\rightarrow$ verify precise decimal quotient output

### Invalid Operator Handling

- [ ] Pass unsupported modulus character (`%`) $\rightarrow$ verify system throws `IllegalArgumentException`

- [ ] Pass exponentiation character (`^`) $\rightarrow$ verify system throws `IllegalArgumentException`

- [ ] Pass alphabetic text string (`abc`) instead of operator $\rightarrow$ verify immediate safe error execution

- [ ] Pass blank space string or null values $\rightarrow$ verify exception handled safely without crash

### Division by Zero (Exception & Floating-Point Edge Cases)

- [ ] Divide standard primitive integer context values by zero $\rightarrow$ verify `ArithmeticException` thrown safely

- [ ] Divide standard double floating-point value by zero $\rightarrow$ verify IEEE 754 compliance returns `Infinity` or `-Infinity`

### Operator Character Variants

- [ ] Execute multiplication via standard star operator wildcard character (`*`) $\rightarrow$ calculate product

- [ ] Execute multiplication via character string variants (`x` or `X`) $\rightarrow$ verify parser alias matches standard multiplication

---

## 3. Critical Edge Cases

| Edge Case                 | Test Action                  | Expected Result                                                            |
| ------------------------- | ---------------------------- | -------------------------------------------------------------------------- |
| Division by Absolute Zero | Call `calculate(10, 0, "/")` | Returns `Infinity` or Throws `ArithmeticException` depending on data types |

|
| Null/Blank Operators | Call `calculate(5, 5, " ")` | Securely catches input fault; throws `IllegalArgumentException`

|
| Integer Boundaries | Input `Integer.MAX_VALUE` + 1 | Safe overflow processing or floating-point promotion

|
| Mixed Arithmetic Signs | Multiply negative double by negative double | Signs resolve cleanly to yield positive output

|
| Case Sensitivity | Pass operator token string variant `"X"` | Successfully parsed as valid multiplication operator

|

---

## 4. State Transitions (Key Scenarios)

```
Initial State (0.0) → calculate(5, 3, "+") → Memory State: [8.0]
                            ↓
                      calculate(8, 2, "*") → Memory State: [16.0] (Chaining Operations)
                            ↓
                            clear()        → Memory State: [0.0]

```

---

## 5. Boundary Cases

| Boundary               | Action                                              | Verify                                                  |
| ---------------------- | --------------------------------------------------- | ------------------------------------------------------- |
| Extreme Integer Bounds | Execute calculations on $MAX\_VALUE$ / $MIN\_VALUE$ | No unintended precision truncations or silent data loss |

|
| Precision Scales | Operations using extremely tiny fractions ($0.00001$) | Mantissa precision scales remain mathematically coherent

|
| Operator Trimming | Pass string operator with padding spaces `" + "` | White-space trimmed cleanly; evaluated successfully

|

---

## 6. Recommended JUnit Tests (26 minimum)

### Normal Evaluation & Signs (8 tests)

1. `testCalculate_AddPositiveIntegers_ShouldReturnExactSum`
2. `testCalculate_SubtractPositiveIntegers_ShouldReturnExactDifference`
3. `testCalculate_MultiplyPositiveIntegers_ShouldReturnExactProduct`
4. `testCalculate_DividePositiveIntegers_ShouldReturnExactQuotient`
5. `testCalculate_AddNegativeNumbers_ShouldReturnCorrectSignedSum`
6. `testCalculate_SubtractNegativeNumbers_ShouldResolveSignsCorrectly`
7. `testCalculate_MultiplyWithNegativeOperand_ShouldReturnNegativeProduct`
8. `testCalculate_DivideWithNegativeOperand_ShouldReturnNegativeQuotient`

### Identifiers & Floating-Point Scales (8 tests)

9. `testCalculate_AddZeroToZero_ShouldReturnZero`
10. `testCalculate_IdentityPropertyWithZero_ShouldReturnSameOperand`
11. `testCalculate_MultiplyByZero_ShouldAnnihilateToZero`
12. `testCalculate_DivideZeroByValidNumber_ShouldReturnZero`
13. `testCalculate_AddDecimals_ShouldMaintainPrecision`
14. `testCalculate_SubtractDecimals_ShouldReturnPreciseFraction`
15. `testCalculate_MultiplyDecimals_ShouldScaleCorrectly`
16. `testCalculate_DivideYieldingDecimal_ShouldReturnPreciseQuotient`

### Fault Injections & Exceptions (6 tests)

17. `testCalculate_ModulusOperator_ShouldThrowIllegalArgumentException`
18. `testCalculate_CaretOperator_ShouldThrowIllegalArgumentException`
19. `testCalculate_AlphabeticOperatorString_ShouldThrowIllegalArgumentException`
20. `testCalculate_EmptyBlankOperator_ShouldThrowIllegalArgumentException`
21. `testCalculate_DivideByZeroIntegerContext_ShouldThrowArithmeticException`
22. `testCalculate_DivideByZeroDoubleContext_ShouldReturnInfinity`

### Parser Variants & Integration States (4 tests)

23. `testCalculate_MultiplicationStarOperator_ShouldComputeValidProduct`
24. `testCalculate_MultiplicationAlphaCharXVariant_ShouldComputeValidProduct`
25. `testIntegration_SequentialChainingOperations_ShouldMaintainMemoryState`
26. `testIntegration_Clear_ShouldResetStateToZero`

**Total: 26 essential validation tests**

---

## 7. Key Testing Risks

| Risk                    | Level       | Mitigation                                          |
| ----------------------- | ----------- | --------------------------------------------------- |
| Silent Integer Overflow | 🔴 CRITICAL | Test data boundary limits with max integer extremes |

|
| Unhandled Empty Operator Token | 🔴 CRITICAL | Explicit verification assertions tracking string space boundaries

|
| Unexpected Crash on Division by 0 | 🟠 HIGH | Map separate tests assessing return structures for int vs double

|
| Precision Loss on Small Floating-Points | 🟠 HIGH | Utilize JUnit delta assertions (`0.0001` variance thresholds) |

---

## 8. Coverage Goals

| Target         | Minimum    |
| -------------- | ---------- |
| Methods tested | 3/3 = 100% |
| Test cases     | 26+ tests  |

|
| Line coverage | 100% |
| Branch coverage | 100% |

---

## 9. Test Execution Checklist

- [ ] Create `SimpleCalculatorTest.java`
- [ ] Set up `@Before` fixture initialization hooks
- [ ] Implement 26 comprehensive checking verification steps

- [ ] Run test executions $\rightarrow$ achieve green status on all suites
- [ ] Run JaCoCo or internal coverage measurement metrics engines
- [ ] Assert complete 100% branch and structural line safety profiles
- [ ] Document final matrices cleanly into the final report

---

**Status:** Ready for JUnit Implementation

**Last Updated:** 2026-06-19
