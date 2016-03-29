/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

/**
 * A testing helper for Google Cloud DNS.
 *
 * <p>A simple usage example:
 * Before the test:
 * <pre> {@code
 * // Minimum delay before processing change requests (in ms). Setting the delay to 0 makes change
 * // request processing synchronous.
 * long delay = 0;
 * LocalDnsHelper dnsHelper = LocalDnsHelper.create(delay);
 * Dns dns = dnsHelper.options().service();
 * dnsHelper.start();
 * }</pre>
 *
 * <p>After the test:
 * <pre> {@code
 * dnsHelper.stop();
 * }</pre>
 */
package com.google.gcloud.dns.testing;
