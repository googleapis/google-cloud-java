/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.storage;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Presigned V4 post policy. Instances of {@code PostPolicyV4} include a URL and a map of fields
 * that can be specified in an HTML form to submit a POST request to upload an object.
 *
 * <p>See <a href="https://cloud.google.com/storage/docs/xml-api/post-object">POST Object</a> for
 * details of upload by using HTML forms.
 *
 * <p>See {@link Storage#generateSignedPostPolicyV4(BlobInfo, long, TimeUnit,
 * PostPolicyV4.PostFieldsV4, PostPolicyV4.PostConditionsV4, Storage.PostPolicyV4Option...)} for
 * example of usage.
 */
public final class PostPolicyV4 {
  private final String url;
  private final Map<String, String> fields;

  private PostPolicyV4(String url, Map<String, String> fields) {
    try {
      if (!new URI(url).isAbsolute()) {
        throw new IllegalArgumentException(url + " is not an absolute URL");
      }
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException(e);
    }

    this.url = url;
    this.fields = Collections.unmodifiableMap(fields);
  }

  /**
   * Constructs {@code PostPolicyV4} instance of the given URL and fields map.
   *
   * @param url URL for the HTTP POST request
   * @param fields HTML form fields
   * @return constructed object
   * @throws IllegalArgumentException if URL is malformed or fields are not valid
   */
  public static PostPolicyV4 of(String url, Map<String, String> fields) {
    return new PostPolicyV4(url, fields);
  }

  /** Returns the URL for the HTTP POST request */
  public String getUrl() {
    return url;
  }

  /** Returns the HTML form fields */
  public Map<String, String> getFields() {
    return fields;
  }

  /**
   * A helper class to define fields to be specified in a V4 POST request. Instance of this class
   * helps to construct {@code PostPolicyV4} objects. Used in: {@link
   * Storage#generateSignedPostPolicyV4(BlobInfo, long, TimeUnit, PostPolicyV4.PostFieldsV4,
   * PostPolicyV4.PostConditionsV4, Storage.PostPolicyV4Option...)}.
   *
   * @see <a href="https://cloud.google.com/storage/docs/xml-api/post-object#form_fields">POST
   *     Object Form fields</a>
   */
  public static final class PostFieldsV4 {
    private final Map<String, String> fieldsMap;

    private PostFieldsV4(Builder builder) {
      this(builder.fieldsMap);
    }

    private PostFieldsV4(Map<String, String> fields) {
      this.fieldsMap = Collections.unmodifiableMap(fields);
    }

    /**
     * Constructs {@code PostPolicyV4.PostFieldsV4} object of the given field map.
     *
     * @param fields a map of the HTML form fields
     * @return constructed object
     * @throws IllegalArgumentException if an unsupported field is specified
     */
    public static PostFieldsV4 of(Map<String, String> fields) {
      return new PostFieldsV4(fields);
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public Map<String, String> getFieldsMap() {
      return fieldsMap;
    }

    public static class Builder {
      private static final String CUSTOM_FIELD_PREFIX = "x-goog-meta-";
      private final Map<String, String> fieldsMap;

      private Builder() {
        this.fieldsMap = new HashMap<>();
      }

      public PostFieldsV4 build() {
        return new PostFieldsV4(this);
      }

      public Builder setAcl(String acl) {
        fieldsMap.put("acl", acl);
        return this;
      }

      public Builder setCacheControl(String cacheControl) {
        fieldsMap.put("cache-control", cacheControl);
        return this;
      }

      public Builder setContentDisposition(String contentDisposition) {
        fieldsMap.put("content-disposition", contentDisposition);
        return this;
      }

      public Builder setContentEncoding(String contentEncoding) {
        fieldsMap.put("content-encoding", contentEncoding);
        return this;
      }

      /**
       * @deprecated Invocation of this method has no effect, because all valid HTML form fields
       *     except Content-Length can use exact matching. Use {@link
       *     PostPolicyV4.PostConditionsV4.Builder#addContentLengthRangeCondition(int, int)} to
       *     specify a range for the content-length.
       */
      @Deprecated
      public Builder setContentLength(int contentLength) {
        return this;
      }

      public Builder setContentType(String contentType) {
        fieldsMap.put("content-type", contentType);
        return this;
      }

      /**
       * @deprecated Use {@link #setExpires(String)}.
       */
      @Deprecated
      public Builder Expires(String expires) {
        return setExpires(expires);
      }

      public Builder setExpires(String expires) {
        fieldsMap.put("expires", expires);
        return this;
      }

      public Builder setSuccessActionRedirect(String successActionRedirect) {
        fieldsMap.put("success_action_redirect", successActionRedirect);
        return this;
      }

      public Builder setSuccessActionStatus(int successActionStatus) {
        fieldsMap.put("success_action_status", "" + successActionStatus);
        return this;
      }

      /**
       * @deprecated Use {@link #setCustomMetadataField(String, String)}.
       */
      @Deprecated
      public Builder AddCustomMetadataField(String field, String value) {
        return setCustomMetadataField(field, value);
      }

      public Builder setCustomMetadataField(String field, String value) {
        if (!field.startsWith(CUSTOM_FIELD_PREFIX)) {
          field = CUSTOM_FIELD_PREFIX + field;
        }
        fieldsMap.put(field, value);
        return this;
      }
    }
  }

  /**
   * A helper class for specifying conditions in a V4 POST Policy document. Used in: {@link
   * Storage#generateSignedPostPolicyV4(BlobInfo, long, TimeUnit, PostPolicyV4.PostFieldsV4,
   * PostPolicyV4.PostConditionsV4, Storage.PostPolicyV4Option...)}.
   *
   * @see <a href="https://cloud.google.com/storage/docs/authentication/signatures#policy-document">
   *     Policy document</a>
   */
  public static final class PostConditionsV4 {
    private Set<ConditionV4> conditions;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public PostConditionsV4(Builder builder) {
      this.conditions = builder.conditions;
    }

    public Builder toBuilder() {
      return new Builder(conditions);
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public Set<ConditionV4> getConditions() {
      return Collections.unmodifiableSet(conditions);
    }

    public static class Builder {
      private final Set<ConditionV4> conditions;

      private Builder() {
        this(new LinkedHashSet<ConditionV4>());
      }

      private Builder(Set<ConditionV4> conditions) {
        this.conditions = conditions;
      }

      public static Builder newBuilder() {
        return new Builder();
      }

      public PostConditionsV4 build() {
        return new PostConditionsV4(this);
      }

      public Builder addAclCondition(ConditionV4Type type, String acl) {
        checkType(type, "acl");
        conditions.add(new ConditionV4(type, "acl", acl));
        return this;
      }

      public Builder addBucketCondition(ConditionV4Type type, String bucket) {
        checkType(type, "bucket");
        conditions.add(new ConditionV4(type, "bucket", bucket));
        return this;
      }

      public Builder addCacheControlCondition(ConditionV4Type type, String cacheControl) {
        checkType(type, "cache-control");
        conditions.add(new ConditionV4(type, "cache-control", cacheControl));
        return this;
      }

      public Builder addContentDispositionCondition(
          ConditionV4Type type, String contentDisposition) {
        checkType(type, "content-disposition");
        conditions.add(new ConditionV4(type, "content-disposition", contentDisposition));
        return this;
      }

      public Builder addContentEncodingCondition(ConditionV4Type type, String contentEncoding) {
        checkType(type, "content-encoding");
        conditions.add(new ConditionV4(type, "content-encoding", contentEncoding));
        return this;
      }

      /**
       * @deprecated Invocation of this method has no effect. Use {@link
       *     #addContentLengthRangeCondition(int, int)} to specify a range for the content-length.
       */
      public Builder addContentLengthCondition(ConditionV4Type type, int contentLength) {
        return this;
      }

      public Builder addContentTypeCondition(ConditionV4Type type, String contentType) {
        checkType(type, "content-type");
        conditions.add(new ConditionV4(type, "content-type", contentType));
        return this;
      }

      /**
       * @deprecated Use {@link #addExpiresCondition(long)}
       */
      @Deprecated
      public Builder addExpiresCondition(ConditionV4Type type, long expires) {
        return addExpiresCondition(expires);
      }

      /**
       * @deprecated Use {@link #addExpiresCondition(String)}
       */
      @Deprecated
      public Builder addExpiresCondition(ConditionV4Type type, String expires) {
        return addExpiresCondition(expires);
      }

      public Builder addExpiresCondition(long expires) {
        return addExpiresCondition(dateFormat.format(expires));
      }

      public Builder addExpiresCondition(String expires) {
        conditions.add(new ConditionV4(ConditionV4Type.MATCHES, "expires", expires));
        return this;
      }

      public Builder addKeyCondition(ConditionV4Type type, String key) {
        checkType(type, "key");
        conditions.add(new ConditionV4(type, "key", key));
        return this;
      }

      public Builder addSuccessActionRedirectUrlCondition(
          ConditionV4Type type, String successActionRedirectUrl) {
        checkType(type, "success_action_redirect");
        conditions.add(new ConditionV4(type, "success_action_redirect", successActionRedirectUrl));
        return this;
      }

      /**
       * @deprecated Use {@link #addSuccessActionStatusCondition(int)}
       */
      @Deprecated
      public Builder addSuccessActionStatusCondition(ConditionV4Type type, int status) {
        return addSuccessActionStatusCondition(status);
      }

      public Builder addSuccessActionStatusCondition(int status) {
        conditions.add(
            new ConditionV4(ConditionV4Type.MATCHES, "success_action_status", "" + status));
        return this;
      }

      public Builder addContentLengthRangeCondition(int min, int max) {
        conditions.add(new ConditionV4(ConditionV4Type.CONTENT_LENGTH_RANGE, "" + min, "" + max));
        return this;
      }

      Builder addCustomCondition(ConditionV4Type type, String field, String value) {
        conditions.add(new ConditionV4(type, field, value));
        return this;
      }

      private void checkType(ConditionV4Type type, String field) {
        if (type != ConditionV4Type.MATCHES && type != ConditionV4Type.STARTS_WITH) {
          throw new IllegalArgumentException("Field " + field + " can't use " + type);
        }
      }
    }
  }

  /**
   * Class for a V4 POST Policy document. Used by Storage to construct {@code PostPolicyV4} objects.
   *
   * @see <a href="https://cloud.google.com/storage/docs/authentication/signatures#policy-document">
   *     Policy document</a>
   */
  public static final class PostPolicyV4Document {
    private final String expiration;
    private final PostConditionsV4 conditions;

    private PostPolicyV4Document(String expiration, PostConditionsV4 conditions) {
      this.expiration = expiration;
      this.conditions = conditions;
    }

    public static PostPolicyV4Document of(String expiration, PostConditionsV4 conditions) {
      return new PostPolicyV4Document(expiration, conditions);
    }

    public String toJson() {
      JsonObject object = new JsonObject();
      JsonArray conditions = new JsonArray();
      for (ConditionV4 condition : this.conditions.conditions) {
        switch (condition.type) {
          case MATCHES:
            JsonObject match = new JsonObject();
            match.addProperty(condition.operand1, condition.operand2);
            conditions.add(match);
            break;
          case STARTS_WITH:
            JsonArray startsWith = new JsonArray();
            startsWith.add("starts-with");
            startsWith.add("$" + condition.operand1);
            startsWith.add(condition.operand2);
            conditions.add(startsWith);
            break;
          case CONTENT_LENGTH_RANGE:
            JsonArray contentLengthRange = new JsonArray();
            contentLengthRange.add("content-length-range");
            contentLengthRange.add(Integer.parseInt(condition.operand1));
            contentLengthRange.add(Integer.parseInt(condition.operand2));
            conditions.add(contentLengthRange);
            break;
        }
      }
      object.add("conditions", conditions);
      object.addProperty("expiration", expiration);

      String json = object.toString();
      StringBuilder escapedJson = new StringBuilder();

      // Certain characters in a policy must be escaped
      char[] jsonArray = json.toCharArray();
      for (int i = 0; i < jsonArray.length; i++) {
        char c = jsonArray[i];
        if (c >= 128) { // is a unicode character
          escapedJson.append(String.format(Locale.US, "\\u%04x", (int) c));
        } else {
          switch (c) {
            case '\\':
              // The JsonObject/JsonArray operations above handle quote escapes, so leave any "\""
              // found alone
              if (jsonArray[i + 1] == '"') {
                escapedJson.append("\\");
              } else {
                escapedJson.append("\\\\");
              }
              break;
            case '\b':
              escapedJson.append("\\b");
              break;
            case '\f':
              escapedJson.append("\\f");
              break;
            case '\n':
              escapedJson.append("\\n");
              break;
            case '\r':
              escapedJson.append("\\r");
              break;
            case '\t':
              escapedJson.append("\\t");
              break;
            case '\u000b':
              escapedJson.append("\\v");
              break;
            default:
              escapedJson.append(c);
          }
        }
      }
      return escapedJson.toString();
    }
  }

  public enum ConditionV4Type {
    MATCHES("eq"),
    STARTS_WITH("starts-with"),
    CONTENT_LENGTH_RANGE("content-length-range");

    private final String name;

    ConditionV4Type(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return name;
    }
  }

  /**
   * Class for a specific POST policy document condition.
   *
   * @see <a href="https://cloud.google.com/storage/docs/authentication/signatures#policy-document">
   *     Policy document</a>
   */
  public static final class ConditionV4 {
    public final ConditionV4Type type;
    public final String operand1;
    public final String operand2;

    ConditionV4(ConditionV4Type type, String operand1, String operand2) {
      this.type = type;
      this.operand1 = operand1;
      this.operand2 = operand2;
    }

    @Override
    public boolean equals(Object other) {
      ConditionV4 condition = (ConditionV4) other;
      return this.type == condition.type
          && this.operand1.equals(condition.operand1)
          && this.operand2.equals(condition.operand2);
    }

    @Override
    public int hashCode() {
      return Objects.hash(type, operand1, operand2);
    }

    /**
     * Examples of returned strings: {@code ["eq", "$key", "test-object"]}, {@code ["starts-with",
     * "$acl", "public"]}, {@code ["content-length-range", 246, 266]}.
     */
    @Override
    public String toString() {
      String body =
          type == ConditionV4Type.CONTENT_LENGTH_RANGE
              ? operand1 + ", " + operand2
              : "\"$" + operand1 + "\", \"" + operand2 + "\"";
      return "[\"" + type + "\", " + body + "]";
    }
  }
}
