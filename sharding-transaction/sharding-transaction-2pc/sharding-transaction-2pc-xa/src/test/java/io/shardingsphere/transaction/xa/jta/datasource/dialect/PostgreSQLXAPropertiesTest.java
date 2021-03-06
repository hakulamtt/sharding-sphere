/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
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
 * </p>
 */

package io.shardingsphere.transaction.xa.jta.datasource.dialect;

import org.junit.Test;

import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class PostgreSQLXAPropertiesTest extends BaseXAPropertiesTest {
    
    @Test
    public void assertBuild() {
        getDataSourceParameter().setUrl("jdbc:postgresql://db.psql:5432/test_db");
        Properties actual = new PostgreSQLXAProperties().build(getDataSourceParameter());
        assertThat(actual.getProperty("user"), is("root"));
        assertThat(actual.getProperty("password"), is("root"));
        assertThat(actual.getProperty("serverName"), is("db.psql"));
        assertThat(actual.getProperty("portNumber"), is("5432"));
        assertThat(actual.getProperty("databaseName"), is("test_db"));
    }
}
