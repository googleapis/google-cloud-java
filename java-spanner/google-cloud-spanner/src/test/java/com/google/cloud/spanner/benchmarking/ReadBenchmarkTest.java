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

import com.google.cloud.spanner.benchmarking.ReadBenchmark.BenchmarkState;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ReadRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadBenchmarkTest {

  @Test
  public void benchmarkStateConnectsToExternalStandaloneServerWhenEnvSet() throws Exception {
    try (StandaloneBenchmarkServer externalServer = StandaloneBenchmarkServer.start(0, 0)) {
      BenchmarkState state = new BenchmarkState();
      state.setup(
          String.valueOf(externalServer.getSpannerPort()),
          String.valueOf(externalServer.getMonitoringPort()));
      try {
        assertThat(System.getProperty("jmh.monitoring-server-port"))
            .isEqualTo(String.valueOf(externalServer.getMonitoringPort()));

        ReadBenchmark benchmark = new ReadBenchmark();
        benchmark.readBenchmark(state, null);
        benchmark.queryBenchmark(state, null);

        assertThat(
                externalServer.getMockSpannerService().countRequestsOfType(ExecuteSqlRequest.class))
            .isEqualTo(0);
        assertThat(externalServer.getMockSpannerService().countRequestsOfType(ReadRequest.class))
            .isEqualTo(0);
      } finally {
        state.tearDown();
      }
    }
  }

  @Test(expected = IllegalStateException.class)
  public void benchmarkStateSetupThrowsWhenSpannerPortMissing() throws Exception {
    BenchmarkState state = new BenchmarkState();
    state.setup(null, null);
  }
}
