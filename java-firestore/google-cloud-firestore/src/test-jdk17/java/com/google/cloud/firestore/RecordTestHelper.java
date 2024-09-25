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

package com.google.cloud.firestore;

import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.LocalFirestoreHelper.SingleField;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.MapValue;
import com.google.firestore.v1.Value;
import com.google.protobuf.NullValue;
import com.google.type.LatLng;

import static com.google.cloud.firestore.LocalFirestoreHelper.commitResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.map;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public final class RecordTestHelper {

  public static final String DATABASE_NAME;
  public static final String DOCUMENT_PATH;
  public static final String DOCUMENT_NAME;
  public static final String DOCUMENT_ROOT;

  public static final SingleComponent SINGLE_COMPONENT_OBJECT;
  public static final Map<String, Value> SINGLE_COMPONENT_PROTO;

  public static final NestedRecord NESTED_RECORD_OBJECT;
  public static final NestedRecordWithPOJO NESTED_RECORD_WITH_POJO_OBJECT;
  public static final NestedPOJOWithRecord NESTED_POJO_WITH_RECORD_OBJECT;

  public static final ServerTimestamp SERVER_TIMESTAMP_OBJECT;
  public static final Map<String, Value> SERVER_TIMESTAMP_PROTO;

  public static final AllSupportedTypes ALL_SUPPORTED_TYPES_OBJECT;
  public static final Map<String, Value> ALL_SUPPORTED_TYPES_PROTO;

  public static final ApiFuture<CommitResponse> SINGLE_WRITE_COMMIT_RESPONSE;

  public static final ApiFuture<CommitResponse> FIELD_TRANSFORM_COMMIT_RESPONSE;

  public static final Date DATE;
  public static final Timestamp TIMESTAMP;
  public static final GeoPoint GEO_POINT;
  public static final Blob BLOB;


  public record SingleComponent(
      String foo) {
  }
  
  public record NestedRecord(
      SingleComponent first,
      AllSupportedTypes second) {
  }

  public record NestedRecordWithPOJO(
      SingleField first,
      AllSupportedTypes second) {
  }

  public static class NestedPOJOWithRecord {
    public SingleField first = new SingleField();
    public AllSupportedTypes second = ALL_SUPPORTED_TYPES_OBJECT;
  }

  public record ServerTimestamp (

    @com.google.cloud.firestore.annotation.ServerTimestamp Date foo,
    Inner inner

  ){
    record Inner (

      @com.google.cloud.firestore.annotation.ServerTimestamp Date bar
    ){}
  }

  public record InvalidRecord (
    BigInteger bigIntegerValue,
    Byte byteValue,
    Short shortValue
  ){}


  public record AllSupportedTypes (

    String foo,
    Double doubleValue,
    long longValue,
    double nanValue,
    double infValue,
    double negInfValue,
    boolean trueValue,
    boolean falseValue,
    SingleComponent objectValue,
    Date dateValue,
    Timestamp timestampValue,
    List<String> arrayValue,
    String nullValue,
    Blob bytesValue,
    GeoPoint geoPointValue,
    Map<String, Object> model
  ){}

  static {
    try {
      DATE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S z").parse("1985-03-18 08:20:00.123 CET");
    } catch (ParseException e) {
      throw new RuntimeException("Failed to parse date", e);
    }

    TIMESTAMP =
        Timestamp.ofTimeSecondsAndNanos(
            TimeUnit.MILLISECONDS.toSeconds(DATE.getTime()),
            123000); // Firestore truncates to microsecond precision.
    GEO_POINT = new GeoPoint(50.1430847, -122.9477780);
    BLOB = Blob.fromBytes(new byte[] {1, 2, 3});

    DATABASE_NAME = "projects/test-project/databases/(default)";
    DOCUMENT_PATH = "coll/doc";
    DOCUMENT_NAME = DATABASE_NAME + "/documents/" + DOCUMENT_PATH;
    DOCUMENT_ROOT = DATABASE_NAME + "/documents/";

    SINGLE_COMPONENT_OBJECT = new SingleComponent("bar");
    SINGLE_COMPONENT_PROTO = map("foo", Value.newBuilder().setStringValue("bar").build());

    SERVER_TIMESTAMP_PROTO = Collections.emptyMap();
    SERVER_TIMESTAMP_OBJECT = new ServerTimestamp(null, new ServerTimestamp.Inner(null));

    ALL_SUPPORTED_TYPES_OBJECT = new AllSupportedTypes("bar", 0.0, 0L, Double.NaN, Double.POSITIVE_INFINITY,
                                                       Double.NEGATIVE_INFINITY, true, false,
                                                       new SingleComponent("bar"), DATE,
                                                       TIMESTAMP, ImmutableList.of("foo"), null, BLOB, GEO_POINT,
                                                       ImmutableMap.of("foo", SINGLE_COMPONENT_OBJECT.foo()));
    ALL_SUPPORTED_TYPES_PROTO =
        ImmutableMap.<String, Value>builder()
            .put("foo", Value.newBuilder().setStringValue("bar").build())
            .put("doubleValue", Value.newBuilder().setDoubleValue(0.0).build())
            .put("longValue", Value.newBuilder().setIntegerValue(0L).build())
            .put("nanValue", Value.newBuilder().setDoubleValue(Double.NaN).build())
            .put("infValue", Value.newBuilder().setDoubleValue(Double.POSITIVE_INFINITY).build())
            .put("negInfValue", Value.newBuilder().setDoubleValue(Double.NEGATIVE_INFINITY).build())
            .put("trueValue", Value.newBuilder().setBooleanValue(true).build())
            .put("falseValue", Value.newBuilder().setBooleanValue(false).build())
            .put(
                "objectValue",
                Value.newBuilder()
                    .setMapValue(MapValue.newBuilder().putAllFields(SINGLE_COMPONENT_PROTO))
                    .build())
            .put(
                "dateValue",
                Value.newBuilder()
                    .setTimestampValue(
                        com.google.protobuf.Timestamp.newBuilder()
                            .setSeconds(479978400)
                            .setNanos(123000000)) // Dates only support millisecond precision.
                    .build())
            .put(
                "timestampValue",
                Value.newBuilder()
                    .setTimestampValue(
                        com.google.protobuf.Timestamp.newBuilder()
                            .setSeconds(479978400)
                            .setNanos(123000)) // Timestamps supports microsecond precision.
                    .build())
            .put(
                "arrayValue",
                Value.newBuilder()
                    .setArrayValue(
                                    ArrayValue.newBuilder().addValues(Value.newBuilder().setStringValue("foo")))
                    .build())
            .put("nullValue", Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
            .put("bytesValue", Value.newBuilder().setBytesValue(BLOB.toByteString()).build())
            .put(
                "geoPointValue",
                Value.newBuilder()
                    .setGeoPointValue(
                                    LatLng.newBuilder().setLatitude(50.1430847).setLongitude(-122.9477780))
                    .build())
            .put(
                "model",
                Value.newBuilder()
                    .setMapValue(MapValue.newBuilder().putAllFields(SINGLE_COMPONENT_PROTO))
                    .build())
            .build();
    SINGLE_WRITE_COMMIT_RESPONSE = commitResponse(/* adds= */ 1, /* deletes= */ 0);

    FIELD_TRANSFORM_COMMIT_RESPONSE = commitResponse(/* adds= */ 2, /* deletes= */ 0);

    NESTED_RECORD_OBJECT = new NestedRecord(SINGLE_COMPONENT_OBJECT, ALL_SUPPORTED_TYPES_OBJECT);

    NESTED_RECORD_WITH_POJO_OBJECT = new NestedRecordWithPOJO(new SingleField(), ALL_SUPPORTED_TYPES_OBJECT);

    NESTED_POJO_WITH_RECORD_OBJECT = new NestedPOJOWithRecord();
  }

}
