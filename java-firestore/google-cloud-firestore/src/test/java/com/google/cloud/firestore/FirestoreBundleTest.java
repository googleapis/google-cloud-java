/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.firestore.LocalFirestoreHelper.COLLECTION_ID;
import static com.google.cloud.firestore.LocalFirestoreHelper.DOCUMENT_NAME;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_FIELD_SNAPSHOT;
import static com.google.cloud.firestore.LocalFirestoreHelper.UPDATED_SINGLE_FIELD_SNAPSHOT;
import static com.google.cloud.firestore.LocalFirestoreHelper.bundleToElementList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.common.collect.Lists;
import com.google.firestore.bundle.BundleElement;
import com.google.firestore.bundle.BundleMetadata;
import com.google.firestore.bundle.BundledDocumentMetadata;
import com.google.firestore.bundle.BundledQuery;
import com.google.firestore.bundle.BundledQuery.LimitType;
import com.google.firestore.bundle.NamedQuery;
import com.google.firestore.v1.Document;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.JsonFormat;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FirestoreBundleTest {
  private static final String TEST_BUNDLE_ID = "test-bundle";
  private static final int TEST_BUNDLE_VERSION = 1;
  private static final JsonFormat.Parser parser = JsonFormat.parser();

  @Spy
  private final FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("test-project").build(),
          Mockito.mock(FirestoreRpc.class));

  private Query query;

  @Before
  public void before() {
    query = firestoreMock.collection(COLLECTION_ID);
  }

  public static void verifyMetadata(
      BundleMetadata meta, Timestamp createTime, int totalDocuments, boolean expectEmptyContent) {
    if (!expectEmptyContent) {
      assertTrue(meta.getTotalBytes() > 0);
    } else {
      assertEquals(0, meta.getTotalBytes());
    }
    assertEquals(TEST_BUNDLE_ID, meta.getId());
    assertEquals(TEST_BUNDLE_VERSION, meta.getVersion());
    assertEquals(totalDocuments, meta.getTotalDocuments());
    assertEquals(createTime, meta.getCreateTime());
  }

  public static void verifyDocumentAndMeta(
      BundledDocumentMetadata documentMetadata,
      Document document,
      String expectedDocumentName,
      List<String> expectedQueries,
      DocumentSnapshot equivalentSnapshot) {
    verifyDocumentAndMeta(
        documentMetadata,
        document,
        expectedDocumentName,
        expectedQueries,
        equivalentSnapshot,
        equivalentSnapshot.getReadTime().toProto());
  }

  public static void verifyDocumentAndMeta(
      BundledDocumentMetadata documentMetadata,
      Document document,
      String expectedDocumentName,
      List<String> expectedQueries,
      DocumentSnapshot equivalentSnapshot,
      Timestamp readTime) {
    assertEquals(
        BundledDocumentMetadata.newBuilder()
            .setExists(true)
            .setName(expectedDocumentName)
            .setReadTime(readTime)
            .addAllQueries(expectedQueries)
            .build(),
        documentMetadata);
    assertEquals(
        Document.newBuilder()
            .putAllFields(equivalentSnapshot.getProtoFields())
            .setCreateTime(equivalentSnapshot.getCreateTime().toProto())
            .setUpdateTime(equivalentSnapshot.getUpdateTime().toProto())
            .setName(expectedDocumentName)
            .build(),
        document);
  }

  public static void verifyNamedQuery(
      NamedQuery namedQuery, String name, Timestamp readTime, Query query, LimitType limitType) {
    assertEquals(
        NamedQuery.newBuilder()
            .setName(name)
            .setReadTime(readTime)
            .setBundledQuery(
                BundledQuery.newBuilder()
                    .setParent(query.toProto().getParent())
                    .setStructuredQuery(query.toProto().getStructuredQuery())
                    .setLimitType(limitType)
                    .build())
            .build(),
        namedQuery);
  }

  @Test
  public void bundleToElementListWorks() {
    String bundleString =
        "20{\"a\":\"string value\"}9{\"b\":123}26{\"c\":{\"d\":\"nested value\"}}";
    List<String> elements =
        bundleToElementList(ByteBuffer.wrap(bundleString.getBytes(StandardCharsets.UTF_8)));
    assertArrayEquals(
        new String[] {
          "{\"a\":\"string value\"}", "{\"b\":123}", "{\"c\":{\"d\":\"nested value\"}}"
        },
        elements.toArray());
  }

  public static List<BundleElement> toBundleElements(ByteBuffer bundleBuffer) {
    ArrayList<BundleElement> result = new ArrayList<>();
    for (String s : bundleToElementList(bundleBuffer)) {
      BundleElement.Builder b = BundleElement.newBuilder();
      try {
        parser.merge(s, b);
      } catch (InvalidProtocolBufferException e) {
        throw new RuntimeException(e);
      }
      result.add(b.build());
    }

    return result;
  }

  @Test
  public void bundleWithDocumentSnapshots() {
    FirestoreBundle.Builder bundleBuilder = new FirestoreBundle.Builder(TEST_BUNDLE_ID);
    bundleBuilder.add(UPDATED_SINGLE_FIELD_SNAPSHOT);
    bundleBuilder.add(SINGLE_FIELD_SNAPSHOT);
    ByteBuffer bundleBuffer = bundleBuilder.build().toByteBuffer();

    // Expected bundle elements are [bundleMetadata, meta of UPDATED_SINGLE_FIELD_SNAPSHOT,
    // UPDATED_SINGLE_FIELD_SNAPSHOT]
    // because UPDATED_SINGLE_FIELD_SNAPSHOT is newer.
    List<BundleElement> elements = toBundleElements(bundleBuffer);
    assertEquals(3, elements.size());

    verifyMetadata(
        elements.get(0).getMetadata(),
        // Even this snapshot is not included, its read time is still used as create time
        // because it is the largest read time came across.
        UPDATED_SINGLE_FIELD_SNAPSHOT.getReadTime().toProto(),
        /*totalDocuments*/ 1,
        /*expectEmptyContent*/ false);

    verifyDocumentAndMeta(
        elements.get(1).getDocumentMetadata(),
        elements.get(2).getDocument(),
        DOCUMENT_NAME,
        Lists.newArrayList(),
        UPDATED_SINGLE_FIELD_SNAPSHOT);
  }

  @Test
  public void bundleWithQuerySnapshot() {
    FirestoreBundle.Builder bundleBuilder = new FirestoreBundle.Builder(TEST_BUNDLE_ID);
    QuerySnapshot snapshot =
        QuerySnapshot.withDocuments(
            query,
            SINGLE_FIELD_SNAPSHOT.getReadTime(),
            Lists.newArrayList(
                QueryDocumentSnapshot.fromDocument(
                    null,
                    SINGLE_FIELD_SNAPSHOT.getReadTime(),
                    SINGLE_FIELD_SNAPSHOT.toDocumentPb().build())));
    bundleBuilder.add("test-query", snapshot);
    ByteBuffer bundleBuffer = bundleBuilder.build().toByteBuffer();

    // Expected bundle elements are [bundleMetadata, named query, meta of SINGLE_FIELD_SNAPSHOT,
    // SINGLE_FIELD_SNAPSHOT]
    List<BundleElement> elements = toBundleElements(bundleBuffer);
    assertEquals(4, elements.size());

    verifyMetadata(
        elements.get(0).getMetadata(),
        SINGLE_FIELD_SNAPSHOT.getReadTime().toProto(),
        /*totalDocuments*/ 1,
        /*expectEmptyContent*/ false);

    verifyNamedQuery(
        elements.get(1).getNamedQuery(),
        "test-query",
        SINGLE_FIELD_SNAPSHOT.getReadTime().toProto(),
        query,
        LimitType.FIRST);

    verifyDocumentAndMeta(
        elements.get(2).getDocumentMetadata(),
        elements.get(3).getDocument(),
        DOCUMENT_NAME,
        Lists.newArrayList("test-query"),
        SINGLE_FIELD_SNAPSHOT);
  }

  @Test
  public void bundleWithQueryReturningNoResult() {
    FirestoreBundle.Builder bundleBuilder = new FirestoreBundle.Builder(TEST_BUNDLE_ID);
    QuerySnapshot snapshot =
        QuerySnapshot.withDocuments(
            query, SINGLE_FIELD_SNAPSHOT.getReadTime(), Collections.emptyList());
    bundleBuilder.add("test-query", snapshot);
    ByteBuffer bundleBuffer = bundleBuilder.build().toByteBuffer();

    // Expected bundle elements are [bundleMetadata, named query]
    List<BundleElement> elements = toBundleElements(bundleBuffer);
    assertEquals(2, elements.size());

    verifyMetadata(
        elements.get(0).getMetadata(),
        SINGLE_FIELD_SNAPSHOT.getReadTime().toProto(),
        /*totalDocuments*/ 0,
        /*expectEmptyContent*/ false);

    verifyNamedQuery(
        elements.get(1).getNamedQuery(),
        "test-query",
        SINGLE_FIELD_SNAPSHOT.getReadTime().toProto(),
        query,
        LimitType.FIRST);
  }

  @Test
  public void bundleBuiltMultipleTimes() {
    FirestoreBundle.Builder bundleBuilder = new FirestoreBundle.Builder(TEST_BUNDLE_ID);
    bundleBuilder.add(SINGLE_FIELD_SNAPSHOT);
    ByteBuffer bundleBuffer = bundleBuilder.build().toByteBuffer();

    // Expected bundle elements are [bundleMetadata, meta of SINGLE_FIELD_SNAPSHOT,
    // SINGLE_FIELD_SNAPSHOT]
    List<BundleElement> elements = toBundleElements(bundleBuffer);
    assertEquals(3, elements.size());

    verifyMetadata(
        elements.get(0).getMetadata(),
        SINGLE_FIELD_SNAPSHOT.getReadTime().toProto(),
        /*totalDocuments*/ 1,
        /*expectEmptyContent*/ false);

    verifyDocumentAndMeta(
        elements.get(1).getDocumentMetadata(),
        elements.get(2).getDocument(),
        DOCUMENT_NAME,
        Lists.newArrayList(),
        SINGLE_FIELD_SNAPSHOT);

    bundleBuilder.add(UPDATED_SINGLE_FIELD_SNAPSHOT);
    bundleBuffer = bundleBuilder.build().toByteBuffer();

    // Expected bundle elements are [bundleMetadata, meta of UPDATED_SINGLE_FIELD_SNAPSHOT,
    // UPDATED_SINGLE_FIELD_SNAPSHOT]
    elements = toBundleElements(bundleBuffer);
    assertEquals(3, elements.size());
    verifyMetadata(
        elements.get(0).getMetadata(),
        UPDATED_SINGLE_FIELD_SNAPSHOT.getReadTime().toProto(),
        /*totalDocuments*/ 1,
        /*expectEmptyContent*/ false);
    verifyDocumentAndMeta(
        elements.get(1).getDocumentMetadata(),
        elements.get(2).getDocument(),
        DOCUMENT_NAME,
        Lists.newArrayList(),
        UPDATED_SINGLE_FIELD_SNAPSHOT);
  }

  @Test
  public void bundleWithNothingAdded() {
    FirestoreBundle.Builder bundleBuilder = new FirestoreBundle.Builder(TEST_BUNDLE_ID);
    ByteBuffer bundleBuffer = bundleBuilder.build().toByteBuffer();

    // Expected bundle elements are [bundleMetadata]
    List<BundleElement> elements = toBundleElements(bundleBuffer);
    assertEquals(1, elements.size());

    verifyMetadata(
        elements.get(0).getMetadata(),
        com.google.cloud.Timestamp.MIN_VALUE.toProto(),
        /*totalDocuments*/ 0,
        /*expectEmptyContent*/ true);
  }
}
