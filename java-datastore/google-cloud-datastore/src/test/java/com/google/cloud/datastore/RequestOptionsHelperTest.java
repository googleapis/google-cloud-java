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

package com.google.cloud.datastore;

import static com.google.cloud.datastore.RequestOptionsHelper.createRequestOptions;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.common.collect.ImmutableList;
import com.google.datastore.v1.RequestOptions;
import org.junit.Test;

public class RequestOptionsHelperTest {

  @Test
  public void testCreateRequestOptions_withNullExecutionOptions_throwsException() {
    DatastoreOptions datastoreOptions =
        DatastoreOptions.newBuilder().setProjectId("test-project").build();

    assertThrows(
        NullPointerException.class,
        () -> createRequestOptions(datastoreOptions, (DatastoreExecutionOptions) null));
  }

  @Test
  public void testCreateRequestOptions_withExecutionOptions() {
    DatastoreOptions datastoreOptions =
        DatastoreOptions.newBuilder()
            .setProjectId("test-project")
            .setRequestTags(ImmutableList.of("global-tag-1", "global-tag-2"))
            .build();
    com.google.cloud.datastore.models.RequestOptions requestOptions =
        com.google.cloud.datastore.models.RequestOptions.newBuilder()
            .setRequestTags(ImmutableList.of("local-tag"))
            .build();
    DatastoreExecutionOptions executionOptions =
        DatastoreExecutionOptions.newBuilder().setRequestOptions(requestOptions).build();

    RequestOptions merged = createRequestOptions(datastoreOptions, executionOptions);

    assertThat(merged.getRequestTagsList())
        .containsExactly("local-tag", "global-tag-1", "global-tag-2")
        .inOrder();
  }

  @Test
  public void testCreateRequestOptions_withNullRequestOptions() {
    DatastoreOptions datastoreOptions =
        DatastoreOptions.newBuilder()
            .setProjectId("test-project")
            .setRequestTags(ImmutableList.of("global-tag"))
            .build();

    RequestOptions merged = createRequestOptions(datastoreOptions, (RequestOptions) null);

    assertThat(merged.getRequestTagsList()).containsExactly("global-tag");
  }

  @Test
  public void testCreateRequestOptions_withRequestOptions() {
    DatastoreOptions datastoreOptions =
        DatastoreOptions.newBuilder()
            .setProjectId("test-project")
            .setRequestTags(ImmutableList.of("instance-tag"))
            .build();
    RequestOptions inputOptions =
        RequestOptions.newBuilder().addRequestTags("req-tag-1").addRequestTags("req-tag-2").build();

    RequestOptions merged = createRequestOptions(datastoreOptions, inputOptions);

    assertThat(merged.getRequestTagsList())
        .containsExactly("req-tag-1", "req-tag-2", "instance-tag")
        .inOrder();
  }
}
