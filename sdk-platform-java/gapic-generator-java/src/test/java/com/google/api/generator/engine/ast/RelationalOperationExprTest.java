// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.engine.ast;

import static org.junit.Assert.assertThrows;

import com.google.api.generator.engine.ast.TypeNode.TypeKind;
import org.junit.jupiter.api.Test;

class RelationalOperationExprTest {
  /** ==================== Equality Operators: LHS data type is numeric ======================= */
  @Test
  void equalToOperationExpr_validBasic() {
    // LHS: numeric type, RHS: matched numeric type.
    // No need swap LHS and RHS test case.
    VariableExpr lhsExpr = createVariableExpr(TypeNode.INT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.INT, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validNumericTYpe() {
    // LHS: numeric type, RHS: unmatched numeric type.
    // No need swap LHS and RHS test case.
    VariableExpr lhsExpr = createVariableExpr(TypeNode.CHAR, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.LONG, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void notEqualToOperationExpr_validMatchedNumericBoxTYpe() {
    // LHS: numeric type, RHS: matched numeric Boxed type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_validBoxedWithMatchedUnBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.FLOAT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.FLOAT_OBJECT, "y");
    RelationalOperationExpr.notEqualToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void notEqualToOperationExpr_validNumericBoxTYpe() {
    // LHS: numeric type, RHS: unmatched numeric Boxed type.
    // Swapping LHS and RHS test case is covered in
    // equalToOperationExpr_validBoxedWithUnmatchedUnBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.FLOAT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.DOUBLE_OBJECT, "y");
    RelationalOperationExpr.notEqualToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_invalidNumericBooleanBoxedType() {
    // LHS: numeric type, RHS: boolean boxed Type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidBoxedBooleanWithNumericType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.FLOAT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.BOOLEAN_OBJECT, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void notEqualToOperationExpr_invalidNumericStringType() {
    // LHS: numeric type, RHS: referenced type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidReferenceWithNumericType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.DOUBLE, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.STRING, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.notEqualToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void notEqualToOperationExpr_invalidNumericNullType() {
    // LHS: numeric type, RHS: null.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidNullWithNumericType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.DOUBLE, "x");
    ValueExpr rhsExpr = ValueExpr.createNullExpr();
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.notEqualToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidNumericBooleanType() {
    // LHS: numeric type, RHS: boolean boxed Type.
    // Swapping LHS and RHS test case is covered in
    // notEqualToOperationExpr_invalidBooleanToNumericType.
    VariableExpr lhsExpr = createVariableExpr(TypeNode.LONG, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.BOOLEAN, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidNumericTypeWithArrayType() {
    // LHS: Numeric Type, RHS: Array with numeric type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidArrayWithNotArrayType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.INT, "x");
    VariableExpr rhsExpr =
        createVariableExpr(
            TypeNode.builder().setIsArray(true).setTypeKind(TypeKind.INT).build(), "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  /** =============== Equality Operators: LHS data type is numeric boxed type ================ */
  @Test
  void equalToOperationExpr_validBoxedWithMatchedBoxedType() {
    // LHS: Boxed type, RHS: Matched Boxed.
    // No need swap LHS and RHS test case.
    VariableExpr lhsExpr = createVariableExpr(TypeNode.INT_OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.INT_OBJECT, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validBoxedWithMatchedUnBoxedType() {
    // LHS: Boxed type, RHS: Unmatched Boxed.
    // Swapping LHS and RHS test case is covered in
    // "notEqualToOperationExpr_validMatchedNumericBoxTYpe".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.FLOAT_OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.FLOAT, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validBoxedWithUnmatchedUnBoxedType() {
    // LHS: Numeric boxed type, RHS: other numeric type.
    // Swapping LHS and RHS test case is covered in "notEqualToOperationExpr_validNumericBoxTYpe".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.FLOAT_OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.DOUBLE, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validNumericBoxedWithNullType() {
    // LHS: Boxed type, RHS: Null.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_validNullWithNumericBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.FLOAT_OBJECT, "x");
    ValueExpr rhsExpr = ValueExpr.createNullExpr();
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validNumericBoxedWithNewObjectType() {
    // LHS: Numeric boxed type, RHS: new object.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_validObjectWithNumericBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.FLOAT_OBJECT, "x");
    NewObjectExpr rhsExpr = NewObjectExpr.withType(TypeNode.OBJECT);
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_invalidNumericBoxedWithBooleanType() {
    // LHS: Numeric boxed type, RHS: Boolean type.
    // Swapping LHS and RHS test case is covered in
    // "notEqualToOperationExpr_invalidBooleanToOtherBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.FLOAT_OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.BOOLEAN, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidNumericBoxedWithBooleanBoxedType() {
    // LHS: Numeric boxed type, RHS: Boolean Boxed type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidBooleanBoxedWithNumericBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.FLOAT_OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.BOOLEAN_OBJECT, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidNumericBoxedWithReferenceType() {
    // LHS: Numeric boxed type, RHS: Reference type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidReferenceWithNumericBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.FLOAT_OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.STRING, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  /** ============= Equality Operators: LHS data type is boolean or its boxed type ============== */
  @Test
  void equalToOperationExpr_validBooleanType() {
    // LHS: boolean type, RHS: boolean Type.
    // No need swap LHS and RHS test case.
    VariableExpr lhsExpr = createVariableExpr(TypeNode.BOOLEAN, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.BOOLEAN, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validRHSBooleanBoxedType() {
    // LHS: boolean type, RHS: boolean boxed Type.
    // Swapping LHS and RHS test case is covered in "equalToOperationExpr_validLHSBooleanBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.BOOLEAN, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.BOOLEAN_OBJECT, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validLHSBooleanBoxedType() {
    // LHS: boolean boxed type, RHS: boolean Type.
    // Swapping LHS and RHS test case is covered in "equalToOperationExpr_validRHSBooleanBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.BOOLEAN_OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.BOOLEAN, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void notEqualToOperationExpr_validBooleanBoxedToNullType() {
    // LHS: boolean boxed type, RHS: null.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_validNullWithBooleanBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.BOOLEAN_OBJECT, "x");
    ValueExpr rhsExpr = ValueExpr.createNullExpr();
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void notEqualToOperationExpr_validBooleanBoxedToObjectType() {
    // LHS: boolean boxed type, RHS: null.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_validObjectWithBooleanBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.BOOLEAN_OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.OBJECT, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void notEqualToOperationExpr_invalidBooleanToNumericType() {
    // LHS: boolean type, RHS: char boxed type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidNumericBooleanType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.BOOLEAN, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.CHAR, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.notEqualToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void notEqualToOperationExpr_invalidBooleanToOtherBoxedType() {
    // LHS: boolean type, RHS: numeric boxed type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidNumericBoxedWithBooleanType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.BOOLEAN, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.CHAR_OBJECT, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.notEqualToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void notEqualToOperationExpr_invalidBooleanToReferenceType() {
    // LHS: boolean type, RHS: object type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidReferenceWithBooleanType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.BOOLEAN, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.STRING, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.notEqualToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidBooleanWithNullType() {
    // LHS: boolean type, RHS: null type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidNullWithBooleanType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.BOOLEAN, "x");
    ValueExpr rhsExpr = ValueExpr.createNullExpr();
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidBooleanWithObjectType() {
    // LHS: boolean type, RHS: object type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidObjectWithBooleanType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.BOOLEAN, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.OBJECT, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidBoxedBooleanWithNumericType() {
    // LHS: boolean boxed type, RHS: numeric
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidNumericBooleanBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.BOOLEAN_OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.INT, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidBooleanBoxedWithNumericBoxedType() {
    // LHS: boolean boxed type, RHS: numeric
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidNumericBoxedWithBooleanBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.BOOLEAN_OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.INT_OBJECT, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidBoxedBooleanWithReferencedType() {
    // LHS: boolean boxed type, RHS: reference type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidReferenceWithBooleanBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.BOOLEAN_OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.STRING, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  /** ===================== Equality Operators: LHS data type is Array ======================== */
  @Test
  void equalToOperationExpr_validArrayWithMatchedType() {
    // LHS: Array with numeric type, RHS: Array with matched numeric type.
    // No need swap LHS and RHS test case.
    VariableExpr lhsExpr =
        createVariableExpr(
            TypeNode.builder().setIsArray(true).setTypeKind(TypeKind.INT).build(), "x");
    VariableExpr rhsExpr =
        createVariableExpr(
            TypeNode.builder().setIsArray(true).setTypeKind(TypeKind.INT).build(), "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validArrayWithNullType() {
    // LHS: Array with numeric type, RHS: null
    // Swapping LHS and RHS test case is covered in "equalToOperationExpr_validANullWithArrayType".
    VariableExpr lhsExpr =
        createVariableExpr(
            TypeNode.builder().setIsArray(true).setTypeKind(TypeKind.INT).build(), "x");
    NullObjectValue nullObjectValue = NullObjectValue.create();
    ValueExpr rhsExpr = ValueExpr.withValue(nullObjectValue);
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void notEqualToOperationExpr_invalidArrayWithUnmatchedType() {
    // LHS: Array with numeric type, RHS: Array with unmatched numeric type.
    // No need swap LHS and RHS test case.
    VariableExpr lhsExpr =
        createVariableExpr(
            TypeNode.builder().setIsArray(true).setTypeKind(TypeKind.INT).build(), "x");
    VariableExpr rhsExpr =
        createVariableExpr(
            TypeNode.builder().setIsArray(true).setTypeKind(TypeKind.CHAR).build(), "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.notEqualToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidArrayWithNotArrayType() {
    // LHS: Array with numeric type, RHS: not Array
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidNumericTypeWithArrayType".
    VariableExpr lhsExpr =
        createVariableExpr(
            TypeNode.builder().setIsArray(true).setTypeKind(TypeKind.INT).build(), "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.INT, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidArrayWithObjectType() {
    // LHS: Array with numeric type, RHS: New Object type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidObjectTypeWithArray".
    VariableExpr lhsExpr =
        createVariableExpr(
            TypeNode.builder().setIsArray(true).setTypeKind(TypeKind.INT).build(), "x");
    NewObjectExpr rhsExpr = NewObjectExpr.withType(TypeNode.OBJECT);
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  /** ================== Equality Operators: LHS data type is reference type =================== */
  @Test
  void equalToOperationExpr_validReferenceWithMatchedType() {
    // LHS: String type, RHS: matched String type.
    // No need swap LHS and RHS test case.
    VariableExpr lhsExpr = createVariableExpr(TypeNode.STRING, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.STRING, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validReferenceWithNullType() {
    // LHS: String type, RHS: null.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_validNullWithReferenceType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.STRING, "x");
    ValueExpr rhsExpr = ValueExpr.createNullExpr();
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validReferenceWithObjectType() {
    // LHS: String type, RHS: New object type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_validObjectWithStringType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.STRING, "x");
    NewObjectExpr rhsExpr = NewObjectExpr.withType(TypeNode.OBJECT);
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validAnyObjectTypeWithObject() {
    // LHS: Any reference type, RHS: Object type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_validObjectWithAnyObjectType".
    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.some.pakkage")
                .build());
    VariableExpr lhsExpr = createVariableExpr(someType, "y");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.OBJECT, "x");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validAnyReferenceTypeWithNull() {
    // LHS: Any reference type, RHS: Null type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_validNullWithAnyReferenceType".
    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.some.pakkage")
                .build());
    VariableExpr lhsExpr = createVariableExpr(someType, "y");
    ValueExpr rhsExpr = ValueExpr.createNullExpr();
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_invalidReferenceWithUnmatchedReferenceType() {
    // LHS: String type, RHS: Unmatched reference type.
    // No need swap LHS and RHS test case.
    VariableExpr lhsExpr = createVariableExpr(TypeNode.STRING, "x");
    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.some.pakkage")
                .build());
    VariableExpr rhsExpr = createVariableExpr(someType, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidReferenceWithNumericType() {
    // LHS: String type, RHS: Numeric type
    // Swapping LHS and RHS test case is covered in
    // "notEqualToOperationExpr_invalidNumericStringType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.STRING, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.DOUBLE, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidReferenceWithNumericBoxedType() {
    // LHS: String type, RHS: numeric boxed type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidNumericBoxedWithReferenceType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.STRING, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.DOUBLE_OBJECT, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidReferenceWithBooleanType() {
    // LHS: String type, RHS: Boolean boxed type.
    // Swapping LHS and RHS test case is covered in
    // "notEqualToOperationExpr_invalidBooleanToReferenceType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.STRING, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.BOOLEAN, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidReferenceWithBooleanBoxedType() {
    // LHS: String type, RHS: Boolean boxed type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidBoxedBooleanWithReferencedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.STRING, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.BOOLEAN_OBJECT, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  /** ================== Equality Operators: LHS data type is Object or null =================== */
  @Test
  void equalToOperationExpr_validObjectWithAnyObjectType() {
    // LHS: Object type, RHS: Any reference type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_validAnyObjectTypeWithObject".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.OBJECT, "x");
    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.some.pakkage")
                .build());
    VariableExpr rhsExpr = createVariableExpr(someType, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validNullWithAnyReferenceType() {
    // LHS: Null type, RHS: any reference type
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_validAnyReferenceTypeWithNull".
    ValueExpr lhsExpr = ValueExpr.createNullExpr();
    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.some.pakkage")
                .build());
    VariableExpr rhsExpr = createVariableExpr(someType, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validObjectWithNullType() {
    // LHS: Object, RHS: Null.
    // Swapping LHS and RHS test case is covered in "equalToOperationExpr_validNullWithObjectType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.OBJECT, "x");
    ValueExpr rhsExpr = ValueExpr.createNullExpr();
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validNullWithObjectType() {
    // LHS: Null, RHS: Object.
    // Swapping LHS and RHS test case is covered in "equalToOperationExpr_validObjectWithNullType".
    VariableExpr rhsExpr = createVariableExpr(TypeNode.OBJECT, "x");
    ValueExpr lhsExpr = ValueExpr.createNullExpr();
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validNullWithNullType() {
    // LHS: Null, RHS: Null.
    // No need swap LHS and RHS test case.
    ValueExpr lhsExpr = ValueExpr.createNullExpr();
    ValueExpr rhsExpr = ValueExpr.createNullExpr();
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validObjectWithStringType() {
    // LHS: Object type, RHS: Reference type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_validReferenceWithObjectType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.STRING, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validObjectWithBooleanBoxedType() {
    // LHS: Object type, RHS: Boolean boxed type.
    // Swapping LHS and RHS test case is covered in
    // "notEqualToOperationExpr_validBooleanBoxedToObjectType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.BOOLEAN_OBJECT, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validObjectWithNumericBoxedType() {
    // LHS: Object type, RHS: Any Boxed type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_validNumericBoxedWithNewObjectType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.SHORT_OBJECT, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validNullWithReferenceType() {
    // LHS: Null type, RHS: Reference type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_validNullWithReferenceType".
    ValueExpr lhsExpr = ValueExpr.createNullExpr();
    VariableExpr rhsExpr = createVariableExpr(TypeNode.STRING, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validNullWithBooleanBoxedType() {
    // LHS: Object type, RHS: Any Boxed type
    // Swapping LHS and RHS test case is covered in
    // "notEqualToOperationExpr_validBooleanBoxedToNullType".
    ValueExpr lhsExpr = ValueExpr.createNullExpr();
    VariableExpr rhsExpr = createVariableExpr(TypeNode.BOOLEAN_OBJECT, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validNullWithNumericBoxedType() {
    // LHS: Object type, RHS: Any Boxed type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_validNumericBoxedWithNullType".
    ValueExpr lhsExpr = ValueExpr.createNullExpr();
    VariableExpr rhsExpr = createVariableExpr(TypeNode.DOUBLE_OBJECT, "y");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_validANullWithArrayType() {
    // LHS: Null, RHS: Array with numeric type.
    // Swapping LHS and RHS test case is covered in "equalToOperationExpr_validArrayWithNullType".
    NullObjectValue nullObjectValue = NullObjectValue.create();
    ValueExpr lhsExpr = ValueExpr.withValue(nullObjectValue);
    VariableExpr rhsExpr =
        createVariableExpr(
            TypeNode.builder().setIsArray(true).setTypeKind(TypeKind.INT).build(), "x");
    RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void equalToOperationExpr_invalidNullWithNumericType() {
    // LHS: Null type, RHS: Nny Numeric type.
    // Swapping LHS and RHS test case is covered in
    // "notEqualToOperationExpr_invalidNumericNullType".
    ValueExpr lhsExpr = ValueExpr.createNullExpr();
    VariableExpr rhsExpr = createVariableExpr(TypeNode.INT, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidNullWithBooleanType() {
    // LHS: Null type, RHS: Boolean type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidBooleanWithNullType".
    ValueExpr lhsExpr = ValueExpr.createNullExpr();
    VariableExpr rhsExpr = createVariableExpr(TypeNode.BOOLEAN, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidObjectWithNumericType() {
    // LHS: Object type, RHS: Any Numeric type.
    VariableExpr lhsExpr = createVariableExpr(TypeNode.OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.DOUBLE, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidObjectWithBooleanType() {
    // LHS: Object type, RHS: Boolean type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidBooleanWithObjectType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.BOOLEAN, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void equalToOperationExpr_invalidObjectTypeWithArray() {
    // LHS: New Object type, RHS: Array with numeric type.
    // Swapping LHS and RHS test case is covered in
    // "equalToOperationExpr_invalidArrayWithObjectType".
    NewObjectExpr lhsExpr = NewObjectExpr.withType(TypeNode.OBJECT);
    VariableExpr rhsExpr =
        createVariableExpr(
            TypeNode.builder().setIsArray(true).setTypeKind(TypeKind.INT).build(), "x");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr));
  }

  /** ================== Less Than Operators: expr types are numeric types =================== */
  // The expression types on LHS or RHS could be any numeric type or any numeric boxed type.
  @Test
  void lessThanOperationExpr_validMatchedNumericType() {
    // LHS: Numeric type, RHS: Matched numeric type.
    // No need swap LHS and RHS test case.
    VariableExpr lhsExpr = createVariableExpr(TypeNode.INT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.INT, "y");
    RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void lessThanOperationExpr_validUnmatchedNumericType() {
    // LHS: Numeric type, RHS: Unmatched numeric type.
    // No need swap LHS and RHS test case.
    VariableExpr lhsExpr = createVariableExpr(TypeNode.INT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.SHORT, "y");
    RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void lessThanOperationExpr_validMatchedNumericBoxedType() {
    // LHS: Numeric type, RHS: Matched numeric type.
    // Swap case in "lessThanOperationExpr_validNumericBoxedTypeWithMatchedNumericType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.FLOAT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.FLOAT_OBJECT, "y");
    RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void lessThanOperationExpr_validNumericBoxedTypeWithMatchedNumericType() {
    // LHS: Numeric boxed type, RHS: Matched numeric type.
    // Swap case in "lessThanOperationExpr_validMatchedNumericBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.CHAR_OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.CHAR, "y");
    RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void lessThanOperationExpr_validUnmatchedNumericBoxedType() {
    // LHS: Numeric type, RHS: Unmatched numeric boxed type.
    // Swap case in "lessThanOperationExpr_validNumericBoxedTypeWithUnmatchedUnBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.DOUBLE, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.LONG_OBJECT, "y");
    RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void lessThanOperationExpr_validNumericBoxedTypeWithUnmatchedUnBoxedType() {
    // LHS: Numeric boxed type, RHS: Unmatched numeric type.
    // Swap case in "lessThanOperationExpr_validUnmatchedNumericBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.INT_OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.BYTE, "y");
    RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void lessThanOperationExpr_validNumericBoxedTypeWithMatchedBoxedType() {
    // LHS: Numeric boxed type, RHS: Matched numeric boxed type.
    // No need swap case.
    VariableExpr lhsExpr = createVariableExpr(TypeNode.INT_OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.INT_OBJECT, "y");
    RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void lessThanOperationExpr_validNumericBoxedTypeWithUnmatchedBoxedType() {
    // LHS: Numeric boxed type, RHS: Unmatched numeric boxed type.
    // No need swap case.
    VariableExpr lhsExpr = createVariableExpr(TypeNode.INT_OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.LONG_OBJECT, "y");
    RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  /** ================= Less Than Operators: expr types are non-numeric types ================== */
  // Invalid if any of expression type on LHS or RHS is non-numeric type or non numeric boxed type.
  @Test
  void lessThanOperationExpr_invalidNumericTypeWithNullType() {
    // LHS: Null type, RHS: Numeric type.
    // Swap case in "lessThanOperationExpr_invalidNumericWithNullType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.INT, "x");
    ValueExpr rhsExpr = ValueExpr.createNullExpr();
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void lessThanOperationExpr_invalidNumericBoxedTypeWithNullType() {
    // LHS: Numeric boxed type, RHS: Null type.
    // Swap case in "lessThanOperationExpr_invalidNullWithNumericBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.INT_OBJECT, "x");
    ValueExpr rhsExpr = ValueExpr.createNullExpr();
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void lessThanOperationExpr_invalidNumericTypeWithObjectType() {
    // LHS: Numeric type, RHS: Object Type.
    // Swap case in "lessThanOperationExpr_invalidObjectNumericType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.INT, "x");
    NewObjectExpr rhsExpr = NewObjectExpr.withType(TypeNode.OBJECT);
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void lessThanOperationExpr_invalidNumericBoxedTypeWithObjectType() {
    // LHS: Numeric boxed type, RHS: Object Type.
    // Swap case in "lessThanOperationExpr_invalidObjectNumericBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.INT_OBJECT, "x");
    NewObjectExpr rhsExpr = NewObjectExpr.withType(TypeNode.OBJECT);
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void lessThanOperationExpr_invalidNumericBoxedTypeWithReferenceType() {
    // LHS: Numeric boxed type, RHS: Reference Type.
    // Swap case in "lessThanOperationExpr_invalidReferenceTypeWithNumericBoxedType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.INT_OBJECT, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.STRING, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void lessThanOperationExpr_invalidReferenceTypeWithNumericBoxedType() {
    // LHS: Reference type, RHS: Numeric boxed Type.
    // Swap case in "lessThanOperationExpr_invalidNumericBoxedTypeWithReferenceType".
    VariableExpr lhsExpr = createVariableExpr(TypeNode.STRING, "x");
    VariableExpr rhsExpr = createVariableExpr(TypeNode.INT_OBJECT, "y");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void lessThanOperationExpr_invalidObjectNumericType() {
    // LHS: Object type, RHS: Numeric Type.
    // Swap case in "lessThanOperationExpr_invalidNumericTypeWithObjectType".
    NewObjectExpr lhsExpr = NewObjectExpr.withType(TypeNode.OBJECT);
    VariableExpr rhsExpr = createVariableExpr(TypeNode.INT, "x");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void lessThanOperationExpr_invalidObjectNumericBoxedType() {
    // LHS: Object type, RHS: Numeric boxed Type.
    // Swap case in "lessThanOperationExpr_invalidNumericBoxedTypeWithObjectType".
    NewObjectExpr lhsExpr = NewObjectExpr.withType(TypeNode.OBJECT);
    VariableExpr rhsExpr = createVariableExpr(TypeNode.INT_OBJECT, "x");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void lessThanOperationExpr_invalidNumericWithNullType() {
    // LHS: Null type, RHS: Numeric box type.

    ValueExpr lhsExpr = ValueExpr.createNullExpr();
    VariableExpr rhsExpr = createVariableExpr(TypeNode.INT, "x");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void lessThanOperationExpr_invalidNullWithNumericBoxedType() {
    // LHS: Null type, RHS: Numeric box type.
    // Swap case in "lessThanOperationExpr_invalidNumericTypeWithNullType".
    ValueExpr lhsExpr = ValueExpr.createNullExpr();
    VariableExpr rhsExpr = createVariableExpr(TypeNode.INT_OBJECT, "x");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void lessThanOperationExpr_invalidVoidType() {
    // LHS: Null type, RHS: Numeric box type.
    // No need swap case
    MethodInvocationExpr lhsExpr =
        MethodInvocationExpr.builder()
            .setMethodName("doNothing")
            .setReturnType(TypeNode.VOID)
            .build();
    VariableExpr rhsExpr = createVariableExpr(TypeNode.INT_OBJECT, "x");
    assertThrows(
        IllegalStateException.class,
        () -> RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr));
  }

  private VariableExpr createVariableExpr(TypeNode type, String name) {
    Variable variable = Variable.builder().setName(name).setType(type).build();
    VariableExpr variableExpr = VariableExpr.withVariable(variable);
    return variableExpr;
  }
}
