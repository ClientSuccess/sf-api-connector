/*
 * Copyright © 2013. Palomino Labs (http://palominolabs.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.palominolabs.crm.sf.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;
import com.palominolabs.crm.sf.soap.ApiException;
import com.palominolabs.crm.sf.soap.BindingConfig;
import com.palominolabs.crm.sf.soap.ConnectionPool;
import com.palominolabs.crm.sf.soap.ConnectionPoolImpl;
import org.apache.http.impl.client.HttpClients;

import java.net.MalformedURLException;
import java.net.URL;

import static com.palominolabs.crm.sf.testutil.TestMetricRegistry.METRIC_REGISTRY;

final class TestConnections {

    static final ObjectMapper MAPPER = new ObjectMapper();

    private TestConnections() {
    }

    static HttpApiClient getHttpApiClient(String user, String password) {
        try {
            BindingConfig bindingConfig = getBindingConfig(user, password);
            String host = new URL(bindingConfig.getPartnerServerUrl()).getHost();
            return new HttpApiClient(host, bindingConfig.getSessionId(), MAPPER,
                    HttpClients.createDefault());
        } catch (ApiException e) {
            throw Throwables.propagate(e);
        } catch (MalformedURLException e) {
            throw Throwables.propagate(e);
        }
    }

    static BindingConfig getBindingConfig(String user, String password) throws ApiException {

        ConnectionPool<Integer> repository =
                new ConnectionPoolImpl<Integer>("testPartnerKey", METRIC_REGISTRY);
        repository.configureOrg(1, user, password, 1);

        return repository.getConnectionBundle(1).getBindingConfig();
    }

    static RestConnection getRestConnection(String user, String password) {
        return new RestConnectionImpl(MAPPER.reader(),
                new FixedHttpApiClientProvider(getHttpApiClient(user, password)), METRIC_REGISTRY);
    }
}
