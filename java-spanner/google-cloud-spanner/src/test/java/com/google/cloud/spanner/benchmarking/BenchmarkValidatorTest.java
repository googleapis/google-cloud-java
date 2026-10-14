/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.benchmarking;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.spanner.benchmarking.BenchmarkValidator.ValidationException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BenchmarkValidatorTest {

  @Rule public TemporaryFolder tempFolder = new TemporaryFolder();

  @Test
  public void validatePassesWhenActualLatencyIsFasterThanBaseline() throws IOException {
    File actualFile = tempFolder.newFile("jmh-faster-result.json");
    String fasterJson =
        "[\n"
            + "  {\n"
            + "    \"benchmark\":"
            + " \"com.google.cloud.spanner.benchmarking.ReadBenchmark.queryBenchmark\",\n"
            + "    \"primaryMetric\": {\n"
            + "      \"scorePercentiles\": {\n"
            + "        \"50.0\": 320.0,\n"
            + "        \"95.0\": 600.0,\n"
            + "        \"99.0\": 900.0\n"
            + "      }\n"
            + "    }\n"
            + "  }\n"
            + "]";
    Files.write(actualFile.toPath(), fasterJson.getBytes(StandardCharsets.UTF_8));

    BenchmarkValidator validator =
        new BenchmarkValidator(
            "com/google/cloud/spanner/jmh/jmh-baseline.json", actualFile.getAbsolutePath());

    // Should not throw when latency improves by >20% (320.0 us/op vs 450.0 us/op baseline)
    validator.validate();
  }

  @Test
  public void validateThrowsWhenLatencyRegressesBeyondThreshold() throws IOException {
    File actualFile = tempFolder.newFile("jmh-slower-result.json");
    String slowerJson =
        "[\n"
            + "  {\n"
            + "    \"benchmark\":"
            + " \"com.google.cloud.spanner.benchmarking.ReadBenchmark.queryBenchmark\",\n"
            + "    \"primaryMetric\": {\n"
            + "      \"scorePercentiles\": {\n"
            + "        \"50.0\": 629.76,\n"
            + "        \"95.0\": 800.0,\n"
            + "        \"99.0\": 1200.0\n"
            + "      }\n"
            + "    }\n"
            + "  }\n"
            + "]";
    Files.write(actualFile.toPath(), slowerJson.getBytes(StandardCharsets.UTF_8));

    BenchmarkValidator validator =
        new BenchmarkValidator(
            "com/google/cloud/spanner/jmh/jmh-baseline.json", actualFile.getAbsolutePath());

    ValidationException ex = assertThrows(ValidationException.class, validator::validate);
    assertThat(ex.getMessage())
        .contains(
            "[com.google.cloud.spanner.benchmarking.ReadBenchmark.queryBenchmark][50.0] Expected"
                + " percentile 450.0[+/-20.0] but got 629.76");
  }
}
