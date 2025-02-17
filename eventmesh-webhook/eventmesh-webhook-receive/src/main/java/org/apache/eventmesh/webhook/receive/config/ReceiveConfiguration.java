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

package org.apache.eventmesh.webhook.receive.config;

import org.apache.eventmesh.common.config.Config;
import org.apache.eventmesh.common.config.ConfigFiled;

import java.util.Properties;

import lombok.Data;

@Data
@Config(prefix = "eventMesh.webHook")
public class ReceiveConfiguration {

    @ConfigFiled(field = "producer.connector")
    private String connectorPluginType;

    @ConfigFiled(field = "operationMode")
    private String operationMode;

    @ConfigFiled(field = "fileMode.filePath")
    private String filePath;

    @ConfigFiled(field = "", reload = true)
    private Properties operationProperties;

    public void reload() {
        processOperationProperties();
    }

    public void processOperationProperties() {
        final String prefix = operationMode + "Mode";
        this.operationProperties = (Properties) operationProperties.get(prefix);
    }
}
