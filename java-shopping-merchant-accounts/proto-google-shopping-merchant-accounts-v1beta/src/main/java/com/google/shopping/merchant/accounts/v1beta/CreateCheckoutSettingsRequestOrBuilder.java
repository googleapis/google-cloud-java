/*
 * Copyright 2025 Google LLC
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
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/shopping/merchant/accounts/v1beta/checkoutsettings.proto

// Protobuf Java Version: 3.25.8
package com.google.shopping.merchant.accounts.v1beta;

public interface CreateCheckoutSettingsRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.shopping.merchant.accounts.v1beta.CreateCheckoutSettingsRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. The merchant account for which the `CheckoutSettings` will be
   * created.
   * </pre>
   *
   * <code>
   * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The parent.
   */
  java.lang.String getParent();

  /**
   *
   *
   * <pre>
   * Required. The merchant account for which the `CheckoutSettings` will be
   * created.
   * </pre>
   *
   * <code>
   * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The bytes for parent.
   */
  com.google.protobuf.ByteString getParentBytes();

  /**
   *
   *
   * <pre>
   * Required. The `CheckoutSettings` object to create.
   * </pre>
   *
   * <code>
   * .google.shopping.merchant.accounts.v1beta.CheckoutSettings checkout_settings = 2 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   *
   * @return Whether the checkoutSettings field is set.
   */
  boolean hasCheckoutSettings();

  /**
   *
   *
   * <pre>
   * Required. The `CheckoutSettings` object to create.
   * </pre>
   *
   * <code>
   * .google.shopping.merchant.accounts.v1beta.CheckoutSettings checkout_settings = 2 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   *
   * @return The checkoutSettings.
   */
  com.google.shopping.merchant.accounts.v1beta.CheckoutSettings getCheckoutSettings();

  /**
   *
   *
   * <pre>
   * Required. The `CheckoutSettings` object to create.
   * </pre>
   *
   * <code>
   * .google.shopping.merchant.accounts.v1beta.CheckoutSettings checkout_settings = 2 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  com.google.shopping.merchant.accounts.v1beta.CheckoutSettingsOrBuilder
      getCheckoutSettingsOrBuilder();
}
