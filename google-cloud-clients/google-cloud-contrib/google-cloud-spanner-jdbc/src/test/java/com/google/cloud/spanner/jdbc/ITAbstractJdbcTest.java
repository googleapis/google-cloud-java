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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Category;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.GceTestEnvConfig;
import com.google.cloud.spanner.Instance;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceConfig;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.SpannerOptions.Builder;
import com.google.cloud.spanner.jdbc.AbstractSqlScriptVerifier.GenericConnectionProvider;
import com.google.cloud.spanner.jdbc.JdbcSqlScriptVerifier.JdbcGenericConnection;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;

/** Base class for integration tests for the JDBC driver. */
@Category(IntegrationTest.class)
public class ITAbstractJdbcTest {
  protected class ITJdbcConnectionProvider implements GenericConnectionProvider {
    public ITJdbcConnectionProvider() {}

    @Override
    public JdbcGenericConnection getConnection() {
      try {
        return JdbcGenericConnection.of(createConnection());
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private static final String CLOUDSPANNER_HOST = "spanner.googleapis.com";
  private static final String DEFAULT_REGION = "regional-us-east4";

  private static final String DEFAULT_PROJECT_PLACEHOLDER = "DEFAULT_PROJECT_ID";
  private static final String DEFAULT_KEY_FILE = "api_key";
  protected static final String DATABASE_ID = "test-database";

  private static Spanner spanner;
  protected static String projectId;
  protected static String translatedProjectId;
  protected static String instanceId;
  protected static DatabaseId databaseId;
  protected static String credentialsPath;

  public static String getHost() {
    return System.getProperty(GceTestEnvConfig.GCE_SERVER_URL, CLOUDSPANNER_HOST);
  }

  public static String getKeyFile() {
    return System.getProperty(GceTestEnvConfig.GCE_CREDENTIALS_FILE, DEFAULT_KEY_FILE);
  }

  public static String getProject() {
    return System.getProperty(GceTestEnvConfig.GCE_PROJECT_ID, DEFAULT_PROJECT_PLACEHOLDER);
  }

  protected static Spanner getSpanner() {
    return spanner;
  }

  protected static DatabaseId getDatabaseId() {
    return databaseId;
  }

  protected DatabaseClient getDatabaseClient() {
    return spanner.getDatabaseClient(getDatabaseId());
  }

  protected DatabaseAdminClient getDatabaseAdminClient() {
    return spanner.getDatabaseAdminClient();
  }

  @BeforeClass
  public static void setup() throws IOException, InterruptedException, ExecutionException {
    createSpanner();
    createInstance();
    createDatabase();
  }

  private static void createSpanner() throws IOException {
    // generate a unique instance id for this test run
    Random rnd = new Random();
    instanceId = "test-instance-" + rnd.nextInt(1000000);
    credentialsPath = getKeyFile();
    projectId = getProject();
    translatedProjectId = projectId;
    CredentialsService credentialsService = CredentialsService.INSTANCE;
    GoogleCredentials credentials;
    if (Files.exists(Paths.get(credentialsPath))) {
      credentials = credentialsService.createCredentials(credentialsPath);
    } else {
      credentials = GoogleCredentials.getApplicationDefault();
    }
    if (translatedProjectId.equalsIgnoreCase(DEFAULT_PROJECT_PLACEHOLDER)) {
      translatedProjectId = ConnectionOptions.getDefaultProjectId(credentials);
    }
    Builder builder = SpannerOptions.newBuilder();
    builder.setProjectId(translatedProjectId);
    builder.setCredentials(credentials);
    builder.setHost("https://" + getHost());

    SpannerOptions options = builder.build();
    spanner = options.getService();
  }

  @AfterClass
  public static void teardown() {
    cleanUpDatabase();
    cleanUpInstance();
    spanner.close();
  }

  private static void createInstance() throws InterruptedException, ExecutionException {
    InstanceAdminClient instanceAdminClient = spanner.getInstanceAdminClient();
    InstanceConfig config = instanceAdminClient.getInstanceConfig(DEFAULT_REGION);
    Instance instance =
        instanceAdminClient.newInstanceBuilder(InstanceId.of(translatedProjectId, instanceId))
            .setDisplayName("Test Instance").setInstanceConfigId(config.getId()).setNodeCount(1)
            .build();
    OperationFuture<Instance, CreateInstanceMetadata> createInstance =
        instanceAdminClient.createInstance(instance);
    instance = createInstance.get();
  }

  private static void createDatabase() throws InterruptedException, ExecutionException {
    OperationFuture<Database, CreateDatabaseMetadata> createDatabase = spanner
        .getDatabaseAdminClient().createDatabase(instanceId, DATABASE_ID, Arrays.<String>asList());
    createDatabase.get();
    databaseId = DatabaseId.of(InstanceId.of(translatedProjectId, instanceId), DATABASE_ID);
  }

  private static void cleanUpInstance() {
    spanner.getInstanceAdminClient().deleteInstance(instanceId);
  }

  private static void cleanUpDatabase() {
    spanner.getDatabaseAdminClient().dropDatabase(instanceId, DATABASE_ID);
  }

  /**
   * Creates a new default JDBC connection to a test database. Use the method
   * {@link ITAbstractJdbcTest#appendConnectionUri(StringBuilder)} to append additional connection
   * options to the connection URI.
   *
   * @return The newly opened JDBC connection.
   */
  public CloudSpannerJdbcConnection createConnection() throws SQLException {
    StringBuilder url = new StringBuilder("jdbc:cloudspanner://");
    url.append(getHost());
    url.append("/projects/").append(projectId);
    url.append("/instances/").append(instanceId);
    url.append("/databases/").append(DATABASE_ID);
    if(Files.exists(Paths.get(credentialsPath))) {
      url.append(";credentials=").append(credentialsPath);
    }
    appendConnectionUri(url);

    return DriverManager.getConnection(url.toString()).unwrap(CloudSpannerJdbcConnection.class);
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
   * @return true if the default test table should be created.
   */
  protected boolean doCreateDefaultTestTable() {
    return false;
  }

  /**
   * Override this method to instruct the test to create the standard example Music data model.
   */
  protected boolean doCreateMusicTables() {
    return false;
  }

  @Before
  public void createTestTable() throws SQLException {
    if (doCreateDefaultTestTable()) {
      try (Connection connection = createConnection()) {
        connection.setAutoCommit(true);
        if (!tableExists(connection, "TEST")) {
          connection.setAutoCommit(false);
          connection.createStatement().execute("START BATCH DDL");
          connection.createStatement().execute(
              "CREATE TABLE TEST (ID INT64 NOT NULL, NAME STRING(100) NOT NULL) PRIMARY KEY (ID)");
          connection.createStatement().execute("RUN BATCH");
        }
      }
    }
  }

  @Before
  public void createMusicTables() throws SQLException {
    if (doCreateMusicTables()) {
      try (Connection connection = createConnection()) {
        connection.setAutoCommit(true);
        if (!tableExists(connection, "Singers")) {
          for (String statement : readStatementsFromFile("CreateMusicTables.sql")) {
            connection.createStatement().execute(statement);
          }
        }
      }
    }
  }

  protected boolean tableExists(Connection connection, String table) throws SQLException {
    try (ResultSet rs = connection.getMetaData().getTables("", "", table, null)) {
      if (rs.next()) {
        if (rs.getString("TABLE_NAME").equalsIgnoreCase(table)) {
          return true;
        }
      }
    }
    return false;
  }

  protected boolean indexExists(Connection connection, String table, String index)
      throws SQLException {
    Preconditions.checkArgument(!Strings.isNullOrEmpty(index));
    try (PreparedStatement ps = connection.prepareStatement(
        "SELECT INDEX_NAME FROM INFORMATION_SCHEMA.INDEXES WHERE UPPER(TABLE_NAME)=? AND UPPER(INDEX_NAME)=?")) {
      ps.setString(1, table);
      ps.setString(2, index);
      try (ResultSet rs = ps.executeQuery()) {
        return rs.next();
      }
    }
  }

  List<String> readStatementsFromFile(String filename) {
    File file = new File(getClass().getResource(filename).getFile());
    StringBuilder builder = new StringBuilder();
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        builder.append(line).append("\n");
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    String script = builder.toString().replaceAll(StatementParserTest.COPYRIGHT_PATTERN, "");
    String[] array = script.split(";");
    List<String> res = new ArrayList<>(array.length);
    for (String statement : array) {
      if (statement != null && statement.trim().length() > 0) {
        res.add(statement);
      }
    }
    return res;
  }

}
