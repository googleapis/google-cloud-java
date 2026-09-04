/*
 * Copyright 2026 Google LLC
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

package com.example.spanner;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SampleTestBaseV2Test {

  @Test
  public void testDefaultFallbackToMySample() {
    assertThat(SampleTestBaseV2.resolveSampleDatabase(null, null, null)).isEqualTo("mysample");
    assertThat(SampleTestBaseV2.resolveSampleDatabase("", "", "")).isEqualTo("mysample");
  }

  @Test
  public void testDefaultPropertyReturnsMySample() {
    assertThat(SampleTestBaseV2.resolveSampleDatabase("mysample", null, null)).isEqualTo("mysample");
  }

  @Test
  public void testKokoroJava8SamplesAutoDetection() {
    assertThat(
            SampleTestBaseV2.resolveSampleDatabase(
                "mysample", null, "cloud-devrel/client-libraries/java/java-spanner/nightly/java8-samples"))
        .isEqualTo("mysample_java8");
  }

  @Test
  public void testKokoroJava11SamplesAutoDetection() {
    assertThat(
            SampleTestBaseV2.resolveSampleDatabase(
                "mysample", null, "cloud-devrel/client-libraries/java/java-spanner/nightly/java11-samples"))
        .isEqualTo("mysample_java11");
  }

  @Test
  public void testKokoroSamplesJobFallback() {
    assertThat(
            SampleTestBaseV2.resolveSampleDatabase(
                "mysample", null, "cloud-devrel/client-libraries/java/java-spanner/nightly/samples"))
        .isEqualTo("mysample");
  }

  @Test
  public void testExplicitSystemPropertyOverrideTakesPrecedence() {
    assertThat(
            SampleTestBaseV2.resolveSampleDatabase(
                "custom-db", null, "cloud-devrel/client-libraries/java/java-spanner/nightly/java8-samples"))
        .isEqualTo("custom-db");
  }

  @Test
  public void testExplicitEnvVarOverrideTakesPrecedence() {
    assertThat(
            SampleTestBaseV2.resolveSampleDatabase(
                "mysample", "env-custom-db", "cloud-devrel/client-libraries/java/java-spanner/nightly/java8-samples"))
        .isEqualTo("env-custom-db");
  }
}
