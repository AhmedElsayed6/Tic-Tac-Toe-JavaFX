package Controllers.OnlineControllers;

import Controllers.ChangeSceneController;
import Views.OnlineViews.LoginPageClass;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class IpController implements Controllers{

    Text txt;
    Text txtIpLength;
    TextField ipField;
    Button btnEnterIp;
    ImageView back;

    public IpController(Button btnEnterIp, TextField ipField, Text txt, Text txtIpLength, ImageView back) {
        this.txt = txt;
        this.txtIpLength = txtIpLength;
        this.ipField = ipField;
        this.btnEnterIp = btnEnterIp;
        this.back = back;
        setHandlers();
    }

    private void setHandlers() {
        btnEnterIp.setOnMouseClicked((MouseEvent event) -> {
            if (isValidIP()) {
                ClientThreadHandler cth = new ClientThreadHandler(ipField.getText());
                ClientThreadHandler.controllersMap.put("ip", this);
                ChangeSceneController.switchSceneWithStage( new LoginPageClass());
            } else {
                txtIpLength.setOpacity(1);
                btnEnterIp.setDisable(true);
                ipField.setDisable(true);
                back.setDisable(true);
                PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(5));
                pause.setOnFinished((e) -> {
                    txtIpLength.setOpacity(0);
                    btnEnterIp.setDisable(false);
                    ipField.setDisable(false);
                    back.setDisable(false);
                });
                pause.play();
            }

        });
    }

    private boolean isValidIP() {
        String[] str = ipField.getText().split("[.]");
        if (str.length != 4) {
            return false;
        } else {
            for (String a : str) {
                if (!(a.length() > 0 && a.length() < 4)) {
                    return false;
                }
            }
        }

        return true;
    }

}
