package com.atf.utilities;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Objects;

public class DatabaseUtils {

    public static void executeScript(DataSource dataSource, String scriptPath) throws IOException {
        Connection con = DataSourceUtils.getConnection(dataSource);
        InputStream inputStream = null;

        try {
            inputStream = DatabaseUtils.class.getClassLoader().getResourceAsStream(scriptPath);
            Resource resource = new InputStreamResource(Objects.requireNonNull(inputStream));
            ScriptUtils.executeSqlScript(con, resource);
        } catch (Exception e) {
            //TODO add logger
        } finally {
            DataSourceUtils.releaseConnection(con, dataSource);
            Objects.requireNonNull(inputStream).close();
        }
    }
}
