/*
 * Copyright 2017 Google LLC
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

import static org.junit.Assert.assertEquals;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.firestore.v1beta1.ArrayValue;
import com.google.firestore.v1beta1.BatchGetDocumentsRequest;
import com.google.firestore.v1beta1.BatchGetDocumentsResponse;
import com.google.firestore.v1beta1.BeginTransactionRequest;
import com.google.firestore.v1beta1.BeginTransactionResponse;
import com.google.firestore.v1beta1.CommitRequest;
import com.google.firestore.v1beta1.CommitResponse;
import com.google.firestore.v1beta1.Cursor;
import com.google.firestore.v1beta1.DatabaseRootName;
import com.google.firestore.v1beta1.Document;
import com.google.firestore.v1beta1.DocumentMask;
import com.google.firestore.v1beta1.DocumentTransform;
import com.google.firestore.v1beta1.DocumentTransform.FieldTransform;
import com.google.firestore.v1beta1.MapValue;
import com.google.firestore.v1beta1.Precondition;
import com.google.firestore.v1beta1.RollbackRequest;
import com.google.firestore.v1beta1.RunQueryRequest;
import com.google.firestore.v1beta1.RunQueryResponse;
import com.google.firestore.v1beta1.StructuredQuery;
import com.google.firestore.v1beta1.Value;
import com.google.firestore.v1beta1.Write;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.NullValue;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.threeten.bp.Instant;

public final class LocalFirestoreHelper {

  public static final String DATABASE_NAME;
  public static final String DOCUMENT_PATH;
  public static final String DOCUMENT_NAME;
  public static final ByteString TRANSACTION_ID;

  public static final Map<String, Value> EMPTY_MAP_PROTO;

  public static final Map<String, Object> SINGLE_FIELD_MAP;
  public static final SingleField SINGLE_FIELD_OBJECT;
  public static final Map<String, Value> SINGLE_FIELD_PROTO;
  public static final DocumentSnapshot SINGLE_FIELD_SNAPSHOT;

  public static final Map<String, Object> UPDATED_FIELD_MAP;
  public static final Map<String, Value> UPDATED_FIELD_PROTO;

  public static final NestedClass NESTED_CLASS_OBJECT;

  public static final Map<String, Object> SERVER_TIMESTAMP_MAP;
  public static final ServerTimestamp SERVER_TIMESTAMP_OBJECT;
  public static final Map<String, Value> SERVER_TIMESTAMP_PROTO;
  public static final Write SERVER_TIMESTAMP_TRANSFORM;

  public static final Map<String, Object> ALL_SUPPORTED_TYPES_MAP;
  public static final AllSupportedTypes ALL_SUPPORTED_TYPES_OBJECT;
  public static final Map<String, Value> ALL_SUPPORTED_TYPES_PROTO;

  public static final CommitRequest SINGLE_CREATE_COMMIT_REQUEST;
  public static final ApiFuture<CommitResponse> SINGLE_DELETE_COMMIT_RESPONSE;
  public static final ApiFuture<CommitResponse> SINGLE_WRITE_COMMIT_RESPONSE;

  public static final ApiFuture<CommitResponse> SERVER_TIMESTAMP_COMMIT_RESPONSE;

  public static final Date DATE;
  public static final GeoPoint GEO_POINT;
  public static final Blob BLOB;

  public static final Precondition CREATE_PRECONDITION;

  public static final Precondition UPDATE_PRECONDITION;

  public static class SingleField {

    public String foo = "bar";

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      SingleField that = (SingleField) o;

      return foo.equals(that.foo);
    }
  }

  public static class NestedClass {
    public SingleField first = new SingleField();
    public AllSupportedTypes second = new AllSupportedTypes();
  }

  public static class ServerTimestamp {

    @com.google.cloud.firestore.annotation.ServerTimestamp public Date foo;
    public Inner inner = new Inner();

    class Inner {

      @com.google.cloud.firestore.annotation.ServerTimestamp public Date bar;
    }
  }

  public static <K, V> Map<K, V> map(K key, V value, Object... moreKeysAndValues) {
    Map<K, V> map = new HashMap<>();
    map.put(key, value);

    for (int i = 0; i < moreKeysAndValues.length; i += 2) {
      map.put((K) moreKeysAndValues[i], (V) moreKeysAndValues[i + 1]);
    }

    return map;
  }

  public static Map<String, Object> map() {
    return new HashMap<>();
  }

  public static Answer<BatchGetDocumentsResponse> getAllResponse(
      final Map<String, Value>... fields) {
    BatchGetDocumentsResponse[] responses = new BatchGetDocumentsResponse[fields.length];

    for (int i = 0; i < fields.length; ++i) {
      String name = DOCUMENT_NAME;
      if (fields.length > 1) {
        name += i + 1;
      }
      BatchGetDocumentsResponse.Builder response = BatchGetDocumentsResponse.newBuilder();
      response.getFoundBuilder().setCreateTime(Timestamp.newBuilder().setSeconds(1).setNanos(2));
      response.getFoundBuilder().setUpdateTime(Timestamp.newBuilder().setSeconds(3).setNanos(4));
      response.setReadTime(Timestamp.newBuilder().setSeconds(5).setNanos(6));
      response.getFoundBuilder().setName(name).putAllFields(fields[i]);
      responses[i] = response.build();
    }

    return streamingResponse(responses);
  }

  public static ApiFuture<Empty> rollbackResponse() {
    return ApiFutures.immediateFuture(Empty.getDefaultInstance());
  }

  public static Answer<RunQueryResponse> queryResponse() {
    return queryResponse(DOCUMENT_NAME);
  }

  public static Answer<RunQueryResponse> queryResponse(String... documentNames) {
    RunQueryResponse[] responses = new RunQueryResponse[documentNames.length];

    for (int i = 0; i < documentNames.length; ++i) {
      final RunQueryResponse.Builder runQueryResponse = RunQueryResponse.newBuilder();
      runQueryResponse.setDocument(
          Document.newBuilder().setName(documentNames[i]).putAllFields(SINGLE_FIELD_PROTO));
      runQueryResponse.setReadTime(Timestamp.newBuilder().setSeconds(1).setNanos(2));
      responses[i] = runQueryResponse.build();
    }
    return streamingResponse(responses);
  }

  public static <T> Answer<T> streamingResponse(final T... response) {
    return new Answer<T>() {
      public T answer(InvocationOnMock invocation) {
        Object[] args = invocation.getArguments();
        ApiStreamObserver<T> observer = (ApiStreamObserver<T>) args[1];
        for (T resp : response) {
          observer.onNext(resp);
        }
        observer.onCompleted();
        return null;
      }
    };
  }

  public static ApiFuture<CommitResponse> commitResponse(int adds, int deletes) {
    CommitResponse.Builder commitResponse = CommitResponse.newBuilder();
    commitResponse.getCommitTimeBuilder().setSeconds(0).setNanos(0);
    for (int i = 0; i < adds; ++i) {
      commitResponse.addWriteResultsBuilder().getUpdateTimeBuilder().setSeconds(i).setNanos(i);
    }
    for (int i = 0; i < deletes; ++i) {
      commitResponse.addWriteResultsBuilder();
    }
    return ApiFutures.immediateFuture(commitResponse.build());
  }

  public static BeginTransactionRequest begin() {
    return begin(null);
  }

  public static BeginTransactionRequest begin(@Nullable ByteString previousTransactionId) {
    BeginTransactionRequest.Builder begin = BeginTransactionRequest.newBuilder();
    begin.setDatabase(DATABASE_NAME);

    if (previousTransactionId != null) {
      begin.getOptionsBuilder().getReadWriteBuilder().setRetryTransaction(previousTransactionId);
    }

    return begin.build();
  }

  public static ApiFuture<BeginTransactionResponse> beginResponse() {
    return beginResponse(TRANSACTION_ID);
  }

  public static ApiFuture<BeginTransactionResponse> beginResponse(ByteString transactionId) {
    BeginTransactionResponse.Builder beginResponse = BeginTransactionResponse.newBuilder();
    beginResponse.setTransaction(transactionId);
    return ApiFutures.immediateFuture(beginResponse.build());
  }

  public static RollbackRequest rollback() {
    RollbackRequest.Builder rollback = RollbackRequest.newBuilder();
    rollback.setDatabase(DATABASE_NAME);
    rollback.setTransaction(TRANSACTION_ID);
    return rollback.build();
  }

  public static Write transform(String... fieldPaths) {
    return transform(null, fieldPaths);
  }

  public static Write transform(@Nullable Precondition precondition, String... fieldPaths) {
    Write.Builder write = Write.newBuilder();
    DocumentTransform.Builder transform = write.getTransformBuilder();
    transform.setDocument(DOCUMENT_NAME);

    for (String fieldPath : fieldPaths) {
      transform
          .addFieldTransformsBuilder()
          .setFieldPath(fieldPath)
          .setSetToServerValue(DocumentTransform.FieldTransform.ServerValue.REQUEST_TIME);
    }

    if (precondition != null) {
      write.setCurrentDocument(precondition);
    }

    return write.build();
  }

  public static Write create(Map<String, Value> fields) {
    Write.Builder write = Write.newBuilder();
    Document.Builder document = write.getUpdateBuilder();
    document.setName(DOCUMENT_NAME);
    document.putAllFields(fields);
    write.getCurrentDocumentBuilder().setExists(false);
    return write.build();
  }

  public static Write set(Map<String, Value> fields) {
    return set(fields, null);
  }

  public static Write set(Map<String, Value> fields, @Nullable List<String> fieldMap) {
    Write.Builder write = Write.newBuilder();
    Document.Builder document = write.getUpdateBuilder();
    document.setName(DOCUMENT_NAME);
    document.putAllFields(fields);

    if (fieldMap != null) {
      write.getUpdateMaskBuilder().addAllFieldPaths(fieldMap);
    }

    return write.build();
  }

  public static Write delete() {
    Write.Builder write = Write.newBuilder();
    write.setDelete(DOCUMENT_NAME);
    return write.build();
  }

  public static Write delete(Precondition precondition) {
    Write.Builder write = Write.newBuilder();
    write.setDelete(DOCUMENT_NAME);
    write.getCurrentDocumentBuilder().mergeFrom(precondition);
    return write.build();
  }

  public static Write update(Map<String, Value> fields, List<String> fieldMap) {
    Write.Builder write = Write.newBuilder();
    Document.Builder document = write.getUpdateBuilder();
    document.setName(DOCUMENT_NAME);
    document.putAllFields(fields);
    write.getUpdateMaskBuilder().addAllFieldPaths(fieldMap);
    write.getCurrentDocumentBuilder().setExists(true);
    return write.build();
  }

  public static Write update(
      Map<String, Value> fields, @Nullable List<String> fieldMap, Precondition precondition) {
    Write.Builder write = Write.newBuilder();
    Document.Builder document = write.getUpdateBuilder();
    document.setName(DOCUMENT_NAME);
    document.putAllFields(fields);
    write.getUpdateMaskBuilder().addAllFieldPaths(fieldMap);
    write.getCurrentDocumentBuilder().mergeFrom(precondition);
    return write.build();
  }

  public static CommitRequest commit(@Nullable ByteString transactionId, Write... writes) {
    CommitRequest.Builder commitRequest = CommitRequest.newBuilder();
    commitRequest.setDatabase(DATABASE_NAME);
    commitRequest.addAllWrites(Arrays.asList(writes));

    if (transactionId != null) {
      commitRequest.setTransaction(transactionId);
    }

    return commitRequest.build();
  }

  public static CommitRequest commit(Write... writes) {
    return commit(null, writes);
  }

  public static StructuredQuery filter(StructuredQuery.FieldFilter.Operator operator) {
    StructuredQuery.Builder structuredQuery = StructuredQuery.newBuilder();
    StructuredQuery.CompositeFilter.Builder compositeFilter =
        structuredQuery.getWhereBuilder().getCompositeFilterBuilder();
    compositeFilter.setOp(StructuredQuery.CompositeFilter.Operator.AND);

    StructuredQuery.FieldFilter.Builder fieldFilter =
        compositeFilter.addFiltersBuilder().getFieldFilterBuilder();
    fieldFilter.setField(StructuredQuery.FieldReference.newBuilder().setFieldPath("foo"));
    fieldFilter.setOp(operator);
    fieldFilter.setValue(Value.newBuilder().setStringValue("bar"));

    return structuredQuery.build();
  }

  public static StructuredQuery unaryFilter(StructuredQuery.UnaryFilter.Operator operator) {
    StructuredQuery.Builder structuredQuery = StructuredQuery.newBuilder();
    StructuredQuery.CompositeFilter.Builder compositeFilter =
        structuredQuery.getWhereBuilder().getCompositeFilterBuilder();
    compositeFilter.setOp(StructuredQuery.CompositeFilter.Operator.AND);

    StructuredQuery.UnaryFilter.Builder fieldFilter =
        compositeFilter.addFiltersBuilder().getUnaryFilterBuilder();
    fieldFilter.setField(StructuredQuery.FieldReference.newBuilder().setFieldPath("foo"));
    fieldFilter.setOp(operator);

    return structuredQuery.build();
  }

  public static RunQueryRequest query(StructuredQuery... query) {
    return query(null, query);
  }

  public static RunQueryRequest query(
      @Nullable ByteString transactionId, StructuredQuery... query) {
    RunQueryRequest.Builder request = RunQueryRequest.newBuilder();
    request.setParent(LocalFirestoreHelper.DATABASE_NAME);
    StructuredQuery.Builder structuredQuery = request.getStructuredQueryBuilder();
    structuredQuery.addFrom(
        StructuredQuery.CollectionSelector.newBuilder().setCollectionId("coll"));

    for (StructuredQuery option : query) {
      structuredQuery.mergeFrom(option);
    }

    if (transactionId != null) {
      request.setTransaction(transactionId);
    }

    return request.build();
  }

  public static BatchGetDocumentsRequest get() {
    return get(null);
  }

  public static BatchGetDocumentsRequest get(@Nullable ByteString transactionId) {
    BatchGetDocumentsRequest.Builder request = BatchGetDocumentsRequest.newBuilder();
    request.setDatabase(DATABASE_NAME);
    request.addDocuments(DOCUMENT_NAME);

    if (transactionId != null) {
      request.setTransaction(transactionId);
    }

    return request.build();
  }

  public static StructuredQuery order(String fieldPath, StructuredQuery.Direction direction) {
    StructuredQuery.Builder structuredQuery = StructuredQuery.newBuilder();
    structuredQuery.addOrderByBuilder().setField(field(fieldPath)).setDirection(direction);
    return structuredQuery.build();
  }

  public static StructuredQuery select(String fieldPath) {
    StructuredQuery.Builder structuredQuery = StructuredQuery.newBuilder();
    structuredQuery.getSelectBuilder().addFields(field(fieldPath));
    return structuredQuery.build();
  }

  public static StructuredQuery select(FieldPath fieldPath) {
    StructuredQuery.Builder structuredQuery = StructuredQuery.newBuilder();
    structuredQuery.getSelectBuilder().addFields(field(fieldPath.getEncodedPath()));
    return structuredQuery.build();
  }

  public static StructuredQuery startAt(boolean before) {
    return startAt(string(), before);
  }

  public static StructuredQuery startAt(Value value, boolean before) {
    StructuredQuery.Builder structuredQuery = StructuredQuery.newBuilder();
    structuredQuery.setStartAt(Cursor.newBuilder().setBefore(before).addValues(value));
    return structuredQuery.build();
  }

  public static StructuredQuery endAt(boolean before) {
    return endAt(string(), before);
  }

  public static StructuredQuery endAt(Value value, boolean before) {
    StructuredQuery.Builder structuredQuery = StructuredQuery.newBuilder();
    structuredQuery.setEndAt(Cursor.newBuilder().setBefore(before).addValues(value));
    return structuredQuery.build();
  }

  public static StructuredQuery limit(int n) {
    StructuredQuery.Builder structuredQuery = StructuredQuery.newBuilder();
    structuredQuery.getLimitBuilder().setValue(n);
    return structuredQuery.build();
  }

  public static StructuredQuery offset(int n) {
    StructuredQuery.Builder structuredQuery = StructuredQuery.newBuilder();
    structuredQuery.setOffset(n);
    return structuredQuery.build();
  }

  public static Value string() {
    return string("bar");
  }

  public static Value string(String value) {
    return Value.newBuilder().setStringValue(value).build();
  }

  public static Value object(String key, Value value) {
    Value.Builder result = Value.newBuilder();
    result.getMapValueBuilder().putFields(key, value);
    return result.build();
  }

  public static StructuredQuery.FieldReference.Builder field(String fieldPath) {
    return StructuredQuery.FieldReference.newBuilder().setFieldPath(fieldPath);
  }

  public static void assertCommitEquals(CommitRequest expected, CommitRequest actual) {
    assertEquals(sortCommit(expected), sortCommit(actual));
  }

  private static CommitRequest sortCommit(CommitRequest commit) {
    CommitRequest.Builder builder = commit.toBuilder();

    for (Write.Builder writes : builder.getWritesBuilderList()) {
      if (writes.hasUpdateMask()) {
        ArrayList<String> updateMask = new ArrayList<>(writes.getUpdateMask().getFieldPathsList());
        Collections.sort(updateMask);
        writes.setUpdateMask(DocumentMask.newBuilder().addAllFieldPaths(updateMask));
      }

      if (writes.getTransform().getFieldTransformsCount() > 0) {
        ArrayList<FieldTransform> transformList =
            new ArrayList<>(writes.getTransform().getFieldTransformsList());
        Collections.sort(
            transformList,
            new Comparator<FieldTransform>() {
              @Override
              public int compare(FieldTransform t1, FieldTransform t2) {
                return t1.getFieldPath().compareTo(t2.getFieldPath());
              }
            });
        writes.setTransform(DocumentTransform.newBuilder().addAllFieldTransforms(transformList));
      }
    }

    return builder.build();
  }

  public static class AllSupportedTypes {

    public String foo = "bar";
    public Double doubleValue = 0.0;
    public long longValue = 0L;
    public double nanValue = Double.NaN;
    public double infValue = Double.POSITIVE_INFINITY;
    public double negInfValue = Double.NEGATIVE_INFINITY;
    public boolean trueValue = true;
    public boolean falseValue = false;
    public SingleField objectValue = new SingleField();
    public Date dateValue = DATE;
    public List<String> arrayValue = ImmutableList.of("foo");
    public String nullValue = null;
    public Blob bytesValue = BLOB;
    public GeoPoint geoPointValue = GEO_POINT;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      AllSupportedTypes that = (AllSupportedTypes) o;
      return longValue == that.longValue
          && Double.compare(that.nanValue, nanValue) == 0
          && Double.compare(that.infValue, infValue) == 0
          && Double.compare(that.negInfValue, negInfValue) == 0
          && trueValue == that.trueValue
          && falseValue == that.falseValue
          && Objects.equals(foo, that.foo)
          && Objects.equals(doubleValue, that.doubleValue)
          && Objects.equals(objectValue, that.objectValue)
          && Objects.equals(dateValue, that.dateValue)
          && Objects.equals(arrayValue, that.arrayValue)
          && Objects.equals(nullValue, that.nullValue)
          && Objects.equals(bytesValue, that.bytesValue)
          && Objects.equals(geoPointValue, that.geoPointValue);
    }
  }

  static {
    TRANSACTION_ID = ByteString.copyFrom("foo", Charset.defaultCharset());

    try {
      DATE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S z").parse("1985-03-18 08:20:00.123 CET");
    } catch (ParseException e) {
      throw new RuntimeException("Failed to parse date", e);
    }

    GEO_POINT = new GeoPoint(50.1430847, -122.9477780);
    BLOB = Blob.fromBytes(new byte[] {1, 2, 3});

    DATABASE_NAME = "projects/test-project/databases/(default)";
    DOCUMENT_PATH = "coll/doc";
    DOCUMENT_NAME = DATABASE_NAME + "/documents/" + DOCUMENT_PATH;

    EMPTY_MAP_PROTO =
        map("inner", Value.newBuilder().setMapValue(MapValue.getDefaultInstance()).build());

    SINGLE_FIELD_MAP = map("foo", (Object) "bar");
    SINGLE_FIELD_OBJECT = new SingleField();
    SINGLE_FIELD_PROTO = map("foo", Value.newBuilder().setStringValue("bar").build());
    SINGLE_FIELD_SNAPSHOT =
        new DocumentSnapshot(
            null,
            new DocumentReference(
                null,
                ResourcePath.create(DatabaseRootName.of("", ""), ImmutableList.of("coll", "doc"))),
            SINGLE_FIELD_PROTO,
            Instant.ofEpochSecond(5, 6),
            Instant.ofEpochSecond(3, 4),
            Instant.ofEpochSecond(1, 2));

    UPDATED_FIELD_MAP = map("foo", (Object) "foobar");
    UPDATED_FIELD_PROTO = map("foo", Value.newBuilder().setStringValue("foobar").build());

    SERVER_TIMESTAMP_MAP = new HashMap<>();
    SERVER_TIMESTAMP_MAP.put("foo", FieldValue.serverTimestamp());
    SERVER_TIMESTAMP_MAP.put("inner", new HashMap<String, Object>());
    ((Map<String, Object>) SERVER_TIMESTAMP_MAP.get("inner"))
        .put("bar", FieldValue.serverTimestamp());

    Value.Builder mapValue = Value.newBuilder();
    mapValue.getMapValueBuilder();
    SERVER_TIMESTAMP_PROTO = Collections.emptyMap();
    SERVER_TIMESTAMP_OBJECT = new ServerTimestamp();
    SERVER_TIMESTAMP_TRANSFORM = transform("foo", "inner.bar");

    ALL_SUPPORTED_TYPES_MAP = new HashMap<>();
    ALL_SUPPORTED_TYPES_MAP.put("foo", "bar");
    ALL_SUPPORTED_TYPES_MAP.put("doubleValue", 0.0);
    ALL_SUPPORTED_TYPES_MAP.put("longValue", 0L);
    ALL_SUPPORTED_TYPES_MAP.put("nanValue", Double.NaN);
    ALL_SUPPORTED_TYPES_MAP.put("infValue", Double.POSITIVE_INFINITY);
    ALL_SUPPORTED_TYPES_MAP.put("negInfValue", Double.NEGATIVE_INFINITY);
    ALL_SUPPORTED_TYPES_MAP.put("trueValue", true);
    ALL_SUPPORTED_TYPES_MAP.put("falseValue", false);
    ALL_SUPPORTED_TYPES_MAP.put("objectValue", map("foo", (Object) "bar"));
    ALL_SUPPORTED_TYPES_MAP.put("dateValue", DATE);
    ALL_SUPPORTED_TYPES_MAP.put("arrayValue", ImmutableList.of("foo"));
    ALL_SUPPORTED_TYPES_MAP.put("nullValue", null);
    ALL_SUPPORTED_TYPES_MAP.put("bytesValue", BLOB);
    ALL_SUPPORTED_TYPES_MAP.put("geoPointValue", GEO_POINT);

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
                    .setMapValue(MapValue.newBuilder().putAllFields(SINGLE_FIELD_PROTO))
                    .build())
            .put(
                "dateValue",
                Value.newBuilder()
                    .setTimestampValue(
                        Timestamp.newBuilder().setSeconds(479978400).setNanos(123000000))
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
            .build();
    ALL_SUPPORTED_TYPES_OBJECT = new AllSupportedTypes();

    SINGLE_WRITE_COMMIT_RESPONSE = commitResponse(/* adds= */ 1, /* deletes= */ 0);
    SINGLE_DELETE_COMMIT_RESPONSE = commitResponse(/* adds= */ 0, /* deletes= */ 1);
    SINGLE_CREATE_COMMIT_REQUEST = commit(create(SINGLE_FIELD_PROTO));

    SERVER_TIMESTAMP_COMMIT_RESPONSE = commitResponse(/* adds= */ 2, /* deletes= */ 0);

    NESTED_CLASS_OBJECT = new NestedClass();

    CREATE_PRECONDITION = Precondition.newBuilder().setExists(false).build();

    UPDATE_PRECONDITION = Precondition.newBuilder().setExists(true).build();
  }

  public static String autoId() {
    return FirestoreImpl.autoId();
  }
}
