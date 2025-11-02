# 🧩 Java: Braces Challenge

## Problem Description

Implement a `Parser` class that checks if a string of brackets is **balanced**.

A string of brackets `()` and `[]` is balanced if one of these conditions is met:

1. It is an **empty string**.  
2. If strings **A** and **B** are balanced, then **AB** is balanced.  
3. If string **A** is balanced, then **(A)** and **[A]** are balanced.

The class should return `"true"` if a string is balanced, and `"false"` otherwise.

---

## 🔍 Example

```java
s = ["(())", "()", "([])"]
```

### Explanation
- `"()"` and `"([])"` are balanced because `"()"` and `"[]"` are both balanced.
- `"()[]"` is balanced because both `"()"` and `"[]"` are balanced.
- `"([])"` is balanced because `"([])"` is balanced itself.

✅ **All three return `"true"`**

---

```java
s = ["[(())", "(", ")(", "{}]"]
```

### Explanation
- `"[(())"` is unbalanced due to the open `"("`.  
- `"("` is unbalanced due to `")"` before `"("` is closed.  
- `")("` is unbalanced because neither `"("` nor `")"` is closed.  
- `"{}]"` is unbalanced because `"}"` comes before `"{"` and the final `"{"` is not closed.

❌ **All four return `"false"`**

---

## 🧠 Function Description

The provided code contains the declaration for a class named **`Solution`** with a `main` method that does the following:

1. Creates a **`Parser`** object.  
2. Reads an unknown number of strings from `stdin`.  
3. Passes each string as an argument to the Parser object's **`isBalanced`** method.  
4. Prints the value returned by the method on a new line.

---

## ✏️ Complete the Function

Implement the following function:

```java
string isBalanced(string s)
```

### Parameters
- `string s`: a string of characters to check for balance.

### Returns
- `string`: returns `"true"` if the string is balanced, or `"false"` if it is not.

---

## ⚙️ Constraints

- Each string consists **only** of the characters `(`, `)`, `[`, `]`, `{`, and `}`.  
- Each string has **fewer than 50 characters**.

---

## 💾 Input Format for Custom Testing

Input from **stdin** will be processed as follows and passed to your `Parser.isBalanced` method.

Each line contains a string to parse, **`s`**.

---

## 🧪 Sample Case 0

### Input
```text
()
[]{}
([()])
)(
```

### Output
```text
true
true
false
false
```

### Explanation

1. `()` contains two adjacent balanced strings `'()'` and `'()'`, so return `"true"`.  
2. `[](){}` contains a balanced string `'[]'`, nested inside `'()'`, nested inside `'{}'`. Return `"true"`.  
3. `([()])` contains a balanced string `'([()])'`, followed by an unbalanced string `'('`. Return `"false"`.  
4. `)(` contains a reversed and unbalanced order. Return `"false"`.

---

## 🏁 Summary

| Case | Input | Expected Output | Reason |
|------|--------|----------------|--------|
| 1 | `()` | `true` | Balanced |
| 2 | `[]{}` | `true` | Nested and balanced |
| 3 | `([()])` | `false` | Unbalanced |
| 4 | `)(` | `false` | Wrong order |

---

💡 *This problem tests your understanding of stack-based algorithms and bracket matching in Java.*
