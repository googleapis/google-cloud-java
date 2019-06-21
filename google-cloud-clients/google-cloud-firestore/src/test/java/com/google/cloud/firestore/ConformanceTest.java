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

import static com.google.cloud.firestore.ConformanceConversions.convertInput;
import static com.google.cloud.firestore.ConformanceConversions.convertPath;
import static com.google.cloud.firestore.ConformanceConversions.convertPaths;
import static com.google.cloud.firestore.ConformanceConversions.convertPrecondition;
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
import com.google.cloud.firestore.conformance.TestDefinition.ListenTest;
import com.google.cloud.firestore.conformance.TestDefinition.OrderBy;
import com.google.cloud.firestore.conformance.TestDefinition.SetTest;
import com.google.cloud.firestore.conformance.TestDefinition.Snapshot;
import com.google.cloud.firestore.conformance.TestDefinition.UpdatePathsTest;
import com.google.cloud.firestore.conformance.TestDefinition.UpdateTest;
import com.google.cloud.firestore.conformance.TestDefinition.Where;
import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.common.base.Preconditions;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.ListenRequest;
import com.google.firestore.v1.ListenResponse;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.Value;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Message;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
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

  private static final String TEST_FILE =
      "/com/google/cloud/firestore/conformance/test-suite.binproto";

  /** Excluded tests by test description. */
  private static final Set<String> excludedTests = Collections.emptySet();

  /** If non-empty, only runs tests included in this set. */
  private static final Set<String> includedTests = Collections.emptySet();

  /** If true, prints debug information to System.out. */
  private static final boolean DEBUG_MODE = !includedTests.isEmpty();

  public ConformanceTest() {}

  /** Generate the test suite based on the tests defined in test_data.binprotos. */
  public static TestSuite suite() throws IOException {
    TestSuite suite = new TestSuite();
    final TestDefinition.TestSuite testSuite = parseTests();
    for (Test test : initTests(testSuite)) {
      suite.addTest(test);
    }
    return suite;
  }

  private static List<Test> initTests(TestDefinition.TestSuite testSuite) {
    final List<Test> tests = new ArrayList<>();
    for (final TestDefinition.Test testDefinition : testSuite.getTestsList()) {
      if (!includedTests.isEmpty() && !includedTests.contains(testDefinition.getDescription())
          || excludedTests.contains(testDefinition.getDescription())) {
        continue;
      }
      final Test test = buildTest(testDefinition);
      MockitoAnnotations.initMocks(test);
      tests.add(test);
    }

    return tests;
  }

  /** Reads the test definition from the Proto file. */
  private static TestDefinition.TestSuite parseTests() throws IOException {
    final InputStream is = ConformanceTest.class.getResourceAsStream(TEST_FILE);
    return TestDefinition.TestSuite.parseFrom(is);
  }

  /** Returns the test case for the provided test definition. */
  private static Test buildTest(final TestDefinition.Test td) {
    switch (td.getTestCase()) {
      case GET:
        return new ConformanceGetTestRunner(td.getDescription(), td.getGet());
      case CREATE:
        return new ConformanceCreateTestRunner(td.getDescription(), td.getCreate());
      case SET:
        return new ConformanceSetTestRunner(td.getDescription(), td.getSet());
      case UPDATE:
        return new ConformanceUpdateTestRunner(td.getDescription(), td.getUpdate());
      case UPDATE_PATHS:
        return new ConformanceUpdatePathsTestRunner(td.getDescription(), td.getUpdatePaths());
      case DELETE:
        return new ConformanceDeleteTestRunner(td.getDescription(), td.getDelete());
      case QUERY:
        return new ConformanceQueryTestRunner(td.getDescription(), td.getQuery());
      case LISTEN:
        return new ConformanceListenTestRunner(td.getDescription(), td.getListen());
      default:
        throw new UnsupportedOperationException("Unknown test case type: " + td.getTestCase());
    }
  }

  private abstract static class BaseConformanceTestRunner<T> implements Test, Describable {
    private static final String DEBUG_MESSAGE_FORMAT =
        "--- Test Description -----------------------------------------------------------%n"
            + "%s%n"
            + "--- Test Case ------------------------------------------------------------------%n"
            + "%s%n"
            + "--------------------------------------------------------------------------------%n";

    protected static final String ROOT_COLLECTION_PATH =
        "projects/projectID/databases/(default)/documents/";

    private final Description description;
    protected final T testParameters;
    protected final FirestoreImpl firestore;

    protected BaseConformanceTestRunner(final String description, final T testParameters) {
      this.description =
          Description.createTestDescription(ConformanceTest.class.getName(), description);
      this.testParameters = testParameters;
      ScheduledExecutorService firestoreExecutor = Executors.newSingleThreadScheduledExecutor();
      FirestoreRpc firestoreRpc = Mockito.mock(FirestoreRpc.class);
      when(firestoreRpc.getExecutor()).thenReturn(firestoreExecutor);
      this.firestore =
          Mockito.spy(
              new FirestoreImpl(
                  FirestoreOptions.newBuilder().setProjectId("projectID").build(), firestoreRpc));
    }

    @Override
    public final Description getDescription() {
      return description;
    }

    @Override
    public final int countTestCases() {
      return 1;
    }

    @Override
    public final void run(TestResult testResult) {
      testResult.startTest(this);
      testResult.runProtected(
          this,
          new Protectable() {
            @Override
            public void protect() throws Throwable {
              if (DEBUG_MODE) {
                System.out.printf(DEBUG_MESSAGE_FORMAT, description, testParameters);
              }
              runTest();
            }
          });
      testResult.endTest(this);
    }

    public abstract void runTest() throws Throwable;

    @Override
    public final String toString() {
      return getClass().getSimpleName() + "{" + "description=" + description.getDisplayName() + '}';
    }

    /** Creates a document reference from an absolute path. */
    final DocumentReference document(final String absolutePath) {
      Preconditions.checkState(absolutePath.startsWith(ROOT_COLLECTION_PATH));
      return firestore.document(absolutePath.substring(ROOT_COLLECTION_PATH.length()));
    }

    /** Creates a collection reference from an absolute path. */
    final CollectionReference collection(final String absolutePath) {
      Preconditions.checkState(absolutePath.startsWith(ROOT_COLLECTION_PATH));
      return firestore.collection(absolutePath.substring(ROOT_COLLECTION_PATH.length()));
    }
  }

  private static final class ConformanceGetTestRunner extends BaseConformanceTestRunner<GetTest> {

    @Captor private ArgumentCaptor<BatchGetDocumentsRequest> getAllCapture;
    @Captor private ArgumentCaptor<ApiStreamObserver<AbstractMessage>> streamObserverCapture;

    private ConformanceGetTestRunner(String description, GetTest testParameters) {
      super(description, testParameters);
    }

    @Override
    public void runTest() throws Throwable {
      doAnswer(getAllResponse(Collections.<String, Value>emptyMap()))
          .when(firestore)
          .streamRequest(
              getAllCapture.capture(),
              streamObserverCapture.capture(),
              Matchers.<ServerStreamingCallable>any());

      document(testParameters.getDocRefPath()).get().get();

      BatchGetDocumentsRequest request = getAllCapture.getValue();

      Assert.assertEquals(1, request.getDocumentsCount());
      Assert.assertEquals(testParameters.getRequest().getName(), request.getDocuments(0));
    }
  }

  private static final class ConformanceCreateTestRunner
      extends BaseConformanceTestRunner<CreateTest> {

    @Captor private ArgumentCaptor<CommitRequest> commitCapture;

    private ConformanceCreateTestRunner(String description, CreateTest testParameters) {
      super(description, testParameters);
    }

    @Override
    public void runTest() {
      doReturn(commitResponse(testParameters.getRequest().getWritesCount(), 0))
          .when(firestore)
          .sendRequest(commitCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

      try {
        ApiFuture<WriteResult> apiCall =
            document(testParameters.getDocRefPath())
                .create(convertInput(testParameters.getJsonData()));

        Assert.assertFalse(testParameters.getIsError());
        apiCall.get();

        CommitRequest request = commitCapture.getValue();
        Assert.assertEquals(testParameters.getRequest(), request);

      } catch (Exception e) {
        Assert.assertTrue(testParameters.getIsError());
      }
    }
  }

  private static final class ConformanceSetTestRunner extends BaseConformanceTestRunner<SetTest> {

    @Captor private ArgumentCaptor<CommitRequest> commitCapture;

    private ConformanceSetTestRunner(String description, SetTest testParameters) {
      super(description, testParameters);
    }

    @Override
    public void runTest() {
      doReturn(commitResponse(testParameters.getRequest().getWritesCount(), 0))
          .when(firestore)
          .sendRequest(commitCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());
      ApiFuture<WriteResult> apiCall;

      try {
        if (testParameters.hasOption() && testParameters.getOption().getAll()) {
          apiCall =
              document(testParameters.getDocRefPath())
                  .set(convertInput(testParameters.getJsonData()), SetOptions.merge());
        } else if (testParameters.hasOption() && testParameters.getOption().getFieldsCount() > 0) {
          apiCall =
              document(testParameters.getDocRefPath())
                  .set(
                      convertInput(testParameters.getJsonData()),
                      SetOptions.mergeFieldPaths(
                          convertPaths(testParameters.getOption().getFieldsList())));
        } else {
          apiCall =
              document(testParameters.getDocRefPath())
                  .set(convertInput(testParameters.getJsonData()));
        }

        Assert.assertFalse(testParameters.getIsError());
        apiCall.get();

        CommitRequest request = commitCapture.getValue();
        Assert.assertEquals(testParameters.getRequest(), request);
      } catch (Exception e) {
        Assert.assertTrue(testParameters.getIsError());
      }
    }
  }

  private static final class ConformanceUpdateTestRunner
      extends BaseConformanceTestRunner<UpdateTest> {

    @Captor private ArgumentCaptor<CommitRequest> commitCapture;

    private ConformanceUpdateTestRunner(String description, UpdateTest testParameters) {
      super(description, testParameters);
    }

    @Override
    public void runTest() {
      doReturn(commitResponse(testParameters.getRequest().getWritesCount(), 0))
          .when(firestore)
          .sendRequest(commitCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

      try {
        ApiFuture<WriteResult> apiCall;

        if (testParameters.hasPrecondition()) {
          apiCall =
              document(testParameters.getDocRefPath())
                  .update(
                      convertInput(testParameters.getJsonData()),
                      convertPrecondition(testParameters.getPrecondition()));
        } else {
          apiCall =
              document(testParameters.getDocRefPath())
                  .update(convertInput(testParameters.getJsonData()));
        }

        Assert.assertFalse(testParameters.getIsError());

        apiCall.get();
        CommitRequest request = commitCapture.getValue();
        Assert.assertEquals(testParameters.getRequest(), request);
      } catch (Exception e) {
        Assert.assertTrue(testParameters.getIsError());
      }
    }
  }

  private static final class ConformanceUpdatePathsTestRunner
      extends BaseConformanceTestRunner<UpdatePathsTest> {

    @Captor private ArgumentCaptor<CommitRequest> commitCapture;

    private ConformanceUpdatePathsTestRunner(String description, UpdatePathsTest testParameters) {
      super(description, testParameters);
    }

    @Override
    public void runTest() {
      doReturn(commitResponse(testParameters.getRequest().getWritesCount(), 0))
          .when(firestore)
          .sendRequest(commitCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

      try {
        ApiFuture<WriteResult> apiCall;

        List<FieldPath> fieldPaths = convertPaths(testParameters.getFieldPathsList());
        FieldPath firstField = fieldPaths.remove(0);

        List<Object> values = convertInput(testParameters.getJsonValuesList());
        Object firstValue = values.remove(0);

        Object[] moreFieldsAndValues = new Object[2 * fieldPaths.size()];

        for (int i = 0; i < fieldPaths.size(); ++i) {
          moreFieldsAndValues[2 * i] = fieldPaths.get(i);
          moreFieldsAndValues[2 * i + 1] = values.get(i);
        }

        if (testParameters.hasPrecondition()) {
          apiCall =
              document(testParameters.getDocRefPath())
                  .update(
                      convertPrecondition(testParameters.getPrecondition()),
                      firstField,
                      firstValue,
                      moreFieldsAndValues);
        } else {
          apiCall =
              document(testParameters.getDocRefPath())
                  .update(firstField, firstValue, moreFieldsAndValues);
        }

        Assert.assertFalse(testParameters.getIsError());

        apiCall.get();
        CommitRequest request = commitCapture.getValue();
        Assert.assertEquals(testParameters.getRequest(), request);
      } catch (Exception e) {
        Assert.assertTrue(testParameters.getIsError());
      }
    }
  }

  private static final class ConformanceDeleteTestRunner
      extends BaseConformanceTestRunner<DeleteTest> {

    @Captor private ArgumentCaptor<CommitRequest> commitCapture;

    private ConformanceDeleteTestRunner(String description, DeleteTest testParameters) {
      super(description, testParameters);
    }

    @Override
    public void runTest() throws Throwable {
      doReturn(commitResponse(0, testParameters.getRequest().getWritesCount()))
          .when(firestore)
          .sendRequest(commitCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

      if (!testParameters.hasPrecondition()) {
        document(testParameters.getDocRefPath()).delete().get();
      } else {
        document(testParameters.getDocRefPath())
            .delete(convertPrecondition(testParameters.getPrecondition()))
            .get();
      }

      CommitRequest request = commitCapture.getValue();
      Assert.assertEquals(testParameters.getRequest(), request);
    }
  }

  private static final class ConformanceQueryTestRunner
      extends BaseConformanceTestRunner<TestDefinition.QueryTest> {

    @Captor private ArgumentCaptor<RunQueryRequest> runQueryCapture;
    @Captor private ArgumentCaptor<ApiStreamObserver<AbstractMessage>> streamObserverCapture;

    private ConformanceQueryTestRunner(
        String description, TestDefinition.QueryTest testParameters) {
      super(description, testParameters);
    }

    @Override
    public void runTest() {
      doAnswer(queryResponse())
          .when(firestore)
          .streamRequest(
              runQueryCapture.capture(),
              streamObserverCapture.capture(),
              Matchers.<ServerStreamingCallable>any());

      Query query = collection(testParameters.getCollPath());

      try {
        for (Clause clause : testParameters.getClausesList()) {
          query = applyClause(query, clause);
        }

        ApiFuture<QuerySnapshot> apiCall = query.get();
        Assert.assertFalse(testParameters.getIsError());

        apiCall.get();
        RunQueryRequest request = runQueryCapture.getValue();
        Assert.assertEquals(testParameters.getQuery(), request.getStructuredQuery());
      } catch (Exception e) {
        Assert.assertTrue(testParameters.getIsError());
      }
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

    /** Converts a DocumentSnapshot proto into a DocumentSnapshot. */
    private DocumentSnapshot convertDocument(DocSnapshot snapshot) {
      return DocumentSnapshot.fromObject(
          firestore,
          document(snapshot.getPath()),
          convertInput(snapshot.getJsonData()),
          NO_DELETES);
    }
  }

  private static final class ConformanceListenTestRunner
      extends BaseConformanceTestRunner<ListenTest> {

    @Captor private ArgumentCaptor<ApiStreamObserver<AbstractMessage>> streamObserverCapture;
    @Mock private ApiStreamObserver<ListenRequest> noOpRequestObserver;

    private Query watchQuery;

    private ConformanceListenTestRunner(
        String description, TestDefinition.ListenTest testParameters) {
      super(description, testParameters);
      watchQuery = collection(ROOT_COLLECTION_PATH + "C").orderBy("a");
    }

    @Override
    public void runTest() throws Throwable {
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
          .when(firestore)
          .streamRequest(
              streamObserverCapture.capture(), Matchers.any(BidiStreamingCallable.class));

      final List<Snapshot> expectedSnapshots = new ArrayList<>(testParameters.getSnapshotsList());

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
                        if (!testParameters.getIsError()) {
                          testCaseFinished.set(null);
                        }
                      }
                    } else { // Error case
                      Assert.assertNotNull(error);
                      Assert.assertTrue(expectedSnapshots.isEmpty());
                      Assert.assertTrue(testParameters.getIsError());
                      testCaseFinished.set(null);
                    }
                  } catch (AssertionError e) {
                    testCaseFinished.setException(e);
                  }
                }
              });

      testCaseStarted.get();

      for (ListenResponse response : testParameters.getResponsesList()) {
        streamObserverCapture.getValue().onNext(response);
      }

      testCaseFinished.get();
      registration.remove();
    }

    /** Converts a test snapshot to its API representation. */
    private QuerySnapshot convertQuerySnapshot(Snapshot testSnapshot) {
      Timestamp readTime = Timestamp.fromProto(testSnapshot.getReadTime());

      final List<QueryDocumentSnapshot> documentSnapshots = new ArrayList<>();

      for (Document document : testSnapshot.getDocsList()) {
        documentSnapshots.add(
            QueryDocumentSnapshot.fromDocument(
                firestore, Timestamp.fromProto(testSnapshot.getReadTime()), document));
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
                firestore,
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

    /** Converts a Kind into a DocumentChange.Type */
    private static DocumentChange.Type convertKind(Kind kind) {
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
  }
}
