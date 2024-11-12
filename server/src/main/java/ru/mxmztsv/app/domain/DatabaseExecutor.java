package ru.mxmztsv.app.domain;

import lombok.extern.slf4j.Slf4j;
import ru.mxmztsv.model.category;
import ru.mxmztsv.model.status;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DatabaseExecutor {

    private final DataSource dataSource;

    public DatabaseExecutor(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Client> executeSelect(String sql, List<Object> params) {
        List<Client> Clients = new ArrayList<>();
        try (
                var connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            log.info("query: {}", sql);
            log.info("params: {}", params);
            for (int i = 0; i < params.size(); i++) {
                Object param = params.get(i);
                if (param instanceof status) {
                    statement.setString(i + 1, ((status) param).name());
                } else if (param instanceof category) {
                    statement.setString(i + 1, ((category) param).name());
                } else {
                    statement.setObject(i + 1, param);
                }
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Clients.add(mapToClient(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Clients;
    }

    private Client mapToClient(ResultSet resultSet) throws SQLException {
        return Client.builder()
                .id(resultSet.getInt("id"))
                .firstName(resultSet.getString("first_name"))
                .lastName(resultSet.getString("last_name"))
                .status(resultSet.getString("status"))
                .category(resultSet.getString("category"))
                .createdAt(resultSet.getDate("created_at"))
                .build();
    }
}
