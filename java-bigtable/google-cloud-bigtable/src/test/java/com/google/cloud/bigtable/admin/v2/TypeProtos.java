/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.admin.v2;

public class TypeProtos {
  public static com.google.bigtable.admin.v2.Type.Bytes bytesType() {
    return com.google.bigtable.admin.v2.Type.Bytes.newBuilder()
        .setEncoding(
            com.google.bigtable.admin.v2.Type.Bytes.Encoding.newBuilder()
                .setRaw(com.google.bigtable.admin.v2.Type.Bytes.Encoding.Raw.getDefaultInstance())
                .build())
        .build();
  }

  public static com.google.bigtable.admin.v2.Type int64Type() {
    return com.google.bigtable.admin.v2.Type.newBuilder()
        .setInt64Type(
            com.google.bigtable.admin.v2.Type.Int64.newBuilder()
                .setEncoding(
                    com.google.bigtable.admin.v2.Type.Int64.Encoding.newBuilder()
                        .setBigEndianBytes(
                            com.google.bigtable.admin.v2.Type.Int64.Encoding.BigEndianBytes
                                .newBuilder()
                                .build())
                        .build()))
        .build();
  }

  public static com.google.bigtable.admin.v2.Type intSumType() {
    return com.google.bigtable.admin.v2.Type.newBuilder()
        .setAggregateType(
            com.google.bigtable.admin.v2.Type.Aggregate.newBuilder()
                .setInputType(TypeProtos.int64Type())
                .setSum(com.google.bigtable.admin.v2.Type.Aggregate.Sum.getDefaultInstance()))
        .build();
  }

  public static com.google.bigtable.admin.v2.Type intMinType() {
    return com.google.bigtable.admin.v2.Type.newBuilder()
        .setAggregateType(
            com.google.bigtable.admin.v2.Type.Aggregate.newBuilder()
                .setInputType(TypeProtos.int64Type())
                .setMin(com.google.bigtable.admin.v2.Type.Aggregate.Min.getDefaultInstance()))
        .build();
  }

  public static com.google.bigtable.admin.v2.Type intMaxType() {
    return com.google.bigtable.admin.v2.Type.newBuilder()
        .setAggregateType(
            com.google.bigtable.admin.v2.Type.Aggregate.newBuilder()
                .setInputType(TypeProtos.int64Type())
                .setMax(com.google.bigtable.admin.v2.Type.Aggregate.Max.getDefaultInstance()))
        .build();
  }

  public static com.google.bigtable.admin.v2.Type intHllType() {
    return com.google.bigtable.admin.v2.Type.newBuilder()
        .setAggregateType(
            com.google.bigtable.admin.v2.Type.Aggregate.newBuilder()
                .setInputType(TypeProtos.int64Type())
                .setHllppUniqueCount(
                    com.google.bigtable.admin.v2.Type.Aggregate.HyperLogLogPlusPlusUniqueCount
                        .getDefaultInstance()))
        .build();
  }
}
