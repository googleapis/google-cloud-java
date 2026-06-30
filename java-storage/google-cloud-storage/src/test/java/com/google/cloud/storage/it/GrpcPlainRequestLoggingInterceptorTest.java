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

package com.google.cloud.storage.it;

import static com.google.cloud.storage.TestUtils.GRPC_STATUS_DETAILS_KEY;
import static com.google.common.truth.Truth.assertThat;

import com.google.common.io.Resources;
import com.google.protobuf.Any;
import com.google.protobuf.TextFormat;
import com.google.rpc.DebugInfo;
import com.google.storage.v2.BidiReadObjectError;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiReadObjectSpec;
import com.google.storage.v2.ReadRange;
import com.google.storage.v2.ReadRangeError;
import io.grpc.Metadata;
import io.grpc.Status;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Supplier;
import org.junit.Test;

public final class GrpcPlainRequestLoggingInterceptorTest {

  @Test
  public void lazyOnCloseLogStringGolden() throws IOException {
    BidiReadObjectRequest request =
        BidiReadObjectRequest.newBuilder()
            .setReadObjectSpec(
                BidiReadObjectSpec.newBuilder()
                    .setBucket("projects/_/buckets/b")
                    .setObject("o")
                    .setGeneration(1)
                    .build())
            .addReadRanges(ReadRange.newBuilder().setReadId(3).setReadOffset(39).build())
            .build();

    Optional<ReadRange> readRange = request.getReadRangesList().stream().findFirst();
    String message =
        String.format(
            Locale.US,
            "OUT_OF_RANGE read_offset = %d",
            readRange.map(ReadRange::getReadOffset).orElse(0L));
    long readId = readRange.map(ReadRange::getReadId).orElse(0L);

    BidiReadObjectError err2 =
        BidiReadObjectError.newBuilder()
            .addReadRangeErrors(
                ReadRangeError.newBuilder()
                    .setReadId(readId)
                    .setStatus(
                        com.google.rpc.Status.newBuilder()
                            .setCode(com.google.rpc.Code.OUT_OF_RANGE_VALUE)
                            .build())
                    .build())
            .build();

    com.google.rpc.Status grpcStatusDetails =
        com.google.rpc.Status.newBuilder()
            .setCode(com.google.rpc.Code.UNAVAILABLE_VALUE)
            .setMessage("fail read_id: " + readId)
            .addDetails(Any.pack(err2))
            .addDetails(
                Any.pack(
                    DebugInfo.newBuilder()
                        .setDetail(message)
                        .addStackEntries(TextFormat.printer().shortDebugString(request))
                        .build()))
            .build();

    Metadata trailers = new Metadata();
    trailers.put(GRPC_STATUS_DETAILS_KEY, grpcStatusDetails);
    Supplier<String> supplier =
        GrpcPlainRequestLoggingInterceptor.lazyOnCloseLogString(Status.OUT_OF_RANGE, trailers);
    String actual = supplier.get();

    String expected =
        loadGoldenFile(
            "com/google/cloud/storage/it/GrpcPlainRequestLoggingInterceptor/golden/OUT_OF_RANGE.txt");
    assertThat(actual).isEqualTo(expected);
  }

  private static String loadGoldenFile(String resourcePath) throws IOException {
    URL url =
        GrpcPlainRequestLoggingInterceptorTest.class.getClassLoader().getResource(resourcePath);
    assertThat(url).isNotNull();

    return Resources.toString(url, StandardCharsets.UTF_8).replace(System.lineSeparator(), "\n");
  }
}
