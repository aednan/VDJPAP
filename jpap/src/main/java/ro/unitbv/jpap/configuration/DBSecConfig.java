/**
 *  Copyright (C) 2021  the original author or authors.
 *
 * 		This program is free software: you can redistribute it and/or modify
 * 		it under the terms of the GNU General Public License as published by
 * 		the Free Software Foundation, either version 3 of the License, or
 * 		(at your option) any later version.
 *
 * 		This program is distributed in the hope that it will be useful,
 * 		but WITHOUT ANY WARRANTY; without even the implied warranty of
 * 		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * 		GNU General Public License for more details.
 *
 * 		You should have received a copy of the GNU General Public License
 * 		along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package ro.unitbv.jpap.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 */


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "dbsecEntityManagerFactory",
        transactionManagerRef = "dbsecTransactionManager",
        basePackages = {"ro.unitbv.jpap.dao.dbsec" })
public class DBSecConfig {

    @Bean(name = "dbsecEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean dbsecEntityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dbsecDataSource());
        em.setPackagesToScan("ro.unitbv.jpap.security.entity");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        properties.put("hibernate.hbm2ddl.import_files", "import_dbsec.sql");
        em.setJpaPropertyMap(properties);
        return em;
    }


    @ConfigurationProperties(prefix="spring.dbsec.datasource")
    @Bean(name = "dbsecDataSource")
    public DataSource dbsecDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dbsecTransactionManager")
    public PlatformTransactionManager dbsecTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(dbsecEntityManagerFactory().getObject());
        return transactionManager;
    }

}
