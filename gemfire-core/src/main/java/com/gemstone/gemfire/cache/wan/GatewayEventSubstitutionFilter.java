/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gemstone.gemfire.cache.wan;

import com.gemstone.gemfire.cache.CacheCallback;
import com.gemstone.gemfire.cache.EntryEvent;

/**
 * Interface <code>GatewayEventSubstitutionFilter</code> provides a way to
 * specify a substitute value to be stored in the <code>GatewayQueueEvent</code>
 * and enqueued in the <code>RegionQueue</code>.
 */
public interface GatewayEventSubstitutionFilter<K,V> extends CacheCallback {

  /**
   * Return the substitute value to be stored in the
   * <code>GatewayQueueEvent</code> and enqueued in the <code>RegionQueue</code>
   * 
   * @param event
   *          The originating <code>EntryEvent</code>
   * @return the substitute value to be stored in the
   *         <code>GatewayQueueEvent</code> and enqueued in the
   *         <code>RegionQueue</code>
   */
  public Object getSubstituteValue(EntryEvent<K,V> event);
}
