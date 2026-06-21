/*
 * Copyright 2026, Google LLC
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

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpBackOffIOExceptionHandler;
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpIOExceptionHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Clock;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.client.util.Key;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Represents the regional access boundary configuration for a credential. This class holds the
 * information retrieved from the IAM `allowedLocations` endpoint. This data is then used to
 * populate the `x-allowed-locations` header in outgoing API requests, which in turn allows Google's
 * infrastructure to enforce regional security restrictions. This class does not perform any
 * client-side validation or enforcement.
 */
final class RegionalAccessBoundary implements Serializable {

  static final String X_ALLOWED_LOCATIONS_HEADER_KEY = "x-allowed-locations";
  private static final long serialVersionUID = -2428522338274020302L;

  static final long TTL_MILLIS = 6 * 60 * 60 * 1000L; // 6 hours
  static final long REFRESH_THRESHOLD_MILLIS = 1 * 60 * 60 * 1000L; // 1 hour

  private final String encodedLocations;
  private final List<String> locations;
  private final long refreshTime;
  private transient Clock clock;

  /**
   * Creates a new RegionalAccessBoundary instance.
   *
   * @param encodedLocations The encoded string representation of the allowed locations.
   * @param locations A list of human-readable location strings.
   * @param clock The clock used to set the creation time.
   */
  RegionalAccessBoundary(String encodedLocations, List<String> locations, Clock clock) {
    this(
        encodedLocations,
        locations,
        clock != null ? clock.currentTimeMillis() : Clock.SYSTEM.currentTimeMillis(),
        clock);
  }

  /**
   * Internal constructor for testing and manual creation with refresh time.
   *
   * @param encodedLocations The encoded string representation of the allowed locations.
   * @param locations A list of human-readable location strings.
   * @param refreshTime The time at which the information was last refreshed.
   * @param clock The clock to use for expiration checks.
   */
  RegionalAccessBoundary(
      String encodedLocations, List<String> locations, long refreshTime, Clock clock) {
    this.encodedLocations = encodedLocations;
    this.locations =
        locations == null
            ? Collections.<String>emptyList()
            : Collections.unmodifiableList(new java.util.ArrayList<>(locations));
    this.refreshTime = refreshTime;
    this.clock = clock != null ? clock : Clock.SYSTEM;
  }

  /** Returns the encoded string representation of the allowed locations. */
  public String getEncodedLocations() {
    return encodedLocations;
  }

  /** Returns a list of human-readable location strings. */
  public List<String> getLocations() {
    return locations;
  }

  /**
   * Checks if the regional access boundary data is expired.
   *
   * @return True if the data has expired based on the TTL, false otherwise.
   */
  public boolean isExpired() {
    return clock.currentTimeMillis() > refreshTime + TTL_MILLIS;
  }

  /**
   * Checks if the regional access boundary data should be refreshed. This is a "soft-expiry" check
   * that allows for background refreshes before the data actually expires.
   *
   * @return True if the data is within the refresh threshold, false otherwise.
   */
  public boolean shouldRefresh() {
    return clock.currentTimeMillis() > refreshTime + (TTL_MILLIS - REFRESH_THRESHOLD_MILLIS);
  }

  /** Represents the JSON response from the regional access boundary endpoint. */
  public static class RegionalAccessBoundaryResponse extends GenericJson {
    @Key("encodedLocations")
    private String encodedLocations;

    @Key("locations")
    private List<String> locations;

    /** Returns the encoded string representation of the allowed locations from the API response. */
    public String getEncodedLocations() {
      return encodedLocations;
    }

    /** Returns a list of human-readable location strings from the API response. */
    public List<String> getLocations() {
      return locations;
    }

    @Override
    /** Returns a string representation of the RegionalAccessBoundaryResponse. */
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("encodedLocations", encodedLocations)
          .add("locations", locations)
          .toString();
    }
  }

  /**
   * Refreshes the regional access boundary by making a network call to the lookup endpoint.
   *
   * @param transportFactory The HTTP transport factory to use for the network request.
   * @param url The URL of the regional access boundary endpoint.
   * @param accessToken The access token to authenticate the request.
   * @param clock The clock to use for expiration checks.
   * @param maxRetryElapsedTimeMillis The max duration to wait for retries.
   * @return A new RegionalAccessBoundary object containing the refreshed information.
   * @throws IllegalArgumentException If the provided access token is null or expired.
   * @throws IOException If a network error occurs or the response is malformed.
   */
  static RegionalAccessBoundary refresh(
      HttpTransportFactory transportFactory,
      String url,
      AccessToken accessToken,
      Clock clock,
      int maxRetryElapsedTimeMillis)
      throws IOException {
    Preconditions.checkNotNull(accessToken, "The provided access token is null.");
    if (accessToken.getExpirationTimeMillis() != null
        && accessToken.getExpirationTimeMillis() < clock.currentTimeMillis()) {
      throw new IllegalArgumentException("The provided access token is expired.");
    }

    HttpRequestFactory requestFactory = transportFactory.create().createRequestFactory();
    HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(url));
    // Disable automatic logging by google-http-java-client to prevent leakage of sensitive tokens.
    request.setLoggingEnabled(false);
    request.getHeaders().setAuthorization("Bearer " + accessToken.getTokenValue());

    // Add retry logic
    ExponentialBackOff backoff =
        new ExponentialBackOff.Builder()
            .setInitialIntervalMillis(OAuth2Utils.INITIAL_RETRY_INTERVAL_MILLIS)
            .setRandomizationFactor(OAuth2Utils.RETRY_RANDOMIZATION_FACTOR)
            .setMultiplier(OAuth2Utils.RETRY_MULTIPLIER)
            .setMaxElapsedTimeMillis(maxRetryElapsedTimeMillis)
            .build();

    HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler =
        new HttpBackOffUnsuccessfulResponseHandler(backoff)
            .setBackOffRequired(
                response -> {
                  int statusCode = response.getStatusCode();
                  return statusCode == 500
                      || statusCode == 502
                      || statusCode == 503
                      || statusCode == 504;
                });
    request.setUnsuccessfulResponseHandler(unsuccessfulResponseHandler);

    HttpIOExceptionHandler ioExceptionHandler = new HttpBackOffIOExceptionHandler(backoff);
    request.setIOExceptionHandler(ioExceptionHandler);

    request.setParser(new JsonObjectParser(OAuth2Utils.JSON_FACTORY));

    RegionalAccessBoundaryResponse json;
    HttpResponse response = null;
    try {
      response = request.execute();
      json = response.parseAs(RegionalAccessBoundaryResponse.class);
    } catch (IOException e) {
      throw new IOException(
          "RegionalAccessBoundary: Failure while getting regional access boundaries:", e);
    } finally {
      if (response != null) {
        response.disconnect();
      }
    }
    String encodedLocations = json.getEncodedLocations();
    // The encodedLocations is the value attached to the x-allowed-locations header, and
    // it should always have a value.
    if (encodedLocations == null) {
      throw new IOException(
          "RegionalAccessBoundary: Malformed response from lookup endpoint - `encodedLocations` was null.");
    }
    return new RegionalAccessBoundary(encodedLocations, json.getLocations(), clock);
  }

  /**
   * Initializes the transient clock to Clock.SYSTEM upon deserialization to prevent
   * NullPointerException when evaluating expiration on deserialized objects.
   */
  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    clock = Clock.SYSTEM;
  }
}
