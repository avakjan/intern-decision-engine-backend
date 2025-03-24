# TICKET-101 Evaluation

## Overview
A brief summary of the assignment.

## UI/UX
- **Loan Period Slider:**  
  - Displays “6 months” on the legend while the actual input is 12 months.
  - Changes loan period strictly by 6-month increments (this may align with business logic requirements).

## Business Logic
- **Loan Period Constraint:**  
  - The maximal loan period should be capped at 48 months, but the system allows up to 60 months.

## Code Quality
- **Method Parameters:**  
  - A creditModifier variable was not passed to highestValidLoanAmount method.
- **Data Type Use:**  
  - Using a `long` for `loanAmount` seems unnecessary as `int` is sufficient (max value 2,147,483,647).

## Shortcomings
- **Loan Amount Handling:**  
  - The current logic returns the user-requested sum even if it’s smaller than the server-approved value. The server-approved value should override in all cases.
  - ```dart
    if (tempAmount <= _loanAmount || tempPeriod > _loanPeriod) {
       _loanAmountResult = int.parse(result['loanAmount'].toString());
       _loanPeriodResult = int.parse(result['loanPeriod'].toString());
    } else {
       _loanAmountResult = _loanAmount;
       _loanPeriodResult = _loanPeriod;
    }
    ```
  - This condition does not fully enforce the server-approved values.

## Most Important Shortcoming
- **Missing Scoring Algorithm:**  
  - The scoring algorithm is absent. 
  - After implementing scoring algorithm myself, two of the tests failed (`testSegment1PersonalCode` and `testSegment2PersonalCode`). Meaning that they never considered a scoring algorithm in the first place.
  - These tests assume that a segment1PersonalCode with request of a credit score of 100, a loan request of 4000, and a 12-month loan period would be approved, which contradicts the intended logic of scoring algorithm. Similar applies for segment2PersonalCode too.
  - **Fix:** Adjust these tests to assert an exception, aligning with the correct scoring logic. The algorithm should ensure the requested loan does not exceed the server-approved maximum.

## Strengths
- **Detailed JavaDocs:**  
  - Each class and method is well-documented.
- **Clean, Modular, and Maintainable Code Structure**
  - The business logic is isolated in the service layer, while the API-specific logic is handled in the controller layer.
  - Variable and method names are descriptive and formatting is consistent.


## Conclusion
The evaluation reveals that while the intern has covered several important areas, key improvements are needed — most notably in implementing the scoring algorithm and ensuring strict enforcement of business logic constraints. 