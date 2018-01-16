package controller;

import view.*;

public class AgendaController {
    private static Agenda app;

    public static Agenda run() {
        app = new Agenda();
        app.populateContactsList();
        return app;
    }
}
