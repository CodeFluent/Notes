package sample;

import javafx.scene.control.Toggle;

@FunctionalInterface
public interface SelectionSourceHandle {

    void handleSelectionSubmission(String toggle);
}
