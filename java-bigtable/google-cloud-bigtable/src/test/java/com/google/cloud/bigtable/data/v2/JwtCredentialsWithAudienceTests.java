/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2;

import static com.google.common.truth.Truth.assertThat;

import com.google.auth.oauth2.OAuth2Utils;
import com.google.auth.oauth2.ServiceAccountJwtAccessCredentials;
import com.google.cloud.bigtable.data.v2.internal.JwtCredentialsWithAudience;
import java.io.IOException;
import java.net.URI;
import java.security.PrivateKey;
import org.junit.Test;

public class JwtCredentialsWithAudienceTests {

  private static final String SA_CLIENT_EMAIL =
      "36680232662-vrd7ji19qe3nelgchd0ah2csanun6bnr@developer.gserviceaccount.com";
  private static final String SA_CLIENT_ID =
      "36680232662-vrd7ji19qe3nelgchd0ah2csanun6bnr.apps.googleusercontent.com";
  private static final String SA_PRIVATE_KEY_ID = "d84a4fefcf50791d4a90f2d7af17469d6282df9d";
  private static final String SA_PRIVATE_KEY_PKCS8 =
      "-----BEGIN PRIVATE KEY-----\n"
          + "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALX0PQoe1igW12ikv1bN/r9lN749y2ijmbc/mFHPyS3hNTyOCjDvBbXYbDhQJzWVUikh4mvGBA07qTj79Xc3yBDfKP2IeyYQIFe0t0zkd7R9Zdn98Y2rIQC47aAbDfubtkU1U72t4zL11kHvoa0/RuFZjncvlr42X7be7lYh4p3NAgMBAAECgYASk5wDw4Az2ZkmeuN6Fk/y9H+Lcb2pskJIXjrL533vrDWGOC48LrsThMQPv8cxBky8HFSEklPpkfTF95tpD43iVwJRB/GrCtGTw65IfJ4/tI09h6zGc4yqvIo1cHX/LQ+SxKLGyir/dQM925rGt/VojxY5ryJR7GLbCzxPnJm/oQJBANwOCO6D2hy1LQYJhXh7O+RLtA/tSnT1xyMQsGT+uUCMiKS2bSKx2wxo9k7h3OegNJIu1q6nZ6AbxDK8H3+d0dUCQQDTrPSXagBxzp8PecbaCHjzNRSQE2in81qYnrAFNB4o3DpHyMMY6s5ALLeHKscEWnqP8Ur6X4PvzZecCWU9BKAZAkAutLPknAuxSCsUOvUfS1i87ex77Ot+w6POp34pEX+UWb+u5iFn2cQacDTHLV1LtE80L8jVLSbrbrlH43H0DjU5AkEAgidhycxS86dxpEljnOMCw8CKoUBd5I880IUahEiUltk7OLJYS/Ts1wbn3kPOVX3wyJs8WBDtBkFrDHW2ezth2QJADj3e1YhMVdjJW5jqwlD/VNddGjgzyunmiZg0uOXsHXbytYmsA545S8KRQFaJKFXYYFo2kOjqOiC1T2cAzMDjCQ==\n"
          + "-----END PRIVATE KEY-----\n";
  private static final String QUOTA_PROJECT = "sample-quota-project-id";

  @Test
  public void getUniverseDomain_default() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials serviceAccountJwtAccessCredentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setQuotaProjectId(QUOTA_PROJECT)
            .build();
    JwtCredentialsWithAudience jwtWithAudience =
        new JwtCredentialsWithAudience(
            serviceAccountJwtAccessCredentials, URI.create("default-aud"));
    assertThat(jwtWithAudience.getUniverseDomain()).isEqualTo("googleapis.com");
  }

  @Test
  public void getUniverseDomain_custom() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials serviceAccountJwtAccessCredentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setQuotaProjectId(QUOTA_PROJECT)
            .setUniverseDomain("example.com")
            .build();
    JwtCredentialsWithAudience jwtWithAudience =
        new JwtCredentialsWithAudience(
            serviceAccountJwtAccessCredentials, URI.create("default-aud"));
    assertThat(jwtWithAudience.getUniverseDomain()).isEqualTo("example.com");
  }
}
