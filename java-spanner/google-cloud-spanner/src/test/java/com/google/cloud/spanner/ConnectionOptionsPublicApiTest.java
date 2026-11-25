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

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.connection.ConnectionOptions.StartupPropertyPolicy;
import com.google.cloud.spanner.connection.ConnectionProperties;
import com.google.cloud.spanner.connection.ConnectionPropertyValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Verifies programmatic {@link ConnectionPropertyValue} access from outside the connection package.
 */
@RunWith(JUnit4.class)
public class ConnectionOptionsPublicApiTest {

  @Test
  public void testExternalPackageCanBuildConnectionPropertyValues() {
    ConnectionPropertyValue<String> endpoint =
        ConnectionPropertyValue.of(ConnectionProperties.ENDPOINT, "external.example.com:443");
    assertSame(ConnectionProperties.ENDPOINT, endpoint.getProperty());
    assertEquals("external.example.com:443", endpoint.getValue());
    assertEquals("external.example.com:443", endpoint.getResetValue());

    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
            .setUri(
                "cloudspanner:/projects/test-project/instances/test-instance/databases/test-db?autocommit=true")
            .setConnectionPropertyValue(endpoint)
            .setConnectionPropertyValue(
                ConnectionPropertyValue.of(ConnectionProperties.USE_PLAIN_TEXT, true))
            .setConnectionPropertyValue(
                ConnectionPropertyValue.of(ConnectionProperties.AUTOCOMMIT, false))
            .setConnectionPropertyValue(
                ConnectionPropertyValue.of(ConnectionProperties.DIALECT, Dialect.POSTGRESQL))
            .setConnectionPropertyValue(
                ConnectionPropertyValue.of(ConnectionProperties.ENABLE_END_TO_END_TRACING, true))
            .build();

    assertEquals("http://external.example.com:443", options.getHost());
    assertFalse(options.isAutocommit());
    assertEquals(Dialect.POSTGRESQL, options.getDialect());
    assertTrue(options.isEndToEndTracingEnabled());

    SpannerException rejected =
        assertThrows(
            SpannerException.class,
            () ->
                ConnectionOptions.newBuilder()
                    .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                    .setUri(
                        "cloudspanner:/projects/test-project/instances/test-instance/databases/test-db?endpoint=evil.example.com:443")
                    .build());
    assertEquals(ErrorCode.INVALID_ARGUMENT, rejected.getErrorCode());
  }
}
