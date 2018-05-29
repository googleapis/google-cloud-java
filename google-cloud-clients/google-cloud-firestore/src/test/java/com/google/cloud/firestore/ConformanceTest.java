/*
 * Copyright 2017 Google LLC
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

import static com.google.cloud.firestore.LocalFirestoreHelper.commitResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.getAllResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.queryResponse;
import static com.google.cloud.firestore.UserDataConverter.NO_DELETES;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.Query.Direction;
import com.google.cloud.firestore.conformance.TestDefinition;
import com.google.cloud.firestore.conformance.TestDefinition.Clause;
import com.google.cloud.firestore.conformance.TestDefinition.CreateTest;
import com.google.cloud.firestore.conformance.TestDefinition.Cursor;
import com.google.cloud.firestore.conformance.TestDefinition.DeleteTest;
import com.google.cloud.firestore.conformance.TestDefinition.DocChange;
import com.google.cloud.firestore.conformance.TestDefinition.DocChange.Kind;
import com.google.cloud.firestore.conformance.TestDefinition.DocSnapshot;
import com.google.cloud.firestore.conformance.TestDefinition.GetTest;
import com.google.cloud.firestore.conformance.TestDefinition.OrderBy;
import com.google.cloud.firestore.conformance.TestDefinition.SetTest;
import com.google.cloud.firestore.conformance.TestDefinition.Snapshot;
import com.google.cloud.firestore.conformance.TestDefinition.UpdatePathsTest;
import com.google.cloud.firestore.conformance.TestDefinition.UpdateTest;
import com.google.cloud.firestore.conformance.TestDefinition.Where;
import com.google.cloud.firestore.spi.v1beta1.FirestoreRpc;
import com.google.common.base.Preconditions;
import com.google.firestore.v1beta1.BatchGetDocumentsRequest;
import com.google.firestore.v1beta1.CommitRequest;
import com.google.firestore.v1beta1.Document;
import com.google.firestore.v1beta1.ListenRequest;
import com.google.firestore.v1beta1.ListenResponse;
import com.google.firestore.v1beta1.Precondition;
import com.google.firestore.v1beta1.RunQueryRequest;
import com.google.firestore.v1beta1.Value;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Message;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import junit.framework.Protectable;
import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.runner.Describable;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@RunWith(AllTests.class)
public class ConformanceTest {
  private static final String TEST_FILE = "./src/test/resources/test-suite.binproto";

  /** Interface implemented by the conformance test cases. */
  private interface ConformanceTestCase extends Test, Describable {}

  /** Excluded tests by test description. */
  private final Set<String> excludedTests = Collections.emptySet();

  /** If non-empty, only runs tests included in this set. */
  private final Set<String> includedTests = Collections.emptySet();

  @Captor private ArgumentCaptor<CommitRequest> commitCapture;

  @Captor private ArgumentCaptor<BatchGetDocumentsRequest> getAllCapture;

  @Captor private ArgumentCaptor<ApiStreamObserver<GeneratedMessageV3>> streamObserverCapture;

  @Captor private ArgumentCaptor<RunQueryRequest> runQueryCapture;

  private Gson gson = new Gson();

  @Mock private ApiStreamObserver<ListenRequest> noOpRequestObserver;

  private FirestoreImpl firestoreMock;

  private Query watchQuery;

  public ConformanceTest() {
    ScheduledExecutorService firestoreExecutor = Executors.newSingleThreadScheduledExecutor();
    FirestoreRpc firestoreRpc = Mockito.mock(FirestoreRpc.class);
    when(firestoreRpc.getExecutor()).thenReturn(firestoreExecutor);

    firestoreMock =
        Mockito.spy(
            new FirestoreImpl(
                FirestoreOptions.newBuilder()
                    .setProjectId("projectID")
                    .setTimestampsInSnapshotsEnabled(true)
                    .build(),
                firestoreRpc));
    watchQuery = collection("projects/projectID/databases/(default)/documents/C").orderBy("a");
  }

  /** Generate the test suite based on the tests defined in test_data.binprotos. */
  public static TestSuite suite() throws IOException {
    TestSuite suite = new TestSuite();
    ConformanceTest conformanceTest = new ConformanceTest();
    MockitoAnnotations.initMocks(conformanceTest);
    for (Test test : conformanceTest.parseTests()) {
      suite.addTest(test);
    }
    return suite;
  }

  /** Creates a document reference from an absolute path. */
  private DocumentReference document(String absolutePath) {
    String root = "projects/projectID/databases/(default)/documents/";
    Preconditions.checkState(absolutePath.startsWith(root));
    return firestoreMock.document(absolutePath.substring(root.length()));
  }

  /** Creates a collection reference from an absolute path. */
  private CollectionReference collection(String absolutePath) {
    String root = "projects/projectID/databases/(default)/documents/";
    Preconditions.checkState(absolutePath.startsWith(root));
    return firestoreMock.collection(absolutePath.substring(root.length()));
  }

  /** Converts a Protobuf Precondition to its API counterpart. */
  private com.google.cloud.firestore.Precondition convertPrecondition(Precondition precondition) {
    switch (precondition.getConditionTypeCase()) {
      case EXISTS:
        return com.google.cloud.firestore.Precondition.exists(precondition.getExists());
      case UPDATE_TIME:
        return com.google.cloud.firestore.Precondition.updatedAt(
            Timestamp.fromProto(precondition.getUpdateTime()));
      default:
        return com.google.cloud.firestore.Precondition.NONE;
    }
  }

  /** Converts a list of Proto FieldPaths to its API counterpart. */
  private List<FieldPath> convertPaths(List<TestDefinition.FieldPath> fieldsList) {
    List<FieldPath> convertedPaths = new ArrayList<>();
    for (TestDefinition.FieldPath fieldPath : fieldsList) {
      convertedPaths.add(convertPath(fieldPath));
    }
    return convertedPaths;
  }

  /** Converts a Proto FieldPath to its API counterpart. */
  private FieldPath convertPath(TestDefinition.FieldPath fieldPath) {
    return FieldPath.of(fieldPath.getFieldList().toArray(new String[0]));
  }

  /** Converts a JSON string into a Java Map. */
  private Map<String, Object> convertInput(String jsonMap) {
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    Map<String, Object> parsedData = gson.fromJson(jsonMap, type);
    return convertMap(parsedData);
  }

  /** Converts a list of Strings into a Java Object. Parses JSON when provided. */
  private List<Object> convertInput(List<String> jsonValues) {
    List<Object> result = new ArrayList<>();
    for (String input : jsonValues) {
      if (input.matches("^\\{.*}$")) {
        result.add(convertInput(input));
      } else {
        // We need to "fake" a proper JSON object to let GSON convert to native types.
        result.add(convertInput("{a:" + input + "}").get("a"));
      }
    }
    return result;
  }

  /** Converts a DocumentSnapshot proto into a DocumentSnapshot. */
  private DocumentSnapshot convertDocument(DocSnapshot snapshot) {
    return DocumentSnapshot.fromObject(
        firestoreMock,
        document(snapshot.getPath()),
        convertInput(snapshot.getJsonData()),
        NO_DELETES);
  }

  /** Helper function to convert test values in a nested Map to Firestore API types. */
  private Map<String, Object> convertMap(Map<String, Object> parsedData) {
    for (Entry<String, Object> entry : parsedData.entrySet()) {
      parsedData.put(entry.getKey(), convertValue(entry.getValue()));
    }
    return parsedData;
  }

  /**
   * Converts test values to Firestore API types. Replaces sentinel values with their FieldValue
   * constants.
   */
  private Object convertValue(Object data) {
    if (data instanceof Map) {
      return convertMap((Map<String, Object>) data);
    } else if (data instanceof List) {
      return convertArray((List<Object>) data);
    } else if ("NaN".equals(data)) {
      return Double.NaN;
    } else if ("Delete".equals(data)) {
      return FieldValue.delete();
    } else if ("ServerTimestamp".equals(data)) {
      return FieldValue.serverTimestamp();
    } else if (data instanceof Double
        && Double.compare((double) data, Math.floor((double) data)) == 0) {
      return (long) (double) data;
    } else {
      return data;
    }
  }

  /** Converts a Kind into a DocumentChange.Type */
  private DocumentChange.Type convertKind(Kind kind) {
    DocumentChange.Type changeType = null;

    switch (kind) {
      case ADDED:
        changeType = DocumentChange.Type.ADDED;
        break;
      case REMOVED:
        changeType = DocumentChange.Type.REMOVED;
        break;
      case MODIFIED:
        changeType = DocumentChange.Type.MODIFIED;
        break;
      default:
        Assert.fail("Unable to convert document change for kind: " + kind);
        break;
    }

    return changeType;
  }

  /** Converts a test snapshot to its API representation. */
  private QuerySnapshot convertQuerySnapshot(Snapshot testSnapshot) {
    Timestamp readTime = Timestamp.fromProto(testSnapshot.getReadTime());

    final List<QueryDocumentSnapshot> documentSnapshots = new ArrayList<>();

    for (Document document : testSnapshot.getDocsList()) {
      documentSnapshots.add(
          QueryDocumentSnapshot.fromDocument(
              firestoreMock, Timestamp.fromProto(testSnapshot.getReadTime()), document));
    }

    DocumentSet documentSet =
        DocumentSet.emptySet(
            new Comparator<QueryDocumentSnapshot>() {
              @Override
              public int compare(QueryDocumentSnapshot o1, QueryDocumentSnapshot o2) {
                // Comparator that preserves the insertion order as defined in the test case.
                for (QueryDocumentSnapshot snapshot : documentSnapshots) {
                  if (o1.equals(o2)) {
                    return 0;
                  } else if (o1.equals(snapshot)) {
                    return -1;
                  } else if (o2.equals(snapshot)) {
                    return 1;
                  }
                }

                Assert.fail("Unable to find position for document snapshot");
                return 0;
              }
            });

    for (QueryDocumentSnapshot snapshot : documentSnapshots) {
      documentSet = documentSet.add(snapshot);
    }

    List<DocumentChange> documentChanges = new ArrayList<>();

    for (DocChange documentChange : testSnapshot.getChangesList()) {
      QueryDocumentSnapshot documentSnapshot =
          QueryDocumentSnapshot.fromDocument(
              firestoreMock,
              Timestamp.fromProto(testSnapshot.getReadTime()),
              documentChange.getDoc());
      DocumentChange.Type changeType = convertKind(documentChange.getKind());
      documentChanges.add(
          new DocumentChange(
              documentSnapshot,
              changeType,
              documentChange.getOldIndex(),
              documentChange.getNewIndex()));
    }

    return QuerySnapshot.withChanges(watchQuery, readTime, documentSet, documentChanges);
  }

  /** Helper function to convert test values in a list to Firestore API types. */
  private List<Object> convertArray(List<Object> list) {
    for (int i = 0; i < list.size(); ++i) {
      list.set(i, convertValue(list.get(i)));
    }
    return list;
  }

  /** Reads the test definition from the Proto file. */
  private List<Test> parseTests() throws IOException {
    List<Test> tests = new ArrayList<>();

    TestDefinition.TestSuite testSuite =
        TestDefinition.TestSuite.parseFrom(new FileInputStream(TEST_FILE));
    for (TestDefinition.Test testDefinition : testSuite.getTestsList()) {
      if (!includedTests.isEmpty() && !includedTests.contains(testDefinition.getDescription())
          || excludedTests.contains(testDefinition.getDescription())) {
        continue;
      }
      Test test = buildTest(testDefinition);
      tests.add(test);
    }

    return tests;
  }

  /** Returns the test case for the provided test definition. */
  private Test buildTest(final TestDefinition.Test testDefinition) {
    return new ConformanceTestCase() {
      @Override
      public Description getDescription() {
        return Description.createTestDescription(
            ConformanceTest.class.getName(), testDefinition.getDescription());
      }

      @Override
      public int countTestCases() {
        return 1;
      }

      @Override
      public void run(TestResult testResult) {
        testResult.startTest(this);
        testResult.runProtected(
            this,
            new Protectable() {
              @Override
              public void protect() throws Throwable {
                // Uncomment to print the test protobuf:
                // System.out.println(testDefinition);

                switch (testDefinition.getTestCase()) {
                  case GET:
                    runGetTest(testDefinition.getGet());
                    break;
                  case CREATE:
                    runCreateTest(testDefinition.getCreate());
                    break;
                  case SET:
                    runSetTest(testDefinition.getSet());
                    break;
                  case UPDATE:
                    runUpdateTest(testDefinition.getUpdate());
                    break;
                  case UPDATE_PATHS:
                    runUpdatePathTest(testDefinition.getUpdatePaths());
                    break;
                  case DELETE:
                    runDeleteTest(testDefinition.getDelete());
                    break;
                  case QUERY:
                    runQueryTest(testDefinition.getQuery());
                    break;
                  case LISTEN:
                    runWatchTest(testDefinition.getListen());
                    break;
                  default:
                    throw new UnsupportedOperationException();
                }
              }
            });
        testResult.endTest(this);
      }
    };
  }

  private void runQueryTest(TestDefinition.QueryTest testCase) {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQueryCapture.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    Query query = collection(testCase.getCollPath());

    try {
      for (Clause clause : testCase.getClausesList()) {
        query = applyClause(query, clause);
      }

      ApiFuture<QuerySnapshot> apiCall = query.get();
      Assert.assertFalse(testCase.getIsError());

      apiCall.get();
      RunQueryRequest request = runQueryCapture.getValue();
      Assert.assertEquals(testCase.getQuery(), request.getStructuredQuery());
    } catch (Exception e) {
      Assert.assertTrue(testCase.getIsError());
    }
  }

  private void runWatchTest(final TestDefinition.ListenTest testCase)
      throws ExecutionException, InterruptedException {
    final SettableApiFuture<Void> testCaseStarted = SettableApiFuture.create();
    final SettableApiFuture<Void> testCaseFinished = SettableApiFuture.create();

    doAnswer(
            new Answer<ApiStreamObserver<ListenRequest>>() {
              @Override
              public ApiStreamObserver<ListenRequest> answer(InvocationOnMock invocationOnMock) {
                testCaseStarted.set(null);
                return noOpRequestObserver;
              }
            })
        .when(firestoreMock)
        .streamRequest(streamObserverCapture.capture(), Matchers.any(BidiStreamingCallable.class));

    final List<Snapshot> expectedSnapshots = new ArrayList<>(testCase.getSnapshotsList());

    final ListenerRegistration registration =
        watchQuery.addSnapshotListener(
            new EventListener<QuerySnapshot>() {
              @Override
              public void onEvent(
                  @Nullable QuerySnapshot actualSnapshot, @Nullable FirestoreException error) {
                try {
                  if (actualSnapshot != null) {
                    Assert.assertNull(error);
                    Assert.assertFalse(expectedSnapshots.isEmpty());
                    Snapshot expectedSnapshot = expectedSnapshots.remove(0);
                    Assert.assertEquals(convertQuerySnapshot(expectedSnapshot), actualSnapshot);
                    if (expectedSnapshots.isEmpty()) {
                      if (!testCase.getIsError()) {
                        testCaseFinished.set(null);
                      }
                    }
                  } else { // Error case
                    Assert.assertNotNull(error);
                    Assert.assertTrue(expectedSnapshots.isEmpty());
                    Assert.assertTrue(testCase.getIsError());
                    testCaseFinished.set(null);
                  }
                } catch (AssertionError e) {
                  testCaseFinished.setException(e);
                }
              }
            });

    testCaseStarted.get();

    for (ListenResponse response : testCase.getResponsesList()) {
      streamObserverCapture.getValue().onNext(response);
    }

    testCaseFinished.get();
    registration.remove();
  }

  /** Returns a new query with 'clause' applied. */
  private Query applyClause(Query query, Clause clause) {
    FieldPath fieldPath;
    Object value;
    Cursor cursor;

    switch (clause.getClauseCase()) {
      case SELECT:
        query =
            query.select(
                convertPaths(clause.getSelect().getFieldsList()).toArray(new FieldPath[] {}));
        break;
      case WHERE:
        Where whereClause = clause.getWhere();
        fieldPath = convertPath(whereClause.getPath());
        value = convertInput(Collections.singletonList(whereClause.getJsonValue())).get(0);
        switch (whereClause.getOp()) {
          case "<":
            query = query.whereLessThan(fieldPath, value);
            break;
          case "<=":
            query = query.whereLessThanOrEqualTo(fieldPath, value);
            break;
          case "==":
            query = query.whereEqualTo(fieldPath, value);
            break;
          case ">=":
            query = query.whereGreaterThanOrEqualTo(fieldPath, value);
            break;
          case ">":
            query = query.whereGreaterThan(fieldPath, value);
            break;
          default:
            throw new UnsupportedOperationException();
        }
        break;
      case ORDER_BY:
        OrderBy orderClause = clause.getOrderBy();
        fieldPath = convertPath(orderClause.getPath());
        switch (orderClause.getDirection()) {
          case "asc":
            query = query.orderBy(fieldPath, Direction.ASCENDING);
            break;
          case "desc":
            query = query.orderBy(fieldPath, Direction.DESCENDING);
            break;
          default:
            throw new UnsupportedOperationException();
        }
        break;
      case OFFSET:
        query = query.offset(clause.getOffset());
        break;
      case LIMIT:
        query = query.limit(clause.getLimit());
        break;
      case START_AT:
        cursor = clause.getStartAt();
        if (cursor.hasDocSnapshot()) {
          query = query.startAt(convertDocument(cursor.getDocSnapshot()));
        } else {
          query = query.startAt(convertInput(cursor.getJsonValuesList()).toArray());
        }
        break;
      case START_AFTER:
        cursor = clause.getStartAfter();
        if (cursor.hasDocSnapshot()) {
          query = query.startAfter(convertDocument(cursor.getDocSnapshot()));
        } else {
          query = query.startAfter(convertInput(cursor.getJsonValuesList()).toArray());
        }
        break;
      case END_AT:
        cursor = clause.getEndAt();
        if (cursor.hasDocSnapshot()) {
          query = query.endAt(convertDocument(cursor.getDocSnapshot()));
        } else {
          query = query.endAt(convertInput(cursor.getJsonValuesList()).toArray());
        }
        break;
      case END_BEFORE:
        cursor = clause.getEndBefore();
        if (cursor.hasDocSnapshot()) {
          query = query.endBefore(convertDocument(cursor.getDocSnapshot()));
        } else {
          query = query.endBefore(convertInput(cursor.getJsonValuesList()).toArray());
        }
        break;
      default:
        throw new UnsupportedOperationException();
    }
    return query;
  }

  private void runUpdatePathTest(UpdatePathsTest testCase) {
    doReturn(commitResponse(testCase.getRequest().getWritesCount(), 0))
        .when(firestoreMock)
        .sendRequest(commitCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    try {
      ApiFuture<WriteResult> apiCall;

      List<FieldPath> fieldPaths = convertPaths(testCase.getFieldPathsList());
      FieldPath firstField = fieldPaths.remove(0);

      List<Object> values = convertInput(testCase.getJsonValuesList());
      Object firstValue = values.remove(0);

      Object[] moreFieldsAndValues = new Object[2 * fieldPaths.size()];

      for (int i = 0; i < fieldPaths.size(); ++i) {
        moreFieldsAndValues[2 * i] = fieldPaths.get(i);
        moreFieldsAndValues[2 * i + 1] = values.get(i);
      }

      if (testCase.hasPrecondition()) {
        apiCall =
            document(testCase.getDocRefPath())
                .update(
                    convertPrecondition(testCase.getPrecondition()),
                    firstField,
                    firstValue,
                    moreFieldsAndValues);
      } else {
        apiCall =
            document(testCase.getDocRefPath()).update(firstField, firstValue, moreFieldsAndValues);
      }

      Assert.assertFalse(testCase.getIsError());

      apiCall.get();
      CommitRequest request = commitCapture.getValue();
      Assert.assertEquals(testCase.getRequest(), request);
    } catch (Exception e) {
      Assert.assertTrue(testCase.getIsError());
    }
  }

  private void runUpdateTest(UpdateTest testCase) {
    doReturn(commitResponse(testCase.getRequest().getWritesCount(), 0))
        .when(firestoreMock)
        .sendRequest(commitCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    try {
      ApiFuture<WriteResult> apiCall;

      if (testCase.hasPrecondition()) {
        apiCall =
            document(testCase.getDocRefPath())
                .update(
                    convertInput(testCase.getJsonData()),
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

  private void runDeleteTest(DeleteTest testCase) throws ExecutionException, InterruptedException {
    doReturn(commitResponse(0, testCase.getRequest().getWritesCount()))
        .when(firestoreMock)
        .sendRequest(commitCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    if (!testCase.hasPrecondition()) {
      document(testCase.getDocRefPath()).delete().get();
    } else {
      document(testCase.getDocRefPath())
          .delete(convertPrecondition(testCase.getPrecondition()))
          .get();
    }

    CommitRequest request = commitCapture.getValue();
    Assert.assertEquals(testCase.getRequest(), request);
  }

  private void runCreateTest(CreateTest testCase) {
    doReturn(commitResponse(testCase.getRequest().getWritesCount(), 0))
        .when(firestoreMock)
        .sendRequest(commitCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    try {
      ApiFuture<WriteResult> apiCall =
          document(testCase.getDocRefPath()).create(convertInput(testCase.getJsonData()));

      Assert.assertFalse(testCase.getIsError());
      apiCall.get();

      CommitRequest request = commitCapture.getValue();
      Assert.assertEquals(testCase.getRequest(), request);

    } catch (Exception e) {
      Assert.assertTrue(testCase.getIsError());
    }
  }

  private void runSetTest(SetTest testCase) throws InterruptedException {
    doReturn(commitResponse(testCase.getRequest().getWritesCount(), 0))
        .when(firestoreMock)
        .sendRequest(commitCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());
    ApiFuture<WriteResult> apiCall;

    try {
      if (testCase.hasOption() && testCase.getOption().getAll()) {
        apiCall =
            document(testCase.getDocRefPath())
                .set(convertInput(testCase.getJsonData()), SetOptions.merge());
      } else if (testCase.hasOption() && testCase.getOption().getFieldsCount() > 0) {
        apiCall =
            document(testCase.getDocRefPath())
                .set(
                    convertInput(testCase.getJsonData()),
                    SetOptions.mergeFieldPaths(convertPaths(testCase.getOption().getFieldsList())));
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

  private void runGetTest(GetTest testCase) throws ExecutionException, InterruptedException {
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
}
