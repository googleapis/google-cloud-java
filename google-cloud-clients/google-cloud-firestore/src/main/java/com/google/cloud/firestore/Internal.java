package com.google.cloud.firestore;

import static com.google.cloud.firestore.UserDataConverter.NO_DELETES;

import com.google.api.core.InternalApi;
import com.google.cloud.Timestamp;
import com.google.common.base.Preconditions;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.Value;
import java.util.Map;

@InternalApi
public class Internal {
  private FirestoreImpl firestore;

  @InternalApi
  public Internal(FirestoreImpl firestore) {
    this.firestore = firestore;
  }

  @InternalApi
  public DocumentSnapshot snapshotFromObject(String documentPath, Object pojo) {
    DocumentReference documentReference = firestore.document(documentPath);
    Object data = CustomClassMapper.convertToPlainJavaTypes(pojo);
    Preconditions.checkArgument(
        data instanceof Map, "Can't create a document from an array or primitive");
    return DocumentSnapshot.fromObject(
        firestore, documentReference, (Map<String, Object>) data, NO_DELETES);
  }

  @InternalApi
  public DocumentSnapshot snapshotFromMap(String documentPath, Map<String, Object> data) {
    DocumentReference documentReference = firestore.document(documentPath);
    return DocumentSnapshot.fromObject(firestore, documentReference, data, NO_DELETES);
  }

  @InternalApi
  public DocumentSnapshot snapshotFromProto(Timestamp readTime, Document document) {
    return DocumentSnapshot.fromDocument(firestore, readTime, document);
  }

  @InternalApi
  public Map<String, Value> protoFromSnapshot(DocumentSnapshot snapshot) {
    return snapshot.getProtoFields();
  }
}
