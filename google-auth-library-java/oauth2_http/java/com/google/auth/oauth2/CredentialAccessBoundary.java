/*
 * Copyright 2021 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.auth.oauth2;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.json.GenericJson;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Defines an upper bound of permissions available for a GCP credential via {@link
 * AccessBoundaryRule}s.
 *
 * <p>See <a href='https://cloud.google.com/iam/docs/downscoping-short-lived-credentials'>for more
 * information.</a>
 */
public final class CredentialAccessBoundary {

  private static final int RULES_SIZE_LIMIT = 10;

  private final List<AccessBoundaryRule> accessBoundaryRules;

  CredentialAccessBoundary(List<AccessBoundaryRule> accessBoundaryRules) {
    checkNotNull(accessBoundaryRules);
    checkArgument(
        !accessBoundaryRules.isEmpty(), "At least one access boundary rule must be provided.");
    checkArgument(
        accessBoundaryRules.size() < RULES_SIZE_LIMIT,
        String.format(
            "The provided list has more than %s access boundary rules.", RULES_SIZE_LIMIT));
    this.accessBoundaryRules = accessBoundaryRules;
  }

  /**
   * Internal method that returns the JSON string representation of the credential access boundary.
   */
  String toJson() {
    List<GenericJson> rules = new ArrayList<>();
    for (AccessBoundaryRule rule : accessBoundaryRules) {
      GenericJson ruleJson = new GenericJson();
      ruleJson.setFactory(OAuth2Utils.JSON_FACTORY);

      ruleJson.put("availableResource", rule.getAvailableResource());
      ruleJson.put("availablePermissions", rule.getAvailablePermissions());

      AccessBoundaryRule.AvailabilityCondition availabilityCondition =
          rule.getAvailabilityCondition();
      if (availabilityCondition != null) {
        GenericJson availabilityConditionJson = new GenericJson();
        availabilityConditionJson.setFactory(OAuth2Utils.JSON_FACTORY);

        availabilityConditionJson.put("expression", availabilityCondition.getExpression());
        if (availabilityCondition.getTitle() != null) {
          availabilityConditionJson.put("title", availabilityCondition.getTitle());
        }
        if (availabilityCondition.getDescription() != null) {
          availabilityConditionJson.put("description", availabilityCondition.getDescription());
        }

        ruleJson.put("availabilityCondition", availabilityConditionJson);
      }
      rules.add(ruleJson);
    }
    GenericJson accessBoundaryRulesJson = new GenericJson();
    accessBoundaryRulesJson.setFactory(OAuth2Utils.JSON_FACTORY);
    accessBoundaryRulesJson.put("accessBoundaryRules", rules);

    GenericJson json = new GenericJson();
    json.setFactory(OAuth2Utils.JSON_FACTORY);
    json.put("accessBoundary", accessBoundaryRulesJson);
    return json.toString();
  }

  public List<AccessBoundaryRule> getAccessBoundaryRules() {
    return accessBoundaryRules;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private List<AccessBoundaryRule> accessBoundaryRules;

    private Builder() {}

    /**
     * Sets the list of {@link AccessBoundaryRule}'s.
     *
     * <p>This list must not exceed 10 rules.
     *
     * @param rule the collection of rules to be set, should not be null
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setRules(List<AccessBoundaryRule> rule) {
      accessBoundaryRules = new ArrayList<>(checkNotNull(rule));
      return this;
    }

    @CanIgnoreReturnValue
    public CredentialAccessBoundary.Builder addRule(AccessBoundaryRule rule) {
      if (accessBoundaryRules == null) {
        accessBoundaryRules = new ArrayList<>();
      }
      accessBoundaryRules.add(checkNotNull(rule));
      return this;
    }

    public CredentialAccessBoundary build() {
      return new CredentialAccessBoundary(accessBoundaryRules);
    }
  }

  /**
   * Defines an upper bound of permissions on a particular resource.
   *
   * <p>The following snippet shows an AccessBoundaryRule that applies to the Cloud Storage bucket
   * bucket-one to set the upper bound of permissions to those defined by the
   * roles/storage.objectViewer role.
   *
   * <pre><code>
   * AccessBoundaryRule rule = AccessBoundaryRule.newBuilder()
   *   .setAvailableResource("//storage.googleapis.com/projects/_/buckets/bucket-one")
   *   .addAvailablePermission("inRole:roles/storage.objectViewer")
   *   .build();
   * </code></pre>
   */
  public static final class AccessBoundaryRule {

    private final String availableResource;
    private final List<String> availablePermissions;

    @Nullable private final AvailabilityCondition availabilityCondition;

    AccessBoundaryRule(
        String availableResource,
        List<String> availablePermissions,
        @Nullable AvailabilityCondition availabilityCondition) {
      this.availableResource = checkNotNull(availableResource);
      this.availablePermissions = new ArrayList<>(checkNotNull(availablePermissions));
      this.availabilityCondition = availabilityCondition;

      checkArgument(!availableResource.isEmpty(), "The provided availableResource is empty.");
      checkArgument(
          !availablePermissions.isEmpty(), "The list of provided availablePermissions is empty.");
      for (String permission : availablePermissions) {
        if (permission == null) {
          throw new IllegalArgumentException("One of the provided available permissions is null.");
        }
        if (permission.isEmpty()) {
          throw new IllegalArgumentException("One of the provided available permissions is empty.");
        }
      }
    }

    public String getAvailableResource() {
      return availableResource;
    }

    public List<String> getAvailablePermissions() {
      return availablePermissions;
    }

    @Nullable
    public AvailabilityCondition getAvailabilityCondition() {
      return availabilityCondition;
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public static class Builder {
      private String availableResource;
      private List<String> availablePermissions;

      @Nullable private AvailabilityCondition availabilityCondition;

      private Builder() {}

      /**
       * Sets the available resource, which is the full resource name of the GCP resource to allow
       * access to.
       *
       * <p>For example: "//storage.googleapis.com/projects/_/buckets/example".
       *
       * @param availableResource the resource name to set
       * @return this {@code Builder} object
       */
      @CanIgnoreReturnValue
      public Builder setAvailableResource(String availableResource) {
        this.availableResource = availableResource;
        return this;
      }

      /**
       * Sets the list of permissions that can be used on the resource. This should be a list of IAM
       * roles prefixed by inRole.
       *
       * <p>For example: {"inRole:roles/storage.objectViewer"}.
       *
       * @param availablePermissions the collection of permissions to set, should not be null
       * @return this {@code Builder} object
       */
      @CanIgnoreReturnValue
      public Builder setAvailablePermissions(List<String> availablePermissions) {
        this.availablePermissions = new ArrayList<>(checkNotNull(availablePermissions));
        return this;
      }

      /**
       * Adds a permission that can be used on the resource. This should be an IAM role prefixed by
       * inRole.
       *
       * <p>For example: "inRole:roles/storage.objectViewer".
       *
       * @param availablePermission a permission to add, should not be null
       * @return this {@code Builder} object
       */
      public Builder addAvailablePermission(String availablePermission) {
        if (availablePermissions == null) {
          availablePermissions = new ArrayList<>();
        }
        availablePermissions.add(availablePermission);
        return this;
      }

      /**
       * Sets the availability condition which is an IAM condition that defines constraints to apply
       * to the token expressed in CEL format.
       *
       * @param availabilityCondition the {@code AvailabilityCondition} to set
       * @return this {@code Builder} object
       */
      @CanIgnoreReturnValue
      public Builder setAvailabilityCondition(AvailabilityCondition availabilityCondition) {
        this.availabilityCondition = availabilityCondition;
        return this;
      }

      public AccessBoundaryRule build() {
        return new AccessBoundaryRule(
            availableResource, availablePermissions, availabilityCondition);
      }
    }

    /**
     * An optional condition that can be used as part of a {@link AccessBoundaryRule} to further
     * restrict permissions.
     *
     * <p>For example, you can define an AvailabilityCondition that applies to a set of Cloud
     * Storage objects whose names start with auth:
     *
     * <pre><code>
     * AvailabilityCondition availabilityCondition = AvailabilityCondition.newBuilder()
     *   .setExpression("resource.name.startsWith('projects/_/buckets/bucket-123/objects/auth')")
     *   .build();
     * </code></pre>
     */
    public static final class AvailabilityCondition {
      private final String expression;

      @Nullable private final String title;
      @Nullable private final String description;

      AvailabilityCondition(
          String expression, @Nullable String title, @Nullable String description) {
        this.expression = checkNotNull(expression);
        this.title = title;
        this.description = description;

        checkArgument(!expression.isEmpty(), "The provided expression is empty.");
      }

      public String getExpression() {
        return expression;
      }

      @Nullable
      public String getTitle() {
        return title;
      }

      @Nullable
      public String getDescription() {
        return description;
      }

      public static Builder newBuilder() {
        return new Builder();
      }

      public static final class Builder {
        private String expression;

        @Nullable private String title;
        @Nullable private String description;

        private Builder() {}

        /**
         * Sets the required expression which must be defined in Common Expression Language (CEL)
         * format.
         *
         * <p>This expression specifies the Cloud Storage object where permissions are available.
         * See <a href='https://cloud.google.com/iam/docs/conditions-overview#cel'>for more
         * information.</a>
         *
         * @param expression the expression to set
         * @return this {@code Builder} object
         */
        @CanIgnoreReturnValue
        public Builder setExpression(String expression) {
          this.expression = expression;
          return this;
        }

        /**
         * Sets the optional title that identifies the purpose of the condition.
         *
         * @param title the title to set
         * @return this {@code Builder} object
         */
        @CanIgnoreReturnValue
        public Builder setTitle(String title) {
          this.title = title;
          return this;
        }

        /**
         * Sets the description that details the purpose of the condition.
         *
         * @param description the description to set
         * @return this {@code Builder} object
         */
        @CanIgnoreReturnValue
        public Builder setDescription(String description) {
          this.description = description;
          return this;
        }

        public AvailabilityCondition build() {
          return new AvailabilityCondition(expression, title, description);
        }
      }
    }
  }
}
