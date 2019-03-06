/*
 * Copyright 2015 Google LLC
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

/**
 * A base interface for all service factories.
 *
 * <p>Implementation must provide a public no-arg constructor. Loading of a factory implementation
 * is done via {@link java.util.ServiceLoader}.
 *
 * @param <ServiceT> the service subclass
 * @param <ServiceOptionsT> the {@code ServiceOptions} subclass corresponding to the service
 */
@SuppressWarnings("rawtypes")
public interface ServiceFactory<ServiceT extends Service, ServiceOptionsT extends ServiceOptions> {

  ServiceT create(ServiceOptionsT serviceOptions);
}
