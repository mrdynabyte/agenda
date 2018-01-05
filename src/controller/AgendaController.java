package controller;

import model.*;
import view.*;

public class AgendaController {
    private static Agenda app;

    public static Agenda run() {
        app = new Agenda();
        app.populateContactsList(ContactModel.getContactList());
        return app;
    }
}
