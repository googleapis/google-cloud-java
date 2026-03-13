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

package com.google.api.generator.gapic.model;

import com.google.api.generator.gapic.model.HttpBindings.HttpVerb;
import com.google.common.truth.Truth;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class ResourceNameTest {
  private final ResourceName resName =
      ResourceName.builder()
          .setVariableName("topic")
          .setPakkage("com.google.pubsub.v1")
          .setResourceTypeString("pubsub.googleapis.com/Topic")
          .setPatterns(Arrays.asList("_deleted-topic_", "projects/{project}/topics/{topic}"))
          .setParentMessageName("com.google.pubsub.v1.Topic")
          .build();

  @Test
  void getMatchingPattern() {
    HttpBindings bindings =
        HttpBindings.builder()
            .setHttpVerb(HttpVerb.PUT)
            .setPattern("/v1/{name=projects/*/topics/*}")
            .setAdditionalPatterns(Collections.emptyList())
            .setIsAsteriskBody(true)
            .build();

    String matchingPattern = resName.getMatchingPattern(bindings);
    Truth.assertThat(matchingPattern).isEqualTo("projects/{project}/topics/{topic}");
  }

  @Test
  void getMatchingPatternFromAdditionalPattern() {
    HttpBindings bindings =
        HttpBindings.builder()
            .setHttpVerb(HttpVerb.PUT)
            .setPattern("/v1/{name=projects/*/subscriptions/*}")
            .setAdditionalPatterns(Collections.singletonList("/v1/{name=projects/*/topics/*}"))
            .setIsAsteriskBody(true)
            .build();

    String matchingPattern = resName.getMatchingPattern(bindings);
    Truth.assertThat(matchingPattern).isEqualTo("projects/{project}/topics/{topic}");
  }

  @Test
  void getMatchingPatternNoMatch() {
    HttpBindings bindings =
        HttpBindings.builder()
            .setHttpVerb(HttpVerb.PUT)
            .setPattern("/v1/{name=projects/*/subscriptions/*}")
            .setAdditionalPatterns(Collections.singletonList("/v1/{name=projects/*/stuff/*}"))
            .setIsAsteriskBody(true)
            .build();

    String matchingPattern = resName.getMatchingPattern(bindings);
    Truth.assertThat(matchingPattern).isNull();
  }
}
