/*
 * Copyright 2017 Google LLC
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

package com.google.cloud;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * A qualifier indicating what level of access and support can be expected of a particular Google
 * Cloud Platform feature. The "GeneralAvailability" qualifier is not provided since the vast
 * majority of features are in this category. Note that features may be in a later launch stage than
 * the client library annotation indicates.
 *
 * <p>See more at the <a href="https://cloud.google.com/terms/launch-stages">Launch Stages
 * Documentation</a>.
 */
public class GcpLaunchStage {

  /**
   * Early Access features are limited to a closed group of testers. To use these features, you must
   * sign up in advance and sign a Trusted Tester agreement (which includes confidentiality
   * provisions). These features may be unstable, changed in backward-incompatible ways, and are not
   * guaranteed to be released.
   */
  @Retention(RetentionPolicy.RUNTIME)
  public @interface EarlyAccess {}

  /**
   * Alpha is a limited availability test for releases before they are cleared for widespread use.
   * By Alpha, all significant design issues are resolved and we are in the process of verifying
   * functionality. Alpha customers need to apply for access, agree to applicable terms, and have
   * their projects whitelisted. Alpha releases don’t have to be feature complete, no SLAs are
   * provided, and there are no technical support obligations, but they will be far enough along
   * that customers can actually use them in test environments or for limited-use tests -- just like
   * they would in normal production cases.
   */
  @Retention(RetentionPolicy.RUNTIME)
  public @interface Alpha {}

  /**
   * Beta is the point at which we are ready to open a release for any customer to use. There are no
   * SLA or technical support obligations in a Beta release, and charges may be waived in some
   * cases. Products will be complete from a feature perspective, but may have some open outstanding
   * issues. Beta releases are suitable for limited production use cases.
   */
  @Retention(RetentionPolicy.RUNTIME)
  public @interface Beta {}

  /**
   * Deprecated features are scheduled to be shut down and removed. For more information, see the
   * “Deprecation Policy” section of our <a href="https://cloud.google.com/terms/">Terms of
   * Service</a> and the <a href="https://cloud.google.com/terms/deprecation">Google Cloud Platform
   * Subject to the Deprecation Policy</a> documentation.
   */
  @Retention(RetentionPolicy.RUNTIME)
  public @interface Deprecated {}

  private GcpLaunchStage() {
    // Intentionally left blank.
  }
}
