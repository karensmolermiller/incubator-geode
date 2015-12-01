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
package com.gemstone.gemfire.distributed.internal.direct;

import com.gemstone.gemfire.GemFireCheckedException;

/**
 * Exception thrown when the TCPConduit is unable to acquire a stub
 * for the given recipient.
 * 
 * @author jpenney
 *
 */
public class MissingStubException extends GemFireCheckedException
{

  private static final long serialVersionUID = -6455664684151074915L;

  public MissingStubException(String msg) {
    super(msg);
  }
  
}
