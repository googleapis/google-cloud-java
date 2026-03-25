// Copyright 2022 Google LLC
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

package com.google.api.generator.test.utils;

import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.TypeNode.TypeKind;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;

public class TestExprBuilder {

  public static ValueExpr generateStringValueExpr(String value) {
    return ValueExpr.builder().setValue(StringObjectValue.withValue(value)).build();
  }

  public static VariableExpr generateClassValueExpr(String clazzName) {
    return VariableExpr.builder()
        .setVariable(Variable.builder().setType(TypeNode.CLASS_OBJECT).setName("class").build())
        .setStaticReferenceType(
            TypeNode.builder()
                .setReference(
                    VaporReference.builder().setName(clazzName).setPakkage("com.test").build())
                .setTypeKind(TypeKind.OBJECT)
                .build())
        .build();
  }
}
