/*
 * Copyright 2026 Google LLC
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
import static org.junit.Assert.assertTrue;

import com.google.cloud.firestore.models.RequestOptions;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RequestOptionsHelperTest {

  @Test
  public void testCreateRequestOptionsWithNulls() {
    com.google.firestore.v1.RequestOptions proto =
        RequestOptionsHelper.createRequestOptions(
            (FirestoreOptions) null, (FirestoreExecutionOptions) null);
    assertTrue(proto.getRequestTagsList().isEmpty());
  }

  @Test
  public void testCreateRequestOptionsWithClientTagsOnly() {
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId("test-project")
            .setRequestTags(Arrays.asList("client-tag1", "client-tag2"))
            .build();
    com.google.firestore.v1.RequestOptions proto =
        RequestOptionsHelper.createRequestOptions(options, (FirestoreExecutionOptions) null);
    assertEquals(Arrays.asList("client-tag1", "client-tag2"), proto.getRequestTagsList());
  }

  @Test
  public void testCreateRequestOptionsWithExecutionTagsOnly() {
    FirestoreExecutionOptions executionOptions =
        FirestoreExecutionOptions.options()
            .withRequestOptions(
                RequestOptions.newBuilder().addTag("req-tag1").addTag("req-tag2").build())
            .build();
    com.google.firestore.v1.RequestOptions proto =
        RequestOptionsHelper.createRequestOptions((FirestoreOptions) null, executionOptions);
    assertEquals(Arrays.asList("req-tag1", "req-tag2"), proto.getRequestTagsList());
  }

  @Test
  public void testCreateRequestOptionsMergedTags() {
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId("test-project")
            .setRequestTags(Arrays.asList("client-tag1", "client-tag2"))
            .build();
    FirestoreExecutionOptions executionOptions =
        FirestoreExecutionOptions.options()
            .withRequestOptions(
                RequestOptions.newBuilder().addTag("req-tag1").addTag("req-tag2").build())
            .build();
    com.google.firestore.v1.RequestOptions proto =
        RequestOptionsHelper.createRequestOptions(options, executionOptions);
    assertEquals(
        Arrays.asList("req-tag1", "req-tag2", "client-tag1", "client-tag2"),
        proto.getRequestTagsList());
  }
}
