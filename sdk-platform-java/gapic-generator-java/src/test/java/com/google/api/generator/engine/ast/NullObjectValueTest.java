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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class NullObjectValueTest {
  private static final String NULL_VALUE = "null";

  @Test
  void createNullObjectValue_valid() {
    NullObjectValue nullValue = NullObjectValue.create();
    assertEquals(NULL_VALUE, nullValue.value());
    assertThat(nullValue.type()).isEqualTo(TypeNode.NULL);
  }
}
