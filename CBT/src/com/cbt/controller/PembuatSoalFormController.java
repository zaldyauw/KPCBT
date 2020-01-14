/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbt.controller;

import com.cbt.MainApp;
import com.cbt.dao.AnswerDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import com.cbt.entity.Question;
import com.cbt.dao.PembuatSoalFormDaoImpl;
import com.cbt.dao.PicturesquestionDaoImpl;
import com.cbt.dao.CoursedatabaseDaoImpl;
import com.cbt.dao.SubtestDaoImpl;
import com.cbt.entity.Mediacontent;
import com.cbt.entity.Coursedatabase;
import com.cbt.dao.CoursedatabaseDaoImpl;
import com.cbt.dao.MediacontentDaoImpl;
import com.cbt.dao.QuestionDaoImpl;
import com.cbt.dao.UserDaoImpl;
import com.cbt.entity.Answer;
import com.cbt.entity.AnswerId;
import com.cbt.entity.Media;
import com.cbt.entity.Role;
import com.cbt.entity.Subtest;
import com.cbt.entity.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Zaldy Auw
 */
public class PembuatSoalFormController {

    @FXML
    private VBox root;
    @FXML
    private HBox userHbox;
    @FXML
    private VBox creatorVbox;
    @FXML
    private VBox userVbox;
    private TextField txtPictures;
    private TextField txtAudio;
    private TextField txtVideo;
    private TextField txtTrueN;
    private TextField txtWrong1N;
    private TextField txtWrong2N;
    private TextField txtWrong3N;
    private TextField txtWrong4N;
    private TextArea textSoalN;
    private TextField txtTrueP;
    private TextField txtWrong1P;
    private TextField txtWrong2P;
    private TextField txtWrong3P;
    private TextField txtWrong4P;
    private TextField txtTrueA;
    private TextField txtWrong1A;
    private TextField txtWrong2A;
    private TextField txtWrong3A;
    private TextField txtWrong4A;
    private TextField txtTrueV;
    private TextField txtWrong1V;
    private TextField txtWrong2V;
    private TextField txtWrong3V;
    private TextField txtWrong4V;
    private TextField questID;
    private TextField SubID;

    @FXML
    private TableColumn<Coursedatabase, String> col1;
    @FXML
    private TableColumn<Coursedatabase, String> col2;
    private TableColumn<Coursedatabase, String> col3;
    private TextField newdatabaseId;
    @FXML
    private TableView<Coursedatabase> tblDB;

    private LoginController mainController;
    @FXML
    private VBox profileVbox;
    @FXML
    private Button editProfileButton;
    @FXML
    private VBox updateProfileCardVbox;
        private UserDaoImpl userDao;
    @FXML
    private VBox profileCardVbox;
    private Stage mainStage;
    private ObservableList<Question> questions;
    private ObservableList<Subtest> subtests;
    private ObservableList<Answer> answers;
    private QuestionDaoImpl questionDao;
    private SubtestDaoImpl subtestDao;
    private AnswerDaoImpl answerDao;
    private MediacontentDaoImpl mediacontentDao;
    private CoursedatabaseDaoImpl couserdatabaseDao;
    private ObservableList<Coursedatabase> coursedatabases;
    double x, y;
    @FXML
    private ImageView maximizeImageVIew;
    private HTMLEditor txtSoal;
    private VBox JawabanVbox;
    private VBox DaftarVbox;
    private Coursedatabase selectedCourse = new Coursedatabase();
    private int type = 4;
    private TextField txtAttach;
    @FXML
    private VBox questionVbox;
    @FXML
    private TableColumn<Question, String> col11;
    @FXML
    private TableColumn<Question, String> col21;
    @FXML
    private TableColumn<Question, String> col31;
    @FXML
    private TableView<Question> tblquestions;
    private TextArea txtviewsoal;
    @FXML
    private Button btnedit;
    private RadioButton btnradioa;
    private RadioButton btnradiob;
    private RadioButton btnradioc;
    private RadioButton btnradiod;
    private RadioButton btnradioe;
    @FXML
    private TextArea txtContent;
    @FXML
    private HTMLEditor htmlEditor;
    @FXML
    private RadioButton rbA;
    @FXML
    private RadioButton rbB;
    @FXML
    private RadioButton rbC;
    @FXML
    private RadioButton rbE;
    @FXML
    private TextArea txtAnsA;
    @FXML
    private TextArea txtAnsB;
    @FXML
    private TextArea txtAnsC;
    @FXML
    private TextArea txtAnsD;
    @FXML
    private TextArea txtAnsE;
    @FXML
    private TextField txtPath;
    @FXML
    private RadioButton rbD;
    @FXML
    private Button btnUpload;
    private ToggleGroup toggle = new ToggleGroup();
    private FileChooser filechooser;
    private Question selectedQuestion;
    private Boolean isEditMode = false;
    private ObservableList<Answer> selectedAnswers;
    private User loginUser;
    @FXML
    private TextField updateUserIdTextField;
    @FXML
    private TextField updateUserEmailTextField;
    @FXML
    private TextField updateUsernameTextField;
    @FXML
    private TextField updateUserPasswordTextField;
    @FXML
    private TextField updateUserFirstNameTextField;
    @FXML
    private TextField updateUserLastNameTextField;
    @FXML
    private TextField updateUserPhoneNumberTextField;
    @FXML
    private Label userIdLabel;
    @FXML
    private Label userNameLabel;
    @FXML
    private Label userPhoneNumberLabel;
    @FXML
    private Label userEmailLabel;
    
    
    

    public void setMainController(LoginController mainController) {
        
        this.mainController = mainController;
        answerDao = new AnswerDaoImpl();
        questionDao = new QuestionDaoImpl();
        mediacontentDao = new MediacontentDaoImpl();
        questions = FXCollections.observableArrayList();
        answers = FXCollections.observableArrayList();
        selectedAnswers = FXCollections.observableArrayList();
        //tableview
        tblDB.setItems(getCoursedatabases());
        col1.setCellValueFactory((data) -> {
            Coursedatabase coursedatabase = data.getValue();
            return new SimpleStringProperty(coursedatabase.getId());
        });
        col2.setCellValueFactory((data) -> {
            Coursedatabase coursedatabase = data.getValue();
            return new SimpleStringProperty(coursedatabase.getName());
        });

        tblDB.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    // TODO
                    selectedCourse = tblDB.getSelectionModel().getSelectedItem();
                    btnedit.setDisable(false);
                    questions.clear();
                    questions.addAll(questionDao.getSpecificData(selectedCourse));
                    tblquestions.setItems(questions);
                    col11.setCellValueFactory((data) -> {
                        Question question = data.getValue();
                        return new SimpleStringProperty(question.getId());
                    });
                    col21.setCellValueFactory((data) -> {
                        Question question = data.getValue();
                        return new SimpleStringProperty(question.getContent());
                    });
                    col31.setCellValueFactory((data) -> {
                        Question question = data.getValue();
                        return new SimpleStringProperty(question.getMediacontent().getMedia().getMediaType());
                    });
                    questionVbox.toFront();

                }
            }
        });

        rbA.setToggleGroup(toggle);
        rbB.setToggleGroup(toggle);
        rbC.setToggleGroup(toggle);
        rbD.setToggleGroup(toggle);
        rbE.setToggleGroup(toggle);

        btnUpload.setDisable(true);
        txtPath.setDisable(true);
//        setProfileLabelText();
        
        

    }
//     public void setProfileLabelText() {
//        userIdLabel.setText(loginUser.getId());
//        userNameLabel.setText(loginUser.getFirstName() + " " + loginUser.getLastName());
//        userPhoneNumberLabel.setText(loginUser.getPhoneNumber());
//        userEmailLabel.setText(loginUser.getEmail());
//    }

    @FXML
    private void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (!stage.isFullScreen()) {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        }
    }

    @FXML
    private void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    private void mouseExitedUser(MouseEvent event) {
    }

    @FXML
    private void mouseEnteredUser(MouseEvent event) {
    }

    @FXML
    private void userOnClick(MouseEvent event) {
        creatorVbox.toFront();
    }

    public void initialize(URL url, ResourceBundle rb) {
        //tableview1
        tblDB.setItems(getCoursedatabases());
        col1.setCellValueFactory((data) -> {
            Coursedatabase coursedatabase = data.getValue();
            return new SimpleStringProperty(coursedatabase.getId());
        });
        col2.setCellValueFactory((data) -> {
            Coursedatabase coursedatabase = data.getValue();
            return new SimpleStringProperty(coursedatabase.getName());
        });
//        tableview2
        tblquestions.setItems(getQuestions());
        col11.setCellValueFactory((data) -> {
            Question question = data.getValue();
            return new SimpleStringProperty(question.getId());
        });
        col21.setCellValueFactory((data) -> {
            Question question = data.getValue();
            return new SimpleStringProperty(question.getContent());
        });
        col31.setCellValueFactory((data) -> {
            Question question = data.getValue();
            return new SimpleObjectProperty(question.getMediacontent());
        });

    }
//      public void setProfileLabelText() {
////        userIdLabel.setText(loginUser.getId());
////        userNameLabel.setText(loginUser.getFirstName() + " " + loginUser.getLastName());
////        userPhoneNumberLabel.setText(loginUser.getPhoneNumber());
////        userEmailLabel.setText(loginUser.getEmail());
//    }
//public UserDaoImpl getUserDao() {
//        if (userDao == null) {
//            userDao = new UserDaoImpl();
//        }
//        return userDao;
//    }

    public SubtestDaoImpl getSubtestDao() {
        if (subtestDao == null) {
            subtestDao = new SubtestDaoImpl();
        }
        return subtestDao;
    }

    public ObservableList<Subtest> getSubtest() {
        if (subtests == null) {
            subtests = FXCollections.observableArrayList();
            subtests.addAll(getSubtestDao().getAllData());
        }
        return subtests;
    }

    public CoursedatabaseDaoImpl getCoursedatabaseDao() {
        if (couserdatabaseDao == null) {
            couserdatabaseDao = new CoursedatabaseDaoImpl();
        }
        return couserdatabaseDao;
    }

    public ObservableList<Coursedatabase> getCoursedatabases() {
        if (coursedatabases == null) {
            coursedatabases = FXCollections.observableArrayList();
            coursedatabases.addAll(getCoursedatabaseDao().showAllData());
        }
        return coursedatabases;
    }

    public QuestionDaoImpl getQuestionDao() {
        if (questionDao == null) {
            questionDao = new QuestionDaoImpl();
        }
        return questionDao;
    }

    public ObservableList<Question> getQuestions() {
        if (questions == null) {
            questions = FXCollections.observableArrayList();
            questions.addAll(getQuestionDao().getAllData());
        }
        return questions;
    }
    
      public UserDaoImpl getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    private void backButtonAct(ActionEvent event) {
        creatorVbox.toFront();

    }

    @FXML
    private void tblDBClick(MouseEvent event) {
        selectedCourse = tblDB.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void profileOnClick(MouseEvent event) {
        profileVbox.toFront();
    }

    @FXML
    private void editProfileButtonClick(ActionEvent event) {
//updateUserIdTextField.setText(loginUser.getId());

//        updateUsernameTextField.setText(loginUser.getUsername());
//        updateUserPasswordTextField.setText(loginUser.getPassword());
//        updateUserFirstNameTextField.setText(loginUser.getFirstName());
//        updateUserLastNameTextField.setText(loginUser.getLastName());
//        updateUserPhoneNumberTextField.setText(loginUser.getPhoneNumber());
//        updateUserEmailTextField.setText(loginUser.getEmail());

        updateProfileCardVbox.toFront();
        editProfileButton.setDisable(true);
    }

    @FXML
    private void saveEditProfileButtonClick(ActionEvent event) {
//          if (updateUsernameTextField.getText().trim().isEmpty()
//                || updateUserPasswordTextField.getText().trim().isEmpty()
//                || updateUserFirstNameTextField.getText().trim().isEmpty()) {
//            //  Show alert if username/password/first name field is empty
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setHeaderText("Field Empty");
//            alert.setContentText("Username/Password/First Name cannot be empty");
//            alert.initOwner(root.getScene().getWindow());
//            alert.initModality(Modality.APPLICATION_MODAL);
//            alert.show();
//        } else {
//            //  Init new user
//            User user = new User();
//
//            //  Set new user attributes
//            user.setId(loginUser.getId());
//            user.setUsername(updateUsernameTextField.getText());
//            user.setPassword(updateUserPasswordTextField.getText());
//            user.setFirstName(updateUserFirstNameTextField.getText());
//            user.setLastName(updateUserLastNameTextField.getText());
//            user.setPhoneNumber(updateUserPhoneNumberTextField.getText());
//            user.setEmail(updateUserEmailTextField.getText());
//            user.setStatus(Byte.valueOf("1"));
//
//            Role role = new Role();
//            role.setId(loginUser.getRole().getId());
//            role.setClassName(loginUser.getRole().getClassName());
//            user.setRole(role);
//
//          
//
//            //  Update local user login
//            loginUser = user;
//
//            //  Update profile text label
//            setProfileLabelText();
//
//            // Update database user
//            getUserDao().updateData(user);

   
        profileCardVbox.toFront();
        editProfileButton.setDisable(false);
//    }
    }

    @FXML
    private void cancelEditProfileButtonClick(ActionEvent event) {
        profileCardVbox.toFront();
        editProfileButton.setDisable(false);
    }

    @FXML
    private void logOutButtonAction(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PembuatLoginForm.fxml"));
            HBox pane = loader.load();
            Scene scene = new Scene(pane);
            mainStage = new Stage();
            mainStage.setScene(scene);
            mainStage.initStyle(StageStyle.TRANSPARENT);
            mainStage.setTitle("CBT Login");
            ((Stage) root.getScene().getWindow()).close();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainStage.show();
    }

    @FXML
    private void minimizeButton(MouseEvent event) {
        Stage stage = (Stage) ((HBox) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void maximizeButton(MouseEvent event) {
        Stage stage = (Stage) ((HBox) event.getSource()).getScene().getWindow();
        if (stage.isFullScreen()) {
            stage.setFullScreen(false);
            maximizeImageVIew.setImage(new Image(getClass().getResource("/com/cbt/images/maximize.png").
                    toString()));
        } else {
            stage.setFullScreen(true);
            maximizeImageVIew.setImage(new Image(getClass().getResource("/com/cbt/images/restore.png").
                    toString()));
        }
    }

    @FXML
    private void closeButton(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    private void btnvideoclick(ActionEvent event) {
        type = 1;

    }

    private void btnaudioclick(ActionEvent event) {
        type = 2;
    }

    private void btnpictureclick(ActionEvent event) {
        type = 3;
    }

    private void btntextclick(ActionEvent event) {
        type = 4;
    }

    @FXML
    private void btneditclick(ActionEvent event) {
        isEditMode = true;
        htmlEditor.setHtmlText(selectedQuestion.getMediacontent().getCaption());
        txtContent.setText(selectedQuestion.getContent());
        
        selectedAnswers.addAll(answerDao.getSpecificData(selectedQuestion));
        switch(selectedAnswers.get(0).getTrueAnswer()) {
            case 1:
                rbA.setSelected(true);
                break;
            case 0:
                rbA.setSelected(false);
                break;
            default:
                break;
        }
        switch(selectedAnswers.get(1).getTrueAnswer()) {
            case 1:
                rbB.setSelected(true);
                break;
            case 0:
                rbB.setSelected(false);
                break;
            default:
                break;
        }
        switch(selectedAnswers.get(2).getTrueAnswer()) {
            case 1:
                rbC.setSelected(true);
                break;
            case 0:
                rbC.setSelected(false);
                break;
            default:
                break;
        }
        switch(selectedAnswers.get(3).getTrueAnswer()) {
            case 1:
                rbD.setSelected(true);
                break;
            case 0:
                rbD.setSelected(false);
                break;
            default:
                break;
        }
        switch(selectedAnswers.get(4).getTrueAnswer()) {
            case 1:
                rbE.setSelected(true);
                break;
            case 0:
                rbE.setSelected(false);
                break;
            default:
                break;
        }
        txtAnsA.setText(selectedAnswers.get(0).getContent());
        txtAnsB.setText(selectedAnswers.get(1).getContent());
        txtAnsC.setText(selectedAnswers.get(2).getContent());
        txtAnsD.setText(selectedAnswers.get(3).getContent());
        txtAnsE.setText(selectedAnswers.get(4).getContent());
        
//        if (selectedQuestion.getMediacontent().getMediaAddress() != null) {
//            
//        }
        userVbox.toFront();
        
    }

    @FXML
    private void btntambahclick(ActionEvent event) {
        htmlEditor.setHtmlText("");
        txtPath.clear();
        txtContent.clear();
        txtAnsA.clear();
        txtAnsB.clear();
        txtAnsC.clear();
        txtAnsD.clear();
        txtAnsE.clear();
        userVbox.toFront();
    }

    @FXML
    private void btnbackclick(ActionEvent event) {
        creatorVbox.toFront();
    }

    @FXML
    private void btnSwcVideoClick(ActionEvent event) {
        type = 1;
        btnUpload.setDisable(false);
        txtPath.setDisable(false);
    }

    @FXML
    private void btnSwcAudioClick(ActionEvent event) {
        type = 2;
        btnUpload.setDisable(false);
        txtPath.setDisable(false);
    }

    @FXML
    private void btnSwcImageClick(ActionEvent event) {
        type = 3;
        btnUpload.setDisable(false);
        txtPath.setDisable(false);
    }

    @FXML
    private void btnSwcTextClick(ActionEvent event) {
        type = 4;
        btnUpload.setDisable(true);
        txtPath.setDisable(true);
    }

    @FXML
    private void btnUploadClick(ActionEvent event) {
        FileChooser chooser = new FileChooser();
               File file = chooser.showOpenDialog(root.getScene().getWindow());
        switch (type) {
             

            case 3:
//                FileChooser chooser = new FileChooser();
                chooser.setTitle("Upload image");
                chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(
                        "*.png", "*"));
//                File file = chooser.showOpenDialog(root.getScene().getWindow());

                txtPath.setText(file.getName());
                txtPath.setDisable(true);

                break;
            case 1:
//                FileChooser chooser = new FileChooser();
                chooser.setTitle("Upload Video");
                chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(
                        "*.mp4", "*"));
//                File file = chooser.showOpenDialog(root.getScene().getWindow());

                txtPath.setText(file.getName());
                txtPath.setDisable(true);
                break;
            case 2:
//                FileChooser chooser = new FileChooser();
                chooser.setTitle("Upload Audio");
                chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(
                        "*.mp3", "*"));
//                File file = chooser.showOpenDialog(root.getScene().getWindow());

                txtPath.setText(file.getName());
                txtPath.setDisable(true);
                break;
            case 4:
////                FileChooser chooser = new FileChooser();
//                chooser.setTitle("Upload image");
//                chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(
//                        "*.png", "*"));
////                File file = chooser.showOpenDialog(root.getScene().getWindow());
//
//                txtPath.setText(file.getName());
//                txtPath.setDisable(true);
                break;
            default:
                break;
        }

    }

    @FXML
    private void btnKembaliClick(ActionEvent event) {
        questionVbox.toFront();
    }

    @FXML
    private void btnSaveClick(ActionEvent event) {
        
        
        ObservableList<Question> counts = FXCollections.observableArrayList();
        ObservableList<Mediacontent> contents = FXCollections.observableArrayList();
        ObservableList<AnswerId> countAns = FXCollections.observableArrayList();

        Question question = new Question();
          Mediacontent mc = new Mediacontent();
                Media m = new Media();
                
                
//                answer 
                Answer ansA = new Answer();
                Answer ansB = new Answer();
                Answer ansC = new Answer();
                Answer ansD = new Answer();
                Answer ansE = new Answer();
                
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YY");
        switch (type) {
            case 4:
                if(txtAnsA.getText().isEmpty()||txtAnsB.getText().isEmpty()||txtAnsC.getText().isEmpty()||txtAnsD.getText().isEmpty()||txtAnsE.getText().isEmpty()||txtContent.getText().isEmpty()){
                     Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Field Empty");
            alert.setContentText("Ada yang kurang soal ataupun jawaban");
            alert.initOwner(root.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.showAndWait();
                }
                else{
                counts.addAll(questionDao.getCount("QN-"));
                contents.addAll(mediacontentDao.getSpecificData(4));
                countAns.addAll(answerDao.countAns("NA-"));
//                Mediacontent mc = new Mediacontent();
//                Media m = new Media();
                m.setId(4);
                m.setMediaType("Text");
                
                
                
                mc.setMediaAddress("http://localhost/NetBeans/medias/image/" + txtPath.getText());
                mc.setCaption(htmlEditor.getHtmlText());
                mc.setMedia(m);
                
                if (isEditMode) {
                    mc.setId(selectedQuestion.getMediacontent().getId());
                    mediacontentDao.updateData(mc);
                } else {
                    mc.setId("TXT-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("000" + String.valueOf(contents.size() + 1), 4));
                    mediacontentDao.addData(mc);
                }
                
              
                question.setContent(txtContent.getText());
                question.setUser(this.mainController.getLoginUser());
                question.setCoursedatabase(selectedCourse);
                
                question.setMediacontent(mc);
                
                if (isEditMode) {
                    question.setId(selectedQuestion.getId());
                    questionDao.updateData(question);
                } else {
                    question.setId("QN-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(counts.size() + 1), 5));
                    questionDao.addData(question);
                }
                
                //answer A

//                Answer ansA = new Answer();
                
                ansA.setQuestion(question);
                if (rbA.isSelected()) {
                    ansA.setTrueAnswer((byte) 1);
                } else {
                    ansA.setTrueAnswer((byte) 0);
                }
                ansA.setContent(txtAnsA.getText());
                if (isEditMode) {
                    ansA.setId(selectedAnswers.get(0).getId());
                    answerDao.updateData(ansA);
                    
                } else {
                    ansA.setId(new AnswerId("NA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansA);
                }
                
                countAns.clear();
                countAns.addAll(answerDao.countAns("NA-"));

                //answer B
//                Answer ansB = new Answer();
                
                ansB.setQuestion(question);
                if (rbB.isSelected()) {
                    ansB.setTrueAnswer((byte) 1);
                } else {
                    ansB.setTrueAnswer((byte) 0);
                }
                ansB.setContent(txtAnsB.getText());
                if (isEditMode) {
                    ansB.setId(selectedAnswers.get(1).getId());
                    answerDao.updateData(ansB);
                } else {
                    ansB.setId(new AnswerId("NA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansB);
                }
                countAns.clear();
                countAns.addAll(answerDao.countAns("NA-"));

                //answer C
//                Answer ansC = new Answer();
                
                ansC.setQuestion(question);
                if (rbC.isSelected()) {
                    ansC.setTrueAnswer((byte) 1);
                } else {
                    ansC.setTrueAnswer((byte) 0);
                }
                ansC.setContent(txtAnsC.getText());
                if (isEditMode) {
                    ansC.setId(selectedAnswers.get(2).getId());
                    answerDao.updateData(ansC);
                } else {
                    ansC.setId(new AnswerId("NA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansC);
                }
                countAns.clear();
                countAns.addAll(answerDao.countAns("NA-"));

                //answer D
//                Answer ansD = new Answer();
                
                ansD.setQuestion(question);
                if (rbD.isSelected()) {
                    ansD.setTrueAnswer((byte) 1);
                } else {
                    ansD.setTrueAnswer((byte) 0);
                }
                ansD.setContent(txtAnsD.getText());
                if (isEditMode) {
                    ansD.setId(selectedAnswers.get(3).getId());
                    answerDao.updateData(ansD);
                } else {
                    ansD.setId(new AnswerId("NA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansD);
                }
                countAns.clear();
                countAns.addAll(answerDao.countAns("NA-"));

                //answer E
//                Answer ansE = new Answer();
                
                ansE.setQuestion(question);
                if (rbE.isSelected()) {
                    ansE.setTrueAnswer((byte) 1);
                } else {
                    ansE.setTrueAnswer((byte) 0);
                }
                ansE.setContent(txtAnsE.getText());
                if (isEditMode) {
                    ansE.setId(selectedAnswers.get(4).getId());
                    answerDao.updateData(ansE);
                } else {
                    ansE.setId(new AnswerId("NA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansE);
                }
                countAns.clear();
                countAns.addAll(answerDao.countAns("NA-"));

                txtPath.clear();
                rbA.setSelected(false);
                rbB.setSelected(false);
                rbC.setSelected(false);
                rbD.setSelected(false);
                rbE.setSelected(false);
                isEditMode = false;
                selectedAnswers.clear();
               
                break;
                 }
            case 2:
                 if(txtAnsA.getText().isEmpty()||txtAnsB.getText().isEmpty()||txtAnsC.getText().isEmpty()||txtAnsD.getText().isEmpty()||txtAnsE.getText().isEmpty()||txtContent.getText().isEmpty()){
                     Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Field Empty");
            alert.setContentText("Ada yang kurang soal ataupun jawaban");
            alert.initOwner(root.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.showAndWait();
                }
                else{
                 counts.addAll(questionDao.getCount("QA-"));
                contents.addAll(mediacontentDao.getSpecificData(4));
                countAns.addAll(answerDao.countAns("AA-"));
//                Mediacontent mc = new Mediacontent();
//                Media m = new Media();
                m.setId(2);
                m.setMediaType("Audio");
                
                mc.setMediaAddress("http://localhost/NetBeans/medias/image/" + txtPath.getText());
                mc.setCaption(htmlEditor.getHtmlText());
                mc.setMedia(m);
                
                if (isEditMode) {
                    mc.setId(selectedQuestion.getMediacontent().getId());
                    mediacontentDao.updateData(mc);
                } else {
                    mc.setId("AUD-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("000" + String.valueOf(contents.size() + 1), 4));
                    mediacontentDao.addData(mc);
                }
                
              
                question.setContent(txtContent.getText());
                question.setUser(this.mainController.getLoginUser());
                question.setCoursedatabase(selectedCourse);
                
                question.setMediacontent(mc);
                
                if (isEditMode) {
                    question.setId(selectedQuestion.getId());
                    questionDao.updateData(question);
                } else {
                    question.setId("QA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(counts.size() + 1), 5));
                    questionDao.addData(question);
                }
                
                //answer A

//                Answer ansA = new Answer();
                
                ansA.setQuestion(question);
                if (rbA.isSelected()) {
                    ansA.setTrueAnswer((byte) 1);
                } else {
                    ansA.setTrueAnswer((byte) 0);
                }
                ansA.setContent(txtAnsA.getText());
                if (isEditMode) {
                    ansA.setId(selectedAnswers.get(0).getId());
                    answerDao.updateData(ansA);
                    
                } else {
                    ansA.setId(new AnswerId("AA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansA);
                }
                
                countAns.clear();
                countAns.addAll(answerDao.countAns("AA-"));

                //answer B
//                Answer ansB = new Answer();
                
                ansB.setQuestion(question);
                if (rbB.isSelected()) {
                    ansB.setTrueAnswer((byte) 1);
                } else {
                    ansB.setTrueAnswer((byte) 0);
                }
                ansB.setContent(txtAnsB.getText());
                if (isEditMode) {
                    ansB.setId(selectedAnswers.get(1).getId());
                    answerDao.updateData(ansB);
                } else {
                    ansB.setId(new AnswerId("AA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansB);
                }
                countAns.clear();
                countAns.addAll(answerDao.countAns("AA-"));

                //answer C
//                Answer ansC = new Answer();
                
                ansC.setQuestion(question);
                if (rbC.isSelected()) {
                    ansC.setTrueAnswer((byte) 1);
                } else {
                    ansC.setTrueAnswer((byte) 0);
                }
                ansC.setContent(txtAnsC.getText());
                if (isEditMode) {
                    ansC.setId(selectedAnswers.get(2).getId());
                    answerDao.updateData(ansC);
                } else {
                    ansC.setId(new AnswerId("AA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansC);
                }
                countAns.clear();
                countAns.addAll(answerDao.countAns("AA-"));

                //answer D
//                Answer ansD = new Answer();
                
                ansD.setQuestion(question);
                if (rbD.isSelected()) {
                    ansD.setTrueAnswer((byte) 1);
                } else {
                    ansD.setTrueAnswer((byte) 0);
                }
                ansD.setContent(txtAnsD.getText());
                if (isEditMode) {
                    ansD.setId(selectedAnswers.get(3).getId());
                    answerDao.updateData(ansD);
                } else {
                    ansD.setId(new AnswerId("AA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansD);
                }
                countAns.clear();
                countAns.addAll(answerDao.countAns("AA-"));

                //answer E
//                Answer ansE = new Answer();
                
                ansE.setQuestion(question);
                if (rbE.isSelected()) {
                    ansE.setTrueAnswer((byte) 1);
                } else {
                    ansE.setTrueAnswer((byte) 0);
                }
                ansE.setContent(txtAnsE.getText());
                if (isEditMode) {
                    ansE.setId(selectedAnswers.get(4).getId());
                    answerDao.updateData(ansE);
                } else {
                    ansE.setId(new AnswerId("AA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansE);
                }
                countAns.clear();
                countAns.addAll(answerDao.countAns("AA-"));

                txtPath.clear();
                rbA.setSelected(false);
                rbB.setSelected(false);
                rbC.setSelected(false);
                rbD.setSelected(false);
                rbE.setSelected(false);
                isEditMode = false;
                selectedAnswers.clear();
                break;
                 }
            case 3:
                  if(txtAnsA.getText().isEmpty()||txtAnsB.getText().isEmpty()||txtAnsC.getText().isEmpty()||txtAnsD.getText().isEmpty()||txtAnsE.getText().isEmpty()||txtContent.getText().isEmpty()){
                     Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Field Empty");
            alert.setContentText("Ada yang kurang soal ataupun jawaban");
            alert.initOwner(root.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.showAndWait();
                }
                else{
                 counts.addAll(questionDao.getCount("QI-"));
                contents.addAll(mediacontentDao.getSpecificData(4));
                countAns.addAll(answerDao.countAns("IA-"));
//                Mediacontent mc = new Mediacontent();
//                Media m = new Media();
                m.setId(3);
                m.setMediaType("Image");
                
                mc.setMediaAddress("http://localhost/NetBeans/medias/image/" + txtPath.getText());
                mc.setCaption(htmlEditor.getHtmlText());
                mc.setMedia(m);
                
                if (isEditMode) {
                    mc.setId(selectedQuestion.getMediacontent().getId());
                    mediacontentDao.updateData(mc);
                } else {
                    mc.setId("IMG-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("000" + String.valueOf(contents.size() + 1), 4));
                    mediacontentDao.addData(mc);
                }
                
              
                question.setContent(txtContent.getText());
                question.setUser(this.mainController.getLoginUser());
                question.setCoursedatabase(selectedCourse);
                
                question.setMediacontent(mc);
                
                if (isEditMode) {
                    question.setId(selectedQuestion.getId());
                    questionDao.updateData(question);
                } else {
                    question.setId("QI-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(counts.size() + 1), 5));
                    questionDao.addData(question);
                }
                
                //answer A

//                Answer ansA = new Answer();
                
                ansA.setQuestion(question);
                if (rbA.isSelected()) {
                    ansA.setTrueAnswer((byte) 1);
                } else {
                    ansA.setTrueAnswer((byte) 0);
                }
                ansA.setContent(txtAnsA.getText());
                if (isEditMode) {
                    ansA.setId(selectedAnswers.get(0).getId());
                    answerDao.updateData(ansA);
                    
                } else {
                    ansA.setId(new AnswerId("IA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansA);
                }
                
                countAns.clear();
                countAns.addAll(answerDao.countAns("IA-"));

                //answer B
//                Answer ansB = new Answer();
                
                ansB.setQuestion(question);
                if (rbB.isSelected()) {
                    ansB.setTrueAnswer((byte) 1);
                } else {
                    ansB.setTrueAnswer((byte) 0);
                }
                ansB.setContent(txtAnsB.getText());
                if (isEditMode) {
                    ansB.setId(selectedAnswers.get(1).getId());
                    answerDao.updateData(ansB);
                } else {
                    ansB.setId(new AnswerId("IA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansB);
                }
                countAns.clear();
                countAns.addAll(answerDao.countAns("IA-"));

                //answer C
//                Answer ansC = new Answer();
                
                ansC.setQuestion(question);
                if (rbC.isSelected()) {
                    ansC.setTrueAnswer((byte) 1);
                } else {
                    ansC.setTrueAnswer((byte) 0);
                }
                ansC.setContent(txtAnsC.getText());
                if (isEditMode) {
                    ansC.setId(selectedAnswers.get(2).getId());
                    answerDao.updateData(ansC);
                } else {
                    ansC.setId(new AnswerId("IA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansC);
                }
                countAns.clear();
                countAns.addAll(answerDao.countAns("IA-"));

                //answer D
//                Answer ansD = new Answer();
                
                ansD.setQuestion(question);
                if (rbD.isSelected()) {
                    ansD.setTrueAnswer((byte) 1);
                } else {
                    ansD.setTrueAnswer((byte) 0);
                }
                ansD.setContent(txtAnsD.getText());
                if (isEditMode) {
                    ansD.setId(selectedAnswers.get(3).getId());
                    answerDao.updateData(ansD);
                } else {
                    ansD.setId(new AnswerId("IA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansD);
                }
                countAns.clear();
                countAns.addAll(answerDao.countAns("IA-"));

                //answer E
//                Answer ansE = new Answer();
                
                ansE.setQuestion(question);
                if (rbE.isSelected()) {
                    ansE.setTrueAnswer((byte) 1);
                } else {
                    ansE.setTrueAnswer((byte) 0);
                }
                ansE.setContent(txtAnsE.getText());
                if (isEditMode) {
                    ansE.setId(selectedAnswers.get(4).getId());
                    answerDao.updateData(ansE);
                } else {
                    ansE.setId(new AnswerId("IA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansE);
                }
                countAns.clear();
                countAns.addAll(answerDao.countAns("IA-"));

                txtPath.clear();
                rbA.setSelected(false);
                rbB.setSelected(false);
                rbC.setSelected(false);
                rbD.setSelected(false);
                rbE.setSelected(false);
                isEditMode = false;
                selectedAnswers.clear();
                
                
                
                break;
                  }
            case 1:
                  if(txtAnsA.getText().isEmpty()||txtAnsB.getText().isEmpty()||txtAnsC.getText().isEmpty()||txtAnsD.getText().isEmpty()||txtAnsE.getText().isEmpty()||txtContent.getText().isEmpty()){
                     Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Field Empty");
            alert.setContentText("Ada yang kurang soal ataupun jawaban");
            alert.initOwner(root.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.showAndWait();
                }
                else{
                
                 counts.addAll(questionDao.getCount("QV-"));
                contents.addAll(mediacontentDao.getSpecificData(4));
                countAns.addAll(answerDao.countAns("VA-"));
//                Mediacontent mc = new Mediacontent();
//                Media m = new Media();
                m.setId(1);
                m.setMediaType("Video");
                
                mc.setMediaAddress("http://localhost/NetBeans/medias/image/" + txtPath.getText());
                mc.setCaption(htmlEditor.getHtmlText());
                mc.setMedia(m);
                
                if (isEditMode) {
                    mc.setId(selectedQuestion.getMediacontent().getId());
                    mediacontentDao.updateData(mc);
                } else {
                    mc.setId("VID-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("000" + String.valueOf(contents.size() + 1), 4));
                    mediacontentDao.addData(mc);
                }
                
              
                question.setContent(txtContent.getText());
                question.setUser(this.mainController.getLoginUser());
                question.setCoursedatabase(selectedCourse);
                
                question.setMediacontent(mc);
                
                if (isEditMode) {
                    question.setId(selectedQuestion.getId());
                    questionDao.updateData(question);
                } else {
                    question.setId("QV-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(counts.size() + 1), 5));
                    questionDao.addData(question);
                }
                
                //answer A

//                Answer ansA = new Answer();
                
                ansA.setQuestion(question);
                if (rbA.isSelected()) {
                    ansA.setTrueAnswer((byte) 1);
                } else {
                    ansA.setTrueAnswer((byte) 0);
                }
                ansA.setContent(txtAnsA.getText());
                if (isEditMode) {
                    ansA.setId(selectedAnswers.get(0).getId());
                    answerDao.updateData(ansA);
                    
                } else {
                    ansA.setId(new AnswerId("VA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansA);
                }
                
                countAns.clear();
                countAns.addAll(answerDao.countAns("VA-"));

                //answer B
//                Answer ansB = new Answer();
                
                ansB.setQuestion(question);
                if (rbB.isSelected()) {
                    ansB.setTrueAnswer((byte) 1);
                } else {
                    ansB.setTrueAnswer((byte) 0);
                }
                ansB.setContent(txtAnsB.getText());
                if (isEditMode) {
                    ansB.setId(selectedAnswers.get(1).getId());
                    answerDao.updateData(ansB);
                } else {
                    ansB.setId(new AnswerId("VA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansB);
                }
                countAns.clear();
                countAns.addAll(answerDao.countAns("VA-"));

                //answer C
//                Answer ansC = new Answer();
                
                ansC.setQuestion(question);
                if (rbC.isSelected()) {
                    ansC.setTrueAnswer((byte) 1);
                } else {
                    ansC.setTrueAnswer((byte) 0);
                }
                ansC.setContent(txtAnsC.getText());
                if (isEditMode) {
                    ansC.setId(selectedAnswers.get(2).getId());
                    answerDao.updateData(ansC);
                } else {
                    ansC.setId(new AnswerId("VA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansC);
                }
                countAns.clear();
                countAns.addAll(answerDao.countAns("VA-"));

                //answer D
//                Answer ansD = new Answer();
                
                ansD.setQuestion(question);
                if (rbD.isSelected()) {
                    ansD.setTrueAnswer((byte) 1);
                } else {
                    ansD.setTrueAnswer((byte) 0);
                }
                ansD.setContent(txtAnsD.getText());
                if (isEditMode) {
                    ansD.setId(selectedAnswers.get(3).getId());
                    answerDao.updateData(ansD);
                } else {
                    ansD.setId(new AnswerId("VA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansD);
                }
                countAns.clear();
                countAns.addAll(answerDao.countAns("VA-"));

                //answer E
//                Answer ansE = new Answer();
                
                ansE.setQuestion(question);
                if (rbE.isSelected()) {
                    ansE.setTrueAnswer((byte) 1);
                } else {
                    ansE.setTrueAnswer((byte) 0);
                }
                ansE.setContent(txtAnsE.getText());
                if (isEditMode) {
                    ansE.setId(selectedAnswers.get(4).getId());
                    answerDao.updateData(ansE);
                } else {
                    ansE.setId(new AnswerId("VA-" + format.format(date) + right("0"
                        + String.valueOf(this.mainController.getLoginUser().getInstitute().getId()), 2)
                        + right("0000" + String.valueOf(countAns.size() + 1), 5), question.getId()));
                    answerDao.addData(ansE);
                }
                countAns.clear();
                countAns.addAll(answerDao.countAns("VA-"));

                txtPath.clear();
                rbA.setSelected(false);
                rbB.setSelected(false);
                rbC.setSelected(false);
                rbD.setSelected(false);
                rbE.setSelected(false);
                isEditMode = false;
                selectedAnswers.clear();
                
                break;
                  }
            default:
                break;

        }
        htmlEditor.setHtmlText("");
        txtPath.clear();
        txtContent.clear();
        txtAnsA.clear();
        txtAnsB.clear();
        txtAnsC.clear();
        txtAnsD.clear();
        txtAnsE.clear();
        questions.clear();
        questions.addAll(questionDao.getSpecificData(selectedCourse));
        tblquestions.refresh();
        questionVbox.toFront();

    }

    public static String right(String value, int length) {
        return value.substring(value.length() - length);
    }
    
    private static void copy(File src, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);

            // buffer size 1K
            byte[] buf = new byte[1024];

            int bytesRead;
            while ((bytesRead = is.read(buf)) > 0) {
                os.write(buf, 0, bytesRead);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    @FXML
    private void tblQstClick(MouseEvent event) {
        selectedQuestion = tblquestions.getSelectionModel().getSelectedItem();
    }

    private void setProfileLabelText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
