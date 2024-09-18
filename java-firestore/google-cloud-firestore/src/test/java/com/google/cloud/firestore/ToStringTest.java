/*
 * Copyright 2023 Google LLC
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

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.firestore.v1.Value;
import java.util.Collections;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/** @author Eran Leshem */
@RunWith(MockitoJUnitRunner.class)
public class ToStringTest {

  @Spy
  private final FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("test-project").build(),
          Mockito.mock(FirestoreRpc.class));

  private WriteBatch batch;
  private DocumentReference documentReference;

  @Before
  public void before() {
    batch = firestoreMock.batch();
    documentReference = firestoreMock.document("coll/doc");
  }

  @Test
  public void testDocumentSnapshot() {
    Map<String, Value> fields =
        Collections.singletonMap(
            "key123",
            UserDataConverter.encodeValue(
                FieldPath.of("key456"),
                CustomClassMapper.convertToPlainJavaTypes("value789"),
                UserDataConverter.NO_DELETES));
    String toStringResult =
        new DocumentSnapshot(
                null,
                documentReference,
                fields,
                Timestamp.ofTimeMicroseconds(1),
                Timestamp.ofTimeMicroseconds(2),
                Timestamp.ofTimeMicroseconds(3))
            .toString();
    assertThat(toStringResult).startsWith("DocumentSnapshot{");
    assertThat(toStringResult).containsMatch("doc=DocumentReference\\{path=.*/documents/coll/doc}");
    assertThat(toStringResult).containsMatch("(?s)fields=\\{key123=string_value:.*value789.*}");
    assertThat(toStringResult).contains("readTime=1970-01-01T00:00:00.000001000Z");
    assertThat(toStringResult).contains("updateTime=1970-01-01T00:00:00.000002000Z");
    assertThat(toStringResult).contains("createTime=1970-01-01T00:00:00.000003000Z");
    assertThat(toStringResult).endsWith("}");
  }

  @Test
  public void testWriteOperation() {
    String toStringResult =
        new UpdateBuilder.WriteOperation(
                documentReference,
                DocumentSnapshot.fromObject(
                        null,
                        documentReference,
                        Collections.singletonMap("key", "value"),
                        UserDataConverter.NO_DELETES)
                    .toPb()
                    .build())
            .toString();
    assertThat(toStringResult).startsWith("WriteOperation{");
    assertThat(toStringResult)
        .containsMatch("(?s)write=update\\s*\\{\\s*name:.*/documents/coll/doc.*}");
    assertThat(toStringResult).containsMatch("doc=DocumentReference\\{path=.*/documents/coll/doc}");
    assertThat(toStringResult).endsWith("}");
  }

  @Test
  public void testWriteBatch() {
    batch.update(documentReference, Collections.singletonMap("key", "value"));
    String toStringResult = batch.toString();
    assertThat(toStringResult).startsWith("WriteBatch{");
    assertThat(toStringResult)
        .containsMatch("(?s)writes=\\[WriteOperation\\{write=update.*/documents/coll/doc.*}]");
    assertThat(toStringResult).contains("committed=false");
    assertThat(toStringResult).endsWith("}");
  }
}
