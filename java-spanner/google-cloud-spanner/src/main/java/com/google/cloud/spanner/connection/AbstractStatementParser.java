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

package com.google.cloud.spanner.connection;

import static com.google.cloud.spanner.connection.SimpleParser.isValidIdentifierChar;
import static com.google.cloud.spanner.connection.StatementHintParser.convertHintsToOptions;

import com.google.api.core.InternalApi;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Options.ReadQueryUpdateTransactionOption;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.AbstractBaseUnitOfWork.InterceptorsUsage;
import com.google.cloud.spanner.connection.SimpleParser.Result;
import com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType;
import com.google.cloud.spanner.connection.UnitOfWork.CallType;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Suppliers;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheStats;
import com.google.common.cache.Weigher;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.spanner.v1.ExecuteSqlRequest.QueryOptions;
import java.nio.CharBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * Internal class for the Spanner Connection API.
 *
 * <p>Parses {@link ClientSideStatement}s and normal SQL statements. The parser is able to recognize
 * the type of statement, allowing the connection API to know which method on Spanner should be
 * called. The parser does not validate the validity of statements, except for {@link
 * ClientSideStatement}s. This means that an invalid DML statement could be accepted by the {@link
 * AbstractStatementParser} and sent to Spanner, and Spanner will then reject it with some error
 * message.
 */
@InternalApi
public abstract class AbstractStatementParser {
  private static final Object lock = new Object();
  private static final Map<Dialect, AbstractStatementParser> INSTANCES = new HashMap<>();
  private static final ImmutableMap<Dialect, Class<? extends AbstractStatementParser>>
      KNOWN_PARSER_CLASSES =
          ImmutableMap.of(
              Dialect.GOOGLE_STANDARD_SQL,
              SpannerStatementParser.class,
              Dialect.POSTGRESQL,
              PostgreSQLStatementParser.class);

  @VisibleForTesting
  static void resetParsers() {
    synchronized (lock) {
      INSTANCES.clear();
    }
  }

  /** Get an instance of {@link AbstractStatementParser} for the specified dialect. */
  public static AbstractStatementParser getInstance(Dialect dialect) {
    synchronized (lock) {
      if (!INSTANCES.containsKey(dialect)) {
        try {
          Class<? extends AbstractStatementParser> clazz = KNOWN_PARSER_CLASSES.get(dialect);
          if (clazz == null) {
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.INTERNAL, "There is no known statement parser for dialect " + dialect);
          }
          INSTANCES.put(dialect, clazz.getDeclaredConstructor().newInstance());
        } catch (Exception exception) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INTERNAL,
              "Could not instantiate statement parser for dialect " + dialect.name(),
              exception);
        }
      }
      return INSTANCES.get(dialect);
    }
  }

  static final Set<String> ddlStatements =
      ImmutableSet.of("CREATE", "DROP", "ALTER", "ANALYZE", "GRANT", "REVOKE", "RENAME");
  static final Set<String> selectStatements =
      ImmutableSet.of("SELECT", "WITH", "SHOW", "FROM", "GRAPH", "CALL");
  static final Set<String> SELECT_STATEMENTS_ALLOWING_PRECEDING_BRACKETS =
      ImmutableSet.of("SELECT", "FROM");
  static final Set<String> dmlStatements = ImmutableSet.of("INSERT", "UPDATE", "DELETE");

  /*
   * The following fixed pre-parsed statements are used internally by the Connection API. These do
   * not need to be parsed using a specific dialect, as they are equal for all dialects, and
   * pre-parsing them avoids the need to repeatedly parse statements that are used internally.
   */

  /** Begins a transaction. */
  static final ParsedStatement BEGIN_STATEMENT;

  /**
   * Create a COMMIT statement to use with the {@link Connection#commit()} method to allow it to be
   * cancelled, time out or retried.
   *
   * <p>{@link ReadWriteTransaction} uses the generic methods {@link
   * ReadWriteTransaction#executeStatementAsync(CallType, ParsedStatement, Callable,
   * InterceptorsUsage, Collection)} and {@link ReadWriteTransaction#runWithRetry(Callable)} to
   * allow statements to be cancelled, to timeout and to be retried. These methods require a {@link
   * ParsedStatement} as input. When the {@link Connection#commit()} method is called directly, we
   * do not have a {@link ParsedStatement}, and the method uses this statement instead in order to
   * use the same logic as the other statements.
   */
  static final ParsedStatement COMMIT_STATEMENT;

  /** The {@link Statement} and {@link Callable} for rollbacks */
  static final ParsedStatement ROLLBACK_STATEMENT;

  /**
   * Create a RUN BATCH statement to use with the {@link Connection#executeBatchUpdate(Iterable)}
   * method to allow it to be cancelled, time out or retried.
   *
   * <p>{@link ReadWriteTransaction} uses the generic methods {@link
   * ReadWriteTransaction#executeStatementAsync(CallType, ParsedStatement, Callable, Collection)}
   * and {@link ReadWriteTransaction#runWithRetry(Callable)} to allow statements to be cancelled, to
   * timeout and to be retried. These methods require a {@link ParsedStatement} as input. When the
   * {@link Connection#executeBatchUpdate(Iterable)} method is called, we do not have one {@link
   * ParsedStatement}, and the method uses this statement instead in order to use the same logic as
   * the other statements.
   */
  static final ParsedStatement RUN_BATCH_STATEMENT;

  static {
    try {
      BEGIN_STATEMENT = getInstance(Dialect.GOOGLE_STANDARD_SQL).parse(Statement.of("BEGIN"));
      COMMIT_STATEMENT = getInstance(Dialect.GOOGLE_STANDARD_SQL).parse(Statement.of("COMMIT"));
      ROLLBACK_STATEMENT = getInstance(Dialect.GOOGLE_STANDARD_SQL).parse(Statement.of("ROLLBACK"));
      RUN_BATCH_STATEMENT =
          getInstance(Dialect.GOOGLE_STANDARD_SQL).parse(Statement.of("RUN BATCH"));

    } catch (Throwable ex) {
      Logger logger = Logger.getLogger(AbstractStatementParser.class.getName());
      logger.log(Level.SEVERE, "Static initialization failure.", ex);
      throw ex;
    }
  }

  /** The type of statement that has been recognized by the parser. */
  @InternalApi
  public enum StatementType {
    CLIENT_SIDE,
    DDL,
    QUERY,
    UPDATE,
    UNKNOWN
  }

  /** A statement that has been parsed */
  @InternalApi
  public static class ParsedStatement {
    private final StatementType type;
    private final ClientSideStatementImpl clientSideStatement;
    private final Statement statement;
    private final Supplier<String> sqlWithoutComments;
    private final Supplier<Boolean> returningClause;
    private final ReadQueryUpdateTransactionOption[] optionsFromHints;

    private static ParsedStatement clientSideStatement(
        ClientSideStatementImpl clientSideStatement,
        Statement statement,
        Supplier<String> sqlWithoutComments) {
      return new ParsedStatement(clientSideStatement, statement, sqlWithoutComments);
    }

    private static ParsedStatement ddl(Statement statement, Supplier<String> sqlWithoutComments) {
      return new ParsedStatement(StatementType.DDL, statement, sqlWithoutComments);
    }

    private static ParsedStatement query(
        Statement statement,
        Supplier<String> sqlWithoutComments,
        QueryOptions defaultQueryOptions,
        ReadQueryUpdateTransactionOption[] optionsFromHints) {
      return new ParsedStatement(
          StatementType.QUERY,
          null,
          statement,
          sqlWithoutComments,
          defaultQueryOptions,
          Suppliers.ofInstance(false),
          optionsFromHints);
    }

    private static ParsedStatement update(
        Statement statement,
        Supplier<String> sqlWithoutComments,
        Supplier<Boolean> returningClause,
        ReadQueryUpdateTransactionOption[] optionsFromHints) {
      return new ParsedStatement(
          StatementType.UPDATE, statement, sqlWithoutComments, returningClause, optionsFromHints);
    }

    private static ParsedStatement unknown(
        Statement statement, Supplier<String> sqlWithoutComments) {
      return new ParsedStatement(StatementType.UNKNOWN, statement, sqlWithoutComments);
    }

    private ParsedStatement(
        ClientSideStatementImpl clientSideStatement,
        Statement statement,
        Supplier<String> sqlWithoutComments) {
      Preconditions.checkNotNull(clientSideStatement);
      Preconditions.checkNotNull(statement);
      this.type = StatementType.CLIENT_SIDE;
      this.clientSideStatement = clientSideStatement;
      this.statement = statement;
      this.sqlWithoutComments = sqlWithoutComments;
      this.returningClause = Suppliers.ofInstance(false);
      this.optionsFromHints = EMPTY_OPTIONS;
    }

    private ParsedStatement(
        StatementType type,
        Statement statement,
        Supplier<String> sqlWithoutComments,
        Supplier<Boolean> returningClause,
        ReadQueryUpdateTransactionOption[] optionsFromHints) {
      this(type, null, statement, sqlWithoutComments, null, returningClause, optionsFromHints);
    }

    private ParsedStatement(
        StatementType type, Statement statement, Supplier<String> sqlWithoutComments) {
      this(
          type,
          null,
          statement,
          sqlWithoutComments,
          null,
          Suppliers.ofInstance(false),
          EMPTY_OPTIONS);
    }

    private ParsedStatement(
        StatementType type,
        ClientSideStatementImpl clientSideStatement,
        Statement statement,
        Supplier<String> sqlWithoutComments,
        QueryOptions defaultQueryOptions,
        Supplier<Boolean> returningClause,
        ReadQueryUpdateTransactionOption[] optionsFromHints) {
      Preconditions.checkNotNull(type);
      this.type = type;
      this.clientSideStatement = clientSideStatement;
      this.statement = statement == null ? null : mergeQueryOptions(statement, defaultQueryOptions);
      this.sqlWithoutComments = Preconditions.checkNotNull(sqlWithoutComments);
      this.returningClause = returningClause;
      this.optionsFromHints = optionsFromHints;
    }

    private ParsedStatement copy(Statement statement, QueryOptions defaultQueryOptions) {
      return new ParsedStatement(
          this.type,
          this.clientSideStatement,
          statement.withReplacedSql(this.statement.getSql()),
          this.sqlWithoutComments,
          defaultQueryOptions,
          this.returningClause,
          this.optionsFromHints);
    }

    private ParsedStatement forCache() {
      return new ParsedStatement(
          this.type,
          this.clientSideStatement,
          Statement.of(this.statement.getSql()),
          this.sqlWithoutComments,
          null,
          this.returningClause,
          this.optionsFromHints);
    }

    @Override
    public int hashCode() {
      return Objects.hash(
          this.type, this.clientSideStatement, this.statement, this.sqlWithoutComments);
    }

    @Override
    public boolean equals(Object other) {
      if (!(other instanceof ParsedStatement)) {
        return false;
      }
      ParsedStatement o = (ParsedStatement) other;
      return Objects.equals(this.type, o.type)
          && Objects.equals(this.clientSideStatement, o.clientSideStatement)
          && Objects.equals(this.statement, o.statement)
          && Objects.equals(this.sqlWithoutComments, o.sqlWithoutComments);
    }

    /**
     * @return the type of statement that was recognized by the parser.
     */
    @InternalApi
    public StatementType getType() {
      return type;
    }

    /**
     * @return whether the statement has a returning clause or not.
     */
    @InternalApi
    public boolean hasReturningClause() {
      return this.returningClause.get();
    }

    @InternalApi
    public ReadQueryUpdateTransactionOption[] getOptionsFromHints() {
      return this.optionsFromHints;
    }

    /**
     * @return true if the statement is a query that will return a {@link
     *     com.google.cloud.spanner.ResultSet}.
     */
    @InternalApi
    public boolean isQuery() {
      switch (type) {
        case CLIENT_SIDE:
          return getClientSideStatement().isQuery();
        case QUERY:
          return true;
        case UPDATE:
        case DDL:
        case UNKNOWN:
        default:
      }
      return false;
    }

    /**
     * @return true if the statement is a DML statement or a client side statement that will return
     *     an update count.
     */
    @InternalApi
    public boolean isUpdate() {
      switch (type) {
        case CLIENT_SIDE:
          return getClientSideStatement().isUpdate();
        case UPDATE:
          return true;
        case QUERY:
        case DDL:
        case UNKNOWN:
        default:
      }
      return false;
    }

    /**
     * @return true if the statement is a DDL statement.
     */
    @InternalApi
    public boolean isDdl() {
      switch (type) {
        case DDL:
          return true;
        case CLIENT_SIDE:
        case UPDATE:
        case QUERY:
        case UNKNOWN:
        default:
      }
      return false;
    }

    /**
     * @return the {@link ClientSideStatementType} of this statement. This method may only be called
     *     on statements of type {@link StatementType#CLIENT_SIDE}.
     */
    @InternalApi
    public ClientSideStatementType getClientSideStatementType() {
      Preconditions.checkState(type == StatementType.CLIENT_SIDE);
      return clientSideStatement.getStatementType();
    }

    Statement getStatement() {
      return statement;
    }

    /**
     * Merges the {@link QueryOptions} of the {@link Statement} with the current {@link
     * QueryOptions} of this connection. The {@link QueryOptions} that are already present on the
     * statement take precedence above the connection {@link QueryOptions}.
     */
    Statement mergeQueryOptions(Statement statement, QueryOptions defaultQueryOptions) {
      if (defaultQueryOptions == null
          || defaultQueryOptions.equals(QueryOptions.getDefaultInstance())) {
        return statement;
      }
      if (statement.getQueryOptions() == null) {
        return statement.toBuilder().withQueryOptions(defaultQueryOptions).build();
      }
      return statement.toBuilder()
          .withQueryOptions(
              defaultQueryOptions.toBuilder().mergeFrom(statement.getQueryOptions()).build())
          .build();
    }

    /**
     * @return the original SQL statement
     */
    @InternalApi
    public String getSql() {
      return statement.getSql();
    }

    /**
     * @return the SQL statement with all comments removed from the SQL string.
     * @deprecated use {@link #getSql()} instead
     */
    @Deprecated
    @InternalApi
    public String getSqlWithoutComments() {
      return sqlWithoutComments.get();
    }

    ClientSideStatement getClientSideStatement() {
      Preconditions.checkState(
          clientSideStatement != null,
          "This ParsedStatement does not contain a ClientSideStatement");
      return clientSideStatement;
    }
  }

  private final Set<ClientSideStatementImpl> statements;

  /** The default maximum size of the statement cache in Mb. */
  public static final int DEFAULT_MAX_STATEMENT_CACHE_SIZE_MB = 5;

  private static int getMaxStatementCacheSize() {
    String stringValue = System.getProperty("spanner.statement_cache_size_mb");
    if (stringValue == null) {
      return DEFAULT_MAX_STATEMENT_CACHE_SIZE_MB;
    }
    int value = 0;
    try {
      value = Integer.parseInt(stringValue);
    } catch (NumberFormatException ignore) {
    }
    return Math.max(value, 0);
  }

  private static boolean isRecordStatementCacheStats() {
    return "true"
        .equalsIgnoreCase(System.getProperty("spanner.record_statement_cache_stats", "false"));
  }

  /**
   * Cache for parsed statements. This prevents statements that are executed multiple times by the
   * application to be parsed over and over again. The default maximum size is 5Mb.
   */
  private final Cache<String, ParsedStatement> statementCache;

  AbstractStatementParser(Set<ClientSideStatementImpl> statements) {
    this.statements = Collections.unmodifiableSet(statements);
    int maxCacheSize = getMaxStatementCacheSize();
    if (maxCacheSize > 0) {
      CacheBuilder<String, ParsedStatement> cacheBuilder =
          CacheBuilder.newBuilder()
              // Set the max size to (approx) 5MB (by default).
              .maximumWeight(maxCacheSize * 1024L * 1024L)
              // We do length*2 because Java uses 2 bytes for each char.
              .weigher(
                  (Weigher<String, ParsedStatement>)
                      (key, value) -> 2 * key.length() + 2 * value.statement.getSql().length())
              .concurrencyLevel(Runtime.getRuntime().availableProcessors());
      if (isRecordStatementCacheStats()) {
        cacheBuilder.recordStats();
      }
      this.statementCache = cacheBuilder.build();
    } else {
      this.statementCache = null;
    }
  }

  @VisibleForTesting
  CacheStats getStatementCacheStats() {
    return statementCache == null ? null : statementCache.stats();
  }

  @VisibleForTesting
  Set<ClientSideStatementImpl> getClientSideStatements() {
    return statements;
  }

  /**
   * Parses the given statement and categorizes it as one of the possible {@link StatementType}s.
   * The validity of the statement is not checked, unless it is a client-side statement.
   *
   * @param statement The statement to parse.
   * @return the parsed and categorized statement.
   */
  @InternalApi
  public ParsedStatement parse(Statement statement) {
    return parse(statement, null);
  }

  ParsedStatement parse(Statement statement, QueryOptions defaultQueryOptions) {
    if (statementCache == null) {
      return internalParse(statement, defaultQueryOptions);
    }

    ParsedStatement parsedStatement = statementCache.getIfPresent(statement.getSql());
    if (parsedStatement == null) {
      parsedStatement = internalParse(statement, defaultQueryOptions);
      statementCache.put(statement.getSql(), parsedStatement.forCache());
      return parsedStatement;
    }
    return parsedStatement.copy(statement, defaultQueryOptions);
  }

  ParsedStatement internalParse(Statement statement, QueryOptions defaultQueryOptions) {
    String sql = statement.getSql();
    StatementHintParser statementHintParser = new StatementHintParser(getDialect(), sql);
    ReadQueryUpdateTransactionOption[] optionsFromHints = EMPTY_OPTIONS;
    if (statementHintParser.hasStatementHints()
        && !statementHintParser.getClientSideStatementHints().isEmpty()) {
      statement =
          statement.toBuilder().replace(statementHintParser.getSqlWithoutClientSideHints()).build();
      optionsFromHints = convertHintsToOptions(statementHintParser.getClientSideStatementHints());
    }
    // Create a supplier that will actually remove all comments and hints from the SQL string to be
    // backwards compatible with anything that really needs the SQL string without comments.
    Supplier<String> sqlWithoutCommentsSupplier =
        Suppliers.memoize(() -> removeCommentsAndTrim(sql));

    // Get rid of any spaces/comments at the start of the string.
    SimpleParser simpleParser = new SimpleParser(getDialect(), sql);
    simpleParser.skipWhitespaces();
    // Create a wrapper around the SQL string from the point after the first whitespace.
    CharBuffer charBuffer = CharBuffer.wrap(sql, simpleParser.getPos(), sql.length());
    ClientSideStatementImpl client = parseClientSideStatement(charBuffer);

    if (client != null) {
      return ParsedStatement.clientSideStatement(client, statement, sqlWithoutCommentsSupplier);
    } else {
      // Find the first keyword in the SQL statement.
      Result keywordResult = simpleParser.eatNextKeyword();
      if (keywordResult.isValid()) {
        // Determine the statement type based on the first keyword.
        String keyword = keywordResult.getValue().toUpperCase();
        if (keywordResult.isInParenthesis()) {
          // If the first keyword is inside one or more parentheses, then only a subset of all
          // keywords are allowed.
          if (SELECT_STATEMENTS_ALLOWING_PRECEDING_BRACKETS.contains(keyword)) {
            return ParsedStatement.query(
                statement, sqlWithoutCommentsSupplier, defaultQueryOptions, optionsFromHints);
          }
        } else {
          if (selectStatements.contains(keyword)) {
            return ParsedStatement.query(
                statement, sqlWithoutCommentsSupplier, defaultQueryOptions, optionsFromHints);
          } else if (dmlStatements.contains(keyword)) {
            return ParsedStatement.update(
                statement,
                sqlWithoutCommentsSupplier,
                // TODO: Make the returning clause check work without removing comments
                Suppliers.memoize(() -> checkReturningClause(sqlWithoutCommentsSupplier.get())),
                optionsFromHints);
          } else if (ddlStatements.contains(keyword)) {
            return ParsedStatement.ddl(statement, sqlWithoutCommentsSupplier);
          }
        }
      }
    }
    // Fallthrough: Return an unknown statement.
    return ParsedStatement.unknown(statement, sqlWithoutCommentsSupplier);
  }

  /**
   * Parses the given statement as a client-side statement. Client-side statements are statements
   * that are never sent to Cloud Spanner, but that are interpreted by the Connection API and then
   * translated into some action, such as for example starting a transaction or getting the last
   * commit timestamp.
   *
   * @param sql The statement to try to parse as a client-side statement (without any comments).
   * @return a valid {@link ClientSideStatement} or null if the statement is not a client-side
   *     statement.
   */
  @VisibleForTesting
  ClientSideStatementImpl parseClientSideStatement(CharSequence sql) {
    for (ClientSideStatementImpl css : statements) {
      if (css.matches(sql)) {
        return css;
      }
    }
    return null;
  }

  /**
   * Checks whether the given statement is (probably) a DDL statement. The method does not check the
   * validity of the statement, only if it is a DDL statement based on the first word in the
   * statement.
   *
   * @param sql The statement to check (without any comments).
   * @return <code>true</code> if the statement is a DDL statement (i.e. starts with 'CREATE',
   *     'ALTER' or 'DROP').
   * @deprecated Use {@link #parse(Statement)} instead
   */
  @InternalApi
  @Deprecated
  public boolean isDdlStatement(String sql) {
    return statementStartsWith(sql, ddlStatements);
  }

  /**
   * Checks whether the given statement is (probably) a SELECT query. The method does not check the
   * validity of the statement, only if it is a SELECT statement based on the first word in the
   * statement.
   *
   * @param sql The statement to check (without any comments).
   * @return <code>true</code> if the statement is a SELECT statement (i.e. starts with 'SELECT').
   * @deprecated Use {@link #parse(Statement)} instead
   */
  @InternalApi
  @Deprecated
  public boolean isQuery(String sql) {
    // Skip any query hints at the beginning of the query.
    // We only do this if we actually know that it starts with a hint to prevent unnecessary
    // re-assigning the exact same sql string.
    if (sql.startsWith("@")) {
      sql = removeStatementHint(sql);
    }
    if (sql.startsWith("(")) {
      sql = removeOpeningBrackets(sql);
      return statementStartsWith(sql, SELECT_STATEMENTS_ALLOWING_PRECEDING_BRACKETS);
    }
    return statementStartsWith(sql, selectStatements);
  }

  /**
   * Checks whether the given statement is (probably) an update statement. The method does not check
   * the validity of the statement, only if it is an update statement based on the first word in the
   * statement.
   *
   * @param sql The statement to check (without any comments).
   * @return <code>true</code> if the statement is a DML update statement (i.e. starts with
   *     'INSERT', 'UPDATE' or 'DELETE').
   * @deprecated Use {@link #parse(Statement)} instead
   */
  @InternalApi
  @Deprecated
  public boolean isUpdateStatement(String sql) {
    // Skip any query hints at the beginning of the query.
    if (sql.startsWith("@")) {
      sql = removeStatementHint(sql);
    }
    return statementStartsWith(sql, dmlStatements);
  }

  private boolean statementStartsWith(String sql, Iterable<String> checkStatements) {
    Preconditions.checkNotNull(sql);
    Iterator<String> tokens = Splitter.onPattern("\\s+").split(sql).iterator();
    if (!tokens.hasNext()) {
      return false;
    }
    String token = tokens.next();
    for (String check : checkStatements) {
      if (token.equalsIgnoreCase(check)) {
        return true;
      }
    }
    return false;
  }

  static final char SINGLE_QUOTE = '\'';
  static final char DOUBLE_QUOTE = '"';
  static final char BACKTICK_QUOTE = '`';
  static final char HYPHEN = '-';
  static final char DASH = '#';
  static final char SLASH = '/';
  static final char ASTERISK = '*';
  static final char DOLLAR = '$';
  static final char SPACE = ' ';
  static final char CLOSE_PARENTHESIS = ')';
  static final char COMMA = ',';
  static final char UNDERSCORE = '_';
  static final char BACKSLASH = '\\';

  /**
   * Removes comments from and trims the given sql statement using the dialect of this parser.
   *
   * @param sql The sql statement to remove comments from and to trim.
   * @return the sql statement without the comments and leading and trailing spaces.
   */
  @InternalApi
  abstract String removeCommentsAndTrimInternal(String sql);

  /**
   * Removes comments from and trims the given sql statement using the dialect of this parser.
   *
   * @param sql The sql statement to remove comments from and to trim.
   * @return the sql statement without the comments and leading and trailing spaces.
   */
  @InternalApi
  public String removeCommentsAndTrim(String sql) {
    return removeCommentsAndTrimInternal(sql);
  }

  /** Removes any statement hints at the beginning of the statement. */
  abstract String removeStatementHint(String sql);

  private String removeOpeningBrackets(String sql) {
    int index = 0;
    while (index < sql.length()) {
      if (sql.charAt(index) == '(' || Character.isWhitespace(sql.charAt(index))) {
        index++;
      } else {
        return sql.substring(index);
      }
    }
    return sql;
  }

  @VisibleForTesting
  static final ReadQueryUpdateTransactionOption[] EMPTY_OPTIONS =
      new ReadQueryUpdateTransactionOption[0];

  /** Parameter information with positional parameters translated to named parameters. */
  @InternalApi
  public static class ParametersInfo {
    public final int numberOfParameters;
    public final String sqlWithNamedParameters;

    ParametersInfo(int numberOfParameters, String sqlWithNamedParameters) {
      this.numberOfParameters = numberOfParameters;
      this.sqlWithNamedParameters = sqlWithNamedParameters;
    }
  }

  /**
   * Converts all positional parameters (?) in the given sql string into named parameters. The
   * parameters are named @p1, @p2, etc. for GoogleSQL, and $1, $2, etc. for PostgreSQL. This method
   * is used when converting a JDBC statement that uses positional parameters to a Cloud Spanner
   * {@link Statement} instance that requires named parameters.
   *
   * @param sql The sql string that should be converted to use named parameters
   * @return A {@link ParametersInfo} object containing a string with named parameters instead of
   *     positional parameters and the number of parameters.
   * @throws SpannerException If the input sql string contains an unclosed string/byte literal.
   */
  @InternalApi
  public ParametersInfo convertPositionalParametersToNamedParameters(char paramChar, String sql) {
    Preconditions.checkNotNull(sql);
    final String namedParamPrefix = getQueryParameterPrefix();
    StringBuilder named = new StringBuilder(sql.length() + countOccurrencesOf(paramChar, sql));
    int index = 0;
    int paramIndex = 1;
    while (index < sql.length()) {
      char c = sql.charAt(index);
      if (c == paramChar) {
        named.append(namedParamPrefix).append(paramIndex);
        paramIndex++;
        index++;
      } else {
        index = skip(sql, index, named);
      }
    }
    return new ParametersInfo(paramIndex - 1, named.toString());
  }

  /** Convenience method that is used to estimate the number of parameters in a SQL statement. */
  static int countOccurrencesOf(char c, String string) {
    int res = 0;
    for (int i = 0; i < string.length(); i++) {
      if (string.charAt(i) == c) {
        res++;
      }
    }
    return res;
  }

  /**
   * Checks if the given SQL string contains a Returning clause. This method is used only in case of
   * a DML statement.
   *
   * @param sql The sql string without comments that has to be evaluated.
   * @return A boolean indicating whether the sql string has a Returning clause or not.
   */
  @InternalApi
  protected abstract boolean checkReturningClauseInternal(String sql);

  /**
   * Checks if the given SQL string contains a Returning clause. This method is used only in case of
   * a DML statement.
   *
   * @param sql The sql string without comments that has to be evaluated.
   * @return A boolean indicating whether the sql string has a Returning clause or not.
   */
  @InternalApi
  public boolean checkReturningClause(String sql) {
    return checkReturningClauseInternal(sql);
  }

  abstract Dialect getDialect();

  /**
   * Returns true if this dialect supports nested comments.
   *
   * <ul>
   *   <li>This method should return false for dialects that consider this to be a valid comment:
   *       <code>/* A comment /* still a comment *&#47;</code>.
   *   <li>This method should return true for dialects that require all comment start sequences to
   *       be balanced with a comment end sequence: <code>
   *       /* A comment /* still a comment *&#47; Also still a comment *&#47;</code>.
   * </ul>
   */
  abstract boolean supportsNestedComments();

  /**
   * Returns true for dialects that support dollar-quoted string literals.
   *
   * <p>Example: <code>$tag$This is a string$tag$</code>.
   */
  abstract boolean supportsDollarQuotedStrings();

  /**
   * Returns true for dialects that support backticks as a quoting character, either for string
   * literals or identifiers.
   */
  abstract boolean supportsBacktickQuote();

  /**
   * Returns true for dialects that support triple-quoted string literals and identifiers.
   *
   * <p>Example: ```This is a triple-quoted string```
   */
  abstract boolean supportsTripleQuotedStrings();

  /**
   * Returns true if the dialect supports escaping a quote character within a literal with the same
   * quote as the literal is using. That is: 'foo''bar' means "foo'bar".
   */
  abstract boolean supportsEscapeQuoteWithQuote();

  /** Returns true if the dialect supports starting an escape sequence with a backslash. */
  abstract boolean supportsBackslashEscape();

  /**
   * Returns true if the dialect supports single-line comments that start with a dash.
   *
   * <p>Example: # This is a comment
   */
  abstract boolean supportsHashSingleLineComments();

  /**
   * Returns true for dialects that allow line-feeds in quoted strings. Note that the return value
   * of this is not used for triple-quoted strings. Triple-quoted strings are assumed to always
   * support line-feeds.
   */
  abstract boolean supportsLineFeedInQuotedString();

  /** Returns the query parameter prefix that should be used for this dialect. */
  abstract String getQueryParameterPrefix();

  /** Reads a dollar-quoted string literal from position index in the given sql string. */
  String parseDollarQuotedString(String sql, int index) {
    // Look ahead to the next dollar sign (if any). Everything in between is the quote tag.
    StringBuilder tag = new StringBuilder();
    while (index < sql.length()) {
      char c = sql.charAt(index);
      if (c == DOLLAR) {
        return tag.toString();
      }
      if (!isValidIdentifierChar(c)) {
        break;
      }
      tag.append(c);
      index++;
    }
    return null;
  }

  /**
   * Skips the next character, literal, identifier, or comment in the given sql string from the
   * given index. The skipped characters are added to result if it is not null.
   */
  int skip(String sql, int currentIndex, @Nullable StringBuilder result) {
    if (currentIndex >= sql.length()) {
      return currentIndex;
    }
    char currentChar = sql.charAt(currentIndex);

    if (currentChar == SINGLE_QUOTE
        || currentChar == DOUBLE_QUOTE
        || (supportsBacktickQuote() && currentChar == BACKTICK_QUOTE)) {
      appendIfNotNull(result, currentChar);
      return skipQuoted(sql, currentIndex, currentChar, result);
    } else if (supportsDollarQuotedStrings() && currentChar == DOLLAR) {
      String dollarTag = parseDollarQuotedString(sql, currentIndex + 1);
      if (dollarTag != null) {
        appendIfNotNull(result, currentChar, dollarTag, currentChar);
        return skipQuoted(
            sql, currentIndex + dollarTag.length() + 1, currentChar, dollarTag, result);
      }
    } else if (currentChar == HYPHEN
        && sql.length() > (currentIndex + 1)
        && sql.charAt(currentIndex + 1) == HYPHEN) {
      return skipSingleLineComment(sql, /* prefixLength= */ 2, currentIndex, result);
    } else if (currentChar == DASH && supportsHashSingleLineComments()) {
      return skipSingleLineComment(sql, /* prefixLength= */ 1, currentIndex, result);
    } else if (currentChar == SLASH
        && sql.length() > (currentIndex + 1)
        && sql.charAt(currentIndex + 1) == ASTERISK) {
      return skipMultiLineComment(sql, currentIndex, result);
    }

    appendIfNotNull(result, currentChar);
    return currentIndex + 1;
  }

  /** Skips a single-line comment from startIndex and adds it to result if result is not null. */
  int skipSingleLineComment(
      String sql, int prefixLength, int startIndex, @Nullable StringBuilder result) {
    return skipSingleLineComment(getDialect(), sql, prefixLength, startIndex, result);
  }

  static int skipSingleLineComment(
      Dialect dialect,
      String sql,
      int prefixLength,
      int startIndex,
      @Nullable StringBuilder result) {
    SimpleParser simpleParser = new SimpleParser(dialect, sql, startIndex, false);
    if (simpleParser.skipSingleLineComment(prefixLength)) {
      appendIfNotNull(result, sql.substring(startIndex, simpleParser.getPos()));
    }
    return simpleParser.getPos();
  }

  /** Skips a multi-line comment from startIndex and adds it to result if result is not null. */
  int skipMultiLineComment(String sql, int startIndex, @Nullable StringBuilder result) {
    SimpleParser simpleParser = new SimpleParser(getDialect(), sql, startIndex, false);
    if (simpleParser.skipMultiLineComment()) {
      appendIfNotNull(result, sql.substring(startIndex, simpleParser.getPos()));
    }
    return simpleParser.getPos();
  }

  /** Skips a quoted string from startIndex. */
  private int skipQuoted(
      String sql, int startIndex, char startQuote, @Nullable StringBuilder result) {
    return skipQuoted(sql, startIndex, startQuote, null, result);
  }

  /**
   * Skips a quoted string from startIndex. The quote character is assumed to be $ if dollarTag is
   * not null.
   */
  int skipQuoted(
      String sql,
      int startIndex,
      char startQuote,
      @Nullable String dollarTag,
      @Nullable StringBuilder result) {
    boolean isTripleQuoted =
        supportsTripleQuotedStrings()
            && sql.length() > startIndex + 2
            && sql.charAt(startIndex + 1) == startQuote
            && sql.charAt(startIndex + 2) == startQuote;
    int currentIndex = startIndex + (isTripleQuoted ? 3 : 1);
    if (isTripleQuoted) {
      appendIfNotNull(result, startQuote);
      appendIfNotNull(result, startQuote);
    }
    int length = sql.length();
    while (currentIndex < length) {
      char currentChar = sql.charAt(currentIndex);
      if (currentChar == startQuote) {
        if (supportsDollarQuotedStrings() && currentChar == DOLLAR) {
          // Check if this is the end of the current dollar quoted string.
          String tag = parseDollarQuotedString(sql, currentIndex + 1);
          if (tag != null && tag.equals(dollarTag)) {
            appendIfNotNull(result, currentChar, dollarTag, currentChar);
            return currentIndex + tag.length() + 2;
          }
        } else if (supportsEscapeQuoteWithQuote()
            && length > currentIndex + 1
            && sql.charAt(currentIndex + 1) == startQuote) {
          // This is an escaped quote (e.g. 'foo''bar')
          appendIfNotNull(result, currentChar);
          appendIfNotNull(result, currentChar);
          currentIndex += 2;
          continue;
        } else if (isTripleQuoted) {
          // Check if this is the end of the triple-quoted string.
          if (length > currentIndex + 2
              && sql.charAt(currentIndex + 1) == startQuote
              && sql.charAt(currentIndex + 2) == startQuote) {
            appendIfNotNull(result, currentChar);
            appendIfNotNull(result, currentChar);
            appendIfNotNull(result, currentChar);
            return currentIndex + 3;
          }
        } else {
          appendIfNotNull(result, currentChar);
          return currentIndex + 1;
        }
      } else if (supportsBackslashEscape()
          && currentChar == BACKSLASH
          && length > currentIndex + 1
          && (sql.charAt(currentIndex + 1) == startQuote
              || sql.charAt(currentIndex + 1) == BACKSLASH)) {
        // This is an escaped quote (e.g. 'foo\'bar') or an escaped backslash (e.g. 'test\\').
        // Note that in raw strings, the \ officially does not start an escape sequence, but the
        // result is still the same, as in a raw string 'both characters are preserved'.
        appendIfNotNull(result, currentChar);
        appendIfNotNull(result, sql.charAt(currentIndex + 1));
        currentIndex += 2;
        continue;
      } else if (currentChar == '\n' && !isTripleQuoted && !supportsLineFeedInQuotedString()) {
        break;
      }
      currentIndex++;
      appendIfNotNull(result, currentChar);
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT, "SQL statement contains an unclosed literal: " + sql);
  }

  /** Appends the given character to result if result is not null. */
  private void appendIfNotNull(@Nullable StringBuilder result, char currentChar) {
    if (result != null) {
      result.append(currentChar);
    }
  }

  /** Appends the given suffix to result if result is not null. */
  private static void appendIfNotNull(@Nullable StringBuilder result, String suffix) {
    if (result != null) {
      result.append(suffix);
    }
  }

  /** Appends the given prefix, tag, and suffix to result if result is not null. */
  private static void appendIfNotNull(
      @Nullable StringBuilder result, char prefix, String tag, char suffix) {
    if (result != null) {
      result.append(prefix).append(tag).append(suffix);
    }
  }
}
