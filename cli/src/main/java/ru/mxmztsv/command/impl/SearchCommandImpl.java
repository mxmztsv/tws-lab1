package ru.mxmztsv.command.impl;

import lombok.SneakyThrows;
import ru.mxmztsv.app.Category;
import ru.mxmztsv.app.ClientService;
import ru.mxmztsv.app.ClientServiceImpl;
import ru.mxmztsv.app.Status;
import ru.mxmztsv.command.Command;
import ru.mxmztsv.command.CommandHandler;
import ru.mxmztsv.command.Key;
import ru.mxmztsv.command.mapper.ClientMapper;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchCommandImpl implements CommandHandler {
    private final ClientServiceImpl ClientService;

    public SearchCommandImpl() {
        ClientService service = new ClientService();
        ClientService = service.getClientServicePort();
    }

    @SneakyThrows
    @Override
    public void execute(Map<Key, String> params) {
        String Clients = Optional.ofNullable(
                        ClientService.searchClients(
                                params.get(Key.FIRST_NAME),
                                params.get(Key.LAST_NAME),
                                params.get(Key.STATUS) != null
                                        ? Status.valueOf(params.get(Key.STATUS).toUpperCase())
                                        : null,
                                params.get(Key.CATEGORY) != null
                                        ? Category.valueOf(params.get(Key.CATEGORY).toUpperCase())
                                        : null,
                                params.get(Key.DATE) != null
                                        ? ClientMapper.DATA_FORMAT_SERVER
                                        .format(ClientMapper.DATA_FORMAT.parse(params.get(Key.DATE)))
                                        : null
                        ).getResponseModelList()
                ).stream()
                .flatMap(Collection::stream)
                .map(ClientMapper::mapToString)
                .collect(Collectors.joining("\n"));
        if (Clients.isEmpty()) {
            System.out.println("Нет клиентов, соответствующих заданным параметрам.");
        } else {
            System.out.println(Clients);
        }

    }

    @Override
    public Command getName() {
        return Command.SEARCH;
    }
}
