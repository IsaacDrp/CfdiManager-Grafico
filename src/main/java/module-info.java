module com.cfdimanager {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.cfdimanager to javafx.fxml;
    exports com.cfdimanager;
}
