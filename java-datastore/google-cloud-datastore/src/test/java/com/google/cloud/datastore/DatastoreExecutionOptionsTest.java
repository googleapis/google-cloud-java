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
  public void testFactoryMethods() {
    RequestOptions requestOptions = RequestOptions.newBuilder().addRequestTags("tag1").build();
    ExplainOptions explainOptions = ExplainOptions.newBuilder().setAnalyze(true).build();
    ReadOption readOption = ReadOption.eventualConsistency();

    DatastoreExecutionOptions opt1 = DatastoreExecutionOptions.of(requestOptions);
    assertThat(opt1.getRequestOptions()).isEqualTo(requestOptions);

    DatastoreExecutionOptions opt2 = DatastoreExecutionOptions.of(explainOptions);
    assertThat(opt2.getExplainOptions()).isEqualTo(explainOptions);

    DatastoreExecutionOptions opt3 = DatastoreExecutionOptions.of(ImmutableList.of(readOption));
    assertThat(opt3.getReadOptions()).containsExactly(readOption);

    DatastoreExecutionOptions opt4 =
        DatastoreExecutionOptions.of(requestOptions, ImmutableList.of(readOption));
    assertThat(opt4.getRequestOptions()).isEqualTo(requestOptions);
    assertThat(opt4.getReadOptions()).containsExactly(readOption);

    DatastoreExecutionOptions opt5 =
        DatastoreExecutionOptions.of(explainOptions, requestOptions, ImmutableList.of(readOption));
    assertThat(opt5.getExplainOptions()).isEqualTo(explainOptions);
    assertThat(opt5.getRequestOptions()).isEqualTo(requestOptions);
    assertThat(opt5.getReadOptions()).containsExactly(readOption);
  }

  @Test
  public void testEqualsAndHashCode() {
    RequestOptions reqOpts = RequestOptions.newBuilder().addRequestTags("tag1").build();
    ExplainOptions expOpts = ExplainOptions.newBuilder().setAnalyze(true).build();

    DatastoreExecutionOptions opt1 = DatastoreExecutionOptions.of(expOpts, reqOpts);
    DatastoreExecutionOptions opt2 = DatastoreExecutionOptions.of(expOpts, reqOpts);

    assertThat(opt1).isEqualTo(opt2);
    assertThat(opt1.hashCode()).isEqualTo(opt2.hashCode());
  }

  @Test
  public void testCreateRequestOptionsWithDatastoreExecutionOptions() {
    DatastoreOptions datastoreOptions =
        DatastoreOptions.newBuilder().setRequestTags("instance-tag").build();
    RequestOptions reqOpts = RequestOptions.newBuilder().addRequestTags("request-tag").build();
    DatastoreExecutionOptions execOptions = DatastoreExecutionOptions.of(reqOpts);

    RequestOptions merged =
        RequestOptionsHelper.createRequestOptions(datastoreOptions, execOptions);

    assertThat(merged.getRequestTagsList()).containsExactly("request-tag", "instance-tag");
  }
}
