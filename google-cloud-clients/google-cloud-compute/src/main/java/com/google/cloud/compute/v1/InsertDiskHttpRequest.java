/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * Request object for method compute.disks.insert. Creates a persistent disk in the specified
 * project using the data in the request. You can create a disk with a sourceImage, a
 * sourceSnapshot, or create an empty 500 GB data disk by omitting all properties. You can also
 * create a disk that is larger than the default size by specifying the sizeGb property.
 */
public final class InsertDiskHttpRequest implements ApiMessage {
  private final String access_token;
  private final String callback;
  private final Disk diskResource;
  private final String fields;
  private final String key;
  private final String prettyPrint;
  private final String quotaUser;
  private final String requestId;
  private final String sourceImage;
  private final String userIp;
  private final String zone;

  private InsertDiskHttpRequest() {
    this.access_token = null;
    this.callback = null;
    this.diskResource = null;
    this.fields = null;
    this.key = null;
    this.prettyPrint = null;
    this.quotaUser = null;
    this.requestId = null;
    this.sourceImage = null;
    this.userIp = null;
    this.zone = null;
  }

  private InsertDiskHttpRequest(
      String access_token,
      String callback,
      Disk diskResource,
      String fields,
      String key,
      String prettyPrint,
      String quotaUser,
      String requestId,
      String sourceImage,
      String userIp,
      String zone) {
    this.access_token = access_token;
    this.callback = callback;
    this.diskResource = diskResource;
    this.fields = fields;
    this.key = key;
    this.prettyPrint = prettyPrint;
    this.quotaUser = quotaUser;
    this.requestId = requestId;
    this.sourceImage = sourceImage;
    this.userIp = userIp;
    this.zone = zone;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("access_token".equals(fieldName)) {
      return access_token;
    }
    if ("callback".equals(fieldName)) {
      return callback;
    }
    if ("diskResource".equals(fieldName)) {
      return diskResource;
    }
    if ("fields".equals(fieldName)) {
      return fields;
    }
    if ("key".equals(fieldName)) {
      return key;
    }
    if ("prettyPrint".equals(fieldName)) {
      return prettyPrint;
    }
    if ("quotaUser".equals(fieldName)) {
      return quotaUser;
    }
    if ("requestId".equals(fieldName)) {
      return requestId;
    }
    if ("sourceImage".equals(fieldName)) {
      return sourceImage;
    }
    if ("userIp".equals(fieldName)) {
      return userIp;
    }
    if ("zone".equals(fieldName)) {
      return zone;
    }
    return null;
  }

  @Nullable
  @Override
  public Disk getApiMessageRequestBody() {
    return diskResource;
  }

  @Nullable
  @Override
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** OAuth 2.0 token for the current user. */
  public String getAccessToken() {
    return access_token;
  }

  /** Name of the JavaScript callback function that handles the response. */
  public String getCallback() {
    return callback;
  }

  /**
   * Represents a Persistent Disk resource.
   *
   * <p>Persistent disks are required for running your VM instances. Create both boot and non-boot
   * (data) persistent disks. For more information, read Persistent Disks. For more storage options,
   * read Storage options.
   *
   * <p>The disks resource represents a zonal persistent disk. For more information, read Zonal
   * persistent disks.
   *
   * <p>The regionDisks resource represents a regional persistent disk. For more information, read
   * Regional resources. (== resource_for beta.disks ==) (== resource_for v1.disks ==) (==
   * resource_for v1.regionDisks ==) (== resource_for beta.regionDisks ==)
   */
  public Disk getDiskResource() {
    return diskResource;
  }

  /** Selector specifying a subset of fields to include in the response. */
  public String getFields() {
    return fields;
  }

  /** API key. Required unless you provide an OAuth 2.0 token. */
  public String getKey() {
    return key;
  }

  /** Returns response with indentations and line breaks. */
  public String getPrettyPrint() {
    return prettyPrint;
  }

  /** Alternative to userIp. */
  public String getQuotaUser() {
    return quotaUser;
  }

  /**
   * An optional request ID to identify requests. Specify a unique request ID so that if you must
   * retry your request, the server will know to ignore the request if it has already been
   * completed.
   *
   * <p>For example, consider a situation where you make an initial request and the request times
   * out. If you make the request again with the same request ID, the server can check if original
   * operation with the same request ID was received, and if so, will ignore the second request.
   * This prevents clients from accidentally creating duplicate commitments.
   *
   * <p>The request ID must be a valid UUID with the exception that zero UUID is not supported
   * (00000000-0000-0000-0000-000000000000).
   */
  public String getRequestId() {
    return requestId;
  }

  /** Optional. Source image to restore onto a disk. */
  public String getSourceImage() {
    return sourceImage;
  }

  /** IP address of the end user for whom the API call is being made. */
  public String getUserIp() {
    return userIp;
  }

  /**
   * The name of the zone for this request. It must have the format `{project}/zones/{zone}/disks`.
   * \`{zone}\` must start with a letter, and contain only letters (\`[A-Za-z]\`), numbers
   * (\`[0-9]\`), dashes (\`-\`), &#42; underscores (\`_\`), periods (\`.\`), tildes (\`~\`), plus
   * (\`+\`) or percent &#42; signs (\`%\`). It must be between 3 and 255 characters in length, and
   * it &#42; must not start with \`"goog"\`.
   */
  public String getZone() {
    return zone;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InsertDiskHttpRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InsertDiskHttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InsertDiskHttpRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InsertDiskHttpRequest();
  }

  public static class Builder {
    private String access_token;
    private String callback;
    private Disk diskResource;
    private String fields;
    private String key;
    private String prettyPrint;
    private String quotaUser;
    private String requestId;
    private String sourceImage;
    private String userIp;
    private String zone;

    Builder() {}

    public Builder mergeFrom(InsertDiskHttpRequest other) {
      if (other == InsertDiskHttpRequest.getDefaultInstance()) return this;
      if (other.getAccessToken() != null) {
        this.access_token = other.access_token;
      }
      if (other.getCallback() != null) {
        this.callback = other.callback;
      }
      if (other.getDiskResource() != null) {
        this.diskResource = other.diskResource;
      }
      if (other.getFields() != null) {
        this.fields = other.fields;
      }
      if (other.getKey() != null) {
        this.key = other.key;
      }
      if (other.getPrettyPrint() != null) {
        this.prettyPrint = other.prettyPrint;
      }
      if (other.getQuotaUser() != null) {
        this.quotaUser = other.quotaUser;
      }
      if (other.getRequestId() != null) {
        this.requestId = other.requestId;
      }
      if (other.getSourceImage() != null) {
        this.sourceImage = other.sourceImage;
      }
      if (other.getUserIp() != null) {
        this.userIp = other.userIp;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(InsertDiskHttpRequest source) {
      this.access_token = source.access_token;
      this.callback = source.callback;
      this.diskResource = source.diskResource;
      this.fields = source.fields;
      this.key = source.key;
      this.prettyPrint = source.prettyPrint;
      this.quotaUser = source.quotaUser;
      this.requestId = source.requestId;
      this.sourceImage = source.sourceImage;
      this.userIp = source.userIp;
      this.zone = source.zone;
    }

    /** OAuth 2.0 token for the current user. */
    public String getAccessToken() {
      return access_token;
    }

    /** OAuth 2.0 token for the current user. */
    public Builder setAccessToken(String access_token) {
      this.access_token = access_token;
      return this;
    }

    /** Name of the JavaScript callback function that handles the response. */
    public String getCallback() {
      return callback;
    }

    /** Name of the JavaScript callback function that handles the response. */
    public Builder setCallback(String callback) {
      this.callback = callback;
      return this;
    }

    /**
     * Represents a Persistent Disk resource.
     *
     * <p>Persistent disks are required for running your VM instances. Create both boot and non-boot
     * (data) persistent disks. For more information, read Persistent Disks. For more storage
     * options, read Storage options.
     *
     * <p>The disks resource represents a zonal persistent disk. For more information, read Zonal
     * persistent disks.
     *
     * <p>The regionDisks resource represents a regional persistent disk. For more information, read
     * Regional resources. (== resource_for beta.disks ==) (== resource_for v1.disks ==) (==
     * resource_for v1.regionDisks ==) (== resource_for beta.regionDisks ==)
     */
    public Disk getDiskResource() {
      return diskResource;
    }

    /**
     * Represents a Persistent Disk resource.
     *
     * <p>Persistent disks are required for running your VM instances. Create both boot and non-boot
     * (data) persistent disks. For more information, read Persistent Disks. For more storage
     * options, read Storage options.
     *
     * <p>The disks resource represents a zonal persistent disk. For more information, read Zonal
     * persistent disks.
     *
     * <p>The regionDisks resource represents a regional persistent disk. For more information, read
     * Regional resources. (== resource_for beta.disks ==) (== resource_for v1.disks ==) (==
     * resource_for v1.regionDisks ==) (== resource_for beta.regionDisks ==)
     */
    public Builder setDiskResource(Disk diskResource) {
      this.diskResource = diskResource;
      return this;
    }

    /** Selector specifying a subset of fields to include in the response. */
    public String getFields() {
      return fields;
    }

    /** Selector specifying a subset of fields to include in the response. */
    public Builder setFields(String fields) {
      this.fields = fields;
      return this;
    }

    /** API key. Required unless you provide an OAuth 2.0 token. */
    public String getKey() {
      return key;
    }

    /** API key. Required unless you provide an OAuth 2.0 token. */
    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    /** Returns response with indentations and line breaks. */
    public String getPrettyPrint() {
      return prettyPrint;
    }

    /** Returns response with indentations and line breaks. */
    public Builder setPrettyPrint(String prettyPrint) {
      this.prettyPrint = prettyPrint;
      return this;
    }

    /** Alternative to userIp. */
    public String getQuotaUser() {
      return quotaUser;
    }

    /** Alternative to userIp. */
    public Builder setQuotaUser(String quotaUser) {
      this.quotaUser = quotaUser;
      return this;
    }

    /**
     * An optional request ID to identify requests. Specify a unique request ID so that if you must
     * retry your request, the server will know to ignore the request if it has already been
     * completed.
     *
     * <p>For example, consider a situation where you make an initial request and the request times
     * out. If you make the request again with the same request ID, the server can check if original
     * operation with the same request ID was received, and if so, will ignore the second request.
     * This prevents clients from accidentally creating duplicate commitments.
     *
     * <p>The request ID must be a valid UUID with the exception that zero UUID is not supported
     * (00000000-0000-0000-0000-000000000000).
     */
    public String getRequestId() {
      return requestId;
    }

    /**
     * An optional request ID to identify requests. Specify a unique request ID so that if you must
     * retry your request, the server will know to ignore the request if it has already been
     * completed.
     *
     * <p>For example, consider a situation where you make an initial request and the request times
     * out. If you make the request again with the same request ID, the server can check if original
     * operation with the same request ID was received, and if so, will ignore the second request.
     * This prevents clients from accidentally creating duplicate commitments.
     *
     * <p>The request ID must be a valid UUID with the exception that zero UUID is not supported
     * (00000000-0000-0000-0000-000000000000).
     */
    public Builder setRequestId(String requestId) {
      this.requestId = requestId;
      return this;
    }

    /** Optional. Source image to restore onto a disk. */
    public String getSourceImage() {
      return sourceImage;
    }

    /** Optional. Source image to restore onto a disk. */
    public Builder setSourceImage(String sourceImage) {
      this.sourceImage = sourceImage;
      return this;
    }

    /** IP address of the end user for whom the API call is being made. */
    public String getUserIp() {
      return userIp;
    }

    /** IP address of the end user for whom the API call is being made. */
    public Builder setUserIp(String userIp) {
      this.userIp = userIp;
      return this;
    }

    /**
     * The name of the zone for this request. It must have the format
     * `{project}/zones/{zone}/disks`. \`{zone}\` must start with a letter, and contain only letters
     * (\`[A-Za-z]\`), numbers (\`[0-9]\`), dashes (\`-\`), &#42; underscores (\`_\`), periods
     * (\`.\`), tildes (\`~\`), plus (\`+\`) or percent &#42; signs (\`%\`). It must be between 3
     * and 255 characters in length, and it &#42; must not start with \`"goog"\`.
     */
    public String getZone() {
      return zone;
    }

    /**
     * The name of the zone for this request. It must have the format
     * `{project}/zones/{zone}/disks`. \`{zone}\` must start with a letter, and contain only letters
     * (\`[A-Za-z]\`), numbers (\`[0-9]\`), dashes (\`-\`), &#42; underscores (\`_\`), periods
     * (\`.\`), tildes (\`~\`), plus (\`+\`) or percent &#42; signs (\`%\`). It must be between 3
     * and 255 characters in length, and it &#42; must not start with \`"goog"\`.
     */
    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public InsertDiskHttpRequest build() {
      String missing = "";

      if (zone == null) {
        missing += " zone";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new InsertDiskHttpRequest(
          access_token,
          callback,
          diskResource,
          fields,
          key,
          prettyPrint,
          quotaUser,
          requestId,
          sourceImage,
          userIp,
          zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAccessToken(this.access_token);
      newBuilder.setCallback(this.callback);
      newBuilder.setDiskResource(this.diskResource);
      newBuilder.setFields(this.fields);
      newBuilder.setKey(this.key);
      newBuilder.setPrettyPrint(this.prettyPrint);
      newBuilder.setQuotaUser(this.quotaUser);
      newBuilder.setRequestId(this.requestId);
      newBuilder.setSourceImage(this.sourceImage);
      newBuilder.setUserIp(this.userIp);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InsertDiskHttpRequest{"
        + "access_token="
        + access_token
        + ", "
        + "callback="
        + callback
        + ", "
        + "diskResource="
        + diskResource
        + ", "
        + "fields="
        + fields
        + ", "
        + "key="
        + key
        + ", "
        + "prettyPrint="
        + prettyPrint
        + ", "
        + "quotaUser="
        + quotaUser
        + ", "
        + "requestId="
        + requestId
        + ", "
        + "sourceImage="
        + sourceImage
        + ", "
        + "userIp="
        + userIp
        + ", "
        + "zone="
        + zone
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InsertDiskHttpRequest) {
      InsertDiskHttpRequest that = (InsertDiskHttpRequest) o;
      return Objects.equals(this.access_token, that.getAccessToken())
          && Objects.equals(this.callback, that.getCallback())
          && Objects.equals(this.diskResource, that.getDiskResource())
          && Objects.equals(this.fields, that.getFields())
          && Objects.equals(this.key, that.getKey())
          && Objects.equals(this.prettyPrint, that.getPrettyPrint())
          && Objects.equals(this.quotaUser, that.getQuotaUser())
          && Objects.equals(this.requestId, that.getRequestId())
          && Objects.equals(this.sourceImage, that.getSourceImage())
          && Objects.equals(this.userIp, that.getUserIp())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        access_token,
        callback,
        diskResource,
        fields,
        key,
        prettyPrint,
        quotaUser,
        requestId,
        sourceImage,
        userIp,
        zone);
  }
}
