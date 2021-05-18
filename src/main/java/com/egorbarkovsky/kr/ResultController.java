package com.egorbarkovsky.kr;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("result.fxml")
public class ResultController {

    @FXML private javafx.scene.control.Button closeButton;
    @FXML private javafx.scene.control.Label resultId;

    public void initialize(){
        if (MyController.answer != null){
            resultId.setText(MyController.answer);
        }else{
            resultId.setText(MyController.msg);
        }
    }

    public void kk(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
