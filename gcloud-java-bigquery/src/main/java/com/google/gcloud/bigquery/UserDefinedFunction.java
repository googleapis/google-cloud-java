package com.google.gcloud.bigquery;

import com.google.api.services.bigquery.model.UserDefinedFunctionResource;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Google BigQuery User Defined Function. BigQuery supports user-defined functions (UDFs) written in
 * JavaScript. A UDF is similar to the "Map" function in a MapReduce: it takes a single row as input
 * and produces zero or more rows as output. The output can potentially have a different schema than
 * the input.
 *
 * @see <a href="https://cloud.google.com/bigquery/user-defined-functions">User-Defined Functions</a>
 */
public abstract class UserDefinedFunction implements Serializable {

  static final Function<UserDefinedFunctionResource, UserDefinedFunction> FROM_PB_FUNCTION =
      new Function<UserDefinedFunctionResource, UserDefinedFunction>() {
        @Override
        public UserDefinedFunction apply(UserDefinedFunctionResource userDefinedFunctionPb) {
          return UserDefinedFunction.fromPb(userDefinedFunctionPb);
        }
      };
  static final Function<UserDefinedFunction, UserDefinedFunctionResource> TO_PB_FUNCTION =
      new Function<UserDefinedFunction, UserDefinedFunctionResource>() {
        @Override
        public UserDefinedFunctionResource apply(UserDefinedFunction userDefinedFunction) {
          return userDefinedFunction.toPb();
        }
      };

  private static final long serialVersionUID = 8704260561787440287L;

  /**
   * Type of user-defined function. User defined functions can be provided inline as code blobs
   * ({@link #INLINE}) or as a Google Cloud Storage URI ({@link #FROM_URI}).
   */
  public enum Type {
    INLINE,
    FROM_URI
  }

  private final Type type;
  private final String content;

  UserDefinedFunction(Type type, String content) {
    this.type = type;
    this.content = content;
  }

  public Type type() {
    return type;
  }

  /**
   * If {@link #type()} is {@link Type#INLINE} this method returns a code blob. If {@link #type()}
   * is {@link Type#FROM_URI} the method returns a Google Cloud Storage URI (e.g. gs://bucket/path).
   */
  public String content() {
    return content;
  }

  /**
   * A Google Cloud BigQuery user-defined function, as a code blob.
   */
  static final class InlineFunction extends UserDefinedFunction {

    private static final long serialVersionUID = 1083672109192091686L;

    InlineFunction(String inlineCode) {
      super(Type.INLINE, inlineCode);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("inlineCode", content()).toString();
    }

    @Override
    public com.google.api.services.bigquery.model.UserDefinedFunctionResource toPb() {
      return new com.google.api.services.bigquery.model.UserDefinedFunctionResource()
          .setInlineCode(content());
    }
  }

  /**
   * A Google Cloud BigQuery user-defined function, as an URI to Google Cloud Storage.
   */
  static final class UriFunction extends UserDefinedFunction {

    private static final long serialVersionUID = 4660331691852223839L;

    UriFunction(String functionUri) {
      super(Type.FROM_URI, functionUri);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("functionUri", content()).toString();
    }

    @Override
    public com.google.api.services.bigquery.model.UserDefinedFunctionResource toPb() {
      return new com.google.api.services.bigquery.model.UserDefinedFunctionResource()
          .setResourceUri(content());
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, content);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof UserDefinedFunction
        && Objects.equals(toPb(), ((UserDefinedFunction) obj).toPb());
  }

  public abstract com.google.api.services.bigquery.model.UserDefinedFunctionResource toPb();

  /**
   * Creates a Google Cloud BigQuery user-defined function given a code blob.
   */
  public static UserDefinedFunction inline(String functionDefinition) {
    return new InlineFunction(functionDefinition);
  }

  /**
   * Creates a Google Cloud BigQuery user-defined function given a Google Cloud Storage URI (e.g.
   * gs://bucket/path).
   */
  public static UserDefinedFunction fromUri(String functionDefinition) {
    return new UriFunction(functionDefinition);
  }

  public static UserDefinedFunction fromPb(
      com.google.api.services.bigquery.model.UserDefinedFunctionResource pb) {
    if (pb.getInlineCode() != null) {
      return new InlineFunction(pb.getInlineCode());
    }
    if (pb.getResourceUri() != null) {
      return new UriFunction(pb.getResourceUri());
    }
    throw new IllegalArgumentException("Invalid user-defined function");
  }
}
