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

import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.cloud.bigtable.data.v2.models.DefaultRowAdapter;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi.ServerStreamingStashCallable;
import com.google.common.base.CaseFormat;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.protobuf.TextFormat;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
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
  private final ChunkTestCase testCase;

  public ReadRowsMergingAcceptanceTest(ChunkTestCase testCase) {
    this.testCase = testCase;
  }

  @Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    InputStream testInputStream =
        ReadRowsMergingAcceptanceTest.class.getResourceAsStream("read-rows-acceptance-test.json");

    // Parse the json
    Gson gson = new Gson();
    AcceptanceTest acceptanceTest =
        gson.fromJson(new InputStreamReader(testInputStream), AcceptanceTest.class);

    // Construct parameters for each test run
    List<Object[]> data = new ArrayList<>();
    for (ChunkTestCase test : acceptanceTest.tests) {
      data.add(new Object[] {test});
    }

    return data;
  }

  @Test
  public void test() throws Exception {
    List<ReadRowsResponse> responses = Lists.newArrayList();

    // Convert the chunks into a single ReadRowsResponse
    for (String chunkStr : testCase.chunks) {
      ReadRowsResponse.Builder responseBuilder = ReadRowsResponse.newBuilder();
      TextFormat.merge(new StringReader(chunkStr), responseBuilder.addChunksBuilder());
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
    List<TestResult> actualResults = Lists.newArrayList();
    Exception error = null;

    try {
      for (Row row : stream) {
        for (RowCell cell : row.getCells()) {
          actualResults.add(
              new TestResult(
                  row.getKey().toStringUtf8(),
                  cell.getFamily(),
                  cell.getQualifier().toStringUtf8(),
                  cell.getTimestamp(),
                  cell.getValue().toStringUtf8(),
                  cell.getLabels().isEmpty() ? "" : cell.getLabels().get(0)));
        }
      }
    } catch (Exception e) {
      error = e;
    }

    // Verify the results
    if (testCase.expectsError()) {
      assertThat(error).isNotNull();
    } else {
      if (error != null) {
        throw error;
      }
    }

    assertThat(testCase.getNonExceptionResults()).isEqualTo(actualResults);
  }

  // <editor-fold desc="JSON data model populated by gson">
  private static final class AcceptanceTest {
    List<ChunkTestCase> tests;
  }

  private static final class ChunkTestCase {
    String name;
    List<String> chunks;
    List<TestResult> results;

    /** The test name in the source file is an arbitrary string. Make it junit-friendly. */
    String getJunitTestName() {
      return CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, name.replace(" ", "-"));
    }

    @Override
    public String toString() {
      return getJunitTestName();
    }

    boolean expectsError() {
      return results != null && !results.isEmpty() && results.get(results.size() - 1).error;
    }

    List<TestResult> getNonExceptionResults() {
      ArrayList<TestResult> response = new ArrayList<>();
      if (results != null) {
        for (TestResult result : results) {
          if (!result.error) {
            response.add(result);
          }
        }
      }
      return response;
    }
  }

  private static final class TestResult {
    @SerializedName("rk")
    String rowKey;

    @SerializedName("fm")
    String family;

    @SerializedName("qual")
    String qualifier;

    @SerializedName("ts")
    long timestamp;

    String value;
    String label;
    boolean error;

    /** Constructor for JSon deserialization. */
    @SuppressWarnings("unused")
    public TestResult() {}

    TestResult(
        String rowKey,
        String family,
        String qualifier,
        long timestamp,
        String value,
        String label) {
      this.rowKey = rowKey;
      this.family = family;
      this.qualifier = qualifier;
      this.timestamp = timestamp;
      this.value = value;
      this.label = label;
      this.error = false;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      TestResult that = (TestResult) o;
      return Objects.equal(rowKey, that.rowKey)
          && Objects.equal(family, that.family)
          && Objects.equal(qualifier, that.qualifier)
          && timestamp == that.timestamp
          && Objects.equal(value, that.value)
          && Objects.equal(label, that.label)
          && error == that.error;
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(rowKey, family, qualifier, timestamp, value, label, error);
    }
  }
  // </editor-fold>
}
