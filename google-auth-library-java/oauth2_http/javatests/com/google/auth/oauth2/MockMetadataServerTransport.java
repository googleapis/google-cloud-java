/*
 * Copyright 2015, Google Inc. All rights reserved.
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
 *    * Neither the name of Google Inc. nor the names of its
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

import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.Json;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.BaseEncoding;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/** Transport that simulates the GCE metadata server for access tokens. */
public class MockMetadataServerTransport extends MockHttpTransport {

  private static final Pattern BOOL_PARAMETER_VALUE = Pattern.compile("on|1|(?i)y|yes|true");

  // key are scopes as in request url string following "?scopes="
  private Map<String, String> scopesToAccessToken;

  private Integer statusCode;

  private String serviceAccountEmail;

  private String idToken;

  private byte[] signature;

  private Map<String, String> s2aContentMap = new HashMap<>();

  private boolean emptyContent;
  private MockLowLevelHttpRequest request;

  public MockMetadataServerTransport() {}

  public MockMetadataServerTransport(String accessToken) {
    setAccessToken(accessToken);
  }

  public MockMetadataServerTransport(Map<String, String> accessTokenMap) {
    for (String scope : accessTokenMap.keySet()) {
      setAccessToken(scope, accessTokenMap.get(scope));
    }
  }

  public void setAccessToken(String accessToken) {
    setAccessToken("default", accessToken);
  }

  public void setAccessToken(String scopes, String accessToken) {
    if (scopesToAccessToken == null) {
      scopesToAccessToken = new HashMap<>();
    }
    scopesToAccessToken.put(scopes, accessToken);
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  public void setServiceAccountEmail(String serviceAccountEmail) {
    this.serviceAccountEmail = serviceAccountEmail;
  }

  public void setSignature(byte[] signature) {
    this.signature = signature;
  }

  public void setIdToken(String idToken) {
    this.idToken = idToken;
  }

  public void setS2AContentMap(ImmutableMap<String, String> map) {
    this.s2aContentMap = map;
  }

  public void setEmptyContent(boolean emptyContent) {
    this.emptyContent = emptyContent;
  }

  public MockLowLevelHttpRequest getRequest() {
    return request;
  }

  @Override
  public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
    if (url.startsWith(ComputeEngineCredentials.getTokenServerEncodedUrl())) {
      this.request = getMockRequestForTokenEndpoint(url);
      return this.request;
    } else if (isGetDefaultServiceAccountsUrl(url)) {
      this.request = getMockRequestForDefaultServiceAccount(url);
      return this.request;
    } else if (isSignRequestUrl(url)) {
      this.request = getMockRequestForSign(url);
      return this.request;
    } else if (isIdentityDocumentUrl(url)) {
      this.request = getMockRequestForIdentityDocument(url);
      return this.request;
    } else if (isMtlsConfigRequestUrl(url)) {
      return getMockRequestForMtlsConfig(url);
    }
    this.request =
        new MockLowLevelHttpRequest(url) {
          @Override
          public LowLevelHttpResponse execute() {
            if (statusCode != null && (statusCode >= 400 && statusCode < 600)) {
              return new MockLowLevelHttpResponse()
                  .setStatusCode(statusCode)
                  .setContent("Metadata Error");
            }

            MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
            response.addHeader("Metadata-Flavor", "Google");
            response.setStatusCode(HttpStatusCodes.STATUS_CODE_OK);
            return response;
          }
        };
    return this.request;
  }

  private MockLowLevelHttpRequest getMockRequestForSign(String url) {
    return new MockLowLevelHttpRequest(url) {
      @Override
      public LowLevelHttpResponse execute() throws IOException {
        // Create the JSON response
        GenericJson signContents = new GenericJson();
        signContents.setFactory(OAuth2Utils.JSON_FACTORY);
        signContents.put("signedBlob", BaseEncoding.base64().encode(signature));
        return new MockLowLevelHttpResponse()
            .setContentType(Json.MEDIA_TYPE)
            .setContent(signContents.toPrettyString());
      }
    };
  }

  private MockLowLevelHttpRequest getMockRequestForDefaultServiceAccount(String url) {
    return new MockLowLevelHttpRequest(url) {
      @Override
      public LowLevelHttpResponse execute() {
        return new MockLowLevelHttpResponse()
            .setContentType(Json.MEDIA_TYPE)
            .setContent(serviceAccountEmail);
      }
    };
  }

  private MockLowLevelHttpRequest getMockRequestForTokenEndpoint(String url) {
    return new MockLowLevelHttpRequest(url) {
      @Override
      public LowLevelHttpResponse execute() throws IOException {

        if (statusCode != null && (statusCode >= 400 && statusCode < 600)) {
          return new MockLowLevelHttpResponse()
              .setStatusCode(statusCode)
              .setContent("Token Fetch Error");
        }

        String metadataRequestHeader = getFirstHeaderValue("Metadata-Flavor");
        if (!"Google".equals(metadataRequestHeader)) {
          throw new IOException("Metadata request header not found.");
        }

        // Create the JSON response
        GenericJson refreshContents = new GenericJson();
        refreshContents.setFactory(OAuth2Utils.JSON_FACTORY);

        List<String> urlParsed = Splitter.on("?scopes=").splitToList(url);
        if (urlParsed.size() == 1) {
          // no scopes specified, return access token correspoinding to default scopes
          refreshContents.put("access_token", scopesToAccessToken.get("default"));
        } else {
          refreshContents.put(
              "access_token", scopesToAccessToken.get("[" + urlParsed.get(1) + "]"));
        }
        refreshContents.put("expires_in", 3600000);
        refreshContents.put("token_type", "Bearer");
        String refreshText = refreshContents.toPrettyString();

        return new MockLowLevelHttpResponse()
            .setContentType(Json.MEDIA_TYPE)
            .setStatusCode(HttpStatusCodes.STATUS_CODE_OK)
            .setContent(refreshText);
      }
    };
  }

  private MockLowLevelHttpRequest getMockRequestForIdentityDocument(String url)
      throws UnsupportedEncodingException {
    if (statusCode != null && statusCode != HttpStatusCodes.STATUS_CODE_OK) {
      return new MockLowLevelHttpRequest(url) {
        @Override
        public LowLevelHttpResponse execute() {
          return new MockLowLevelHttpResponse().setStatusCode(statusCode);
        }
      };
    } else if (idToken != null) {
      return new MockLowLevelHttpRequest(url) {
        @Override
        public LowLevelHttpResponse execute() {
          return new MockLowLevelHttpResponse().setContent(idToken);
        }
      };
    } else if (emptyContent) {
      return new MockLowLevelHttpRequest(url) {
        @Override
        public LowLevelHttpResponse execute() {
          return new MockLowLevelHttpResponse();
        }
      };
    }

    // https://cloud.google.com/compute/docs/instances/verifying-instance-identity#token_format
    Map<String, String> queryPairs = new HashMap<String, String>();
    String query = (URI.create(url)).getQuery();
    String[] pairs = query.split("&");
    for (String pair : pairs) {
      int idx = pair.indexOf("=");
      queryPairs.put(
          URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
          URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
    }

    if (queryPairs.containsKey("format") && queryPairs.get("format").equals("full")) {
      // return licenses only if format=full is set
      if (queryPairs.containsKey("licenses")
          && BOOL_PARAMETER_VALUE.matcher(queryPairs.get("licenses")).matches()) {
        return new MockLowLevelHttpRequest(url) {
          @Override
          public LowLevelHttpResponse execute() throws IOException {
            return new MockLowLevelHttpResponse()
                .setContent(ComputeEngineCredentialsTest.FULL_ID_TOKEN_WITH_LICENSES);
          }
        };
      }

      // otherwise return full format
      return new MockLowLevelHttpRequest(url) {
        @Override
        public LowLevelHttpResponse execute() throws IOException {
          return new MockLowLevelHttpResponse()
              .setContent(ComputeEngineCredentialsTest.FULL_ID_TOKEN);
        }
      };
    }

    // Return default format if nothing is set
    return new MockLowLevelHttpRequest(url) {
      @Override
      public LowLevelHttpResponse execute() throws IOException {
        return new MockLowLevelHttpResponse()
            .setContent(ComputeEngineCredentialsTest.STANDARD_ID_TOKEN);
      }
    };
  }

  private MockLowLevelHttpRequest getMockRequestForMtlsConfig(String url) {
    return new MockLowLevelHttpRequest(url) {
      @Override
      public LowLevelHttpResponse execute() throws IOException {

        String metadataRequestHeader = getFirstHeaderValue(SecureSessionAgent.METADATA_FLAVOR);
        if (!SecureSessionAgent.GOOGLE.equals(metadataRequestHeader)) {
          throw new IOException("Metadata request header not found");
        }

        // Create the JSON response
        GenericJson content = new GenericJson();
        content.setFactory(OAuth2Utils.JSON_FACTORY);
        if (statusCode == HttpStatusCodes.STATUS_CODE_OK) {
          content.put(SecureSessionAgent.S2A_JSON_KEY, s2aContentMap);
        }
        String contentText = content.toPrettyString();

        MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();

        if (statusCode != null) {
          response.setStatusCode(statusCode);
        }
        if (emptyContent == true) {
          return response.setZeroContent();
        }
        response.setContentType(Json.MEDIA_TYPE).setContent(contentText);
        return response;
      }
    };
  }

  protected boolean isGetDefaultServiceAccountsUrl(String url) {
    return url.equals(ComputeEngineCredentials.getDefaultServiceAccountUrl());
  }

  protected boolean isSignRequestUrl(String url) {
    return serviceAccountEmail != null
        && url.equals(
            String.format(
                IamUtils.IAM_SIGN_BLOB_ENDPOINT_FORMAT, "googleapis.com", serviceAccountEmail));
  }

  protected boolean isIdentityDocumentUrl(String url) {
    return url.startsWith(String.format(ComputeEngineCredentials.getIdentityDocumentUrl()));
  }

  protected boolean isMtlsConfigRequestUrl(String url) {
    return url.equals(
        ComputeEngineCredentials.getMetadataServerUrl()
            + SecureSessionAgent.S2A_CONFIG_ENDPOINT_POSTFIX);
  }
}
