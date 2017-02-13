/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.ByteArray;
import com.google.cloud.spanner.spi.SpannerRpc;
import com.google.common.io.Resources;
import com.google.protobuf.util.JsonFormat;
import com.google.spanner.v1.ExecuteSqlRequest.QueryMode;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.Transaction;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;

/** Test runner that runs tests specified in json file */
public class ReadFormatTestRunner extends ParentRunner<JSONObject> {

  private static class NoOpListener implements SpannerImpl.AbstractResultSet.Listener {
    @Override
    public void onTransactionMetadata(Transaction transaction) throws SpannerException {}

    @Override
    public void onError(SpannerException e) {}

    @Override
    public void onDone() {}
  }

  public ReadFormatTestRunner(Class<?> clazz) throws InitializationError {
    super(clazz);
  }

  @Override
  protected Description describeChild(JSONObject child) {
    try {
      return Description.createTestDescription(
          getTestClass().getJavaClass(), child.getString("name"));
    } catch (JSONException e) {
      throw new IllegalStateException("Illegal json object: " + child.toString(), e);
    }
  }

  @Override
  protected void runChild(JSONObject child, RunNotifier notifier) {
    EachTestNotifier eachNotifier = new EachTestNotifier(notifier, describeChild(child));
    eachNotifier.fireTestStarted();
    try {
      new TestCaseRunner(child).run();
      eachNotifier.fireTestFinished();
    } catch (Exception | AssertionError e) {
      eachNotifier.addFailure(e);
    }
  }

  @Override
  protected List<JSONObject> getChildren() {
    try {
      List<JSONObject> children = new ArrayList<>();
      String jsonStr =
          Resources.toString(
              Resources.getResource(this.getClass(), "read_tests.json"), StandardCharsets.UTF_8);
      JSONObject json = new JSONObject(jsonStr);
      JSONArray testCases = json.getJSONArray("tests");
      for (int i = 0; i < testCases.length(); i++) {
        JSONObject testCase = testCases.getJSONObject(i);
        children.add(testCase);
      }
      return children;
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }

  private class TestCaseRunner {
    private SpannerImpl.GrpcResultSet resultSet;
    private SpannerRpc.ResultStreamConsumer consumer;
    private SpannerImpl.GrpcStreamIterator stream;
    private JSONObject testCase;

    TestCaseRunner(JSONObject testCase) {
      this.testCase = testCase;
    }

    private void run() throws Exception {
      stream = new SpannerImpl.GrpcStreamIterator(10);
      stream.setCall(
          new SpannerRpc.StreamingCall() {
            @Override
            public void cancel(@Nullable String message) {}

            @Override
            public void request(int numMessages) {}
          });
      consumer = stream.consumer();
      resultSet = new SpannerImpl.GrpcResultSet(stream, new NoOpListener(), QueryMode.NORMAL);

      JSONArray chunks = testCase.getJSONArray("chunks");
      JSONObject expectedResult = testCase.getJSONObject("result");
      for (int i = 0; i < chunks.length(); i++) {
        PartialResultSet.Builder builder = PartialResultSet.newBuilder();
        JsonFormat.parser().merge(chunks.getString(i), builder);
        consumer.onPartialResultSet(builder.build());
      }
      consumer.onCompleted();
      assertResultSet(resultSet, expectedResult.getJSONArray("value"));
    }

    private void assertResultSet(SpannerImpl.GrpcResultSet actual, JSONArray expected)
        throws Exception {
      int i = 0;
      while (actual.next()) {
        Struct actualRow = actual.getCurrentRowAsStruct();
        JSONArray expectedRow = expected.getJSONArray(i);
        assertRow(actualRow, expectedRow);
        i++;
      }
      assertThat(i).isEqualTo(expected.length());
    }

    private void assertRow(Struct actualRow, JSONArray expectedRow) throws Exception {
      assertThat(actualRow.getColumnCount()).isEqualTo(expectedRow.length());
      for (int i = 0; i < expectedRow.length(); i++) {
        switch (actualRow.getColumnType(i).getCode()) {
          case BOOL:
            assertThat(actualRow.getBoolean(i)).isEqualTo(expectedRow.getBoolean(i));
            break;
          case STRING:
            assertThat(actualRow.getString(i)).isEqualTo(expectedRow.getString(i));
            break;
          case INT64:
            assertThat(actualRow.getLong(i)).isEqualTo(expectedRow.getLong(i));
            break;
          case FLOAT64:
            assertThat(actualRow.getDouble(i)).isEqualTo(expectedRow.getDouble(i));
            break;
          case BYTES:
            assertThat(actualRow.getBytes(i))
                .isEqualTo(ByteArrays.fromBase64(expectedRow.getString(i)));
            break;
          case ARRAY:
            Type elementType = actualRow.getColumnType(i).getArrayElementType();
            assertArray(getRawList(actualRow, i, elementType), expectedRow.getJSONArray(i));
            break;
          default:
            Assert.fail("Unexpected type code:" + actualRow.getColumnType(i).getCode());
        }
      }
    }

    private List<?> getRawList(Struct actualRow, int index, Type elementType) throws Exception {
      List<?> rawList = null;
      switch (elementType.getCode()) {
        case BOOL:
          rawList = actualRow.getBooleanList(index);
          break;
        case STRING:
          rawList = actualRow.getStringList(index);
          break;
        case BYTES:
          rawList = actualRow.getBytesList(index);
          break;
        case INT64:
          rawList = actualRow.getLongList(index);
          break;
        case FLOAT64:
          rawList = actualRow.getDoubleList(index);
          break;
        case STRUCT:
          rawList = actualRow.getStructList(index);
          break;
        default:
          Assert.fail("Unexpected type code:" + elementType.getCode());
      }
      return rawList;
    }

    private void assertArray(List<?> actualValues, JSONArray expectedList) throws Exception {
      assertThat(actualValues.size()).isEqualTo(expectedList.length());
      for (int i = 0; i < actualValues.size(); i++) {
        Object actualValue = actualValues.get(i);
        if (actualValue == null) {
          assertThat(expectedList.isNull(i)).isTrue();
        } else {
          if (actualValue instanceof Boolean) {
            assertThat((Boolean) actualValue).isEqualTo(expectedList.getBoolean(i));
          } else if (actualValue instanceof String) {
            assertThat((String) actualValue).isEqualTo(expectedList.getString(i));
          } else if (actualValue instanceof Long) {
            assertThat((Long) actualValue).isEqualTo(expectedList.getLong(i));
          } else if (actualValue instanceof Double) {
            assertThat((Double) actualValue).isEqualTo(expectedList.getDouble(i));
          } else if (actualValue instanceof ByteArray) {
            assertThat((ByteArray) actualValue)
                .isEqualTo(ByteArrays.fromBase64(expectedList.getString(i)));
          } else if (actualValue instanceof Struct) {
            Struct actualStruct = (Struct) actualValue;
            JSONArray expectedFields = expectedList.getJSONArray(i);
            assertRow(actualStruct, expectedFields);
          }
        }
      }
    }
  }
}
