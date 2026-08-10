package com.google.auth.oauth2;

import com.google.api.client.testing.http.FixedClock;
import java.io.IOException;
import java.net.URI;
import java.util.Map;

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
