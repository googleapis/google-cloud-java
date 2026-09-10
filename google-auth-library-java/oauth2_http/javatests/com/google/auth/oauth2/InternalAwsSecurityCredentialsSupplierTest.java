/*
 * Copyright 2024 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.auth.oauth2;

import static com.google.auth.oauth2.AwsCredentialsTest.buildAwsImdsv2CredentialSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.auth.oauth2.ExternalAccountCredentialsTest.MockExternalAccountCredentialsTransportFactory;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.jupiter.api.Test;

/** Tests for {@link InternalAwsSecurityCredentialsSupplier}. */
class InternalAwsSecurityCredentialsSupplierTest extends BaseSerializationTest {
  @Test
  void shouldUseMetadataServer_withRequiredEnvironmentVariables() {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    // Add required environment variables.
    List<String> regionKeys = ImmutableList.of("AWS_REGION", "AWS_DEFAULT_REGION");
    for (String regionKey : regionKeys) {
      TestEnvironmentProvider environmentProvider = new TestEnvironmentProvider();
      // AWS_ACCESS_KEY_ID and AWS_SECRET_ACCESS_KEY are always required.
      environmentProvider
          .setEnv(regionKey, "awsRegion")
          .setEnv("AWS_ACCESS_KEY_ID", "awsAccessKeyId")
          .setEnv("AWS_SECRET_ACCESS_KEY", "awsSecretAccessKey");
      InternalAwsSecurityCredentialsSupplier supplier =
          new InternalAwsSecurityCredentialsSupplier(
              buildAwsImdsv2CredentialSource(transportFactory),
              environmentProvider,
              transportFactory);
      assertFalse(supplier.shouldUseMetadataServer());
    }
  }

  @Test
  void shouldUseMetadataServer_missingRegion() {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    TestEnvironmentProvider environmentProvider = new TestEnvironmentProvider();
    environmentProvider
        .setEnv("AWS_ACCESS_KEY_ID", "awsAccessKeyId")
        .setEnv("AWS_SECRET_ACCESS_KEY", "awsSecretAccessKey");
    InternalAwsSecurityCredentialsSupplier supplier =
        new InternalAwsSecurityCredentialsSupplier(
            buildAwsImdsv2CredentialSource(transportFactory),
            environmentProvider,
            transportFactory);
    assertTrue(supplier.shouldUseMetadataServer());
  }

  @Test
  void shouldUseMetadataServer_missingAwsAccessKeyId() {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    // Add required environment variables.
    List<String> regionKeys = ImmutableList.of("AWS_REGION", "AWS_DEFAULT_REGION");
    for (String regionKey : regionKeys) {
      TestEnvironmentProvider environmentProvider = new TestEnvironmentProvider();
      // AWS_ACCESS_KEY_ID and AWS_SECRET_ACCESS_KEY are always required.
      environmentProvider
          .setEnv(regionKey, "awsRegion")
          .setEnv("AWS_SECRET_ACCESS_KEY", "awsSecretAccessKey");
      InternalAwsSecurityCredentialsSupplier supplier =
          new InternalAwsSecurityCredentialsSupplier(
              buildAwsImdsv2CredentialSource(transportFactory),
              environmentProvider,
              transportFactory);
      assertTrue(supplier.shouldUseMetadataServer());
    }
  }

  @Test
  void shouldUseMetadataServer_missingAwsSecretAccessKey() {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    // Add required environment variables.
    List<String> regionKeys = ImmutableList.of("AWS_REGION", "AWS_DEFAULT_REGION");
    for (String regionKey : regionKeys) {
      TestEnvironmentProvider environmentProvider = new TestEnvironmentProvider();
      // AWS_ACCESS_KEY_ID and AWS_SECRET_ACCESS_KEY are always required.
      environmentProvider
          .setEnv(regionKey, "awsRegion")
          .setEnv("AWS_ACCESS_KEY_ID", "awsAccessKeyId");
      InternalAwsSecurityCredentialsSupplier supplier =
          new InternalAwsSecurityCredentialsSupplier(
              buildAwsImdsv2CredentialSource(transportFactory),
              environmentProvider,
              transportFactory);
      assertTrue(supplier.shouldUseMetadataServer());
    }
  }

  @Test
  void shouldUseMetadataServer_missingAwsSecurityCreds() {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();

    // Add required environment variables.
    List<String> regionKeys = ImmutableList.of("AWS_REGION", "AWS_DEFAULT_REGION");
    for (String regionKey : regionKeys) {
      TestEnvironmentProvider environmentProvider = new TestEnvironmentProvider();
      // AWS_ACCESS_KEY_ID and AWS_SECRET_ACCESS_KEY are always required.
      // Not set here.
      environmentProvider.setEnv(regionKey, "awsRegion");
      InternalAwsSecurityCredentialsSupplier supplier =
          new InternalAwsSecurityCredentialsSupplier(
              buildAwsImdsv2CredentialSource(transportFactory),
              environmentProvider,
              transportFactory);
      assertTrue(supplier.shouldUseMetadataServer());
    }
  }

  @Test
  void shouldUseMetadataServer_noEnvironmentVars() {
    TestEnvironmentProvider environmentProvider = new TestEnvironmentProvider();
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();
    InternalAwsSecurityCredentialsSupplier supplier =
        new InternalAwsSecurityCredentialsSupplier(
            buildAwsImdsv2CredentialSource(transportFactory),
            environmentProvider,
            transportFactory);
    assertTrue(supplier.shouldUseMetadataServer());
  }

  /**
   * Verifies that {@link InternalAwsSecurityCredentialsSupplier} restores its {@code
   * transportFactory} upon deserialization, enabling successful retrieval of AWS security
   * credentials and region from the AWS EC2 metadata server.
   */
  @Test
  void serializeAndDeserialize_retrievesCredentialsAndRegionSuccessfully() throws Exception {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();
    InternalAwsSecurityCredentialsSupplier supplier =
        new InternalAwsSecurityCredentialsSupplier(
            buildAwsImdsv2CredentialSource(transportFactory),
            // Pass null to use the default SystemEnvironmentProvider, which implements Serializable
            // (unlike TestEnvironmentProvider).
            /* environmentProvider= */ null,
            transportFactory);

    InternalAwsSecurityCredentialsSupplier deserialized = serializeAndDeserialize(supplier);
    assertEquals(
        MockExternalAccountCredentialsTransportFactory.class,
        deserialized.getTransportFactory().getClass());

    // Credentials and region are not serialized fields; they are retrieved on demand via HTTP.
    // Calling getCredentials() and getRegion() verifies that the restored transportFactory
    // successfully constructs and executes HTTP requests against the mock metadata server
    // (rather than failing with a NullPointerException).
    AwsSecurityCredentials credentials = deserialized.getCredentials(null);
    assertNotNull(credentials);
    assertEquals("accessKeyId", credentials.getAccessKeyId());
    assertEquals("secretAccessKey", credentials.getSecretAccessKey());
    assertEquals("token", credentials.getSessionToken());

    String region = deserialized.getRegion(null);
    assertEquals("us-east-1", region);
  }

  /**
   * Verifies that {@link InternalAwsSecurityCredentialsSupplier} deserializes cleanly and falls
   * back to the default {@link OAuth2Utils#HTTP_TRANSPORT_FACTORY} when no custom transport factory
   * was provided.
   */
  @Test
  void serializeAndDeserialize_defaultTransportFactory_success() throws Exception {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();
    InternalAwsSecurityCredentialsSupplier supplier =
        new InternalAwsSecurityCredentialsSupplier(
            buildAwsImdsv2CredentialSource(transportFactory),
            /* environmentProvider= */ null,
            /* transportFactory= */ null);

    InternalAwsSecurityCredentialsSupplier deserialized = serializeAndDeserialize(supplier);
    assertNotNull(deserialized);
    assertSame(OAuth2Utils.HTTP_TRANSPORT_FACTORY, deserialized.getTransportFactory());
  }

  /**
   * Verifies that {@link InternalAwsSecurityCredentialsSupplier} can be serialized and deserialized
   * when an explicit {@link EnvironmentProvider} is provided.
   */
  @Test
  void serializeAndDeserialize_withEnvironmentVariables_success() throws Exception {
    MockExternalAccountCredentialsTransportFactory transportFactory =
        new MockExternalAccountCredentialsTransportFactory();
    SystemEnvironmentProvider environmentProvider = SystemEnvironmentProvider.getInstance();
    InternalAwsSecurityCredentialsSupplier supplier =
        new InternalAwsSecurityCredentialsSupplier(
            buildAwsImdsv2CredentialSource(transportFactory),
            environmentProvider,
            transportFactory);

    InternalAwsSecurityCredentialsSupplier deserialized = serializeAndDeserialize(supplier);
    assertNotNull(deserialized);
  }
}
