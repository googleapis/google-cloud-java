/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.session;

import com.google.bigtable.v2.FakeSessionGrpc;
import com.google.bigtable.v2.FakeSessionOpRequest;
import com.google.bigtable.v2.FakeSessionOpResponse;
import com.google.bigtable.v2.OpenFakeSessionRequest;
import com.google.bigtable.v2.SessionFakeScriptedRequest;
import com.google.bigtable.v2.SessionFakeScriptedResponse;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.MethodInfo;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcDescriptor.Decoder;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcDescriptor.Encoder;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcDescriptor.SessionDescriptor;
import com.google.common.collect.ImmutableMap;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class FakeDescriptor {
  public static final SessionDescriptor<OpenFakeSessionRequest> FAKE_SESSION =
      new SessionDescriptor<>(
          FakeSessionGrpc.getOpenSessionMethod(), r -> "FAKE_SESSION", r -> ImmutableMap.of());
  public static VRpcDescriptor<
          OpenFakeSessionRequest, SessionFakeScriptedRequest, SessionFakeScriptedResponse>
      SCRIPTED =
          new VRpcDescriptor<>(
              FAKE_SESSION,
              MethodInfo.of("Bigtable.FakeMethod", false),
              createFakeEncoder(FakeSessionOpRequest.Builder::setScriptedRequest),
              createFakeDecoder(FakeSessionOpResponse::getScripted),
              (name, appProfileId, req) -> {
                throw new UnsupportedOperationException();
              });

  private static <ReqT> Encoder<ReqT> createFakeEncoder(
      BiConsumer<FakeSessionOpRequest.Builder, ReqT> subEncoder) {
    return req -> {
      FakeSessionOpRequest.Builder builder = FakeSessionOpRequest.newBuilder();
      subEncoder.accept(builder, req);
      return builder.build().toByteString();
    };
  }

  private static <RespT> Decoder<RespT> createFakeDecoder(
      Function<FakeSessionOpResponse, RespT> subDecoder) {
    return (bytes) -> subDecoder.apply(FakeSessionOpResponse.parseFrom(bytes));
  }
}
