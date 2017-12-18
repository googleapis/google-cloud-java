package com.google.cloud.firestore;


import static com.google.cloud.firestore.LocalFirestoreHelper.commitResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.getAllResponse;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.firestore.conformance.TestDefinition;
import com.google.cloud.firestore.conformance.TestDefinition.CreateTest;
import com.google.cloud.firestore.conformance.TestDefinition.DeleteTest;
import com.google.cloud.firestore.conformance.TestDefinition.GetTest;
import com.google.cloud.firestore.conformance.TestDefinition.SetTest;
import com.google.cloud.firestore.conformance.TestDefinition.UpdatePathsTest;
import com.google.cloud.firestore.conformance.TestDefinition.UpdateTest;
import com.google.cloud.firestore.spi.v1beta1.FirestoreRpc;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.firestore.v1beta1.BatchGetDocumentsRequest;
import com.google.firestore.v1beta1.CommitRequest;
import com.google.firestore.v1beta1.Precondition;
import com.google.firestore.v1beta1.Value;
import com.google.firestore.v1beta1.Write;
import com.google.firestore.v1beta1.Write.Builder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.Message;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import junit.framework.Protectable;
import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.threeten.bp.Instant;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RunWith(AllTests.class)
public class ConformanceTest {

  private Gson gson = new Gson();

  private Set<String> excludedTests = ImmutableSet.<String>builder().add(
      "set: nested ServerTimestamp field", "set: multiple ServerTimestamp fields",
      "create: nested ServerTimestamp field", "create: multiple ServerTimestamp fields",
      "create: ServerTimestamp alone",
      "set: ServerTimestamp with MergeAll",
      "set: ServerTimestamp alone with MergeAll",
      "set-merge: ServerTimestamp with Merge of both fields",
      "set-merge: If no ordinary values in Merge, no write",
      "update: ServerTimestamp alone",
      "update: ServerTimestamp with data",
      "update: nested ServerTimestamp field", "update: multiple ServerTimestamp fields",
      "update: ServerTimestamp with dotted field",
      "update-paths: ServerTimestamp alone",
      "update-paths: ServerTimestamp with data",
      "update-paths: nested ServerTimestamp field", "update-paths: multiple ServerTimestamp fields"

  ).build();

  private Set<String> includedTests = ImmutableSet.<String>builder().
     //add("update-paths: special characters").
          build();

  @Spy
  private FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("projectID").build(),
          Mockito.mock(FirestoreRpc.class));

  @Captor
  private ArgumentCaptor<CommitRequest> commitCapture;

  @Captor
  private ArgumentCaptor<BatchGetDocumentsRequest> getAllCapture;

  @Captor
  private ArgumentCaptor<ApiStreamObserver> streamObserverCapture;

  public static TestSuite suite() throws IOException {
    TestSuite suite = new TestSuite();
    ConformanceTest conformanceTest = new ConformanceTest();
    MockitoAnnotations.initMocks(conformanceTest);
    for (Test test : conformanceTest.parseTests()) {
      suite.addTest(test);
    }
    return suite;
  }


  private Map<String, Object> convertInput(String jsonData) {
    Type type = new TypeToken<Map<String, Object>>() {
    }.getType();
    Map<String, Object> parsedData = gson.fromJson(jsonData, type);
    return convertMap(parsedData);
  }


  private List<Object> convertInput(List<String> values) {
    List<Object> result = new ArrayList<>();
    for (String input : values) {
      if (input.matches("^\\{.*}$")) {
        result.add(convertInput(input));
      } else {
        result.add(convertInput("{a:" + input + "}").get("a"));
      }
    }
    return result;
  }

  private Map<String, Object> convertMap(Map<String, Object> parsedData) {
    for (Entry<String, Object> entry : parsedData.entrySet()) {
      parsedData.put(entry.getKey(), convertValue(entry.getValue()));
    }
    return parsedData;
  }

  private Object convertValue(Object data) {
    if (data instanceof Map) {
      return convertMap((Map<String, Object>) data);
    } else if (data instanceof List) {
      return convertArray((List<Object>) data);
    } else if (data.equals("Delete")) {
      return FieldValue.delete();
    } else if (data.equals("ServerTimestamp")) {
      return FieldValue.serverTimestamp();
    } else if (data instanceof Double
        && Double.compare((double) data, Math.floor((double) data)) == 0) {
      return (long) (double) data;
    } else {
      return data;
    }
  }

  private List<Object> convertArray(List<Object> list) {
    for (int i = 0; i < list.size(); ++i) {
      list.set(i, convertValue(list.get(i)));
    }
    return list;
  }

  private List<Test> parseTests() throws IOException {
    List<Test> tests = new ArrayList<>();
    FileInputStream inputStream = new FileInputStream("./src/test/resources/test_data.binprotos");

    int length;
    while ((length = readVarInt(inputStream)) != -1) {
      byte[] buffer = new byte[length];
      int read = inputStream.read(buffer);
      Preconditions.checkState(length == read,
          "Encountered unexpected length for test case. Expected %d, but was %d", length, read);
      TestDefinition.Test testDefinition = TestDefinition.Test.parseFrom(buffer);

      if ((!includedTests.isEmpty() && !includedTests.contains(testDefinition.getDescription()))
          || excludedTests.contains(testDefinition.getDescription())) {
        continue;
      }
      tests.add(buildTest(testDefinition));
    }

    return tests;
  }

  private Test buildTest(final TestDefinition.Test testDefinition) {
    return new Test() {
      @Override
      public String toString() {
        return testDefinition.getDescription();
      }

      @Override
      public int countTestCases() {
        return 1;
      }

      @Override
      public void run(TestResult testResult) {
        testResult.startTest(this);
        testResult.runProtected(this, new Protectable() {
          @Override
          public void protect() throws Throwable {
            System.out.println(testDefinition);
            switch (testDefinition.getTestCase()) {
              case GET:
                runGet(testDefinition.getGet());
                break;
              case CREATE:
                runCreate(testDefinition.getCreate());
                break;
              case SET:
                runSet(testDefinition.getSet());
                break;
              case UPDATE:
                runUpdate(testDefinition.getUpdate());
                break;
              case UPDATE_PATHS:
                runUpdatePath(testDefinition.getUpdatePaths());
                break;
              case DELETE:
                runDelete(testDefinition.getDelete());
                break;
              default:
                break;
            }
          }
        });
        testResult.endTest(this);
      }
    };
  }

  private void runUpdatePath(UpdatePathsTest testCase) {
    doReturn(commitResponse(testCase.getRequest().getWritesCount(), 0))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    try {
      ApiFuture<WriteResult> apiCall;

      List<FieldPath> fieldPaths = convertFields(testCase.getFieldPathsList());
      FieldPath firstField = fieldPaths.remove(0);

      List<Object> values = convertInput(testCase.getJsonValuesList());
      Object firstValue = values.remove(0);

      Object[] moreFieldsAndValues = new Object[2 * fieldPaths.size()];

      for (int i = 0 ; i < fieldPaths.size(); ++i) {
        moreFieldsAndValues[2 * i] = fieldPaths.get(i);
        moreFieldsAndValues[2 * i + 1] = values.get(i);
      }

      if (testCase.hasPrecondition()) {
        apiCall = document(testCase.getDocRefPath()).update(
            convertPrecondition(testCase.getPrecondition()), firstField, firstValue, moreFieldsAndValues);
      } else {
        apiCall = document(testCase.getDocRefPath()).update(firstField, firstValue, moreFieldsAndValues);
      }

      Assert.assertFalse(testCase.getIsError());

      apiCall.get();
      CommitRequest request = commitCapture.getValue();
      Assert.assertEquals(testCase.getRequest(), request);

    } catch (Exception e) {
      Assert.assertTrue(testCase.getIsError());
    }
  }

  private void runUpdate(UpdateTest testCase) {
    doReturn(commitResponse(testCase.getRequest().getWritesCount(), 0))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    try {
      ApiFuture<WriteResult> apiCall;

      if (testCase.hasPrecondition()) {
        apiCall = document(testCase.getDocRefPath()).update(convertInput(testCase.getJsonData()),
            convertPrecondition(testCase.getPrecondition()));
      } else {
        apiCall = document(testCase.getDocRefPath()).update(convertInput(testCase.getJsonData()));
      }

      Assert.assertFalse(testCase.getIsError());

      apiCall.get();
      CommitRequest request = commitCapture.getValue();
      Assert.assertEquals(testCase.getRequest(), request);

    } catch (Exception e) {
      Assert.assertTrue(testCase.getIsError());
    }
  }


  private void runDelete(DeleteTest testCase) throws ExecutionException, InterruptedException {
    doReturn(commitResponse(0, testCase.getRequest().getWritesCount()))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    if (!testCase.hasPrecondition()) {
      document(testCase.getDocRefPath()).delete().get();
    } else {

      document(testCase.getDocRefPath()).delete(convertPrecondition(testCase.getPrecondition()))
          .get();
    }

    CommitRequest request = commitCapture.getValue();
    Assert.assertEquals(testCase.getRequest(), request);

  }

  private com.google.cloud.firestore.Precondition convertPrecondition(Precondition precondition) {
    switch (precondition.getConditionTypeCase()) {

      case EXISTS:
        return com.google.cloud.firestore.Precondition.exists(precondition.getExists());
      case UPDATE_TIME:
        return com.google.cloud.firestore.Precondition.updatedAt(Instant
            .ofEpochSecond(precondition.getUpdateTime().getSeconds(),
                precondition.getUpdateTime().getNanos()));
      default:
        return com.google.cloud.firestore.Precondition.NONE;
    }
  }

  private void runCreate(CreateTest testCase) {
    doReturn(commitResponse(testCase.getRequest().getWritesCount(), 0))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    try {
      ApiFuture<WriteResult> apiCall = document(testCase.getDocRefPath())
          .create(convertInput(testCase.getJsonData()));

      Assert.assertFalse(testCase.getIsError());
      apiCall.get();

      CommitRequest request = commitCapture.getValue();
      Assert.assertEquals(testCase.getRequest(), request);

    } catch (Exception e) {
      Assert.assertTrue(testCase.getIsError());
    }
  }

  private void runSet(SetTest testCase) throws InterruptedException {
    doReturn(commitResponse(testCase.getRequest().getWritesCount(), 0))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());
    ApiFuture<WriteResult> apiCall;

    try {
      if (testCase.hasOption() && testCase.getOption().getAll()) {
        apiCall = document(testCase.getDocRefPath())
            .set(convertInput(testCase.getJsonData()), SetOptions.merge());
      } else if (testCase.hasOption() && testCase.getOption().getFieldsCount() > 0) {
        apiCall = document(testCase.getDocRefPath()).set(convertInput(testCase.getJsonData()),
            SetOptions.mergeFieldPaths(convertFields(testCase.getOption().getFieldsList())));
      } else {
        apiCall = document(testCase.getDocRefPath()).set(convertInput(testCase.getJsonData()));
      }

      Assert.assertFalse(testCase.getIsError());
      apiCall.get();

      CommitRequest request = commitCapture.getValue();
      Assert.assertEquals(testCase.getRequest(), request);
    } catch (Exception e) {
      Assert.assertTrue(testCase.getIsError());
    }
  }

  private List<FieldPath> convertFields(List<TestDefinition.FieldPath> fieldsList) {
    List<FieldPath> convertedFields = new ArrayList<>();
    for (TestDefinition.FieldPath fieldPath : fieldsList) {
      convertedFields.add(FieldPath.of(fieldPath.getFieldList().toArray(new String[0])));
    }
    return convertedFields;
  }


  private void runGet(GetTest testCase) throws ExecutionException, InterruptedException {
    doAnswer(getAllResponse(Collections.<String, Value>emptyMap()))
        .when(firestoreMock)
        .streamRequest(
            getAllCapture.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    document(testCase.getDocRefPath()).get().get();

    BatchGetDocumentsRequest request = getAllCapture.getValue();

    Assert.assertEquals(1, request.getDocumentsCount());
    Assert.assertEquals(testCase.getRequest().getName(), request.getDocuments(0));
  }

  private DocumentReference document(String absolutePath) {
    String root = "projects/projectID/databases/(default)/documents/";
    Preconditions.checkState(absolutePath.startsWith(root));
    return firestoreMock.document(absolutePath.substring(root.length()));
  }

  /**
   * Decodes a Protobuf varint.
   */
  public int readVarInt(InputStream in) throws IOException {
    int res = 0;
    int pos = 0;
    int b;
    while (((b = in.read()) & 0x80) != 0) {
      if (b == -1) {
        return -1;
      }
      res |= (b & 0x7F) << pos;
      pos += 7;
    }
    return res | (b << pos);
  }


}
