/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.GceTestEnvConfig;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TransactionManager;
import com.google.cloud.spanner.TransactionManager.TransactionState;
import com.google.cloud.spanner.jdbc.AbstractSqlScriptVerifier.GenericConnection;
import com.google.cloud.spanner.jdbc.AbstractSqlScriptVerifier.GenericConnectionProvider;
import com.google.cloud.spanner.jdbc.SqlScriptVerifier.SpannerGenericConnection;
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.experimental.categories.Category;

/**
 * Base class for integration tests. This class is located in this package to be able to access
 * package-private methods of the Connection API
 */
@Category(IntegrationTest.class)
public abstract class ITAbstractSpannerTest {
  protected class ITConnectionProvider implements GenericConnectionProvider {
    public ITConnectionProvider() {}

    @Override
    public GenericConnection getConnection() {
      return SpannerGenericConnection.of(createConnection());
    }
  }

  protected interface ITConnection extends Connection {}

  private ITConnection createITConnection(ConnectionOptions options) {
    return new ITConnectionImpl(options);
  }

  protected void closeSpanner() {
    ConnectionOptions.closeSpanner();
  }

  public static class AbortInterceptor implements StatementExecutionInterceptor {
    /** We need to replicate the enum here as it is not visibible outside the connection package */
    public enum ExecutionStep {
      /** The initial execution of a statement (DML/Query) */
      EXECUTE_STATEMENT,
      /** A call to {@link ResultSet#next()} */
      CALL_NEXT_ON_RESULT_SET,
      /** Execution of the statement during a transaction retry */
      RETRY_STATEMENT,
      /** A call to {@link ResultSet#next()} during transaction retry */
      RETRY_NEXT_ON_RESULT_SET;

      static ExecutionStep of(StatementExecutionStep step) {
        return ExecutionStep.valueOf(step.name());
      }
    }

    private double probability;
    private boolean onlyInjectOnce = false;
    private final Random random = new Random();

    public AbortInterceptor(double probability) {
      Preconditions.checkArgument(probability >= 0.0D && probability <= 1.0D);
      this.probability = probability;
    }

    public void setProbability(double probability) {
      Preconditions.checkArgument(probability >= 0.0D && probability <= 1.0D);
      this.probability = probability;
    }

    /** Set this value to true to automatically set the probability to zero after an abort */
    public void setOnlyInjectOnce(boolean value) {
      this.onlyInjectOnce = value;
    }

    protected boolean shouldAbort(String statement, ExecutionStep step) {
      return probability > random.nextDouble();
    }

    @Override
    public void intercept(
        ParsedStatement statement, StatementExecutionStep step, UnitOfWork transaction) {
      if (shouldAbort(statement.getSqlWithoutComments(), ExecutionStep.of(step))) {
        // ugly hack warning: inject the aborted state into the transaction manager to simulate an
        // abort
        if (transaction instanceof ReadWriteTransaction) {
          try {
            Field field = ReadWriteTransaction.class.getDeclaredField("txManager");
            field.setAccessible(true);
            TransactionManager tx = (TransactionManager) field.get(transaction);
            Class<?> cls = Class.forName("com.google.cloud.spanner.TransactionManagerImpl");
            Class<?> cls2 =
                Class.forName("com.google.cloud.spanner.SessionPool$AutoClosingTransactionManager");
            Field delegateField = cls2.getDeclaredField("delegate");
            delegateField.setAccessible(true);
            TransactionManager delegate = (TransactionManager) delegateField.get(tx);
            Field stateField = cls.getDeclaredField("txnState");
            stateField.setAccessible(true);

            // First rollback the delegate, and then pretend it aborted.
            // We should call rollback on the delegate and not the wrapping
            // AutoClosingTransactionManager, as the latter would cause the session to be returned
            // to the session pool.
            delegate.rollback();
            stateField.set(delegate, TransactionState.ABORTED);
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
          if (onlyInjectOnce) {
            probability = 0;
          }
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.ABORTED, "Transaction was aborted by interceptor");
        }
      }
    }
  }

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static final String DEFAULT_KEY_FILE = null;
  private static Database database;

  protected static String getKeyFile() {
    return System.getProperty(GceTestEnvConfig.GCE_CREDENTIALS_FILE, DEFAULT_KEY_FILE);
  }

  protected static boolean hasValidKeyFile() {
    return getKeyFile() != null && Files.exists(Paths.get(getKeyFile()));
  }

  protected static IntegrationTestEnv getTestEnv() {
    return env;
  }

  protected static Database getDatabase() {
    return database;
  }

  /**
   * Returns a connection URL that is extracted from the given {@link SpannerOptions} and database
   * in the form
   * cloudspanner:[//host]/projects/PROJECT_ID/instances/INSTANCE_ID/databases/DATABASE_ID
   */
  static StringBuilder extractConnectionUrl(SpannerOptions options, Database database) {
    StringBuilder url = new StringBuilder("cloudspanner:");
    if (options.getHost() != null) {
      url.append(options.getHost().substring(options.getHost().indexOf(':') + 1));
    }
    url.append("/").append(database.getId().getName());
    return url;
  }

  @BeforeClass
  public static void setup() throws IOException, InterruptedException, ExecutionException {
    database = env.getTestHelper().createTestDatabase();
  }

  /**
   * Creates a new default connection to a test database. Use the method {@link
   * ITAbstractSpannerTest#appendConnectionUri(StringBuilder)} to append additional connection
   * options to the connection URI.
   *
   * @return the newly opened connection.
   */
  public ITConnection createConnection() {
    return createConnection(
        Collections.<StatementExecutionInterceptor>emptyList(),
        Collections.<TransactionRetryListener>emptyList());
  }

  public ITConnection createConnection(AbortInterceptor interceptor) {
    return createConnection(
        Arrays.<StatementExecutionInterceptor>asList(interceptor),
        Collections.<TransactionRetryListener>emptyList());
  }

  public ITConnection createConnection(
      AbortInterceptor interceptor, TransactionRetryListener transactionRetryListener) {
    return createConnection(
        Arrays.<StatementExecutionInterceptor>asList(interceptor),
        Arrays.<TransactionRetryListener>asList(transactionRetryListener));
  }

  /**
   * Creates a new default connection to a test database. Use the method {@link
   * ITAbstractSpannerTest#appendConnectionUri(StringBuilder)} to append additional connection
   * options to the connection URI.
   *
   * @param interceptors Interceptors that should be executed after each statement
   * @param transactionRetryListeners Transaction retry listeners that should be added to the {@link
   *     Connection}
   * @return the newly opened connection.
   */
  public ITConnection createConnection(
      List<StatementExecutionInterceptor> interceptors,
      List<TransactionRetryListener> transactionRetryListeners) {
    StringBuilder url =
        extractConnectionUrl(getTestEnv().getTestHelper().getOptions(), getDatabase());
    appendConnectionUri(url);
    ConnectionOptions.Builder builder =
        ConnectionOptions.newBuilder()
            .setUri(url.toString())
            .setStatementExecutionInterceptors(interceptors);
    if (hasValidKeyFile()) {
      builder.setCredentialsUrl(getKeyFile());
    }
    ConnectionOptions options = builder.build();
    ITConnection connection = createITConnection(options);
    for (TransactionRetryListener listener : transactionRetryListeners) {
      connection.addTransactionRetryListener(listener);
    }
    return connection;
  }

  protected void appendConnectionUri(StringBuilder uri) {}

  /**
   * Override this method to instruct the test to create a default test table in the form:
   *
   * <pre>
   * CREATE TABLE TEST (ID INT64 NOT NULL, NAME STRING(100) NOT NULL) PRIMARY KEY (ID)
   * </pre>
   *
   * Note that the table is not re-created for each test case, but is preserved between test cases.
   * It is the responsibility of the test class to either empty the table at the end of each test
   * case, or keep track of the state of the test table and execute the test cases in a specific
   * order.
   *
   * @return <code>true</code> if the default test table should be created.
   */
  protected boolean doCreateDefaultTestTable() {
    return false;
  }

  @Before
  public void createTestTable() throws Exception {
    if (doCreateDefaultTestTable()) {
      try (Connection connection = createConnection()) {
        connection.setAutocommit(true);
        if (!tableExists(connection, "TEST")) {
          connection.setAutocommit(false);
          connection.startBatchDdl();
          connection.execute(
              Statement.of(
                  "CREATE TABLE TEST (ID INT64 NOT NULL, NAME STRING(100) NOT NULL) PRIMARY KEY (ID)"));
          connection.runBatch();
        }
      }
    }
  }

  protected boolean tableExists(Connection connection, String table) {
    Preconditions.checkArgument(!Strings.isNullOrEmpty(table));
    try (ResultSet rs =
        connection.executeQuery(
            Statement.newBuilder(
                    "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE UPPER(TABLE_NAME)=@table_name")
                .bind("table_name")
                .to(table.toUpperCase())
                .build())) {
      while (rs.next()) {
        return true;
      }
    }
    return false;
  }

  protected boolean indexExists(Connection connection, String table, String index) {
    Preconditions.checkArgument(!Strings.isNullOrEmpty(index));
    try (ResultSet rs =
        connection.executeQuery(
            Statement.newBuilder(
                    "SELECT INDEX_NAME FROM INFORMATION_SCHEMA.INDEXES WHERE UPPER(TABLE_NAME)=@table_name AND UPPER(INDEX_NAME)=@index_name")
                .bind("table_name")
                .to(table)
                .bind("index_name")
                .to(index.toUpperCase())
                .build())) {
      while (rs.next()) {
        return true;
      }
    }
    return false;
  }
}
