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
package com.gemstone.gemfire.cache.query.dunit;

import java.security.Principal;

import junit.framework.TestCase;

import com.gemstone.gemfire.LogWriter;
import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheClosedException;
import com.gemstone.gemfire.cache.operations.ExecuteCQOperationContext;
import com.gemstone.gemfire.cache.operations.OperationContext;
import com.gemstone.gemfire.distributed.DistributedMember;
import com.gemstone.gemfire.security.AccessControl;
import com.gemstone.gemfire.security.NotAuthorizedException;

public class CloseCacheAuthorization extends TestCase implements AccessControl {
  private DistributedMember remoteDistributedMember;
  private Cache cache;
  private LogWriter logger;

  public static AccessControl create() {
    return new CloseCacheAuthorization();
  }

  @Override
  public void close() {
  }

  @Override
  public void init(Principal principal, DistributedMember remoteMember,
      Cache cache) throws NotAuthorizedException {
    this.remoteDistributedMember = remoteMember;
    this.cache = cache;
    this.logger = cache.getSecurityLogger();
  }

  @Override
  public boolean authorizeOperation(String regionName, OperationContext context) {
    if (context instanceof ExecuteCQOperationContext) {
      cache.close();
      //return false;
      throw new CacheClosedException("cache is closed");
    }
    return true;
  }
}
