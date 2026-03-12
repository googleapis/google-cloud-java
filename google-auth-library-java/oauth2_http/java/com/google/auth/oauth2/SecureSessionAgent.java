/*
 * Copyright 2024, Google Inc. All rights reserved.
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

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpBackOffIOExceptionHandler;
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.client.util.GenericData;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.collect.Iterables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import javax.annotation.concurrent.ThreadSafe;

/**
 * Utilities to fetch the S2A (Secure Session Agent) address from the mTLS configuration.
 *
 * <p>mTLS configuration is queried from the MDS MTLS Autoconfiguration endpoint. See
 * https://google.aip.dev/auth/4115 for details.
 *
 * <p>This is an experimental utility.
 */
@ThreadSafe
public class SecureSessionAgent {
  static final String S2A_JSON_KEY = "s2a";
  static final String S2A_PLAINTEXT_ADDRESS_JSON_KEY = "plaintext_address";
  static final String S2A_MTLS_ADDRESS_JSON_KEY = "mtls_address";
  static final String S2A_CONFIG_ENDPOINT_POSTFIX =
      "/computeMetadata/v1/instance/platform-security/auto-mtls-configuration";

  static final String METADATA_FLAVOR = "Metadata-Flavor";
  static final String GOOGLE = "Google";
  private static final Set<Integer> RETRYABLE_STATUS_CODES =
      new HashSet<>(Arrays.asList(500, 502, 503));
  private static final String PARSE_ERROR_S2A = "Error parsing S2A Config from MDS JSON response.";
  private static final String MDS_MTLS_ENDPOINT =
      ComputeEngineCredentials.getMetadataServerUrl() + S2A_CONFIG_ENDPOINT_POSTFIX;

  private transient HttpTransportFactory transportFactory;

  SecureSessionAgent(SecureSessionAgent.Builder builder) {
    this.transportFactory = builder.getHttpTransportFactory();
  }

  /**
   * This method makes a network call to MDS to get the {@link SecureSessionAgentConfig} which
   * contains the plaintext and mtls address to reach the S2A (Secure Session Agent).
   *
   * @return a SecureSessionAgentConfig.
   */
  public SecureSessionAgentConfig getConfig() {
    return getSecureSessionAgentConfigFromMDS();
  }

  /**
   * @return default instance of SecureSessionAgent
   */
  public static SecureSessionAgent create() {
    return newBuilder().build();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private HttpTransportFactory transportFactory;

    protected Builder() {}

    @CanIgnoreReturnValue
    public Builder setHttpTransportFactory(HttpTransportFactory transportFactory) {
      this.transportFactory = transportFactory;
      return this;
    }

    public HttpTransportFactory getHttpTransportFactory() {
      return this.transportFactory;
    }

    public SecureSessionAgent build() {
      return new SecureSessionAgent(this);
    }
  }

  /**
   * Queries the MDS mTLS Autoconfiguration endpoint and returns the {@link
   * SecureSessionAgentConfig}.
   *
   * <p>Returns {@link SecureSessionAgentConfig}. If S2A is not running, or if any error occurs when
   * making the request to MDS / processing the response, {@link SecureSessionAgentConfig} will be
   * populated with empty addresses.
   *
   * <p>Users are expected to try to fetch the mTLS-S2A address first (via {@link
   * getMtlsS2AAddress}). If it is empty or they have some problem loading the mTLS-MDS credentials,
   * they should then fallback to fetching the plaintext-S2A address (via {@link
   * getPlaintextS2AAddress}). If the plaintext-S2A address is empty it means that an error occurred
   * when talking to the MDS / processing the response or that S2A is not running in the
   * environment; in either case this indicates S2A shouldn't be used.
   *
   * @return the {@link SecureSessionAgentConfig}.
   */
  private SecureSessionAgentConfig getSecureSessionAgentConfigFromMDS() {
    if (transportFactory == null) {
      transportFactory =
          Iterables.getFirst(
              ServiceLoader.load(HttpTransportFactory.class), OAuth2Utils.HTTP_TRANSPORT_FACTORY);
    }

    HttpRequest request = null;
    GenericUrl genericUrl = new GenericUrl(MDS_MTLS_ENDPOINT);
    try {
      request = transportFactory.create().createRequestFactory().buildGetRequest(genericUrl);
    } catch (IOException ignore) {
      /*
       * Return empty addresses in {@link SecureSessionAgentConfig} if error building the GET request.
       */
      return SecureSessionAgentConfig.createBuilder().build();
    }

    request.setParser(new JsonObjectParser(OAuth2Utils.JSON_FACTORY));
    request.getHeaders().set(METADATA_FLAVOR, GOOGLE);
    request.setThrowExceptionOnExecuteError(false);
    request.setNumberOfRetries(OAuth2Utils.DEFAULT_NUMBER_OF_RETRIES);

    ExponentialBackOff backoff =
        new ExponentialBackOff.Builder()
            .setInitialIntervalMillis(OAuth2Utils.INITIAL_RETRY_INTERVAL_MILLIS)
            .setRandomizationFactor(OAuth2Utils.RETRY_RANDOMIZATION_FACTOR)
            .setMultiplier(OAuth2Utils.RETRY_MULTIPLIER)
            .build();

    // Retry on 5xx status codes.
    request.setUnsuccessfulResponseHandler(
        new HttpBackOffUnsuccessfulResponseHandler(backoff)
            .setBackOffRequired(
                response -> RETRYABLE_STATUS_CODES.contains(response.getStatusCode())));
    request.setIOExceptionHandler(new HttpBackOffIOExceptionHandler(backoff));

    GenericData responseData = null;
    try {
      HttpResponse response = request.execute();
      InputStream content = response.getContent();
      if (content == null) {
        return SecureSessionAgentConfig.createBuilder().build();
      }
      responseData = response.parseAs(GenericData.class);
    } catch (IOException ignore) {
      /*
       * Return empty addresses in {@link SecureSessionAgentConfig} once all retries have been exhausted.
       */
      return SecureSessionAgentConfig.createBuilder().build();
    }

    String plaintextS2AAddress = "";
    String mtlsS2AAddress = "";
    Map<String, Object> s2aAddressConfig = (Map<String, Object>) responseData.get(S2A_JSON_KEY);
    if (s2aAddressConfig == null) {
      /*
       * Return empty addresses in {@link SecureSessionAgentConfig} if endpoint doesn't return anything.
       */
      return SecureSessionAgentConfig.createBuilder().build();
    }
    try {
      plaintextS2AAddress =
          OAuth2Utils.validateString(
              s2aAddressConfig, S2A_PLAINTEXT_ADDRESS_JSON_KEY, PARSE_ERROR_S2A);
    } catch (IOException ignore) {
      /*
       * Do not throw error because of parsing error, just leave the address as empty in {@link SecureSessionAgentConfig}.
       */
    }
    try {
      mtlsS2AAddress =
          OAuth2Utils.validateString(s2aAddressConfig, S2A_MTLS_ADDRESS_JSON_KEY, PARSE_ERROR_S2A);
    } catch (IOException ignore) {
      /*
       * Do not throw error because of parsing error, just leave the address as empty in {@link SecureSessionAgentConfig}.
       */
    }

    return SecureSessionAgentConfig.createBuilder()
        .setPlaintextAddress(plaintextS2AAddress)
        .setMtlsAddress(mtlsS2AAddress)
        .build();
  }
}
