module com.example.mtbfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mtbfx to javafx.fxml;
    exports com.example.mtbfx;
}