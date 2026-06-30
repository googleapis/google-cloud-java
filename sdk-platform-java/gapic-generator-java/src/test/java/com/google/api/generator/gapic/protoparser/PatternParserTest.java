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

package com.google.api.generator.gapic.protoparser;

import static com.google.common.truth.Truth.assertThat;

import java.util.Set;
import org.junit.jupiter.api.Test;

class PatternParserTest {
  @Test
  void getPattenBindings_shouldReturnEmptySetIfPatternIsEmpty() {
    assertThat(PatternParser.getPatternBindings("")).isEmpty();
  }

  @Test
  void getPattenBindings_shouldFilterOutUnboundVariables() {
    Set<String> actual = PatternParser.getPatternBindings("{routing_id=projects/*}/**");
    assertThat(actual).hasSize(1);
  }

  @Test
  void getPattenBindings_shouldReturnBindingsInNatualOrder() {
    Set<String> actual =
        PatternParser.getPatternBindings("{routing_id=projects/*}/{name=instance/*}");
    assertThat(actual).containsExactly("name", "routing_id").inOrder();
  }
}
