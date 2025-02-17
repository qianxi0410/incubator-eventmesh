/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.eventmesh.runtime.core.protocol.tcp.client.session;

import org.apache.eventmesh.common.protocol.SubscriptionItem;
import org.apache.eventmesh.runtime.constants.EventMeshConstants;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.concurrent.ConcurrentHashMap;

public class SessionContext {

    private Session session;

    public ConcurrentHashMap<String, String> sendTopics = new ConcurrentHashMap<String, String>();

    public ConcurrentHashMap<String, SubscriptionItem> subscribeTopics = new ConcurrentHashMap<String, SubscriptionItem>();

    public long createTime = System.currentTimeMillis();

    public SessionContext(Session session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "SessionContext{subscribeTopics=" + subscribeTopics
            + ",sendTopics=" + sendTopics.keySet()
            + ",createTime=" + DateFormatUtils.format(createTime, EventMeshConstants.DATE_FORMAT) + "}";
    }
}
