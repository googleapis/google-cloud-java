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

import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.jdbc.StatementResult.ResultType;
import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Implementation of the {@link ClientSideStatement} interface. The instances of this class are
 * imported from the file 'ClientSideStatements.json' in the resources folder.
 */
class ClientSideStatementImpl implements ClientSideStatement {

  /**
   * Statements that set a value, such as SET AUTOCOMMIT ON|OFF, must specify a {@link
   * ClientSideSetStatementImpl} that defines how the value is set.
   */
  static class ClientSideSetStatementImpl {
    /** The property name that is to be set, e.g. AUTOCOMMIT. */
    private String propertyName;
    /** The separator between the property and the value (i.e. '=' or '\s+'). */
    private String separator;
    /** Regex specifying the range of allowed values for the property. */
    private String allowedValues;
    /** The class name of the {@link ClientSideStatementValueConverter} to use. */
    private String converterName;

    String getPropertyName() {
      return propertyName;
    }

    String getSeparator() {
      return separator;
    }

    String getAllowedValues() {
      return allowedValues;
    }

    String getConverterName() {
      return converterName;
    }
  }

  static class CompileException extends Exception {
    private static final long serialVersionUID = 1L;
    private final ClientSideStatementImpl statement;

    CompileException(Throwable cause, ClientSideStatementImpl statement) {
      super(cause);
      this.statement = statement;
    }

    @Override
    public String getMessage() {
      return "Could not compile statement " + this.statement.name;
    }
  }

  static class ExecuteException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final ClientSideStatementImpl statement;
    private final String sql;

    private ExecuteException(Throwable cause, ClientSideStatementImpl statement, String sql) {
      super(cause);
      this.statement = statement;
      this.sql = sql;
    }

    @Override
    public String getMessage() {
      return "Could not execute statement " + this.statement.name + " (" + sql + ")";
    }
  }

  /** The name of this statement. Used in error and info messages. */
  private String name;

  /**
   * The class name of the {@link ClientSideStatementExecutor} that should be used for this
   * statement.
   */
  private String executorName;

  /** The result type of this statement. */
  private ResultType resultType;

  /** The regular expression that should be used to recognize this class of statements. */
  private String regex;

  /**
   * The method name of the {@link ConnectionStatementExecutor} that should be called when this
   * statement is executed, for example 'statementSetAutocommit'.
   */
  private String method;

  /** A list of example statements that is used for testing. */
  private List<String> exampleStatements;

  /**
   * A list of statements that need to be executed before the example statements may be executed.
   */
  private List<String> examplePrerequisiteStatements;

  /**
   * If this statement sets a value, the statement definition should also contain a {@link
   * ClientSideSetStatementImpl} definition that defines how the value that is to be set should be
   * parsed.
   */
  private ClientSideSetStatementImpl setStatement;

  /** The compiled regex pattern for recognizing this statement. */
  private Pattern pattern;

  /** A reference to the executor that should be used. */
  private ClientSideStatementExecutor executor;

  /**
   * Compiles this {@link ClientSideStatementImpl}. Throws a {@link CompileException} if the
   * compilation fails. This should never happen, and if it does, it is a sign of a invalid
   * statement definition in the ClientSideStatements.json file.
   */
  ClientSideStatementImpl compile() throws CompileException {
    try {
      this.pattern = Pattern.compile(regex);
      this.executor =
          (ClientSideStatementExecutor)
              Class.forName(getClass().getPackage().getName() + "." + executorName).newInstance();
      this.executor.compile(this);
      return this;
    } catch (Exception e) {
      throw new CompileException(e, this);
    }
  }

  @Override
  public StatementResult execute(ConnectionStatementExecutor connection, String statement) {
    Preconditions.checkState(executor != null, "This statement has not been compiled");
    try {
      return executor.execute(connection, statement);
    } catch (SpannerException e) {
      throw e;
    } catch (InvocationTargetException e) {
      if (e.getCause() instanceof SpannerException) {
        throw (SpannerException) e.getCause();
      }
      throw new ExecuteException(e.getCause(), this, statement);
    } catch (Exception e) {
      throw new ExecuteException(e, this, statement);
    }
  }

  @Override
  public boolean isQuery() {
    return resultType == ResultType.RESULT_SET;
  }

  @Override
  public boolean isUpdate() {
    return resultType == ResultType.UPDATE_COUNT;
  }

  boolean matches(String statement) {
    Preconditions.checkState(pattern != null, "This statement has not been compiled");
    return pattern.matcher(statement).matches();
  }

  @Override
  public String toString() {
    return name;
  }

  Pattern getPattern() {
    return pattern;
  }

  String getMethodName() {
    return method;
  }

  @Override
  public List<String> getExampleStatements() {
    return Collections.unmodifiableList(exampleStatements);
  }

  @Override
  public List<String> getExamplePrerequisiteStatements() {
    if (examplePrerequisiteStatements == null) {
      return Collections.emptyList();
    }
    return Collections.unmodifiableList(examplePrerequisiteStatements);
  }

  ClientSideSetStatementImpl getSetStatement() {
    return setStatement;
  }
}
