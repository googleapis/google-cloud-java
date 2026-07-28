/*
 * Copyright 2022 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;

import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import org.junit.Test;

public class FirestoreOptionsTest {

  @Test
  public void instantiateWithProjectId() {
    FirestoreOptions firestoreOptions =
        FirestoreOptions.newBuilder().setProjectId("test-project").build();
    FirestoreImpl firestore = new FirestoreImpl(firestoreOptions, mock(FirestoreRpc.class));

    DocumentReference document = firestore.document("coll/doc1");
    assertThat(document.getName())
        .isEqualTo("projects/test-project/databases/(default)/documents/coll/doc1");
  }

  @Test
  public void instantiateWithProjectIdAndDatabaseId() {
    FirestoreOptions firestoreOptions =
        FirestoreOptions.newBuilder()
            .setProjectId("test-project")
            .setDatabaseId("test-database")
            .build();
    FirestoreImpl firestore = new FirestoreImpl(firestoreOptions, mock(FirestoreRpc.class));

    DocumentReference document = firestore.document("coll/doc1");
    assertThat(document.getName())
        .isEqualTo("projects/test-project/databases/test-database/documents/coll/doc1");
  }
}
