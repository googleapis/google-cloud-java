/*
 * Copyright 2019 Google LLC
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
