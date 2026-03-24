/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@InternalApi
public class XGoogSpannerRequestId {
  // 1. Generate the random process ID singleton.
  @VisibleForTesting
  static final String RAND_PROCESS_ID = XGoogSpannerRequestId.generateRandProcessId();

  public static String REQUEST_ID_HEADER_NAME = "x-goog-spanner-request-id";
  public static final Metadata.Key<String> REQUEST_ID_HEADER_KEY =
      Metadata.Key.of(REQUEST_ID_HEADER_NAME, Metadata.ASCII_STRING_MARSHALLER);
  public static final CallOptions.Key<XGoogSpannerRequestId> REQUEST_ID_CALL_OPTIONS_KEY =
      CallOptions.Key.create("XGoogSpannerRequestId");

  @VisibleForTesting
  static final long VERSION = 1; // The version of the specification being implemented.

  private final long nthClientId;
  private final long nthRequest;
  private long nthChannelId;
  private long attempt;

  XGoogSpannerRequestId(long nthClientId, long nthChannelId, long nthRequest, long attempt) {
    this.nthClientId = nthClientId;
    this.nthChannelId = nthChannelId;
    this.nthRequest = nthRequest;
    this.attempt = attempt;
  }

  public static XGoogSpannerRequestId of(
      long nthClientId, long nthChannelId, long nthRequest, long attempt) {
    return new XGoogSpannerRequestId(nthClientId, nthChannelId, nthRequest, attempt);
  }

  @VisibleForTesting
  long getNthClientId() {
    return nthClientId;
  }

  @VisibleForTesting
  long getNthChannelId() {
    return nthChannelId;
  }

  boolean hasChannelId() {
    return nthChannelId > 0;
  }

  @VisibleForTesting
  long getAttempt() {
    return this.attempt;
  }

  @VisibleForTesting
  long getNthRequest() {
    return this.nthRequest;
  }

  @VisibleForTesting
  static final Pattern REGEX =
      Pattern.compile("^(\\d)\\.([0-9a-z]{16})\\.(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$");

  public static XGoogSpannerRequestId of(String s) {
    Matcher m = XGoogSpannerRequestId.REGEX.matcher(s);
    if (!m.matches()) {
      throw new IllegalStateException(
          s + " does not match " + XGoogSpannerRequestId.REGEX.pattern());
    }

    MatchResult mr = m.toMatchResult();

    return new XGoogSpannerRequestId(
        Long.parseLong(mr.group(3)),
        Long.parseLong(mr.group(4)),
        Long.parseLong(mr.group(5)),
        Long.parseLong(mr.group(6)));
  }

  private static String generateRandProcessId() {
    // Expecting to use 64-bits of randomness to avoid clashes.
    BigInteger bigInt = new BigInteger(64, new SecureRandom());
    return String.format("%016x", bigInt);
  }

  /** Returns the string representation of this RequestId as it should be sent to Spanner. */
  public String getHeaderValue() {
    return String.format(
        "%d.%s.%d.%d.%d.%d",
        XGoogSpannerRequestId.VERSION,
        XGoogSpannerRequestId.RAND_PROCESS_ID,
        this.nthClientId,
        this.nthChannelId,
        this.nthRequest,
        this.attempt);
  }

  @Override
  public String toString() {
    return String.format(
        "%d.%s.%d.%s.%d.%d",
        XGoogSpannerRequestId.VERSION,
        XGoogSpannerRequestId.RAND_PROCESS_ID,
        this.nthClientId,
        this.nthChannelId < 0 ? "x" : String.valueOf(this.nthChannelId),
        this.nthRequest,
        this.attempt);
  }

  public String debugToString() {
    return String.format(
        "%d.%s.nth_client=%d.nth_chan=%d.nth_req=%d.attempt=%d",
        XGoogSpannerRequestId.VERSION,
        XGoogSpannerRequestId.RAND_PROCESS_ID,
        this.nthClientId,
        this.nthChannelId,
        this.nthRequest,
        this.attempt);
  }

  @VisibleForTesting
  boolean isGreaterThan(XGoogSpannerRequestId other) {
    if (this.nthClientId != other.nthClientId) {
      return this.nthClientId > other.nthClientId;
    }
    if (this.nthChannelId != other.nthChannelId) {
      return this.nthChannelId > other.nthChannelId;
    }
    if (this.nthRequest != other.nthRequest) {
      return this.nthRequest > other.nthRequest;
    }
    return this.attempt > other.attempt;
  }

  @Override
  public boolean equals(Object other) {
    // instanceof for a null object returns false.
    if (!(other instanceof XGoogSpannerRequestId)) {
      return false;
    }

    XGoogSpannerRequestId otherReqId = (XGoogSpannerRequestId) (other);

    return Objects.equals(this.nthClientId, otherReqId.nthClientId)
        && Objects.equals(this.nthChannelId, otherReqId.nthChannelId)
        && Objects.equals(this.nthRequest, otherReqId.nthRequest)
        && Objects.equals(this.attempt, otherReqId.attempt);
  }

  public void incrementAttempt() {
    this.attempt++;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.nthClientId, this.nthChannelId, this.nthRequest, this.attempt);
  }

  @InternalApi
  public interface RequestIdCreator {
    long getClientId();

    XGoogSpannerRequestId nextRequestId(long channelId);

    void reset();
  }

  // TODO: Move this class into test code.
  static final class NoopRequestIdCreator implements RequestIdCreator {
    static final NoopRequestIdCreator INSTANCE = new NoopRequestIdCreator();

    private NoopRequestIdCreator() {}

    @Override
    public long getClientId() {
      return 1L;
    }

    @Override
    public XGoogSpannerRequestId nextRequestId(long channelId) {
      return XGoogSpannerRequestId.of(1, channelId, 1, 0);
    }

    @Override
    public void reset() {}
  }

  public void setChannelId(long channelId) {
    this.nthChannelId = channelId;
  }

  @VisibleForTesting
  XGoogSpannerRequestId withNthRequest(long replacementNthRequest) {
    return XGoogSpannerRequestId.of(
        this.nthClientId, this.nthChannelId, replacementNthRequest, this.attempt);
  }

  @VisibleForTesting
  XGoogSpannerRequestId withChannelId(long replacementChannelId) {
    return XGoogSpannerRequestId.of(
        this.nthClientId, replacementChannelId, this.nthRequest, this.attempt);
  }

  @VisibleForTesting
  XGoogSpannerRequestId withNthClientId(long replacementClientId) {
    return XGoogSpannerRequestId.of(
        replacementClientId, this.nthChannelId, this.nthRequest, this.attempt);
  }
}
