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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.firestore.models.RequestOptions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FirestoreExecutionOptionsTest {

  @Test
  public void testDefaultInstance() {
    FirestoreExecutionOptions options = FirestoreExecutionOptions.getDefaultInstance();
    assertNotNull(options);
    assertNull(options.getExplainOptions());
    assertEquals(RequestOptions.getDefaultInstance(), options.getRequestOptions());
  }

  @Test
  public void testWithOptions() {
    ExplainOptions explainOptions = ExplainOptions.builder().setAnalyze(true).build();
    RequestOptions requestOptions = RequestOptions.newBuilder().addTag("tag1").build();

    FirestoreExecutionOptions options =
        FirestoreExecutionOptions.options()
            .withExplainOptions(explainOptions)
            .withRequestOptions(requestOptions)
            .build();

    assertEquals(explainOptions, options.getExplainOptions());
    assertEquals(requestOptions, options.getRequestOptions());
  }

  @Test
  public void testEqualsAndHashCode() {
    ExplainOptions explainOptions = ExplainOptions.builder().setAnalyze(true).build();
    RequestOptions requestOptions = RequestOptions.newBuilder().addTag("tag1").build();

    FirestoreExecutionOptions options1 =
        FirestoreExecutionOptions.options()
            .withExplainOptions(explainOptions)
            .withRequestOptions(requestOptions)
            .build();
    FirestoreExecutionOptions options2 =
        FirestoreExecutionOptions.options()
            .withExplainOptions(explainOptions)
            .withRequestOptions(requestOptions)
            .build();
    FirestoreExecutionOptions options3 =
        FirestoreExecutionOptions.options().withRequestOptions(requestOptions).build();

    assertEquals(options1, options2);
    assertEquals(options1.hashCode(), options2.hashCode());
    assertNotEquals(options1, options3);
  }

  @Test
  public void testToString() {
    RequestOptions requestOptions = RequestOptions.newBuilder().addTag("tag1").build();
    FirestoreExecutionOptions options =
        FirestoreExecutionOptions.options().withRequestOptions(requestOptions).build();
    assertTrue(options.toString().contains("tag1"));
  }
}
