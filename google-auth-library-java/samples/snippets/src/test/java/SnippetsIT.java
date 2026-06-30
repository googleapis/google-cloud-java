/*
 * Copyright 2022 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.auth.oauth2.IdToken;
import com.google.auth.oauth2.IdTokenProvider.Option;
import com.google.auth.oauth2.ServiceAccountCredentials;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SnippetsIT {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String CREDENTIALS = System.getenv("GOOGLE_APPLICATION_CREDENTIALS");
  private ByteArrayOutputStream stdOut;

  // Check if the required environment variables are set.
  public static void requireEnvVar(String envVarName) {
    assertWithMessage(String.format("Missing environment variable '%s' ", envVarName))
        .that(System.getenv(envVarName))
        .isNotEmpty();
  }

  @BeforeClass
  public static void setup() throws IOException {
    final PrintStream out = System.out;
    ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");

    stdOut.close();
    System.setOut(out);
  }

  @AfterClass
  public static void cleanup() {}

  @Before
  public void beforeEach() {
    stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));
  }

  @After
  public void afterEach() {
    stdOut = null;
    System.setOut(null);
  }

  // Get an id token from a Google service account.
  private static String getIdTokenFromServiceAccount(
      String jsonCredentialPath, String targetAudience) throws IOException {

    // Initialize the Service Account Credentials class with the path to the json file.
    ServiceAccountCredentials serviceAccountCredentials =
        ServiceAccountCredentials.fromStream(new FileInputStream(jsonCredentialPath));

    // Obtain the id token by providing the target audience.
    // tokenOption: Enum of various credential-specific options to apply to the token. Applicable
    // only for credentials obtained through Compute Engine or Impersonation.
    List<Option> tokenOption = Arrays.asList();
    IdToken idToken = serviceAccountCredentials.idTokenWithAudience(targetAudience, tokenOption);

    return idToken.getTokenValue();
  }

  @Test
  public void testIdTokenFromServiceAccount() throws IOException {
    IdTokenFromServiceAccount.getIdTokenFromServiceAccount(CREDENTIALS, "https://example.com");
    assertThat(stdOut.toString()).contains("Generated ID token.");
  }

  @Test
  public void testVerifyGoogleIdToken() throws IOException {
    String idToken = getIdTokenFromServiceAccount(CREDENTIALS, "https://example.com");

    VerifyGoogleIdToken.verifyGoogleIdToken(
        idToken, "https://example.com", "https://www.googleapis.com/oauth2/v3/certs");
  }

  @Test
  public void testIdTokenFromMetadataServer() throws GeneralSecurityException, IOException {
    IdTokenFromMetadataServer.getIdTokenFromMetadataServer("https://www.google.com");
    assertThat(stdOut.toString()).contains("Generated ID token.");
  }

  @Test
  public void testAuthenticateImplicitWithAdc() throws IOException {
    AuthenticateImplicitWithAdc.authenticateImplicitWithAdc(PROJECT_ID);
    assertThat(stdOut.toString()).contains("Listed all storage buckets.");
  }

  @Test
  public void testAuthenticateExplicit() throws IOException {
    AuthenticateExplicit.authenticateExplicit(PROJECT_ID);
    assertThat(stdOut.toString()).contains("Listed all storage buckets.");
  }
}
