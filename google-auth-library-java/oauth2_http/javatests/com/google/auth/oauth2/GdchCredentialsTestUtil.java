package com.google.auth.oauth2;

import com.google.api.client.testing.http.FixedClock;
import java.io.IOException;
import java.net.URI;
import java.util.Map;

/**
 * This class marked public as it is used in showcase tests to test GDCH:
 * https://github.com/googleapis/google-cloud-java/blob/e50b96b70826f173e6d23278fea96c2af9b6e817/java-showcase/gapic-showcase/src/test/java/com/google/showcase/v1beta1/it/ITGdch.java#L217-L225
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
