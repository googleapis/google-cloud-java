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

package com.google.cloud.spanner.spi.v1;

import com.google.cloud.grpc.GcpManagedChannel;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.SpannerGrpc;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import javax.annotation.Nullable;

final class GrpcGcpAffinityUtil {
  private GrpcGcpAffinityUtil() {}

  static void clearChannelHintAffinity(
      @Nullable ManagedChannel channel, @Nullable Long channelHint) {
    if (!(channel instanceof GcpManagedChannel) || channelHint == null) {
      return;
    }
    // TODO: Replace this synthetic call once grpc-gcp exposes a direct API for unbinding
    // affinity keys without creating and immediately cancelling a ClientCall.
    ClientCall<ExecuteSqlRequest, ResultSet> call =
        channel.newCall(
            SpannerGrpc.getExecuteSqlMethod(),
            CallOptions.DEFAULT
                .withOption(GcpManagedChannel.AFFINITY_KEY, String.valueOf(channelHint))
                .withOption(GcpManagedChannel.UNBIND_AFFINITY_KEY, true));
    call.cancel("Cloud Spanner transaction closed", null);
  }
}
