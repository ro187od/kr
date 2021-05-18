package com.egorbarkovsky.kr;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.TreeMap;


@Component
@FxmlView("kr.fxml")
public class MyController {

    @FXML
    private Label weatherLabel;

    @FXML
    private Spinner<Integer> firstExpertZ11;

    @FXML
    private Spinner<Integer> firstExpertZ21;

    @FXML
    private Spinner<Integer> firstExpertZ31;

    @FXML
    private Spinner<Integer> firstExpertZ12;

    @FXML
    private Spinner<Integer> firstExpertZ22;

    @FXML
    private Spinner<Integer> firstExpertZ32;

    @FXML
    private Spinner<Integer> firstExpertZ13;

    @FXML
    private Spinner<Integer> firstExpertZ23;

    @FXML
    private Spinner<Integer> firstExpertZ33;

    @FXML
    private Spinner<Integer> secondExpertZ11;

    @FXML
    private Spinner<Integer> secondExpertZ21;

    @FXML
    private Spinner<Integer> secondExpertZ31;

    @FXML
    private Spinner<Integer> secondExpertZ12;

    @FXML
    private Spinner<Integer> secondExpertZ22;

    @FXML
    private Spinner<Integer> secondExpertZ32;

    @FXML
    private Spinner<Integer> secondExpertZ13;

    @FXML
    private Spinner<Integer> secondExpertZ23;

    @FXML
    private Spinner<Integer> secondExpertZ33;

    @FXML
    private TextField jTextField19;

    @FXML
    private TextField jTextField20;

    @FXML
    private TextField jTextField21;

    @FXML
    private TextField jTextField22;

    @FXML
    private TextField jTextField23;

    @FXML
    private TextField jTextField24;

    @FXML
    private TextField jTextField25;

    @FXML
    private TextField jTextField26;

    @FXML
    private TextField jTextField27;

    @FXML
    private TextField jTextField28;

    @FXML
    private TextField jTextField29;

    @FXML
    private TextField jTextField30;

    @FXML
    private TextField jTextField31;

    @FXML
    private TextField jTextField32;

    @FXML
    private TextField jTextField33;

    @FXML
    private final int scale = 30;

    @Autowired
    private FxWeaver fxWeaver;

    private Stage stage;

    public static String answer;

    public static String msg;

    @FXML
    public void initialize(){
        firstExpertZ11.getEditor().setText("0");
        firstExpertZ31.getEditor().setText("0");
        firstExpertZ21.getEditor().setText("0");

        firstExpertZ12.getEditor().setText("0");
        firstExpertZ22.getEditor().setText("0");
        firstExpertZ32.getEditor().setText("0");

        firstExpertZ13.getEditor().setText("0");
        firstExpertZ33.getEditor().setText("0");
        firstExpertZ23.getEditor().setText("0");


        secondExpertZ11.getEditor().setText("0");
        secondExpertZ21.getEditor().setText("0");
        secondExpertZ31.getEditor().setText("0");

        secondExpertZ12.getEditor().setText("0");
        secondExpertZ22.getEditor().setText("0");
        secondExpertZ32.getEditor().setText("0");

        secondExpertZ13.getEditor().setText("0");
        secondExpertZ23.getEditor().setText("0");
        secondExpertZ33.getEditor().setText("0");
    }

    public void ok(){
        int f11 = firstExpertZ11.getValue() + firstExpertZ13.getValue();
        int f12 = firstExpertZ21.getValue() + firstExpertZ23.getValue();
        int f13 = firstExpertZ31.getValue() + firstExpertZ32.getValue();
        int f21 = secondExpertZ12.getValue() + secondExpertZ13.getValue();
        int f22 = secondExpertZ21.getValue() + secondExpertZ23.getValue();
        int f23 = secondExpertZ31.getValue() + secondExpertZ32.getValue();
        String F11 = f11 + "/" + scale;
        String F12 = f12 + "/" + scale;
        String F13 = f13 + "/" + scale;
        String F21 = f21 + "/" + scale;
        String F22 = f22 + "/" + scale;
        String F23 = f23 + "/" + scale;
        jTextField19.setText(F11);
        jTextField20.setText(F12);
        jTextField21.setText(F13);
        jTextField22.setText(F21);
        jTextField24.setText(F22);
        jTextField23.setText(F23);
        int N = 5;
        String V11 = f11 + "/" + scale + "/" + N;
        String V12 = f12 + "/" + scale + "/" + N;
        String V13 = f13 + "/" + scale + "/" + N;
        String V21 = f21 + "/" + scale + "/" + N;
        String V22 = f22 + "/" + scale + "/" + N;
        String V23 = f23 + "/" + scale + "/" + N;
        jTextField30.setText(V11);
        jTextField29.setText(V12);
        jTextField28.setText(V13);
        jTextField27.setText(V21);
        jTextField26.setText(V22);
        jTextField25.setText(V23);
        double W1 = (double) (f11 + f21) / scale / N;
        double W2 = (double) (f12 + f22) / scale / N;
        double W3 = (double) (f13 + f23) / scale / N;
        jTextField33.setText(String.valueOf(W1));
        jTextField31.setText(String.valueOf(W2));
        jTextField32.setText(String.valueOf(W3));
        DecimalFormatSymbols s = new DecimalFormatSymbols();
        s.setDecimalSeparator('.');
        DecimalFormat f = new DecimalFormat("0.000", s);
        W1 = (double) Double.valueOf(f.format(W1));
        W2 = (double) Double.valueOf(f.format(W2));
        W3 = (double) Double.valueOf(f.format(W3));
        HashMap<String, Double> map = new HashMap<>();
        ValueComparator bvc = new ValueComparator(map);
        TreeMap<String, Double> sorted_map = new TreeMap<>(bvc);
        map.put("Z1", W1);
        map.put("Z2", W2);
        map.put("Z3", W3);
        if(W1 == W2 & W2 == W3){
            String title = "Наиболее предпочтительные варианты";
            answer = "{Z1=" + W1 + ", Z2=" + W2 +", Z3=" + W3 + "}";
            showInfoDialog(title);
        } else {
            sorted_map.putAll(map);
            String title = "Наиболеепредпочтительныеварианты";
            msg = sorted_map + "";
            showInfoDialog(title);
        }
    }

    public void reset(){
        initialize();
    }

    private void showInfoDialog(String title) {
        Parent root = fxWeaver.loadView(ResultController.class);
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
