/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.storage;

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public final class FeatureTrackingTest {

  private static final int PCU_MASK = TrackedFeature.PCU.bitMask();

  @Test
  public void encode_knownVectors() throws Exception {
    assertAll(
        () -> assertThat(FeatureTracking.encode(0)).isEqualTo("AAAAAA=="),
        () -> assertThat(FeatureTracking.encode(1)).isEqualTo("AAAAAQ=="),
        () -> assertThat(FeatureTracking.encode(2)).isEqualTo("AAAAAg=="),
        () -> assertThat(FeatureTracking.encode(3)).isEqualTo("AAAAAw=="),
        () -> assertThat(FeatureTracking.encode(4)).isEqualTo("AAAABA=="),
        // 0xF8 and 0xFC produce the 62nd and 63rd base64 alphabet characters, which must be the
        // URL-safe '-' and '_' rather than the standard '+' and '/'
        () -> assertThat(FeatureTracking.encode(0xF8)).isEqualTo("AAAA-A=="),
        () -> assertThat(FeatureTracking.encode(0xFC)).isEqualTo("AAAA_A=="),
        // high bit set; verify unsigned, big-endian interpretation
        () -> assertThat(FeatureTracking.encode(0x80000000)).isEqualTo("gAAAAA=="),
        () -> assertThat(FeatureTracking.encode(0xFFFFFFFF)).isEqualTo("_____w=="));
  }

  @Test
  public void trackedFeature_bitMasksAreDistinctSingleBits() {
    Set<Integer> seen = new HashSet<>();
    for (TrackedFeature feature : TrackedFeature.values()) {
      assertThat(Integer.bitCount(feature.bitMask())).isEqualTo(1);
      seen.add(feature.bitMask());
    }
    assertThat(seen).hasSize(TrackedFeature.values().length);
  }

  /** Once released a feature's bit position must never change; pin it. */
  @Test
  public void trackedFeature_pcu_isBitZero() {
    assertThat(TrackedFeature.PCU.bitMask()).isEqualTo(1);
  }

  @Test
  public void trackedFeatures_zeroMask_throws() {
    assertThrows(IllegalArgumentException.class, () -> UnifiedOpts.trackedFeatures(0));
  }

  @Test
  public void trackedFeatures_grpc_addsHeaderWithLiteralWireNameAndValue() {
    Opts<ObjectTargetOpt> opts = Opts.from(UnifiedOpts.trackedFeatures(PCU_MASK));

    GrpcCallContext ctx = opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());

    assertThat(ctx.getExtraHeaders())
        .containsExactly("x-goog-storage-java-features", ImmutableList.of("AAAAAQ=="));
  }

  @Test
  public void trackedFeatures_http_addsHeaderWithLiteralWireNameAndValue() {
    Opts<ObjectTargetOpt> opts = Opts.from(UnifiedOpts.trackedFeatures(PCU_MASK));

    ImmutableMap<StorageRpc.Option, ?> rpcOptions = opts.getRpcOptions();

    assertThat(rpcOptions)
        .containsExactly(
            StorageRpc.Option.EXTRA_HEADERS,
            ImmutableMap.of("x-goog-storage-java-features", "AAAAAQ=="));
  }

  /**
   * {@link Opts#prepend} drops opts whose type is already present; the tracking header must survive
   * being prepended to opts which already contain user supplied extra headers, and both must reach
   * the wire on both transports.
   */
  @Test
  public void trackedFeatures_coexistsWithUserExtraHeaders_grpcAndHttp() throws Exception {
    Opts<ObjectTargetOpt> userOpts =
        Opts.from(UnifiedOpts.extraHeaders(ImmutableMap.of("x-user-header", "user-value")));
    Opts<ObjectTargetOpt> tracked = Opts.from(UnifiedOpts.trackedFeatures(PCU_MASK));

    Opts<ObjectTargetOpt> opts = userOpts.prepend(tracked);

    GrpcCallContext ctx = opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
    ImmutableMap<StorageRpc.Option, ?> rpcOptions = opts.getRpcOptions();
    assertAll(
        () ->
            assertThat(ctx.getExtraHeaders())
                .containsExactly(
                    "x-goog-storage-java-features", ImmutableList.of("AAAAAQ=="),
                    "x-user-header", ImmutableList.of("user-value")),
        () ->
            assertThat(rpcOptions)
                .containsExactly(
                    StorageRpc.Option.EXTRA_HEADERS,
                    ImmutableMap.of(
                        "x-goog-storage-java-features", "AAAAAQ==",
                        "x-user-header", "user-value")));
  }

  @Test
  public void extraHeaders_featureTrackingHeader_throws() {
    ImmutableMap<String, String> headers = ImmutableMap.of(FeatureTracking.HEADER, "AAAAAQ==");

    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> UnifiedOpts.extraHeaders(headers));

    assertThat(thrown).hasMessageThat().contains("Disallowed headers");
    assertThat(thrown).hasMessageThat().contains("x-goog-storage-java-features");
  }
}
