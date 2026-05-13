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

import com.google.cloud.Timestamp;
import com.google.common.collect.Lists;
import com.google.firestore.bundle.BundleElement;
import com.google.firestore.bundle.BundleMetadata;
import com.google.firestore.bundle.BundledDocumentMetadata;
import com.google.firestore.bundle.BundledQuery;
import com.google.firestore.bundle.NamedQuery;
import com.google.firestore.v1.Document;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Represents a Firestore data bundle with results from the given document and query snapshots. */
public final class FirestoreBundle {

  static final int BUNDLE_SCHEMA_VERSION = 1;
  // Printer to encode protobuf objects into JSON string.
  private static final JsonFormat.Printer PRINTER = JsonFormat.printer();
  private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

  // Raw byte array to hold the content of the bundle.
  private final byte[] bundleData;

  /** Builds a Firestore data bundle with results from the given document and query snapshots. */
  public static final class Builder {
    // Id of the bundle.
    private final String id;
    // Resulting documents for the bundle, keyed by full document path.
    private final Map<String, BundledDocument> documents = new HashMap<>();
    // Named queries saved in the bundle, keyed by query name.
    private final Map<String, NamedQuery> namedQueries = new HashMap<>();
    // The latest read time among all bundled documents and queries.
    private Timestamp latestReadTime = Timestamp.MIN_VALUE;

    Builder(String id) {
      this.id = id;
    }

    /** Returns the ID for this bundle. */
    public String getId() {
      return this.id;
    }

    /**
     * Adds a Firestore document snapshot to the bundle. Both the document data and the document
     * read time will be included in the bundle.
     *
     * @param documentSnapshot A document snapshot to add.
     * @return This instance.
     */
    public Builder add(DocumentSnapshot documentSnapshot) {
      return add(documentSnapshot, Optional.empty());
    }

    private Builder add(DocumentSnapshot documentSnapshot, Optional<String> queryName) {
      String documentName = documentSnapshot.getReference().getName();
      BundledDocument originalDocument = documents.get(documentSnapshot.getReference().getName());
      List<String> queries =
          originalDocument == null
              ? Lists.newArrayList()
              : Lists.newArrayList(originalDocument.getMetadata().getQueriesList());

      // Update with document built from `documentSnapshot` because it is newer.
      Timestamp snapReadTime =
          documentSnapshot.getReadTime() == null
              ? Timestamp.MIN_VALUE
              : documentSnapshot.getReadTime();
      if (originalDocument == null
          || originalDocument.getMetadata().getReadTime() == null
          || snapReadTime.compareTo(
                  Timestamp.fromProto(originalDocument.getMetadata().getReadTime()))
              > 0) {
        BundledDocumentMetadata metadata =
            BundledDocumentMetadata.newBuilder()
                .setName(documentName)
                .setReadTime(snapReadTime.toProto())
                .setExists(documentSnapshot.exists())
                .build();
        Document document =
            documentSnapshot.exists() ? documentSnapshot.toDocumentPb().build() : null;
        documents.put(documentName, new BundledDocument(metadata, document));
      }

      // Update queries to include all queries whose results include this document.
      if (queryName.isPresent()) {
        queries.add(queryName.get());
      }
      documents
          .get(documentName)
          .setMetadata(
              documents.get(documentName).getMetadata().toBuilder()
                  .clearQueries()
                  .addAllQueries(queries)
                  .build());

      if (documentSnapshot.getReadTime().compareTo(latestReadTime) > 0) {
        latestReadTime = documentSnapshot.getReadTime();
      }

      return this;
    }

    /**
     * Adds a Firestore query snapshot to the bundle. Both the documents in the query snapshot and
     * the query read time will be included in the bundle.
     *
     * @param queryName The name of the query to add.
     * @param querySnap The query snapshot to add.
     * @return This instance.
     */
    public Builder add(String queryName, QuerySnapshot querySnap) {
      BundledQuery query = querySnap.getQuery().toBundledQuery();
      NamedQuery namedQuery =
          NamedQuery.newBuilder()
              .setName(queryName)
              .setReadTime(querySnap.getReadTime().toProto())
              .setBundledQuery(query)
              .build();
      namedQueries.put(queryName, namedQuery);

      for (QueryDocumentSnapshot snapshot : querySnap.getDocuments()) {
        add(snapshot, Optional.of(queryName));
      }

      if (querySnap.getReadTime().compareTo(latestReadTime) > 0) {
        latestReadTime = querySnap.getReadTime();
      }

      return this;
    }

    public FirestoreBundle build() {
      StringBuilder buffer = new StringBuilder();

      for (NamedQuery namedQuery : namedQueries.values()) {
        buffer.append(
            elementToLengthPrefixedStringBuilder(
                BundleElement.newBuilder().setNamedQuery(namedQuery).build()));
      }

      for (BundledDocument bundledDocument : documents.values()) {
        buffer.append(
            elementToLengthPrefixedStringBuilder(
                BundleElement.newBuilder()
                    .setDocumentMetadata(bundledDocument.getMetadata())
                    .build()));
        if (bundledDocument.getDocument() != null) {
          buffer.append(
              elementToLengthPrefixedStringBuilder(
                  BundleElement.newBuilder().setDocument(bundledDocument.getDocument()).build()));
        }
      }

      BundleMetadata metadata =
          BundleMetadata.newBuilder()
              .setId(id)
              .setCreateTime(latestReadTime.toProto())
              .setVersion(BUNDLE_SCHEMA_VERSION)
              .setTotalDocuments(documents.size())
              .setTotalBytes(buffer.toString().getBytes(DEFAULT_CHARSET).length)
              .build();
      BundleElement element = BundleElement.newBuilder().setMetadata(metadata).build();
      buffer.insert(0, elementToLengthPrefixedStringBuilder(element));

      return new FirestoreBundle(buffer.toString().getBytes(DEFAULT_CHARSET));
    }

    private StringBuilder elementToLengthPrefixedStringBuilder(BundleElement element) {
      String elementJson = null;
      try {
        elementJson = PRINTER.print(element);
      } catch (InvalidProtocolBufferException e) {
        throw new RuntimeException(e);
      }
      return new StringBuilder()
          .append(elementJson.getBytes(DEFAULT_CHARSET).length)
          .append(elementJson);
    }
  }

  private FirestoreBundle(byte[] data) {
    bundleData = data;
  }

  /** Returns the bundle content as a readonly {@link ByteBuffer}. */
  public ByteBuffer toByteBuffer() {
    return ByteBuffer.wrap(bundleData).asReadOnlyBuffer();
  }

  /**
   * Convenient class to hold both the metadata and the actual content of a document to be bundled.
   */
  private static class BundledDocument {
    private BundledDocumentMetadata metadata;
    private final Document document;

    BundledDocument(BundledDocumentMetadata metadata, Document document) {
      this.metadata = metadata;
      this.document = document;
    }

    public BundledDocumentMetadata getMetadata() {
      return metadata;
    }

    void setMetadata(BundledDocumentMetadata metadata) {
      this.metadata = metadata;
    }

    public Document getDocument() {
      return document;
    }
  }
}
