package com.google.cloud.firestore;

import com.google.common.base.Preconditions;
import com.google.firestore.v1beta1.Document;
import com.google.firestore.v1beta1.Value;
import com.google.protobuf.Timestamp;
import java.util.Map;
import javax.annotation.Nonnull;
import org.threeten.bp.Instant;

/**
 * A QueryDocumentSnapshot contains data read from a document in your Firestore database as part of
 * a query. The document is guaranteed to exist and its data can be extracted using the getData() or
 * get() methods.
 *
 * <p>QueryDocumentSnapshot offers the same API surface as {@link DocumentSnapshot}. Since query
 * results contain only existing documents, the exists() method will always return true and
 * getData() will never be null.
 */
public final class QueryDocumentSnapshot extends DocumentSnapshot {
  private QueryDocumentSnapshot(
      FirestoreImpl firestore,
      DocumentReference docRef,
      Map<String, Value> fields,
      Instant readTime,
      Instant updateTime,
      Instant createTime) {
    super(firestore, docRef, fields, readTime, updateTime, createTime);
  }

  static QueryDocumentSnapshot fromDocument(
      FirestoreImpl firestore, Timestamp readTime, Document document) {
    Timestamp updateTime = document.getUpdateTime();
    Timestamp createTime = document.getCreateTime();
    return new QueryDocumentSnapshot(
        firestore,
        new DocumentReference(firestore, ResourcePath.create(document.getName())),
        document.getFieldsMap(),
        Instant.ofEpochSecond(readTime.getSeconds(), readTime.getNanos()),
        Instant.ofEpochSecond(updateTime.getSeconds(), updateTime.getNanos()),
        Instant.ofEpochSecond(createTime.getSeconds(), createTime.getNanos()));
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
    return super.getData();
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
