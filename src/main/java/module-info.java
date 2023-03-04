module application{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
//    requires org.controlsfx.controls;
//    requires org.kordamp.bootstrapfx.core;
//    requires MaterialFX;

    opens oberflaeche to javafx.fxml;
    exports oberflaeche;
}