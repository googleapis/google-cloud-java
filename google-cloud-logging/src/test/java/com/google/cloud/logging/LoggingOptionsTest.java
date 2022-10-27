/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.logging;

import static org.easymock.EasyMock.createMock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.cloud.NoCredentials;
import com.google.cloud.TransportOptions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class LoggingOptionsTest {
  private static final Boolean DONT_AUTO_POPULATE_METADATA = false;
  private static final String PROJECT_ID = "fake-project-id";
  private static final Long ELEMENTS_TRESHOLD_COUNT = 100L;
  private static final Long REQUEST_BYTE_TRESHOLD_COUNT = 10485760L;
  private static final long DURATION = 501L;
  private static final Long MAX_OUTSTANDING_ELEMENTS_COUNT = 1000001L;
  private static final Long MAX_OUTSTANDING_REQUEST_BYTES_COUNT = 104857601L;

  @Test
  public void testNonGrpcTransportOptions() {
    TransportOptions invalidTransport = createMock(TransportOptions.class);
    assertThrows(
        IllegalArgumentException.class,
        () -> LoggingOptions.newBuilder().setTransportOptions(invalidTransport));
  }

  @Test
  public void testAutoPopulateMetadataOption() {
    LoggingOptions actual =
        LoggingOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setAutoPopulateMetadata(DONT_AUTO_POPULATE_METADATA)
            .build();
    assertEquals(DONT_AUTO_POPULATE_METADATA, actual.getAutoPopulateMetadata());
  }

  @Test
  public void testAutoPopulateMetadataDefaultOption() {
    LoggingOptions actual = LoggingOptions.newBuilder().setProjectId(PROJECT_ID).build();
    assertEquals(Boolean.TRUE, actual.getAutoPopulateMetadata());
  }

  @Test
  public void testBatchingSettingsDefaultOption() {
    LoggingOptions actual = LoggingOptions.newBuilder().setProjectId(PROJECT_ID).build();
    assertNull("Batching settings should be null by default!", actual.getBatchingSettings());
  }

  @Test
  public void testBatchingSettingsOption() {
    verifyBatchingSettings(generateLoggingOptions().getBatchingSettings());
  }

  @Test
  public void testBatchingSettingsOptionWithGrpc() {
    verifyBatchingSettings(
        generateLoggingOptions().getService().getOptions().getBatchingSettings());
  }

  private static LoggingOptions generateLoggingOptions() {
    return LoggingOptions.newBuilder()
        .setBatchingSettings(
            BatchingSettings.newBuilder()
                .setIsEnabled(true)
                .setElementCountThreshold(ELEMENTS_TRESHOLD_COUNT)
                .setRequestByteThreshold(REQUEST_BYTE_TRESHOLD_COUNT)
                .setDelayThreshold(Duration.ofMillis(DURATION))
                .setFlowControlSettings(
                    FlowControlSettings.newBuilder()
                        .setMaxOutstandingElementCount(MAX_OUTSTANDING_ELEMENTS_COUNT)
                        .setMaxOutstandingRequestBytes(MAX_OUTSTANDING_REQUEST_BYTES_COUNT)
                        .setLimitExceededBehavior(
                            FlowController.LimitExceededBehavior.ThrowException)
                        .build())
                .build())
        .setProjectId(PROJECT_ID)
        .setCredentials(NoCredentials.getInstance())
        .build();
  }

  private static void verifyBatchingSettings(BatchingSettings settings) {
    assertEquals(true, settings.getIsEnabled());
    assertEquals(ELEMENTS_TRESHOLD_COUNT, settings.getElementCountThreshold());
    assertEquals(REQUEST_BYTE_TRESHOLD_COUNT, settings.getRequestByteThreshold());
    assertNotNull(settings.getDelayThreshold());
    assertEquals(DURATION, settings.getDelayThreshold().toMillis());
    assertEquals(
        MAX_OUTSTANDING_ELEMENTS_COUNT,
        settings.getFlowControlSettings().getMaxOutstandingElementCount());
    assertEquals(
        MAX_OUTSTANDING_REQUEST_BYTES_COUNT,
        settings.getFlowControlSettings().getMaxOutstandingRequestBytes());
    assertEquals(
        FlowController.LimitExceededBehavior.ThrowException,
        settings.getFlowControlSettings().getLimitExceededBehavior());
  }
}
