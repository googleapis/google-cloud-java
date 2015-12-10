/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud;

/**
 * A base interface for all service factories.
 *
 * Implementation must provide a public no-arg constructor.
 * Loading of a factory implementation is done via {@link java.util.ServiceLoader}.
 */
@SuppressWarnings("rawtypes")
public interface ServiceFactory<ServiceT extends Service, ServiceOptionsT extends ServiceOptions> {

  ServiceT create(ServiceOptionsT serviceOptions);
}
