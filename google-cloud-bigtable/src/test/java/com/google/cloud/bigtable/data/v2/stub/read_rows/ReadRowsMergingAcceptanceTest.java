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
package com.google.cloud.bigtable.data.v2.stub.read_rows;

import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.ReadRowsResponse.CellChunk;
import com.google.cloud.bigtable.data.v2.wrappers.DefaultRowAdapter;
import com.google.cloud.bigtable.data.v2.wrappers.Row;
import com.google.cloud.bigtable.data.v2.wrappers.RowCell;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi.ServerStreamingStashCallable;
import com.google.common.base.CaseFormat;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.protobuf.TextFormat;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.junit.Assert;
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

    Gson gson = new Gson();
    AcceptanceTest acceptanceTest =
        gson.fromJson(new InputStreamReader(testInputStream), AcceptanceTest.class);
    List<Object[]> data = new ArrayList<>();
    for (ChunkTestCase test : acceptanceTest.tests) {
      data.add(new Object[] {test});
    }
    return data;
  }

  @Test
  public void test() throws Exception {
    List<ReadRowsResponse> responses = Lists.newArrayList();

    for (String chunkStr : testCase.chunks) {
      ReadRowsResponse.Builder responseBuilder = ReadRowsResponse.newBuilder();
      CellChunk.Builder ccBuilder = CellChunk.newBuilder();
      TextFormat.merge(new StringReader(chunkStr), ccBuilder);
      responseBuilder.addChunks(ccBuilder.build());
      responses.add(responseBuilder.build());
    }

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> source =
        new ServerStreamingStashCallable<>(responses);
    RowMergingCallable<Row> mergingCallable =
        new RowMergingCallable<>(source, new DefaultRowAdapter());

    ServerStream<Row> stream = mergingCallable.call(ReadRowsRequest.getDefaultInstance());

    List<TestResult> actualResults = Lists.newArrayList();
    Exception error = null;

    try {
      for (Row row : stream) {
        for (RowCell cell : row.getCells()) {
          actualResults.add(
              new TestResult(
                  row.getKey().toStringUtf8(),
                  cell.family(),
                  cell.qualifier().toStringUtf8(),
                  cell.timestamp(),
                  cell.value().toStringUtf8(),
                  cell.labels().isEmpty() ? "" : cell.labels().get(0),
                  false));
        }
      }
    } catch (Exception e) {
      error = e;
    }

    if (testCase.expectsError()) {
      Assert.assertNotNull(error);
    } else {
      if (error != null) {
        throw error;
      }
    }

    Assert.assertEquals(testCase.getNonExceptionResults(), actualResults);
  }

  // The acceptance test data model, populated via jackson data binding
  private static final class AcceptanceTest {

    public List<ChunkTestCase> tests;
  }

  private static final class ChunkTestCase {

    public String name;
    public List<String> chunks;
    public List<TestResult> results;

    /** The test name in the source file is an arbitrary string. Make it junit-friendly. */
    public String getJunitTestName() {
      return CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, name.replace(" ", "-"));
    }

    @Override
    public String toString() {
      return getJunitTestName();
    }

    public boolean expectsError() {
      return results != null && !results.isEmpty() && results.get(results.size() - 1).error;
    }

    public List<TestResult> getNonExceptionResults() {
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

    public String rk;
    public String fm;
    public String qual;
    public long ts;
    public String value;
    public String label;
    public boolean error;

    /** Constructor for JSon deserialization. */
    @SuppressWarnings("unused")
    public TestResult() {}

    public TestResult(
        String rk, String fm, String qual, long ts, String value, String label, boolean error) {
      this.rk = rk;
      this.fm = fm;
      this.qual = qual;
      this.ts = ts;
      this.value = value;
      this.label = label;
      this.error = error;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("rk", rk)
          .add("fm", fm)
          .add("qual", qual)
          .add("ts", ts)
          .add("value", value)
          .add("label", label)
          .add("error", error)
          .toString();
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null || !(obj instanceof TestResult)) {
        return false;
      }
      if (obj == this) {
        return true;
      }
      TestResult other = (TestResult) obj;
      return Objects.equals(rk, other.rk)
          && Objects.equals(fm, other.fm)
          && Objects.equals(qual, other.qual)
          && Objects.equals(ts, other.ts)
          && Objects.equals(value, other.value)
          && Objects.equals(label, other.label)
          && Objects.equals(error, other.error);
    }
  }
}
