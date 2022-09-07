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
import static org.junit.Assert.assertThrows;

import com.google.cloud.TransportOptions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LoggingOptionsTest {
  private static final Boolean DONT_AUTO_POPULATE_METADATA = false;
  private static final String PROJECT_ID = "fake-project-id";

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
}
