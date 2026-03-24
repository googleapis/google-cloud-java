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

package com.google.api.generator.gapic.model;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.generator.engine.ast.TypeNode;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

class MethodArgumentTest {
  @Test
  void compareMethodArguments() {
    BiFunction<String, TypeNode, MethodArgument> methodArgFn =
        (name, type) ->
            MethodArgument.builder()
                .setName(name)
                .setType(type)
                .setField(Field.builder().setName("foobar").setType(type).build())
                .build();

    // Cursory sanity-check of type-only differences, since these are already covered in the
    // TypeNode test.
    assertThat(
            methodArgFn
                .apply("foo", TypeNode.INT)
                .compareTo(methodArgFn.apply("foo", TypeNode.BOOLEAN)))
        .isGreaterThan(0);
    assertThat(
            methodArgFn
                .apply("foo", TypeNode.INT)
                .compareTo(methodArgFn.apply("foo", TypeNode.INT_OBJECT)))
        .isLessThan(0);

    // Non-type-based differences.
    Function<String, MethodArgument> simpleMethodArgFn =
        (name) -> methodArgFn.apply(name, TypeNode.INT);
    assertThat(simpleMethodArgFn.apply("foo").compareTo(simpleMethodArgFn.apply("bar")))
        .isGreaterThan(0);
    assertThat(simpleMethodArgFn.apply("bar").compareTo(simpleMethodArgFn.apply("foo")))
        .isLessThan(0);
  }
}
