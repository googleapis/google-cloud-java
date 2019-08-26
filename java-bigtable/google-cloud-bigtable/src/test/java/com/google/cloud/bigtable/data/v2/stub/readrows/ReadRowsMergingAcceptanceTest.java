/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub.readrows;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.ReadRowsResponse.CellChunk;
import com.google.cloud.bigtable.data.v2.models.DefaultRowAdapter;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi.ServerStreamingStashCallable;
import com.google.cloud.conformance.bigtable.v2.TestDefinition.ReadRowsTest;
import com.google.cloud.conformance.bigtable.v2.TestDefinition.TestFile;
import com.google.common.base.CaseFormat;
import com.google.common.collect.Lists;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/** Parses and runs the acceptance tests for read rows */
@RunWith(Parameterized.class)
public class ReadRowsMergingAcceptanceTest {
  private static final String TEST_DATA_JSON_RESOURCE =
      "com/google/cloud/conformance/bigtable/v2/readrows.json";

  private final ReadRowsTest testCase;

  /**
   * @param testData The serialized test data representing the test case.
   * @param junitName Not used by the test, but used by the parameterized test runner as the name of
   *     the test.
   */
  public ReadRowsMergingAcceptanceTest(
      ReadRowsTest testData, @SuppressWarnings("unused") String junitName) {
    this.testCase = testData;
  }

  // Each tuple consists of [testData: ReadRowsTest, junitName: String]
  @Parameters(name = "{1}")
  public static Collection<Object[]> data() throws IOException {
    ClassLoader cl = Thread.currentThread().getContextClassLoader();
    InputStream dataJson = cl.getResourceAsStream(TEST_DATA_JSON_RESOURCE);
    assertWithMessage("Unable to load test definition: %s", TEST_DATA_JSON_RESOURCE)
        .that(dataJson)
        .isNotNull();

    InputStreamReader reader = new InputStreamReader(dataJson);
    TestFile.Builder testBuilder = TestFile.newBuilder();
    JsonFormat.parser().merge(reader, testBuilder);
    TestFile testDefinition = testBuilder.build();

    List<ReadRowsTest> tests = testDefinition.getReadRowsTestsList();
    ArrayList<Object[]> data = new ArrayList<>(tests.size());
    for (ReadRowsTest test : tests) {
      String junitName =
          CaseFormat.LOWER_HYPHEN.to(
              CaseFormat.LOWER_CAMEL, test.getDescription().replace(" ", "-"));
      data.add(new Object[] {test, junitName});
    }
    return data;
  }

  @Test
  public void test() throws Exception {
    List<ReadRowsResponse> responses = Lists.newArrayList();

    // Convert the chunks into a single ReadRowsResponse
    for (CellChunk chunk : testCase.getChunksList()) {
      ReadRowsResponse.Builder responseBuilder = ReadRowsResponse.newBuilder();
      responseBuilder.addChunks(chunk);
      responses.add(responseBuilder.build());
    }

    // Wrap the responses in a callable
    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> source =
        new ServerStreamingStashCallable<>(responses);
    RowMergingCallable<Row> mergingCallable =
        new RowMergingCallable<>(source, new DefaultRowAdapter());

    // Invoke the callable to get the merged rows
    ServerStream<Row> stream = mergingCallable.call(ReadRowsRequest.getDefaultInstance());

    // Read all of the rows and transform them into logical cells
    List<ReadRowsTest.Result> actualResults = Lists.newArrayList();
    Exception error = null;

    try {
      for (Row row : stream) {
        for (RowCell cell : row.getCells()) {
          actualResults.add(
              ReadRowsTest.Result.newBuilder()
                  .setRowKeyBytes(row.getKey())
                  .setFamilyName(cell.getFamily())
                  .setQualifierBytes(cell.getQualifier())
                  .setTimestampMicros(cell.getTimestamp())
                  .setValueBytes(cell.getValue())
                  .setLabel(cell.getLabels().isEmpty() ? "" : cell.getLabels().get(0))
                  .build());
        }
      }
    } catch (Exception e) {
      error = e;
    }

    // Verify the results
    if (expectsError(testCase)) {
      assertThat(error).isNotNull();
    } else {
      if (error != null) {
        throw error;
      }
    }

    assertThat(getNonExceptionResults(testCase)).isEqualTo(actualResults);
  }

  private static boolean expectsError(ReadRowsTest rrt) {
    List<ReadRowsTest.Result> results = rrt.getResultsList();
    return results != null && !results.isEmpty() && results.get(results.size() - 1).getError();
  }

  private static List<ReadRowsTest.Result> getNonExceptionResults(ReadRowsTest rrt) {
    List<ReadRowsTest.Result> results = rrt.getResultsList();

    List<ReadRowsTest.Result> response = new ArrayList<>();
    if (results != null) {
      for (ReadRowsTest.Result result : results) {
        if (!result.getError()) {
          response.add(result);
        }
      }
    }
    return response;
  }
}
