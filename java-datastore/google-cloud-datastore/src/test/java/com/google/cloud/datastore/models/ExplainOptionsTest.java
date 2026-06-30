/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.datastore.models;

import com.google.common.testing.EqualsTester;
import com.google.common.truth.Truth;
import org.junit.Test;

public class ExplainOptionsTest {
  @Test
  public void testModel() {
    com.google.datastore.v1.ExplainOptions builtProto =
        com.google.datastore.v1.ExplainOptions.newBuilder().setAnalyze(true).build();

    com.google.datastore.v1.ExplainOptions defaultProto =
        com.google.datastore.v1.ExplainOptions.newBuilder().build();

    ExplainOptions explainOptionsAnalyzeTrue = ExplainOptions.newBuilder().setAnalyze(true).build();
    ExplainOptions explainOptionsAnalyzeFalse =
        ExplainOptions.newBuilder().setAnalyze(false).build();
    ExplainOptions explainOptionsDefault = ExplainOptions.newBuilder().build();

    Truth.assertThat(explainOptionsAnalyzeTrue.shouldAnalyze()).isTrue();
    Truth.assertThat(explainOptionsAnalyzeTrue.toPb()).isEqualTo(builtProto);

    Truth.assertThat(explainOptionsAnalyzeFalse.shouldAnalyze()).isFalse();
    Truth.assertThat(explainOptionsAnalyzeFalse.toPb()).isEqualTo(defaultProto);

    Truth.assertThat(explainOptionsDefault.shouldAnalyze()).isFalse();
    Truth.assertThat(explainOptionsDefault.toPb()).isNotEqualTo(builtProto);
    Truth.assertThat(explainOptionsDefault.toPb()).isEqualTo(defaultProto);
    Truth.assertThat(explainOptionsDefault).isEqualTo(explainOptionsAnalyzeFalse);
  }

  @Test
  public void testEqualsAndHashcode() {
    ExplainOptions explainOptions = ExplainOptions.newBuilder().build();
    ExplainOptions explainOptions2 = ExplainOptions.newBuilder().setAnalyze(true).build();

    Truth.assertThat(explainOptions).isNotEqualTo(explainOptions2);
    EqualsTester equalsTester = new EqualsTester();
    equalsTester.addEqualityGroup(explainOptions, explainOptions).testEquals();

    Truth.assertThat(explainOptions.hashCode()).isNotEqualTo(explainOptions2.hashCode());
    Truth.assertThat(explainOptions.hashCode()).isEqualTo(explainOptions.hashCode());
  }
}
