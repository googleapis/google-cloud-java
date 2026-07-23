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

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.datastore.models.ExplainOptions;
import com.google.datastore.v1.RequestOptions;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

public class DatastoreExecutionOptionsTest {

  @Test
  public void testBuilderDefaults() {
    DatastoreExecutionOptions option = DatastoreExecutionOptions.newBuilder().build();

    assertThat(option.getExplainOptions()).isNull();
    assertThat(option.getRequestOptions()).isNull();
    assertThat(option.getReadOptions()).isEmpty();
  }

  @Test
  public void testGetDefaultInstance() {
    DatastoreExecutionOptions defaultOptions = DatastoreExecutionOptions.getDefaultInstance();

    assertThat(defaultOptions.getExplainOptions()).isNull();
    assertThat(defaultOptions.getRequestOptions()).isNull();
    assertThat(defaultOptions.getReadOptions()).isEmpty();
  }

  @Test
  public void testBuilderFull() {
    ExplainOptions explainOptions = ExplainOptions.newBuilder().setAnalyze(true).build();
    RequestOptions requestOptions = RequestOptions.newBuilder().addRequestTags("tag1").build();
    ReadOption readOption = ReadOption.eventualConsistency();

    DatastoreExecutionOptions option =
        DatastoreExecutionOptions.newBuilder()
            .setExplainOptions(explainOptions)
            .setRequestOptions(requestOptions)
            .setReadOptions(ImmutableList.of(readOption))
            .build();

    assertThat(option.getExplainOptions()).isEqualTo(explainOptions);
    assertThat(option.getRequestOptions()).isEqualTo(requestOptions);
    assertThat(option.getReadOptions()).containsExactly(readOption);
  }

  @Test
  public void testToBuilder() {
    ExplainOptions explainOptions = ExplainOptions.newBuilder().setAnalyze(true).build();
    RequestOptions requestOptions = RequestOptions.newBuilder().addRequestTags("tag1").build();
    ReadOption readOption = ReadOption.eventualConsistency();

    DatastoreExecutionOptions original =
        DatastoreExecutionOptions.newBuilder()
            .setExplainOptions(explainOptions)
            .setRequestOptions(requestOptions)
            .build();

    DatastoreExecutionOptions copy =
        original.toBuilder().setReadOptions(ImmutableList.of(readOption)).build();

    assertThat(copy.getExplainOptions()).isEqualTo(explainOptions);
    assertThat(copy.getRequestOptions()).isEqualTo(requestOptions);
    assertThat(copy.getReadOptions()).containsExactly(readOption);
  }

  @Test
  public void testEqualsAndHashCode() {
    RequestOptions reqOpts = RequestOptions.newBuilder().addRequestTags("tag1").build();
    ExplainOptions expOpts = ExplainOptions.newBuilder().setAnalyze(true).build();

    DatastoreExecutionOptions opt1 =
        DatastoreExecutionOptions.newBuilder()
            .setExplainOptions(expOpts)
            .setRequestOptions(reqOpts)
            .build();
    DatastoreExecutionOptions opt2 =
        DatastoreExecutionOptions.newBuilder()
            .setExplainOptions(expOpts)
            .setRequestOptions(reqOpts)
            .build();

    assertThat(opt1).isEqualTo(opt2);
    assertThat(opt1.hashCode()).isEqualTo(opt2.hashCode());
  }

  @Test
  public void testCreateRequestOptionsWithDatastoreExecutionOptions() {
    DatastoreOptions datastoreOptions =
        DatastoreOptions.newBuilder().setRequestTags(ImmutableList.of("instance-tag")).build();
    RequestOptions reqOpts = RequestOptions.newBuilder().addRequestTags("request-tag").build();
    DatastoreExecutionOptions execOptions =
        DatastoreExecutionOptions.newBuilder().setRequestOptions(reqOpts).build();

    RequestOptions merged =
        RequestOptionsHelper.createRequestOptions(datastoreOptions, execOptions);

    assertThat(merged.getRequestTagsList()).containsExactly("request-tag", "instance-tag");
  }
}
