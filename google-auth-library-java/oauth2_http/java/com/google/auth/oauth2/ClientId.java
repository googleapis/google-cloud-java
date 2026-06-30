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

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * An OAuth2 user authorization Client ID and associated information.
 *
 * <p>Corresponds to the information in the json file downloadable for a Client ID.
 */
public class ClientId {

  private static final String FIELD_TYPE_INSTALLED = "installed";
  private static final String FIELD_TYPE_WEB = "web";
  private static final String FIELD_CLIENT_ID = "client_id";
  private static final String FIELD_CLIENT_SECRET = "client_secret";
  private static final String JSON_PARSE_ERROR = "Error parsing Client ID JSON: ";

  private final String clientId;
  private final String clientSecret;

  /**
   * Constructs a client ID from an explicit ID and secret.
   *
   * <p>Note: Direct use of this factory method in application code is not recommended to avoid
   * having secrets or values that need to be updated in source code.
   *
   * @param clientId Text identifier of the Client ID.
   * @param clientSecret Secret to associated with the Client ID.
   * @return The ClientId instance.
   */
  public static ClientId of(String clientId, String clientSecret) {
    return new ClientId(clientId, clientSecret);
  }

  /**
   * Constructs a Client ID from JSON from a downloaded file.
   *
   * @param json the JSON from the downloaded file
   * @return the ClientId instance based on the JSON
   * @throws IOException the JSON could not be parsed
   */
  public static ClientId fromJson(Map<String, Object> json) throws IOException {
    Object rawDetail = null;
    rawDetail = json.get(FIELD_TYPE_INSTALLED);
    if (rawDetail == null) {
      rawDetail = json.get(FIELD_TYPE_WEB);
    }
    if (rawDetail == null || !(rawDetail instanceof Map<?, ?>)) {
      throw new IOException(
          "Unable to parse Client ID JSON. Expecting top-level field '"
              + FIELD_TYPE_WEB
              + "' or '"
              + FIELD_TYPE_INSTALLED
              + "' of collection type");
    }
    @SuppressWarnings("unchecked")
    Map<String, Object> detail = (Map<String, Object>) rawDetail;
    String clientId = OAuth2Utils.validateString(detail, FIELD_CLIENT_ID, JSON_PARSE_ERROR);
    if (clientId == null || clientId.length() == 0) {
      throw new IOException(
          "Unable to parse ClientId. Field '" + FIELD_CLIENT_ID + "' is required.");
    }
    String clientSecret =
        OAuth2Utils.validateOptionalString(detail, FIELD_CLIENT_SECRET, JSON_PARSE_ERROR);
    return new ClientId(clientId, clientSecret);
  }

  /**
   * Constructs a Client ID from JSON file stored as a resource.
   *
   * @param relativeClass a class in the same namespace as the resource
   * @param resourceName the name of the resource
   * @return the constructed ClientID instance based on the JSON in the resource
   * @throws IOException The JSON could not be loaded or parsed.
   */
  public static ClientId fromResource(Class<?> relativeClass, String resourceName)
      throws IOException {
    InputStream stream = relativeClass.getResourceAsStream(resourceName);
    return fromStream(stream);
  }

  /**
   * Constructs a Client ID from JSON file stream.
   *
   * @param stream the downloaded JSON file
   * @return the constructed ClientID instance based on the JSON in the stream
   * @throws IOException the JSON could not be read or parsed
   */
  public static ClientId fromStream(InputStream stream) throws IOException {
    Preconditions.checkNotNull(stream);
    JsonObjectParser parser = new JsonObjectParser(OAuth2Utils.JSON_FACTORY);
    GenericJson parsedJson =
        parser.parseAndClose(stream, StandardCharsets.UTF_8, GenericJson.class);
    return fromJson(parsedJson);
  }

  /**
   * Constructs a client ID using an explicit ID and secret
   *
   * <p>Note: Direct use of this constructor in application code is not recommended to avoid having
   * secrets or values that need to be updated in source code.
   *
   * @param clientId Text identifier of the Client ID.
   * @param clientSecret Secret to associated with the Client ID.
   */
  private ClientId(String clientId, String clientSecret) {
    this.clientId = Preconditions.checkNotNull(clientId);
    this.clientSecret = clientSecret;
  }

  /**
   * Returns the text identifier of the Client ID.
   *
   * @return The text identifier of the Client ID.
   */
  public final String getClientId() {
    return clientId;
  }

  /**
   * Returns the secret associated with the Client ID.
   *
   * @return The secret associated with the Client ID.
   */
  public final String getClientSecret() {
    return clientSecret;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static class Builder {

    private String clientId;

    private String clientSecret;

    protected Builder() {}

    protected Builder(ClientId clientId) {
      this.clientId = clientId.getClientId();
      this.clientSecret = clientId.getClientSecret();
    }

    @CanIgnoreReturnValue
    public Builder setClientId(String clientId) {
      this.clientId = clientId;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setClientSecret(String clientSecret) {
      this.clientSecret = clientSecret;
      return this;
    }

    public String getClientSecret() {
      return clientSecret;
    }

    public ClientId build() {
      return new ClientId(clientId, clientSecret);
    }
  }
}
