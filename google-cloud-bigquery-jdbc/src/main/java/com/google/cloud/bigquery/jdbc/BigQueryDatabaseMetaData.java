/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.api.gax.paging.Page;
import com.google.cloud.Tuple;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetListOption;
import com.google.cloud.bigquery.BigQuery.RoutineListOption;
import com.google.cloud.bigquery.BigQuery.TableListOption;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Field.Mode;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Routine;
import com.google.cloud.bigquery.RoutineArgument;
import com.google.cloud.bigquery.RoutineId;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLDataType;
import com.google.cloud.bigquery.StandardSQLField;
import com.google.cloud.bigquery.StandardSQLTableType;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/**
 * An implementation of {@link java.sql.DatabaseMetaData}. This interface is implemented by driver
 * vendors to let users know the capabilities of a Database Management System (DBMS) in combination
 * with the driver based on JDBC™ technology ("JDBC driver") that is used with it.
 *
 * @see BigQueryStatement
 */
// TODO(neenu): test and verify after post MVP implementation.
class BigQueryDatabaseMetaData implements DatabaseMetaData {
  final BigQueryJdbcCustomLogger LOG = new BigQueryJdbcCustomLogger(this.toString());
  private static final String DATABASE_PRODUCT_NAME = "Google BigQuery";
  private static final String DATABASE_PRODUCT_VERSION = "2.0";
  private static final String DRIVER_NAME = "GoogleJDBCDriverForGoogleBigQuery";
  private static final String DRIVER_DEFAULT_VERSION = "0.0.0";
  private static final String SCHEMA_TERM = "Dataset";
  private static final String CATALOG_TERM = "Project";
  private static final String PROCEDURE_TERM = "Procedure";
  private static final String GET_PRIMARY_KEYS_SQL = "DatabaseMetaData_GetPrimaryKeys.sql";
  private static final String GET_IMPORTED_KEYS_SQL = "DatabaseMetaData_GetImportedKeys.sql";
  private static final String GET_EXPORTED_KEYS_SQL = "DatabaseMetaData_GetExportedKeys.sql";
  private static final String GET_CROSS_REFERENCE_SQL = "DatabaseMetaData_GetCrossReference.sql";
  private static final int API_EXECUTOR_POOL_SIZE = 50;
  private static final int DEFAULT_PAGE_SIZE = 500;
  private static final int DEFAULT_QUEUE_CAPACITY = 5000;
  // Declared package-private for testing.
  static final String GOOGLE_SQL_QUOTED_IDENTIFIER = "`";
  // Does not include SQL:2003 Keywords as per JDBC spec.
  // https://en.wikipedia.org/wiki/List_of_SQL_reserved_words
  static final String GOOGLE_SQL_RESERVED_KEYWORDS =
      "ASC,ASSERT_ROWS_MODIFIED,DESC,ENUM,EXCLUDE,FOLLOWING,HASH,IF,"
          + "IGNORE,LIMIT,LOOKUP,NULLS,PRECEDING,PROTO,QUALIFY,RESPECT,STRUCT,UNBOUNDED";
  static final String GOOGLE_SQL_NUMERIC_FNS =
      "ABS,ACOS,ACOSH,ASIN,ASINH,ATAN,ATAN2,ATANH,CBRT,CEIL,CEILING,COS"
          + ",COSH,COSINE_DISTANCE,COT,COTH,CSC,CSCH,DIV,EXP,EUCLIDEAN_DISTANCE,FLOOR"
          + ",GREATEST,IS_INF,LEAST,LN,LOG,LOG10,MOD,POW,RAND,RANGE_BUCKET,ROUND,"
          + ",SAFE_ADD,SAFE_DIVIDE,SAFE_MULTIPLY,SAFE_NEGATE,SAFE_SUBTRACT,SEC,SECH,"
          + "SIGN,SIN,SINH,SQRT,TAN,TANH,TRUNC";
  static final String GOOGLE_SQL_STRING_FNS =
      "ASCII,BYTE_LENGTH,CHAR_LENGTH,CHARACTER_LENGTH,CHR,CODE_POINTS_TO_BYTES,"
          + "CODE_POINTS_TO_STRING,COLLATE,CONCAT,CONTAINS_SUBSTR,EDIT_DISTANCE,ENDS_WITH,"
          + "FORMAT,FROM_BASE32,FROM_BASE64,FROM_HEX,INITCAP,INSTR,LEFT,LENGTH,LOWER,"
          + "LPAD,LTRIM,NORMALIZ,NORMALIZE_AND_CASEFOLD,OCTET_LENGTH,REGEXP_CONTAINS,"
          + "REGEXP_EXTRACT,REGEXP_EXTRACT_ALL,REGEXP_INSTR,REGEXP_REPLACE,REGEXP_SUBSTR,"
          + "REPEAT,REPLACE,REVERSE,RIGHT,RPAD,RTRIM,SAFE_CONVERT_BYTES_TO_STRING,SOUNDEX,"
          + "SPLIT,STARTS_WITH,STRPOS,SUBSTR,SUBSTRING,TO_BASE32,TO_BASE64,TO_CODE_POINTS,"
          + "TO_HEX,TRANSLATE,TRIMunicode,UNICODE,UPPER";
  static final String GOOGLE_SQL_TIME_DATE_FNS =
      "DATE,DATE_ADD,DATE_BUCKET,DATE_DIFF,DATE_FROM_UNIX_DATE,"
          + "DATE_SUB,DATE_TRUNC,DATETIME,DATETIME_ADD.,DATETIME_BUCKET,"
          + "DATETIME_DIFF,DATETIME_SUB,DATETIME_TRUNC,CURRENT_DATE,CURRENT_DATETIME,"
          + "CURRENT_TIME,CURRENT_TIMESTAMP,CURRENT_TIME,EXTRACT,FORMAT_TIME,PARSE_TIME,"
          + "TIME,TIME_ADD,TIME_DIFF,TIME_SUB,TIME_TRUNC,CURRENT_TIMESTAMP,EXTRACT,"
          + "FORMAT_TIMESTAMP,GENERATE_TIMESTAMP_ARRAY,PARSE_TIMESTAMP,TIMESTAMP,"
          + "TIMESTAMP_ADD,TIMESTAMP_DIFF,TIMESTAMP_MICROS,TIMESTAMP_MILLIS,TIMESTAMP_SECONDS,"
          + "TIMESTAMP_SUB,TIMESTAMP_TRUNC,UNIX_MICROS,UNIX_MILLIS,UNIX_SECONDS";
  static final String GOOGLE_SQL_ESCAPE = "\\";
  static final String GOOGLE_SQL_CATALOG_SEPARATOR = ".";
  static final int GOOGLE_SQL_MAX_COL_NAME_LEN = 300;
  static final int GOOGLE_SQL_MAX_COLS_PER_TABLE = 10000;

  String URL;
  BigQueryConnection connection;
  private final BigQueryStatement statement;
  private final BigQuery bigquery;
  private final int metadataFetchThreadCount;
  private static final AtomicReference<String> parsedDriverVersion = new AtomicReference<>(null);
  private static final AtomicReference<Integer> parsedDriverMajorVersion =
      new AtomicReference<>(null);
  private static final AtomicReference<Integer> parsedDriverMinorVersion =
      new AtomicReference<>(null);

  BigQueryDatabaseMetaData(BigQueryConnection connection) throws SQLException {
    this.URL = connection.getConnectionUrl();
    this.connection = connection;
    this.statement = connection.createStatement().unwrap(BigQueryStatement.class);
    this.bigquery = connection.getBigQuery();
    this.metadataFetchThreadCount = connection.getMetadataFetchThreadCount();
    loadDriverVersionProperties();
  }

  @Override
  public boolean allProceduresAreCallable() {
    // Returns false because BigQuery's IAM permissions can allow a user
    // to discover a procedure's existence without having rights to execute it.
    return false;
  }

  @Override
  public boolean allTablesAreSelectable() {
    // Returns true to ensure maximum compatibility with client applications
    // that expect a positive response to discover and list all available tables.
    return true;
  }

  @Override
  public String getURL() {
    return this.URL;
  }

  @Override
  public String getUserName() {
    return null;
  }

  @Override
  public boolean isReadOnly() {
    return false;
  }

  @Override
  public boolean nullsAreSortedHigh() {
    return false;
  }

  @Override
  public boolean nullsAreSortedLow() {
    return false;
  }

  @Override
  public boolean nullsAreSortedAtStart() {
    return false;
  }

  @Override
  public boolean nullsAreSortedAtEnd() {
    return false;
  }

  @Override
  public String getDatabaseProductName() {
    return DATABASE_PRODUCT_NAME;
  }

  @Override
  public String getDatabaseProductVersion() {
    return DATABASE_PRODUCT_VERSION;
  }

  @Override
  public String getDriverName() {
    return DRIVER_NAME;
  }

  @Override
  public String getDriverVersion() {
    return parsedDriverVersion.get() != null ? parsedDriverVersion.get() : DRIVER_DEFAULT_VERSION;
  }

  @Override
  public int getDriverMajorVersion() {
    return parsedDriverMajorVersion.get() != null ? parsedDriverMajorVersion.get() : 0;
  }

  @Override
  public int getDriverMinorVersion() {
    return parsedDriverMinorVersion.get() != null ? parsedDriverMinorVersion.get() : 0;
  }

  @Override
  public boolean usesLocalFiles() {
    return false;
  }

  @Override
  public boolean usesLocalFilePerTable() {
    return false;
  }

  @Override
  public boolean supportsMixedCaseIdentifiers() {
    return false;
  }

  @Override
  public boolean storesUpperCaseIdentifiers() {
    return false;
  }

  @Override
  public boolean storesLowerCaseIdentifiers() {
    return false;
  }

  @Override
  public boolean storesMixedCaseIdentifiers() {
    return false;
  }

  @Override
  public boolean supportsMixedCaseQuotedIdentifiers() {
    return false;
  }

  @Override
  public boolean storesUpperCaseQuotedIdentifiers() {
    return false;
  }

  @Override
  public boolean storesLowerCaseQuotedIdentifiers() {
    return false;
  }

  @Override
  public boolean storesMixedCaseQuotedIdentifiers() {
    return false;
  }

  @Override
  public String getIdentifierQuoteString() {
    return GOOGLE_SQL_QUOTED_IDENTIFIER;
  }

  @Override
  public String getSQLKeywords() {
    return GOOGLE_SQL_RESERVED_KEYWORDS;
  }

  @Override
  public String getNumericFunctions() {
    return GOOGLE_SQL_NUMERIC_FNS;
  }

  @Override
  public String getStringFunctions() {
    return GOOGLE_SQL_STRING_FNS;
  }

  @Override
  // GoogleSQL has UDF (user defined functions).
  // System functions like DATABASE(), USER() are not supported.
  public String getSystemFunctions() {
    return null;
  }

  @Override
  public String getTimeDateFunctions() {
    return GOOGLE_SQL_TIME_DATE_FNS;
  }

  @Override
  public String getSearchStringEscape() {
    return GOOGLE_SQL_ESCAPE;
  }

  @Override
  // No extra characters beyond a-z, A-Z, 0-9 and _
  public String getExtraNameCharacters() {
    return null;
  }

  @Override
  public boolean supportsAlterTableWithAddColumn() {
    return true;
  }

  @Override
  public boolean supportsAlterTableWithDropColumn() {
    return true;
  }

  @Override
  public boolean supportsColumnAliasing() {
    return true;
  }

  @Override
  public boolean nullPlusNonNullIsNull() {
    return true;
  }

  @Override
  public boolean supportsConvert() {
    return false;
  }

  @Override
  public boolean supportsConvert(int fromType, int toType) {
    return false;
  }

  @Override
  public boolean supportsTableCorrelationNames() {
    return true;
  }

  @Override
  public boolean supportsDifferentTableCorrelationNames() {
    return false;
  }

  @Override
  public boolean supportsExpressionsInOrderBy() {
    return true;
  }

  @Override
  public boolean supportsOrderByUnrelated() {
    return true;
  }

  @Override
  public boolean supportsGroupBy() {
    return true;
  }

  @Override
  public boolean supportsGroupByUnrelated() {
    return true;
  }

  @Override
  public boolean supportsGroupByBeyondSelect() {
    return true;
  }

  @Override
  public boolean supportsLikeEscapeClause() {
    return false;
  }

  @Override
  public boolean supportsMultipleResultSets() {
    return false;
  }

  @Override
  public boolean supportsMultipleTransactions() {
    return false;
  }

  @Override
  public boolean supportsNonNullableColumns() {
    return false;
  }

  @Override
  public boolean supportsMinimumSQLGrammar() {
    return false;
  }

  @Override
  public boolean supportsCoreSQLGrammar() {
    return false;
  }

  @Override
  public boolean supportsExtendedSQLGrammar() {
    return false;
  }

  @Override
  public boolean supportsANSI92EntryLevelSQL() {
    return false;
  }

  @Override
  public boolean supportsANSI92IntermediateSQL() {
    return false;
  }

  @Override
  public boolean supportsANSI92FullSQL() {
    return false;
  }

  @Override
  public boolean supportsIntegrityEnhancementFacility() {
    return false;
  }

  @Override
  public boolean supportsOuterJoins() {
    return false;
  }

  @Override
  public boolean supportsFullOuterJoins() {
    return false;
  }

  @Override
  public boolean supportsLimitedOuterJoins() {
    return false;
  }

  @Override
  public String getSchemaTerm() {
    return SCHEMA_TERM;
  }

  @Override
  public String getProcedureTerm() {
    return PROCEDURE_TERM;
  }

  @Override
  public String getCatalogTerm() {
    return CATALOG_TERM;
  }

  @Override
  public boolean isCatalogAtStart() {
    return true;
  }

  @Override
  public String getCatalogSeparator() {
    return GOOGLE_SQL_CATALOG_SEPARATOR;
  }

  @Override
  public boolean supportsSchemasInDataManipulation() {
    return false;
  }

  @Override
  public boolean supportsSchemasInProcedureCalls() {
    return false;
  }

  @Override
  public boolean supportsSchemasInTableDefinitions() {
    return false;
  }

  @Override
  public boolean supportsSchemasInIndexDefinitions() {
    return false;
  }

  @Override
  public boolean supportsSchemasInPrivilegeDefinitions() {
    return false;
  }

  @Override
  public boolean supportsCatalogsInDataManipulation() {
    return false;
  }

  @Override
  public boolean supportsCatalogsInProcedureCalls() {
    return false;
  }

  @Override
  public boolean supportsCatalogsInTableDefinitions() {
    return false;
  }

  @Override
  public boolean supportsCatalogsInIndexDefinitions() {
    return false;
  }

  @Override
  public boolean supportsCatalogsInPrivilegeDefinitions() {
    return false;
  }

  @Override
  public boolean supportsPositionedDelete() {
    return false;
  }

  @Override
  public boolean supportsPositionedUpdate() {
    return false;
  }

  @Override
  public boolean supportsSelectForUpdate() {
    return false;
  }

  @Override
  public boolean supportsStoredProcedures() {
    return false;
  }

  @Override
  public boolean supportsSubqueriesInComparisons() {
    return false;
  }

  @Override
  public boolean supportsSubqueriesInExists() {
    return false;
  }

  @Override
  public boolean supportsSubqueriesInIns() {
    return false;
  }

  @Override
  public boolean supportsSubqueriesInQuantifieds() {
    return false;
  }

  @Override
  public boolean supportsCorrelatedSubqueries() {
    return false;
  }

  @Override
  public boolean supportsUnion() {
    return true;
  }

  @Override
  public boolean supportsUnionAll() {
    return true;
  }

  @Override
  public boolean supportsOpenCursorsAcrossCommit() {
    return false;
  }

  @Override
  public boolean supportsOpenCursorsAcrossRollback() {
    return false;
  }

  @Override
  public boolean supportsOpenStatementsAcrossCommit() {
    return false;
  }

  @Override
  public boolean supportsOpenStatementsAcrossRollback() {
    return false;
  }

  @Override
  // No limit
  public int getMaxBinaryLiteralLength() {
    return 0;
  }

  @Override
  // No Limit
  public int getMaxCharLiteralLength() {
    return 0;
  }

  @Override
  // GoogleSQL documentation says 300.
  // https://cloud.google.com/bigquery/quotas#all_tables
  public int getMaxColumnNameLength() {
    return GOOGLE_SQL_MAX_COL_NAME_LEN;
  }

  @Override
  // No specific limits for group by.
  public int getMaxColumnsInGroupBy() {
    return 0;
  }

  @Override
  // No specific limits for index.
  public int getMaxColumnsInIndex() {
    return 0;
  }

  @Override
  // No specific limit for Order By.
  public int getMaxColumnsInOrderBy() {
    return 0;
  }

  @Override
  // All columns can be selected. No specific limits.
  public int getMaxColumnsInSelect() {
    return 0;
  }

  @Override
  public int getMaxColumnsInTable() {
    return GOOGLE_SQL_MAX_COLS_PER_TABLE;
  }

  @Override
  public int getMaxConnections() {
    // Per JDBC spec, returns 0 as there is no connection limit or is unknown.
    return 0;
  }

  @Override
  public int getMaxCursorNameLength() {
    // BigQuery does not support named cursors or positioned updates/deletes.
    return 0;
  }

  @Override
  public int getMaxIndexLength() {
    // Per the JDBC spec, 0 indicates this feature is not supported.
    return 0;
  }

  @Override
  public int getMaxSchemaNameLength() {
    // Dataset IDs can be up to 1024 characters long.
    // See: https://cloud.google.com/bigquery/docs/datasets#dataset-naming
    return 1024;
  }

  @Override
  public int getMaxProcedureNameLength() {
    // Routine IDs can be up to 256 characters long.
    // See:
    // https://cloud.google.com/bigquery/docs/reference/rest/v2/routines#RoutineReference.FIELDS.routine_id
    return 256;
  }

  @Override
  public int getMaxCatalogNameLength() {
    // Corresponds to the BigQuery Project ID, which can be a maximum of 30 characters.
    // See:
    // https://cloud.google.com/resource-manager/docs/creating-managing-projects#before_you_begin
    return 30;
  }

  @Override
  public int getMaxRowSize() {
    // Per JDBC spec, returns 0 as there is no fixed limit or is unknown.
    return 0;
  }

  @Override
  public boolean doesMaxRowSizeIncludeBlobs() {
    return false;
  }

  @Override
  public int getMaxStatementLength() {
    // Per JDBC spec, returns 0 as there is no fixed limit or is unknown.
    // See: https://cloud.google.com/bigquery/quotas#query_jobs
    return 0;
  }

  @Override
  public int getMaxStatements() {
    // Per JDBC spec, returns 0 as there is no fixed limit or is unknown.
    return 0;
  }

  @Override
  public int getMaxTableNameLength() {
    // Table IDs can be up to 1024 characters long.
    // See: https://cloud.google.com/bigquery/docs/tables#table-naming
    return 1024;
  }

  @Override
  public int getMaxTablesInSelect() {
    // BigQuery allows up to 1,000 tables to be referenced per query.
    // See: https://cloud.google.com/bigquery/quotas#query_jobs
    return 1000;
  }

  @Override
  public int getMaxUserNameLength() {
    return 0;
  }

  @Override
  public int getDefaultTransactionIsolation() {
    return Connection.TRANSACTION_SERIALIZABLE;
  }

  @Override
  public boolean supportsTransactions() {
    return true;
  }

  @Override
  public boolean supportsTransactionIsolationLevel(int level) {
    return level == Connection.TRANSACTION_SERIALIZABLE;
  }

  @Override
  public boolean supportsDataDefinitionAndDataManipulationTransactions() {
    return false;
  }

  @Override
  public boolean supportsDataManipulationTransactionsOnly() {
    return false;
  }

  @Override
  public boolean dataDefinitionCausesTransactionCommit() {
    return false;
  }

  @Override
  public boolean dataDefinitionIgnoredInTransactions() {
    return false;
  }

  @Override
  public ResultSet getProcedures(
      String catalog, String schemaPattern, String procedureNamePattern) {
    if ((catalog == null || catalog.isEmpty())
        || (schemaPattern != null && schemaPattern.isEmpty())
        || (procedureNamePattern != null && procedureNamePattern.isEmpty())) {
      LOG.warning("Returning empty ResultSet as catalog is null/empty or a pattern is empty.");
      return new BigQueryJsonResultSet();
    }

    LOG.info(
        String.format(
            "getProcedures called for catalog: %s, schemaPattern: %s, procedureNamePattern: %s",
            catalog, schemaPattern, procedureNamePattern));

    final Pattern schemaRegex = compileSqlLikePattern(schemaPattern);
    final Pattern procedureNameRegex = compileSqlLikePattern(procedureNamePattern);
    final Schema resultSchema = defineGetProceduresSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();
    final BlockingQueue<BigQueryFieldValueListWrapper> queue =
        new LinkedBlockingQueue<>(DEFAULT_QUEUE_CAPACITY);
    final List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());
    final List<Future<?>> processingTaskFutures = new ArrayList<>();
    final String catalogParam = catalog;

    Runnable procedureFetcher =
        () -> {
          ExecutorService apiExecutor = null;
          ExecutorService routineProcessorExecutor = null;
          final FieldList localResultSchemaFields = resultSchemaFields;
          final List<Future<List<Routine>>> apiFutures = new ArrayList<>();

          try {
            List<Dataset> datasetsToScan =
                findMatchingBigQueryObjects(
                    "Dataset",
                    () ->
                        bigquery.listDatasets(
                            catalogParam, DatasetListOption.pageSize(DEFAULT_PAGE_SIZE)),
                    (name) -> bigquery.getDataset(DatasetId.of(catalogParam, name)),
                    (ds) -> ds.getDatasetId().getDataset(),
                    schemaPattern,
                    schemaRegex,
                    LOG);

            if (datasetsToScan.isEmpty()) {
              LOG.info("Fetcher thread found no matching datasets. Finishing.");
              return;
            }

            apiExecutor = Executors.newFixedThreadPool(API_EXECUTOR_POOL_SIZE);
            routineProcessorExecutor = Executors.newFixedThreadPool(this.metadataFetchThreadCount);

            LOG.fine("Submitting parallel findMatchingRoutines tasks...");
            for (Dataset dataset : datasetsToScan) {
              if (Thread.currentThread().isInterrupted()) {
                LOG.warning("Fetcher interrupted during dataset iteration submission.");
                break;
              }

              final DatasetId currentDatasetId = dataset.getDatasetId();
              Callable<List<Routine>> apiCallable =
                  () ->
                      findMatchingBigQueryObjects(
                          "Routine",
                          () ->
                              bigquery.listRoutines(
                                  currentDatasetId, RoutineListOption.pageSize(DEFAULT_PAGE_SIZE)),
                          (name) ->
                              bigquery.getRoutine(
                                  RoutineId.of(
                                      currentDatasetId.getProject(),
                                      currentDatasetId.getDataset(),
                                      name)),
                          (rt) -> rt.getRoutineId().getRoutine(),
                          procedureNamePattern,
                          procedureNameRegex,
                          LOG);
              Future<List<Routine>> apiFuture = apiExecutor.submit(apiCallable);
              apiFutures.add(apiFuture);
            }
            LOG.fine("Finished submitting " + apiFutures.size() + " findMatchingRoutines tasks.");
            apiExecutor.shutdown();

            LOG.fine("Processing results from findMatchingRoutines tasks...");
            for (Future<List<Routine>> apiFuture : apiFutures) {
              if (Thread.currentThread().isInterrupted()) {
                LOG.warning("Fetcher interrupted while processing API futures.");
                break;
              }
              try {
                List<Routine> routinesResult = apiFuture.get();
                if (routinesResult != null) {
                  for (Routine routine : routinesResult) {
                    if (Thread.currentThread().isInterrupted()) break;

                    if ("PROCEDURE".equalsIgnoreCase(routine.getRoutineType())) {
                      LOG.fine(
                          "Submitting processing task for procedure: " + routine.getRoutineId());
                      final Routine finalRoutine = routine;
                      Future<?> processFuture =
                          routineProcessorExecutor.submit(
                              () ->
                                  processProcedureInfo(
                                      finalRoutine, collectedResults, localResultSchemaFields));
                      processingTaskFutures.add(processFuture);
                    } else {
                      LOG.finer("Skipping non-procedure routine: " + routine.getRoutineId());
                    }
                  }
                }
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOG.warning("Fetcher thread interrupted while waiting for API future result.");
                break;
              } catch (ExecutionException e) {
                LOG.warning(
                    "Error executing findMatchingRoutines task: "
                        + e.getMessage()
                        + ". Cause: "
                        + e.getCause());
              } catch (CancellationException e) {
                LOG.warning("A findMatchingRoutines task was cancelled.");
              }
            }

            LOG.fine(
                "Finished submitting "
                    + processingTaskFutures.size()
                    + " processProcedureInfo tasks.");

            if (Thread.currentThread().isInterrupted()) {
              LOG.warning(
                  "Fetcher interrupted before waiting for processing tasks; cancelling remaining.");
              processingTaskFutures.forEach(f -> f.cancel(true));
            } else {
              LOG.fine("Waiting for processProcedureInfo tasks to complete...");
              waitForTasksCompletion(processingTaskFutures);
              LOG.fine("All processProcedureInfo tasks completed or handled.");
            }

            if (!Thread.currentThread().isInterrupted()) {
              Comparator<FieldValueList> comparator =
                  defineGetProceduresComparator(localResultSchemaFields);
              sortResults(collectedResults, comparator, "getProcedures", LOG);
            }

            if (!Thread.currentThread().isInterrupted()) {
              populateQueue(collectedResults, queue, localResultSchemaFields);
            }

          } catch (Throwable t) {
            LOG.severe("Unexpected error in procedure fetcher runnable: " + t.getMessage());
            apiFutures.forEach(f -> f.cancel(true));
            processingTaskFutures.forEach(f -> f.cancel(true));
          } finally {
            signalEndOfData(queue, localResultSchemaFields);
            shutdownExecutor(apiExecutor);
            shutdownExecutor(routineProcessorExecutor);
            LOG.info("Procedure fetcher thread finished.");
          }
        };

    Thread fetcherThread = new Thread(procedureFetcher, "getProcedures-fetcher-" + catalog);
    BigQueryJsonResultSet resultSet =
        BigQueryJsonResultSet.of(
            resultSchema, -1, queue, this.statement, new Thread[] {fetcherThread});

    fetcherThread.start();
    LOG.info("Started background thread for getProcedures");
    return resultSet;
  }

  Schema defineGetProceduresSchema() {
    List<Field> fields = new ArrayList<>(9);
    fields.add(
        Field.newBuilder("PROCEDURE_CAT", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("PROCEDURE_SCHEM", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("PROCEDURE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("reserved1", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("reserved2", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("reserved3", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("REMARKS", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("PROCEDURE_TYPE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("SPECIFIC_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    return Schema.of(fields);
  }

  void processProcedureInfo(
      Routine routine, List<FieldValueList> collectedResults, FieldList resultSchemaFields) {

    RoutineId routineId = routine.getRoutineId();
    LOG.fine("Processing procedure info for: " + routineId);

    try {
      if (!"PROCEDURE".equalsIgnoreCase(routine.getRoutineType())) {
        LOG.warning(
            "processProcedureInfo called with non-procedure type: "
                + routine.getRoutineType()
                + " for "
                + routineId);
        return;
      }

      String catalogName = routineId.getProject();
      String schemaName = routineId.getDataset();
      String procedureName = routineId.getRoutine();
      String remarks = routine.getDescription();

      List<FieldValue> values = new ArrayList<>(resultSchemaFields.size());

      values.add(createStringFieldValue(catalogName)); // 1. PROCEDURE_CAT
      values.add(createStringFieldValue(schemaName)); // 2. PROCEDURE_SCHEM
      values.add(createStringFieldValue(procedureName)); // 3. PROCEDURE_NAME
      values.add(createNullFieldValue()); // 4. reserved1
      values.add(createNullFieldValue()); // 5. reserved2
      values.add(createNullFieldValue()); // 6. reserved3
      values.add(createStringFieldValue(remarks)); // 7. REMARKS
      values.add(
          createLongFieldValue(
              (long) DatabaseMetaData.procedureResultUnknown)); // 8. PROCEDURE_TYPE
      values.add(createStringFieldValue(procedureName)); // 9. SPECIFIC_NAME

      FieldValueList rowFvl = FieldValueList.of(values, resultSchemaFields);
      collectedResults.add(rowFvl);

      LOG.fine("Processed and added procedure info row for: " + routineId);

    } catch (Exception e) {
      LOG.warning(
          String.format(
              "Error processing procedure info for %s: %s. Skipping this procedure.",
              routineId, e.getMessage()));
    }
  }

  Comparator<FieldValueList> defineGetProceduresComparator(FieldList resultSchemaFields) {
    final int PROC_CAT_IDX = resultSchemaFields.getIndex("PROCEDURE_CAT");
    final int PROC_SCHEM_IDX = resultSchemaFields.getIndex("PROCEDURE_SCHEM");
    final int PROC_NAME_IDX = resultSchemaFields.getIndex("PROCEDURE_NAME");
    final int SPEC_NAME_IDX = resultSchemaFields.getIndex("SPECIFIC_NAME");
    return Comparator.comparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, PROC_CAT_IDX),
            Comparator.nullsFirst(String::compareTo))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, PROC_SCHEM_IDX),
            Comparator.nullsFirst(String::compareTo))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, PROC_NAME_IDX),
            Comparator.nullsFirst(String::compareTo))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, SPEC_NAME_IDX),
            Comparator.nullsFirst(String::compareTo));
  }

  @Override
  public ResultSet getProcedureColumns(
      String catalog, String schemaPattern, String procedureNamePattern, String columnNamePattern) {

    if (catalog == null || catalog.isEmpty()) {
      LOG.warning("Returning empty ResultSet because catalog (project) is null or empty.");
      return new BigQueryJsonResultSet();
    }
    if ((schemaPattern != null && schemaPattern.isEmpty())
        || (procedureNamePattern != null && procedureNamePattern.isEmpty())
        || (columnNamePattern != null && columnNamePattern.isEmpty())) {
      LOG.warning("Returning empty ResultSet because an explicit empty pattern was provided.");
      return new BigQueryJsonResultSet();
    }

    LOG.info(
        String.format(
            "getProcedureColumns called for catalog: %s, schemaPattern: %s, procedureNamePattern:"
                + " %s, columnNamePattern: %s",
            catalog, schemaPattern, procedureNamePattern, columnNamePattern));

    final Pattern schemaRegex = compileSqlLikePattern(schemaPattern);
    final Pattern procedureNameRegex = compileSqlLikePattern(procedureNamePattern);
    final Pattern columnNameRegex = compileSqlLikePattern(columnNamePattern);

    final Schema resultSchema = defineGetProcedureColumnsSchema();
    final BlockingQueue<BigQueryFieldValueListWrapper> queue =
        new LinkedBlockingQueue<>(DEFAULT_QUEUE_CAPACITY);
    final List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());
    final List<Future<?>> processingTaskFutures = new ArrayList<>();
    final String catalogParam = catalog;

    Runnable procedureColumnFetcher =
        () -> {
          ExecutorService listRoutinesExecutor = null;
          ExecutorService getRoutineDetailsExecutor = null;
          ExecutorService processArgsExecutor = null;

          final String fetcherThreadNameSuffix =
              "-" + catalogParam.substring(0, Math.min(10, catalogParam.length()));

          try {
            List<Dataset> datasetsToScan =
                fetchMatchingDatasetsForProcedureColumns(catalogParam, schemaPattern, schemaRegex);
            if (datasetsToScan.isEmpty() || Thread.currentThread().isInterrupted()) {
              LOG.info(
                  "Fetcher: No matching datasets or interrupted early. Catalog: " + catalogParam);
              return;
            }

            listRoutinesExecutor =
                Executors.newFixedThreadPool(
                    API_EXECUTOR_POOL_SIZE,
                    runnable -> new Thread(runnable, "pcol-list-rout" + fetcherThreadNameSuffix));
            List<RoutineId> procedureIdsToGet =
                listMatchingProcedureIdsFromDatasets(
                    datasetsToScan,
                    procedureNamePattern,
                    procedureNameRegex,
                    listRoutinesExecutor,
                    catalogParam,
                    LOG);
            shutdownExecutor(listRoutinesExecutor);
            listRoutinesExecutor = null;

            if (procedureIdsToGet.isEmpty() || Thread.currentThread().isInterrupted()) {
              LOG.info("Fetcher: No procedure IDs found or interrupted. Catalog: " + catalogParam);
              return;
            }

            getRoutineDetailsExecutor =
                Executors.newFixedThreadPool(
                    100,
                    runnable -> new Thread(runnable, "pcol-get-details" + fetcherThreadNameSuffix));
            List<Routine> fullRoutines =
                fetchFullRoutineDetailsForIds(procedureIdsToGet, getRoutineDetailsExecutor, LOG);
            shutdownExecutor(getRoutineDetailsExecutor);
            getRoutineDetailsExecutor = null;

            if (fullRoutines.isEmpty() || Thread.currentThread().isInterrupted()) {
              LOG.info(
                  "Fetcher: No full routines fetched or interrupted. Catalog: " + catalogParam);
              return;
            }

            processArgsExecutor =
                Executors.newFixedThreadPool(
                    this.metadataFetchThreadCount,
                    runnable -> new Thread(runnable, "pcol-proc-args" + fetcherThreadNameSuffix));
            submitProcedureArgumentProcessingJobs(
                fullRoutines,
                columnNameRegex,
                collectedResults,
                resultSchema.getFields(),
                processArgsExecutor,
                processingTaskFutures,
                LOG);

            if (Thread.currentThread().isInterrupted()) {
              LOG.warning(
                  "Fetcher: Interrupted before waiting for argument processing. Catalog: "
                      + catalogParam);
              processingTaskFutures.forEach(f -> f.cancel(true));
            } else {
              LOG.fine(
                  "Fetcher: Waiting for "
                      + processingTaskFutures.size()
                      + " argument processing tasks. Catalog: "
                      + catalogParam);
              waitForTasksCompletion(processingTaskFutures);
              LOG.fine(
                  "Fetcher: All argument processing tasks completed or handled. Catalog: "
                      + catalogParam);
            }

            if (!Thread.currentThread().isInterrupted()) {
              Comparator<FieldValueList> comparator =
                  defineGetProcedureColumnsComparator(resultSchema.getFields());
              sortResults(collectedResults, comparator, "getProcedureColumns", LOG);
              populateQueue(collectedResults, queue, resultSchema.getFields());
            }

          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOG.warning(
                "Fetcher: Interrupted in main try block for catalog "
                    + catalogParam
                    + ". Error: "
                    + e.getMessage());
            processingTaskFutures.forEach(f -> f.cancel(true));
          } catch (Throwable t) {
            LOG.severe(
                "Fetcher: Unexpected error in main try block for catalog "
                    + catalogParam
                    + ". Error: "
                    + t.getMessage());
            processingTaskFutures.forEach(f -> f.cancel(true));
          } finally {
            signalEndOfData(queue, resultSchema.getFields());
            if (listRoutinesExecutor != null) shutdownExecutor(listRoutinesExecutor);
            if (getRoutineDetailsExecutor != null) shutdownExecutor(getRoutineDetailsExecutor);
            if (processArgsExecutor != null) shutdownExecutor(processArgsExecutor);
            LOG.info("Procedure column fetcher thread finished for catalog: " + catalogParam);
          }
        };

    Thread fetcherThread =
        new Thread(procedureColumnFetcher, "getProcedureColumns-fetcher-" + catalog);
    BigQueryJsonResultSet resultSet =
        BigQueryJsonResultSet.of(
            resultSchema, -1, queue, this.statement, new Thread[] {fetcherThread});

    fetcherThread.start();
    LOG.info("Started background thread for getProcedureColumns for catalog: " + catalog);
    return resultSet;
  }

  private List<Dataset> fetchMatchingDatasetsForProcedureColumns(
      String catalogParam, String schemaPattern, Pattern schemaRegex) throws InterruptedException {
    LOG.fine(
        String.format(
            "Fetching matching datasets for catalog '%s', schemaPattern '%s'",
            catalogParam, schemaPattern));
    List<Dataset> datasetsToScan =
        findMatchingBigQueryObjects(
            "Dataset",
            () ->
                bigquery.listDatasets(catalogParam, DatasetListOption.pageSize(DEFAULT_PAGE_SIZE)),
            (name) -> bigquery.getDataset(DatasetId.of(catalogParam, name)),
            (ds) -> ds.getDatasetId().getDataset(),
            schemaPattern,
            schemaRegex,
            LOG);
    LOG.info(
        String.format(
            "Found %d datasets to scan for procedures in catalog '%s'.",
            datasetsToScan.size(), catalogParam));
    return datasetsToScan;
  }

  List<RoutineId> listMatchingProcedureIdsFromDatasets(
      List<Dataset> datasetsToScan,
      String procedureNamePattern,
      Pattern procedureNameRegex,
      ExecutorService listRoutinesExecutor,
      String catalogParam,
      BigQueryJdbcCustomLogger logger)
      throws InterruptedException {

    logger.fine(
        String.format(
            "Listing matching procedure IDs from %d datasets for catalog '%s'.",
            datasetsToScan.size(), catalogParam));
    final List<Future<List<Routine>>> listRoutineFutures = new ArrayList<>();
    final List<RoutineId> procedureIdsToGet = Collections.synchronizedList(new ArrayList<>());

    for (Dataset dataset : datasetsToScan) {
      if (Thread.currentThread().isInterrupted()) {
        logger.warning(
            "Interrupted during submission of routine listing tasks for catalog: " + catalogParam);
        throw new InterruptedException("Interrupted while listing routines");
      }
      final DatasetId currentDatasetId = dataset.getDatasetId();
      Callable<List<Routine>> listCallable =
          () ->
              findMatchingBigQueryObjects(
                  "Routine",
                  () ->
                      bigquery.listRoutines(
                          currentDatasetId, RoutineListOption.pageSize(DEFAULT_PAGE_SIZE)),
                  (name) ->
                      bigquery.getRoutine(
                          RoutineId.of(
                              currentDatasetId.getProject(), currentDatasetId.getDataset(), name)),
                  (rt) -> rt.getRoutineId().getRoutine(),
                  procedureNamePattern,
                  procedureNameRegex,
                  logger);
      listRoutineFutures.add(listRoutinesExecutor.submit(listCallable));
    }
    logger.fine(
        "Submitted "
            + listRoutineFutures.size()
            + " routine list tasks for catalog: "
            + catalogParam);

    for (Future<List<Routine>> listFuture : listRoutineFutures) {
      if (Thread.currentThread().isInterrupted()) {
        logger.warning(
            "Interrupted while collecting routine list results for catalog: " + catalogParam);
        listRoutineFutures.forEach(f -> f.cancel(true));
        throw new InterruptedException("Interrupted while collecting routine lists");
      }
      try {
        List<Routine> listedRoutines = listFuture.get();
        if (listedRoutines != null) {
          for (Routine listedRoutine : listedRoutines) {
            if (listedRoutine != null
                && "PROCEDURE".equalsIgnoreCase(listedRoutine.getRoutineType())) {
              if (listedRoutine.getRoutineId() != null) {
                procedureIdsToGet.add(listedRoutine.getRoutineId());
              } else {
                logger.warning(
                    "Found a procedure type routine with a null ID during listing phase for"
                        + " catalog: "
                        + catalogParam);
              }
            }
          }
        }
      } catch (ExecutionException e) {
        logger.warning(
            "Error getting routine list result for catalog " + catalogParam + ": " + e.getCause());
      } catch (CancellationException e) {
        logger.warning("Routine list task cancelled for catalog: " + catalogParam);
      }
    }
    logger.info(
        String.format(
            "Found %d procedure IDs to fetch details for in catalog '%s'.",
            procedureIdsToGet.size(), catalogParam));
    return procedureIdsToGet;
  }

  List<Routine> fetchFullRoutineDetailsForIds(
      List<RoutineId> procedureIdsToGet,
      ExecutorService getRoutineDetailsExecutor,
      BigQueryJdbcCustomLogger logger)
      throws InterruptedException {
    logger.fine(
        String.format("Fetching full details for %d procedure IDs.", procedureIdsToGet.size()));
    final List<Future<Routine>> getRoutineFutures = new ArrayList<>();
    final List<Routine> fullRoutines = Collections.synchronizedList(new ArrayList<>());

    for (RoutineId procId : procedureIdsToGet) {
      if (Thread.currentThread().isInterrupted()) {
        logger.warning("Interrupted during submission of getRoutine detail tasks.");
        throw new InterruptedException("Interrupted while submitting getRoutine tasks");
      }
      final RoutineId currentProcId = procId;
      Callable<Routine> getCallable =
          () -> {
            try {
              return bigquery.getRoutine(currentProcId);
            } catch (Exception e) {
              logger.warning(
                  "Failed to get full details for routine "
                      + currentProcId
                      + ": "
                      + e.getMessage());
              return null;
            }
          };
      getRoutineFutures.add(getRoutineDetailsExecutor.submit(getCallable));
    }
    logger.fine("Submitted " + getRoutineFutures.size() + " getRoutine detail tasks.");

    for (Future<Routine> getFuture : getRoutineFutures) {
      if (Thread.currentThread().isInterrupted()) {
        logger.warning("Interrupted while collecting getRoutine detail results.");
        getRoutineFutures.forEach(f -> f.cancel(true)); // Cancel remaining
        throw new InterruptedException("Interrupted while collecting Routine details");
      }
      try {
        Routine fullRoutine = getFuture.get();
        if (fullRoutine != null) {
          fullRoutines.add(fullRoutine);
        }
      } catch (ExecutionException e) {
        logger.warning("Error processing getRoutine future result: " + e.getCause());
      } catch (CancellationException e) {
        logger.warning("getRoutine detail task cancelled.");
      }
    }
    logger.info(
        String.format("Successfully fetched full details for %d routines.", fullRoutines.size()));
    return fullRoutines;
  }

  void submitProcedureArgumentProcessingJobs(
      List<Routine> fullRoutines,
      Pattern columnNameRegex,
      List<FieldValueList> collectedResults,
      FieldList resultSchemaFields,
      ExecutorService processArgsExecutor,
      List<Future<?>> outArgumentProcessingFutures,
      BigQueryJdbcCustomLogger logger)
      throws InterruptedException {
    logger.fine(
        String.format("Submitting argument processing jobs for %d routines.", fullRoutines.size()));

    for (Routine fullRoutine : fullRoutines) {
      if (Thread.currentThread().isInterrupted()) {
        logger.warning("Interrupted during submission of argument processing tasks.");
        throw new InterruptedException("Interrupted while submitting argument processing jobs");
      }
      if (fullRoutine != null) {
        if ("PROCEDURE".equalsIgnoreCase(fullRoutine.getRoutineType())) {
          final Routine finalFullRoutine = fullRoutine;
          Future<?> processFuture =
              processArgsExecutor.submit(
                  () ->
                      processProcedureArguments(
                          finalFullRoutine, columnNameRegex, collectedResults, resultSchemaFields));
          outArgumentProcessingFutures.add(processFuture);
        } else {
          logger.warning(
              "Routine "
                  + (fullRoutine.getRoutineId() != null
                      ? fullRoutine.getRoutineId().toString()
                      : "UNKNOWN_ID")
                  + " fetched via getRoutine was not of type PROCEDURE (Type: "
                  + fullRoutine.getRoutineType()
                  + "). Skipping argument processing.");
        }
      }
    }
    logger.fine(
        "Finished submitting "
            + outArgumentProcessingFutures.size()
            + " processProcedureArguments tasks.");
  }

  Schema defineGetProcedureColumnsSchema() {
    List<Field> fields = new ArrayList<>(20);
    fields.add(
        Field.newBuilder("PROCEDURE_CAT", StandardSQLTypeName.STRING)
            .setMode(Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("PROCEDURE_SCHEM", StandardSQLTypeName.STRING)
            .setMode(Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("PROCEDURE_NAME", StandardSQLTypeName.STRING)
            .setMode(Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("COLUMN_NAME", StandardSQLTypeName.STRING).setMode(Mode.REQUIRED).build());
    fields.add(
        Field.newBuilder("COLUMN_TYPE", StandardSQLTypeName.INT64).setMode(Mode.REQUIRED).build());
    fields.add(
        Field.newBuilder("DATA_TYPE", StandardSQLTypeName.INT64).setMode(Mode.REQUIRED).build());
    fields.add(
        Field.newBuilder("TYPE_NAME", StandardSQLTypeName.STRING).setMode(Mode.REQUIRED).build());
    fields.add(
        Field.newBuilder("PRECISION", StandardSQLTypeName.INT64).setMode(Mode.NULLABLE).build());
    fields.add(
        Field.newBuilder("LENGTH", StandardSQLTypeName.INT64).setMode(Mode.NULLABLE).build());
    fields.add(Field.newBuilder("SCALE", StandardSQLTypeName.INT64).setMode(Mode.NULLABLE).build());
    fields.add(Field.newBuilder("RADIX", StandardSQLTypeName.INT64).setMode(Mode.NULLABLE).build());
    fields.add(
        Field.newBuilder("NULLABLE", StandardSQLTypeName.INT64).setMode(Mode.REQUIRED).build());
    fields.add(
        Field.newBuilder("REMARKS", StandardSQLTypeName.STRING).setMode(Mode.NULLABLE).build());
    fields.add(
        Field.newBuilder("COLUMN_DEF", StandardSQLTypeName.STRING).setMode(Mode.NULLABLE).build());
    fields.add(
        Field.newBuilder("SQL_DATA_TYPE", StandardSQLTypeName.INT64)
            .setMode(Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("SQL_DATETIME_SUB", StandardSQLTypeName.INT64)
            .setMode(Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("CHAR_OCTET_LENGTH", StandardSQLTypeName.INT64)
            .setMode(Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("ORDINAL_POSITION", StandardSQLTypeName.INT64)
            .setMode(Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("IS_NULLABLE", StandardSQLTypeName.STRING).setMode(Mode.REQUIRED).build());
    fields.add(
        Field.newBuilder("SPECIFIC_NAME", StandardSQLTypeName.STRING)
            .setMode(Mode.REQUIRED)
            .build());
    return Schema.of(fields);
  }

  void processProcedureArguments(
      Routine routine,
      Pattern columnNameRegex,
      List<FieldValueList> collectedResults,
      FieldList resultSchemaFields) {

    RoutineId routineId = routine.getRoutineId();
    List<RoutineArgument> arguments;
    try {
      arguments = routine.getArguments();
    } catch (Exception e) {
      LOG.warning(
          String.format(
              "Could not retrieve arguments list for procedure %s: %s. No arguments will be"
                  + " processed.",
              routineId, e.getMessage()));
      return;
    }

    if (arguments == null || arguments.isEmpty()) {
      LOG.fine("Procedure " + routineId + " has no arguments.");
      return;
    }

    String catalogName = routineId.getProject();
    String schemaName = routineId.getDataset();
    String procedureName = routineId.getRoutine();
    String specificName = procedureName;

    for (int i = 0; i < arguments.size(); i++) {
      if (Thread.currentThread().isInterrupted()) {
        LOG.warning("Argument processing task interrupted for " + routineId);
        break;
      }

      int ordinalPosition = i + 1;
      RoutineArgument arg;
      String argName;

      try {
        arg = arguments.get(i);
        argName = arg.getName();
      } catch (Exception listAccessException) {
        LOG.warning(
            String.format(
                "Exception during arguments.get(%d) for Proc: %s. Ordinal: %d. Message: %s."
                    + " Generating fallback row.",
                i, routineId, ordinalPosition, listAccessException.getMessage()));
        argName = "arg_retrieval_err_" + ordinalPosition;
        arg = null;
      }

      // Filter by columnNamePattern, but not by generated fallback name
      if (columnNameRegex != null) {
        assert argName != null;
        if (!argName.startsWith("arg_")) {
          if (!columnNameRegex.matcher(argName).matches()) {
            continue;
          }
        }
      }

      List<FieldValue> values =
          createProcedureColumnRow(
              catalogName, schemaName, procedureName, specificName, arg, ordinalPosition, argName);

      FieldValueList rowFvl = FieldValueList.of(values, resultSchemaFields);
      collectedResults.add(rowFvl);
    }
  }

  List<FieldValue> createProcedureColumnRow(
      String catalog,
      String schemaName,
      String procedureName,
      String specificName,
      @Nullable RoutineArgument argument,
      int ordinalPosition,
      String columnName) {

    List<FieldValue> values = new ArrayList<>(20);
    ColumnTypeInfo typeInfo;

    if (argument == null) {
      LOG.warning(
          String.format(
              "Proc: %s, Arg: %s (Pos %d) - RoutineArgument object is null. Defaulting type to"
                  + " VARCHAR.",
              procedureName, columnName, ordinalPosition));
      typeInfo = new ColumnTypeInfo(Types.VARCHAR, "VARCHAR", null, null, null);
    } else {
      try {
        StandardSQLDataType argumentDataType = argument.getDataType();
        if (argumentDataType == null) {
          LOG.warning(
              String.format(
                  "Proc: %s, Arg: %s (Pos %d) - argument.getDataType() returned null. Defaulting"
                      + " type to VARCHAR.",
                  procedureName, columnName, ordinalPosition));
          typeInfo = new ColumnTypeInfo(Types.VARCHAR, "VARCHAR", null, null, null);
        } else {
          typeInfo =
              determineTypeInfoFromDataType(
                  argumentDataType, procedureName, columnName, ordinalPosition);
        }
      } catch (Exception e) {
        LOG.warning(
            String.format(
                "Proc: %s, Arg: %s (Pos %d) - Unexpected Exception during type processing."
                    + " Defaulting type to VARCHAR. Error: %s",
                procedureName, columnName, ordinalPosition, e.getMessage()));
        typeInfo = new ColumnTypeInfo(Types.VARCHAR, "VARCHAR", null, null, null);
      }
    }

    String argumentModeStr = null;
    if (argument != null) {
      try {
        argumentModeStr = argument.getMode();
      } catch (Exception e) {
        LOG.warning(
            String.format(
                "Proc: %s, Arg: %s (Pos %d) - Could not get argument mode. Error: %s",
                procedureName, columnName, ordinalPosition, e.getMessage()));
      }
    }

    values.add(createStringFieldValue(catalog)); // 1. PROCEDURE_CAT
    values.add(createStringFieldValue(schemaName)); // 2. PROCEDURE_SCHEM
    values.add(createStringFieldValue(procedureName)); // 3. PROCEDURE_NAME
    values.add(createStringFieldValue(columnName)); // 4. COLUMN_NAME
    long columnTypeJdbc = DatabaseMetaData.procedureColumnUnknown;
    if ("IN".equalsIgnoreCase(argumentModeStr)) {
      columnTypeJdbc = DatabaseMetaData.procedureColumnIn;
    } else if ("OUT".equalsIgnoreCase(argumentModeStr)) {
      columnTypeJdbc = DatabaseMetaData.procedureColumnOut;
    } else if ("INOUT".equalsIgnoreCase(argumentModeStr)) {
      columnTypeJdbc = DatabaseMetaData.procedureColumnInOut;
    }
    values.add(createLongFieldValue(columnTypeJdbc)); // 5. COLUMN_TYPE
    values.add(createLongFieldValue((long) typeInfo.jdbcType)); // 6. DATA_TYPE (java.sql.Types)
    values.add(createStringFieldValue(typeInfo.typeName)); // 7. TYPE_NAME (DB type name)
    values.add(
        createLongFieldValue(
            typeInfo.columnSize == null ? null : typeInfo.columnSize.longValue())); // 8. PRECISION
    values.add(
        createNullFieldValue()); // 9. LENGTH (length in bytes - often null for procedure params)
    values.add(
        createLongFieldValue(
            typeInfo.decimalDigits == null
                ? null
                : typeInfo.decimalDigits.longValue())); // 10. SCALE
    values.add(
        createLongFieldValue(
            typeInfo.numPrecRadix == null ? null : typeInfo.numPrecRadix.longValue())); // 11. RADIX
    values.add(createLongFieldValue((long) DatabaseMetaData.procedureNullable)); // 12. NULLABLE
    values.add(
        createNullFieldValue()); // 13. REMARKS (Can be argument.getDescription() if available and
    // needed)
    values.add(createNullFieldValue()); // 14. COLUMN_DEF (Default value - typically null)
    values.add(createNullFieldValue()); // 15. SQL_DATA_TYPE (reserved)
    values.add(createNullFieldValue()); // 16. SQL_DATETIME_SUB (reserved)
    values.add(createNullFieldValue()); // 17. CHAR_OCTET_LENGTH (null for non-char/binary)
    values.add(createLongFieldValue((long) ordinalPosition)); // 18. ORDINAL_POSITION
    values.add(createStringFieldValue("YES")); // 19. IS_NULLABLE (Default to "YES")
    values.add(createStringFieldValue(specificName)); // 20. SPECIFIC_NAME

    return values;
  }

  ColumnTypeInfo determineTypeInfoFromDataType(
      StandardSQLDataType argumentDataType,
      String procedureName,
      String columnName,
      int ordinalPosition) {

    ColumnTypeInfo defaultVarcharTypeInfo =
        new ColumnTypeInfo(Types.VARCHAR, "VARCHAR", null, null, null);
    try {
      String typeKind = argumentDataType.getTypeKind();
      if (typeKind != null && !typeKind.isEmpty()) {
        if ("ARRAY".equalsIgnoreCase(typeKind)) {
          return new ColumnTypeInfo(Types.ARRAY, "ARRAY", null, null, null);
        }
        StandardSQLTypeName determinedType = StandardSQLTypeName.valueOf(typeKind.toUpperCase());
        return getColumnTypeInfoForSqlType(determinedType);
      }
    } catch (Exception e) {
      LOG.warning(
          String.format(
              "Proc: %s, Arg: %s (Pos %d) - Caught an unexpected Exception during type"
                  + " determination. Defaulting type to VARCHAR. Error: %s",
              procedureName, columnName, ordinalPosition, e.getMessage()));
    }
    return defaultVarcharTypeInfo;
  }

  Comparator<FieldValueList> defineGetProcedureColumnsComparator(FieldList resultSchemaFields) {
    final int PROC_CAT_IDX = resultSchemaFields.getIndex("PROCEDURE_CAT");
    final int PROC_SCHEM_IDX = resultSchemaFields.getIndex("PROCEDURE_SCHEM");
    final int PROC_NAME_IDX = resultSchemaFields.getIndex("PROCEDURE_NAME");
    final int SPEC_NAME_IDX = resultSchemaFields.getIndex("SPECIFIC_NAME");
    final int COL_NAME_IDX = resultSchemaFields.getIndex("COLUMN_NAME");

    if (PROC_CAT_IDX < 0
        || PROC_SCHEM_IDX < 0
        || PROC_NAME_IDX < 0
        || SPEC_NAME_IDX < 0
        || COL_NAME_IDX < 0) {
      LOG.severe(
          "Could not find required columns (PROCEDURE_CAT, SCHEM, NAME, SPECIFIC_NAME, COLUMN_NAME)"
              + " in getProcedureColumns schema for sorting. Returning null comparator.");
      return null;
    }

    return Comparator.comparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, PROC_CAT_IDX),
            Comparator.nullsFirst(String::compareToIgnoreCase))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, PROC_SCHEM_IDX),
            Comparator.nullsFirst(String::compareToIgnoreCase))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, PROC_NAME_IDX),
            Comparator.nullsFirst(String::compareToIgnoreCase))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, SPEC_NAME_IDX),
            Comparator.nullsFirst(String::compareToIgnoreCase))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, COL_NAME_IDX),
            Comparator.nullsFirst(String::compareToIgnoreCase));
  }

  @Override
  public ResultSet getTables(
      String catalog, String schemaPattern, String tableNamePattern, String[] types) {

    Tuple<String, String> effectiveIdentifiers =
        determineEffectiveCatalogAndSchema(catalog, schemaPattern);
    String effectiveCatalog = effectiveIdentifiers.x();
    String effectiveSchemaPattern = effectiveIdentifiers.y();

    if ((effectiveCatalog == null || effectiveCatalog.isEmpty())
        || (effectiveSchemaPattern != null && effectiveSchemaPattern.isEmpty())
        || (tableNamePattern != null && tableNamePattern.isEmpty())) {
      LOG.warning(
          "Returning empty ResultSet as one or more patterns are empty or catalog is null.");
      return new BigQueryJsonResultSet();
    }

    LOG.info(
        String.format(
            "getTables called for catalog: %s, schemaPattern: %s, tableNamePattern: %s, types: %s",
            effectiveCatalog, effectiveSchemaPattern, tableNamePattern, Arrays.toString(types)));

    final Pattern schemaRegex = compileSqlLikePattern(effectiveSchemaPattern);
    final Pattern tableNameRegex = compileSqlLikePattern(tableNamePattern);
    final Set<String> requestedTypes =
        (types == null || types.length == 0) ? null : new HashSet<>(Arrays.asList(types));

    final Schema resultSchema = defineGetTablesSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();

    final BlockingQueue<BigQueryFieldValueListWrapper> queue =
        new LinkedBlockingQueue<>(DEFAULT_QUEUE_CAPACITY);
    final List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());
    final String catalogParam = effectiveCatalog;
    final String schemaParam = effectiveSchemaPattern;

    Runnable tableFetcher =
        () -> {
          ExecutorService apiExecutor = null;
          ExecutorService tableProcessorExecutor = null;
          final FieldList localResultSchemaFields = resultSchemaFields;
          final List<Future<List<Table>>> apiFutures = new ArrayList<>();
          final List<Future<?>> processingFutures = new ArrayList<>();

          try {
            List<Dataset> datasetsToScan =
                findMatchingBigQueryObjects(
                    "Dataset",
                    () ->
                        bigquery.listDatasets(
                            catalogParam, DatasetListOption.pageSize(DEFAULT_PAGE_SIZE)),
                    (name) -> bigquery.getDataset(DatasetId.of(catalogParam, name)),
                    (ds) -> ds.getDatasetId().getDataset(),
                    schemaParam,
                    schemaRegex,
                    LOG);

            if (datasetsToScan.isEmpty()) {
              LOG.info("Fetcher thread found no matching datasets. Returning empty resultset.");
              return;
            }

            apiExecutor = Executors.newFixedThreadPool(API_EXECUTOR_POOL_SIZE);
            tableProcessorExecutor = Executors.newFixedThreadPool(this.metadataFetchThreadCount);

            LOG.fine("Submitting parallel findMatchingTables tasks...");
            for (Dataset dataset : datasetsToScan) {
              if (Thread.currentThread().isInterrupted()) {
                LOG.warning("Table fetcher interrupted during dataset iteration.");
                break;
              }

              final DatasetId currentDatasetId = dataset.getDatasetId();
              Callable<List<Table>> apiCallable =
                  () ->
                      findMatchingBigQueryObjects(
                          "Table",
                          () ->
                              bigquery.listTables(
                                  currentDatasetId, TableListOption.pageSize(DEFAULT_PAGE_SIZE)),
                          (name) ->
                              bigquery.getTable(
                                  TableId.of(
                                      currentDatasetId.getProject(),
                                      currentDatasetId.getDataset(),
                                      name)),
                          (tbl) -> tbl.getTableId().getTable(),
                          tableNamePattern,
                          tableNameRegex,
                          LOG);
              Future<List<Table>> apiFuture = apiExecutor.submit(apiCallable);
              apiFutures.add(apiFuture);
            }
            LOG.fine("Finished submitting " + apiFutures.size() + " findMatchingTables tasks.");
            apiExecutor.shutdown();

            LOG.fine("Processing results from findMatchingTables tasks...");
            for (Future<List<Table>> apiFuture : apiFutures) {
              if (Thread.currentThread().isInterrupted()) {
                LOG.warning("Table fetcher interrupted while processing API futures.");
                break;
              }
              try {
                List<Table> tablesResult = apiFuture.get();
                if (tablesResult != null) {
                  for (Table table : tablesResult) {
                    if (Thread.currentThread().isInterrupted()) break;

                    final Table currentTable = table;
                    Future<?> processFuture =
                        tableProcessorExecutor.submit(
                            () ->
                                processTableInfo(
                                    currentTable,
                                    requestedTypes,
                                    collectedResults,
                                    localResultSchemaFields));
                    processingFutures.add(processFuture);
                  }
                }
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOG.warning("Fetcher thread interrupted while waiting for API future result.");
                break;
              } catch (ExecutionException e) {
                LOG.warning(
                    "Error executing findMatchingTables task: "
                        + e.getMessage()
                        + ". Cause: "
                        + e.getCause());
              } catch (CancellationException e) {
                LOG.warning("A findMatchingTables task was cancelled.");
              }
            }

            LOG.fine(
                "Finished submitting " + processingFutures.size() + " processTableInfo tasks.");

            if (Thread.currentThread().isInterrupted()) {
              LOG.warning(
                  "Fetcher interrupted before waiting for processing tasks; cancelling remaining.");
              processingFutures.forEach(f -> f.cancel(true));
            } else {
              LOG.fine("Waiting for processTableInfo tasks to complete...");
              waitForTasksCompletion(processingFutures);
              LOG.fine("All processTableInfo tasks completed.");
            }

            if (!Thread.currentThread().isInterrupted()) {
              Comparator<FieldValueList> comparator =
                  defineGetTablesComparator(localResultSchemaFields);
              sortResults(collectedResults, comparator, "getTables", LOG);
            }

            if (!Thread.currentThread().isInterrupted()) {
              populateQueue(collectedResults, queue, localResultSchemaFields);
            }

          } catch (Throwable t) {
            LOG.severe("Unexpected error in table fetcher runnable: " + t.getMessage());
            apiFutures.forEach(f -> f.cancel(true));
            processingFutures.forEach(f -> f.cancel(true));
          } finally {
            signalEndOfData(queue, localResultSchemaFields);
            shutdownExecutor(apiExecutor);
            shutdownExecutor(tableProcessorExecutor);
            LOG.info("Table fetcher thread finished.");
          }
        };

    Thread fetcherThread = new Thread(tableFetcher, "getTables-fetcher-" + effectiveCatalog);
    BigQueryJsonResultSet resultSet =
        BigQueryJsonResultSet.of(
            resultSchema, -1, queue, this.statement, new Thread[] {fetcherThread});

    fetcherThread.start();
    LOG.info("Started background thread for getTables");
    return resultSet;
  }

  Schema defineGetTablesSchema() {
    List<Field> fields = new ArrayList<>(10);
    fields.add(
        Field.newBuilder("TABLE_CAT", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("TABLE_SCHEM", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("TABLE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("TABLE_TYPE", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("REMARKS", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("TYPE_CAT", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("TYPE_SCHEM", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("TYPE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("SELF_REFERENCING_COL_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("REF_GENERATION", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    return Schema.of(fields);
  }

  void processTableInfo(
      Table table,
      Set<String> requestedTypes,
      List<FieldValueList> collectedResults,
      FieldList resultSchemaFields) {

    TableId tableId = table.getTableId();
    LOG.fine("Processing table info for: " + tableId);

    try {
      String catalogName = tableId.getProject();
      String schemaName = tableId.getDataset();
      String tableName = tableId.getTable();
      TableDefinition definition = table.getDefinition();
      String bqTableType = definition.getType().toString();
      String remarks = table.getDescription();

      if (requestedTypes != null && !requestedTypes.contains(bqTableType)) {
        LOG.finer(
            String.format(
                "Skipping table %s as its type '%s' is not in the requested types %s",
                tableId, bqTableType, requestedTypes));
        return;
      }

      List<FieldValue> values = new ArrayList<>(resultSchemaFields.size());
      values.add(createStringFieldValue(catalogName)); // 1. TABLE_CAT
      values.add(createStringFieldValue(schemaName)); // 2. TABLE_SCHEM
      values.add(createStringFieldValue(tableName)); // 3. TABLE_NAME
      values.add(createStringFieldValue(bqTableType)); // 4. TABLE_TYPE
      values.add(createStringFieldValue(remarks)); // 5. REMARKS
      values.add(createNullFieldValue()); // 6. TYPE_CAT (always null)
      values.add(createNullFieldValue()); // 7. TYPE_SCHEM (always null)
      values.add(createNullFieldValue()); // 8. TYPE_NAME (always null)
      values.add(createNullFieldValue()); // 9. SELF_REFERENCING_COL_NAME (always null)
      values.add(createNullFieldValue()); // 10. REF_GENERATION (always null)

      FieldValueList rowFvl = FieldValueList.of(values, resultSchemaFields);
      collectedResults.add(rowFvl);

      LOG.fine("Processed and added table info row for: " + tableId);
    } catch (Exception e) {
      LOG.warning(
          String.format(
              "Error processing table info for %s: %s. Skipping this table.",
              tableId, e.getMessage()));
    }
  }

  Comparator<FieldValueList> defineGetTablesComparator(FieldList resultSchemaFields) {
    final int TABLE_TYPE_IDX = resultSchemaFields.getIndex("TABLE_TYPE");
    final int TABLE_CAT_IDX = resultSchemaFields.getIndex("TABLE_CAT");
    final int TABLE_SCHEM_IDX = resultSchemaFields.getIndex("TABLE_SCHEM");
    final int TABLE_NAME_IDX = resultSchemaFields.getIndex("TABLE_NAME");
    return Comparator.comparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, TABLE_TYPE_IDX),
            Comparator.nullsFirst(String::compareTo))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, TABLE_CAT_IDX),
            Comparator.nullsFirst(String::compareTo))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, TABLE_SCHEM_IDX),
            Comparator.nullsFirst(String::compareTo))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, TABLE_NAME_IDX),
            Comparator.nullsFirst(String::compareTo));
  }

  @Override
  public ResultSet getSchemas() {
    LOG.info("getSchemas() called");

    return getSchemas(null, null);
  }

  @Override
  public ResultSet getCatalogs() {
    LOG.info("getCatalogs() called");

    final List<String> accessibleCatalogs = getAccessibleCatalogNames();
    final Schema catalogsSchema = defineGetCatalogsSchema();
    final FieldList schemaFields = catalogsSchema.getFields();
    final List<FieldValueList> catalogRows =
        prepareGetCatalogsRows(schemaFields, accessibleCatalogs);

    final BlockingQueue<BigQueryFieldValueListWrapper> queue =
        new LinkedBlockingQueue<>(catalogRows.isEmpty() ? 1 : catalogRows.size() + 1);

    populateQueue(catalogRows, queue, schemaFields);
    signalEndOfData(queue, schemaFields);

    return BigQueryJsonResultSet.of(
        catalogsSchema, catalogRows.size(), queue, this.statement, new Thread[0]);
  }

  Schema defineGetCatalogsSchema() {
    return Schema.of(
        Field.newBuilder("TABLE_CAT", StandardSQLTypeName.STRING).setMode(Mode.REQUIRED).build());
  }

  List<FieldValueList> prepareGetCatalogsRows(
      FieldList schemaFields, List<String> accessibleCatalogs) {
    List<FieldValueList> catalogRows = new ArrayList<>();
    for (String catalogName : accessibleCatalogs) {
      FieldValue fieldValue = FieldValue.of(FieldValue.Attribute.PRIMITIVE, catalogName);
      catalogRows.add(FieldValueList.of(Collections.singletonList(fieldValue), schemaFields));
    }
    return catalogRows;
  }

  @Override
  public ResultSet getTableTypes() {
    LOG.info("getTableTypes() called");

    final Schema tableTypesSchema = defineGetTableTypesSchema();
    final List<FieldValueList> tableTypeRows = prepareGetTableTypesRows(tableTypesSchema);

    BlockingQueue<BigQueryFieldValueListWrapper> queue =
        new LinkedBlockingQueue<>(tableTypeRows.size() + 1);

    populateQueue(tableTypeRows, queue, tableTypesSchema.getFields());
    signalEndOfData(queue, tableTypesSchema.getFields());

    return BigQueryJsonResultSet.of(
        tableTypesSchema, tableTypeRows.size(), queue, this.statement, new Thread[0]);
  }

  static Schema defineGetTableTypesSchema() {
    return Schema.of(
        Field.newBuilder("TABLE_TYPE", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
  }

  static List<FieldValueList> prepareGetTableTypesRows(Schema schema) {
    final String[] tableTypes = {"EXTERNAL", "MATERIALIZED VIEW", "SNAPSHOT", "TABLE", "VIEW"};
    List<FieldValueList> rows = new ArrayList<>(tableTypes.length);
    FieldList schemaFields = schema.getFields();

    for (String typeName : tableTypes) {
      FieldValue fieldValue = FieldValue.of(FieldValue.Attribute.PRIMITIVE, typeName);
      rows.add(FieldValueList.of(Collections.singletonList(fieldValue), schemaFields));
    }
    return rows;
  }

  @Override
  public ResultSet getColumns(
      String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) {

    Tuple<String, String> effectiveIdentifiers =
        determineEffectiveCatalogAndSchema(catalog, schemaPattern);
    String effectiveCatalog = effectiveIdentifiers.x();
    String effectiveSchemaPattern = effectiveIdentifiers.y();

    if ((effectiveCatalog == null || effectiveCatalog.isEmpty())
        || (effectiveSchemaPattern != null && effectiveSchemaPattern.isEmpty())
        || (tableNamePattern != null && tableNamePattern.isEmpty())
        || (columnNamePattern != null && columnNamePattern.isEmpty())) {
      LOG.warning(
          "Returning empty ResultSet as one or more patterns are empty or catalog is null.");
      return new BigQueryJsonResultSet();
    }

    LOG.info(
        String.format(
            "getColumns called for catalog: %s, schemaPattern: %s, tableNamePattern: %s,"
                + " columnNamePattern: %s",
            effectiveCatalog, effectiveSchemaPattern, tableNamePattern, columnNamePattern));

    Pattern schemaRegex = compileSqlLikePattern(effectiveSchemaPattern);
    Pattern tableNameRegex = compileSqlLikePattern(tableNamePattern);
    Pattern columnNameRegex = compileSqlLikePattern(columnNamePattern);

    final Schema resultSchema = defineGetColumnsSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();
    final BlockingQueue<BigQueryFieldValueListWrapper> queue =
        new LinkedBlockingQueue<>(DEFAULT_QUEUE_CAPACITY);
    final List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());
    final String catalogParam = effectiveCatalog;
    final String schemaParam = effectiveSchemaPattern;

    Runnable columnFetcher =
        () -> {
          ExecutorService columnExecutor = null;
          final List<Future<?>> taskFutures = new ArrayList<>();
          final FieldList localResultSchemaFields = resultSchemaFields;

          try {
            List<Dataset> datasetsToScan =
                findMatchingBigQueryObjects(
                    "Dataset",
                    () ->
                        bigquery.listDatasets(
                            catalogParam, DatasetListOption.pageSize(DEFAULT_PAGE_SIZE)),
                    (name) -> bigquery.getDataset(DatasetId.of(catalogParam, name)),
                    (ds) -> ds.getDatasetId().getDataset(),
                    schemaParam,
                    schemaRegex,
                    LOG);

            if (datasetsToScan.isEmpty()) {
              LOG.info("Fetcher thread found no matching datasets. Returning empty resultset.");
              return;
            }

            columnExecutor = Executors.newFixedThreadPool(this.metadataFetchThreadCount);

            for (Dataset dataset : datasetsToScan) {
              if (Thread.currentThread().isInterrupted()) {
                LOG.warning("Fetcher interrupted during dataset iteration.");
                break;
              }

              DatasetId datasetId = dataset.getDatasetId();
              LOG.info("Processing dataset: " + datasetId.getDataset());

              List<Table> tablesToScan =
                  findMatchingBigQueryObjects(
                      "Table",
                      () ->
                          bigquery.listTables(
                              datasetId, TableListOption.pageSize(DEFAULT_PAGE_SIZE)),
                      (name) ->
                          bigquery.getTable(
                              TableId.of(datasetId.getProject(), datasetId.getDataset(), name)),
                      (tbl) -> tbl.getTableId().getTable(),
                      tableNamePattern,
                      tableNameRegex,
                      LOG);

              for (Table table : tablesToScan) {
                if (Thread.currentThread().isInterrupted()) {
                  LOG.warning(
                      "Fetcher interrupted during table iteration for dataset "
                          + datasetId.getDataset());
                  break;
                }

                TableId tableId = table.getTableId();
                LOG.fine("Submitting task for table: " + tableId);
                final Table finalTable = table;
                Future<?> future =
                    columnExecutor.submit(
                        () ->
                            processTableColumns(
                                finalTable,
                                columnNameRegex,
                                collectedResults,
                                localResultSchemaFields));
                taskFutures.add(future);
              }
              if (Thread.currentThread().isInterrupted()) break;
            }

            waitForTasksCompletion(taskFutures);

            if (!Thread.currentThread().isInterrupted()) {
              Comparator<FieldValueList> comparator =
                  defineGetColumnsComparator(localResultSchemaFields);
              sortResults(collectedResults, comparator, "getColumns", LOG);
            }

            if (!Thread.currentThread().isInterrupted()) {
              populateQueue(collectedResults, queue, localResultSchemaFields);
            }

          } catch (Throwable t) {
            LOG.severe("Unexpected error in column fetcher runnable: " + t.getMessage());
            taskFutures.forEach(f -> f.cancel(true));
          } finally {
            signalEndOfData(queue, localResultSchemaFields);
            shutdownExecutor(columnExecutor);
            LOG.info("Column fetcher thread finished.");
          }
        };

    Thread fetcherThread = new Thread(columnFetcher, "getColumns-fetcher-" + effectiveCatalog);
    BigQueryJsonResultSet resultSet =
        BigQueryJsonResultSet.of(resultSchema, -1, queue, null, new Thread[] {fetcherThread});

    fetcherThread.start();
    LOG.info("Started background thread for getColumns");
    return resultSet;
  }

  private void processTableColumns(
      Table table,
      Pattern columnNameRegex,
      List<FieldValueList> collectedResults,
      FieldList resultSchemaFields) {
    TableId tableId = table.getTableId();
    LOG.fine("Processing columns for table: " + tableId);
    TableDefinition definition = table.getDefinition();
    Schema tableSchema = (definition != null) ? definition.getSchema() : null;

    try {
      if (tableSchema == null) {
        LOG.fine(
            "Schema not included in table object for "
                + tableId
                + ", fetching full table details...");
        Table fullTable = bigquery.getTable(tableId);
        if (fullTable != null) {
          definition = fullTable.getDefinition();
          tableSchema = (definition != null) ? definition.getSchema() : null;
        } else {
          LOG.warning(
              "Table " + tableId + " not found when fetching full details for columns. Skipping.");
          return;
        }
      }

      if (tableSchema == null
          || tableSchema.getFields() == null
          || tableSchema.getFields().isEmpty()) {
        LOG.warning(
            String.format(
                "Schema not found or fields are null for table %s (Type: %s). Skipping columns.",
                tableId, definition.getType()));
        return;
      }

      FieldList fields = tableSchema.getFields();
      String catalogName = tableId.getProject();
      String schemaName = tableId.getDataset();
      String tableName = tableId.getTable();

      for (int i = 0; i < fields.size(); i++) {
        if (Thread.currentThread().isInterrupted()) {
          LOG.warning("Task for table " + tableId + " interrupted during column iteration.");
          break;
        }
        Field field = fields.get(i);
        String currentColumnName = field.getName();
        if (columnNameRegex != null && !columnNameRegex.matcher(currentColumnName).matches())
          continue;
        List<FieldValue> values = createColumnRow(catalogName, schemaName, tableName, field, i + 1);
        FieldValueList rowFvl = FieldValueList.of(values, resultSchemaFields);
        collectedResults.add(rowFvl);
      }
      LOG.fine("Finished processing columns for table: " + tableId);
    } catch (BigQueryException e) {
      LOG.warning(
          String.format(
              "BigQueryException processing table %s: %s (Code: %d)",
              tableId, e.getMessage(), e.getCode()));
    } catch (Exception e) {
      LOG.severe(
          String.format("Unexpected error processing table %s: %s", tableId, e.getMessage()));
    }
  }

  private Schema defineGetColumnsSchema() {
    List<Field> fields = new ArrayList<>(24);
    fields.add(
        Field.newBuilder("TABLE_CAT", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 1
    fields.add(
        Field.newBuilder("TABLE_SCHEM", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 2
    fields.add(
        Field.newBuilder("TABLE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build()); // 3
    fields.add(
        Field.newBuilder("COLUMN_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build()); // 4
    fields.add(
        Field.newBuilder("DATA_TYPE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.REQUIRED)
            .build()); // 5
    fields.add(
        Field.newBuilder("TYPE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build()); // 6
    fields.add(
        Field.newBuilder("COLUMN_SIZE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 7
    fields.add(
        Field.newBuilder("BUFFER_LENGTH", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 8
    fields.add(
        Field.newBuilder("DECIMAL_DIGITS", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 9
    fields.add(
        Field.newBuilder("NUM_PREC_RADIX", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 10
    fields.add(
        Field.newBuilder("NULLABLE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.REQUIRED)
            .build()); // 11
    fields.add(
        Field.newBuilder("REMARKS", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 12
    fields.add(
        Field.newBuilder("COLUMN_DEF", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 13
    fields.add(
        Field.newBuilder("SQL_DATA_TYPE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 14
    fields.add(
        Field.newBuilder("SQL_DATETIME_SUB", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 15
    fields.add(
        Field.newBuilder("CHAR_OCTET_LENGTH", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 16
    fields.add(
        Field.newBuilder("ORDINAL_POSITION", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.REQUIRED)
            .build()); // 17
    fields.add(
        Field.newBuilder("IS_NULLABLE", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build()); // 18
    fields.add(
        Field.newBuilder("SCOPE_CATALOG", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 19
    fields.add(
        Field.newBuilder("SCOPE_SCHEMA", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 20
    fields.add(
        Field.newBuilder("SCOPE_TABLE", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 21
    fields.add(
        Field.newBuilder("SOURCE_DATA_TYPE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 22
    fields.add(
        Field.newBuilder("IS_AUTOINCREMENT", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build()); // 23
    fields.add(
        Field.newBuilder("IS_GENERATEDCOLUMN", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build()); // 24
    return Schema.of(fields);
  }

  List<FieldValue> createColumnRow(
      String catalog, String schemaName, String tableName, Field field, int ordinalPosition) {
    List<FieldValue> values = new ArrayList<>(24);
    Field.Mode mode = (field.getMode() == null) ? Field.Mode.NULLABLE : field.getMode();
    ColumnTypeInfo typeInfo = mapBigQueryTypeToJdbc(field);

    values.add(createStringFieldValue(catalog)); // 1. TABLE_CAT
    values.add(createStringFieldValue(schemaName)); // 2. TABLE_SCHEM
    values.add(createStringFieldValue(tableName)); // 3. TABLE_NAME
    values.add(createStringFieldValue(field.getName())); // 4. COLUMN_NAME
    values.add(createLongFieldValue((long) typeInfo.jdbcType)); // 5. DATA_TYPE
    values.add(createStringFieldValue(typeInfo.typeName)); // 6. TYPE_NAME
    values.add(
        createLongFieldValue(
            typeInfo.columnSize == null
                ? null
                : typeInfo.columnSize.longValue())); // 7. COLUMN_SIZE
    values.add(createNullFieldValue()); // 8. BUFFER_LENGTH
    values.add(
        createLongFieldValue(
            typeInfo.decimalDigits == null
                ? null
                : typeInfo.decimalDigits.longValue())); // 9. DECIMAL_DIGITS
    values.add(
        createLongFieldValue(
            typeInfo.numPrecRadix == null
                ? null
                : typeInfo.numPrecRadix.longValue())); // 10. NUM_PREC_RADIX
    int nullable =
        (mode == Field.Mode.REQUIRED)
            ? DatabaseMetaData.columnNoNulls
            : DatabaseMetaData.columnNullable;
    values.add(createLongFieldValue((long) nullable)); // 11. NULLABLE
    values.add(createStringFieldValue(field.getDescription())); // 12. REMARKS
    values.add(createNullFieldValue()); // 13. COLUMN_DEF
    values.add(createNullFieldValue()); // 14. SQL_DATA_TYPE
    values.add(createNullFieldValue()); // 15. SQL_DATETIME_SUB
    values.add(createNullFieldValue()); // 16. CHAR_OCTET_LENGTH
    values.add(createLongFieldValue((long) ordinalPosition)); // 17. ORDINAL_POSITION
    String isNullable = "";
    switch (mode) {
      case REQUIRED:
        isNullable = "NO";
        break;
      case NULLABLE:
      case REPEATED:
        isNullable = "YES";
        break;
    }
    values.add(createStringFieldValue(isNullable)); // 18. IS_NULLABLE
    values.add(createNullFieldValue()); // 19. SCOPE_CATALOG
    values.add(createNullFieldValue()); // 20. SCOPE_SCHEMA
    values.add(createNullFieldValue()); // 21. SCOPE_TABLE
    values.add(createNullFieldValue()); // 22. SOURCE_DATA_TYPE
    values.add(createStringFieldValue("NO")); // 23. IS_AUTOINCREMENT
    values.add(createStringFieldValue("NO")); // 24. IS_GENERATEDCOLUMN

    return values;
  }

  static class ColumnTypeInfo {
    final int jdbcType;
    final String typeName;
    final Integer columnSize;
    final Integer decimalDigits;
    final Integer numPrecRadix;

    ColumnTypeInfo(
        int jdbcType,
        String typeName,
        Integer columnSize,
        Integer decimalDigits,
        Integer numPrecRadix) {
      this.jdbcType = jdbcType;
      this.typeName = typeName;
      this.columnSize = columnSize;
      this.decimalDigits = decimalDigits;
      this.numPrecRadix = numPrecRadix;
    }
  }

  ColumnTypeInfo mapBigQueryTypeToJdbc(Field field) {
    Mode mode = (field.getMode() == null) ? Mode.NULLABLE : field.getMode();
    if (mode == Mode.REPEATED) {
      return new ColumnTypeInfo(Types.ARRAY, "ARRAY", null, null, null);
    }

    StandardSQLTypeName bqType = null;
    if (field.getType() != null && field.getType().getStandardType() != null) {
      bqType = field.getType().getStandardType();
    }
    return getColumnTypeInfoForSqlType(bqType);
  }

  private Comparator<FieldValueList> defineGetColumnsComparator(FieldList resultSchemaFields) {
    final int TABLE_CAT_IDX = resultSchemaFields.getIndex("TABLE_CAT");
    final int TABLE_SCHEM_IDX = resultSchemaFields.getIndex("TABLE_SCHEM");
    final int TABLE_NAME_IDX = resultSchemaFields.getIndex("TABLE_NAME");
    final int ORDINAL_POS_IDX = resultSchemaFields.getIndex("ORDINAL_POSITION");
    return Comparator.comparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, TABLE_CAT_IDX),
            Comparator.nullsFirst(String::compareTo))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, TABLE_SCHEM_IDX),
            Comparator.nullsFirst(String::compareTo))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, TABLE_NAME_IDX),
            Comparator.nullsFirst(String::compareTo))
        .thenComparing(
            (FieldValueList fvl) -> getLongValueOrNull(fvl, ORDINAL_POS_IDX),
            Comparator.nullsFirst(Long::compareTo));
  }

  @Override
  public ResultSet getColumnPrivileges(
      String catalog, String schema, String table, String columnNamePattern) {
    LOG.info(
        String.format(
            "getColumnPrivileges called for catalog: %s, schema: %s, table: %s, columnNamePattern:"
                + " %s. BigQuery IAM model differs from SQL privileges; returning empty ResultSet.",
            catalog, schema, table, columnNamePattern));

    final Schema resultSchema = defineGetColumnPrivilegesSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();
    final BlockingQueue<BigQueryFieldValueListWrapper> queue = new LinkedBlockingQueue<>(1);
    signalEndOfData(queue, resultSchemaFields);

    return BigQueryJsonResultSet.of(resultSchema, 0, queue, this.statement, null);
  }

  Schema defineGetColumnPrivilegesSchema() {
    List<Field> fields = defineBasePrivilegeFields();

    Field columnNameField =
        Field.newBuilder("COLUMN_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build();
    fields.add(3, columnNameField);

    return Schema.of(fields);
  }

  @Override
  public ResultSet getTablePrivileges(
      String catalog, String schemaPattern, String tableNamePattern) {
    LOG.info(
        String.format(
            "getTablePrivileges called for catalog: %s, schemaPattern: %s, tableNamePattern: %s. "
                + "BigQuery IAM model differs from SQL privileges; returning empty ResultSet.",
            catalog, schemaPattern, tableNamePattern));

    final Schema resultSchema = defineGetTablePrivilegesSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();
    final BlockingQueue<BigQueryFieldValueListWrapper> queue = new LinkedBlockingQueue<>(1);
    signalEndOfData(queue, resultSchemaFields);

    return BigQueryJsonResultSet.of(resultSchema, 0, queue, this.statement, null);
  }

  Schema defineGetTablePrivilegesSchema() {
    List<Field> fields = defineBasePrivilegeFields();
    return Schema.of(fields);
  }

  @Override
  public ResultSet getBestRowIdentifier(
      String catalog, String schema, String table, int scope, boolean nullable) {
    LOG.info(
        String.format(
            "getBestRowIdentifier called for catalog: %s, schema: %s, table: %s, scope: %d,"
                + " nullable: %s. BigQuery does not support best row identifiers; returning empty"
                + " ResultSet.",
            catalog, schema, table, scope, nullable));

    final Schema resultSchema = defineGetBestRowIdentifierSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();
    final BlockingQueue<BigQueryFieldValueListWrapper> queue = new LinkedBlockingQueue<>(1);
    signalEndOfData(queue, resultSchemaFields);

    return BigQueryJsonResultSet.of(resultSchema, 0, queue, this.statement, null);
  }

  Schema defineGetBestRowIdentifierSchema() {
    List<Field> fields = new ArrayList<>(8);
    fields.add(
        Field.newBuilder("SCOPE", StandardSQLTypeName.INT64).setMode(Field.Mode.REQUIRED).build());
    fields.add(
        Field.newBuilder("COLUMN_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("DATA_TYPE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("TYPE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("COLUMN_SIZE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("BUFFER_LENGTH", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("DECIMAL_DIGITS", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("PSEUDO_COLUMN", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.REQUIRED)
            .build());
    return Schema.of(fields);
  }

  @Override
  public ResultSet getVersionColumns(String catalog, String schema, String table) {
    LOG.info(
        String.format(
            "getVersionColumns called for catalog: %s, schema: %s, table: %s. "
                + "Automatic version columns not supported by BigQuery; returning empty ResultSet.",
            catalog, schema, table));

    final Schema resultSchema = defineGetVersionColumnsSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();
    final BlockingQueue<BigQueryFieldValueListWrapper> queue = new LinkedBlockingQueue<>(1);
    signalEndOfData(queue, resultSchemaFields);

    return BigQueryJsonResultSet.of(resultSchema, 0, queue, this.statement, null);
  }

  Schema defineGetVersionColumnsSchema() {
    List<Field> fields = new ArrayList<>(8);
    fields.add(
        Field.newBuilder("SCOPE", StandardSQLTypeName.INT64).setMode(Field.Mode.NULLABLE).build());
    fields.add(
        Field.newBuilder("COLUMN_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("DATA_TYPE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("TYPE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("COLUMN_SIZE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("BUFFER_LENGTH", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("DECIMAL_DIGITS", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("PSEUDO_COLUMN", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.REQUIRED)
            .build());
    return Schema.of(fields);
  }

  @Override
  public ResultSet getPrimaryKeys(String catalog, String schema, String table) throws SQLException {
    String sql = readSqlFromFile(GET_PRIMARY_KEYS_SQL);
    try {
      String formattedSql = replaceSqlParameters(sql, catalog, schema, table);
      return this.statement.executeQuery(formattedSql);
    } catch (SQLException e) {
      throw new BigQueryJdbcException(e);
    }
  }

  @Override
  public ResultSet getImportedKeys(String catalog, String schema, String table)
      throws SQLException {
    String sql = readSqlFromFile(GET_IMPORTED_KEYS_SQL);
    try {
      String formattedSql = replaceSqlParameters(sql, catalog, schema, table);
      return this.statement.executeQuery(formattedSql);
    } catch (SQLException e) {
      throw new BigQueryJdbcException(e);
    }
  }

  @Override
  public ResultSet getExportedKeys(String catalog, String schema, String table)
      throws SQLException {
    String sql = readSqlFromFile(GET_EXPORTED_KEYS_SQL);
    try {
      String formattedSql = replaceSqlParameters(sql, catalog, schema, table);
      return this.statement.executeQuery(formattedSql);
    } catch (SQLException e) {
      throw new BigQueryJdbcException(e);
    }
  }

  @Override
  public ResultSet getCrossReference(
      String parentCatalog,
      String parentSchema,
      String parentTable,
      String foreignCatalog,
      String foreignSchema,
      String foreignTable)
      throws SQLException {
    String sql = readSqlFromFile(GET_CROSS_REFERENCE_SQL);
    try {
      String formattedSql =
          replaceSqlParameters(
              sql,
              parentCatalog,
              parentSchema,
              parentTable,
              foreignCatalog,
              foreignSchema,
              foreignTable);
      return this.statement.executeQuery(formattedSql);
    } catch (SQLException e) {
      throw new BigQueryJdbcException(e);
    }
  }

  @Override
  public ResultSet getTypeInfo() {
    LOG.info("getTypeInfo() called");

    final Schema typeInfoSchema = defineGetTypeInfoSchema();
    final FieldList schemaFields = typeInfoSchema.getFields();
    final List<FieldValueList> typeInfoRows = prepareGetTypeInfoRows(schemaFields);

    final Comparator<FieldValueList> comparator = defineGetTypeInfoComparator(schemaFields);
    sortResults(typeInfoRows, comparator, "getTypeInfo", LOG);
    final BlockingQueue<BigQueryFieldValueListWrapper> queue =
        new LinkedBlockingQueue<>(typeInfoRows.size() + 1);

    populateQueue(typeInfoRows, queue, schemaFields);
    signalEndOfData(queue, schemaFields);
    return BigQueryJsonResultSet.of(
        typeInfoSchema, typeInfoRows.size(), queue, this.statement, new Thread[0]);
  }

  Schema defineGetTypeInfoSchema() {
    List<Field> fields = new ArrayList<>(18);
    fields.add(
        Field.newBuilder("TYPE_NAME", StandardSQLTypeName.STRING)
            .setMode(Mode.REQUIRED)
            .build()); // 1
    fields.add(
        Field.newBuilder("DATA_TYPE", StandardSQLTypeName.INT64)
            .setMode(Mode.REQUIRED)
            .build()); // 2
    fields.add(
        Field.newBuilder("PRECISION", StandardSQLTypeName.INT64)
            .setMode(Mode.NULLABLE)
            .build()); // 3
    fields.add(
        Field.newBuilder("LITERAL_PREFIX", StandardSQLTypeName.STRING)
            .setMode(Mode.NULLABLE)
            .build()); // 4
    fields.add(
        Field.newBuilder("LITERAL_SUFFIX", StandardSQLTypeName.STRING)
            .setMode(Mode.NULLABLE)
            .build()); // 5
    fields.add(
        Field.newBuilder("CREATE_PARAMS", StandardSQLTypeName.STRING)
            .setMode(Mode.NULLABLE)
            .build()); // 6
    fields.add(
        Field.newBuilder("NULLABLE", StandardSQLTypeName.INT64)
            .setMode(Mode.REQUIRED)
            .build()); // 7
    fields.add(
        Field.newBuilder("CASE_SENSITIVE", StandardSQLTypeName.BOOL)
            .setMode(Mode.REQUIRED)
            .build()); // 8
    fields.add(
        Field.newBuilder("SEARCHABLE", StandardSQLTypeName.INT64)
            .setMode(Mode.REQUIRED)
            .build()); // 9
    fields.add(
        Field.newBuilder("UNSIGNED_ATTRIBUTE", StandardSQLTypeName.BOOL)
            .setMode(Mode.NULLABLE)
            .build()); // 10
    fields.add(
        Field.newBuilder("FIXED_PREC_SCALE", StandardSQLTypeName.BOOL)
            .setMode(Mode.REQUIRED)
            .build()); // 11
    fields.add(
        Field.newBuilder("AUTO_INCREMENT", StandardSQLTypeName.BOOL)
            .setMode(Mode.REQUIRED)
            .build()); // 12
    fields.add(
        Field.newBuilder("LOCAL_TYPE_NAME", StandardSQLTypeName.STRING)
            .setMode(Mode.NULLABLE)
            .build()); // 13
    fields.add(
        Field.newBuilder("MINIMUM_SCALE", StandardSQLTypeName.INT64)
            .setMode(Mode.NULLABLE)
            .build()); // 14
    fields.add(
        Field.newBuilder("MAXIMUM_SCALE", StandardSQLTypeName.INT64)
            .setMode(Mode.NULLABLE)
            .build()); // 15
    fields.add(
        Field.newBuilder("SQL_DATA_TYPE", StandardSQLTypeName.INT64)
            .setMode(Mode.NULLABLE)
            .build()); // 16
    fields.add(
        Field.newBuilder("SQL_DATETIME_SUB", StandardSQLTypeName.INT64)
            .setMode(Mode.NULLABLE)
            .build()); // 17
    fields.add(
        Field.newBuilder("NUM_PREC_RADIX", StandardSQLTypeName.INT64)
            .setMode(Mode.NULLABLE)
            .build()); // 18
    return Schema.of(fields);
  }

  List<FieldValueList> prepareGetTypeInfoRows(FieldList schemaFields) {
    List<FieldValueList> rows = new ArrayList<>();

    Function<TypeInfoRowData, FieldValueList> createRow =
        (data) -> {
          List<FieldValue> values = new ArrayList<>(18);
          values.add(createStringFieldValue(data.typeName)); // 1. TYPE_NAME
          values.add(createLongFieldValue((long) data.jdbcType)); // 2. DATA_TYPE
          values.add(createLongFieldValue(data.precision)); // 3. PRECISION
          values.add(createStringFieldValue(data.literalPrefix)); // 4. LITERAL_PREFIX
          values.add(createStringFieldValue(data.literalSuffix)); // 5. LITERAL_SUFFIX
          values.add(createStringFieldValue(data.createParams)); // 6. CREATE_PARAMS
          values.add(createLongFieldValue((long) data.nullable)); // 7. NULLABLE
          values.add(createBooleanFieldValue(data.caseSensitive)); // 8. CASE_SENSITIVE
          values.add(createLongFieldValue((long) data.searchable)); // 9. SEARCHABLE
          values.add(createBooleanFieldValue(data.unsignedAttribute)); // 10. UNSIGNED_ATTRIBUTE
          values.add(createBooleanFieldValue(data.fixedPrecScale)); // 11. FIXED_PREC_SCALE
          values.add(createBooleanFieldValue(data.autoIncrement)); // 12. AUTO_INCREMENT
          values.add(createStringFieldValue(data.localTypeName)); // 13. LOCAL_TYPE_NAME
          values.add(createLongFieldValue(data.minimumScale)); // 14. MINIMUM_SCALE
          values.add(createLongFieldValue(data.maximumScale)); // 15. MAXIMUM_SCALE
          values.add(createNullFieldValue()); // 16. SQL_DATA_TYPE
          values.add(createNullFieldValue()); // 17. SQL_DATETIME_SUB
          values.add(createLongFieldValue(data.numPrecRadix)); // 18. NUM_PREC_RADIX
          return FieldValueList.of(values, schemaFields);
        };

    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "INT64",
                Types.BIGINT,
                19L,
                null,
                null,
                null,
                DatabaseMetaData.typeNullable,
                false,
                DatabaseMetaData.typeSearchable,
                false,
                false,
                false,
                "INT64",
                0L,
                0L,
                10L)));
    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "BOOL",
                Types.BOOLEAN,
                1L,
                null,
                null,
                null,
                DatabaseMetaData.typeNullable,
                false,
                DatabaseMetaData.typePredBasic,
                false,
                false,
                false,
                "BOOL",
                0L,
                0L,
                null)));
    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "FLOAT64",
                Types.DOUBLE,
                15L,
                null,
                null,
                null,
                DatabaseMetaData.typeNullable,
                false,
                DatabaseMetaData.typeSearchable,
                false,
                false,
                false,
                "FLOAT64",
                null,
                null,
                2L)));
    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "NUMERIC",
                Types.NUMERIC,
                38L,
                null,
                null,
                "PRECISION,SCALE",
                DatabaseMetaData.typeNullable,
                false,
                DatabaseMetaData.typeSearchable,
                false,
                true,
                false,
                "NUMERIC",
                9L,
                9L,
                10L)));
    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "BIGNUMERIC",
                Types.NUMERIC,
                77L,
                null,
                null,
                "PRECISION,SCALE",
                DatabaseMetaData.typeNullable,
                false,
                DatabaseMetaData.typeSearchable,
                false,
                true,
                false,
                "BIGNUMERIC",
                38L,
                38L,
                10L)));
    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "STRING",
                Types.NVARCHAR,
                null,
                "'",
                "'",
                "LENGTH",
                DatabaseMetaData.typeNullable,
                true,
                DatabaseMetaData.typeSearchable,
                false,
                false,
                false,
                "STRING",
                null,
                null,
                null)));
    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "TIMESTAMP",
                Types.TIMESTAMP,
                29L,
                "'",
                "'",
                null,
                DatabaseMetaData.typeNullable,
                false,
                DatabaseMetaData.typeSearchable,
                false,
                false,
                false,
                "TIMESTAMP",
                null,
                null,
                null)));
    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "DATE",
                Types.DATE,
                10L,
                "'",
                "'",
                null,
                DatabaseMetaData.typeNullable,
                false,
                DatabaseMetaData.typeSearchable,
                false,
                false,
                false,
                "DATE",
                null,
                null,
                null)));
    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "TIME",
                Types.TIME,
                15L,
                "'",
                "'",
                null,
                DatabaseMetaData.typeNullable,
                false,
                DatabaseMetaData.typeSearchable,
                false,
                false,
                false,
                "TIME",
                null,
                null,
                null)));
    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "DATETIME",
                Types.TIMESTAMP,
                29L,
                "'",
                "'",
                null,
                DatabaseMetaData.typeNullable,
                false,
                DatabaseMetaData.typeSearchable,
                false,
                false,
                false,
                "DATETIME",
                null,
                null,
                null)));
    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "GEOGRAPHY",
                Types.OTHER,
                null,
                "'",
                "'",
                null,
                DatabaseMetaData.typeNullable,
                false,
                DatabaseMetaData.typeSearchable,
                false,
                false,
                false,
                "GEOGRAPHY",
                null,
                null,
                null)));
    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "JSON",
                Types.OTHER,
                null,
                "'",
                "'",
                null,
                DatabaseMetaData.typeNullable,
                false,
                DatabaseMetaData.typeSearchable,
                false,
                false,
                false,
                "JSON",
                null,
                null,
                null)));
    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "INTERVAL",
                Types.OTHER,
                null,
                "'",
                "'",
                null,
                DatabaseMetaData.typeNullable,
                false,
                DatabaseMetaData.typeSearchable,
                false,
                false,
                false,
                "INTERVAL",
                null,
                null,
                null)));
    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "BYTES",
                Types.VARBINARY,
                null,
                "0x",
                null,
                "LENGTH",
                DatabaseMetaData.typeNullable,
                false,
                DatabaseMetaData.typeSearchable,
                false,
                false,
                false,
                "BYTES",
                null,
                null,
                null)));
    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "STRUCT",
                Types.STRUCT,
                null,
                null,
                null,
                null,
                DatabaseMetaData.typeNullable,
                false,
                DatabaseMetaData.typePredNone,
                false,
                false,
                false,
                "STRUCT",
                null,
                null,
                null)));
    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "ARRAY",
                Types.ARRAY,
                null,
                null,
                null,
                null,
                DatabaseMetaData.typeNullable,
                false,
                DatabaseMetaData.typePredNone,
                false,
                false,
                false,
                "ARRAY",
                null,
                null,
                null)));
    rows.add(
        createRow.apply(
            new TypeInfoRowData(
                "RANGE",
                Types.OTHER,
                null,
                null,
                null,
                null,
                DatabaseMetaData.typeNullable,
                false,
                DatabaseMetaData.typeSearchable,
                false,
                false,
                false,
                "RANGE",
                null,
                null,
                null)));

    return rows;
  }

  Comparator<FieldValueList> defineGetTypeInfoComparator(FieldList schemaFields) {
    final int DATA_TYPE_IDX = schemaFields.getIndex("DATA_TYPE");
    if (DATA_TYPE_IDX < 0) {
      LOG.severe(
          "Could not find DATA_TYPE column in getTypeInfo schema for sorting. Returning null"
              + " comparator.");
      return null;
    }
    Comparator<FieldValueList> comparator =
        Comparator.comparing(
            (FieldValueList fvl) -> getLongValueOrNull(fvl, DATA_TYPE_IDX),
            Comparator.nullsFirst(Long::compareTo));
    return comparator;
  }

  @Override
  public ResultSet getIndexInfo(
      String catalog, String schema, String table, boolean unique, boolean approximate) {
    LOG.info(
        String.format(
            "getIndexInfo called for catalog: %s, schema: %s, table: %s, unique: %s, approximate:"
                + " %s. Traditional indexes not supported by BigQuery; returning empty ResultSet.",
            catalog, schema, table, unique, approximate));

    final Schema resultSchema = defineGetIndexInfoSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();
    final BlockingQueue<BigQueryFieldValueListWrapper> queue = new LinkedBlockingQueue<>(1);
    signalEndOfData(queue, resultSchemaFields);

    return BigQueryJsonResultSet.of(resultSchema, 0, queue, this.statement, null);
  }

  Schema defineGetIndexInfoSchema() {
    List<Field> fields = new ArrayList<>(13);
    fields.add(
        Field.newBuilder("TABLE_CAT", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("TABLE_SCHEM", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("TABLE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("NON_UNIQUE", StandardSQLTypeName.BOOL)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("INDEX_QUALIFIER", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("INDEX_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("TYPE", StandardSQLTypeName.INT64).setMode(Field.Mode.REQUIRED).build());
    fields.add(
        Field.newBuilder("ORDINAL_POSITION", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("COLUMN_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("ASC_OR_DESC", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("CARDINALITY", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("PAGES", StandardSQLTypeName.INT64).setMode(Field.Mode.NULLABLE).build());
    fields.add(
        Field.newBuilder("FILTER_CONDITION", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    return Schema.of(fields);
  }

  @Override
  public boolean supportsResultSetType(int type) {
    // BigQuery primarily supports forward-only result sets.
    return type == ResultSet.TYPE_FORWARD_ONLY;
  }

  @Override
  public boolean supportsResultSetConcurrency(int type, int concurrency) {
    // BigQuery primarily supports forward-only, read-only result sets.
    return type == ResultSet.TYPE_FORWARD_ONLY && concurrency == ResultSet.CONCUR_READ_ONLY;
  }

  @Override
  public boolean ownUpdatesAreVisible(int type) {
    return false;
  }

  @Override
  public boolean ownDeletesAreVisible(int type) {
    return false;
  }

  @Override
  public boolean ownInsertsAreVisible(int type) {
    return false;
  }

  @Override
  public boolean othersUpdatesAreVisible(int type) {
    return false;
  }

  @Override
  public boolean othersDeletesAreVisible(int type) {
    return false;
  }

  @Override
  public boolean othersInsertsAreVisible(int type) {
    return false;
  }

  @Override
  public boolean updatesAreDetected(int type) {
    return false;
  }

  @Override
  public boolean deletesAreDetected(int type) {
    return false;
  }

  @Override
  public boolean insertsAreDetected(int type) {
    return false;
  }

  @Override
  public boolean supportsBatchUpdates() {
    return false;
  }

  @Override
  public ResultSet getUDTs(
      String catalog, String schemaPattern, String typeNamePattern, int[] types) {
    LOG.info(
        String.format(
            "getUDTs called for catalog: %s, schemaPattern: %s, typeNamePattern: %s, types: %s. "
                + "Feature not supported by BigQuery; returning empty ResultSet.",
            catalog,
            schemaPattern,
            typeNamePattern,
            (types == null ? "null" : Arrays.toString(types))));

    final Schema resultSchema = defineGetUDTsSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();
    final BlockingQueue<BigQueryFieldValueListWrapper> queue = new LinkedBlockingQueue<>(1);
    signalEndOfData(queue, resultSchemaFields);

    return BigQueryJsonResultSet.of(resultSchema, 0, queue, this.statement, null);
  }

  Schema defineGetUDTsSchema() {
    List<Field> fields = new ArrayList<>(7);
    fields.add(
        Field.newBuilder("TYPE_CAT", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("TYPE_SCHEM", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("TYPE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("CLASS_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("DATA_TYPE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("REMARKS", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("BASE_TYPE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    return Schema.of(fields);
  }

  @Override
  public Connection getConnection() {
    return connection;
  }

  @Override
  public boolean supportsSavepoints() {
    return false;
  }

  @Override
  public boolean supportsNamedParameters() {
    return false;
  }

  @Override
  public boolean supportsMultipleOpenResults() {
    return false;
  }

  @Override
  public boolean supportsGetGeneratedKeys() {
    return false;
  }

  @Override
  public ResultSet getSuperTables(String catalog, String schemaPattern, String tableNamePattern) {
    LOG.info(
        String.format(
            "getSuperTables called for catalog: %s, schemaPattern: %s, tableNamePattern: %s. "
                + "BigQuery does not support super tables; returning empty ResultSet.",
            catalog, schemaPattern, tableNamePattern));

    final Schema resultSchema = defineGetSuperTablesSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();
    final BlockingQueue<BigQueryFieldValueListWrapper> queue = new LinkedBlockingQueue<>(1);

    signalEndOfData(queue, resultSchemaFields);

    return BigQueryJsonResultSet.of(resultSchema, 0, queue, this.statement, null);
  }

  Schema defineGetSuperTablesSchema() {
    List<Field> fields = new ArrayList<>(4);
    fields.add(
        Field.newBuilder("TABLE_CAT", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 1. TABLE_CAT
    fields.add(
        Field.newBuilder("TABLE_SCHEM", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 2. TABLE_SCHEM
    fields.add(
        Field.newBuilder("TABLE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build()); // 3. TABLE_NAME
    fields.add(
        Field.newBuilder("SUPERTABLE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build()); // 4. SUPERTABLE_NAME
    return Schema.of(fields);
  }

  @Override
  public ResultSet getSuperTypes(String catalog, String schemaPattern, String typeNamePattern) {
    LOG.info(
        String.format(
            "getSuperTypes called for catalog: %s, schemaPattern: %s, typeNamePattern: %s. BigQuery"
                + " does not support user-defined type hierarchies; returning empty ResultSet.",
            catalog, schemaPattern, typeNamePattern));

    final Schema resultSchema = defineGetSuperTypesSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();
    final BlockingQueue<BigQueryFieldValueListWrapper> queue = new LinkedBlockingQueue<>(1);

    signalEndOfData(queue, resultSchemaFields);

    return BigQueryJsonResultSet.of(resultSchema, 0, queue, this.statement, null);
  }

  Schema defineGetSuperTypesSchema() {
    List<Field> fields = new ArrayList<>(6);
    fields.add(
        Field.newBuilder("TYPE_CAT", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 1. TYPE_CAT
    fields.add(
        Field.newBuilder("TYPE_SCHEM", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 2. TYPE_SCHEM
    fields.add(
        Field.newBuilder("TYPE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build()); // 3. TYPE_NAME
    fields.add(
        Field.newBuilder("SUPERTYPE_CAT", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 4. SUPERTYPE_CAT
    fields.add(
        Field.newBuilder("SUPERTYPE_SCHEM", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 5. SUPERTYPE_SCHEM
    fields.add(
        Field.newBuilder("SUPERTYPE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build()); // 6. SUPERTYPE_NAME
    return Schema.of(fields);
  }

  @Override
  public ResultSet getAttributes(
      String catalog, String schemaPattern, String typeNamePattern, String attributeNamePattern) {
    LOG.info(
        String.format(
            "getAttributes called for catalog: %s, schemaPattern: %s, typeNamePattern: %s,"
                + " attributeNamePattern: %s. Feature not supported by BigQuery; returning empty"
                + " ResultSet.",
            catalog, schemaPattern, typeNamePattern, attributeNamePattern));

    final Schema resultSchema = defineGetAttributesSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();
    final BlockingQueue<BigQueryFieldValueListWrapper> queue = new LinkedBlockingQueue<>(1);
    signalEndOfData(queue, resultSchemaFields);

    return BigQueryJsonResultSet.of(resultSchema, 0, queue, this.statement, null);
  }

  Schema defineGetAttributesSchema() {
    List<Field> fields = new ArrayList<>(21);
    fields.add(
        Field.newBuilder("TYPE_CAT", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("TYPE_SCHEM", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("TYPE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("ATTR_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("DATA_TYPE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("ATTR_TYPE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("ATTR_SIZE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("DECIMAL_DIGITS", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("NUM_PREC_RADIX", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("NULLABLE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("REMARKS", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("ATTR_DEF", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("SQL_DATA_TYPE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("SQL_DATETIME_SUB", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("CHAR_OCTET_LENGTH", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("ORDINAL_POSITION", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("IS_NULLABLE", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("SCOPE_CATALOG", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("SCOPE_SCHEMA", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("SCOPE_TABLE", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("SOURCE_DATA_TYPE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    return Schema.of(fields);
  }

  @Override
  public boolean supportsResultSetHoldability(int holdability) {
    if (holdability == ResultSet.CLOSE_CURSORS_AT_COMMIT) {
      return true;
    }
    return false;
  }

  @Override
  public int getResultSetHoldability() {
    return ResultSet.CLOSE_CURSORS_AT_COMMIT;
  }

  @Override
  // Obtained from java libraries pom
  // https://github.com/googleapis/java-bigquery/blob/main/pom.xml
  public int getDatabaseMajorVersion() {
    return 2;
  }

  @Override
  public int getDatabaseMinorVersion() {
    return 0;
  }

  @Override
  public int getJDBCMajorVersion() {
    return 4;
  }

  @Override
  public int getJDBCMinorVersion() {
    return 2;
  }

  @Override
  public int getSQLStateType() {
    return DatabaseMetaData.sqlStateSQL;
  }

  @Override
  public boolean locatorsUpdateCopy() {
    return false;
  }

  @Override
  public boolean supportsStatementPooling() {
    return false;
  }

  @Override
  public RowIdLifetime getRowIdLifetime() {
    return null;
  }

  @Override
  public ResultSet getSchemas(String catalog, String schemaPattern) {
    if ((catalog != null && catalog.isEmpty())
        || (schemaPattern != null && schemaPattern.isEmpty())) {
      LOG.warning("Returning empty ResultSet as catalog or schemaPattern is an empty string.");
      return new BigQueryJsonResultSet();
    }

    LOG.info(
        String.format(
            "getSchemas called for catalog: %s, schemaPattern: %s", catalog, schemaPattern));

    final Pattern schemaRegex = compileSqlLikePattern(schemaPattern);
    final Schema resultSchema = defineGetSchemasSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();

    final BlockingQueue<BigQueryFieldValueListWrapper> queue =
        new LinkedBlockingQueue<>(DEFAULT_QUEUE_CAPACITY);
    final List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());
    final String catalogParam = catalog;

    Runnable schemaFetcher =
        () -> {
          final FieldList localResultSchemaFields = resultSchemaFields;
          List<String> projectsToScanList = new ArrayList<>();

          if (catalogParam != null) {
            projectsToScanList.add(catalogParam);
          } else {
            projectsToScanList.addAll(getAccessibleCatalogNames());
          }

          if (projectsToScanList.isEmpty()) {
            LOG.info(
                "No valid projects to scan (primary, specified, or additional). Returning empty"
                    + " resultset.");
            return;
          }

          try {
            for (String currentProjectToScan : projectsToScanList) {
              if (Thread.currentThread().isInterrupted()) {
                LOG.warning(
                    "Schema fetcher interrupted during project iteration for project: "
                        + currentProjectToScan);
                break;
              }
              LOG.info("Fetching schemas for project: " + currentProjectToScan);
              List<Dataset> datasetsInProject =
                  findMatchingBigQueryObjects(
                      "Dataset",
                      () ->
                          bigquery.listDatasets(
                              currentProjectToScan,
                              BigQuery.DatasetListOption.pageSize(DEFAULT_PAGE_SIZE)),
                      (name) -> bigquery.getDataset(DatasetId.of(currentProjectToScan, name)),
                      (ds) -> ds.getDatasetId().getDataset(),
                      schemaPattern,
                      schemaRegex,
                      LOG);

              if (datasetsInProject.isEmpty() || Thread.currentThread().isInterrupted()) {
                LOG.info(
                    "Fetcher thread found no matching datasets in project: "
                        + currentProjectToScan);
                continue;
              }

              LOG.fine("Processing found datasets for project: " + currentProjectToScan);
              for (Dataset dataset : datasetsInProject) {
                if (Thread.currentThread().isInterrupted()) {
                  LOG.warning(
                      "Schema fetcher interrupted during dataset iteration for project: "
                          + currentProjectToScan);
                  break;
                }
                processSchemaInfo(dataset, collectedResults, localResultSchemaFields);
              }
            }

            if (!Thread.currentThread().isInterrupted()) {
              Comparator<FieldValueList> comparator =
                  defineGetSchemasComparator(localResultSchemaFields);
              sortResults(collectedResults, comparator, "getSchemas", LOG);
            }

            if (!Thread.currentThread().isInterrupted()) {
              populateQueue(collectedResults, queue, localResultSchemaFields);
            }

          } catch (Throwable t) {
            LOG.severe("Unexpected error in schema fetcher runnable: " + t.getMessage());
          } finally {
            signalEndOfData(queue, localResultSchemaFields);
            LOG.info("Schema fetcher thread finished.");
          }
        };

    Thread fetcherThread = new Thread(schemaFetcher, "getSchemas-fetcher-" + catalog);
    BigQueryJsonResultSet resultSet =
        BigQueryJsonResultSet.of(
            resultSchema, -1, queue, this.statement, new Thread[] {fetcherThread});

    fetcherThread.start();
    LOG.info("Started background thread for getSchemas");
    return resultSet;
  }

  Schema defineGetSchemasSchema() {
    List<Field> fields = new ArrayList<>(2);
    fields.add(
        Field.newBuilder("TABLE_SCHEM", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("TABLE_CATALOG", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    return Schema.of(fields);
  }

  void processSchemaInfo(
      Dataset dataset, List<FieldValueList> collectedResults, FieldList resultSchemaFields) {
    DatasetId datasetId = dataset.getDatasetId();
    LOG.finer("Processing schema info for dataset: " + datasetId);
    try {
      String schemaName = datasetId.getDataset();
      String catalogName = datasetId.getProject();
      List<FieldValue> values = new ArrayList<>(resultSchemaFields.size());
      values.add(createStringFieldValue(schemaName));
      values.add(createStringFieldValue(catalogName));
      FieldValueList rowFvl = FieldValueList.of(values, resultSchemaFields);
      collectedResults.add(rowFvl);
      LOG.finer("Processed and added schema info row for: " + datasetId);
    } catch (Exception e) {
      LOG.warning(
          String.format(
              "Error processing schema info for dataset %s: %s. Skipping this schema.",
              datasetId, e.getMessage()));
    }
  }

  Comparator<FieldValueList> defineGetSchemasComparator(FieldList resultSchemaFields) {
    final int TABLE_CATALOG_IDX = resultSchemaFields.getIndex("TABLE_CATALOG");
    final int TABLE_SCHEM_IDX = resultSchemaFields.getIndex("TABLE_SCHEM");
    return Comparator.comparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, TABLE_CATALOG_IDX),
            Comparator.nullsFirst(String::compareTo))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, TABLE_SCHEM_IDX),
            Comparator.nullsFirst(String::compareTo));
  }

  @Override
  public boolean supportsStoredFunctionsUsingCallSyntax() {
    return false;
  }

  @Override
  public boolean autoCommitFailureClosesAllResultSets() {
    return false;
  }

  @Override
  public ResultSet getClientInfoProperties() {
    LOG.info("getClientInfoProperties() called.");

    final Schema resultSchema = defineGetClientInfoPropertiesSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();
    final BlockingQueue<BigQueryFieldValueListWrapper> queue = new LinkedBlockingQueue<>(4);
    final List<FieldValueList> collectedResults = new ArrayList<>(3);

    try {
      collectedResults.add(
          FieldValueList.of(
              Arrays.asList(
                  createStringFieldValue("ApplicationName"),
                  createLongFieldValue(25L),
                  createNullFieldValue(),
                  createStringFieldValue(
                      "The name of the application currently utilizing the connection.")),
              resultSchemaFields));

      collectedResults.add(
          FieldValueList.of(
              Arrays.asList(
                  createStringFieldValue("ClientHostname"),
                  createLongFieldValue(25L),
                  createNullFieldValue(),
                  createStringFieldValue(
                      "The hostname of the computer the application using the connection is running"
                          + " on.")),
              resultSchemaFields));

      collectedResults.add(
          FieldValueList.of(
              Arrays.asList(
                  createStringFieldValue("ClientUser"),
                  createLongFieldValue(25L),
                  createNullFieldValue(),
                  createStringFieldValue(
                      "The name of the user that the application using the connection is performing"
                          + " work for.")),
              resultSchemaFields));

      Comparator<FieldValueList> comparator =
          Comparator.comparing(
              (FieldValueList fvl) ->
                  getStringValueOrNull(fvl, resultSchemaFields.getIndex("NAME")),
              Comparator.nullsFirst(String::compareToIgnoreCase));
      sortResults(collectedResults, comparator, "getClientInfoProperties", LOG);
      populateQueue(collectedResults, queue, resultSchemaFields);

    } catch (Exception e) {
      LOG.warning("Unexpected error processing client info properties: " + e.getMessage());
      collectedResults.clear();
      queue.clear();
    } finally {
      signalEndOfData(queue, resultSchemaFields);
    }
    return BigQueryJsonResultSet.of(
        resultSchema, collectedResults.size(), queue, this.statement, new Thread[0]);
  }

  Schema defineGetClientInfoPropertiesSchema() {
    List<Field> fields = new ArrayList<>(4);
    fields.add(
        Field.newBuilder("NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build()); // 1
    fields.add(
        Field.newBuilder("MAX_LEN", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 2
    fields.add(
        Field.newBuilder("DEFAULT_VALUE", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 3
    fields.add(
        Field.newBuilder("DESCRIPTION", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build()); // 4
    return Schema.of(fields);
  }

  @Override
  public ResultSet getFunctions(String catalog, String schemaPattern, String functionNamePattern) {
    if ((catalog == null || catalog.isEmpty())
        || (schemaPattern != null && schemaPattern.isEmpty())
        || (functionNamePattern != null && functionNamePattern.isEmpty())) {
      LOG.warning(
          "Returning empty ResultSet as catalog is null/empty or a pattern is empty for"
              + " getFunctions.");
      return new BigQueryJsonResultSet();
    }

    LOG.info(
        String.format(
            "getFunctions called for catalog: %s, schemaPattern: %s, functionNamePattern: %s",
            catalog, schemaPattern, functionNamePattern));

    final Pattern schemaRegex = compileSqlLikePattern(schemaPattern);
    final Pattern functionNameRegex = compileSqlLikePattern(functionNamePattern);
    final Schema resultSchema = defineGetFunctionsSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();
    final BlockingQueue<BigQueryFieldValueListWrapper> queue =
        new LinkedBlockingQueue<>(DEFAULT_QUEUE_CAPACITY);
    final List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());
    final List<Future<?>> processingTaskFutures = new ArrayList<>();
    final String catalogParam = catalog;

    Runnable functionFetcher =
        () -> {
          ExecutorService apiExecutor = null;
          ExecutorService routineProcessorExecutor = null;
          final FieldList localResultSchemaFields = resultSchemaFields;
          final List<Future<List<Routine>>> apiFutures = new ArrayList<>();

          try {
            List<Dataset> datasetsToScan =
                findMatchingBigQueryObjects(
                    "Dataset",
                    () ->
                        bigquery.listDatasets(
                            catalogParam, DatasetListOption.pageSize(DEFAULT_PAGE_SIZE)),
                    (name) -> bigquery.getDataset(DatasetId.of(catalogParam, name)),
                    (ds) -> ds.getDatasetId().getDataset(),
                    schemaPattern,
                    schemaRegex,
                    LOG);

            if (datasetsToScan.isEmpty()) {
              LOG.info("Fetcher thread found no matching datasets. Returning empty resultset.");
              return;
            }

            apiExecutor = Executors.newFixedThreadPool(API_EXECUTOR_POOL_SIZE);
            routineProcessorExecutor = Executors.newFixedThreadPool(this.metadataFetchThreadCount);

            for (Dataset dataset : datasetsToScan) {
              if (Thread.currentThread().isInterrupted()) {
                LOG.warning("Function fetcher interrupted during dataset iteration submission.");
                break;
              }

              final DatasetId currentDatasetId = dataset.getDatasetId();

              Callable<List<Routine>> apiCallable =
                  () -> {
                    LOG.fine(
                        String.format(
                            "Fetching all routines for dataset: %s, pattern: %s",
                            currentDatasetId.getDataset(), functionNamePattern));
                    return findMatchingBigQueryObjects(
                        "Routine",
                        () ->
                            bigquery.listRoutines(
                                currentDatasetId, RoutineListOption.pageSize(DEFAULT_PAGE_SIZE)),
                        (name) ->
                            bigquery.getRoutine(
                                RoutineId.of(
                                    currentDatasetId.getProject(),
                                    currentDatasetId.getDataset(),
                                    name)),
                        (rt) -> rt.getRoutineId().getRoutine(),
                        functionNamePattern,
                        functionNameRegex,
                        LOG);
                  };
              Future<List<Routine>> apiFuture = apiExecutor.submit(apiCallable);
              apiFutures.add(apiFuture);
            }
            LOG.fine(
                "Finished submitting "
                    + apiFutures.size()
                    + " findMatchingRoutines (for functions) tasks.");
            apiExecutor.shutdown();

            for (Future<List<Routine>> apiFuture : apiFutures) {
              if (Thread.currentThread().isInterrupted()) {
                LOG.warning("Function fetcher interrupted while processing API futures.");
                break;
              }
              try {
                List<Routine> routinesResult = apiFuture.get();
                if (routinesResult != null) {
                  for (Routine routine : routinesResult) {
                    if (Thread.currentThread().isInterrupted()) {
                      break;
                    }
                    String routineType = routine.getRoutineType();
                    if ("SCALAR_FUNCTION".equalsIgnoreCase(routineType)
                        || "TABLE_FUNCTION".equalsIgnoreCase(routineType)) {
                      LOG.fine(
                          "Submitting processing task for function: "
                              + routine.getRoutineId()
                              + " of type "
                              + routineType);
                      final Routine finalRoutine = routine;
                      Future<?> processFuture =
                          routineProcessorExecutor.submit(
                              () ->
                                  processFunctionInfo(
                                      finalRoutine, collectedResults, localResultSchemaFields));
                      processingTaskFutures.add(processFuture);
                    }
                  }
                }
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOG.warning(
                    "Function fetcher thread interrupted while waiting for API future result.");
                break;
              } catch (ExecutionException | CancellationException e) {
                LOG.warning(
                    "Error or cancellation in findMatchingRoutines (for functions) task: "
                        + e.getMessage());
              }
            }
            waitForTasksCompletion(processingTaskFutures);
            Comparator<FieldValueList> comparator =
                defineGetFunctionsComparator(localResultSchemaFields);
            sortResults(collectedResults, comparator, "getFunctions", LOG);
            populateQueue(collectedResults, queue, localResultSchemaFields);
          } catch (Throwable t) {
            LOG.severe("Unexpected error in function fetcher runnable: " + t.getMessage());
            apiFutures.forEach(f -> f.cancel(true));
            processingTaskFutures.forEach(f -> f.cancel(true));
          } finally {
            signalEndOfData(queue, localResultSchemaFields);
            shutdownExecutor(apiExecutor);
            shutdownExecutor(routineProcessorExecutor);
            LOG.info("Function fetcher thread finished.");
          }
        };

    Thread fetcherThread = new Thread(functionFetcher, "getFunctions-fetcher-" + catalog);
    BigQueryJsonResultSet resultSet =
        BigQueryJsonResultSet.of(
            resultSchema, -1, queue, this.statement, new Thread[] {fetcherThread});

    fetcherThread.start();
    LOG.info("Started background thread for getFunctions");
    return resultSet;
  }

  Schema defineGetFunctionsSchema() {
    List<Field> fields = new ArrayList<>(6);
    fields.add(
        Field.newBuilder("FUNCTION_CAT", StandardSQLTypeName.STRING)
            .setMode(Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("FUNCTION_SCHEM", StandardSQLTypeName.STRING)
            .setMode(Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("FUNCTION_NAME", StandardSQLTypeName.STRING)
            .setMode(Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("REMARKS", StandardSQLTypeName.STRING).setMode(Mode.NULLABLE).build());
    fields.add(
        Field.newBuilder("FUNCTION_TYPE", StandardSQLTypeName.INT64)
            .setMode(Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("SPECIFIC_NAME", StandardSQLTypeName.STRING)
            .setMode(Mode.REQUIRED)
            .build());
    return Schema.of(fields);
  }

  void processFunctionInfo(
      Routine routine, List<FieldValueList> collectedResults, FieldList resultSchemaFields) {
    RoutineId routineId = routine.getRoutineId();
    LOG.fine("Processing function info for: " + routineId);

    try {
      String catalogName = routineId.getProject();
      String schemaName = routineId.getDataset();
      String functionName = routineId.getRoutine();
      String remarks = routine.getDescription();
      String specificName = functionName;

      short functionType;
      String bqRoutineType = routine.getRoutineType();
      if ("SCALAR_FUNCTION".equalsIgnoreCase(bqRoutineType)) {
        functionType = DatabaseMetaData.functionResultUnknown;
      } else if ("TABLE_FUNCTION".equalsIgnoreCase(bqRoutineType)) {
        functionType = DatabaseMetaData.functionReturnsTable;
      } else {
        functionType = DatabaseMetaData.functionResultUnknown;
      }

      List<FieldValue> values = new ArrayList<>(resultSchemaFields.size());
      values.add(createStringFieldValue(catalogName)); // 1. FUNCTION_CAT
      values.add(createStringFieldValue(schemaName)); // 2. FUNCTION_SCHEM
      values.add(createStringFieldValue(functionName)); // 3. FUNCTION_NAME
      values.add(createStringFieldValue(remarks)); // 4. REMARKS
      values.add(createLongFieldValue((long) functionType)); // 5. FUNCTION_TYPE
      values.add(createStringFieldValue(specificName)); // 6. SPECIFIC_NAME

      FieldValueList rowFvl = FieldValueList.of(values, resultSchemaFields);
      collectedResults.add(rowFvl);
      LOG.fine("Processed and added function info row for: " + routineId);

    } catch (Exception e) {
      LOG.warning(
          String.format(
              "Error processing function info for %s: %s. Skipping this function.",
              routineId, e.getMessage()));
    }
  }

  Comparator<FieldValueList> defineGetFunctionsComparator(FieldList resultSchemaFields) {
    final int FUNC_CAT_IDX = resultSchemaFields.getIndex("FUNCTION_CAT");
    final int FUNC_SCHEM_IDX = resultSchemaFields.getIndex("FUNCTION_SCHEM");
    final int FUNC_NAME_IDX = resultSchemaFields.getIndex("FUNCTION_NAME");
    final int SPEC_NAME_IDX = resultSchemaFields.getIndex("SPECIFIC_NAME");

    return Comparator.comparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, FUNC_CAT_IDX),
            Comparator.nullsFirst(String::compareTo))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, FUNC_SCHEM_IDX),
            Comparator.nullsFirst(String::compareTo))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, FUNC_NAME_IDX),
            Comparator.nullsFirst(String::compareTo))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, SPEC_NAME_IDX),
            Comparator.nullsFirst(String::compareTo));
  }

  @Override
  public ResultSet getFunctionColumns(
      String catalog, String schemaPattern, String functionNamePattern, String columnNamePattern) {
    if (catalog == null || catalog.isEmpty()) {
      LOG.warning("Returning empty ResultSet catalog (project) is null or empty.");
      return new BigQueryJsonResultSet();
    }
    if ((schemaPattern != null && schemaPattern.isEmpty())
        || (functionNamePattern != null && functionNamePattern.isEmpty())
        || (columnNamePattern != null && columnNamePattern.isEmpty())) {
      LOG.warning("Returning empty ResultSet because an explicit empty pattern was provided.");
      return new BigQueryJsonResultSet();
    }

    LOG.info(
        String.format(
            "getFunctionColumns called for catalog: %s, schemaPattern: %s, functionNamePattern: %s,"
                + " columnNamePattern: %s",
            catalog, schemaPattern, functionNamePattern, columnNamePattern));

    final Pattern schemaRegex = compileSqlLikePattern(schemaPattern);
    final Pattern functionNameRegex = compileSqlLikePattern(functionNamePattern);
    final Pattern columnNameRegex = compileSqlLikePattern(columnNamePattern);

    final Schema resultSchema = defineGetFunctionColumnsSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();
    final BlockingQueue<BigQueryFieldValueListWrapper> queue =
        new LinkedBlockingQueue<>(DEFAULT_QUEUE_CAPACITY);
    final List<FieldValueList> collectedResults = Collections.synchronizedList(new ArrayList<>());
    final List<Future<?>> processingTaskFutures = new ArrayList<>();
    final String catalogParam = catalog;

    Runnable functionColumnFetcher =
        () -> {
          ExecutorService listRoutinesExecutor = null;
          ExecutorService getRoutineDetailsExecutor = null;
          ExecutorService processParamsExecutor = null;
          final String fetcherThreadNameSuffix =
              "-" + catalogParam.substring(0, Math.min(10, catalogParam.length()));

          try {
            List<Dataset> datasetsToScan =
                findMatchingBigQueryObjects(
                    "Dataset",
                    () ->
                        bigquery.listDatasets(
                            catalogParam, DatasetListOption.pageSize(DEFAULT_PAGE_SIZE)),
                    (name) -> bigquery.getDataset(DatasetId.of(catalogParam, name)),
                    (ds) -> ds.getDatasetId().getDataset(),
                    schemaPattern,
                    schemaRegex,
                    LOG);

            if (datasetsToScan.isEmpty() || Thread.currentThread().isInterrupted()) {
              LOG.info(
                  "Fetcher: No matching datasets or interrupted early. Catalog: " + catalogParam);
              return;
            }

            listRoutinesExecutor =
                Executors.newFixedThreadPool(
                    API_EXECUTOR_POOL_SIZE,
                    runnable -> new Thread(runnable, "funcol-list-rout" + fetcherThreadNameSuffix));
            List<RoutineId> functionIdsToGet =
                listMatchingFunctionIdsFromDatasets(
                    datasetsToScan,
                    functionNamePattern,
                    functionNameRegex,
                    listRoutinesExecutor,
                    catalogParam,
                    LOG);
            shutdownExecutor(listRoutinesExecutor);
            listRoutinesExecutor = null;

            if (functionIdsToGet.isEmpty() || Thread.currentThread().isInterrupted()) {
              LOG.info("Fetcher: No function IDs found or interrupted. Catalog: " + catalogParam);
              return;
            }

            getRoutineDetailsExecutor =
                Executors.newFixedThreadPool(
                    this.metadataFetchThreadCount,
                    runnable ->
                        new Thread(runnable, "funcol-get-details" + fetcherThreadNameSuffix));
            List<Routine> fullFunctions =
                fetchFullRoutineDetailsForIds(functionIdsToGet, getRoutineDetailsExecutor, LOG);
            shutdownExecutor(getRoutineDetailsExecutor);
            getRoutineDetailsExecutor = null;

            if (fullFunctions.isEmpty() || Thread.currentThread().isInterrupted()) {
              LOG.info(
                  "Fetcher: No full functions fetched or interrupted. Catalog: " + catalogParam);
              return;
            }

            processParamsExecutor =
                Executors.newFixedThreadPool(
                    this.metadataFetchThreadCount,
                    runnable ->
                        new Thread(runnable, "funcol-proc-params" + fetcherThreadNameSuffix));
            submitFunctionParameterProcessingJobs(
                fullFunctions,
                columnNameRegex,
                collectedResults,
                resultSchemaFields,
                processParamsExecutor,
                processingTaskFutures,
                LOG);

            if (Thread.currentThread().isInterrupted()) {
              LOG.warning(
                  "Fetcher: Interrupted before waiting for parameter processing. Catalog: "
                      + catalogParam);
              processingTaskFutures.forEach(f -> f.cancel(true));
            } else {
              LOG.fine(
                  "Fetcher: Waiting for "
                      + processingTaskFutures.size()
                      + " parameter processing tasks. Catalog: "
                      + catalogParam);
              waitForTasksCompletion(processingTaskFutures);
              LOG.fine(
                  "Fetcher: All parameter processing tasks completed or handled. Catalog: "
                      + catalogParam);
            }

            if (!Thread.currentThread().isInterrupted()) {
              Comparator<FieldValueList> comparator =
                  defineGetFunctionColumnsComparator(resultSchemaFields);
              sortResults(collectedResults, comparator, "getFunctionColumns", LOG);
              populateQueue(collectedResults, queue, resultSchemaFields);
            }

          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOG.warning(
                "Fetcher: Interrupted in main try block for catalog "
                    + catalogParam
                    + ". Error: "
                    + e.getMessage());
            processingTaskFutures.forEach(f -> f.cancel(true));
          } catch (Throwable t) {
            LOG.severe(
                "Fetcher: Unexpected error in main try block for catalog "
                    + catalogParam
                    + ". Error: "
                    + t.getMessage());
            processingTaskFutures.forEach(f -> f.cancel(true));
          } finally {
            signalEndOfData(queue, resultSchemaFields);
            if (listRoutinesExecutor != null) shutdownExecutor(listRoutinesExecutor);
            if (getRoutineDetailsExecutor != null) shutdownExecutor(getRoutineDetailsExecutor);
            if (processParamsExecutor != null) shutdownExecutor(processParamsExecutor);
            LOG.info("Function column fetcher thread finished for catalog: " + catalogParam);
          }
        };

    Thread fetcherThread =
        new Thread(functionColumnFetcher, "getFunctionColumns-fetcher-" + catalog);
    BigQueryJsonResultSet resultSet =
        BigQueryJsonResultSet.of(
            resultSchema, -1, queue, this.statement, new Thread[] {fetcherThread});

    fetcherThread.start();
    LOG.info("Started background thread for getFunctionColumns for catalog: " + catalog);
    return resultSet;
  }

  Schema defineGetFunctionColumnsSchema() {
    List<Field> fields = new ArrayList<>(17);
    fields.add(
        Field.newBuilder("FUNCTION_CAT", StandardSQLTypeName.STRING)
            .setMode(Mode.NULLABLE)
            .build()); // 1
    fields.add(
        Field.newBuilder("FUNCTION_SCHEM", StandardSQLTypeName.STRING)
            .setMode(Mode.NULLABLE)
            .build()); // 2
    fields.add(
        Field.newBuilder("FUNCTION_NAME", StandardSQLTypeName.STRING)
            .setMode(Mode.REQUIRED)
            .build()); // 3
    fields.add(
        Field.newBuilder("COLUMN_NAME", StandardSQLTypeName.STRING)
            .setMode(Mode.REQUIRED)
            .build()); // 4
    fields.add(
        Field.newBuilder("COLUMN_TYPE", StandardSQLTypeName.INT64)
            .setMode(Mode.REQUIRED)
            .build()); // 5
    fields.add(
        Field.newBuilder("DATA_TYPE", StandardSQLTypeName.INT64)
            .setMode(Mode.REQUIRED)
            .build()); // 6
    fields.add(
        Field.newBuilder("TYPE_NAME", StandardSQLTypeName.STRING)
            .setMode(Mode.REQUIRED)
            .build()); // 7
    fields.add(
        Field.newBuilder("PRECISION", StandardSQLTypeName.INT64)
            .setMode(Mode.NULLABLE)
            .build()); // 8
    fields.add(
        Field.newBuilder("LENGTH", StandardSQLTypeName.INT64).setMode(Mode.NULLABLE).build()); // 9
    fields.add(
        Field.newBuilder("SCALE", StandardSQLTypeName.INT64).setMode(Mode.NULLABLE).build()); // 10
    fields.add(
        Field.newBuilder("RADIX", StandardSQLTypeName.INT64).setMode(Mode.NULLABLE).build()); // 11
    fields.add(
        Field.newBuilder("NULLABLE", StandardSQLTypeName.INT64)
            .setMode(Mode.REQUIRED)
            .build()); // 12
    fields.add(
        Field.newBuilder("REMARKS", StandardSQLTypeName.STRING)
            .setMode(Mode.NULLABLE)
            .build()); // 13
    fields.add(
        Field.newBuilder("CHAR_OCTET_LENGTH", StandardSQLTypeName.INT64)
            .setMode(Mode.NULLABLE)
            .build()); // 14
    fields.add(
        Field.newBuilder("ORDINAL_POSITION", StandardSQLTypeName.INT64)
            .setMode(Mode.REQUIRED)
            .build()); // 15
    fields.add(
        Field.newBuilder("IS_NULLABLE", StandardSQLTypeName.STRING)
            .setMode(Mode.REQUIRED)
            .build()); // 16
    fields.add(
        Field.newBuilder("SPECIFIC_NAME", StandardSQLTypeName.STRING)
            .setMode(Mode.REQUIRED)
            .build()); // 17
    return Schema.of(fields);
  }

  List<RoutineId> listMatchingFunctionIdsFromDatasets(
      List<Dataset> datasetsToScan,
      String functionNamePattern,
      Pattern functionNameRegex,
      ExecutorService listRoutinesExecutor,
      String catalogParam,
      BigQueryJdbcCustomLogger logger)
      throws InterruptedException {

    logger.fine(
        String.format(
            "Listing matching function IDs from %d datasets for catalog '%s'.",
            datasetsToScan.size(), catalogParam));
    final List<Future<List<Routine>>> listRoutineFutures = new ArrayList<>();
    final List<RoutineId> functionIdsToGet = Collections.synchronizedList(new ArrayList<>());

    for (Dataset dataset : datasetsToScan) {
      if (Thread.currentThread().isInterrupted()) {
        logger.warning(
            "Interrupted during submission of routine (function) listing tasks for catalog: "
                + catalogParam);
        throw new InterruptedException("Interrupted while listing functions");
      }
      final DatasetId currentDatasetId = dataset.getDatasetId();
      Callable<List<Routine>> listCallable =
          () ->
              findMatchingBigQueryObjects(
                  "Routine",
                  () ->
                      bigquery.listRoutines(
                          currentDatasetId, RoutineListOption.pageSize(DEFAULT_PAGE_SIZE)),
                  (name) ->
                      bigquery.getRoutine(
                          RoutineId.of(
                              currentDatasetId.getProject(), currentDatasetId.getDataset(), name)),
                  (rt) -> rt.getRoutineId().getRoutine(),
                  functionNamePattern,
                  functionNameRegex,
                  logger);
      listRoutineFutures.add(listRoutinesExecutor.submit(listCallable));
    }
    logger.fine(
        "Submitted "
            + listRoutineFutures.size()
            + " routine (function) list tasks for catalog: "
            + catalogParam);

    for (Future<List<Routine>> listFuture : listRoutineFutures) {
      if (Thread.currentThread().isInterrupted()) {
        logger.warning(
            "Interrupted while collecting routine (function) list results for catalog: "
                + catalogParam);
        listRoutineFutures.forEach(f -> f.cancel(true));
        throw new InterruptedException("Interrupted while collecting function lists");
      }
      try {
        List<Routine> listedRoutines = listFuture.get();
        if (listedRoutines != null) {
          for (Routine listedRoutine : listedRoutines) {
            if (listedRoutine != null
                && ("SCALAR_FUNCTION".equalsIgnoreCase(listedRoutine.getRoutineType())
                    || "TABLE_FUNCTION".equalsIgnoreCase(listedRoutine.getRoutineType()))) {
              if (listedRoutine.getRoutineId() != null) {
                functionIdsToGet.add(listedRoutine.getRoutineId());
              } else {
                logger.warning(
                    "Found a function type routine with a null ID during listing phase for catalog:"
                        + " "
                        + catalogParam);
              }
            }
          }
        }
      } catch (ExecutionException e) {
        logger.warning(
            "Error getting routine (function) list result for catalog "
                + catalogParam
                + ": "
                + e.getCause());
      } catch (CancellationException e) {
        logger.warning("Routine (function) list task cancelled for catalog: " + catalogParam);
      }
    }
    logger.info(
        String.format(
            "Found %d function IDs to fetch details for in catalog '%s'.",
            functionIdsToGet.size(), catalogParam));
    return functionIdsToGet;
  }

  void submitFunctionParameterProcessingJobs(
      List<Routine> fullFunctions,
      Pattern columnNameRegex,
      List<FieldValueList> collectedResults,
      FieldList resultSchemaFields,
      ExecutorService processParamsExecutor,
      List<Future<?>> outParameterProcessingFutures,
      BigQueryJdbcCustomLogger logger)
      throws InterruptedException {
    logger.fine(
        String.format(
            "Submitting parameter processing jobs for %d functions.", fullFunctions.size()));

    for (Routine fullFunction : fullFunctions) {
      if (Thread.currentThread().isInterrupted()) {
        logger.warning("Interrupted during submission of function parameter processing tasks.");
        throw new InterruptedException(
            "Interrupted while submitting function parameter processing jobs");
      }
      if (fullFunction != null) {
        String routineType = fullFunction.getRoutineType();
        if ("SCALAR_FUNCTION".equalsIgnoreCase(routineType)
            || "TABLE_FUNCTION".equalsIgnoreCase(routineType)) {
          final Routine finalFullFunction = fullFunction;
          Future<?> processFuture =
              processParamsExecutor.submit(
                  () ->
                      processFunctionParametersAndReturnValue(
                          finalFullFunction,
                          columnNameRegex,
                          collectedResults,
                          resultSchemaFields));
          outParameterProcessingFutures.add(processFuture);
        } else {
          logger.warning(
              "Routine "
                  + (fullFunction.getRoutineId() != null
                      ? fullFunction.getRoutineId().toString()
                      : "UNKNOWN_ID")
                  + " fetched for getFunctionColumns was not of a function type (Type: "
                  + routineType
                  + "). Skipping parameter processing.");
        }
      }
    }
    logger.fine(
        "Finished submitting "
            + outParameterProcessingFutures.size()
            + " processFunctionParametersAndReturnValue tasks.");
  }

  void processFunctionParametersAndReturnValue(
      Routine routine,
      Pattern columnNameRegex,
      List<FieldValueList> collectedResults,
      FieldList resultSchemaFields) {
    RoutineId routineId = routine.getRoutineId();
    if (routineId == null) {
      LOG.warning("Processing a routine with a null ID. Skipping.");
      return;
    }
    LOG.finer("Processing function parameters and return value for: " + routineId);

    String functionCatalog = routineId.getProject();
    String functionSchema = routineId.getDataset();
    String functionName = routineId.getRoutine();
    String specificName = functionName;

    if (routine.getReturnTableType() != null) {
      StandardSQLTableType returnTableType = routine.getReturnTableType();
      if (returnTableType != null && returnTableType.getColumns() != null) {
        List<StandardSQLField> tableColumns = returnTableType.getColumns();
        for (int i = 0; i < tableColumns.size(); i++) {
          StandardSQLField tableColumn = tableColumns.get(i);
          String columnName = tableColumn.getName();
          if (columnNameRegex != null
              && (columnName == null || !columnNameRegex.matcher(columnName).matches())) {
            continue;
          }
          List<FieldValue> rowValues =
              createFunctionColumnRow(
                  functionCatalog,
                  functionSchema,
                  functionName,
                  specificName,
                  columnName,
                  DatabaseMetaData.functionColumnResult,
                  tableColumn.getDataType(),
                  i + 1);
          collectedResults.add(FieldValueList.of(rowValues, resultSchemaFields));
        }
      }
    }

    List<RoutineArgument> arguments = routine.getArguments();
    if (arguments != null) {
      for (int i = 0; i < arguments.size(); i++) {
        RoutineArgument arg = arguments.get(i);
        String argName = arg.getName();

        if (columnNameRegex != null
            && (argName == null || !columnNameRegex.matcher(argName).matches())) {
          continue;
        }

        short columnType;
        String originalMode = arg.getMode();

        if ("IN".equalsIgnoreCase(originalMode)) {
          columnType = DatabaseMetaData.functionColumnIn;
        } else if ("OUT".equalsIgnoreCase(originalMode)) {
          columnType = DatabaseMetaData.functionColumnOut;
        } else if ("INOUT".equalsIgnoreCase(originalMode)) {
          columnType = DatabaseMetaData.functionColumnInOut;
        } else {
          columnType = DatabaseMetaData.functionColumnUnknown;
        }

        List<FieldValue> rowValues =
            createFunctionColumnRow(
                functionCatalog,
                functionSchema,
                functionName,
                specificName,
                argName,
                columnType,
                arg.getDataType(),
                i + 1);
        collectedResults.add(FieldValueList.of(rowValues, resultSchemaFields));
      }
    }
  }

  List<FieldValue> createFunctionColumnRow(
      String functionCatalog,
      String functionSchema,
      String functionName,
      String specificName,
      String columnName,
      int columnType,
      StandardSQLDataType dataType,
      int ordinalPosition) {

    List<FieldValue> values = new ArrayList<>(17);
    ColumnTypeInfo typeInfo =
        determineTypeInfoFromDataType(dataType, functionName, columnName, ordinalPosition);

    values.add(createStringFieldValue(functionCatalog)); // 1. FUNCTION_CAT
    values.add(createStringFieldValue(functionSchema)); // 2. FUNCTION_SCHEM
    values.add(createStringFieldValue(functionName)); // 3. FUNCTION_NAME
    values.add(createStringFieldValue(columnName)); // 4. COLUMN_NAME
    values.add(createLongFieldValue((long) columnType)); // 5. COLUMN_TYPE

    values.add(createLongFieldValue((long) typeInfo.jdbcType)); // 6. DATA_TYPE
    values.add(createStringFieldValue(typeInfo.typeName)); // 7. TYPE_NAME
    values.add(
        createLongFieldValue(
            typeInfo.columnSize == null ? null : typeInfo.columnSize.longValue())); // 8. PRECISION
    if (typeInfo.typeName != null
        && (typeInfo.typeName.equalsIgnoreCase("STRING")
            || typeInfo.typeName.equalsIgnoreCase("NVARCHAR")
            || typeInfo.typeName.equalsIgnoreCase("BYTES")
            || typeInfo.typeName.equalsIgnoreCase("VARBINARY"))) {
      values.add(
          createLongFieldValue(
              typeInfo.columnSize == null ? null : typeInfo.columnSize.longValue())); // 9. LENGTH
      values.add(
          createLongFieldValue(
              typeInfo.decimalDigits == null
                  ? null
                  : typeInfo.decimalDigits.longValue())); // 10. SCALE
      values.add(
          createLongFieldValue(
              typeInfo.numPrecRadix == null
                  ? null
                  : typeInfo.numPrecRadix.longValue())); // 11. RADIX
      values.add(
          createLongFieldValue((long) DatabaseMetaData.functionNullableUnknown)); // 12. NULLABLE
      values.add(createStringFieldValue(null)); // 13. REMARKS
      values.add(
          createLongFieldValue(
              typeInfo.columnSize == null
                  ? null
                  : typeInfo.columnSize.longValue())); // 14. CHAR_OCTET_LENGTH
    } else {
      values.add(createNullFieldValue()); // 9. LENGTH
      values.add(
          createLongFieldValue(
              typeInfo.decimalDigits == null
                  ? null
                  : typeInfo.decimalDigits.longValue())); // 10. SCALE
      values.add(
          createLongFieldValue(
              typeInfo.numPrecRadix == null
                  ? null
                  : typeInfo.numPrecRadix.longValue())); // 11. RADIX
      values.add(
          createLongFieldValue((long) DatabaseMetaData.functionNullableUnknown)); // 12. NULLABLE
      values.add(createStringFieldValue(null)); // 13. REMARKS
      values.add(createNullFieldValue()); // 14. CHAR_OCTET_LENGTH
    }

    values.add(createLongFieldValue((long) ordinalPosition)); // 15. ORDINAL_POSITION
    values.add(createStringFieldValue("")); // 16. IS_NULLABLE
    values.add(createStringFieldValue(specificName)); // 17. SPECIFIC_NAME

    return values;
  }

  Comparator<FieldValueList> defineGetFunctionColumnsComparator(FieldList resultSchemaFields) {
    final int FUNC_CAT_IDX = resultSchemaFields.getIndex("FUNCTION_CAT");
    final int FUNC_SCHEM_IDX = resultSchemaFields.getIndex("FUNCTION_SCHEM");
    final int FUNC_NAME_IDX = resultSchemaFields.getIndex("FUNCTION_NAME");
    final int SPEC_NAME_IDX = resultSchemaFields.getIndex("SPECIFIC_NAME");
    final int ORDINAL_POS_IDX = resultSchemaFields.getIndex("ORDINAL_POSITION");

    return Comparator.comparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, FUNC_CAT_IDX),
            Comparator.nullsFirst(String::compareToIgnoreCase))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, FUNC_SCHEM_IDX),
            Comparator.nullsFirst(String::compareToIgnoreCase))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, FUNC_NAME_IDX),
            Comparator.nullsFirst(String::compareToIgnoreCase))
        .thenComparing(
            (FieldValueList fvl) -> getStringValueOrNull(fvl, SPEC_NAME_IDX),
            Comparator.nullsFirst(String::compareToIgnoreCase))
        .thenComparing(
            (FieldValueList fvl) -> getLongValueOrNull(fvl, ORDINAL_POS_IDX),
            Comparator.nullsFirst(Long::compareTo));
  }

  @Override
  public ResultSet getPseudoColumns(
      String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) {
    LOG.info(
        String.format(
            "getPseudoColumns called for catalog: %s, schemaPattern: %s, tableNamePattern: %s,"
                + " columnNamePattern: %s. Pseudo columns not supported by BigQuery; returning"
                + " empty ResultSet.",
            catalog, schemaPattern, tableNamePattern, columnNamePattern));

    final Schema resultSchema = defineGetPseudoColumnsSchema();
    final FieldList resultSchemaFields = resultSchema.getFields();
    final BlockingQueue<BigQueryFieldValueListWrapper> queue = new LinkedBlockingQueue<>(1);
    signalEndOfData(queue, resultSchemaFields);

    return BigQueryJsonResultSet.of(resultSchema, 0, queue, this.statement, null);
  }

  Schema defineGetPseudoColumnsSchema() {
    List<Field> fields = new ArrayList<>(12);
    fields.add(
        Field.newBuilder("TABLE_CAT", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("TABLE_SCHEM", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("TABLE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("COLUMN_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("DATA_TYPE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("COLUMN_SIZE", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("DECIMAL_DIGITS", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("NUM_PREC_RADIX", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("COLUMN_USAGE", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("REMARKS", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("CHAR_OCTET_LENGTH", StandardSQLTypeName.INT64)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("IS_NULLABLE", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    return Schema.of(fields);
  }

  @Override
  public boolean generatedKeyAlwaysReturned() {
    return false;
  }

  @Override
  public <T> T unwrap(Class<T> iface) {
    return null;
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) {
    return false;
  }

  // --- Helper Methods ---

  /**
   * Determines the effective catalog and schema pattern to use for metadata retrieval.
   *
   * <p>This method applies the logic for the {@code FilterTablesOnDefaultDataset} connection
   * property. If this property is enabled and the provided {@code catalog} or {@code schemaPattern}
   * are null, empty, or wildcard ('%'), they may be overridden by the default catalog (project) and
   * default dataset (schema) configured in the {@link BigQueryConnection}.
   *
   * @param catalog The catalog name provided by the user; may be {@code null}.
   * @param schemaPattern The schema name pattern provided by the user; may be {@code null}.
   * @return A {@link Tuple} where {@code Tuple.x()} is the effective catalog string and {@code
   *     Tuple.y()} is the effective schema pattern string. These are the values that should be used
   *     for querying BigQuery's metadata.
   * @see BigQueryConnection#isFilterTablesOnDefaultDataset()
   */
  private Tuple<String, String> determineEffectiveCatalogAndSchema(
      String catalog, String schemaPattern) {
    String effectiveCatalog = catalog;
    String effectiveSchemaPattern = schemaPattern;

    if (this.connection.isFilterTablesOnDefaultDataset()
        && this.connection.getDefaultDataset() != null
        && this.connection.getDefaultDataset().getDataset() != null
        && !this.connection.getDefaultDataset().getDataset().isEmpty()) {

      String defaultProjectFromConnection = this.connection.getCatalog();
      // We only use the dataset part of the DefaultDataset for schema filtering
      String defaultSchemaFromConnection = this.connection.getDefaultDataset().getDataset();

      boolean catalogIsNullOrEmptyOrWildcard =
          (catalog == null || catalog.isEmpty() || catalog.equals("%"));
      boolean schemaPatternIsNullOrEmptyOrWildcard =
          (schemaPattern == null || schemaPattern.isEmpty() || schemaPattern.equals("%"));

      final String logPrefix = "FilterTablesOnDefaultDatasetTrue: ";
      if (catalogIsNullOrEmptyOrWildcard && schemaPatternIsNullOrEmptyOrWildcard) {
        effectiveCatalog = defaultProjectFromConnection;
        effectiveSchemaPattern = defaultSchemaFromConnection;
        LOG.info(
            String.format(
                logPrefix + "Using default catalog '%s' and default dataset '%s'.",
                effectiveCatalog,
                effectiveSchemaPattern));
      } else if (catalogIsNullOrEmptyOrWildcard) {
        effectiveCatalog = defaultProjectFromConnection;
        LOG.info(
            String.format(
                logPrefix
                    + "Using default catalog '%s' with user dataset '%s'. Default dataset '%s' ignored.",
                effectiveCatalog,
                effectiveSchemaPattern,
                defaultSchemaFromConnection));
      } else if (schemaPatternIsNullOrEmptyOrWildcard) {
        effectiveSchemaPattern = defaultSchemaFromConnection;
        LOG.info(
            String.format(
                logPrefix + "Using user catalog '%s' and default dataset '%s'.",
                effectiveCatalog,
                effectiveSchemaPattern));
      } else {
        LOG.info(
            String.format(
                logPrefix
                    + "Using user catalog '%s' and schema '%s'. Default dataset '%s' ignored.",
                effectiveCatalog,
                effectiveSchemaPattern,
                defaultSchemaFromConnection));
      }
    }
    return Tuple.of(effectiveCatalog, effectiveSchemaPattern);
  }

  private ColumnTypeInfo getColumnTypeInfoForSqlType(StandardSQLTypeName bqType) {
    if (bqType == null) {
      LOG.warning("Null BigQuery type encountered: " + bqType.name() + ". Mapping to VARCHAR.");
      return new ColumnTypeInfo(Types.VARCHAR, bqType.name(), null, null, null);
    }

    switch (bqType) {
      case INT64:
        return new ColumnTypeInfo(Types.BIGINT, "BIGINT", 19, 0, 10);
      case BOOL:
        return new ColumnTypeInfo(Types.BOOLEAN, "BOOLEAN", 1, null, null);
      case FLOAT64:
        return new ColumnTypeInfo(Types.DOUBLE, "DOUBLE", 15, null, 10);
      case NUMERIC:
        return new ColumnTypeInfo(Types.NUMERIC, "NUMERIC", 38, 9, 10);
      case BIGNUMERIC:
        return new ColumnTypeInfo(Types.NUMERIC, "NUMERIC", 77, 38, 10);
      case STRING:
        return new ColumnTypeInfo(Types.NVARCHAR, "NVARCHAR", null, null, null);
      case TIMESTAMP:
      case DATETIME:
        return new ColumnTypeInfo(Types.TIMESTAMP, "TIMESTAMP", 29, null, null);
      case DATE:
        return new ColumnTypeInfo(Types.DATE, "DATE", 10, null, null);
      case TIME:
        return new ColumnTypeInfo(Types.TIME, "TIME", 15, null, null);
      case GEOGRAPHY:
      case JSON:
      case INTERVAL:
        return new ColumnTypeInfo(Types.VARCHAR, "VARCHAR", null, null, null);
      case BYTES:
        return new ColumnTypeInfo(Types.VARBINARY, "VARBINARY", null, null, null);
      case STRUCT:
        return new ColumnTypeInfo(Types.STRUCT, "STRUCT", null, null, null);
      default:
        LOG.warning(
            "Unknown BigQuery type encountered: " + bqType.name() + ". Mapping to VARCHAR.");
        return new ColumnTypeInfo(Types.VARCHAR, bqType.name(), null, null, null);
    }
  }

  <T> List<T> findMatchingBigQueryObjects(
      String objectTypeName,
      Supplier<Page<T>> listAllOperation,
      Function<String, T> getSpecificOperation,
      Function<T, String> nameExtractor,
      String pattern,
      Pattern regex,
      BigQueryJdbcCustomLogger logger) {

    boolean needsList = needsListing(pattern);
    List<T> resultList = new ArrayList<>();

    try {
      Iterable<T> objects;
      if (needsList) {
        logger.info(
            String.format(
                "Listing all %ss (pattern: %s)...",
                objectTypeName, pattern == null ? "<all>" : pattern));
        Page<T> firstPage = listAllOperation.get();
        objects = firstPage.iterateAll();
        logger.fine(
            String.format(
                "Retrieved initial %s list, iterating & filtering if needed...", objectTypeName));

      } else {
        logger.info(String.format("Getting specific %s: '%s'", objectTypeName, pattern));
        T specificObject = getSpecificOperation.apply(pattern);
        objects =
            (specificObject == null)
                ? Collections.<T>emptyList()
                : Collections.singletonList(specificObject);
        if (specificObject == null) {
          logger.info(String.format("Specific %s not found: '%s'", objectTypeName, pattern));
        }
      }

      boolean wasListing = needsList;
      for (T obj : objects) {
        if (Thread.currentThread().isInterrupted()) {
          logger.warning("Thread interrupted during " + objectTypeName + " processing loop.");
          throw new InterruptedException(
              "Interrupted during " + objectTypeName + " processing loop");
        }
        if (obj != null) {
          if (wasListing && regex != null) {
            String name = nameExtractor.apply(obj);
            if (name != null && regex.matcher(name).matches()) {
              resultList.add(obj);
            }
          } else {
            resultList.add(obj);
          }
        }
      }

    } catch (BigQueryException e) {
      if (!needsList && e.getCode() == 404) {
        logger.info(String.format("%s '%s' not found (API error 404).", objectTypeName, pattern));
      } else {
        logger.warning(
            String.format(
                "BigQueryException finding %ss for pattern '%s': %s (Code: %d)",
                objectTypeName, pattern, e.getMessage(), e.getCode()));
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      logger.warning("Interrupted while finding " + objectTypeName + "s.");
    } catch (Exception e) {
      logger.severe(
          String.format(
              "Unexpected exception finding %ss for pattern '%s': %s",
              objectTypeName, pattern, e.getMessage()));
    }
    return resultList;
  }

  private static class TypeInfoRowData {
    String typeName;
    int jdbcType;
    Long precision;
    String literalPrefix;
    String literalSuffix;
    String createParams;
    int nullable;
    boolean caseSensitive;
    int searchable;
    boolean unsignedAttribute;
    boolean fixedPrecScale;
    boolean autoIncrement;
    String localTypeName;
    Long minimumScale;
    Long maximumScale;
    Long numPrecRadix;

    TypeInfoRowData(
        String typeName,
        int jdbcType,
        Long precision,
        String literalPrefix,
        String literalSuffix,
        String createParams,
        int nullable,
        boolean caseSensitive,
        int searchable,
        boolean unsignedAttribute,
        boolean fixedPrecScale,
        boolean autoIncrement,
        String localTypeName,
        Long minimumScale,
        Long maximumScale,
        Long numPrecRadix) {
      this.typeName = typeName;
      this.jdbcType = jdbcType;
      this.precision = precision;
      this.literalPrefix = literalPrefix;
      this.literalSuffix = literalSuffix;
      this.createParams = createParams;
      this.nullable = nullable;
      this.caseSensitive = caseSensitive;
      this.searchable = searchable;
      this.unsignedAttribute = unsignedAttribute;
      this.fixedPrecScale = fixedPrecScale;
      this.autoIncrement = autoIncrement;
      this.localTypeName = localTypeName;
      this.minimumScale = minimumScale;
      this.maximumScale = maximumScale;
      this.numPrecRadix = numPrecRadix;
    }
  }

  void sortResults(
      List<FieldValueList> collectedResults,
      Comparator<FieldValueList> comparator,
      String operationName,
      BigQueryJdbcCustomLogger logger) {

    if (collectedResults == null || collectedResults.isEmpty()) {
      logger.info(String.format("No results collected for %s, skipping sort.", operationName));
      return;
    }
    if (comparator == null) {
      logger.info(String.format("No comparator provided for %s, skipping sort.", operationName));
      return;
    }

    logger.info(
        String.format(
            "Sorting %d collected %s results...", collectedResults.size(), operationName));
    try {
      collectedResults.sort(comparator);
      logger.info(String.format("%s result sorting completed.", operationName));
    } catch (Exception e) {
      logger.severe(
          String.format("Error during sorting %s results: %s", operationName, e.getMessage()));
    }
  }

  private List<Field> defineBasePrivilegeFields() {
    List<Field> fields = new ArrayList<>(7);
    fields.add(
        Field.newBuilder("TABLE_CAT", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("TABLE_SCHEM", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("TABLE_NAME", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("GRANTOR", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    fields.add(
        Field.newBuilder("GRANTEE", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("PRIVILEGE", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.REQUIRED)
            .build());
    fields.add(
        Field.newBuilder("IS_GRANTABLE", StandardSQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build());
    return fields;
  }

  Pattern compileSqlLikePattern(String sqlLikePattern) {
    if (sqlLikePattern == null) {
      return null;
    }
    if (sqlLikePattern.isEmpty()) {
      return Pattern.compile("(?!)");
    }
    StringBuilder regex = new StringBuilder(sqlLikePattern.length() * 2);
    regex.append('^');
    for (int i = 0; i < sqlLikePattern.length(); i++) {
      char c = sqlLikePattern.charAt(i);
      switch (c) {
        case '%':
          regex.append(".*");
          break;
        case '_':
          regex.append('.');
          break;
        case '\\':
        case '.':
        case '[':
        case ']':
        case '(':
        case ')':
        case '{':
        case '}':
        case '*':
        case '+':
        case '?':
        case '^':
        case '$':
        case '|':
          regex.append('\\').append(c);
          break;
        default:
          regex.append(c);
          break;
      }
    }
    regex.append('$');
    return Pattern.compile(regex.toString(), Pattern.CASE_INSENSITIVE);
  }

  boolean needsListing(String pattern) {
    return pattern == null || pattern.contains("%") || pattern.contains("_");
  }

  FieldValue createStringFieldValue(String value) {
    return FieldValue.of(FieldValue.Attribute.PRIMITIVE, value);
  }

  FieldValue createLongFieldValue(Long value) {
    return (value == null)
        ? FieldValue.of(FieldValue.Attribute.PRIMITIVE, null)
        : FieldValue.of(FieldValue.Attribute.PRIMITIVE, String.valueOf(value));
  }

  FieldValue createNullFieldValue() {
    return FieldValue.of(FieldValue.Attribute.PRIMITIVE, null);
  }

  FieldValue createBooleanFieldValue(Boolean value) {
    return (value == null)
        ? FieldValue.of(FieldValue.Attribute.PRIMITIVE, null)
        : FieldValue.of(FieldValue.Attribute.PRIMITIVE, value ? "1" : "0");
  }

  private String getStringValueOrNull(FieldValueList fvl, int index) {
    if (fvl == null || index < 0 || index >= fvl.size()) return null;
    FieldValue fv = fvl.get(index);
    return (fv == null || fv.isNull()) ? null : fv.getStringValue();
  }

  private Long getLongValueOrNull(FieldValueList fvl, int index) {
    if (fvl == null || index < 0 || index >= fvl.size()) return null;
    FieldValue fv = fvl.get(index);
    try {
      return (fv == null || fv.isNull()) ? null : fv.getLongValue();
    } catch (NumberFormatException e) {
      LOG.warning("Could not parse Long value for index " + index);
      return null;
    }
  }

  private void waitForTasksCompletion(List<Future<?>> taskFutures) {
    LOG.info(String.format("Waiting for %d submitted tasks to complete...", taskFutures.size()));
    for (Future<?> future : taskFutures) {
      try {
        if (!future.isCancelled()) {
          future.get();
        }
      } catch (CancellationException e) {
        LOG.warning("A table processing task was cancelled.");
      } catch (ExecutionException e) {
        LOG.severe(
            String.format(
                "Error executing table processing task: %s",
                (e.getCause() != null ? e.getCause().getMessage() : e.getMessage())));
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        LOG.warning(
            "Fetcher thread interrupted while waiting for tasks. Attempting to cancel remaining"
                + " tasks.");
        taskFutures.forEach(f -> f.cancel(true));
        break;
      }
    }
    LOG.info("Finished waiting for tasks.");
  }

  private void populateQueue(
      List<FieldValueList> collectedResults,
      BlockingQueue<BigQueryFieldValueListWrapper> queue,
      FieldList resultSchemaFields) {
    LOG.info(String.format("Populating queue with %d results...", collectedResults.size()));
    try {
      for (FieldValueList sortedRow : collectedResults) {
        if (Thread.currentThread().isInterrupted()) {
          LOG.warning("Interrupted during queue population.");
          break;
        }
        queue.put(BigQueryFieldValueListWrapper.of(resultSchemaFields, sortedRow));
      }
      LOG.info("Finished populating queue.");
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      LOG.warning("Interrupted while putting row onto queue.");
    } catch (Exception e) {
      LOG.severe("Unexpected error populating queue: " + e.getMessage());
    }
  }

  private void signalEndOfData(
      BlockingQueue<BigQueryFieldValueListWrapper> queue, FieldList resultSchemaFields) {
    try {
      LOG.info("Adding end signal to queue.");
      queue.put(BigQueryFieldValueListWrapper.of(resultSchemaFields, null, true));
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      LOG.warning("Interrupted while sending end signal to queue.");
    } catch (Exception e) {
      LOG.severe("Exception while sending end signal to queue: " + e.getMessage());
    }
  }

  private void shutdownExecutor(ExecutorService executor) {
    if (executor == null || executor.isShutdown()) {
      return;
    }
    LOG.info("Shutting down column executor service...");
    executor.shutdown();
    try {
      if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
        LOG.warning("Executor did not terminate gracefully after 10s, forcing shutdownNow().");
        List<Runnable> droppedTasks = executor.shutdownNow();
        LOG.warning(
            "Executor shutdownNow() initiated. Dropped tasks count: " + droppedTasks.size());
        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
          LOG.severe("Executor did not terminate even after shutdownNow().");
        }
      }
      LOG.info("Executor shutdown complete.");
    } catch (InterruptedException ie) {
      LOG.warning(
          "Interrupted while waiting for executor termination. Forcing shutdownNow() again.");
      executor.shutdownNow();
      Thread.currentThread().interrupt();
    }
  }

  private String getCurrentCatalogName() {
    return this.connection.getCatalog();
  }

  private List<String> getAccessibleCatalogNames() {
    Set<String> accessibleCatalogs = new HashSet<>();
    String primaryCatalog = getCurrentCatalogName();
    if (primaryCatalog != null && !primaryCatalog.isEmpty()) {
      accessibleCatalogs.add(primaryCatalog);
    }

    List<String> additionalProjects = this.connection.getAdditionalProjects();
    if (additionalProjects != null) {
      for (String project : additionalProjects) {
        if (project != null && !project.isEmpty()) {
          accessibleCatalogs.add(project);
        }
      }
    }

    List<String> sortedCatalogs = new ArrayList<>(accessibleCatalogs);
    Collections.sort(sortedCatalogs);
    return sortedCatalogs;
  }

  static String readSqlFromFile(String filename) {
    InputStream in;
    in = BigQueryDatabaseMetaData.class.getResourceAsStream(filename);
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    StringBuilder builder = new StringBuilder();
    try (Scanner scanner = new Scanner(reader)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        builder.append(line).append("\n");
      }
    }
    return builder.toString();
  }

  String replaceSqlParameters(String sql, String... params) throws SQLException {
    return String.format(sql, (Object[]) params);
  }

  private void loadDriverVersionProperties() {
    if (parsedDriverVersion.get() != null) {
      return;
    }
    Properties props = new Properties();
    try (InputStream input =
        getClass().getResourceAsStream("/com/google/cloud/bigquery/jdbc/dependencies.properties")) {
      if (input == null) {
        String errorMessage =
            "Could not find dependencies.properties. Driver version information is unavailable.";
        LOG.severe(errorMessage);
        throw new IllegalStateException(errorMessage);
      }
      props.load(input);
      String versionString = props.getProperty("version.jdbc");
      if (versionString == null || versionString.trim().isEmpty()) {
        String errorMessage =
            "The property version.jdbc not found or empty in dependencies.properties.";
        LOG.severe(errorMessage);
        throw new IllegalStateException(errorMessage);
      }
      parsedDriverVersion.compareAndSet(null, versionString.trim());
      String[] parts = versionString.split("\\.");
      if (parts.length < 2) {
        return;
      }
      parsedDriverMajorVersion.compareAndSet(null, Integer.parseInt(parts[0]));
      String minorPart = parts[1];
      String numericMinor = minorPart.replaceAll("[^0-9].*", "");
      if (!numericMinor.isEmpty()) {
        parsedDriverMinorVersion.compareAndSet(null, Integer.parseInt(numericMinor));
      }
    } catch (IOException | NumberFormatException e) {
      String errorMessage =
          "Error reading dependencies.properties. Driver version information is"
              + " unavailable. Error: "
              + e.getMessage();
      LOG.severe(errorMessage);
      throw new IllegalStateException(errorMessage, e);
    }
  }
}
