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

package com.google.cloud.spanner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import io.grpc.Metadata;
import io.grpc.MethodDescriptor.MethodType;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class XGoogSpannerRequestIdTest {
  public static long NON_DETERMINISTIC = -1;

  @Test
  public void testEquals() {
    XGoogSpannerRequestId reqID1 = XGoogSpannerRequestId.of(1, 1, 1, 1);
    XGoogSpannerRequestId reqID2 = XGoogSpannerRequestId.of(1, 1, 1, 1);
    assertEquals(reqID1, reqID2);
    assertEquals(reqID1, reqID1);
    assertEquals(reqID2, reqID2);

    XGoogSpannerRequestId reqID3 = XGoogSpannerRequestId.of(1, 1, 1, 2);
    assertNotEquals(reqID1, reqID3);
    assertNotEquals(reqID3, reqID1);
    assertEquals(reqID3, reqID3);
  }

  @Test
  public void testEnsureHexadecimalFormatForRandProcessID() {
    String str = XGoogSpannerRequestId.of(1, 2, 3, 4).toString();
    Matcher m = XGoogSpannerRequestId.REGEX.matcher(str);
    assertTrue(m.matches());
  }

  public static class ServerHeaderEnforcer implements ServerInterceptor {
    private final Map<String, CopyOnWriteArrayList<XGoogSpannerRequestId>> unaryResults =
        new ConcurrentHashMap<>();
    private final Map<String, CopyOnWriteArrayList<XGoogSpannerRequestId>> streamingResults =
        new ConcurrentHashMap<>();
    private final List<String> gotValues = new CopyOnWriteArrayList<>();
    private final Set<String> checkMethods;

    ServerHeaderEnforcer(Set<String> checkMethods) {
      this.checkMethods = checkMethods;
    }

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
        ServerCall<ReqT, RespT> call,
        final Metadata requestHeaders,
        ServerCallHandler<ReqT, RespT> next) {
      boolean isUnary = call.getMethodDescriptor().getType() == MethodType.UNARY;
      String methodName = call.getMethodDescriptor().getFullMethodName();
      String gotReqIdStr = requestHeaders.get(XGoogSpannerRequestId.REQUEST_ID_HEADER_KEY);
      if (!this.checkMethods.contains(methodName)) {
        return next.startCall(call, requestHeaders);
      }

      Map<String, CopyOnWriteArrayList<XGoogSpannerRequestId>> saver = this.streamingResults;
      if (isUnary) {
        saver = this.unaryResults;
      }

      if (Objects.equals(gotReqIdStr, null) || Objects.equals(gotReqIdStr, "")) {
        Status status =
            Status.fromCode(Status.Code.INVALID_ARGUMENT)
                .augmentDescription(
                    methodName + " lacks " + XGoogSpannerRequestId.REQUEST_ID_HEADER_KEY);
        call.close(status, requestHeaders);
        return next.startCall(call, requestHeaders);
      }

      assertNotNull(gotReqIdStr);
      // Firstly assert and validate that at least we've got a requestId.
      Matcher m = XGoogSpannerRequestId.REGEX.matcher(gotReqIdStr);
      assertTrue(m.matches());

      XGoogSpannerRequestId reqId = XGoogSpannerRequestId.of(gotReqIdStr);
      if (!saver.containsKey(methodName)) {
        saver.put(methodName, new CopyOnWriteArrayList<XGoogSpannerRequestId>());
      }

      saver.get(methodName).add(reqId);

      // Finally proceed with the call.
      return next.startCall(call, requestHeaders);
    }

    public String[] accumulatedValues() {
      return this.gotValues.toArray(new String[0]);
    }

    public void assertIntegrity() {
      this.unaryResults.forEach(this::assertMonotonicityOfIds);
      this.streamingResults.forEach(this::assertMonotonicityOfIds);
    }

    private void assertMonotonicityOfIds(String prefix, List<XGoogSpannerRequestId> reqIds) {
      int size = reqIds.size();

      List<String> violations = new ArrayList<>();
      for (int i = 1; i < size; i++) {
        XGoogSpannerRequestId prev = reqIds.get(i - 1);
        XGoogSpannerRequestId curr = reqIds.get(i);
        if (prev.isGreaterThan(curr)) {
          violations.add(String.format("#%d(%s) > #%d(%s)", i - 1, prev, i, curr));
        }
      }

      if (violations.isEmpty()) {
        return;
      }

      throw new IllegalStateException(
          prefix
              + " monotonicity violation:"
              + String.join("\n\t", violations.toArray(new String[0])));
    }

    public MethodAndRequestId[] accumulatedUnaryValues() {
      List<MethodAndRequestId> accumulated = new ArrayList<>();
      this.unaryResults.forEach(
          (String method, CopyOnWriteArrayList<XGoogSpannerRequestId> values) -> {
            for (XGoogSpannerRequestId value : values) {
              accumulated.add(new MethodAndRequestId(method, value));
            }
          });
      return accumulated.toArray(new MethodAndRequestId[0]);
    }

    public MethodAndRequestId[] accumulatedStreamingValues() {
      List<MethodAndRequestId> accumulated = new ArrayList<>();
      this.streamingResults.forEach(
          (String method, CopyOnWriteArrayList<XGoogSpannerRequestId> values) -> {
            for (XGoogSpannerRequestId value : values) {
              accumulated.add(new MethodAndRequestId(method, value));
            }
          });
      return accumulated.toArray(new MethodAndRequestId[0]);
    }

    public void checkExpectedUnaryXGoogRequestIds(MethodAndRequestId... wantUnaryValues) {
      MethodAndRequestId[] gotUnaryValues = this.accumulatedUnaryValues();
      sortValues(gotUnaryValues);
      for (int i = 0; i < gotUnaryValues.length && false; i++) {
        System.out.println("\033[33misUnary: #" + i + ":: " + gotUnaryValues[i] + "\033[00m");
      }
      assertArrayEquals(wantUnaryValues, gotUnaryValues);
    }

    public void checkAtLeastHasExpectedUnaryXGoogRequestIds(MethodAndRequestId... wantUnaryValues) {
      MethodAndRequestId[] gotUnaryValues = this.accumulatedUnaryValues();
      sortValues(gotUnaryValues);
      for (int i = 0; i < gotUnaryValues.length && false; i++) {
        System.out.println("\033[33misUnary: #" + i + ":: " + gotUnaryValues[i] + "\033[00m");
      }
      if (wantUnaryValues.length < gotUnaryValues.length) {
        MethodAndRequestId[] gotSliced =
            Arrays.copyOfRange(gotUnaryValues, 0, wantUnaryValues.length);
        assertArrayEquals(wantUnaryValues, gotSliced);
      } else {
        assertArrayEquals(wantUnaryValues, gotUnaryValues);
      }
    }

    public void checkExpectedUnaryXGoogRequestIdsAsSuffixes(MethodAndRequestId... wantUnaryValues) {
      MethodAndRequestId[] gotUnaryValues = this.accumulatedUnaryValues();
      sortValues(gotUnaryValues);
      for (int i = 0; i < gotUnaryValues.length && false; i++) {
        System.out.println("\033[33misUnary: #" + i + ":: " + gotUnaryValues[i] + "\033[00m");
      }
      if (wantUnaryValues.length < gotUnaryValues.length) {
        MethodAndRequestId[] gotSliced =
            Arrays.copyOfRange(
                gotUnaryValues,
                gotUnaryValues.length - wantUnaryValues.length,
                gotUnaryValues.length);
        assertArrayEquals(wantUnaryValues, gotSliced);
      } else {
        assertArrayEquals(wantUnaryValues, gotUnaryValues);
      }
    }

    private void sortValues(MethodAndRequestId[] values) {
      massageValues(values);
      Arrays.sort(values, new MethodAndRequestIdComparator());
    }

    public void checkExpectedStreamingXGoogRequestIds(MethodAndRequestId... wantStreamingValues) {
      MethodAndRequestId[] gotStreamingValues = this.accumulatedStreamingValues();
      for (int i = 0; i < gotStreamingValues.length && false; i++) {
        System.out.println(
            "\033[32misStreaming: #" + i + ":: " + gotStreamingValues[i] + "\033[00m");
      }
      sortValues(gotStreamingValues);
      assertArrayEquals(wantStreamingValues, gotStreamingValues);
    }

    public void reset() {
      this.gotValues.clear();
      this.unaryResults.clear();
      this.streamingResults.clear();
    }
  }

  public static class MethodAndRequestId {
    String method;
    XGoogSpannerRequestId requestId;

    public MethodAndRequestId(String method, XGoogSpannerRequestId requestId) {
      this.method = method;
      this.requestId = requestId;
    }

    public String toString() {
      return "{" + this.method + ":" + this.requestId.debugToString() + "}";
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof MethodAndRequestId)) {
        return false;
      }
      MethodAndRequestId other = (MethodAndRequestId) o;
      return Objects.equals(this.method, other.method)
          && Objects.equals(this.requestId, other.requestId);
    }
  }

  static class MethodAndRequestIdComparator implements Comparator<MethodAndRequestId> {
    @Override
    public int compare(MethodAndRequestId mr1, MethodAndRequestId mr2) {
      int cmpMethod = mr1.method.compareTo(mr2.method);
      if (cmpMethod != 0) {
        return cmpMethod;
      }

      if (Objects.equals(mr1.requestId, mr2.requestId)) {
        return 0;
      }
      if (mr1.requestId.isGreaterThan(mr2.requestId)) {
        return +1;
      }
      return -1;
    }
  }

  static void massageValues(MethodAndRequestId[] mreqs) {
    for (int i = 0; i < mreqs.length; i++) {
      MethodAndRequestId mreq = mreqs[i];
      // BatchCreateSessions is so hard to control as the round-robin doling out
      // hence we might need to be able to scrub the nth_request that won't match
      // nth_req in consecutive order of nth_client.
      if (mreq.method.compareTo("google.spanner.v1.Spanner/BatchCreateSessions") == 0) {
        mreqs[i] =
            new MethodAndRequestId(
                mreq.method,
                mreq.requestId
                    .withNthRequest(NON_DETERMINISTIC)
                    .withChannelId(NON_DETERMINISTIC)
                    .withNthClientId(NON_DETERMINISTIC));
      } else if (mreq.method.compareTo("google.spanner.v1.Spanner/BeginTransaction") == 0
          || mreq.method.compareTo("google.spanner.v1.Spanner/ExecuteStreamingSql") == 0
          || mreq.method.compareTo("google.spanner.v1.Spanner/ExecuteSql") == 0
          || mreq.method.compareTo("google.spanner.v1.Spanner/CreateSession") == 0
          || mreq.method.compareTo("google.spanner.v1.Spanner/Commit") == 0) {
        mreqs[i] =
            new MethodAndRequestId(mreq.method, mreq.requestId.withNthClientId(NON_DETERMINISTIC));
      }
    }
  }

  public static MethodAndRequestId ofMethodAndRequestId(String method, String reqId) {
    return new MethodAndRequestId(method, XGoogSpannerRequestId.of(reqId));
  }

  public static MethodAndRequestId ofMethodAndRequestId(
      String method, XGoogSpannerRequestId reqId) {
    return new MethodAndRequestId(method, reqId);
  }
}
