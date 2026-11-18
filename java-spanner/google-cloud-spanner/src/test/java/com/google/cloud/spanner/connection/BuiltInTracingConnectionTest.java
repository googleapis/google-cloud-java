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

package com.google.cloud.spanner.connection;

import static com.google.common.truth.Truth.assertThat;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerOptionsTestHelper;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.data.SpanData;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BuiltInTracingConnectionTest extends AbstractMockServerTest {
  private InMemorySpanExporter spanExporter;

  @Before
  public void setUpBuiltInTracing() {
    SpannerOptionsTestHelper.resetActiveTracingFramework();
    GlobalOpenTelemetry.resetForTest();
    spanExporter = InMemorySpanExporter.create();
    SpannerOptionsTestHelper.setBuiltInTracingSpanExporter(spanExporter);
  }

  @After
  public void resetBuiltInTracing() {
    SpannerPool.closeSpannerPool();
    SpannerOptionsTestHelper.resetBuiltInTracing();
    GlobalOpenTelemetry.resetForTest();
    SpannerOptionsTestHelper.resetActiveTracingFramework();
  }

  @Test
  public void connectionSpansAreRecordedByBuiltInTracing() {
    try (Connection connection =
        ConnectionOptions.newBuilder()
            .setUri(getBaseUrl())
            .setConfigurator(
                builder ->
                    builder
                        .setCredentials(OAuth2Credentials.create(new AccessToken("token", null)))
                        .setEnableBuiltInTracing(true)
                        .setBuiltInTracingSamplingRate(1.0))
            .build()
            .getConnection()) {
      connection.setAutocommit(true);
      try (ResultSet resultSet = connection.executeQuery(SELECT1_STATEMENT)) {
        while (resultSet.next()) {}
      }
      ((OpenTelemetrySdk) connection.getSpanner().getOptions().getTracingOpenTelemetry())
          .getSdkTracerProvider()
          .forceFlush()
          .join(10, TimeUnit.SECONDS);
    }

    List<String> spanNames =
        spanExporter.getFinishedSpanItems().stream()
            .map(SpanData::getName)
            .collect(Collectors.toList());
    assertThat(spanNames).contains("CloudSpanner.SingleUseTransaction");
    assertThat(spanNames).contains("CloudSpannerOperation.ExecuteStreamingQuery");
  }
}
