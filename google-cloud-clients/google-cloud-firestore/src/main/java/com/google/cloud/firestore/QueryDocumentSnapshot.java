/*
 * Copyright 2018 Google LLC
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
import com.google.common.base.Preconditions;
import com.google.firestore.v1beta1.Document;
import com.google.firestore.v1beta1.Value;
import java.util.Map;
import javax.annotation.Nonnull;

/**
 * A QueryDocumentSnapshot contains data read from a document in a Firestore database as part of a
 * query. The document is guaranteed to exist and its data can be extracted using the {@link
 * #getData()} or {@link #get(String)} methods.
 *
 * <p>QueryDocumentSnapshot offers the same API surface as {@link DocumentSnapshot}. Since query
 * results contain only existing documents, the {@link #exists()} method will always return true and
 * {@code getData()} will never be null.
 *
 * <p><b>Subclassing Note</b>: Firestore classes are not meant to be subclassed except for use in
 * test mocks. Subclassing is not supported in production code and new SDK releases may break code
 * that does so.
 */
public class QueryDocumentSnapshot extends DocumentSnapshot {
  private QueryDocumentSnapshot(
      FirestoreImpl firestore,
      DocumentReference docRef,
      Map<String, Value> fields,
      Timestamp readTime,
      Timestamp updateTime,
      Timestamp createTime) {
    super(firestore, docRef, fields, readTime, updateTime, createTime);
  }

  static QueryDocumentSnapshot fromDocument(
      FirestoreImpl firestore, Timestamp readTime, Document document) {
    return new QueryDocumentSnapshot(
        firestore,
        new DocumentReference(firestore, ResourcePath.create(document.getName())),
        document.getFieldsMap(),
        readTime,
        Timestamp.fromProto(document.getUpdateTime()),
        Timestamp.fromProto(document.getCreateTime()));
  }

  /**
   * Returns the fields of the document as a Map. Field values will be converted to their native
   * Java representation.
   *
   * @return The fields of the document as a Map.
   */
  @Nonnull
  @Override
  public Map<String, Object> getData() {
    Map<String, Object> result = super.getData();
    Preconditions.checkNotNull(result, "Data in a QueryDocumentSnapshot should be non-null");
    return result;
  }

  /**
   * Returns the contents of the document converted to a POJO.
   *
   * @param valueType The Java class to create
   * @return The contents of the document in an object of type T
   */
  @Nonnull
  @Override
  public <T> T toObject(@Nonnull Class<T> valueType) {
    T result = super.toObject(valueType);
    Preconditions.checkNotNull(result, "Object in a QueryDocumentSnapshot should be non-null");
    return result;
  }
}
