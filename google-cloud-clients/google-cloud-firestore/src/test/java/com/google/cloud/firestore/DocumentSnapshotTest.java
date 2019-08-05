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

import static com.google.cloud.firestore.LocalFirestoreHelper.DOCUMENT_NAME;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_FIELD_OBJECT;
import static com.google.cloud.firestore.LocalFirestoreHelper.SingleField;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.google.cloud.Timestamp;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DocumentSnapshotTest {

  @Test
  public void fronDocument() {
    Document document = Document.newBuilder().setName(DOCUMENT_NAME).build();
    com.google.protobuf.Timestamp timestamp = com.google.protobuf.Timestamp.getDefaultInstance();
    BatchGetDocumentsResponse response =
        BatchGetDocumentsResponse.newBuilder().setReadTime(timestamp).build();
    DocumentSnapshot documentSnapshot =
        DocumentSnapshot.fromDocument(document, Timestamp.fromProto(response.getReadTime()));
    assertEquals(SINGLE_FIELD_OBJECT, documentSnapshot.toObject(SingleField.class));
    assertEquals("doc", documentSnapshot.getId());
    assertNotEquals("doc1", documentSnapshot.getId());
  }
}
