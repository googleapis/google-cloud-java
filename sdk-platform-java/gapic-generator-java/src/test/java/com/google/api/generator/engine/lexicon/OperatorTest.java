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

package com.google.api.generator.engine.lexicon;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class OperatorTest {

  @Test
  void operatorsDetected() {
    assertThat(Operator.containsOperator("foo")).isFalse();

    assertThat(Operator.containsOperator("foo+foo")).isTrue();
    assertThat(Operator.containsOperator("fo:of-oo")).isTrue();
    assertThat(Operator.containsOperator("foo?foo")).isTrue();
    assertThat(Operator.containsOperator("as>df<a|{sdf")).isTrue();
    assertThat(Operator.containsOperator("!=foo")).isTrue();
    assertThat(Operator.containsOperator("fo%o")).isTrue();
    assertThat(Operator.containsOperator("foo|&")).isTrue();
  }
}
