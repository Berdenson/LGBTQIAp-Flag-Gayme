module com.github.berdenson.lgbrqpflaggame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires json.simple;


    opens com.github.berdenson.lgbrqpflaggame to javafx.fxml;
    exports com.github.berdenson.lgbrqpflaggame;
}