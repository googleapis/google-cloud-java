package com.google.auth.oauth2;

import com.google.api.client.testing.http.FixedClock;
import java.io.IOException;
import java.net.URI;
import java.util.Map;

/**
 * This class marked public as it is used in showcase tests in sdk-platform-java to test GDCH:
 * https://github.com/googleapis/sdk-platform-java/blob/3db61c211b757796a3e212c384487d0f2827322b/java-showcase/gapic-showcase/src/test/java/com/google/showcase/v1beta1/it/ITGdch.java#L215-L223
 */
public class GdchCredentialsTestUtil {
  public static void registerGdchCredentialWithMockTransport(
      GdchCredentials credentials,
      MockTokenServerTransport transport,
      String projectId,
      String serviceIdentityName,
      String tokenString,
      URI tokenServerUri) {
    credentials.clock = new FixedClock(0L);
    transport.addGdchServiceAccount(
        GdchCredentials.getIssuerSubjectValue(projectId, serviceIdentityName), tokenString);
    transport.setTokenServerUri(tokenServerUri);
  }

  public static GdchCredentials fromJson(
      Map<String, Object> json, MockTokenServerTransportFactory transportFactory)
      throws IOException {
    return GdchCredentials.fromJson(json, transportFactory);
  }
}
