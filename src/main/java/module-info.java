module com.messenger {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires de.jensd.fx.glyphs.fontawesome;

    opens com.messenger to javafx.fxml;
    exports com.messenger;
}