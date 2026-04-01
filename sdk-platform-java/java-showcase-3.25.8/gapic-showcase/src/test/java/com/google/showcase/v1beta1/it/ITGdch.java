/*
 * Copyright 2023 Google LLC
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

package com.google.showcase.v1beta1.it;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GdchCredentials;
import com.google.auth.oauth2.GdchCredentialsTestUtil;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.showcase.v1beta1.it.util.InterceptingMockTokenServerTransportFactory;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import com.google.showcase.v1beta1.stub.EchoStubSettings;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Test suite to confirm a client can be instantiated with GDCH credentials. No calls are made since
 * it is not feasible to test against real GDCH servers (or replicate an environment)
 */
class ITGdch {

  private static final String CA_CERT_FILENAME = "fake_cert.pem";
  private static final String CA_CERT_RESOURCE_PATH = "/" + CA_CERT_FILENAME;
  private static final String CA_CERT_JSON_KEY = "ca_cert_path";
  private static final String GDCH_CREDENTIAL_FILENAME = "test_gdch_credential.json";
  private static final String GDCH_CREDENTIAL_RESOURCE_PATH = "/" + GDCH_CREDENTIAL_FILENAME;
  private static final String GDCH_TOKEN_STRING = "1/MkSJoj1xsli0AccessToken_NKPY2";
  private static final String SID_NAME = "service-identity-name";

  private EchoClient client;
  private EchoSettings settings;
  private EchoStubSettings stubSettings;
  private Credentials initialCredentials;
  private ClientContext context;
  private InterceptingMockTokenServerTransportFactory transportFactory;
  private String projectId;
  private URI tokenUri;

  @BeforeEach
  void setup(@TempDir Path tempDir) throws IOException {
    transportFactory = new InterceptingMockTokenServerTransportFactory();
    prepareCredentials(tempDir);
    settings =
        EchoSettings.newBuilder()
            .setCredentialsProvider(FixedCredentialsProvider.create(initialCredentials))
            .build();
  }

  @AfterEach
  void tearDown() throws InterruptedException {
    if (client != null) {
      client.close();
      client.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  private void prepareCredentials(Path tempDir) throws IOException {
    // Copy file so it can be referenced by Path even in native-image builds
    File caCertFile = new File(tempDir.toFile(), CA_CERT_FILENAME);
    try (InputStream inputStream = getClass().getResourceAsStream(CA_CERT_RESOURCE_PATH)) {
      assertThat(inputStream).isNotNull();
      Files.copy(inputStream, caCertFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    assertWithMessage(caCertFile.toPath() + " should exist").that(caCertFile.exists()).isTrue();

    // open gdch credential json (still needs its "ca_cert_path" to point to the CA certificate
    // obtained from above)
    JsonFactory factory = new GsonFactory();
    GenericJson converted =
        factory.fromInputStream(
            getClass().getResourceAsStream(GDCH_CREDENTIAL_RESOURCE_PATH), GenericJson.class);

    // modify and save to a temporary folder
    converted.set(CA_CERT_JSON_KEY, caCertFile.toPath().toAbsolutePath().toString());
    projectId = converted.get("project").toString();
    tokenUri = URI.create(converted.get("token_uri").toString());

    File tempGdchCredentialFile = new File(tempDir.toFile(), GDCH_CREDENTIAL_FILENAME);
    try (FileWriter fileWriter = new FileWriter(tempGdchCredentialFile)) {
      String preparedJson = converted.toPrettyString();
      fileWriter.write(preparedJson);
    }

    // use temp location to instantiate credentials
    initialCredentials = GdchCredentialsTestUtil.fromJson(converted, transportFactory);
  }

  /**
   * {@link com.google.api.gax.rpc.ClientContext} will create a new {@link GdchCredentials} with an
   * audience defaulted to the endpoint if the audience is not manually passed. This test confirms
   * that a new credential is created from the context and can be refreshed
   *
   * @throws IOException
   */
  @Test
  void testCreateClient_withGdchCredentialAndNoAudience_defaultsToEndpointBasedAudience()
      throws IOException {

    // we create the client as usual - no audience passed
    String testEndpoint = "custom-endpoint:123";
    settings = settings.toBuilder().setEndpoint(testEndpoint).build();
    context = ClientContext.create(settings);
    stubSettings = EchoStubSettings.newBuilder(context).build();
    client = EchoClient.create(stubSettings.createStub());

    // We retrieve from context and from client
    // the client has only access to creds provider, which may differ from the actual credentials
    // used in the Context
    Credentials fromContext = context.getCredentials();
    Credentials fromClient = initialCredentials;

    // Since ClientContext.create() uses a modified version of GdchCredentials
    // via GdchCredentials.createWithGdchAudience(), they should be different objects
    assertNotSame(fromContext, fromClient);

    // When credentials don't have an audience (such as the ones we passed to client creation and
    // now stored in the
    // provider) they will throw if we try to refresh them
    NullPointerException expectedEx =
        assertThrows(NullPointerException.class, () -> initialCredentials.refresh());
    assertTrue(
        expectedEx.getMessage().contains("Audience are not configured for GDCH service account"));

    // However, the credentials prepared in ClientContext should be able to refresh since the
    // audience would be
    // internally defaulted the endpoint of the StubSettings
    registerCredential(fromContext);
    ((GdchCredentials) fromContext).refreshAccessToken();
    String usedAudience = transportFactory.transport.getLastAudienceSent();
    assertEquals(testEndpoint, usedAudience);
  }

  /**
   * Confirms creating a client with a valid audience is successful. We cannot confirm which
   * audience is chosen (our passed audience or the endpoint) but this is confirmed in the unit
   * tests.
   *
   * @throws IOException
   */
  @Test
  void testCreateClient_withGdchCredentialWithValidAudience_usesCredentialWithPassedAudience()
      throws IOException {

    // Similar to the previous test, create a client as usual but this time we pass a explicit
    // audience. It should
    // be created without issues
    String testAudience = "valid-audience";
    settings =
        settings.toBuilder().setGdchApiAudience(testAudience).setEndpoint("localhost:7469").build();
    context = ClientContext.create(settings);
    stubSettings = EchoStubSettings.newBuilder(context).build();
    client = EchoClient.create(stubSettings.createStub());

    // We retrieve both creds from the creds provider and the ones prepared in the context (which
    // should have been
    // re-created using GdchCredentials.createWithAudience("valid-audience"))
    Credentials fromContext = context.getCredentials();
    assertNotSame(fromContext, initialCredentials);

    // Again, since the initial credentials don't have an audience, we should not be able to refresh
    // them
    NullPointerException thrownByClientCreds =
        assertThrows(NullPointerException.class, () -> initialCredentials.refresh());
    assertTrue(
        thrownByClientCreds
            .getMessage()
            .contains("Audience are not configured for GDCH service account"));

    // But the credentials prepared in ClientContext should be able to refresh since the audience
    // would be internally
    // set to the one passed in stub settings
    registerCredential(fromContext);
    ((GdchCredentials) fromContext).refreshAccessToken();
    String usedAudience = transportFactory.transport.getLastAudienceSent();
    assertEquals(testAudience, usedAudience);
  }

  private void registerCredential(Credentials fromContext) {
    GdchCredentialsTestUtil.registerGdchCredentialWithMockTransport(
        (GdchCredentials) fromContext,
        transportFactory.transport,
        projectId,
        SID_NAME,
        GDCH_TOKEN_STRING,
        tokenUri);
  }
}
