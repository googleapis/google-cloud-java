/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.datastore;

import static com.google.common.truth.Truth.assertThat;

import io.grpc.Status.Code;
import java.util.EnumMap;
import org.junit.Test;

public class GrpcToDatastoreCodeTranslationTest {
  @Test
  public void grpcCodeToDatastoreCode_expectedMapping() {
    EnumMap<Code, Integer> expected = new EnumMap<>(Code.class);
    expected.put(Code.OK, com.google.rpc.Code.OK.getNumber());
    expected.put(Code.INVALID_ARGUMENT, com.google.rpc.Code.INVALID_ARGUMENT.getNumber());
    expected.put(Code.OUT_OF_RANGE, com.google.rpc.Code.OUT_OF_RANGE.getNumber());
    expected.put(Code.UNAUTHENTICATED, com.google.rpc.Code.UNAUTHENTICATED.getNumber());
    expected.put(Code.PERMISSION_DENIED, com.google.rpc.Code.PERMISSION_DENIED.getNumber());
    expected.put(Code.NOT_FOUND, com.google.rpc.Code.NOT_FOUND.getNumber());
    expected.put(Code.FAILED_PRECONDITION, com.google.rpc.Code.FAILED_PRECONDITION.getNumber());
    expected.put(Code.ALREADY_EXISTS, com.google.rpc.Code.ALREADY_EXISTS.getNumber());
    expected.put(Code.RESOURCE_EXHAUSTED, com.google.rpc.Code.RESOURCE_EXHAUSTED.getNumber());
    expected.put(Code.INTERNAL, com.google.rpc.Code.INTERNAL.getNumber());
    expected.put(Code.UNIMPLEMENTED, com.google.rpc.Code.UNIMPLEMENTED.getNumber());
    expected.put(Code.UNAVAILABLE, com.google.rpc.Code.UNAVAILABLE.getNumber());
    expected.put(Code.ABORTED, com.google.rpc.Code.ABORTED.getNumber());
    expected.put(Code.CANCELLED, com.google.rpc.Code.CANCELLED.getNumber());
    expected.put(Code.UNKNOWN, com.google.rpc.Code.UNKNOWN.getNumber());
    expected.put(Code.DEADLINE_EXCEEDED, com.google.rpc.Code.DEADLINE_EXCEEDED.getNumber());
    expected.put(Code.DATA_LOSS, com.google.rpc.Code.DATA_LOSS.getNumber());

    EnumMap<Code, Integer> actual = new EnumMap<>(Code.class);
    for (Code c : Code.values()) {
      actual.put(c, GrpcToDatastoreCodeTranslation.grpcCodeToDatastoreStatusCode(c));
    }

    assertThat(actual).isEqualTo(expected);
  }
}
